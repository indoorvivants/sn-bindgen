import scala.scalanative.unsafe.*
import scalanative.unsigned.*

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

  Zone { implicit z =>

    val WHITE = Color(255.toUByte, 255.toUByte, 255.toUByte, 255.toUByte)
    val RED = Color(255.toUByte, 0.toUByte, 0.toUByte, 255.toUByte)
    val BLACK = Color(0.toUByte, 0.toUByte, 0.toUByte, 255.toUByte)

    val ballPosition = Vector2(screenWidth / 2, screenHeight / 2)

    SetTargetFPS(120)

    var i = 0

    while WindowShouldClose() == 0 do

      !ballPosition = GetMousePosition()
      BeginDrawing()

      ClearBackground(!WHITE)
      DrawText(
        c"move ball with mouse",
        10,
        10,
        20,
        !BLACK
      )
      DrawCircleV(!ballPosition, 50, !RED)
      EndDrawing()
    end while
    CloseWindow()
  }
end hello_raylib
