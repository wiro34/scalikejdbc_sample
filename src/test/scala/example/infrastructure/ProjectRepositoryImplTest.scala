package example.infrastructure

import example.doamin.Id
import org.scalatest.{BeforeAndAfter, fixture}
import org.scalatest.OptionValues._
import org.scalatest.TryValues._
import scalikejdbc._
import scalikejdbc.config.DBs
import scalikejdbc.scalatest.AutoRollback

class ProjectRepositoryImplTest extends fixture.FlatSpec with AutoRollback with BeforeAndAfter {

  before {
    DBs.setupAll()
  }

  override def fixture(implicit session: DBSession): Unit = {
    sql"""
      create table projects (
        id      bigint auto_increment,
        name    varchar(16) not null,
        description varchar(128) not null,
        created_at timestamp,
        updated_at timestamp,

        primary key(id),
        unique(name asc)
      )
    """.execute.apply()
    sql"insert into projects (id, name, description) values (1, 'foo', 'it is foo')".update.apply()
  }

  it should "test" in { implicit s =>
    val result = ProjectRepositoryImpl.find(Id(1))
    println(result)
    val project = result.success.value.value
    assert(project.name == "foo")
  }
}
