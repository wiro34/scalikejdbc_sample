package example.infrastructure

import java.sql.ResultSet

import example.doamin.{Id, Project}
import scalikejdbc.{ParameterBinderFactory, TypeBinder}

object IdDto {

  implicit val idParameterBinder: ParameterBinderFactory[Id[Project]] = ParameterBinderFactory[Id[Project]] {
    value => (stmt, idx) => stmt.setLong(idx, value.value)
  }

  implicit val idTypeBinder: TypeBinder[Id[Project]] = new TypeBinder[Id[Project]] {
    def apply(rs: ResultSet, label: String): Id[Project] = Id(rs.getLong(label))
    def apply(rs: ResultSet, index: Int): Id[Project] = Id(rs.getLong(index))
  }

}
