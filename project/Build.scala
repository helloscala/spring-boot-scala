import sbt.Keys._
import sbt._

object Build extends Build {

  override lazy val settings = super.settings :+ {
    shellPrompt := (s => Project.extract(s).currentProject.id + " > ")
  }

  lazy val root = Project("springscala", file("."))
    .settings(
      description := "Spring boot scala",
      version := "0.0.1",
      homepage := Some(new URL("https://github.com/yangbajing/spring-boot-scala")),
      organization := "me.yangbajing",
      organizationHomepage := Some(new URL("http://www.yangbajing.me")),
      startYear := Some(2016),
      scalaVersion := "2.11.7",
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
        _springBootStarterWeb,
        _springBootStarterTest))

  val verSpringBoot = "1.3.3.RELEASE"
  val _springBootStarterWeb = "org.springframework.boot" % "spring-boot-starter-web" % verSpringBoot
  val _springBootStarterTest = "org.springframework.boot" % "spring-boot-starter-test" % verSpringBoot

}

