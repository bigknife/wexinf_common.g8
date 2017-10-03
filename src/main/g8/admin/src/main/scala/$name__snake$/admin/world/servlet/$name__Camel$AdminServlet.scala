package $name;format="snake"$.admin.world.servlet

import org.http4s._
import org.http4s.servlet._
import $name;format="snake"$.admin.world.service._

class $name;format="Camel"$AdminServlet extends Http4sServlet(
  service = allServices,
  serviceErrorHandler = serviceErrorHandler
) 
