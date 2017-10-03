package $name;format="snake"$.admin.world.blazer

import org.http4s._
import org.http4s.dsl._
import org.http4s.server._
import org.http4s.util._
import org.http4s.server.blaze._

import fs2._

import $name;format="snake"$.admin.world.service._

object $name;format="Camel"$BlazerAdmin extends StreamApp {
  override def stream(args: List[String]): Stream[Task, Nothing] = {
    BlazeBuilder
      .bindHttp(8081, "localhost")
      .mountService(allServices)
      .withServiceErrorHandler(serviceErrorHandler)
      .serve
  }
}