package $name;format="snake"$.server.world.servlet

import org.http4s._
import org.http4s.servlet._
import $name;format="snake"$.server.world._
import $name;format="snake"$.server.world.service._

import javax.servlet.ServletConfig
import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}

class $name;format="Camel"$ServerServlet(implicit setting: Setting) extends Http4sServlet(
  service = allServices,
  servletIo = NonBlockingServletIo($name;format="Camel"$ServerServlet.DefaultChunkSize),
  serviceErrorHandler = serviceErrorHandler
  )

object $name;format="Camel"$ServerServlet {
  private val DefaultChunkSize = 4096
}

class $name;format="Camel"$ServerServletWrapper extends HttpServlet {
  private var underlying: $name;format="Camel"$ServerServlet = _

  override def init(config: ServletConfig): Unit = {
    underlying = {
      implicit val setting = Setting(
        applicationConfPath = Option(config.getInitParameter("applicationConfPath")),
        logbackConfPath = Option(config.getInitParameter("logbackConfPath"))
      )
      new $name;format="Camel"$ServerServlet
    }
    underlying.init(config)
  }

  override def service(req: HttpServletRequest, resp: HttpServletResponse): Unit =
    underlying.service(req, resp)
}
