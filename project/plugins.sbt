resolvers += Resolver.sonatypeRepo("snapshots")
resolvers += MavenRepository("sonatype-s01-snapshots",
                             "https://s01.oss.sonatype.org/content/repositories/snapshots"
)

addSbtPlugin("org.scalablytyped.converter" % "sbt-converter"  % "1.0.0-beta37+7-58716e34-SNAPSHOT")
addSbtPlugin("edu.gemini"                  % "sbt-lucuma-lib" % "0.6.0")
