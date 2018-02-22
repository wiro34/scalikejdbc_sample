package example.infrastructure

import example.doamin.{Id, Project}
import example.domain.ProjectRepository
import scalikejdbc._

import scala.util.Try

object ProjectRepositoryImpl extends ProjectRepository[DBSession] {

  import IdDto._

  val p = ProjectDto.syntax("p")

  def find(id: Id[Project])(implicit s: DBSession = ReadOnlyAutoSession): Try[Option[Project]] = Try {
    withSQL {
      select.from(ProjectDto as p).where.eq(p.id, id)
    }.map(ProjectDto.attach _).single.apply()
  }
}
