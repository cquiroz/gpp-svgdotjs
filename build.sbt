/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

Global / onChangedBuildSource := ReloadOnSourceChanges

inThisBuild(
  Seq(
    homepage                      := Some(url("https://github.com/gemini-hlsw/lucuma-svgdotjs")),
    Global / onChangedBuildSource := ReloadOnSourceChanges
  ) ++ lucumaPublishSettings
)

lazy val root = project
  .in(file("."))
  .settings(name := "lucuma-svgdotjs")
  .settings(
    crossScalaVersions      := Seq("2.13.7", "3.1.0"),
    // shade into another package
    stOutputPackage         := "lucuma.svgdotjs",
    /* javascript / typescript deps */
    Compile / npmDependencies ++= Seq(
      "@svgdotjs/svg.js" -> "3.0.16"
    ),
    /* disabled because it somehow triggers many warnings */
    scalaJSLinkerConfig ~= (_.withSourceMap(false)),
    // because npm is slow
    useYarn                 := true,
    stSourceGenMode         := SourceGenMode.ResourceGenerator,
    stUseScalaJsDom         := true,
    scalacOptions ~= (_.filterNot(
      Set(
        // By necessity facades will have unused params
        "-Wdead-code",
        "-Wunused:params",
        "-Wunused:imports",
        "-Wunused:explicits"
      )
    )),
    Compile / doc / sources := Seq(),
    // focus only on these libraries
    stMinimize              := Selection.AllExcept("@svgdotjs/svg.js")
    // stMinimize := Selection.All,
    // stMinimizeKeep ++= List("svgdotjsSvgJs.mod.Element")
  )
  .settings(lucumaScalaJsSettings: _*)
  .enablePlugins(ScalablyTypedConverterGenSourcePlugin)
