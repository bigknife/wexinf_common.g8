package $name;format="snake"$.server.world.service


import org.http4s._
import org.http4s.dsl._
import org.http4s.circe._

import io.circe._
import io.circe.generic.auto._
import io.circe.generic._
import io.circe.syntax._

import $name;format="snake"$.server.world.protocol._

trait OrderResource {
  val orderService = HttpService {
    case req @ POST -> Root / "order" => 
      for {
        order <- req.as(jsonOf[Order])
        x <- Ok(order.asJson)
  	  } yield x
  }
}

object OrderResource extends OrderResource