package example.infrastructure

import example.doamin.{Id, Project}
import scalikejdbc._

object ProjectDto extends SQLSyntaxSupport[Project] {

  override def tableName = "projects"

  def apply(rs: WrappedResultSet, rn: ResultName[Project]): Project = autoConstruct(rs, rn)

  def attach(rs: WrappedResultSet): Project = {
    Project(
      id = Id(rs.long("id")),
      name = rs.string("name"),
      description = Option(rs.string("description"))
    )
  }
}
