import scala.scalanative.unsafe.*

@main def hello_cjson =
  import libcjson.functions.*
  import libcjson.types.*

  val js = cJSON_Parse(c"""{"hello": 25}""")

  val before = fromCString(cJSON_Print(js))
  cJSON_ReplaceItemInObjectCaseSensitive(
    js,
    c"hello",
    cJSON_CreateFalse()
  )
  val after = fromCString(cJSON_Print(js))
  println(s"Before: $before, after: $after")

end hello_cjson

@main def hello_raylib =
  val screenWidth = 800
  val screenHeight = 450
  import libraylib.functions.*
  import libraylib.types.*

  InitWindow(
    screenWidth,
    screenHeight,
    c"hello raylib from Scala Native"
  )

  SetTargetFPS(1)
  while WindowShouldClose() == 0 do
    BeginDrawing();
    EndDrawing()
  CloseWindow()
end hello_raylib
