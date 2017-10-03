package $name;format="snake"$.server.world.servlet

import org.http4s._
import org.http4s.servlet._
import $name;format="snake"$.server.world.service._

class $name;format="Camel"$ServerServlet extends Http4sServlet(
  service = allServices,
  serviceErrorHandler = serviceErrorHandler
) 
