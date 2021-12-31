Function(InitWindow,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(WindowShouldClose,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CloseWindow,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsWindowReady,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowFullscreen,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowHidden,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowMinimized,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowMaximized,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowFocused,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowResized,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsWindowState,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetWindowState,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ClearWindowState,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ToggleFullscreen,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(MaximizeWindow,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(MinimizeWindow,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(RestoreWindow,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowIcon,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowTitle,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowPosition,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowMonitor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowMinSize,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowSize,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetWindowOpacity,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetWindowHandle,Pointer(Void),ListBuffer(),Extern,OriginalCType(Pointer(Void),void *))
Function(GetScreenWidth,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetScreenHeight,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetRenderWidth,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetRenderHeight,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMonitorCount,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetCurrentMonitor,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMonitorPosition,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetMonitorWidth,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMonitorHeight,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMonitorPhysicalWidth,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMonitorPhysicalHeight,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMonitorRefreshRate,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetWindowPosition,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetWindowScaleDPI,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetMonitorName,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(SetClipboardText,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetClipboardText,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(SwapScreenBuffer,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(PollInputEvents,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(WaitTime,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ShowCursor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(HideCursor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsCursorHidden,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(EnableCursor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DisableCursor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsCursorOnScreen,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(ClearBackground,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginDrawing,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndDrawing,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginMode2D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndMode2D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginMode3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndMode3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginTextureMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndTextureMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginShaderMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndShaderMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginBlendMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndBlendMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginScissorMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndScissorMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(BeginVrStereoMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(EndVrStereoMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadVrStereoConfig,Typedef(VrStereoConfig),ListBuffer(),Extern,OriginalCType(Typedef(VrStereoConfig),VrStereoConfig))
Function(UnloadVrStereoConfig,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadShader,Typedef(Shader),ListBuffer(),Extern,OriginalCType(Typedef(Shader),Shader))
Function(LoadShaderFromMemory,Typedef(Shader),ListBuffer(),Extern,OriginalCType(Typedef(Shader),Shader))
Function(GetShaderLocation,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetShaderLocationAttrib,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetShaderValue,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetShaderValueV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetShaderValueMatrix,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetShaderValueTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadShader,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetMouseRay,Typedef(Ray),ListBuffer(),Extern,OriginalCType(Typedef(Ray),Ray))
Function(GetCameraMatrix,Typedef(Matrix),ListBuffer(),Extern,OriginalCType(Typedef(Matrix),Matrix))
Function(GetCameraMatrix2D,Typedef(Matrix),ListBuffer(),Extern,OriginalCType(Typedef(Matrix),Matrix))
Function(GetWorldToScreen,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetWorldToScreenEx,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetWorldToScreen2D,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetScreenToWorld2D,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(SetTargetFPS,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetFPS,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetFrameTime,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(GetTime,NumericReal(Double),ListBuffer(),Extern,OriginalCType(NumericReal(Double),double))
Function(GetRandomValue,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetRandomSeed,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(TakeScreenshot,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetConfigFlags,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(TraceLog,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetTraceLogLevel,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(MemAlloc,Pointer(Void),ListBuffer(),Extern,OriginalCType(Pointer(Void),void *))
Function(MemRealloc,Pointer(Void),ListBuffer(),Extern,OriginalCType(Pointer(Void),void *))
Function(MemFree,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetTraceLogCallback,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetLoadFileDataCallback,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetSaveFileDataCallback,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetLoadFileTextCallback,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetSaveFileTextCallback,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadFileData,Pointer(NumericIntegral(Char,Unsigned)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Unsigned)),unsigned char *))
Function(UnloadFileData,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SaveFileData,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(LoadFileText,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),char *))
Function(UnloadFileText,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SaveFileText,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(FileExists,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(DirectoryExists,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsFileExtension,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetFileExtension,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(GetFileName,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(GetFileNameWithoutExt,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(GetDirectoryPath,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(GetPrevDirectoryPath,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(GetWorkingDirectory,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(GetDirectoryFiles,Pointer(Pointer(NumericIntegral(Char,Signed))),ListBuffer(),Extern,OriginalCType(Pointer(Pointer(NumericIntegral(Char,Signed))),char **))
Function(ClearDirectoryFiles,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ChangeDirectory,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsFileDropped,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetDroppedFiles,Pointer(Pointer(NumericIntegral(Char,Signed))),ListBuffer(),Extern,OriginalCType(Pointer(Pointer(NumericIntegral(Char,Signed))),char **))
Function(ClearDroppedFiles,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetFileModTime,NumericIntegral(Long,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Long,Signed),long))
Function(CompressData,Pointer(NumericIntegral(Char,Unsigned)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Unsigned)),unsigned char *))
Function(DecompressData,Pointer(NumericIntegral(Char,Unsigned)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Unsigned)),unsigned char *))
Function(EncodeDataBase64,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),char *))
Function(DecodeDataBase64,Pointer(NumericIntegral(Char,Unsigned)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Unsigned)),unsigned char *))
Function(SaveStorageValue,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(LoadStorageValue,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(OpenURL,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsKeyPressed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsKeyDown,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsKeyReleased,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsKeyUp,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetExitKey,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetKeyPressed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetCharPressed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsGamepadAvailable,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGamepadName,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(IsGamepadButtonPressed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsGamepadButtonDown,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsGamepadButtonReleased,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsGamepadButtonUp,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGamepadButtonPressed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGamepadAxisCount,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGamepadAxisMovement,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(SetGamepadMappings,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsMouseButtonPressed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsMouseButtonDown,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsMouseButtonReleased,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsMouseButtonUp,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMouseX,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMouseY,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMousePosition,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetMouseDelta,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(SetMousePosition,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetMouseOffset,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetMouseScale,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetMouseWheelMove,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(SetMouseCursor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetTouchX,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetTouchY,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetTouchPosition,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetTouchPointId,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetTouchPointCount,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetGesturesEnabled,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsGestureDetected,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGestureDetected,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGestureHoldDuration,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(GetGestureDragVector,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetGestureDragAngle,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(GetGesturePinchVector,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetGesturePinchAngle,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(SetCameraMode,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UpdateCamera,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetCameraPanControl,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetCameraAltControl,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetCameraSmoothZoomControl,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetCameraMoveControls,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetShapesTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPixel,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPixelV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLine,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLineV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLineEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLineBezier,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLineBezierQuad,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLineBezierCubic,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawLineStrip,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircle,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircleSector,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircleSectorLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircleGradient,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircleV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircleLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawEllipse,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawEllipseLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRing,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRingLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangle,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleRec,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectanglePro,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleGradientV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleGradientH,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleGradientEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleLinesEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleRounded,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRectangleRoundedLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTriangle,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTriangleLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTriangleFan,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTriangleStrip,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPoly,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPolyLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPolyLinesEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(CheckCollisionRecs,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionCircles,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionCircleRec,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionPointRec,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionPointCircle,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionPointTriangle,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionLines,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionPointLine,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetCollisionRec,Typedef(Rectangle),ListBuffer(),Extern,OriginalCType(Typedef(Rectangle),Rectangle))
Function(LoadImage,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(LoadImageRaw,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(LoadImageAnim,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(LoadImageFromMemory,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(LoadImageFromTexture,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(LoadImageFromScreen,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(UnloadImage,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ExportImage,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(ExportImageAsCode,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GenImageColor,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(GenImageGradientV,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(GenImageGradientH,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(GenImageGradientRadial,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(GenImageChecked,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(GenImageWhiteNoise,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(GenImageCellular,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(ImageCopy,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(ImageFromImage,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(ImageText,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(ImageTextEx,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(ImageFormat,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageToPOT,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageCrop,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageAlphaCrop,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageAlphaClear,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageAlphaMask,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageAlphaPremultiply,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageResize,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageResizeNN,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageResizeCanvas,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageMipmaps,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDither,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageFlipVertical,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageFlipHorizontal,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageRotateCW,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageRotateCCW,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageColorTint,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageColorInvert,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageColorGrayscale,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageColorContrast,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageColorBrightness,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageColorReplace,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadImageColors,Pointer(Typedef(Color)),ListBuffer(),Extern,OriginalCType(Pointer(Typedef(Color)),Color *))
Function(LoadImagePalette,Pointer(Typedef(Color)),ListBuffer(),Extern,OriginalCType(Pointer(Typedef(Color)),Color *))
Function(UnloadImageColors,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadImagePalette,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetImageAlphaBorder,Typedef(Rectangle),ListBuffer(),Extern,OriginalCType(Typedef(Rectangle),Rectangle))
Function(GetImageColor,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(ImageClearBackground,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawPixel,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawPixelV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawLine,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawLineV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawCircle,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawCircleV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawRectangle,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawRectangleV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawRectangleRec,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawRectangleLines,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDraw,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawText,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ImageDrawTextEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadTexture,Typedef(Texture2D),ListBuffer(),Extern,OriginalCType(Typedef(Texture2D),Texture2D))
Function(LoadTextureFromImage,Typedef(Texture2D),ListBuffer(),Extern,OriginalCType(Typedef(Texture2D),Texture2D))
Function(LoadTextureCubemap,Typedef(TextureCubemap),ListBuffer(),Extern,OriginalCType(Typedef(TextureCubemap),TextureCubemap))
Function(LoadRenderTexture,Typedef(RenderTexture2D),ListBuffer(),Extern,OriginalCType(Typedef(RenderTexture2D),RenderTexture2D))
Function(UnloadTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadRenderTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UpdateTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UpdateTextureRec,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GenTextureMipmaps,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetTextureFilter,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetTextureWrap,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextureV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextureEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextureRec,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextureQuad,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextureTiled,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTexturePro,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextureNPatch,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTexturePoly,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(Fade,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(ColorToInt,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(ColorNormalize,Typedef(Vector4),ListBuffer(),Extern,OriginalCType(Typedef(Vector4),Vector4))
Function(ColorFromNormalized,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(ColorToHSV,Typedef(Vector3),ListBuffer(),Extern,OriginalCType(Typedef(Vector3),Vector3))
Function(ColorFromHSV,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(ColorAlpha,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(ColorAlphaBlend,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(GetColor,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(GetPixelColor,Typedef(Color),ListBuffer(),Extern,OriginalCType(Typedef(Color),Color))
Function(SetPixelColor,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetPixelDataSize,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetFontDefault,Typedef(Font),ListBuffer(),Extern,OriginalCType(Typedef(Font),Font))
Function(LoadFont,Typedef(Font),ListBuffer(),Extern,OriginalCType(Typedef(Font),Font))
Function(LoadFontEx,Typedef(Font),ListBuffer(),Extern,OriginalCType(Typedef(Font),Font))
Function(LoadFontFromImage,Typedef(Font),ListBuffer(),Extern,OriginalCType(Typedef(Font),Font))
Function(LoadFontFromMemory,Typedef(Font),ListBuffer(),Extern,OriginalCType(Typedef(Font),Font))
Function(LoadFontData,Pointer(Typedef(GlyphInfo)),ListBuffer(),Extern,OriginalCType(Pointer(Typedef(GlyphInfo)),GlyphInfo *))
Function(GenImageFontAtlas,Typedef(Image),ListBuffer(),Extern,OriginalCType(Typedef(Image),Image))
Function(UnloadFontData,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadFont,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawFPS,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawText,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextPro,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTextCodepoint,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(MeasureText,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(MeasureTextEx,Typedef(Vector2),ListBuffer(),Extern,OriginalCType(Typedef(Vector2),Vector2))
Function(GetGlyphIndex,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetGlyphInfo,Typedef(GlyphInfo),ListBuffer(),Extern,OriginalCType(Typedef(GlyphInfo),GlyphInfo))
Function(GetGlyphAtlasRec,Typedef(Rectangle),ListBuffer(),Extern,OriginalCType(Typedef(Rectangle),Rectangle))
Function(LoadCodepoints,Pointer(NumericIntegral(Int,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Int,Signed)),int *))
Function(UnloadCodepoints,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetCodepointCount,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetCodepoint,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CodepointToUTF8,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextCodepointsToUTF8,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),char *))
Function(TextCopy,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(TextIsEqual,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(TextLength,NumericIntegral(Int,Unsigned),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Unsigned),unsigned int))
Function(TextFormat,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextSubtext,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextReplace,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),char *))
Function(TextInsert,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),char *))
Function(TextJoin,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextSplit,Pointer(Pointer(NumericIntegral(Char,Signed))),ListBuffer(),Extern,OriginalCType(Pointer(Pointer(NumericIntegral(Char,Signed))),const char **))
Function(TextAppend,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(TextFindIndex,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(TextToUpper,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextToLower,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextToPascal,Pointer(NumericIntegral(Char,Signed)),ListBuffer(),Extern,OriginalCType(Pointer(NumericIntegral(Char,Signed)),const char *))
Function(TextToInteger,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(DrawLine3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPoint3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCircle3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTriangle3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawTriangleStrip3D,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCube,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCubeV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCubeWires,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCubeWiresV,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCubeTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCubeTextureRec,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawSphere,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawSphereEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawSphereWires,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCylinder,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCylinderEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCylinderWires,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawCylinderWiresEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawPlane,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawRay,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawGrid,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadModel,Typedef(Model),ListBuffer(),Extern,OriginalCType(Typedef(Model),Model))
Function(LoadModelFromMesh,Typedef(Model),ListBuffer(),Extern,OriginalCType(Typedef(Model),Model))
Function(UnloadModel,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadModelKeepMeshes,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetModelBoundingBox,Typedef(BoundingBox),ListBuffer(),Extern,OriginalCType(Typedef(BoundingBox),BoundingBox))
Function(DrawModel,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawModelEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawModelWires,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawModelWiresEx,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawBoundingBox,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawBillboard,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawBillboardRec,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawBillboardPro,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UploadMesh,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UpdateMeshBuffer,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadMesh,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawMesh,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(DrawMeshInstanced,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ExportMesh,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetMeshBoundingBox,Typedef(BoundingBox),ListBuffer(),Extern,OriginalCType(Typedef(BoundingBox),BoundingBox))
Function(GenMeshTangents,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GenMeshBinormals,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GenMeshPoly,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshPlane,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshCube,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshSphere,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshHemiSphere,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshCylinder,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshCone,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshTorus,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshKnot,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshHeightmap,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(GenMeshCubicmap,Typedef(Mesh),ListBuffer(),Extern,OriginalCType(Typedef(Mesh),Mesh))
Function(LoadMaterials,Pointer(Typedef(Material)),ListBuffer(),Extern,OriginalCType(Pointer(Typedef(Material)),Material *))
Function(LoadMaterialDefault,Typedef(Material),ListBuffer(),Extern,OriginalCType(Typedef(Material),Material))
Function(UnloadMaterial,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetMaterialTexture,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetModelMeshMaterial,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadModelAnimations,Pointer(Typedef(ModelAnimation)),ListBuffer(),Extern,OriginalCType(Pointer(Typedef(ModelAnimation)),ModelAnimation *))
Function(UpdateModelAnimation,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadModelAnimation,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadModelAnimations,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsModelAnimationValid,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionSpheres,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionBoxes,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(CheckCollisionBoxSphere,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(GetRayCollisionSphere,Typedef(RayCollision),ListBuffer(),Extern,OriginalCType(Typedef(RayCollision),RayCollision))
Function(GetRayCollisionBox,Typedef(RayCollision),ListBuffer(),Extern,OriginalCType(Typedef(RayCollision),RayCollision))
Function(GetRayCollisionModel,Typedef(RayCollision),ListBuffer(),Extern,OriginalCType(Typedef(RayCollision),RayCollision))
Function(GetRayCollisionMesh,Typedef(RayCollision),ListBuffer(),Extern,OriginalCType(Typedef(RayCollision),RayCollision))
Function(GetRayCollisionTriangle,Typedef(RayCollision),ListBuffer(),Extern,OriginalCType(Typedef(RayCollision),RayCollision))
Function(GetRayCollisionQuad,Typedef(RayCollision),ListBuffer(),Extern,OriginalCType(Typedef(RayCollision),RayCollision))
Function(InitAudioDevice,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(CloseAudioDevice,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsAudioDeviceReady,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetMasterVolume,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadWave,Typedef(Wave),ListBuffer(),Extern,OriginalCType(Typedef(Wave),Wave))
Function(LoadWaveFromMemory,Typedef(Wave),ListBuffer(),Extern,OriginalCType(Typedef(Wave),Wave))
Function(LoadSound,Typedef(Sound),ListBuffer(),Extern,OriginalCType(Typedef(Sound),Sound))
Function(LoadSoundFromWave,Typedef(Sound),ListBuffer(),Extern,OriginalCType(Typedef(Sound),Sound))
Function(UpdateSound,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadWave,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UnloadSound,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ExportWave,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(ExportWaveAsCode,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(PlaySound,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(StopSound,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(PauseSound,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ResumeSound,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(PlaySoundMulti,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(StopSoundMulti,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetSoundsPlaying,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(IsSoundPlaying,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(SetSoundVolume,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetSoundPitch,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(WaveFormat,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(WaveCopy,Typedef(Wave),ListBuffer(),Extern,OriginalCType(Typedef(Wave),Wave))
Function(WaveCrop,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadWaveSamples,Pointer(NumericReal(Float)),ListBuffer(),Extern,OriginalCType(Pointer(NumericReal(Float)),float *))
Function(UnloadWaveSamples,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(LoadMusicStream,Typedef(Music),ListBuffer(),Extern,OriginalCType(Typedef(Music),Music))
Function(LoadMusicStreamFromMemory,Typedef(Music),ListBuffer(),Extern,OriginalCType(Typedef(Music),Music))
Function(UnloadMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(PlayMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsMusicStreamPlaying,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(UpdateMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(StopMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(PauseMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ResumeMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SeekMusicStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetMusicVolume,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetMusicPitch,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(GetMusicTimeLength,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(GetMusicTimePlayed,NumericReal(Float),ListBuffer(),Extern,OriginalCType(NumericReal(Float),float))
Function(LoadAudioStream,Typedef(AudioStream),ListBuffer(),Extern,OriginalCType(Typedef(AudioStream),AudioStream))
Function(UnloadAudioStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(UpdateAudioStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsAudioStreamProcessed,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(PlayAudioStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(PauseAudioStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(ResumeAudioStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(IsAudioStreamPlaying,NumericIntegral(Int,Signed),ListBuffer(),Extern,OriginalCType(NumericIntegral(Int,Signed),int))
Function(StopAudioStream,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetAudioStreamVolume,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetAudioStreamPitch,Void,ListBuffer(),Extern,OriginalCType(Void,void))
Function(SetAudioStreamBufferSizeDefault,Void,ListBuffer(),Extern,OriginalCType(Void,void))
#include <string.h>
#include <raylib.h>


void __sn_wrap_BeginMode2D(Camera2D *camera) {
 BeginMode2D(*camera);
};

void __sn_wrap_BeginMode3D(Camera3D *camera) {
 BeginMode3D(*camera);
};

void __sn_wrap_BeginShaderMode(Shader *shader) {
 BeginShaderMode(*shader);
};

void __sn_wrap_BeginTextureMode(RenderTexture2D *target) {
 BeginTextureMode(*target);
};

void __sn_wrap_BeginVrStereoMode(VrStereoConfig *config) {
 BeginVrStereoMode(*config);
};

void __sn_wrap_ClearBackground(Color *color) {
 ClearBackground(*color);
};

void __sn_wrap_ColorAlpha(Color *color, float alpha, Color *__return) {
  Color ____ret = ColorAlpha(*color, alpha);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_ColorAlphaBlend(Color *dst, Color *src, Color *tint, Color *__return) {
  Color ____ret = ColorAlphaBlend(*dst, *src, *tint);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_ColorFromHSV(float hue, float saturation, float value, Color *__return) {
  Color ____ret = ColorFromHSV(hue, saturation, value);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_ColorFromNormalized(Vector4 *normalized, Color *__return) {
  Color ____ret = ColorFromNormalized(*normalized);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_ColorNormalize(Color *color, Vector4 *__return) {
  Vector4 ____ret = ColorNormalize(*color);
  memcpy(__return, &____ret, sizeof(Vector4));
}

void __sn_wrap_ColorToHSV(Color *color, Vector3 *__return) {
  Vector3 ____ret = ColorToHSV(*color);
  memcpy(__return, &____ret, sizeof(Vector3));
}

int __sn_wrap_ColorToInt(Color *color) {
 return ColorToInt(*color);
};

void __sn_wrap_DrawBillboard(Camera *camera, Texture2D *texture, Vector3 *position, float size, Color *tint) {
 DrawBillboard(*camera, *texture, *position, size, *tint);
};

void __sn_wrap_DrawBillboardPro(Camera *camera, Texture2D *texture, Rectangle *source, Vector3 *position, Vector3 *up, Vector2 *size, Vector2 *origin, float rotation, Color *tint) {
 DrawBillboardPro(*camera, *texture, *source, *position, *up, *size, *origin, rotation, *tint);
};

void __sn_wrap_DrawBillboardRec(Camera *camera, Texture2D *texture, Rectangle *source, Vector3 *position, Vector2 *size, Color *tint) {
 DrawBillboardRec(*camera, *texture, *source, *position, *size, *tint);
};

void __sn_wrap_DrawBoundingBox(BoundingBox *box, Color *color) {
 DrawBoundingBox(*box, *color);
};

void __sn_wrap_DrawCircle(int centerX, int centerY, float radius, Color *color) {
 DrawCircle(centerX, centerY, radius, *color);
};

void __sn_wrap_DrawCircle3D(Vector3 *center, float radius, Vector3 *rotationAxis, float rotationAngle, Color *color) {
 DrawCircle3D(*center, radius, *rotationAxis, rotationAngle, *color);
};

void __sn_wrap_DrawCircleGradient(int centerX, int centerY, float radius, Color *color1, Color *color2) {
 DrawCircleGradient(centerX, centerY, radius, *color1, *color2);
};

void __sn_wrap_DrawCircleLines(int centerX, int centerY, float radius, Color *color) {
 DrawCircleLines(centerX, centerY, radius, *color);
};

void __sn_wrap_DrawCircleSector(Vector2 *center, float radius, float startAngle, float endAngle, int segments, Color *color) {
 DrawCircleSector(*center, radius, startAngle, endAngle, segments, *color);
};

void __sn_wrap_DrawCircleSectorLines(Vector2 *center, float radius, float startAngle, float endAngle, int segments, Color *color) {
 DrawCircleSectorLines(*center, radius, startAngle, endAngle, segments, *color);
};

void __sn_wrap_DrawCircleV(Vector2 *center, float radius, Color *color) {
 DrawCircleV(*center, radius, *color);
};

void __sn_wrap_DrawCube(Vector3 *position, float width, float height, float length, Color *color) {
 DrawCube(*position, width, height, length, *color);
};

void __sn_wrap_DrawCubeTexture(Texture2D *texture, Vector3 *position, float width, float height, float length, Color *color) {
 DrawCubeTexture(*texture, *position, width, height, length, *color);
};

void __sn_wrap_DrawCubeTextureRec(Texture2D *texture, Rectangle *source, Vector3 *position, float width, float height, float length, Color *color) {
 DrawCubeTextureRec(*texture, *source, *position, width, height, length, *color);
};

void __sn_wrap_DrawCubeV(Vector3 *position, Vector3 *size, Color *color) {
 DrawCubeV(*position, *size, *color);
};

void __sn_wrap_DrawCubeWires(Vector3 *position, float width, float height, float length, Color *color) {
 DrawCubeWires(*position, width, height, length, *color);
};

void __sn_wrap_DrawCubeWiresV(Vector3 *position, Vector3 *size, Color *color) {
 DrawCubeWiresV(*position, *size, *color);
};

void __sn_wrap_DrawCylinder(Vector3 *position, float radiusTop, float radiusBottom, float height, int slices, Color *color) {
 DrawCylinder(*position, radiusTop, radiusBottom, height, slices, *color);
};

void __sn_wrap_DrawCylinderEx(Vector3 *startPos, Vector3 *endPos, float startRadius, float endRadius, int sides, Color *color) {
 DrawCylinderEx(*startPos, *endPos, startRadius, endRadius, sides, *color);
};

void __sn_wrap_DrawCylinderWires(Vector3 *position, float radiusTop, float radiusBottom, float height, int slices, Color *color) {
 DrawCylinderWires(*position, radiusTop, radiusBottom, height, slices, *color);
};

void __sn_wrap_DrawCylinderWiresEx(Vector3 *startPos, Vector3 *endPos, float startRadius, float endRadius, int sides, Color *color) {
 DrawCylinderWiresEx(*startPos, *endPos, startRadius, endRadius, sides, *color);
};

void __sn_wrap_DrawEllipse(int centerX, int centerY, float radiusH, float radiusV, Color *color) {
 DrawEllipse(centerX, centerY, radiusH, radiusV, *color);
};

void __sn_wrap_DrawEllipseLines(int centerX, int centerY, float radiusH, float radiusV, Color *color) {
 DrawEllipseLines(centerX, centerY, radiusH, radiusV, *color);
};

void __sn_wrap_DrawLine(int startPosX, int startPosY, int endPosX, int endPosY, Color *color) {
 DrawLine(startPosX, startPosY, endPosX, endPosY, *color);
};

void __sn_wrap_DrawLine3D(Vector3 *startPos, Vector3 *endPos, Color *color) {
 DrawLine3D(*startPos, *endPos, *color);
};

void __sn_wrap_DrawLineBezier(Vector2 *startPos, Vector2 *endPos, float thick, Color *color) {
 DrawLineBezier(*startPos, *endPos, thick, *color);
};

void __sn_wrap_DrawLineBezierCubic(Vector2 *startPos, Vector2 *endPos, Vector2 *startControlPos, Vector2 *endControlPos, float thick, Color *color) {
 DrawLineBezierCubic(*startPos, *endPos, *startControlPos, *endControlPos, thick, *color);
};

void __sn_wrap_DrawLineBezierQuad(Vector2 *startPos, Vector2 *endPos, Vector2 *controlPos, float thick, Color *color) {
 DrawLineBezierQuad(*startPos, *endPos, *controlPos, thick, *color);
};

void __sn_wrap_DrawLineEx(Vector2 *startPos, Vector2 *endPos, float thick, Color *color) {
 DrawLineEx(*startPos, *endPos, thick, *color);
};

void __sn_wrap_DrawLineStrip(Vector2 * points, int pointCount, Color *color) {
 DrawLineStrip(points, pointCount, *color);
};

void __sn_wrap_DrawLineV(Vector2 *startPos, Vector2 *endPos, Color *color) {
 DrawLineV(*startPos, *endPos, *color);
};

void __sn_wrap_DrawMesh(Mesh *mesh, Material *material, Matrix *transform) {
 DrawMesh(*mesh, *material, *transform);
};

void __sn_wrap_DrawMeshInstanced(Mesh *mesh, Material *material, Matrix * transforms, int instances) {
 DrawMeshInstanced(*mesh, *material, transforms, instances);
};

void __sn_wrap_DrawModel(Model *model, Vector3 *position, float scale, Color *tint) {
 DrawModel(*model, *position, scale, *tint);
};

void __sn_wrap_DrawModelEx(Model *model, Vector3 *position, Vector3 *rotationAxis, float rotationAngle, Vector3 *scale, Color *tint) {
 DrawModelEx(*model, *position, *rotationAxis, rotationAngle, *scale, *tint);
};

void __sn_wrap_DrawModelWires(Model *model, Vector3 *position, float scale, Color *tint) {
 DrawModelWires(*model, *position, scale, *tint);
};

void __sn_wrap_DrawModelWiresEx(Model *model, Vector3 *position, Vector3 *rotationAxis, float rotationAngle, Vector3 *scale, Color *tint) {
 DrawModelWiresEx(*model, *position, *rotationAxis, rotationAngle, *scale, *tint);
};

void __sn_wrap_DrawPixel(int posX, int posY, Color *color) {
 DrawPixel(posX, posY, *color);
};

void __sn_wrap_DrawPixelV(Vector2 *position, Color *color) {
 DrawPixelV(*position, *color);
};

void __sn_wrap_DrawPlane(Vector3 *centerPos, Vector2 *size, Color *color) {
 DrawPlane(*centerPos, *size, *color);
};

void __sn_wrap_DrawPoint3D(Vector3 *position, Color *color) {
 DrawPoint3D(*position, *color);
};

void __sn_wrap_DrawPoly(Vector2 *center, int sides, float radius, float rotation, Color *color) {
 DrawPoly(*center, sides, radius, rotation, *color);
};

void __sn_wrap_DrawPolyLines(Vector2 *center, int sides, float radius, float rotation, Color *color) {
 DrawPolyLines(*center, sides, radius, rotation, *color);
};

void __sn_wrap_DrawPolyLinesEx(Vector2 *center, int sides, float radius, float rotation, float lineThick, Color *color) {
 DrawPolyLinesEx(*center, sides, radius, rotation, lineThick, *color);
};

void __sn_wrap_DrawRay(Ray *ray, Color *color) {
 DrawRay(*ray, *color);
};

void __sn_wrap_DrawRectangle(int posX, int posY, int width, int height, Color *color) {
 DrawRectangle(posX, posY, width, height, *color);
};

void __sn_wrap_DrawRectangleGradientEx(Rectangle *rec, Color *col1, Color *col2, Color *col3, Color *col4) {
 DrawRectangleGradientEx(*rec, *col1, *col2, *col3, *col4);
};

void __sn_wrap_DrawRectangleGradientH(int posX, int posY, int width, int height, Color *color1, Color *color2) {
 DrawRectangleGradientH(posX, posY, width, height, *color1, *color2);
};

void __sn_wrap_DrawRectangleGradientV(int posX, int posY, int width, int height, Color *color1, Color *color2) {
 DrawRectangleGradientV(posX, posY, width, height, *color1, *color2);
};

void __sn_wrap_DrawRectangleLines(int posX, int posY, int width, int height, Color *color) {
 DrawRectangleLines(posX, posY, width, height, *color);
};

void __sn_wrap_DrawRectangleLinesEx(Rectangle *rec, float lineThick, Color *color) {
 DrawRectangleLinesEx(*rec, lineThick, *color);
};

void __sn_wrap_DrawRectanglePro(Rectangle *rec, Vector2 *origin, float rotation, Color *color) {
 DrawRectanglePro(*rec, *origin, rotation, *color);
};

void __sn_wrap_DrawRectangleRec(Rectangle *rec, Color *color) {
 DrawRectangleRec(*rec, *color);
};

void __sn_wrap_DrawRectangleRounded(Rectangle *rec, float roundness, int segments, Color *color) {
 DrawRectangleRounded(*rec, roundness, segments, *color);
};

void __sn_wrap_DrawRectangleRoundedLines(Rectangle *rec, float roundness, int segments, float lineThick, Color *color) {
 DrawRectangleRoundedLines(*rec, roundness, segments, lineThick, *color);
};

void __sn_wrap_DrawRectangleV(Vector2 *position, Vector2 *size, Color *color) {
 DrawRectangleV(*position, *size, *color);
};

void __sn_wrap_DrawRing(Vector2 *center, float innerRadius, float outerRadius, float startAngle, float endAngle, int segments, Color *color) {
 DrawRing(*center, innerRadius, outerRadius, startAngle, endAngle, segments, *color);
};

void __sn_wrap_DrawRingLines(Vector2 *center, float innerRadius, float outerRadius, float startAngle, float endAngle, int segments, Color *color) {
 DrawRingLines(*center, innerRadius, outerRadius, startAngle, endAngle, segments, *color);
};

void __sn_wrap_DrawSphere(Vector3 *centerPos, float radius, Color *color) {
 DrawSphere(*centerPos, radius, *color);
};

void __sn_wrap_DrawSphereEx(Vector3 *centerPos, float radius, int rings, int slices, Color *color) {
 DrawSphereEx(*centerPos, radius, rings, slices, *color);
};

void __sn_wrap_DrawSphereWires(Vector3 *centerPos, float radius, int rings, int slices, Color *color) {
 DrawSphereWires(*centerPos, radius, rings, slices, *color);
};

void __sn_wrap_DrawText(const char * text, int posX, int posY, int fontSize, Color *color) {
 DrawText(text, posX, posY, fontSize, *color);
};

void __sn_wrap_DrawTextCodepoint(Font *font, int codepoint, Vector2 *position, float fontSize, Color *tint) {
 DrawTextCodepoint(*font, codepoint, *position, fontSize, *tint);
};

void __sn_wrap_DrawTextEx(Font *font, const char * text, Vector2 *position, float fontSize, float spacing, Color *tint) {
 DrawTextEx(*font, text, *position, fontSize, spacing, *tint);
};

void __sn_wrap_DrawTextPro(Font *font, const char * text, Vector2 *position, Vector2 *origin, float rotation, float fontSize, float spacing, Color *tint) {
 DrawTextPro(*font, text, *position, *origin, rotation, fontSize, spacing, *tint);
};

void __sn_wrap_DrawTexture(Texture2D *texture, int posX, int posY, Color *tint) {
 DrawTexture(*texture, posX, posY, *tint);
};

void __sn_wrap_DrawTextureEx(Texture2D *texture, Vector2 *position, float rotation, float scale, Color *tint) {
 DrawTextureEx(*texture, *position, rotation, scale, *tint);
};

void __sn_wrap_DrawTextureNPatch(Texture2D *texture, NPatchInfo *nPatchInfo, Rectangle *dest, Vector2 *origin, float rotation, Color *tint) {
 DrawTextureNPatch(*texture, *nPatchInfo, *dest, *origin, rotation, *tint);
};

void __sn_wrap_DrawTexturePoly(Texture2D *texture, Vector2 *center, Vector2 * points, Vector2 * texcoords, int pointCount, Color *tint) {
 DrawTexturePoly(*texture, *center, points, texcoords, pointCount, *tint);
};

void __sn_wrap_DrawTexturePro(Texture2D *texture, Rectangle *source, Rectangle *dest, Vector2 *origin, float rotation, Color *tint) {
 DrawTexturePro(*texture, *source, *dest, *origin, rotation, *tint);
};

void __sn_wrap_DrawTextureQuad(Texture2D *texture, Vector2 *tiling, Vector2 *offset, Rectangle *quad, Color *tint) {
 DrawTextureQuad(*texture, *tiling, *offset, *quad, *tint);
};

void __sn_wrap_DrawTextureRec(Texture2D *texture, Rectangle *source, Vector2 *position, Color *tint) {
 DrawTextureRec(*texture, *source, *position, *tint);
};

void __sn_wrap_DrawTextureTiled(Texture2D *texture, Rectangle *source, Rectangle *dest, Vector2 *origin, float rotation, float scale, Color *tint) {
 DrawTextureTiled(*texture, *source, *dest, *origin, rotation, scale, *tint);
};

void __sn_wrap_DrawTextureV(Texture2D *texture, Vector2 *position, Color *tint) {
 DrawTextureV(*texture, *position, *tint);
};

void __sn_wrap_DrawTriangle(Vector2 *v1, Vector2 *v2, Vector2 *v3, Color *color) {
 DrawTriangle(*v1, *v2, *v3, *color);
};

void __sn_wrap_DrawTriangle3D(Vector3 *v1, Vector3 *v2, Vector3 *v3, Color *color) {
 DrawTriangle3D(*v1, *v2, *v3, *color);
};

void __sn_wrap_DrawTriangleFan(Vector2 * points, int pointCount, Color *color) {
 DrawTriangleFan(points, pointCount, *color);
};

void __sn_wrap_DrawTriangleLines(Vector2 *v1, Vector2 *v2, Vector2 *v3, Color *color) {
 DrawTriangleLines(*v1, *v2, *v3, *color);
};

void __sn_wrap_DrawTriangleStrip(Vector2 * points, int pointCount, Color *color) {
 DrawTriangleStrip(points, pointCount, *color);
};

void __sn_wrap_DrawTriangleStrip3D(Vector3 * points, int pointCount, Color *color) {
 DrawTriangleStrip3D(points, pointCount, *color);
};

void __sn_wrap_Fade(Color *color, float alpha, Color *__return) {
  Color ____ret = Fade(*color, alpha);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_GenImageCellular(int width, int height, int tileSize, Image *__return) {
  Image ____ret = GenImageCellular(width, height, tileSize);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageChecked(int width, int height, int checksX, int checksY, Color *col1, Color *col2, Image *__return) {
  Image ____ret = GenImageChecked(width, height, checksX, checksY, *col1, *col2);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageColor(int width, int height, Color *color, Image *__return) {
  Image ____ret = GenImageColor(width, height, *color);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageFontAtlas(const GlyphInfo * chars, Rectangle ** recs, int glyphCount, int fontSize, int padding, int packMethod, Image *__return) {
  Image ____ret = GenImageFontAtlas(chars, recs, glyphCount, fontSize, padding, packMethod);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageGradientH(int width, int height, Color *left, Color *right, Image *__return) {
  Image ____ret = GenImageGradientH(width, height, *left, *right);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageGradientRadial(int width, int height, float density, Color *inner, Color *outer, Image *__return) {
  Image ____ret = GenImageGradientRadial(width, height, density, *inner, *outer);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageGradientV(int width, int height, Color *top, Color *bottom, Image *__return) {
  Image ____ret = GenImageGradientV(width, height, *top, *bottom);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenImageWhiteNoise(int width, int height, float factor, Image *__return) {
  Image ____ret = GenImageWhiteNoise(width, height, factor);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_GenMeshCone(float radius, float height, int slices, Mesh *__return) {
  Mesh ____ret = GenMeshCone(radius, height, slices);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshCube(float width, float height, float length, Mesh *__return) {
  Mesh ____ret = GenMeshCube(width, height, length);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshCubicmap(Image *cubicmap, Vector3 *cubeSize, Mesh *__return) {
  Mesh ____ret = GenMeshCubicmap(*cubicmap, *cubeSize);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshCylinder(float radius, float height, int slices, Mesh *__return) {
  Mesh ____ret = GenMeshCylinder(radius, height, slices);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshHeightmap(Image *heightmap, Vector3 *size, Mesh *__return) {
  Mesh ____ret = GenMeshHeightmap(*heightmap, *size);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshHemiSphere(float radius, int rings, int slices, Mesh *__return) {
  Mesh ____ret = GenMeshHemiSphere(radius, rings, slices);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshKnot(float radius, float size, int radSeg, int sides, Mesh *__return) {
  Mesh ____ret = GenMeshKnot(radius, size, radSeg, sides);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshPlane(float width, float length, int resX, int resZ, Mesh *__return) {
  Mesh ____ret = GenMeshPlane(width, length, resX, resZ);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshPoly(int sides, float radius, Mesh *__return) {
  Mesh ____ret = GenMeshPoly(sides, radius);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshSphere(float radius, int rings, int slices, Mesh *__return) {
  Mesh ____ret = GenMeshSphere(radius, rings, slices);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GenMeshTorus(float radius, float size, int radSeg, int sides, Mesh *__return) {
  Mesh ____ret = GenMeshTorus(radius, size, radSeg, sides);
  memcpy(__return, &____ret, sizeof(Mesh));
}

void __sn_wrap_GetCameraMatrix(Camera *camera, Matrix *__return) {
  Matrix ____ret = GetCameraMatrix(*camera);
  memcpy(__return, &____ret, sizeof(Matrix));
}

void __sn_wrap_GetCameraMatrix2D(Camera2D *camera, Matrix *__return) {
  Matrix ____ret = GetCameraMatrix2D(*camera);
  memcpy(__return, &____ret, sizeof(Matrix));
}

void __sn_wrap_GetCollisionRec(Rectangle *rec1, Rectangle *rec2, Rectangle *__return) {
  Rectangle ____ret = GetCollisionRec(*rec1, *rec2);
  memcpy(__return, &____ret, sizeof(Rectangle));
}

void __sn_wrap_GetColor(unsigned int hexValue, Color *__return) {
  Color ____ret = GetColor(hexValue);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_GetFontDefault(Font *__return) {
  Font ____ret = GetFontDefault();
  memcpy(__return, &____ret, sizeof(Font));
}

void __sn_wrap_GetGestureDragVector(Vector2 *__return) {
  Vector2 ____ret = GetGestureDragVector();
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetGesturePinchVector(Vector2 *__return) {
  Vector2 ____ret = GetGesturePinchVector();
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetGlyphAtlasRec(Font *font, int codepoint, Rectangle *__return) {
  Rectangle ____ret = GetGlyphAtlasRec(*font, codepoint);
  memcpy(__return, &____ret, sizeof(Rectangle));
}

int __sn_wrap_GetGlyphIndex(Font *font, int codepoint) {
 return GetGlyphIndex(*font, codepoint);
};

void __sn_wrap_GetGlyphInfo(Font *font, int codepoint, GlyphInfo *__return) {
  GlyphInfo ____ret = GetGlyphInfo(*font, codepoint);
  memcpy(__return, &____ret, sizeof(GlyphInfo));
}

void __sn_wrap_GetImageAlphaBorder(Image *image, float threshold, Rectangle *__return) {
  Rectangle ____ret = GetImageAlphaBorder(*image, threshold);
  memcpy(__return, &____ret, sizeof(Rectangle));
}

void __sn_wrap_GetImageColor(Image *image, int x, int y, Color *__return) {
  Color ____ret = GetImageColor(*image, x, y);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_GetMeshBoundingBox(Mesh *mesh, BoundingBox *__return) {
  BoundingBox ____ret = GetMeshBoundingBox(*mesh);
  memcpy(__return, &____ret, sizeof(BoundingBox));
}

void __sn_wrap_GetModelBoundingBox(Model *model, BoundingBox *__return) {
  BoundingBox ____ret = GetModelBoundingBox(*model);
  memcpy(__return, &____ret, sizeof(BoundingBox));
}

void __sn_wrap_GetMonitorPosition(int monitor, Vector2 *__return) {
  Vector2 ____ret = GetMonitorPosition(monitor);
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetMouseDelta(Vector2 *__return) {
  Vector2 ____ret = GetMouseDelta();
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetMousePosition(Vector2 *__return) {
  Vector2 ____ret = GetMousePosition();
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetMouseRay(Vector2 *mousePosition, Camera *camera, Ray *__return) {
  Ray ____ret = GetMouseRay(*mousePosition, *camera);
  memcpy(__return, &____ret, sizeof(Ray));
}

float __sn_wrap_GetMusicTimeLength(Music *music) {
 return GetMusicTimeLength(*music);
};

float __sn_wrap_GetMusicTimePlayed(Music *music) {
 return GetMusicTimePlayed(*music);
};

void __sn_wrap_GetPixelColor(void * srcPtr, int format, Color *__return) {
  Color ____ret = GetPixelColor(srcPtr, format);
  memcpy(__return, &____ret, sizeof(Color));
}

void __sn_wrap_GetRayCollisionBox(Ray *ray, BoundingBox *box, RayCollision *__return) {
  RayCollision ____ret = GetRayCollisionBox(*ray, *box);
  memcpy(__return, &____ret, sizeof(RayCollision));
}

void __sn_wrap_GetRayCollisionMesh(Ray *ray, Mesh *mesh, Matrix *transform, RayCollision *__return) {
  RayCollision ____ret = GetRayCollisionMesh(*ray, *mesh, *transform);
  memcpy(__return, &____ret, sizeof(RayCollision));
}

void __sn_wrap_GetRayCollisionModel(Ray *ray, Model *model, RayCollision *__return) {
  RayCollision ____ret = GetRayCollisionModel(*ray, *model);
  memcpy(__return, &____ret, sizeof(RayCollision));
}

void __sn_wrap_GetRayCollisionQuad(Ray *ray, Vector3 *p1, Vector3 *p2, Vector3 *p3, Vector3 *p4, RayCollision *__return) {
  RayCollision ____ret = GetRayCollisionQuad(*ray, *p1, *p2, *p3, *p4);
  memcpy(__return, &____ret, sizeof(RayCollision));
}

void __sn_wrap_GetRayCollisionSphere(Ray *ray, Vector3 *center, float radius, RayCollision *__return) {
  RayCollision ____ret = GetRayCollisionSphere(*ray, *center, radius);
  memcpy(__return, &____ret, sizeof(RayCollision));
}

void __sn_wrap_GetRayCollisionTriangle(Ray *ray, Vector3 *p1, Vector3 *p2, Vector3 *p3, RayCollision *__return) {
  RayCollision ____ret = GetRayCollisionTriangle(*ray, *p1, *p2, *p3);
  memcpy(__return, &____ret, sizeof(RayCollision));
}

void __sn_wrap_GetScreenToWorld2D(Vector2 *position, Camera2D *camera, Vector2 *__return) {
  Vector2 ____ret = GetScreenToWorld2D(*position, *camera);
  memcpy(__return, &____ret, sizeof(Vector2));
}

int __sn_wrap_GetShaderLocation(Shader *shader, const char * uniformName) {
 return GetShaderLocation(*shader, uniformName);
};

int __sn_wrap_GetShaderLocationAttrib(Shader *shader, const char * attribName) {
 return GetShaderLocationAttrib(*shader, attribName);
};

void __sn_wrap_GetTouchPosition(int index, Vector2 *__return) {
  Vector2 ____ret = GetTouchPosition(index);
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetWindowPosition(Vector2 *__return) {
  Vector2 ____ret = GetWindowPosition();
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetWindowScaleDPI(Vector2 *__return) {
  Vector2 ____ret = GetWindowScaleDPI();
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetWorldToScreen(Vector3 *position, Camera *camera, Vector2 *__return) {
  Vector2 ____ret = GetWorldToScreen(*position, *camera);
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetWorldToScreen2D(Vector2 *position, Camera2D *camera, Vector2 *__return) {
  Vector2 ____ret = GetWorldToScreen2D(*position, *camera);
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_GetWorldToScreenEx(Vector3 *position, Camera *camera, int width, int height, Vector2 *__return) {
  Vector2 ____ret = GetWorldToScreenEx(*position, *camera, width, height);
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_ImageAlphaClear(Image * image, Color *color, float threshold) {
 ImageAlphaClear(image, *color, threshold);
};

void __sn_wrap_ImageAlphaMask(Image * image, Image *alphaMask) {
 ImageAlphaMask(image, *alphaMask);
};

void __sn_wrap_ImageClearBackground(Image * dst, Color *color) {
 ImageClearBackground(dst, *color);
};

void __sn_wrap_ImageColorReplace(Image * image, Color *color, Color *replace) {
 ImageColorReplace(image, *color, *replace);
};

void __sn_wrap_ImageColorTint(Image * image, Color *color) {
 ImageColorTint(image, *color);
};

void __sn_wrap_ImageCopy(Image *image, Image *__return) {
  Image ____ret = ImageCopy(*image);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_ImageCrop(Image * image, Rectangle *crop) {
 ImageCrop(image, *crop);
};

void __sn_wrap_ImageDraw(Image * dst, Image *src, Rectangle *srcRec, Rectangle *dstRec, Color *tint) {
 ImageDraw(dst, *src, *srcRec, *dstRec, *tint);
};

void __sn_wrap_ImageDrawCircle(Image * dst, int centerX, int centerY, int radius, Color *color) {
 ImageDrawCircle(dst, centerX, centerY, radius, *color);
};

void __sn_wrap_ImageDrawCircleV(Image * dst, Vector2 *center, int radius, Color *color) {
 ImageDrawCircleV(dst, *center, radius, *color);
};

void __sn_wrap_ImageDrawLine(Image * dst, int startPosX, int startPosY, int endPosX, int endPosY, Color *color) {
 ImageDrawLine(dst, startPosX, startPosY, endPosX, endPosY, *color);
};

void __sn_wrap_ImageDrawLineV(Image * dst, Vector2 *start, Vector2 *end, Color *color) {
 ImageDrawLineV(dst, *start, *end, *color);
};

void __sn_wrap_ImageDrawPixel(Image * dst, int posX, int posY, Color *color) {
 ImageDrawPixel(dst, posX, posY, *color);
};

void __sn_wrap_ImageDrawPixelV(Image * dst, Vector2 *position, Color *color) {
 ImageDrawPixelV(dst, *position, *color);
};

void __sn_wrap_ImageDrawRectangle(Image * dst, int posX, int posY, int width, int height, Color *color) {
 ImageDrawRectangle(dst, posX, posY, width, height, *color);
};

void __sn_wrap_ImageDrawRectangleLines(Image * dst, Rectangle *rec, int thick, Color *color) {
 ImageDrawRectangleLines(dst, *rec, thick, *color);
};

void __sn_wrap_ImageDrawRectangleRec(Image * dst, Rectangle *rec, Color *color) {
 ImageDrawRectangleRec(dst, *rec, *color);
};

void __sn_wrap_ImageDrawRectangleV(Image * dst, Vector2 *position, Vector2 *size, Color *color) {
 ImageDrawRectangleV(dst, *position, *size, *color);
};

void __sn_wrap_ImageDrawText(Image * dst, const char * text, int posX, int posY, int fontSize, Color *color) {
 ImageDrawText(dst, text, posX, posY, fontSize, *color);
};

void __sn_wrap_ImageDrawTextEx(Image * dst, Font *font, const char * text, Vector2 *position, float fontSize, float spacing, Color *tint) {
 ImageDrawTextEx(dst, *font, text, *position, fontSize, spacing, *tint);
};

void __sn_wrap_ImageFromImage(Image *image, Rectangle *rec, Image *__return) {
  Image ____ret = ImageFromImage(*image, *rec);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_ImageResizeCanvas(Image * image, int newWidth, int newHeight, int offsetX, int offsetY, Color *fill) {
 ImageResizeCanvas(image, newWidth, newHeight, offsetX, offsetY, *fill);
};

void __sn_wrap_ImageText(const char * text, int fontSize, Color *color, Image *__return) {
  Image ____ret = ImageText(text, fontSize, *color);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_ImageTextEx(Font *font, const char * text, float fontSize, float spacing, Color *tint, Image *__return) {
  Image ____ret = ImageTextEx(*font, text, fontSize, spacing, *tint);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_ImageToPOT(Image * image, Color *fill) {
 ImageToPOT(image, *fill);
};

void __sn_wrap_LoadAudioStream(unsigned int sampleRate, unsigned int sampleSize, unsigned int channels, AudioStream *__return) {
  AudioStream ____ret = LoadAudioStream(sampleRate, sampleSize, channels);
  memcpy(__return, &____ret, sizeof(AudioStream));
}

void __sn_wrap_LoadFont(const char * fileName, Font *__return) {
  Font ____ret = LoadFont(fileName);
  memcpy(__return, &____ret, sizeof(Font));
}

void __sn_wrap_LoadFontEx(const char * fileName, int fontSize, int * fontChars, int glyphCount, Font *__return) {
  Font ____ret = LoadFontEx(fileName, fontSize, fontChars, glyphCount);
  memcpy(__return, &____ret, sizeof(Font));
}

void __sn_wrap_LoadFontFromImage(Image *image, Color *key, int firstChar, Font *__return) {
  Font ____ret = LoadFontFromImage(*image, *key, firstChar);
  memcpy(__return, &____ret, sizeof(Font));
}

void __sn_wrap_LoadFontFromMemory(const char * fileType, const unsigned char * fileData, int dataSize, int fontSize, int * fontChars, int glyphCount, Font *__return) {
  Font ____ret = LoadFontFromMemory(fileType, fileData, dataSize, fontSize, fontChars, glyphCount);
  memcpy(__return, &____ret, sizeof(Font));
}

void __sn_wrap_LoadImage(const char * fileName, Image *__return) {
  Image ____ret = LoadImage(fileName);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_LoadImageAnim(const char * fileName, int * frames, Image *__return) {
  Image ____ret = LoadImageAnim(fileName, frames);
  memcpy(__return, &____ret, sizeof(Image));
}

Color * __sn_wrap_LoadImageColors(Image *image) {
 return LoadImageColors(*image);
};

void __sn_wrap_LoadImageFromMemory(const char * fileType, const unsigned char * fileData, int dataSize, Image *__return) {
  Image ____ret = LoadImageFromMemory(fileType, fileData, dataSize);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_LoadImageFromScreen(Image *__return) {
  Image ____ret = LoadImageFromScreen();
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_LoadImageFromTexture(Texture2D *texture, Image *__return) {
  Image ____ret = LoadImageFromTexture(*texture);
  memcpy(__return, &____ret, sizeof(Image));
}

Color * __sn_wrap_LoadImagePalette(Image *image, int maxPaletteSize, int * colorCount) {
 return LoadImagePalette(*image, maxPaletteSize, colorCount);
};

void __sn_wrap_LoadImageRaw(const char * fileName, int width, int height, int format, int headerSize, Image *__return) {
  Image ____ret = LoadImageRaw(fileName, width, height, format, headerSize);
  memcpy(__return, &____ret, sizeof(Image));
}

void __sn_wrap_LoadMaterialDefault(Material *__return) {
  Material ____ret = LoadMaterialDefault();
  memcpy(__return, &____ret, sizeof(Material));
}

void __sn_wrap_LoadModel(const char * fileName, Model *__return) {
  Model ____ret = LoadModel(fileName);
  memcpy(__return, &____ret, sizeof(Model));
}

void __sn_wrap_LoadModelFromMesh(Mesh *mesh, Model *__return) {
  Model ____ret = LoadModelFromMesh(*mesh);
  memcpy(__return, &____ret, sizeof(Model));
}

void __sn_wrap_LoadMusicStream(const char * fileName, Music *__return) {
  Music ____ret = LoadMusicStream(fileName);
  memcpy(__return, &____ret, sizeof(Music));
}

void __sn_wrap_LoadMusicStreamFromMemory(const char * fileType, unsigned char * data, int dataSize, Music *__return) {
  Music ____ret = LoadMusicStreamFromMemory(fileType, data, dataSize);
  memcpy(__return, &____ret, sizeof(Music));
}

void __sn_wrap_LoadRenderTexture(int width, int height, RenderTexture2D *__return) {
  RenderTexture2D ____ret = LoadRenderTexture(width, height);
  memcpy(__return, &____ret, sizeof(RenderTexture2D));
}

void __sn_wrap_LoadShader(const char * vsFileName, const char * fsFileName, Shader *__return) {
  Shader ____ret = LoadShader(vsFileName, fsFileName);
  memcpy(__return, &____ret, sizeof(Shader));
}

void __sn_wrap_LoadShaderFromMemory(const char * vsCode, const char * fsCode, Shader *__return) {
  Shader ____ret = LoadShaderFromMemory(vsCode, fsCode);
  memcpy(__return, &____ret, sizeof(Shader));
}

void __sn_wrap_LoadSound(const char * fileName, Sound *__return) {
  Sound ____ret = LoadSound(fileName);
  memcpy(__return, &____ret, sizeof(Sound));
}

void __sn_wrap_LoadSoundFromWave(Wave *wave, Sound *__return) {
  Sound ____ret = LoadSoundFromWave(*wave);
  memcpy(__return, &____ret, sizeof(Sound));
}

void __sn_wrap_LoadTexture(const char * fileName, Texture2D *__return) {
  Texture2D ____ret = LoadTexture(fileName);
  memcpy(__return, &____ret, sizeof(Texture2D));
}

void __sn_wrap_LoadTextureCubemap(Image *image, int layout, TextureCubemap *__return) {
  TextureCubemap ____ret = LoadTextureCubemap(*image, layout);
  memcpy(__return, &____ret, sizeof(TextureCubemap));
}

void __sn_wrap_LoadTextureFromImage(Image *image, Texture2D *__return) {
  Texture2D ____ret = LoadTextureFromImage(*image);
  memcpy(__return, &____ret, sizeof(Texture2D));
}

void __sn_wrap_LoadVrStereoConfig(VrDeviceInfo *device, VrStereoConfig *__return) {
  VrStereoConfig ____ret = LoadVrStereoConfig(*device);
  memcpy(__return, &____ret, sizeof(VrStereoConfig));
}

void __sn_wrap_LoadWave(const char * fileName, Wave *__return) {
  Wave ____ret = LoadWave(fileName);
  memcpy(__return, &____ret, sizeof(Wave));
}

void __sn_wrap_LoadWaveFromMemory(const char * fileType, const unsigned char * fileData, int dataSize, Wave *__return) {
  Wave ____ret = LoadWaveFromMemory(fileType, fileData, dataSize);
  memcpy(__return, &____ret, sizeof(Wave));
}

float * __sn_wrap_LoadWaveSamples(Wave *wave) {
 return LoadWaveSamples(*wave);
};

void __sn_wrap_MeasureTextEx(Font *font, const char * text, float fontSize, float spacing, Vector2 *__return) {
  Vector2 ____ret = MeasureTextEx(*font, text, fontSize, spacing);
  memcpy(__return, &____ret, sizeof(Vector2));
}

void __sn_wrap_PauseAudioStream(AudioStream *stream) {
 PauseAudioStream(*stream);
};

void __sn_wrap_PauseMusicStream(Music *music) {
 PauseMusicStream(*music);
};

void __sn_wrap_PauseSound(Sound *sound) {
 PauseSound(*sound);
};

void __sn_wrap_PlayAudioStream(AudioStream *stream) {
 PlayAudioStream(*stream);
};

void __sn_wrap_PlayMusicStream(Music *music) {
 PlayMusicStream(*music);
};

void __sn_wrap_PlaySound(Sound *sound) {
 PlaySound(*sound);
};

void __sn_wrap_PlaySoundMulti(Sound *sound) {
 PlaySoundMulti(*sound);
};

void __sn_wrap_ResumeAudioStream(AudioStream *stream) {
 ResumeAudioStream(*stream);
};

void __sn_wrap_ResumeMusicStream(Music *music) {
 ResumeMusicStream(*music);
};

void __sn_wrap_ResumeSound(Sound *sound) {
 ResumeSound(*sound);
};

void __sn_wrap_SeekMusicStream(Music *music, float position) {
 SeekMusicStream(*music, position);
};

void __sn_wrap_SetAudioStreamPitch(AudioStream *stream, float pitch) {
 SetAudioStreamPitch(*stream, pitch);
};

void __sn_wrap_SetAudioStreamVolume(AudioStream *stream, float volume) {
 SetAudioStreamVolume(*stream, volume);
};

void __sn_wrap_SetCameraMode(Camera *camera, int mode) {
 SetCameraMode(*camera, mode);
};

void __sn_wrap_SetMaterialTexture(Material * material, int mapType, Texture2D *texture) {
 SetMaterialTexture(material, mapType, *texture);
};

void __sn_wrap_SetMusicPitch(Music *music, float pitch) {
 SetMusicPitch(*music, pitch);
};

void __sn_wrap_SetMusicVolume(Music *music, float volume) {
 SetMusicVolume(*music, volume);
};

void __sn_wrap_SetPixelColor(void * dstPtr, Color *color, int format) {
 SetPixelColor(dstPtr, *color, format);
};

void __sn_wrap_SetShaderValue(Shader *shader, int locIndex, const void * value, int uniformType) {
 SetShaderValue(*shader, locIndex, value, uniformType);
};

void __sn_wrap_SetShaderValueMatrix(Shader *shader, int locIndex, Matrix *mat) {
 SetShaderValueMatrix(*shader, locIndex, *mat);
};

void __sn_wrap_SetShaderValueTexture(Shader *shader, int locIndex, Texture2D *texture) {
 SetShaderValueTexture(*shader, locIndex, *texture);
};

void __sn_wrap_SetShaderValueV(Shader *shader, int locIndex, const void * value, int uniformType, int count) {
 SetShaderValueV(*shader, locIndex, value, uniformType, count);
};

void __sn_wrap_SetShapesTexture(Texture2D *texture, Rectangle *source) {
 SetShapesTexture(*texture, *source);
};

void __sn_wrap_SetSoundPitch(Sound *sound, float pitch) {
 SetSoundPitch(*sound, pitch);
};

void __sn_wrap_SetSoundVolume(Sound *sound, float volume) {
 SetSoundVolume(*sound, volume);
};

void __sn_wrap_SetTextureFilter(Texture2D *texture, int filter) {
 SetTextureFilter(*texture, filter);
};

void __sn_wrap_SetTextureWrap(Texture2D *texture, int wrap) {
 SetTextureWrap(*texture, wrap);
};

void __sn_wrap_SetWindowIcon(Image *image) {
 SetWindowIcon(*image);
};

void __sn_wrap_StopAudioStream(AudioStream *stream) {
 StopAudioStream(*stream);
};

void __sn_wrap_StopMusicStream(Music *music) {
 StopMusicStream(*music);
};

void __sn_wrap_StopSound(Sound *sound) {
 StopSound(*sound);
};

void __sn_wrap_UnloadAudioStream(AudioStream *stream) {
 UnloadAudioStream(*stream);
};

void __sn_wrap_UnloadFont(Font *font) {
 UnloadFont(*font);
};

void __sn_wrap_UnloadImage(Image *image) {
 UnloadImage(*image);
};

void __sn_wrap_UnloadMaterial(Material *material) {
 UnloadMaterial(*material);
};

void __sn_wrap_UnloadMesh(Mesh *mesh) {
 UnloadMesh(*mesh);
};

void __sn_wrap_UnloadModel(Model *model) {
 UnloadModel(*model);
};

void __sn_wrap_UnloadModelAnimation(ModelAnimation *anim) {
 UnloadModelAnimation(*anim);
};

void __sn_wrap_UnloadModelKeepMeshes(Model *model) {
 UnloadModelKeepMeshes(*model);
};

void __sn_wrap_UnloadMusicStream(Music *music) {
 UnloadMusicStream(*music);
};

void __sn_wrap_UnloadRenderTexture(RenderTexture2D *target) {
 UnloadRenderTexture(*target);
};

void __sn_wrap_UnloadShader(Shader *shader) {
 UnloadShader(*shader);
};

void __sn_wrap_UnloadSound(Sound *sound) {
 UnloadSound(*sound);
};

void __sn_wrap_UnloadTexture(Texture2D *texture) {
 UnloadTexture(*texture);
};

void __sn_wrap_UnloadVrStereoConfig(VrStereoConfig *config) {
 UnloadVrStereoConfig(*config);
};

void __sn_wrap_UnloadWave(Wave *wave) {
 UnloadWave(*wave);
};

void __sn_wrap_UpdateAudioStream(AudioStream *stream, const void * data, int frameCount) {
 UpdateAudioStream(*stream, data, frameCount);
};

void __sn_wrap_UpdateMeshBuffer(Mesh *mesh, int index, void * data, int dataSize, int offset) {
 UpdateMeshBuffer(*mesh, index, data, dataSize, offset);
};

void __sn_wrap_UpdateModelAnimation(Model *model, ModelAnimation *anim, int frame) {
 UpdateModelAnimation(*model, *anim, frame);
};

void __sn_wrap_UpdateMusicStream(Music *music) {
 UpdateMusicStream(*music);
};

void __sn_wrap_UpdateSound(Sound *sound, const void * data, int sampleCount) {
 UpdateSound(*sound, data, sampleCount);
};

void __sn_wrap_UpdateTexture(Texture2D *texture, const void * pixels) {
 UpdateTexture(*texture, pixels);
};

void __sn_wrap_UpdateTextureRec(Texture2D *texture, Rectangle *rec, const void * pixels) {
 UpdateTextureRec(*texture, *rec, pixels);
};

void __sn_wrap_WaveCopy(Wave *wave, Wave *__return) {
  Wave ____ret = WaveCopy(*wave);
  memcpy(__return, &____ret, sizeof(Wave));
}


