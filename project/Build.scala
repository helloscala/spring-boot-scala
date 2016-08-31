import sbt.Keys._
import sbt._

object Build extends Build {

  val verScala = "2.11.8"

  val verSpringBoot = "1.4.0.RELEASE"
  val _springBootStarterTest = "org.springframework.boot" % "spring-boot-starter-test" % verSpringBoot
  val _springBootStarterWeb = "org.springframework.boot" % "spring-boot-starter-web" % verSpringBoot
  val _springBootStarterActuator = "org.springframework.boot" % "spring-boot-starter-actuator" % verSpringBoot
  val _springBootStarterMail = "org.springframework.boot" % "spring-boot-starter-mail" % verSpringBoot

  val _jacksonModuleScala = "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.0.rc2"

  def basicSettings = Seq(
    description := "Spring boot scala",
    version := "version",
    homepage := Some(new URL("https://github.com/helloscala/spring-boot-scala")),
    organization := "com.helloscala",
    organizationHomepage := Some(new URL("http://www.helloscala.com")),
    startYear := Some(2016),
    scalaVersion := verScala,
    scalacOptions ++= Seq(
      "-encoding", "utf8",
      "-unchecked",
      "-feature",
      "-deprecation"
    ),
    javacOptions ++= Seq(
      "-source", "1.8",
      "-target", "1.8",
      "-encoding", "utf8",
      "-Xlint:unchecked",
      "-Xlint:deprecation"
    ),
    offline := true,
    libraryDependencies ++= Seq(
      _jacksonModuleScala,
      _springBootStarterWeb,
      _springBootStarterActuator,
      _springBootStarterTest % "test")
  )

  override lazy val settings = super.settings :+ {
    shellPrompt := (s => Project.extract(s).currentProject.id + " > ")
  }

  lazy val parent = Project("spring-boot-scala", file("."))
    .aggregate(web)

  lazy val web = Project("web", file("web"))
    .dependsOn(common)
    .settings(basicSettings: _*)

  lazy val common = Project("common", file("common"))
    .settings(basicSettings: _*)
    .settings(
      libraryDependencies += _springBootStarterMail
    )

}

