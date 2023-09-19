package models

import play.api.libs.json.{Json, OFormat}

case class GoogleBook(
                       url: String,
                       term: String,
                       search: String
                     )

object GoogleBook {
  implicit val formats: OFormat[GoogleBook] = Json.format[GoogleBook]

}