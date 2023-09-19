package controllers

import baseSpec.BaseSpecWithApplication
import models._
import play.api.test.FakeRequest
import play.api.http.Status
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.Result
import play.api.test.Helpers._

import scala.concurrent.Future

class ApplicationControllerSpec extends BaseSpecWithApplication {

  val TestApplicationController = new ApplicationController(
    component, repository
  )

  private val dataModel = DataModel(
    _id = "abcd",
    name = "test name",
    description = "test description",
    numSales = 100
  )

  "ApplicationController .index()" should {
    val result = TestApplicationController.index()(FakeRequest())

    "return TODO" in {
      status(result) shouldBe Status.OK
    }
  }

  "ApplicationController .create" should {
    beforeEach()
    "create a book in the database" in {

      val request: FakeRequest[JsValue] = buildPost("/api").withBody[JsValue](Json.toJson(dataModel))
      val createdResult: Future[Result] = TestApplicationController.create()(request)

      status(createdResult) shouldBe Status.CREATED

    }

    "Read a book with invalid json return Bad Request" in {
      val request = buildGet("/api/create").withBody[JsValue](Json.parse(
        """
          |{
          |"name": "My Name"
          |}
          |""".stripMargin))
      val createdResult = TestApplicationController.create()(request)
      status(createdResult) shouldBe BAD_REQUEST

    }
    afterEach()
  }

  "ApplicationController .read" should {

    "find a book in the database by id" in {
      beforeEach()
      val request: FakeRequest[JsValue] = buildPost(s"/api/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))
      val createdResult: Future[Result] = TestApplicationController.create()(request)

      status(createdResult) shouldBe Status.CREATED
      val readResult: Result = await(TestApplicationController.read("abcd")(FakeRequest()))

      readResult.header.status shouldBe ACCEPTED
      afterEach()
    }

  }

  "ApplicationController .update" should {
    beforeEach()
    "Update a book in the database by id" in {
      val request: FakeRequest[JsValue] = buildPut(s"/api/update/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))
      val createdResult = TestApplicationController.create()(request)
      status(createdResult) shouldBe Status.CREATED
      val dModel = DataModel(_id = "efgh", name = "test name 2", description = "test description 2", numSales = 200)
      val updateRequest = buildPut(s"/api/update/${dataModel._id}").withBody[JsValue](Json.toJson(dModel))
      val readResult = TestApplicationController.update("efgh")(updateRequest)
      status(readResult) shouldBe ACCEPTED
    }

    "Update a book with invalid json body return Bad Request" in {
      val request = buildPut(s"/api/update/${dataModel._id}").withBody[JsValue](Json.parse(
        """
          |{
          |"name": "My Name"
          |}
          |""".stripMargin))
      val createdResult = TestApplicationController.update("Hello")(request)
      status(createdResult) shouldBe BAD_REQUEST

    }
    afterEach()
  }

  "ApplicationController .delete" should {
    beforeEach()
    "Delete a book in the database by id" in {

      val request = buildDelete(s"/api/delete/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))
      TestApplicationController.create()(request)
      val readResult = TestApplicationController.delete("efgh")(FakeRequest())
      status(readResult) shouldBe ACCEPTED

    }
    afterEach()
  }

  "test name" should {
    "do something" in {
      beforeEach
      afterEach
    }
  }

  override def beforeEach(): Unit = repository.deleteAll()

  override def afterEach(): Unit = repository.deleteAll()

}
