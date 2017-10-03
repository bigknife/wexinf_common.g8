package $name;format="snake"$.server.world

import org.http4s._
import org.http4s.dsl._
import org.http4s.server._

import cats.implicits._


package object service {

  val healthCheckService = HttpService {
    case GET -> Root / "_healthcheck" => Ok("ok")
  }

  val allServices = healthCheckService |+| OrderResource.orderService

  val serviceErrorHandler: ServiceErrorHandler = req => {
    case x: Throwable =>
      x.printStackTrace
      DefaultServiceErrorHandler(req).apply(x)
  }
}
