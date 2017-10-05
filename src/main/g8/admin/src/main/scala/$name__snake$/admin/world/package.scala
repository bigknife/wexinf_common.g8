package $name;format="snake"$.admin

import com.typesafe.config._

package object world {
case class Setting(
    applicationConfPath: Option[String] = None,
    logbackConfPath: Option[String] = None
  ) {
    lazy val config: Config = {
      val inner = ConfigFactory.load()
      applicationConfPath match {
        case Some(p) =>
          val outter = ConfigFactory.parseFile(new java.io.File(p))
          outter.resolve()
          outter.withFallback(inner)
        case None => inner
      }
    }
  }

  object Setting {
    val unit: Setting = Setting()
  }
}

