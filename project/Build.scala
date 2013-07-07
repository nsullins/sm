import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "sm"
  val appVersion      = "1.0-SNAPSHOT"

  val mandubianRepo = Seq(
    "Mandubian repository snapshots" at "https://github.com/mandubian/mandubian-mvn/raw/master/snapshots/",
    "Mandubian repository releases" at "https://github.com/mandubian/mandubian-mvn/raw/master/releases/"
  )
  val appDependencies = Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.9",
  "org.specs2" %% "specs2" % "1.14",
  "play"              %% "play-json"           % "2.2-SNAPSHOT",
  "play-json-zipper"  %% "play-json-zipper"    % "0.1-SNAPSHOT"
  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here
    resolvers ++= mandubianRepo
  )

}
