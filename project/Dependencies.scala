import sbt._

object Dependencies {
  lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"

  lazy val scalikejdbc = Seq(
    "org.scalikejdbc" %% "scalikejdbc"       % "3.2.1",
    "org.scalikejdbc" %% "scalikejdbc-test"   % "3.2.1"   % "test",
    "org.scalikejdbc" %% "scalikejdbc-config"  % "3.2.1",
    "org.scalikejdbc" %% "scalikejdbc-syntax-support-macro" % "3.2.1",
    "com.h2database"  %  "h2"                % "1.4.196"
  )
}
