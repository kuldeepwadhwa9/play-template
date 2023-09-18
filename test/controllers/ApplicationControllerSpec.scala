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
    "abcd",
    "test name",
    "test description",
    100
  )

  "ApplicationController .index()" should {
    val result = TestApplicationController.index()(FakeRequest())

    "return TODO" in {
      status(result) shouldBe Status.OK
    }
  }

  "ApplicationController .create()" should {
    val result = TestApplicationController.create()(FakeRequest())

    "return TODO" in {
      status(result) shouldBe Status.OK
    }
  }

  "ApplicationController .read()" should {
    val result = TestApplicationController.read("Hello")(FakeRequest())

    "return TODO" in {
      status(result) shouldBe Status.OK
    }
  }

  "ApplicationController .update()" should {
    val result = TestApplicationController.update("Hello")(FakeRequest())

    "return TODO" in {
      status(result) shouldBe Status.OK
    }
  }

  "ApplicationController .delete()" should {
    val result = TestApplicationController.delete("Hello")(FakeRequest())

    "return TODO" in {
      status(result) shouldBe Status.OK
    }
  }

  "ApplicationController .create" should {

    "create a book in the database" in {
      beforeEach()
      val request: FakeRequest[JsValue] = buildPost("/api").withBody[JsValue](Json.toJson(dataModel))
      val createdResult: Future[Result] = TestApplicationController.create()(request)

      status(createdResult) shouldBe Status.BAD_REQUEST
      afterEach()
    }
  }

  "ApplicationController .read" should {

    "find a book in the database by id" in {
      beforeEach()
      val request: FakeRequest[JsValue] = buildGet(s"/api/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))
      val createdResult: Future[Result] = TestApplicationController.create()(request)

      //Hint: You could use status(createdResult) shouldBe Status.CREATED to check this has worked again

      val readResult: Future[Result] = TestApplicationController.read("abcd")(FakeRequest())

      status(readResult) shouldBe ACCEPTED
      afterEach()
    }


    "Read a book with invalid json return Bad Request" in {
      beforeEach()
      val request = buildGet("/api/create").withBody[JsValue](Json.toJson(dataModel))
      val createdResult = TestApplicationController.create()(request)
      val readResult = TestApplicationController.read("aldd")(FakeRequest())
      status(readResult) shouldBe BAD_REQUEST
      afterEach()
    }
  }

  "ApplicationController .create" should {
    "Create a book in the database by id" in {
      beforeEach()
      val request: FakeRequest[JsValue] = buildPost(s"/api/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))

      //Hint: You could use status(createdResult) shouldBe Status.CREATED to check this has worked again

      val readResult: Future[Result] = TestApplicationController.create()(request)

      status(readResult) shouldBe CREATED
      contentAsJson(readResult).as[DataModel] shouldBe dataModel
      afterEach()
    }

  }

  "ApplicationController .update" should {
    "Update a book in the database by id" in {
      beforeEach()
      val request = buildPut(s"/api/update/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))
    TestApplicationController.create()(request)
      val readResult = TestApplicationController.update("efgh")(FakeRequest())
      status(readResult) shouldBe ACCEPTED

      afterEach()
    }
  }

  "ApplicationController .delete" should {
    "Delete a book in the database by id" in {
      beforeEach()
      val request = buildDelete(s"/api/delete/${dataModel._id}").withBody[JsValue](Json.toJson(dataModel))
      TestApplicationController.create()(request)
      val readResult = TestApplicationController.update("efgh")(FakeRequest())
      status(readResult) shouldBe ACCEPTED

      afterEach()
    }
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
