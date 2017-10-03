package $name;format="snake"$.server.world.blazer

import org.http4s._
import org.http4s.dsl._
import org.http4s.server._
import org.http4s.util._
import org.http4s.server.blaze._

import fs2._

import $name;format="snake"$.server.world.service._

object $name;format="Camel"$BlazerServer extends StreamApp {
  override def stream(args: List[String]): Stream[Task, Nothing] = {
    BlazeBuilder
      .bindHttp(8080, "localhost")
      .mountService(allServices)
      .withServiceErrorHandler(serviceErrorHandler)
      .serve
  }
}