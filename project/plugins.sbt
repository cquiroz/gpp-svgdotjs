resolvers += MavenRepository("sonatype-s01-snapshots",
                             "https://s01.oss.sonatype.org/content/repositories/snapshots"
)

val sbtLucumaVersion = "0.8.4"
addSbtPlugin("org.scalablytyped.converter" % "sbt-converter"          % "1.0.0-beta37+42-35921de2-SNAPSHOT")
addSbtPlugin("edu.gemini"                  % "sbt-lucuma-lib"         % sbtLucumaVersion)
addSbtPlugin("edu.gemini"                  % "sbt-lucuma-sjs-bundler" % sbtLucumaVersion)
