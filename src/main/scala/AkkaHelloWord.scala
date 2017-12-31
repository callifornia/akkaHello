import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer


object AkkaHelloWord {

  def main(Args: Array[String]): Unit = {

    implicit val actorSystem = ActorSystem("awesomeSystem")
    implicit val materialize = ActorMaterializer()
    implicit val executionContext = actorSystem.dispatcher


    val routes = path("hello"){
      get{
        complete("Hi there !!! =)")
      }
    }
    Http().bindAndHandle(routes, "0.0.0.0", 8080)
  }
}