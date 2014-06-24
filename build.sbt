
sbtPlugin := true

name := "sbt-satisfy"

scalaVersion := "2.10.2"

organization := "com.tagged.satisfaction"

version := "0.3"

val hadoopVersion = "2.3.0"

libraryDependencies ++= Seq(
  ("org.apache.hadoop" % "hadoop-common" % hadoopVersion),
  ("org.apache.hadoop" % "hadoop-hdfs" % hadoopVersion)
)

publishMavenStyle := true

isSnapshot := true

///publishTo := Some("tagged-artifactory-release" at "http://artifactory.tagged.com:8081/artifactory/libs-release-local")
///publishTo := Some(  Resolver.url("tagged-artifactory-release") artifacts "http://artifactory.tagged.com:8081/artifactory/libs-release-local/[orgPath]/[module]_[scalaVersion]_[sbtVersion]/[revision]/[module]_[scalaVersion]_[sbtVersion]_[revision].[ext]"  )
publishTo := Some(  Resolver.url("tagged-artifactory-release") artifacts "http://artifactory.tagged.com:8081/artifactory/libs-release-local/[orgPath]/[module]/[revision]/[module]_[revision].[ext]"  )

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

