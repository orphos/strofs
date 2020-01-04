import sbt._
import Keys._

scalaVersion in ThisBuild := "2.13.1"
conflictWarning in ThisBuild := ConflictWarning("global", Level.Error, failOnConflict = true)

scalacOptions in ThisBuild ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-Xlint",
)

scalafmtOnCompile in ThisBuild := true

javaOptions in Test ++= Seq(
  "-Xms1g",
  "-Xmx4g"
)

fork := true

libraryDependencies in ThisBuild ++= Seq(
 "com.backblaze.b2" % "b2-sdk-core" % "3.1.0",
 "com.backblaze.b2" % "b2-sdk-httpclient" % "3.1.0",
 "software.amazon.awssdk" % "s3" % "2.10.41",
  "org.xerial" % "sqlite-jdbc" % "3.30.1",
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2"
)
libraryDependencies in ThisBuild ++= Seq(
  "org.scalatest" %% "scalatest" % "3.1.0",
).map(_ % Test)

lazy val root = Project(id = "strofs", base = file("."))

