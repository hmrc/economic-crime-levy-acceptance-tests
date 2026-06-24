lazy val testSuite = (project in file("."))
  .disablePlugins(JUnitXmlReportPlugin)
  .settings(
    name := "economic-crime-levy-acceptance-tests",
    version := "0.1.0",
    scalaVersion := "3.3.7",
    scalacOptions ++= Seq("-feature"),
    libraryDependencies ++= Dependencies.test,
    )
