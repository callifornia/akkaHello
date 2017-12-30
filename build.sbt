name := "akkaHello"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"   % "10.1.0-RC1",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.11" % Test,
"com.typesafe.akka" %% "akka-stream" % "2.5.8")