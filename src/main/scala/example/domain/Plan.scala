package example.doamin

case class Plan(id: Id[Plan],
                projectId: Id[Project],
                name: String,
                description: Option[String])
