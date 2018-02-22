package example.doamin

case class Project(id: Id[Project],
                   name: String,
                   description: Option[String])
