package bindgen

import scala.util.boundary, boundary.break, boundary.Label

extension [A, B](e: Either[BindingError, A])
  def ?(using Label[Either[BindingError, B]]): A =
    e match
      case Left(value)  => break(Left(value))
      case Right(value) => value
