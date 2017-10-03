package $name;format="snake"$.server


/**
  * exception package object
  * @template_author bigknife<bigknife@outlook.com>
  */
package object exception {
  sealed abstract class $name;format="Camel"$Exception(msg: String, cause: Option[Throwable] = None) extends RuntimeException(msg, cause.orNull)

  // all the biz exception should declared here

}

