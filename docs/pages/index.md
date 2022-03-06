---
title: Home
index: true
---

SN Bindgen is a set of tools to generate Scala Native bindings for C libraries 
from header files.

It comes in the form of a standalone CLI binary and a SBT plugin, both of which can 
generate comprehensive Scala 3 Native definitions from C header files.

- Head on over to [Quick start](/quickstart) to see how to use this project

- Check out [Motivation](/motivation) to see why I think this project is useful

- See [Semantics](/semantics) for detailed description of what is generated, how it behaves, and
  and how C definitions are interpreted

- Visit [Limitations](/limitations) to see what the generator currently cannot do and what
  is required to overcome those difficulties

- In [Configuration](/configuration) you can see what options are available both in CLI and 
  in the SBT plugin

There's a GIF, therefore it works
--

As a motivating example, here's a program written with bindings to [Raylib](https://www.raylib.com/examples.html), running on Apple M1.

<img title = "A GIF showing the program running, and a code modification" src ="https://user-images.githubusercontent.com/1052965/156929377-5494b58a-41f3-4fff-8462-435a41929277.gif"  style = "width: 100%">

```scala
import libraylib.functions.*
import libraylib.types.*

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

@main def hello_raylib =
  val screenWidth = 800
  val screenHeight = 450

  InitWindow(
    screenWidth,
    screenHeight,
    c"hello raylib from Scala Native"
  )

  Zone { implicit z =>

    val WHITE = Color(255.toUByte, 255.toUByte, 255.toUByte, 255.toUByte)
    val GREEN = Color(0.toUByte, 255.toUByte, 0.toUByte, 255.toUByte)
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
      DrawCircleV(!redBallPosition, 50, !GREEN)
      DrawCircleV(blueBallPosition, 20, !BLUE)
      EndDrawing()
    end while
    CloseWindow()
  }
end hello_raylib
```
