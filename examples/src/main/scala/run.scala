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

@main def hello_curl =
  import libcurl.functions.*
  import libcurl.types.*

  Zone { implicit z =>

    val curl = curl_easy_init()
    if curl != null then
      Curl_vsetopt(
        curl,
        CURLoption.CURLOPT_URL,
        toCVarArgList(c"http://google.com")
      )
      val res: CURLcode = curl_easy_perform(curl)
      curl_easy_cleanup(curl)
      println(res)
    end if
  }
end hello_curl

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
    val BLUE = Color(0.toUByte, 0.toUByte, 255.toUByte, 255.toUByte)
    val BLACK = Color(0.toUByte, 0.toUByte, 0.toUByte, 255.toUByte)

    val redBallPosition = Vector2(screenWidth / 2, screenHeight / 2)
    val blueBallPositionPtr = Vector2(0, 0)
    val blueBallPosition = !blueBallPositionPtr

    SetTargetFPS(200)

    var i = 0

    while !WindowShouldClose() do

      !redBallPosition = GetMousePosition()
      BeginDrawing()

      import KeyboardKey.*

      if IsKeyDown(KEY_RIGHT.int) then blueBallPosition.x += 2.0f;
      if IsKeyDown(KEY_LEFT.int) then blueBallPosition.x -= 2.0f;
      if IsKeyDown(KEY_UP.int) then blueBallPosition.y -= 2.0f;
      if IsKeyDown(KEY_DOWN.int) then blueBallPosition.y += 2.0f;

      ClearBackground(!WHITE)
      DrawText(
        c"Red ball will follow your pointer,\n move blue with arrow keys",
        10,
        10,
        20,
        !BLACK
      )
      DrawCircleV(!redBallPosition, 50, !RED)
      DrawCircleV(blueBallPosition, 20, !BLUE)
      EndDrawing()
    end while
    CloseWindow()
  }
end hello_raylib
