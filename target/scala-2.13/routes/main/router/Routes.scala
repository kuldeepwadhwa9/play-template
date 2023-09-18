// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:2
  HomeController_0: controllers.HomeController,
  // @LINE:5
  Assets_1: controllers.Assets,
  // @LINE:7
  ApplicationController_2: controllers.ApplicationController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:2
    HomeController_0: controllers.HomeController,
    // @LINE:5
    Assets_1: controllers.Assets,
    // @LINE:7
    ApplicationController_2: controllers.ApplicationController
  ) = this(errorHandler, HomeController_0, Assets_1, ApplicationController_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, ApplicationController_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api""", """controllers.ApplicationController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/read/""" + "$" + """id<[^/]+>""", """controllers.ApplicationController.read(id:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/create""", """controllers.ApplicationController.create"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/update/""" + "$" + """id<[^/]+>""", """controllers.ApplicationController.update(id:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/delete/""" + "$" + """id<[^/]+>""", """controllers.ApplicationController.delete(id:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:2
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_Assets_versioned1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned1_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_ApplicationController_index2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api")))
  )
  private[this] lazy val controllers_ApplicationController_index2_invoker = createInvoker(
    ApplicationController_2.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "index",
      Nil,
      "GET",
      this.prefix + """api""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_ApplicationController_read3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/read/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApplicationController_read3_invoker = createInvoker(
    ApplicationController_2.read(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "read",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/read/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_ApplicationController_create4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/create")))
  )
  private[this] lazy val controllers_ApplicationController_create4_invoker = createInvoker(
    ApplicationController_2.create,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "create",
      Nil,
      "POST",
      this.prefix + """api/create""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_ApplicationController_update5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/update/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApplicationController_update5_invoker = createInvoker(
    ApplicationController_2.update(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "update",
      Seq(classOf[String]),
      "PUT",
      this.prefix + """api/update/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_ApplicationController_delete6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/delete/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_ApplicationController_delete6_invoker = createInvoker(
    ApplicationController_2.delete(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.ApplicationController",
      "delete",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """api/delete/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:2
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:5
    case controllers_Assets_versioned1_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned1_invoker.call(Assets_1.versioned(path, file))
      }
  
    // @LINE:7
    case controllers_ApplicationController_index2_route(params@_) =>
      call { 
        controllers_ApplicationController_index2_invoker.call(ApplicationController_2.index)
      }
  
    // @LINE:8
    case controllers_ApplicationController_read3_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ApplicationController_read3_invoker.call(ApplicationController_2.read(id))
      }
  
    // @LINE:11
    case controllers_ApplicationController_create4_route(params@_) =>
      call { 
        controllers_ApplicationController_create4_invoker.call(ApplicationController_2.create)
      }
  
    // @LINE:13
    case controllers_ApplicationController_update5_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ApplicationController_update5_invoker.call(ApplicationController_2.update(id))
      }
  
    // @LINE:15
    case controllers_ApplicationController_delete6_route(params@_) =>
      call(params.fromPath[String]("id", None)) { (id) =>
        controllers_ApplicationController_delete6_invoker.call(ApplicationController_2.delete(id))
      }
  }
}
