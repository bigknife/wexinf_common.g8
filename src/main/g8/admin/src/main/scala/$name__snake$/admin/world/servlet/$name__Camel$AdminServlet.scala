package $name;format="snake"$.admin.world.servlet

import org.http4s._
import org.http4s.servlet._
import $name;format="snake"$.admin.world._
import $name;format="snake"$.admin.world.service._


import javax.servlet.ServletConfig
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class $name;format="Camel"$AdminServlet(implicit setting: Setting) extends Http4sServlet(
  service = allServices,
  servletIo = NonBlockingServletIo($name;format="Camel"$AdminServlet.DefaultChunkSize),
  serviceErrorHandler = serviceErrorHandler
)

object $name;format="Camel"$AdminServlet {
  private val DefaultChunkSize = 4096
}

class $name;format="Camel"$AdminServletWrapper extends HttpServlet {
  private var underlying: $name;format="Camel"$AdminServlet = _

  override def init(config: ServletConfig): Unit = {
    underlying = {
      implicit val setting = Setting(
        applicationConfPath = Option(config.getInitParameter("applicationConfPath")),
        logbackConfPath = Option(config.getInitParameter("logbackConfPath"))
      )
      new $name;format="Camel"$AdminServlet
    }
    underlying.init(config)
  }

  override def service(req: HttpServletRequest, resp: HttpServletResponse): Unit =
    underlying.service(req, resp)
}
