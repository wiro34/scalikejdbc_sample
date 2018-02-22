package example.domain

import example.doamin.{Id, Project}

import scala.util.Try

trait ProjectRepository[Env] {
  def find(id: Id[Project])(implicit env: Env): Try[Option[Project]]
}
