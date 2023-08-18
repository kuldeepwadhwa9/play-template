// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/kuldeep.wadhwa/Documents/Scala/play-template/conf/routes
// @DATE:Fri Aug 18 13:06:47 BST 2023


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
