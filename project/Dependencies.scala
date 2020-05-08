import sbt._
import Keys._

object Dependencies {
  val Versions = Seq(
    // estryker, test reverting to scala 2.11.12 crossScalaVersions := Seq("2.12.8", "2.11.12"),
    crossScalaVersions := Seq("2.11.12"),
    scalaVersion := crossScalaVersions.value.head
  )

  object Compile {
    val breeze_natives = "org.scalanlp" %% "breeze-natives" % "0.13.2" % "provided"

    object Test {
      val scalatest = "org.scalatest" %% "scalatest" % "3.1.0" % "test"
      val sparktest = "org.apache.spark" %% "spark-core" % "2.4.4"  % "test" classifier "tests"
    }
  }

  import Compile._
  import Test._
  val l = libraryDependencies

  val core = l ++= Seq(scalatest, sparktest)
  val examples = core +: (l ++= Seq(breeze_natives))
}
