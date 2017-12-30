import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import scala.io.StdIn
import akka.http.scaladsl.server.{RouteResult}


object AkkaHelloWord {

  def main(Args: Array[String]): Unit = {
    implicit val actorSystem = ActorSystem("awesomeSystem")
    implicit val materialize = ActorMaterializer()
    implicit val executionContext = actorSystem.dispatcher


    val routes = Routes.getRoutes
    val bindingFuture = Http().bindAndHandle(routes, "localhost", 8080)
    StdIn.readLine()
    bindingFuture
      .flatMap(_.unbind())
      .onComplete(_ => actorSystem.terminate())
  }
}

object Routes {
  def getRoutes(implicit
                materializer: ActorMaterializer,
                actorSystem: ActorSystem) = {

    val route = pathSingleSlash {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka http</h1>"))
      }
    }
    RouteResult.route2HandlerFlow(route)
  }
}
