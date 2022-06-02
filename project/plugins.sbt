resolvers += MavenRepository("sonatype-s01-snapshots",
                             "https://s01.oss.sonatype.org/content/repositories/snapshots"
)

val sbtLucumaVersion = "0.7.0"
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter"          % "1.0.0-beta37+34-8922c488-SNAPSHOT")
addSbtPlugin("edu.gemini"                  % "sbt-lucuma-lib"         % sbtLucumaVersion)
addSbtPlugin("edu.gemini"                  % "sbt-lucuma-sjs-bundler" % sbtLucumaVersion)
