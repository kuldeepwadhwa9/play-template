package controllers

import models.{DataModel, GoogleBook}
import models.APIError._
import play.api.libs.json.{JsError, JsSuccess, JsValue, Json}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import repositories.DataRepository
import services.LibraryService

import javax.inject.{Inject, Singleton}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ApplicationController @Inject()(val controllerComponents: ControllerComponents, val dataRepository: DataRepository, val service: LibraryService)
                                     (implicit val ec: ExecutionContext) extends BaseController {

  def index(): Action[AnyContent] = Action.async { implicit request =>
    dataRepository.index().map {
      case Right(item: Seq[DataModel]) => Ok {
        Json.toJson(item)
      }
      case Left(error) => Status(error)(Json.toJson("Unable to find any books"))
    }
  }

  def create(): Action[JsValue] = Action.async(parse.json) { implicit request =>
    request.body.validate[DataModel] match {
      case JsSuccess(dataModel, _) =>
        dataRepository.create(dataModel).map(_ => Created)
      case JsError(_) => Future(BadRequest)
    }
  }

  def read(id: String) = Action.async { _ =>
    dataRepository.read(id).map(_ => Accepted)
  }

  def update(id: String) = Action.async(parse.json) { implicit request =>
    request.body.validate[DataModel] match {
      case JsSuccess(dataModel, _) =>
        dataRepository.update(id, dataModel).map(_ => Accepted)
      case JsError(_) => Future(BadRequest)
    }
  }

  def delete(id: String) = Action.async { _ =>
    dataRepository.delete(id).map(_ => Accepted)
  }

  def getGoogleBook(search: String, term: String): Action[AnyContent] = Action.async { implicit request =>
    service.getGoogleBook(search = search, term = term).map {
      book =>
        Ok {
          Json.toJson(book)
        }
    }
  }

}
