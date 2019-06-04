name := "connecting_slick_with_psql"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.4",
  "com.typesafe.slick" %% "slick" % "3.3.0",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.0",
  "org.postgresql" % "postgresql" % "42.2.5",
  "org.slf4j" % "slf4j-nop" % "1.6.4"
)