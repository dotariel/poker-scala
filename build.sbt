lazy val commonSettings = Seq(
  organization := "com.ipcoop.vps",
  version := "0.1.0",
  scalaVersion := "2.11.4"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "poker_scala",
    libraryDependencies += "org.scalatest" % "scalatest_2.11" % "3.0.0-SNAP4",
    libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.2" % "test"
  )