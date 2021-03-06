import Dependencies._

ThisBuild / scalaVersion     := "2.12.11"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "json4s-deser-examples",
    libraryDependencies ++= Seq(
           scalaTest % Test,
           "org.json4s" %% "json4s-native" % "3.6.8"
    )

  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
