package example.doamin

final case class Id[T](value: Long) extends AnyVal

object Id {
  def Zero[T]: Id[T] = Id(0)
}
