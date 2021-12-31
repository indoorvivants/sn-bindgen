package libraylib

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:  
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)
  
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
      
object types:
  import predef.*
  opaque type BlendMode = CUnsignedInt
  object BlendMode extends CEnumU[BlendMode]:
    inline def define(inline a: Long): BlendMode = a.toUInt
    val BLEND_ALPHA = define(0)
    val BLEND_ADDITIVE = define(1)
    val BLEND_MULTIPLIED = define(2)
    val BLEND_ADD_COLORS = define(3)
    val BLEND_SUBTRACT_COLORS = define(4)
    val BLEND_CUSTOM = define(5)

  opaque type CameraMode = CUnsignedInt
  object CameraMode extends CEnumU[CameraMode]:
    inline def define(inline a: Long): CameraMode = a.toUInt
    val CAMERA_CUSTOM = define(0)
    val CAMERA_FREE = define(1)
    val CAMERA_ORBITAL = define(2)
    val CAMERA_FIRST_PERSON = define(3)
    val CAMERA_THIRD_PERSON = define(4)

  opaque type CameraProjection = CUnsignedInt
  object CameraProjection extends CEnumU[CameraProjection]:
    inline def define(inline a: Long): CameraProjection = a.toUInt
    val CAMERA_PERSPECTIVE = define(0)
    val CAMERA_ORTHOGRAPHIC = define(1)

  opaque type ConfigFlags = CUnsignedInt
  object ConfigFlags extends CEnumU[ConfigFlags]:
    inline def define(inline a: Long): ConfigFlags = a.toUInt
    val FLAG_VSYNC_HINT = define(64)
    val FLAG_FULLSCREEN_MODE = define(2)
    val FLAG_WINDOW_RESIZABLE = define(4)
    val FLAG_WINDOW_UNDECORATED = define(8)
    val FLAG_WINDOW_HIDDEN = define(128)
    val FLAG_WINDOW_MINIMIZED = define(512)
    val FLAG_WINDOW_MAXIMIZED = define(1024)
    val FLAG_WINDOW_UNFOCUSED = define(2048)
    val FLAG_WINDOW_TOPMOST = define(4096)
    val FLAG_WINDOW_ALWAYS_RUN = define(256)
    val FLAG_WINDOW_TRANSPARENT = define(16)
    val FLAG_WINDOW_HIGHDPI = define(8192)
    val FLAG_MSAA_4X_HINT = define(32)
    val FLAG_INTERLACED_HINT = define(65536)

  opaque type CubemapLayout = CUnsignedInt
  object CubemapLayout extends CEnumU[CubemapLayout]:
    inline def define(inline a: Long): CubemapLayout = a.toUInt
    val CUBEMAP_LAYOUT_AUTO_DETECT = define(0)
    val CUBEMAP_LAYOUT_LINE_VERTICAL = define(1)
    val CUBEMAP_LAYOUT_LINE_HORIZONTAL = define(2)
    val CUBEMAP_LAYOUT_CROSS_THREE_BY_FOUR = define(3)
    val CUBEMAP_LAYOUT_CROSS_FOUR_BY_THREE = define(4)
    val CUBEMAP_LAYOUT_PANORAMA = define(5)

  opaque type FontType = CUnsignedInt
  object FontType extends CEnumU[FontType]:
    inline def define(inline a: Long): FontType = a.toUInt
    val FONT_DEFAULT = define(0)
    val FONT_BITMAP = define(1)
    val FONT_SDF = define(2)

  opaque type GamepadAxis = CUnsignedInt
  object GamepadAxis extends CEnumU[GamepadAxis]:
    inline def define(inline a: Long): GamepadAxis = a.toUInt
    val GAMEPAD_AXIS_LEFT_X = define(0)
    val GAMEPAD_AXIS_LEFT_Y = define(1)
    val GAMEPAD_AXIS_RIGHT_X = define(2)
    val GAMEPAD_AXIS_RIGHT_Y = define(3)
    val GAMEPAD_AXIS_LEFT_TRIGGER = define(4)
    val GAMEPAD_AXIS_RIGHT_TRIGGER = define(5)

  opaque type GamepadButton = CUnsignedInt
  object GamepadButton extends CEnumU[GamepadButton]:
    inline def define(inline a: Long): GamepadButton = a.toUInt
    val GAMEPAD_BUTTON_UNKNOWN = define(0)
    val GAMEPAD_BUTTON_LEFT_FACE_UP = define(1)
    val GAMEPAD_BUTTON_LEFT_FACE_RIGHT = define(2)
    val GAMEPAD_BUTTON_LEFT_FACE_DOWN = define(3)
    val GAMEPAD_BUTTON_LEFT_FACE_LEFT = define(4)
    val GAMEPAD_BUTTON_RIGHT_FACE_UP = define(5)
    val GAMEPAD_BUTTON_RIGHT_FACE_RIGHT = define(6)
    val GAMEPAD_BUTTON_RIGHT_FACE_DOWN = define(7)
    val GAMEPAD_BUTTON_RIGHT_FACE_LEFT = define(8)
    val GAMEPAD_BUTTON_LEFT_TRIGGER_1 = define(9)
    val GAMEPAD_BUTTON_LEFT_TRIGGER_2 = define(10)
    val GAMEPAD_BUTTON_RIGHT_TRIGGER_1 = define(11)
    val GAMEPAD_BUTTON_RIGHT_TRIGGER_2 = define(12)
    val GAMEPAD_BUTTON_MIDDLE_LEFT = define(13)
    val GAMEPAD_BUTTON_MIDDLE = define(14)
    val GAMEPAD_BUTTON_MIDDLE_RIGHT = define(15)
    val GAMEPAD_BUTTON_LEFT_THUMB = define(16)
    val GAMEPAD_BUTTON_RIGHT_THUMB = define(17)

  opaque type Gesture = CUnsignedInt
  object Gesture extends CEnumU[Gesture]:
    inline def define(inline a: Long): Gesture = a.toUInt
    val GESTURE_NONE = define(0)
    val GESTURE_TAP = define(1)
    val GESTURE_DOUBLETAP = define(2)
    val GESTURE_HOLD = define(4)
    val GESTURE_DRAG = define(8)
    val GESTURE_SWIPE_RIGHT = define(16)
    val GESTURE_SWIPE_LEFT = define(32)
    val GESTURE_SWIPE_UP = define(64)
    val GESTURE_SWIPE_DOWN = define(128)
    val GESTURE_PINCH_IN = define(256)
    val GESTURE_PINCH_OUT = define(512)

  opaque type KeyboardKey = CUnsignedInt
  object KeyboardKey extends CEnumU[KeyboardKey]:
    inline def define(inline a: Long): KeyboardKey = a.toUInt
    val KEY_NULL = define(0)
    val KEY_APOSTROPHE = define(39)
    val KEY_COMMA = define(44)
    val KEY_MINUS = define(45)
    val KEY_PERIOD = define(46)
    val KEY_SLASH = define(47)
    val KEY_ZERO = define(48)
    val KEY_ONE = define(49)
    val KEY_TWO = define(50)
    val KEY_THREE = define(51)
    val KEY_FOUR = define(52)
    val KEY_FIVE = define(53)
    val KEY_SIX = define(54)
    val KEY_SEVEN = define(55)
    val KEY_EIGHT = define(56)
    val KEY_NINE = define(57)
    val KEY_SEMICOLON = define(59)
    val KEY_EQUAL = define(61)
    val KEY_A = define(65)
    val KEY_B = define(66)
    val KEY_C = define(67)
    val KEY_D = define(68)
    val KEY_E = define(69)
    val KEY_F = define(70)
    val KEY_G = define(71)
    val KEY_H = define(72)
    val KEY_I = define(73)
    val KEY_J = define(74)
    val KEY_K = define(75)
    val KEY_L = define(76)
    val KEY_M = define(77)
    val KEY_N = define(78)
    val KEY_O = define(79)
    val KEY_P = define(80)
    val KEY_Q = define(81)
    val KEY_R = define(82)
    val KEY_S = define(83)
    val KEY_T = define(84)
    val KEY_U = define(85)
    val KEY_V = define(86)
    val KEY_W = define(87)
    val KEY_X = define(88)
    val KEY_Y = define(89)
    val KEY_Z = define(90)
    val KEY_LEFT_BRACKET = define(91)
    val KEY_BACKSLASH = define(92)
    val KEY_RIGHT_BRACKET = define(93)
    val KEY_GRAVE = define(96)
    val KEY_SPACE = define(32)
    val KEY_ESCAPE = define(256)
    val KEY_ENTER = define(257)
    val KEY_TAB = define(258)
    val KEY_BACKSPACE = define(259)
    val KEY_INSERT = define(260)
    val KEY_DELETE = define(261)
    val KEY_RIGHT = define(262)
    val KEY_LEFT = define(263)
    val KEY_DOWN = define(264)
    val KEY_UP = define(265)
    val KEY_PAGE_UP = define(266)
    val KEY_PAGE_DOWN = define(267)
    val KEY_HOME = define(268)
    val KEY_END = define(269)
    val KEY_CAPS_LOCK = define(280)
    val KEY_SCROLL_LOCK = define(281)
    val KEY_NUM_LOCK = define(282)
    val KEY_PRINT_SCREEN = define(283)
    val KEY_PAUSE = define(284)
    val KEY_F1 = define(290)
    val KEY_F2 = define(291)
    val KEY_F3 = define(292)
    val KEY_F4 = define(293)
    val KEY_F5 = define(294)
    val KEY_F6 = define(295)
    val KEY_F7 = define(296)
    val KEY_F8 = define(297)
    val KEY_F9 = define(298)
    val KEY_F10 = define(299)
    val KEY_F11 = define(300)
    val KEY_F12 = define(301)
    val KEY_LEFT_SHIFT = define(340)
    val KEY_LEFT_CONTROL = define(341)
    val KEY_LEFT_ALT = define(342)
    val KEY_LEFT_SUPER = define(343)
    val KEY_RIGHT_SHIFT = define(344)
    val KEY_RIGHT_CONTROL = define(345)
    val KEY_RIGHT_ALT = define(346)
    val KEY_RIGHT_SUPER = define(347)
    val KEY_KB_MENU = define(348)
    val KEY_KP_0 = define(320)
    val KEY_KP_1 = define(321)
    val KEY_KP_2 = define(322)
    val KEY_KP_3 = define(323)
    val KEY_KP_4 = define(324)
    val KEY_KP_5 = define(325)
    val KEY_KP_6 = define(326)
    val KEY_KP_7 = define(327)
    val KEY_KP_8 = define(328)
    val KEY_KP_9 = define(329)
    val KEY_KP_DECIMAL = define(330)
    val KEY_KP_DIVIDE = define(331)
    val KEY_KP_MULTIPLY = define(332)
    val KEY_KP_SUBTRACT = define(333)
    val KEY_KP_ADD = define(334)
    val KEY_KP_ENTER = define(335)
    val KEY_KP_EQUAL = define(336)
    val KEY_BACK = define(4)
    val KEY_MENU = define(82)
    val KEY_VOLUME_UP = define(24)
    val KEY_VOLUME_DOWN = define(25)

  opaque type MaterialMapIndex = CUnsignedInt
  object MaterialMapIndex extends CEnumU[MaterialMapIndex]:
    inline def define(inline a: Long): MaterialMapIndex = a.toUInt
    val MATERIAL_MAP_ALBEDO = define(0)
    val MATERIAL_MAP_METALNESS = define(1)
    val MATERIAL_MAP_NORMAL = define(2)
    val MATERIAL_MAP_ROUGHNESS = define(3)
    val MATERIAL_MAP_OCCLUSION = define(4)
    val MATERIAL_MAP_EMISSION = define(5)
    val MATERIAL_MAP_HEIGHT = define(6)
    val MATERIAL_MAP_CUBEMAP = define(7)
    val MATERIAL_MAP_IRRADIANCE = define(8)
    val MATERIAL_MAP_PREFILTER = define(9)
    val MATERIAL_MAP_BRDF = define(10)

  opaque type MouseButton = CUnsignedInt
  object MouseButton extends CEnumU[MouseButton]:
    inline def define(inline a: Long): MouseButton = a.toUInt
    val MOUSE_BUTTON_LEFT = define(0)
    val MOUSE_BUTTON_RIGHT = define(1)
    val MOUSE_BUTTON_MIDDLE = define(2)
    val MOUSE_BUTTON_SIDE = define(3)
    val MOUSE_BUTTON_EXTRA = define(4)
    val MOUSE_BUTTON_FORWARD = define(5)
    val MOUSE_BUTTON_BACK = define(6)

  opaque type MouseCursor = CUnsignedInt
  object MouseCursor extends CEnumU[MouseCursor]:
    inline def define(inline a: Long): MouseCursor = a.toUInt
    val MOUSE_CURSOR_DEFAULT = define(0)
    val MOUSE_CURSOR_ARROW = define(1)
    val MOUSE_CURSOR_IBEAM = define(2)
    val MOUSE_CURSOR_CROSSHAIR = define(3)
    val MOUSE_CURSOR_POINTING_HAND = define(4)
    val MOUSE_CURSOR_RESIZE_EW = define(5)
    val MOUSE_CURSOR_RESIZE_NS = define(6)
    val MOUSE_CURSOR_RESIZE_NWSE = define(7)
    val MOUSE_CURSOR_RESIZE_NESW = define(8)
    val MOUSE_CURSOR_RESIZE_ALL = define(9)
    val MOUSE_CURSOR_NOT_ALLOWED = define(10)

  opaque type NPatchLayout = CUnsignedInt
  object NPatchLayout extends CEnumU[NPatchLayout]:
    inline def define(inline a: Long): NPatchLayout = a.toUInt
    val NPATCH_NINE_PATCH = define(0)
    val NPATCH_THREE_PATCH_VERTICAL = define(1)
    val NPATCH_THREE_PATCH_HORIZONTAL = define(2)

  opaque type PixelFormat = CUnsignedInt
  object PixelFormat extends CEnumU[PixelFormat]:
    inline def define(inline a: Long): PixelFormat = a.toUInt
    val PIXELFORMAT_UNCOMPRESSED_GRAYSCALE = define(1)
    val PIXELFORMAT_UNCOMPRESSED_GRAY_ALPHA = define(2)
    val PIXELFORMAT_UNCOMPRESSED_R5G6B5 = define(3)
    val PIXELFORMAT_UNCOMPRESSED_R8G8B8 = define(4)
    val PIXELFORMAT_UNCOMPRESSED_R5G5B5A1 = define(5)
    val PIXELFORMAT_UNCOMPRESSED_R4G4B4A4 = define(6)
    val PIXELFORMAT_UNCOMPRESSED_R8G8B8A8 = define(7)
    val PIXELFORMAT_UNCOMPRESSED_R32 = define(8)
    val PIXELFORMAT_UNCOMPRESSED_R32G32B32 = define(9)
    val PIXELFORMAT_UNCOMPRESSED_R32G32B32A32 = define(10)
    val PIXELFORMAT_COMPRESSED_DXT1_RGB = define(11)
    val PIXELFORMAT_COMPRESSED_DXT1_RGBA = define(12)
    val PIXELFORMAT_COMPRESSED_DXT3_RGBA = define(13)
    val PIXELFORMAT_COMPRESSED_DXT5_RGBA = define(14)
    val PIXELFORMAT_COMPRESSED_ETC1_RGB = define(15)
    val PIXELFORMAT_COMPRESSED_ETC2_RGB = define(16)
    val PIXELFORMAT_COMPRESSED_ETC2_EAC_RGBA = define(17)
    val PIXELFORMAT_COMPRESSED_PVRT_RGB = define(18)
    val PIXELFORMAT_COMPRESSED_PVRT_RGBA = define(19)
    val PIXELFORMAT_COMPRESSED_ASTC_4x4_RGBA = define(20)
    val PIXELFORMAT_COMPRESSED_ASTC_8x8_RGBA = define(21)

  opaque type ShaderAttributeDataType = CUnsignedInt
  object ShaderAttributeDataType extends CEnumU[ShaderAttributeDataType]:
    inline def define(inline a: Long): ShaderAttributeDataType = a.toUInt
    val SHADER_ATTRIB_FLOAT = define(0)
    val SHADER_ATTRIB_VEC2 = define(1)
    val SHADER_ATTRIB_VEC3 = define(2)
    val SHADER_ATTRIB_VEC4 = define(3)

  opaque type ShaderLocationIndex = CUnsignedInt
  object ShaderLocationIndex extends CEnumU[ShaderLocationIndex]:
    inline def define(inline a: Long): ShaderLocationIndex = a.toUInt
    val SHADER_LOC_VERTEX_POSITION = define(0)
    val SHADER_LOC_VERTEX_TEXCOORD01 = define(1)
    val SHADER_LOC_VERTEX_TEXCOORD02 = define(2)
    val SHADER_LOC_VERTEX_NORMAL = define(3)
    val SHADER_LOC_VERTEX_TANGENT = define(4)
    val SHADER_LOC_VERTEX_COLOR = define(5)
    val SHADER_LOC_MATRIX_MVP = define(6)
    val SHADER_LOC_MATRIX_VIEW = define(7)
    val SHADER_LOC_MATRIX_PROJECTION = define(8)
    val SHADER_LOC_MATRIX_MODEL = define(9)
    val SHADER_LOC_MATRIX_NORMAL = define(10)
    val SHADER_LOC_VECTOR_VIEW = define(11)
    val SHADER_LOC_COLOR_DIFFUSE = define(12)
    val SHADER_LOC_COLOR_SPECULAR = define(13)
    val SHADER_LOC_COLOR_AMBIENT = define(14)
    val SHADER_LOC_MAP_ALBEDO = define(15)
    val SHADER_LOC_MAP_METALNESS = define(16)
    val SHADER_LOC_MAP_NORMAL = define(17)
    val SHADER_LOC_MAP_ROUGHNESS = define(18)
    val SHADER_LOC_MAP_OCCLUSION = define(19)
    val SHADER_LOC_MAP_EMISSION = define(20)
    val SHADER_LOC_MAP_HEIGHT = define(21)
    val SHADER_LOC_MAP_CUBEMAP = define(22)
    val SHADER_LOC_MAP_IRRADIANCE = define(23)
    val SHADER_LOC_MAP_PREFILTER = define(24)
    val SHADER_LOC_MAP_BRDF = define(25)

  opaque type ShaderUniformDataType = CUnsignedInt
  object ShaderUniformDataType extends CEnumU[ShaderUniformDataType]:
    inline def define(inline a: Long): ShaderUniformDataType = a.toUInt
    val SHADER_UNIFORM_FLOAT = define(0)
    val SHADER_UNIFORM_VEC2 = define(1)
    val SHADER_UNIFORM_VEC3 = define(2)
    val SHADER_UNIFORM_VEC4 = define(3)
    val SHADER_UNIFORM_INT = define(4)
    val SHADER_UNIFORM_IVEC2 = define(5)
    val SHADER_UNIFORM_IVEC3 = define(6)
    val SHADER_UNIFORM_IVEC4 = define(7)
    val SHADER_UNIFORM_SAMPLER2D = define(8)

  opaque type TextureFilter = CUnsignedInt
  object TextureFilter extends CEnumU[TextureFilter]:
    inline def define(inline a: Long): TextureFilter = a.toUInt
    val TEXTURE_FILTER_POINT = define(0)
    val TEXTURE_FILTER_BILINEAR = define(1)
    val TEXTURE_FILTER_TRILINEAR = define(2)
    val TEXTURE_FILTER_ANISOTROPIC_4X = define(3)
    val TEXTURE_FILTER_ANISOTROPIC_8X = define(4)
    val TEXTURE_FILTER_ANISOTROPIC_16X = define(5)

  opaque type TextureWrap = CUnsignedInt
  object TextureWrap extends CEnumU[TextureWrap]:
    inline def define(inline a: Long): TextureWrap = a.toUInt
    val TEXTURE_WRAP_REPEAT = define(0)
    val TEXTURE_WRAP_CLAMP = define(1)
    val TEXTURE_WRAP_MIRROR_REPEAT = define(2)
    val TEXTURE_WRAP_MIRROR_CLAMP = define(3)

  opaque type TraceLogLevel = CUnsignedInt
  object TraceLogLevel extends CEnumU[TraceLogLevel]:
    inline def define(inline a: Long): TraceLogLevel = a.toUInt
    val LOG_ALL = define(0)
    val LOG_TRACE = define(1)
    val LOG_DEBUG = define(2)
    val LOG_INFO = define(3)
    val LOG_WARNING = define(4)
    val LOG_ERROR = define(5)
    val LOG_FATAL = define(6)
    val LOG_NONE = define(7)
  type Camera = Camera3D
  object Camera: 
    given _tag: Tag[Camera] = Camera3D._tag

  opaque type LoadFileDataCallback = Ptr[CFuncPtr2[CString, Ptr[CUnsignedInt], Ptr[CUnsignedChar]]]
  object LoadFileDataCallback: 
    given _tag: Tag[LoadFileDataCallback] = Tag.Ptr[CFuncPtr2[CString, Ptr[CUnsignedInt], Ptr[CUnsignedChar]]](Tag.materializeCFuncPtr2[CString, Ptr[CUnsignedInt], Ptr[CUnsignedChar]])
    inline def apply(inline o: Ptr[CFuncPtr2[CString, Ptr[CUnsignedInt], Ptr[CUnsignedChar]]]): LoadFileDataCallback = o

  opaque type LoadFileTextCallback = Ptr[CFuncPtr1[CString, CString]]
  object LoadFileTextCallback: 
    given _tag: Tag[LoadFileTextCallback] = Tag.Ptr[CFuncPtr1[CString, CString]](Tag.materializeCFuncPtr1[CString, CString])
    inline def apply(inline o: Ptr[CFuncPtr1[CString, CString]]): LoadFileTextCallback = o

  type Quaternion = Vector4
  object Quaternion: 
    given _tag: Tag[Quaternion] = Vector4._tag

  type RenderTexture2D = RenderTexture
  object RenderTexture2D: 
    given _tag: Tag[RenderTexture2D] = RenderTexture._tag

  opaque type SaveFileTextCallback = Ptr[CFuncPtr2[CString, CString, CInt]]
  object SaveFileTextCallback: 
    given _tag: Tag[SaveFileTextCallback] = Tag.Ptr[CFuncPtr2[CString, CString, CInt]](Tag.materializeCFuncPtr2[CString, CString, CInt])
    inline def apply(inline o: Ptr[CFuncPtr2[CString, CString, CInt]]): SaveFileTextCallback = o

  type Texture2D = Texture
  object Texture2D: 
    given _tag: Tag[Texture2D] = Texture._tag

  type TextureCubemap = Texture
  object TextureCubemap: 
    given _tag: Tag[TextureCubemap] = Texture._tag

  opaque type TraceLogCallback = Ptr[CFuncPtr3[CInt, CString, CInt, Unit]]
  object TraceLogCallback: 
    given _tag: Tag[TraceLogCallback] = Tag.Ptr[CFuncPtr3[CInt, CString, CInt, Unit]](Tag.materializeCFuncPtr3[CInt, CString, CInt, Unit])
    inline def apply(inline o: Ptr[CFuncPtr3[CInt, CString, CInt, Unit]]): TraceLogCallback = o

  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o

  type bool = CFuncPtr1[Ptr[CInt], CInt]
  object bool: 
    given _tag: Tag[bool] = Tag.materializeCFuncPtr1[Ptr[CInt], CInt]
  opaque type AudioStream = CStruct4[Ptr[rAudioBuffer], CUnsignedInt, CUnsignedInt, CUnsignedInt]
  object AudioStream:
    given _tag: Tag[AudioStream] = Tag.materializeCStruct4Tag[Ptr[rAudioBuffer], CUnsignedInt, CUnsignedInt, CUnsignedInt]
    def apply()(using Zone): Ptr[AudioStream] = scala.scalanative.unsafe.alloc[AudioStream](1)
    def apply(buffer: Ptr[rAudioBuffer], sampleRate: CUnsignedInt, sampleSize: CUnsignedInt, channels: CUnsignedInt)(using Zone): Ptr[AudioStream] = 
      val ____ptr = apply()
      (!____ptr).buffer = buffer
      (!____ptr).sampleRate = sampleRate
      (!____ptr).sampleSize = sampleSize
      (!____ptr).channels = channels
      ____ptr
    extension (struct: AudioStream)
      def buffer: Ptr[rAudioBuffer] = struct._1
      def buffer_=(value: Ptr[rAudioBuffer]): Unit = !struct.at1 = value
      def sampleRate: CUnsignedInt = struct._2
      def sampleRate_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def sampleSize: CUnsignedInt = struct._3
      def sampleSize_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def channels: CUnsignedInt = struct._4
      def channels_=(value: CUnsignedInt): Unit = !struct.at4 = value

  opaque type BoneInfo = CStruct2[CArray[CChar, Nat.Digit2[Nat._3, Nat._2]], CInt]
  object BoneInfo:
    given _tag: Tag[BoneInfo] = Tag.materializeCStruct2Tag[CArray[CChar, Nat.Digit2[Nat._3, Nat._2]], CInt]
    def apply()(using Zone): Ptr[BoneInfo] = scala.scalanative.unsafe.alloc[BoneInfo](1)
    def apply(name: CArray[CChar, Nat.Digit2[Nat._3, Nat._2]], parent: CInt)(using Zone): Ptr[BoneInfo] = 
      val ____ptr = apply()
      (!____ptr).name = name
      (!____ptr).parent = parent
      ____ptr
    extension (struct: BoneInfo)
      def name: CArray[CChar, Nat.Digit2[Nat._3, Nat._2]] = struct._1
      def name_=(value: CArray[CChar, Nat.Digit2[Nat._3, Nat._2]]): Unit = !struct.at1 = value
      def parent: CInt = struct._2
      def parent_=(value: CInt): Unit = !struct.at2 = value

  opaque type BoundingBox = CStruct2[Vector3, Vector3]
  object BoundingBox:
    given _tag: Tag[BoundingBox] = Tag.materializeCStruct2Tag[Vector3, Vector3]
    def apply()(using Zone): Ptr[BoundingBox] = scala.scalanative.unsafe.alloc[BoundingBox](1)
    def apply(min: Vector3, max: Vector3)(using Zone): Ptr[BoundingBox] = 
      val ____ptr = apply()
      (!____ptr).min = min
      (!____ptr).max = max
      ____ptr
    extension (struct: BoundingBox)
      def min: Vector3 = struct._1
      def min_=(value: Vector3): Unit = !struct.at1 = value
      def max: Vector3 = struct._2
      def max_=(value: Vector3): Unit = !struct.at2 = value

  opaque type Camera2D = CStruct4[Vector2, Vector2, Float, Float]
  object Camera2D:
    given _tag: Tag[Camera2D] = Tag.materializeCStruct4Tag[Vector2, Vector2, Float, Float]
    def apply()(using Zone): Ptr[Camera2D] = scala.scalanative.unsafe.alloc[Camera2D](1)
    def apply(offset: Vector2, target: Vector2, rotation: Float, zoom: Float)(using Zone): Ptr[Camera2D] = 
      val ____ptr = apply()
      (!____ptr).offset = offset
      (!____ptr).target = target
      (!____ptr).rotation = rotation
      (!____ptr).zoom = zoom
      ____ptr
    extension (struct: Camera2D)
      def offset: Vector2 = struct._1
      def offset_=(value: Vector2): Unit = !struct.at1 = value
      def target: Vector2 = struct._2
      def target_=(value: Vector2): Unit = !struct.at2 = value
      def rotation: Float = struct._3
      def rotation_=(value: Float): Unit = !struct.at3 = value
      def zoom: Float = struct._4
      def zoom_=(value: Float): Unit = !struct.at4 = value

  opaque type Camera3D = CStruct5[Vector3, Vector3, Vector3, Float, CInt]
  object Camera3D:
    given _tag: Tag[Camera3D] = Tag.materializeCStruct5Tag[Vector3, Vector3, Vector3, Float, CInt]
    def apply()(using Zone): Ptr[Camera3D] = scala.scalanative.unsafe.alloc[Camera3D](1)
    def apply(position: Vector3, target: Vector3, up: Vector3, fovy: Float, projection: CInt)(using Zone): Ptr[Camera3D] = 
      val ____ptr = apply()
      (!____ptr).position = position
      (!____ptr).target = target
      (!____ptr).up = up
      (!____ptr).fovy = fovy
      (!____ptr).projection = projection
      ____ptr
    extension (struct: Camera3D)
      def position: Vector3 = struct._1
      def position_=(value: Vector3): Unit = !struct.at1 = value
      def target: Vector3 = struct._2
      def target_=(value: Vector3): Unit = !struct.at2 = value
      def up: Vector3 = struct._3
      def up_=(value: Vector3): Unit = !struct.at3 = value
      def fovy: Float = struct._4
      def fovy_=(value: Float): Unit = !struct.at4 = value
      def projection: CInt = struct._5
      def projection_=(value: CInt): Unit = !struct.at5 = value

  opaque type Color = CStruct4[CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar]
  object Color:
    given _tag: Tag[Color] = Tag.materializeCStruct4Tag[CUnsignedChar, CUnsignedChar, CUnsignedChar, CUnsignedChar]
    def apply()(using Zone): Ptr[Color] = scala.scalanative.unsafe.alloc[Color](1)
    def apply(r: CUnsignedChar, g: CUnsignedChar, b: CUnsignedChar, a: CUnsignedChar)(using Zone): Ptr[Color] = 
      val ____ptr = apply()
      (!____ptr).r = r
      (!____ptr).g = g
      (!____ptr).b = b
      (!____ptr).a = a
      ____ptr
    extension (struct: Color)
      def r: CUnsignedChar = struct._1
      def r_=(value: CUnsignedChar): Unit = !struct.at1 = value
      def g: CUnsignedChar = struct._2
      def g_=(value: CUnsignedChar): Unit = !struct.at2 = value
      def b: CUnsignedChar = struct._3
      def b_=(value: CUnsignedChar): Unit = !struct.at3 = value
      def a: CUnsignedChar = struct._4
      def a_=(value: CUnsignedChar): Unit = !struct.at4 = value

  opaque type Font = CStruct6[CInt, CInt, CInt, Texture2D, Ptr[Rectangle], Ptr[GlyphInfo]]
  object Font:
    given _tag: Tag[Font] = Tag.materializeCStruct6Tag[CInt, CInt, CInt, Texture2D, Ptr[Rectangle], Ptr[GlyphInfo]]
    def apply()(using Zone): Ptr[Font] = scala.scalanative.unsafe.alloc[Font](1)
    def apply(baseSize: CInt, glyphCount: CInt, glyphPadding: CInt, texture: Texture2D, recs: Ptr[Rectangle], glyphs: Ptr[GlyphInfo])(using Zone): Ptr[Font] = 
      val ____ptr = apply()
      (!____ptr).baseSize = baseSize
      (!____ptr).glyphCount = glyphCount
      (!____ptr).glyphPadding = glyphPadding
      (!____ptr).texture = texture
      (!____ptr).recs = recs
      (!____ptr).glyphs = glyphs
      ____ptr
    extension (struct: Font)
      def baseSize: CInt = struct._1
      def baseSize_=(value: CInt): Unit = !struct.at1 = value
      def glyphCount: CInt = struct._2
      def glyphCount_=(value: CInt): Unit = !struct.at2 = value
      def glyphPadding: CInt = struct._3
      def glyphPadding_=(value: CInt): Unit = !struct.at3 = value
      def texture: Texture2D = struct._4
      def texture_=(value: Texture2D): Unit = !struct.at4 = value
      def recs: Ptr[Rectangle] = struct._5
      def recs_=(value: Ptr[Rectangle]): Unit = !struct.at5 = value
      def glyphs: Ptr[GlyphInfo] = struct._6
      def glyphs_=(value: Ptr[GlyphInfo]): Unit = !struct.at6 = value

  opaque type GlyphInfo = CStruct5[CInt, CInt, CInt, CInt, Image]
  object GlyphInfo:
    given _tag: Tag[GlyphInfo] = Tag.materializeCStruct5Tag[CInt, CInt, CInt, CInt, Image]
    def apply()(using Zone): Ptr[GlyphInfo] = scala.scalanative.unsafe.alloc[GlyphInfo](1)
    def apply(value: CInt, offsetX: CInt, offsetY: CInt, advanceX: CInt, image: Image)(using Zone): Ptr[GlyphInfo] = 
      val ____ptr = apply()
      (!____ptr).value = value
      (!____ptr).offsetX = offsetX
      (!____ptr).offsetY = offsetY
      (!____ptr).advanceX = advanceX
      (!____ptr).image = image
      ____ptr
    extension (struct: GlyphInfo)
      def value: CInt = struct._1
      def value_=(value: CInt): Unit = !struct.at1 = value
      def offsetX: CInt = struct._2
      def offsetX_=(value: CInt): Unit = !struct.at2 = value
      def offsetY: CInt = struct._3
      def offsetY_=(value: CInt): Unit = !struct.at3 = value
      def advanceX: CInt = struct._4
      def advanceX_=(value: CInt): Unit = !struct.at4 = value
      def image: Image = struct._5
      def image_=(value: Image): Unit = !struct.at5 = value

  opaque type Image = CStruct5[Ptr[Byte], CInt, CInt, CInt, CInt]
  object Image:
    given _tag: Tag[Image] = Tag.materializeCStruct5Tag[Ptr[Byte], CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[Image] = scala.scalanative.unsafe.alloc[Image](1)
    def apply(data: Ptr[Byte], width: CInt, height: CInt, mipmaps: CInt, format: CInt)(using Zone): Ptr[Image] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).mipmaps = mipmaps
      (!____ptr).format = format
      ____ptr
    extension (struct: Image)
      def data: Ptr[Byte] = struct._1
      def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def width: CInt = struct._2
      def width_=(value: CInt): Unit = !struct.at2 = value
      def height: CInt = struct._3
      def height_=(value: CInt): Unit = !struct.at3 = value
      def mipmaps: CInt = struct._4
      def mipmaps_=(value: CInt): Unit = !struct.at4 = value
      def format: CInt = struct._5
      def format_=(value: CInt): Unit = !struct.at5 = value

  opaque type Material = CStruct3[Shader, Ptr[MaterialMap], CArray[Float, Nat._4]]
  object Material:
    given _tag: Tag[Material] = Tag.materializeCStruct3Tag[Shader, Ptr[MaterialMap], CArray[Float, Nat._4]]
    def apply()(using Zone): Ptr[Material] = scala.scalanative.unsafe.alloc[Material](1)
    def apply(shader: Shader, maps: Ptr[MaterialMap], params: CArray[Float, Nat._4])(using Zone): Ptr[Material] = 
      val ____ptr = apply()
      (!____ptr).shader = shader
      (!____ptr).maps = maps
      (!____ptr).params = params
      ____ptr
    extension (struct: Material)
      def shader: Shader = struct._1
      def shader_=(value: Shader): Unit = !struct.at1 = value
      def maps: Ptr[MaterialMap] = struct._2
      def maps_=(value: Ptr[MaterialMap]): Unit = !struct.at2 = value
      def params: CArray[Float, Nat._4] = struct._3
      def params_=(value: CArray[Float, Nat._4]): Unit = !struct.at3 = value

  opaque type MaterialMap = CStruct3[Texture2D, Color, Float]
  object MaterialMap:
    given _tag: Tag[MaterialMap] = Tag.materializeCStruct3Tag[Texture2D, Color, Float]
    def apply()(using Zone): Ptr[MaterialMap] = scala.scalanative.unsafe.alloc[MaterialMap](1)
    def apply(texture: Texture2D, color: Color, value: Float)(using Zone): Ptr[MaterialMap] = 
      val ____ptr = apply()
      (!____ptr).texture = texture
      (!____ptr).color = color
      (!____ptr).value = value
      ____ptr
    extension (struct: MaterialMap)
      def texture: Texture2D = struct._1
      def texture_=(value: Texture2D): Unit = !struct.at1 = value
      def color: Color = struct._2
      def color_=(value: Color): Unit = !struct.at2 = value
      def value: Float = struct._3
      def value_=(value: Float): Unit = !struct.at3 = value

  opaque type Matrix = CStruct16[Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float]
  object Matrix:
    given _tag: Tag[Matrix] = Tag.materializeCStruct16Tag[Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float, Float]
    def apply()(using Zone): Ptr[Matrix] = scala.scalanative.unsafe.alloc[Matrix](1)
    def apply(m0: Float, m4: Float, m8: Float, m12: Float, m1: Float, m5: Float, m9: Float, m13: Float, m2: Float, m6: Float, m10: Float, m14: Float, m3: Float, m7: Float, m11: Float, m15: Float)(using Zone): Ptr[Matrix] = 
      val ____ptr = apply()
      (!____ptr).m0 = m0
      (!____ptr).m4 = m4
      (!____ptr).m8 = m8
      (!____ptr).m12 = m12
      (!____ptr).m1 = m1
      (!____ptr).m5 = m5
      (!____ptr).m9 = m9
      (!____ptr).m13 = m13
      (!____ptr).m2 = m2
      (!____ptr).m6 = m6
      (!____ptr).m10 = m10
      (!____ptr).m14 = m14
      (!____ptr).m3 = m3
      (!____ptr).m7 = m7
      (!____ptr).m11 = m11
      (!____ptr).m15 = m15
      ____ptr
    extension (struct: Matrix)
      def m0: Float = struct._1
      def m0_=(value: Float): Unit = !struct.at1 = value
      def m4: Float = struct._2
      def m4_=(value: Float): Unit = !struct.at2 = value
      def m8: Float = struct._3
      def m8_=(value: Float): Unit = !struct.at3 = value
      def m12: Float = struct._4
      def m12_=(value: Float): Unit = !struct.at4 = value
      def m1: Float = struct._5
      def m1_=(value: Float): Unit = !struct.at5 = value
      def m5: Float = struct._6
      def m5_=(value: Float): Unit = !struct.at6 = value
      def m9: Float = struct._7
      def m9_=(value: Float): Unit = !struct.at7 = value
      def m13: Float = struct._8
      def m13_=(value: Float): Unit = !struct.at8 = value
      def m2: Float = struct._9
      def m2_=(value: Float): Unit = !struct.at9 = value
      def m6: Float = struct._10
      def m6_=(value: Float): Unit = !struct.at10 = value
      def m10: Float = struct._11
      def m10_=(value: Float): Unit = !struct.at11 = value
      def m14: Float = struct._12
      def m14_=(value: Float): Unit = !struct.at12 = value
      def m3: Float = struct._13
      def m3_=(value: Float): Unit = !struct.at13 = value
      def m7: Float = struct._14
      def m7_=(value: Float): Unit = !struct.at14 = value
      def m11: Float = struct._15
      def m11_=(value: Float): Unit = !struct.at15 = value
      def m15: Float = struct._16
      def m15_=(value: Float): Unit = !struct.at16 = value

  opaque type Mesh = CStruct15[CInt, CInt, Ptr[Float], Ptr[Float], Ptr[Float], Ptr[Float], Ptr[Float], Ptr[CUnsignedChar], Ptr[CUnsignedShort], Ptr[Float], Ptr[Float], Ptr[CUnsignedChar], Ptr[Float], CUnsignedInt, Ptr[CUnsignedInt]]
  object Mesh:
    given _tag: Tag[Mesh] = Tag.materializeCStruct15Tag[CInt, CInt, Ptr[Float], Ptr[Float], Ptr[Float], Ptr[Float], Ptr[Float], Ptr[CUnsignedChar], Ptr[CUnsignedShort], Ptr[Float], Ptr[Float], Ptr[CUnsignedChar], Ptr[Float], CUnsignedInt, Ptr[CUnsignedInt]]
    def apply()(using Zone): Ptr[Mesh] = scala.scalanative.unsafe.alloc[Mesh](1)
    def apply(vertexCount: CInt, triangleCount: CInt, vertices: Ptr[Float], texcoords: Ptr[Float], texcoords2: Ptr[Float], normals: Ptr[Float], tangents: Ptr[Float], colors: Ptr[CUnsignedChar], indices: Ptr[CUnsignedShort], animVertices: Ptr[Float], animNormals: Ptr[Float], boneIds: Ptr[CUnsignedChar], boneWeights: Ptr[Float], vaoId: CUnsignedInt, vboId: Ptr[CUnsignedInt])(using Zone): Ptr[Mesh] = 
      val ____ptr = apply()
      (!____ptr).vertexCount = vertexCount
      (!____ptr).triangleCount = triangleCount
      (!____ptr).vertices = vertices
      (!____ptr).texcoords = texcoords
      (!____ptr).texcoords2 = texcoords2
      (!____ptr).normals = normals
      (!____ptr).tangents = tangents
      (!____ptr).colors = colors
      (!____ptr).indices = indices
      (!____ptr).animVertices = animVertices
      (!____ptr).animNormals = animNormals
      (!____ptr).boneIds = boneIds
      (!____ptr).boneWeights = boneWeights
      (!____ptr).vaoId = vaoId
      (!____ptr).vboId = vboId
      ____ptr
    extension (struct: Mesh)
      def vertexCount: CInt = struct._1
      def vertexCount_=(value: CInt): Unit = !struct.at1 = value
      def triangleCount: CInt = struct._2
      def triangleCount_=(value: CInt): Unit = !struct.at2 = value
      def vertices: Ptr[Float] = struct._3
      def vertices_=(value: Ptr[Float]): Unit = !struct.at3 = value
      def texcoords: Ptr[Float] = struct._4
      def texcoords_=(value: Ptr[Float]): Unit = !struct.at4 = value
      def texcoords2: Ptr[Float] = struct._5
      def texcoords2_=(value: Ptr[Float]): Unit = !struct.at5 = value
      def normals: Ptr[Float] = struct._6
      def normals_=(value: Ptr[Float]): Unit = !struct.at6 = value
      def tangents: Ptr[Float] = struct._7
      def tangents_=(value: Ptr[Float]): Unit = !struct.at7 = value
      def colors: Ptr[CUnsignedChar] = struct._8
      def colors_=(value: Ptr[CUnsignedChar]): Unit = !struct.at8 = value
      def indices: Ptr[CUnsignedShort] = struct._9
      def indices_=(value: Ptr[CUnsignedShort]): Unit = !struct.at9 = value
      def animVertices: Ptr[Float] = struct._10
      def animVertices_=(value: Ptr[Float]): Unit = !struct.at10 = value
      def animNormals: Ptr[Float] = struct._11
      def animNormals_=(value: Ptr[Float]): Unit = !struct.at11 = value
      def boneIds: Ptr[CUnsignedChar] = struct._12
      def boneIds_=(value: Ptr[CUnsignedChar]): Unit = !struct.at12 = value
      def boneWeights: Ptr[Float] = struct._13
      def boneWeights_=(value: Ptr[Float]): Unit = !struct.at13 = value
      def vaoId: CUnsignedInt = struct._14
      def vaoId_=(value: CUnsignedInt): Unit = !struct.at14 = value
      def vboId: Ptr[CUnsignedInt] = struct._15
      def vboId_=(value: Ptr[CUnsignedInt]): Unit = !struct.at15 = value

  opaque type Model = CStruct9[Matrix, CInt, CInt, Ptr[Mesh], Ptr[Material], Ptr[CInt], CInt, Ptr[BoneInfo], Ptr[Transform]]
  object Model:
    given _tag: Tag[Model] = Tag.materializeCStruct9Tag[Matrix, CInt, CInt, Ptr[Mesh], Ptr[Material], Ptr[CInt], CInt, Ptr[BoneInfo], Ptr[Transform]]
    def apply()(using Zone): Ptr[Model] = scala.scalanative.unsafe.alloc[Model](1)
    def apply(transform: Matrix, meshCount: CInt, materialCount: CInt, meshes: Ptr[Mesh], materials: Ptr[Material], meshMaterial: Ptr[CInt], boneCount: CInt, bones: Ptr[BoneInfo], bindPose: Ptr[Transform])(using Zone): Ptr[Model] = 
      val ____ptr = apply()
      (!____ptr).transform = transform
      (!____ptr).meshCount = meshCount
      (!____ptr).materialCount = materialCount
      (!____ptr).meshes = meshes
      (!____ptr).materials = materials
      (!____ptr).meshMaterial = meshMaterial
      (!____ptr).boneCount = boneCount
      (!____ptr).bones = bones
      (!____ptr).bindPose = bindPose
      ____ptr
    extension (struct: Model)
      def transform: Matrix = struct._1
      def transform_=(value: Matrix): Unit = !struct.at1 = value
      def meshCount: CInt = struct._2
      def meshCount_=(value: CInt): Unit = !struct.at2 = value
      def materialCount: CInt = struct._3
      def materialCount_=(value: CInt): Unit = !struct.at3 = value
      def meshes: Ptr[Mesh] = struct._4
      def meshes_=(value: Ptr[Mesh]): Unit = !struct.at4 = value
      def materials: Ptr[Material] = struct._5
      def materials_=(value: Ptr[Material]): Unit = !struct.at5 = value
      def meshMaterial: Ptr[CInt] = struct._6
      def meshMaterial_=(value: Ptr[CInt]): Unit = !struct.at6 = value
      def boneCount: CInt = struct._7
      def boneCount_=(value: CInt): Unit = !struct.at7 = value
      def bones: Ptr[BoneInfo] = struct._8
      def bones_=(value: Ptr[BoneInfo]): Unit = !struct.at8 = value
      def bindPose: Ptr[Transform] = struct._9
      def bindPose_=(value: Ptr[Transform]): Unit = !struct.at9 = value

  opaque type ModelAnimation = CStruct4[CInt, CInt, Ptr[BoneInfo], Ptr[Ptr[Transform]]]
  object ModelAnimation:
    given _tag: Tag[ModelAnimation] = Tag.materializeCStruct4Tag[CInt, CInt, Ptr[BoneInfo], Ptr[Ptr[Transform]]]
    def apply()(using Zone): Ptr[ModelAnimation] = scala.scalanative.unsafe.alloc[ModelAnimation](1)
    def apply(boneCount: CInt, frameCount: CInt, bones: Ptr[BoneInfo], framePoses: Ptr[Ptr[Transform]])(using Zone): Ptr[ModelAnimation] = 
      val ____ptr = apply()
      (!____ptr).boneCount = boneCount
      (!____ptr).frameCount = frameCount
      (!____ptr).bones = bones
      (!____ptr).framePoses = framePoses
      ____ptr
    extension (struct: ModelAnimation)
      def boneCount: CInt = struct._1
      def boneCount_=(value: CInt): Unit = !struct.at1 = value
      def frameCount: CInt = struct._2
      def frameCount_=(value: CInt): Unit = !struct.at2 = value
      def bones: Ptr[BoneInfo] = struct._3
      def bones_=(value: Ptr[BoneInfo]): Unit = !struct.at3 = value
      def framePoses: Ptr[Ptr[Transform]] = struct._4
      def framePoses_=(value: Ptr[Ptr[Transform]]): Unit = !struct.at4 = value

  opaque type Music = CStruct5[AudioStream, CUnsignedInt, CInt, CInt, Ptr[Byte]]
  object Music:
    given _tag: Tag[Music] = Tag.materializeCStruct5Tag[AudioStream, CUnsignedInt, CInt, CInt, Ptr[Byte]]
    def apply()(using Zone): Ptr[Music] = scala.scalanative.unsafe.alloc[Music](1)
    def apply(stream: AudioStream, frameCount: CUnsignedInt, looping: CInt, ctxType: CInt, ctxData: Ptr[Byte])(using Zone): Ptr[Music] = 
      val ____ptr = apply()
      (!____ptr).stream = stream
      (!____ptr).frameCount = frameCount
      (!____ptr).looping = looping
      (!____ptr).ctxType = ctxType
      (!____ptr).ctxData = ctxData
      ____ptr
    extension (struct: Music)
      def stream: AudioStream = struct._1
      def stream_=(value: AudioStream): Unit = !struct.at1 = value
      def frameCount: CUnsignedInt = struct._2
      def frameCount_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def looping: CInt = struct._3
      def looping_=(value: CInt): Unit = !struct.at3 = value
      def ctxType: CInt = struct._4
      def ctxType_=(value: CInt): Unit = !struct.at4 = value
      def ctxData: Ptr[Byte] = struct._5
      def ctxData_=(value: Ptr[Byte]): Unit = !struct.at5 = value

  opaque type NPatchInfo = CStruct6[Rectangle, CInt, CInt, CInt, CInt, CInt]
  object NPatchInfo:
    given _tag: Tag[NPatchInfo] = Tag.materializeCStruct6Tag[Rectangle, CInt, CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[NPatchInfo] = scala.scalanative.unsafe.alloc[NPatchInfo](1)
    def apply(source: Rectangle, left: CInt, top: CInt, right: CInt, bottom: CInt, layout: CInt)(using Zone): Ptr[NPatchInfo] = 
      val ____ptr = apply()
      (!____ptr).source = source
      (!____ptr).left = left
      (!____ptr).top = top
      (!____ptr).right = right
      (!____ptr).bottom = bottom
      (!____ptr).layout = layout
      ____ptr
    extension (struct: NPatchInfo)
      def source: Rectangle = struct._1
      def source_=(value: Rectangle): Unit = !struct.at1 = value
      def left: CInt = struct._2
      def left_=(value: CInt): Unit = !struct.at2 = value
      def top: CInt = struct._3
      def top_=(value: CInt): Unit = !struct.at3 = value
      def right: CInt = struct._4
      def right_=(value: CInt): Unit = !struct.at4 = value
      def bottom: CInt = struct._5
      def bottom_=(value: CInt): Unit = !struct.at5 = value
      def layout: CInt = struct._6
      def layout_=(value: CInt): Unit = !struct.at6 = value

  opaque type Ray = CStruct2[Vector3, Vector3]
  object Ray:
    given _tag: Tag[Ray] = Tag.materializeCStruct2Tag[Vector3, Vector3]
    def apply()(using Zone): Ptr[Ray] = scala.scalanative.unsafe.alloc[Ray](1)
    def apply(position: Vector3, direction: Vector3)(using Zone): Ptr[Ray] = 
      val ____ptr = apply()
      (!____ptr).position = position
      (!____ptr).direction = direction
      ____ptr
    extension (struct: Ray)
      def position: Vector3 = struct._1
      def position_=(value: Vector3): Unit = !struct.at1 = value
      def direction: Vector3 = struct._2
      def direction_=(value: Vector3): Unit = !struct.at2 = value

  opaque type RayCollision = CStruct4[CInt, Float, Vector3, Vector3]
  object RayCollision:
    given _tag: Tag[RayCollision] = Tag.materializeCStruct4Tag[CInt, Float, Vector3, Vector3]
    def apply()(using Zone): Ptr[RayCollision] = scala.scalanative.unsafe.alloc[RayCollision](1)
    def apply(hit: CInt, distance: Float, point: Vector3, normal: Vector3)(using Zone): Ptr[RayCollision] = 
      val ____ptr = apply()
      (!____ptr).hit = hit
      (!____ptr).distance = distance
      (!____ptr).point = point
      (!____ptr).normal = normal
      ____ptr
    extension (struct: RayCollision)
      def hit: CInt = struct._1
      def hit_=(value: CInt): Unit = !struct.at1 = value
      def distance: Float = struct._2
      def distance_=(value: Float): Unit = !struct.at2 = value
      def point: Vector3 = struct._3
      def point_=(value: Vector3): Unit = !struct.at3 = value
      def normal: Vector3 = struct._4
      def normal_=(value: Vector3): Unit = !struct.at4 = value

  opaque type Rectangle = CStruct4[Float, Float, Float, Float]
  object Rectangle:
    given _tag: Tag[Rectangle] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    def apply()(using Zone): Ptr[Rectangle] = scala.scalanative.unsafe.alloc[Rectangle](1)
    def apply(x: Float, y: Float, width: Float, height: Float)(using Zone): Ptr[Rectangle] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).width = width
      (!____ptr).height = height
      ____ptr
    extension (struct: Rectangle)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value
      def width: Float = struct._3
      def width_=(value: Float): Unit = !struct.at3 = value
      def height: Float = struct._4
      def height_=(value: Float): Unit = !struct.at4 = value

  opaque type RenderTexture = CStruct3[CUnsignedInt, Texture, Texture]
  object RenderTexture:
    given _tag: Tag[RenderTexture] = Tag.materializeCStruct3Tag[CUnsignedInt, Texture, Texture]
    def apply()(using Zone): Ptr[RenderTexture] = scala.scalanative.unsafe.alloc[RenderTexture](1)
    def apply(id: CUnsignedInt, texture: Texture, depth: Texture)(using Zone): Ptr[RenderTexture] = 
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).texture = texture
      (!____ptr).depth = depth
      ____ptr
    extension (struct: RenderTexture)
      def id: CUnsignedInt = struct._1
      def id_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def texture: Texture = struct._2
      def texture_=(value: Texture): Unit = !struct.at2 = value
      def depth: Texture = struct._3
      def depth_=(value: Texture): Unit = !struct.at3 = value

  opaque type Shader = CStruct2[CUnsignedInt, Ptr[CInt]]
  object Shader:
    given _tag: Tag[Shader] = Tag.materializeCStruct2Tag[CUnsignedInt, Ptr[CInt]]
    def apply()(using Zone): Ptr[Shader] = scala.scalanative.unsafe.alloc[Shader](1)
    def apply(id: CUnsignedInt, locs: Ptr[CInt])(using Zone): Ptr[Shader] = 
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).locs = locs
      ____ptr
    extension (struct: Shader)
      def id: CUnsignedInt = struct._1
      def id_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def locs: Ptr[CInt] = struct._2
      def locs_=(value: Ptr[CInt]): Unit = !struct.at2 = value

  opaque type Sound = CStruct2[AudioStream, CUnsignedInt]
  object Sound:
    given _tag: Tag[Sound] = Tag.materializeCStruct2Tag[AudioStream, CUnsignedInt]
    def apply()(using Zone): Ptr[Sound] = scala.scalanative.unsafe.alloc[Sound](1)
    def apply(stream: AudioStream, frameCount: CUnsignedInt)(using Zone): Ptr[Sound] = 
      val ____ptr = apply()
      (!____ptr).stream = stream
      (!____ptr).frameCount = frameCount
      ____ptr
    extension (struct: Sound)
      def stream: AudioStream = struct._1
      def stream_=(value: AudioStream): Unit = !struct.at1 = value
      def frameCount: CUnsignedInt = struct._2
      def frameCount_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type Texture = CStruct5[CUnsignedInt, CInt, CInt, CInt, CInt]
  object Texture:
    given _tag: Tag[Texture] = Tag.materializeCStruct5Tag[CUnsignedInt, CInt, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[Texture] = scala.scalanative.unsafe.alloc[Texture](1)
    def apply(id: CUnsignedInt, width: CInt, height: CInt, mipmaps: CInt, format: CInt)(using Zone): Ptr[Texture] = 
      val ____ptr = apply()
      (!____ptr).id = id
      (!____ptr).width = width
      (!____ptr).height = height
      (!____ptr).mipmaps = mipmaps
      (!____ptr).format = format
      ____ptr
    extension (struct: Texture)
      def id: CUnsignedInt = struct._1
      def id_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def width: CInt = struct._2
      def width_=(value: CInt): Unit = !struct.at2 = value
      def height: CInt = struct._3
      def height_=(value: CInt): Unit = !struct.at3 = value
      def mipmaps: CInt = struct._4
      def mipmaps_=(value: CInt): Unit = !struct.at4 = value
      def format: CInt = struct._5
      def format_=(value: CInt): Unit = !struct.at5 = value

  opaque type Transform = CStruct3[Vector3, Quaternion, Vector3]
  object Transform:
    given _tag: Tag[Transform] = Tag.materializeCStruct3Tag[Vector3, Quaternion, Vector3]
    def apply()(using Zone): Ptr[Transform] = scala.scalanative.unsafe.alloc[Transform](1)
    def apply(translation: Vector3, rotation: Quaternion, scale: Vector3)(using Zone): Ptr[Transform] = 
      val ____ptr = apply()
      (!____ptr).translation = translation
      (!____ptr).rotation = rotation
      (!____ptr).scale = scale
      ____ptr
    extension (struct: Transform)
      def translation: Vector3 = struct._1
      def translation_=(value: Vector3): Unit = !struct.at1 = value
      def rotation: Quaternion = struct._2
      def rotation_=(value: Quaternion): Unit = !struct.at2 = value
      def scale: Vector3 = struct._3
      def scale_=(value: Vector3): Unit = !struct.at3 = value

  opaque type Vector2 = CStruct2[Float, Float]
  object Vector2:
    given _tag: Tag[Vector2] = Tag.materializeCStruct2Tag[Float, Float]
    def apply()(using Zone): Ptr[Vector2] = scala.scalanative.unsafe.alloc[Vector2](1)
    def apply(x: Float, y: Float)(using Zone): Ptr[Vector2] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      ____ptr
    extension (struct: Vector2)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value

  opaque type Vector3 = CStruct3[Float, Float, Float]
  object Vector3:
    given _tag: Tag[Vector3] = Tag.materializeCStruct3Tag[Float, Float, Float]
    def apply()(using Zone): Ptr[Vector3] = scala.scalanative.unsafe.alloc[Vector3](1)
    def apply(x: Float, y: Float, z: Float)(using Zone): Ptr[Vector3] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).z = z
      ____ptr
    extension (struct: Vector3)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value
      def z: Float = struct._3
      def z_=(value: Float): Unit = !struct.at3 = value

  opaque type Vector4 = CStruct4[Float, Float, Float, Float]
  object Vector4:
    given _tag: Tag[Vector4] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    def apply()(using Zone): Ptr[Vector4] = scala.scalanative.unsafe.alloc[Vector4](1)
    def apply(x: Float, y: Float, z: Float, w: Float)(using Zone): Ptr[Vector4] = 
      val ____ptr = apply()
      (!____ptr).x = x
      (!____ptr).y = y
      (!____ptr).z = z
      (!____ptr).w = w
      ____ptr
    extension (struct: Vector4)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value
      def z: Float = struct._3
      def z_=(value: Float): Unit = !struct.at3 = value
      def w: Float = struct._4
      def w_=(value: Float): Unit = !struct.at4 = value

  opaque type VrDeviceInfo = CStruct10[CInt, CInt, Float, Float, Float, Float, Float, Float, CArray[Float, Nat._4], CArray[Float, Nat._4]]
  object VrDeviceInfo:
    given _tag: Tag[VrDeviceInfo] = Tag.materializeCStruct10Tag[CInt, CInt, Float, Float, Float, Float, Float, Float, CArray[Float, Nat._4], CArray[Float, Nat._4]]
    def apply()(using Zone): Ptr[VrDeviceInfo] = scala.scalanative.unsafe.alloc[VrDeviceInfo](1)
    def apply(hResolution: CInt, vResolution: CInt, hScreenSize: Float, vScreenSize: Float, vScreenCenter: Float, eyeToScreenDistance: Float, lensSeparationDistance: Float, interpupillaryDistance: Float, lensDistortionValues: CArray[Float, Nat._4], chromaAbCorrection: CArray[Float, Nat._4])(using Zone): Ptr[VrDeviceInfo] = 
      val ____ptr = apply()
      (!____ptr).hResolution = hResolution
      (!____ptr).vResolution = vResolution
      (!____ptr).hScreenSize = hScreenSize
      (!____ptr).vScreenSize = vScreenSize
      (!____ptr).vScreenCenter = vScreenCenter
      (!____ptr).eyeToScreenDistance = eyeToScreenDistance
      (!____ptr).lensSeparationDistance = lensSeparationDistance
      (!____ptr).interpupillaryDistance = interpupillaryDistance
      (!____ptr).lensDistortionValues = lensDistortionValues
      (!____ptr).chromaAbCorrection = chromaAbCorrection
      ____ptr
    extension (struct: VrDeviceInfo)
      def hResolution: CInt = struct._1
      def hResolution_=(value: CInt): Unit = !struct.at1 = value
      def vResolution: CInt = struct._2
      def vResolution_=(value: CInt): Unit = !struct.at2 = value
      def hScreenSize: Float = struct._3
      def hScreenSize_=(value: Float): Unit = !struct.at3 = value
      def vScreenSize: Float = struct._4
      def vScreenSize_=(value: Float): Unit = !struct.at4 = value
      def vScreenCenter: Float = struct._5
      def vScreenCenter_=(value: Float): Unit = !struct.at5 = value
      def eyeToScreenDistance: Float = struct._6
      def eyeToScreenDistance_=(value: Float): Unit = !struct.at6 = value
      def lensSeparationDistance: Float = struct._7
      def lensSeparationDistance_=(value: Float): Unit = !struct.at7 = value
      def interpupillaryDistance: Float = struct._8
      def interpupillaryDistance_=(value: Float): Unit = !struct.at8 = value
      def lensDistortionValues: CArray[Float, Nat._4] = struct._9
      def lensDistortionValues_=(value: CArray[Float, Nat._4]): Unit = !struct.at9 = value
      def chromaAbCorrection: CArray[Float, Nat._4] = struct._10
      def chromaAbCorrection_=(value: CArray[Float, Nat._4]): Unit = !struct.at10 = value

  opaque type VrStereoConfig = CStruct8[CArray[Matrix, Nat._2], CArray[Matrix, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2]]
  object VrStereoConfig:
    given _tag: Tag[VrStereoConfig] = Tag.materializeCStruct8Tag[CArray[Matrix, Nat._2], CArray[Matrix, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2], CArray[Float, Nat._2]]
    def apply()(using Zone): Ptr[VrStereoConfig] = scala.scalanative.unsafe.alloc[VrStereoConfig](1)
    def apply(projection: CArray[Matrix, Nat._2], viewOffset: CArray[Matrix, Nat._2], leftLensCenter: CArray[Float, Nat._2], rightLensCenter: CArray[Float, Nat._2], leftScreenCenter: CArray[Float, Nat._2], rightScreenCenter: CArray[Float, Nat._2], scale: CArray[Float, Nat._2], scaleIn: CArray[Float, Nat._2])(using Zone): Ptr[VrStereoConfig] = 
      val ____ptr = apply()
      (!____ptr).projection = projection
      (!____ptr).viewOffset = viewOffset
      (!____ptr).leftLensCenter = leftLensCenter
      (!____ptr).rightLensCenter = rightLensCenter
      (!____ptr).leftScreenCenter = leftScreenCenter
      (!____ptr).rightScreenCenter = rightScreenCenter
      (!____ptr).scale = scale
      (!____ptr).scaleIn = scaleIn
      ____ptr
    extension (struct: VrStereoConfig)
      def projection: CArray[Matrix, Nat._2] = struct._1
      def projection_=(value: CArray[Matrix, Nat._2]): Unit = !struct.at1 = value
      def viewOffset: CArray[Matrix, Nat._2] = struct._2
      def viewOffset_=(value: CArray[Matrix, Nat._2]): Unit = !struct.at2 = value
      def leftLensCenter: CArray[Float, Nat._2] = struct._3
      def leftLensCenter_=(value: CArray[Float, Nat._2]): Unit = !struct.at3 = value
      def rightLensCenter: CArray[Float, Nat._2] = struct._4
      def rightLensCenter_=(value: CArray[Float, Nat._2]): Unit = !struct.at4 = value
      def leftScreenCenter: CArray[Float, Nat._2] = struct._5
      def leftScreenCenter_=(value: CArray[Float, Nat._2]): Unit = !struct.at5 = value
      def rightScreenCenter: CArray[Float, Nat._2] = struct._6
      def rightScreenCenter_=(value: CArray[Float, Nat._2]): Unit = !struct.at6 = value
      def scale: CArray[Float, Nat._2] = struct._7
      def scale_=(value: CArray[Float, Nat._2]): Unit = !struct.at7 = value
      def scaleIn: CArray[Float, Nat._2] = struct._8
      def scaleIn_=(value: CArray[Float, Nat._2]): Unit = !struct.at8 = value

  opaque type Wave = CStruct5[CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, Ptr[Byte]]
  object Wave:
    given _tag: Tag[Wave] = Tag.materializeCStruct5Tag[CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, Ptr[Byte]]
    def apply()(using Zone): Ptr[Wave] = scala.scalanative.unsafe.alloc[Wave](1)
    def apply(frameCount: CUnsignedInt, sampleRate: CUnsignedInt, sampleSize: CUnsignedInt, channels: CUnsignedInt, data: Ptr[Byte])(using Zone): Ptr[Wave] = 
      val ____ptr = apply()
      (!____ptr).frameCount = frameCount
      (!____ptr).sampleRate = sampleRate
      (!____ptr).sampleSize = sampleSize
      (!____ptr).channels = channels
      (!____ptr).data = data
      ____ptr
    extension (struct: Wave)
      def frameCount: CUnsignedInt = struct._1
      def frameCount_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def sampleRate: CUnsignedInt = struct._2
      def sampleRate_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def sampleSize: CUnsignedInt = struct._3
      def sampleSize_=(value: CUnsignedInt): Unit = !struct.at3 = value
      def channels: CUnsignedInt = struct._4
      def channels_=(value: CUnsignedInt): Unit = !struct.at4 = value
      def data: Ptr[Byte] = struct._5
      def data_=(value: Ptr[Byte]): Unit = !struct.at5 = value

  opaque type rAudioBuffer = CStruct0
  object rAudioBuffer:
    given _tag: Tag[rAudioBuffer] = Tag.materializeCStruct0Tag
@link("raylib")
@extern
private[libraylib] object extern_functions: 
  import types.*

  def BeginBlendMode(mode: CInt): Unit = extern

  def BeginDrawing(): Unit = extern

  def BeginScissorMode(x: CInt, y: CInt, width: CInt, height: CInt): Unit = extern

  def ChangeDirectory(): CInt = extern

  def CheckCollisionBoxSphere(): CInt = extern

  def CheckCollisionBoxes(): CInt = extern

  def CheckCollisionCircleRec(): CInt = extern

  def CheckCollisionCircles(): CInt = extern

  def CheckCollisionLines(): CInt = extern

  def CheckCollisionPointCircle(): CInt = extern

  def CheckCollisionPointLine(): CInt = extern

  def CheckCollisionPointRec(): CInt = extern

  def CheckCollisionPointTriangle(): CInt = extern

  def CheckCollisionRecs(): CInt = extern

  def CheckCollisionSpheres(): CInt = extern

  def ClearDirectoryFiles(): Unit = extern

  def ClearDroppedFiles(): Unit = extern

  def ClearWindowState(flags: CUnsignedInt): Unit = extern

  def CloseAudioDevice(): Unit = extern

  def CloseWindow(): Unit = extern

  def CodepointToUTF8(codepoint: CInt, byteSize: Ptr[CInt]): CString = extern

  def CompressData(data: Ptr[CUnsignedChar], dataLength: CInt, compDataLength: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def DecodeDataBase64(data: Ptr[CUnsignedChar], outputLength: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def DecompressData(compData: Ptr[CUnsignedChar], compDataLength: CInt, dataLength: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def DirectoryExists(): CInt = extern

  def DisableCursor(): Unit = extern

  def DrawFPS(posX: CInt, posY: CInt): Unit = extern

  def DrawGrid(slices: CInt, spacing: Float): Unit = extern

  def EnableCursor(): Unit = extern

  def EncodeDataBase64(data: Ptr[CUnsignedChar], dataLength: CInt, outputLength: Ptr[CInt]): CString = extern

  def EndBlendMode(): Unit = extern

  def EndDrawing(): Unit = extern

  def EndMode2D(): Unit = extern

  def EndMode3D(): Unit = extern

  def EndScissorMode(): Unit = extern

  def EndShaderMode(): Unit = extern

  def EndTextureMode(): Unit = extern

  def EndVrStereoMode(): Unit = extern

  def ExportImage(): CInt = extern

  def ExportImageAsCode(): CInt = extern

  def ExportMesh(): CInt = extern

  def ExportWave(): CInt = extern

  def ExportWaveAsCode(): CInt = extern

  def FileExists(): CInt = extern

  def GenMeshBinormals(mesh: Ptr[Mesh]): Unit = extern

  def GenMeshTangents(mesh: Ptr[Mesh]): Unit = extern

  def GenTextureMipmaps(texture: Ptr[Texture2D]): Unit = extern

  def GetCharPressed(): CInt = extern

  def GetClipboardText(): CString = extern

  def GetCodepoint(text: CString, bytesProcessed: Ptr[CInt]): CInt = extern

  def GetCodepointCount(text: CString): CInt = extern

  def GetCurrentMonitor(): CInt = extern

  def GetDirectoryFiles(dirPath: CString, count: Ptr[CInt]): Ptr[CString] = extern

  def GetDirectoryPath(filePath: CString): CString = extern

  def GetDroppedFiles(count: Ptr[CInt]): Ptr[CString] = extern

  def GetFPS(): CInt = extern

  def GetFileExtension(fileName: CString): CString = extern

  def GetFileModTime(fileName: CString): CLongInt = extern

  def GetFileName(filePath: CString): CString = extern

  def GetFileNameWithoutExt(filePath: CString): CString = extern

  def GetFrameTime(): Float = extern

  def GetGamepadAxisCount(gamepad: CInt): CInt = extern

  def GetGamepadAxisMovement(gamepad: CInt, axis: CInt): Float = extern

  def GetGamepadButtonPressed(): CInt = extern

  def GetGamepadName(gamepad: CInt): CString = extern

  def GetGestureDetected(): CInt = extern

  def GetGestureDragAngle(): Float = extern

  def GetGestureHoldDuration(): Float = extern

  def GetGesturePinchAngle(): Float = extern

  def GetKeyPressed(): CInt = extern

  def GetMonitorCount(): CInt = extern

  def GetMonitorHeight(monitor: CInt): CInt = extern

  def GetMonitorName(monitor: CInt): CString = extern

  def GetMonitorPhysicalHeight(monitor: CInt): CInt = extern

  def GetMonitorPhysicalWidth(monitor: CInt): CInt = extern

  def GetMonitorRefreshRate(monitor: CInt): CInt = extern

  def GetMonitorWidth(monitor: CInt): CInt = extern

  def GetMouseWheelMove(): Float = extern

  def GetMouseX(): CInt = extern

  def GetMouseY(): CInt = extern

  def GetPixelDataSize(width: CInt, height: CInt, format: CInt): CInt = extern

  def GetPrevDirectoryPath(dirPath: CString): CString = extern

  def GetRandomValue(min: CInt, max: CInt): CInt = extern

  def GetRenderHeight(): CInt = extern

  def GetRenderWidth(): CInt = extern

  def GetScreenHeight(): CInt = extern

  def GetScreenWidth(): CInt = extern

  def GetSoundsPlaying(): CInt = extern

  def GetTime(): Double = extern

  def GetTouchPointCount(): CInt = extern

  def GetTouchPointId(index: CInt): CInt = extern

  def GetTouchX(): CInt = extern

  def GetTouchY(): CInt = extern

  def GetWindowHandle(): Ptr[Byte] = extern

  def GetWorkingDirectory(): CString = extern

  def HideCursor(): Unit = extern

  def ImageAlphaCrop(image: Ptr[Image], threshold: Float): Unit = extern

  def ImageAlphaPremultiply(image: Ptr[Image]): Unit = extern

  def ImageColorBrightness(image: Ptr[Image], brightness: CInt): Unit = extern

  def ImageColorContrast(image: Ptr[Image], contrast: Float): Unit = extern

  def ImageColorGrayscale(image: Ptr[Image]): Unit = extern

  def ImageColorInvert(image: Ptr[Image]): Unit = extern

  def ImageDither(image: Ptr[Image], rBpp: CInt, gBpp: CInt, bBpp: CInt, aBpp: CInt): Unit = extern

  def ImageFlipHorizontal(image: Ptr[Image]): Unit = extern

  def ImageFlipVertical(image: Ptr[Image]): Unit = extern

  def ImageFormat(image: Ptr[Image], newFormat: CInt): Unit = extern

  def ImageMipmaps(image: Ptr[Image]): Unit = extern

  def ImageResize(image: Ptr[Image], newWidth: CInt, newHeight: CInt): Unit = extern

  def ImageResizeNN(image: Ptr[Image], newWidth: CInt, newHeight: CInt): Unit = extern

  def ImageRotateCCW(image: Ptr[Image]): Unit = extern

  def ImageRotateCW(image: Ptr[Image]): Unit = extern

  def InitAudioDevice(): Unit = extern

  def InitWindow(width: CInt, height: CInt, title: CString): Unit = extern

  def IsAudioDeviceReady(): CInt = extern

  def IsAudioStreamPlaying(): CInt = extern

  def IsAudioStreamProcessed(): CInt = extern

  def IsCursorHidden(): CInt = extern

  def IsCursorOnScreen(): CInt = extern

  def IsFileDropped(): CInt = extern

  def IsFileExtension(): CInt = extern

  def IsGamepadAvailable(): CInt = extern

  def IsGamepadButtonDown(): CInt = extern

  def IsGamepadButtonPressed(): CInt = extern

  def IsGamepadButtonReleased(): CInt = extern

  def IsGamepadButtonUp(): CInt = extern

  def IsGestureDetected(): CInt = extern

  def IsKeyDown(): CInt = extern

  def IsKeyPressed(): CInt = extern

  def IsKeyReleased(): CInt = extern

  def IsKeyUp(): CInt = extern

  def IsModelAnimationValid(): CInt = extern

  def IsMouseButtonDown(): CInt = extern

  def IsMouseButtonPressed(): CInt = extern

  def IsMouseButtonReleased(): CInt = extern

  def IsMouseButtonUp(): CInt = extern

  def IsMusicStreamPlaying(): CInt = extern

  def IsSoundPlaying(): CInt = extern

  def IsWindowFocused(): CInt = extern

  def IsWindowFullscreen(): CInt = extern

  def IsWindowHidden(): CInt = extern

  def IsWindowMaximized(): CInt = extern

  def IsWindowMinimized(): CInt = extern

  def IsWindowReady(): CInt = extern

  def IsWindowResized(): CInt = extern

  def IsWindowState(): CInt = extern

  def LoadCodepoints(text: CString, count: Ptr[CInt]): Ptr[CInt] = extern

  def LoadFileData(fileName: CString, bytesRead: Ptr[CUnsignedInt]): Ptr[CUnsignedChar] = extern

  def LoadFileText(fileName: CString): CString = extern

  def LoadFontData(fileData: Ptr[CUnsignedChar], dataSize: CInt, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt, `type`: CInt): Ptr[GlyphInfo] = extern

  def LoadMaterials(fileName: CString, materialCount: Ptr[CInt]): Ptr[Material] = extern

  def LoadModelAnimations(fileName: CString, animCount: Ptr[CUnsignedInt]): Ptr[ModelAnimation] = extern

  def LoadStorageValue(position: CUnsignedInt): CInt = extern

  def MaximizeWindow(): Unit = extern

  def MeasureText(text: CString, fontSize: CInt): CInt = extern

  def MemAlloc(size: CInt): Ptr[Byte] = extern

  def MemFree(ptr: Ptr[Byte]): Unit = extern

  def MemRealloc(ptr: Ptr[Byte], size: CInt): Ptr[Byte] = extern

  def MinimizeWindow(): Unit = extern

  def OpenURL(url: CString): Unit = extern

  def PollInputEvents(): Unit = extern

  def RestoreWindow(): Unit = extern

  def SaveFileData(): CInt = extern

  def SaveFileText(): CInt = extern

  def SaveStorageValue(): CInt = extern

  def SetAudioStreamBufferSizeDefault(size: CInt): Unit = extern

  def SetCameraAltControl(keyAlt: CInt): Unit = extern

  def SetCameraMoveControls(keyFront: CInt, keyBack: CInt, keyRight: CInt, keyLeft: CInt, keyUp: CInt, keyDown: CInt): Unit = extern

  def SetCameraPanControl(keyPan: CInt): Unit = extern

  def SetCameraSmoothZoomControl(keySmoothZoom: CInt): Unit = extern

  def SetClipboardText(text: CString): Unit = extern

  def SetConfigFlags(flags: CUnsignedInt): Unit = extern

  def SetExitKey(key: CInt): Unit = extern

  def SetGamepadMappings(mappings: CString): CInt = extern

  def SetGesturesEnabled(flags: CUnsignedInt): Unit = extern

  def SetLoadFileDataCallback(callback: LoadFileDataCallback): Unit = extern

  def SetLoadFileTextCallback(callback: LoadFileTextCallback): Unit = extern

  def SetMasterVolume(volume: Float): Unit = extern

  def SetModelMeshMaterial(model: Ptr[Model], meshId: CInt, materialId: CInt): Unit = extern

  def SetMouseCursor(cursor: CInt): Unit = extern

  def SetMouseOffset(offsetX: CInt, offsetY: CInt): Unit = extern

  def SetMousePosition(x: CInt, y: CInt): Unit = extern

  def SetMouseScale(scaleX: Float, scaleY: Float): Unit = extern

  def SetRandomSeed(seed: CUnsignedInt): Unit = extern

  def SetSaveFileDataCallback(callback: CInt): Unit = extern

  def SetSaveFileTextCallback(callback: SaveFileTextCallback): Unit = extern

  def SetTargetFPS(fps: CInt): Unit = extern

  def SetTraceLogCallback(callback: TraceLogCallback): Unit = extern

  def SetTraceLogLevel(logLevel: CInt): Unit = extern

  def SetWindowMinSize(width: CInt, height: CInt): Unit = extern

  def SetWindowMonitor(monitor: CInt): Unit = extern

  def SetWindowOpacity(opacity: Float): Unit = extern

  def SetWindowPosition(x: CInt, y: CInt): Unit = extern

  def SetWindowSize(width: CInt, height: CInt): Unit = extern

  def SetWindowState(flags: CUnsignedInt): Unit = extern

  def SetWindowTitle(title: CString): Unit = extern

  def ShowCursor(): Unit = extern

  def StopSoundMulti(): Unit = extern

  def SwapScreenBuffer(): Unit = extern

  def TakeScreenshot(fileName: CString): Unit = extern

  def TextAppend(text: CString, append: CString, position: Ptr[CInt]): Unit = extern

  def TextCodepointsToUTF8(codepoints: Ptr[CInt], length: CInt): CString = extern

  def TextCopy(dst: CString, src: CString): CInt = extern

  def TextFindIndex(text: CString, find: CString): CInt = extern

  def TextFormat(text: CString): CString = extern

  def TextInsert(text: CString, insert: CString, position: CInt): CString = extern

  def TextIsEqual(): CInt = extern

  def TextJoin(textList: Ptr[CString], count: CInt, delimiter: CString): CString = extern

  def TextLength(text: CString): CUnsignedInt = extern

  def TextReplace(text: CString, replace: CString, by: CString): CString = extern

  def TextSplit(text: CString, delimiter: CChar, count: Ptr[CInt]): Ptr[CString] = extern

  def TextSubtext(text: CString, position: CInt, length: CInt): CString = extern

  def TextToInteger(text: CString): CInt = extern

  def TextToLower(text: CString): CString = extern

  def TextToPascal(text: CString): CString = extern

  def TextToUpper(text: CString): CString = extern

  def ToggleFullscreen(): Unit = extern

  def TraceLog(logLevel: CInt, text: CString): Unit = extern

  def UnloadCodepoints(codepoints: Ptr[CInt]): Unit = extern

  def UnloadFileData(data: Ptr[CUnsignedChar]): Unit = extern

  def UnloadFileText(text: CString): Unit = extern

  def UnloadFontData(chars: Ptr[GlyphInfo], glyphCount: CInt): Unit = extern

  def UnloadImageColors(colors: Ptr[Color]): Unit = extern

  def UnloadImagePalette(colors: Ptr[Color]): Unit = extern

  def UnloadModelAnimations(animations: Ptr[ModelAnimation], count: CUnsignedInt): Unit = extern

  def UnloadWaveSamples(samples: Ptr[Float]): Unit = extern

  def UpdateCamera(camera: Ptr[Camera]): Unit = extern

  def UploadMesh(mesh: Ptr[Mesh], dynamic: bool): Unit = extern

  def WaitTime(ms: Float): Unit = extern

  def WaveCrop(wave: Ptr[Wave], initSample: CInt, finalSample: CInt): Unit = extern

  def WaveFormat(wave: Ptr[Wave], sampleRate: CInt, sampleSize: CInt, channels: CInt): Unit = extern

  def WindowShouldClose(): CInt = extern

  @name("__sn_wrap_BeginMode2D")
  private[libraylib] def __sn_wrap_BeginMode2D(camera: Ptr[Camera2D]): Unit = extern

  @name("__sn_wrap_BeginMode3D")
  private[libraylib] def __sn_wrap_BeginMode3D(camera: Ptr[Camera3D]): Unit = extern

  @name("__sn_wrap_BeginShaderMode")
  private[libraylib] def __sn_wrap_BeginShaderMode(shader: Ptr[Shader]): Unit = extern

  @name("__sn_wrap_BeginTextureMode")
  private[libraylib] def __sn_wrap_BeginTextureMode(target: Ptr[RenderTexture2D]): Unit = extern

  @name("__sn_wrap_BeginVrStereoMode")
  private[libraylib] def __sn_wrap_BeginVrStereoMode(config: Ptr[VrStereoConfig]): Unit = extern

  @name("__sn_wrap_ClearBackground")
  private[libraylib] def __sn_wrap_ClearBackground(color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ColorAlpha")
  private[libraylib] def __sn_wrap_ColorAlpha(color: Ptr[Color], alpha: Float, __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ColorAlphaBlend")
  private[libraylib] def __sn_wrap_ColorAlphaBlend(dst: Ptr[Color], src: Ptr[Color], tint: Ptr[Color], __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ColorFromHSV")
  private[libraylib] def __sn_wrap_ColorFromHSV(hue: Float, saturation: Float, value: Float, __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ColorFromNormalized")
  private[libraylib] def __sn_wrap_ColorFromNormalized(normalized: Ptr[Vector4], __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ColorNormalize")
  private[libraylib] def __sn_wrap_ColorNormalize(color: Ptr[Color], __return: Ptr[Vector4]): Unit = extern

  @name("__sn_wrap_ColorToHSV")
  private[libraylib] def __sn_wrap_ColorToHSV(color: Ptr[Color], __return: Ptr[Vector3]): Unit = extern

  @name("__sn_wrap_ColorToInt")
  private[libraylib] def __sn_wrap_ColorToInt(color: Ptr[Color]): CInt = extern

  @name("__sn_wrap_DrawBillboard")
  private[libraylib] def __sn_wrap_DrawBillboard(camera: Ptr[Camera], texture: Ptr[Texture2D], position: Ptr[Vector3], size: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawBillboardPro")
  private[libraylib] def __sn_wrap_DrawBillboardPro(camera: Ptr[Camera], texture: Ptr[Texture2D], source: Ptr[Rectangle], position: Ptr[Vector3], up: Ptr[Vector3], size: Ptr[Vector2], origin: Ptr[Vector2], rotation: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawBillboardRec")
  private[libraylib] def __sn_wrap_DrawBillboardRec(camera: Ptr[Camera], texture: Ptr[Texture2D], source: Ptr[Rectangle], position: Ptr[Vector3], size: Ptr[Vector2], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawBoundingBox")
  private[libraylib] def __sn_wrap_DrawBoundingBox(box: Ptr[BoundingBox], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircle")
  private[libraylib] def __sn_wrap_DrawCircle(centerX: CInt, centerY: CInt, radius: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircle3D")
  private[libraylib] def __sn_wrap_DrawCircle3D(center: Ptr[Vector3], radius: Float, rotationAxis: Ptr[Vector3], rotationAngle: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircleGradient")
  private[libraylib] def __sn_wrap_DrawCircleGradient(centerX: CInt, centerY: CInt, radius: Float, color1: Ptr[Color], color2: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircleLines")
  private[libraylib] def __sn_wrap_DrawCircleLines(centerX: CInt, centerY: CInt, radius: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircleSector")
  private[libraylib] def __sn_wrap_DrawCircleSector(center: Ptr[Vector2], radius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircleSectorLines")
  private[libraylib] def __sn_wrap_DrawCircleSectorLines(center: Ptr[Vector2], radius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCircleV")
  private[libraylib] def __sn_wrap_DrawCircleV(center: Ptr[Vector2], radius: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCube")
  private[libraylib] def __sn_wrap_DrawCube(position: Ptr[Vector3], width: Float, height: Float, length: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCubeTexture")
  private[libraylib] def __sn_wrap_DrawCubeTexture(texture: Ptr[Texture2D], position: Ptr[Vector3], width: Float, height: Float, length: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCubeTextureRec")
  private[libraylib] def __sn_wrap_DrawCubeTextureRec(texture: Ptr[Texture2D], source: Ptr[Rectangle], position: Ptr[Vector3], width: Float, height: Float, length: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCubeV")
  private[libraylib] def __sn_wrap_DrawCubeV(position: Ptr[Vector3], size: Ptr[Vector3], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCubeWires")
  private[libraylib] def __sn_wrap_DrawCubeWires(position: Ptr[Vector3], width: Float, height: Float, length: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCubeWiresV")
  private[libraylib] def __sn_wrap_DrawCubeWiresV(position: Ptr[Vector3], size: Ptr[Vector3], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCylinder")
  private[libraylib] def __sn_wrap_DrawCylinder(position: Ptr[Vector3], radiusTop: Float, radiusBottom: Float, height: Float, slices: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCylinderEx")
  private[libraylib] def __sn_wrap_DrawCylinderEx(startPos: Ptr[Vector3], endPos: Ptr[Vector3], startRadius: Float, endRadius: Float, sides: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCylinderWires")
  private[libraylib] def __sn_wrap_DrawCylinderWires(position: Ptr[Vector3], radiusTop: Float, radiusBottom: Float, height: Float, slices: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawCylinderWiresEx")
  private[libraylib] def __sn_wrap_DrawCylinderWiresEx(startPos: Ptr[Vector3], endPos: Ptr[Vector3], startRadius: Float, endRadius: Float, sides: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawEllipse")
  private[libraylib] def __sn_wrap_DrawEllipse(centerX: CInt, centerY: CInt, radiusH: Float, radiusV: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawEllipseLines")
  private[libraylib] def __sn_wrap_DrawEllipseLines(centerX: CInt, centerY: CInt, radiusH: Float, radiusV: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLine")
  private[libraylib] def __sn_wrap_DrawLine(startPosX: CInt, startPosY: CInt, endPosX: CInt, endPosY: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLine3D")
  private[libraylib] def __sn_wrap_DrawLine3D(startPos: Ptr[Vector3], endPos: Ptr[Vector3], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLineBezier")
  private[libraylib] def __sn_wrap_DrawLineBezier(startPos: Ptr[Vector2], endPos: Ptr[Vector2], thick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLineBezierCubic")
  private[libraylib] def __sn_wrap_DrawLineBezierCubic(startPos: Ptr[Vector2], endPos: Ptr[Vector2], startControlPos: Ptr[Vector2], endControlPos: Ptr[Vector2], thick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLineBezierQuad")
  private[libraylib] def __sn_wrap_DrawLineBezierQuad(startPos: Ptr[Vector2], endPos: Ptr[Vector2], controlPos: Ptr[Vector2], thick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLineEx")
  private[libraylib] def __sn_wrap_DrawLineEx(startPos: Ptr[Vector2], endPos: Ptr[Vector2], thick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLineStrip")
  private[libraylib] def __sn_wrap_DrawLineStrip(points: Ptr[Vector2], pointCount: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawLineV")
  private[libraylib] def __sn_wrap_DrawLineV(startPos: Ptr[Vector2], endPos: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawMesh")
  private[libraylib] def __sn_wrap_DrawMesh(mesh: Ptr[Mesh], material: Ptr[Material], transform: Ptr[Matrix]): Unit = extern

  @name("__sn_wrap_DrawMeshInstanced")
  private[libraylib] def __sn_wrap_DrawMeshInstanced(mesh: Ptr[Mesh], material: Ptr[Material], transforms: Ptr[Matrix], instances: CInt): Unit = extern

  @name("__sn_wrap_DrawModel")
  private[libraylib] def __sn_wrap_DrawModel(model: Ptr[Model], position: Ptr[Vector3], scale: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawModelEx")
  private[libraylib] def __sn_wrap_DrawModelEx(model: Ptr[Model], position: Ptr[Vector3], rotationAxis: Ptr[Vector3], rotationAngle: Float, scale: Ptr[Vector3], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawModelWires")
  private[libraylib] def __sn_wrap_DrawModelWires(model: Ptr[Model], position: Ptr[Vector3], scale: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawModelWiresEx")
  private[libraylib] def __sn_wrap_DrawModelWiresEx(model: Ptr[Model], position: Ptr[Vector3], rotationAxis: Ptr[Vector3], rotationAngle: Float, scale: Ptr[Vector3], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPixel")
  private[libraylib] def __sn_wrap_DrawPixel(posX: CInt, posY: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPixelV")
  private[libraylib] def __sn_wrap_DrawPixelV(position: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPlane")
  private[libraylib] def __sn_wrap_DrawPlane(centerPos: Ptr[Vector3], size: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPoint3D")
  private[libraylib] def __sn_wrap_DrawPoint3D(position: Ptr[Vector3], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPoly")
  private[libraylib] def __sn_wrap_DrawPoly(center: Ptr[Vector2], sides: CInt, radius: Float, rotation: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPolyLines")
  private[libraylib] def __sn_wrap_DrawPolyLines(center: Ptr[Vector2], sides: CInt, radius: Float, rotation: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawPolyLinesEx")
  private[libraylib] def __sn_wrap_DrawPolyLinesEx(center: Ptr[Vector2], sides: CInt, radius: Float, rotation: Float, lineThick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRay")
  private[libraylib] def __sn_wrap_DrawRay(ray: Ptr[Ray], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangle")
  private[libraylib] def __sn_wrap_DrawRectangle(posX: CInt, posY: CInt, width: CInt, height: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleGradientEx")
  private[libraylib] def __sn_wrap_DrawRectangleGradientEx(rec: Ptr[Rectangle], col1: Ptr[Color], col2: Ptr[Color], col3: Ptr[Color], col4: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleGradientH")
  private[libraylib] def __sn_wrap_DrawRectangleGradientH(posX: CInt, posY: CInt, width: CInt, height: CInt, color1: Ptr[Color], color2: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleGradientV")
  private[libraylib] def __sn_wrap_DrawRectangleGradientV(posX: CInt, posY: CInt, width: CInt, height: CInt, color1: Ptr[Color], color2: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleLines")
  private[libraylib] def __sn_wrap_DrawRectangleLines(posX: CInt, posY: CInt, width: CInt, height: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleLinesEx")
  private[libraylib] def __sn_wrap_DrawRectangleLinesEx(rec: Ptr[Rectangle], lineThick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectanglePro")
  private[libraylib] def __sn_wrap_DrawRectanglePro(rec: Ptr[Rectangle], origin: Ptr[Vector2], rotation: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleRec")
  private[libraylib] def __sn_wrap_DrawRectangleRec(rec: Ptr[Rectangle], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleRounded")
  private[libraylib] def __sn_wrap_DrawRectangleRounded(rec: Ptr[Rectangle], roundness: Float, segments: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleRoundedLines")
  private[libraylib] def __sn_wrap_DrawRectangleRoundedLines(rec: Ptr[Rectangle], roundness: Float, segments: CInt, lineThick: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRectangleV")
  private[libraylib] def __sn_wrap_DrawRectangleV(position: Ptr[Vector2], size: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRing")
  private[libraylib] def __sn_wrap_DrawRing(center: Ptr[Vector2], innerRadius: Float, outerRadius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawRingLines")
  private[libraylib] def __sn_wrap_DrawRingLines(center: Ptr[Vector2], innerRadius: Float, outerRadius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawSphere")
  private[libraylib] def __sn_wrap_DrawSphere(centerPos: Ptr[Vector3], radius: Float, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawSphereEx")
  private[libraylib] def __sn_wrap_DrawSphereEx(centerPos: Ptr[Vector3], radius: Float, rings: CInt, slices: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawSphereWires")
  private[libraylib] def __sn_wrap_DrawSphereWires(centerPos: Ptr[Vector3], radius: Float, rings: CInt, slices: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawText")
  private[libraylib] def __sn_wrap_DrawText(text: CString, posX: CInt, posY: CInt, fontSize: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextCodepoint")
  private[libraylib] def __sn_wrap_DrawTextCodepoint(font: Ptr[Font], codepoint: CInt, position: Ptr[Vector2], fontSize: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextEx")
  private[libraylib] def __sn_wrap_DrawTextEx(font: Ptr[Font], text: CString, position: Ptr[Vector2], fontSize: Float, spacing: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextPro")
  private[libraylib] def __sn_wrap_DrawTextPro(font: Ptr[Font], text: CString, position: Ptr[Vector2], origin: Ptr[Vector2], rotation: Float, fontSize: Float, spacing: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTexture")
  private[libraylib] def __sn_wrap_DrawTexture(texture: Ptr[Texture2D], posX: CInt, posY: CInt, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextureEx")
  private[libraylib] def __sn_wrap_DrawTextureEx(texture: Ptr[Texture2D], position: Ptr[Vector2], rotation: Float, scale: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextureNPatch")
  private[libraylib] def __sn_wrap_DrawTextureNPatch(texture: Ptr[Texture2D], nPatchInfo: Ptr[NPatchInfo], dest: Ptr[Rectangle], origin: Ptr[Vector2], rotation: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTexturePoly")
  private[libraylib] def __sn_wrap_DrawTexturePoly(texture: Ptr[Texture2D], center: Ptr[Vector2], points: Ptr[Vector2], texcoords: Ptr[Vector2], pointCount: CInt, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTexturePro")
  private[libraylib] def __sn_wrap_DrawTexturePro(texture: Ptr[Texture2D], source: Ptr[Rectangle], dest: Ptr[Rectangle], origin: Ptr[Vector2], rotation: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextureQuad")
  private[libraylib] def __sn_wrap_DrawTextureQuad(texture: Ptr[Texture2D], tiling: Ptr[Vector2], offset: Ptr[Vector2], quad: Ptr[Rectangle], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextureRec")
  private[libraylib] def __sn_wrap_DrawTextureRec(texture: Ptr[Texture2D], source: Ptr[Rectangle], position: Ptr[Vector2], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextureTiled")
  private[libraylib] def __sn_wrap_DrawTextureTiled(texture: Ptr[Texture2D], source: Ptr[Rectangle], dest: Ptr[Rectangle], origin: Ptr[Vector2], rotation: Float, scale: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTextureV")
  private[libraylib] def __sn_wrap_DrawTextureV(texture: Ptr[Texture2D], position: Ptr[Vector2], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTriangle")
  private[libraylib] def __sn_wrap_DrawTriangle(v1: Ptr[Vector2], v2: Ptr[Vector2], v3: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTriangle3D")
  private[libraylib] def __sn_wrap_DrawTriangle3D(v1: Ptr[Vector3], v2: Ptr[Vector3], v3: Ptr[Vector3], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTriangleFan")
  private[libraylib] def __sn_wrap_DrawTriangleFan(points: Ptr[Vector2], pointCount: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTriangleLines")
  private[libraylib] def __sn_wrap_DrawTriangleLines(v1: Ptr[Vector2], v2: Ptr[Vector2], v3: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTriangleStrip")
  private[libraylib] def __sn_wrap_DrawTriangleStrip(points: Ptr[Vector2], pointCount: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_DrawTriangleStrip3D")
  private[libraylib] def __sn_wrap_DrawTriangleStrip3D(points: Ptr[Vector3], pointCount: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_Fade")
  private[libraylib] def __sn_wrap_Fade(color: Ptr[Color], alpha: Float, __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_GenImageCellular")
  private[libraylib] def __sn_wrap_GenImageCellular(width: CInt, height: CInt, tileSize: CInt, __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageChecked")
  private[libraylib] def __sn_wrap_GenImageChecked(width: CInt, height: CInt, checksX: CInt, checksY: CInt, col1: Ptr[Color], col2: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageColor")
  private[libraylib] def __sn_wrap_GenImageColor(width: CInt, height: CInt, color: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageFontAtlas")
  private[libraylib] def __sn_wrap_GenImageFontAtlas(chars: Ptr[GlyphInfo], recs: Ptr[Ptr[Rectangle]], glyphCount: CInt, fontSize: CInt, padding: CInt, packMethod: CInt, __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageGradientH")
  private[libraylib] def __sn_wrap_GenImageGradientH(width: CInt, height: CInt, left: Ptr[Color], right: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageGradientRadial")
  private[libraylib] def __sn_wrap_GenImageGradientRadial(width: CInt, height: CInt, density: Float, inner: Ptr[Color], outer: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageGradientV")
  private[libraylib] def __sn_wrap_GenImageGradientV(width: CInt, height: CInt, top: Ptr[Color], bottom: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenImageWhiteNoise")
  private[libraylib] def __sn_wrap_GenImageWhiteNoise(width: CInt, height: CInt, factor: Float, __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_GenMeshCone")
  private[libraylib] def __sn_wrap_GenMeshCone(radius: Float, height: Float, slices: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshCube")
  private[libraylib] def __sn_wrap_GenMeshCube(width: Float, height: Float, length: Float, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshCubicmap")
  private[libraylib] def __sn_wrap_GenMeshCubicmap(cubicmap: Ptr[Image], cubeSize: Ptr[Vector3], __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshCylinder")
  private[libraylib] def __sn_wrap_GenMeshCylinder(radius: Float, height: Float, slices: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshHeightmap")
  private[libraylib] def __sn_wrap_GenMeshHeightmap(heightmap: Ptr[Image], size: Ptr[Vector3], __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshHemiSphere")
  private[libraylib] def __sn_wrap_GenMeshHemiSphere(radius: Float, rings: CInt, slices: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshKnot")
  private[libraylib] def __sn_wrap_GenMeshKnot(radius: Float, size: Float, radSeg: CInt, sides: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshPlane")
  private[libraylib] def __sn_wrap_GenMeshPlane(width: Float, length: Float, resX: CInt, resZ: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshPoly")
  private[libraylib] def __sn_wrap_GenMeshPoly(sides: CInt, radius: Float, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshSphere")
  private[libraylib] def __sn_wrap_GenMeshSphere(radius: Float, rings: CInt, slices: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GenMeshTorus")
  private[libraylib] def __sn_wrap_GenMeshTorus(radius: Float, size: Float, radSeg: CInt, sides: CInt, __return: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_GetCameraMatrix")
  private[libraylib] def __sn_wrap_GetCameraMatrix(camera: Ptr[Camera], __return: Ptr[Matrix]): Unit = extern

  @name("__sn_wrap_GetCameraMatrix2D")
  private[libraylib] def __sn_wrap_GetCameraMatrix2D(camera: Ptr[Camera2D], __return: Ptr[Matrix]): Unit = extern

  @name("__sn_wrap_GetCollisionRec")
  private[libraylib] def __sn_wrap_GetCollisionRec(rec1: Ptr[Rectangle], rec2: Ptr[Rectangle], __return: Ptr[Rectangle]): Unit = extern

  @name("__sn_wrap_GetColor")
  private[libraylib] def __sn_wrap_GetColor(hexValue: CUnsignedInt, __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_GetFontDefault")
  private[libraylib] def __sn_wrap_GetFontDefault(__return: Ptr[Font]): Unit = extern

  @name("__sn_wrap_GetGestureDragVector")
  private[libraylib] def __sn_wrap_GetGestureDragVector(__return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetGesturePinchVector")
  private[libraylib] def __sn_wrap_GetGesturePinchVector(__return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetGlyphAtlasRec")
  private[libraylib] def __sn_wrap_GetGlyphAtlasRec(font: Ptr[Font], codepoint: CInt, __return: Ptr[Rectangle]): Unit = extern

  @name("__sn_wrap_GetGlyphIndex")
  private[libraylib] def __sn_wrap_GetGlyphIndex(font: Ptr[Font], codepoint: CInt): CInt = extern

  @name("__sn_wrap_GetGlyphInfo")
  private[libraylib] def __sn_wrap_GetGlyphInfo(font: Ptr[Font], codepoint: CInt, __return: Ptr[GlyphInfo]): Unit = extern

  @name("__sn_wrap_GetImageAlphaBorder")
  private[libraylib] def __sn_wrap_GetImageAlphaBorder(image: Ptr[Image], threshold: Float, __return: Ptr[Rectangle]): Unit = extern

  @name("__sn_wrap_GetImageColor")
  private[libraylib] def __sn_wrap_GetImageColor(image: Ptr[Image], x: CInt, y: CInt, __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_GetMeshBoundingBox")
  private[libraylib] def __sn_wrap_GetMeshBoundingBox(mesh: Ptr[Mesh], __return: Ptr[BoundingBox]): Unit = extern

  @name("__sn_wrap_GetModelBoundingBox")
  private[libraylib] def __sn_wrap_GetModelBoundingBox(model: Ptr[Model], __return: Ptr[BoundingBox]): Unit = extern

  @name("__sn_wrap_GetMonitorPosition")
  private[libraylib] def __sn_wrap_GetMonitorPosition(monitor: CInt, __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetMouseDelta")
  private[libraylib] def __sn_wrap_GetMouseDelta(__return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetMousePosition")
  private[libraylib] def __sn_wrap_GetMousePosition(__return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetMouseRay")
  private[libraylib] def __sn_wrap_GetMouseRay(mousePosition: Ptr[Vector2], camera: Ptr[Camera], __return: Ptr[Ray]): Unit = extern

  @name("__sn_wrap_GetMusicTimeLength")
  private[libraylib] def __sn_wrap_GetMusicTimeLength(music: Ptr[Music]): Float = extern

  @name("__sn_wrap_GetMusicTimePlayed")
  private[libraylib] def __sn_wrap_GetMusicTimePlayed(music: Ptr[Music]): Float = extern

  @name("__sn_wrap_GetPixelColor")
  private[libraylib] def __sn_wrap_GetPixelColor(srcPtr: Ptr[Byte], format: CInt, __return: Ptr[Color]): Unit = extern

  @name("__sn_wrap_GetRayCollisionBox")
  private[libraylib] def __sn_wrap_GetRayCollisionBox(ray: Ptr[Ray], box: Ptr[BoundingBox], __return: Ptr[RayCollision]): Unit = extern

  @name("__sn_wrap_GetRayCollisionMesh")
  private[libraylib] def __sn_wrap_GetRayCollisionMesh(ray: Ptr[Ray], mesh: Ptr[Mesh], transform: Ptr[Matrix], __return: Ptr[RayCollision]): Unit = extern

  @name("__sn_wrap_GetRayCollisionModel")
  private[libraylib] def __sn_wrap_GetRayCollisionModel(ray: Ptr[Ray], model: Ptr[Model], __return: Ptr[RayCollision]): Unit = extern

  @name("__sn_wrap_GetRayCollisionQuad")
  private[libraylib] def __sn_wrap_GetRayCollisionQuad(ray: Ptr[Ray], p1: Ptr[Vector3], p2: Ptr[Vector3], p3: Ptr[Vector3], p4: Ptr[Vector3], __return: Ptr[RayCollision]): Unit = extern

  @name("__sn_wrap_GetRayCollisionSphere")
  private[libraylib] def __sn_wrap_GetRayCollisionSphere(ray: Ptr[Ray], center: Ptr[Vector3], radius: Float, __return: Ptr[RayCollision]): Unit = extern

  @name("__sn_wrap_GetRayCollisionTriangle")
  private[libraylib] def __sn_wrap_GetRayCollisionTriangle(ray: Ptr[Ray], p1: Ptr[Vector3], p2: Ptr[Vector3], p3: Ptr[Vector3], __return: Ptr[RayCollision]): Unit = extern

  @name("__sn_wrap_GetScreenToWorld2D")
  private[libraylib] def __sn_wrap_GetScreenToWorld2D(position: Ptr[Vector2], camera: Ptr[Camera2D], __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetShaderLocation")
  private[libraylib] def __sn_wrap_GetShaderLocation(shader: Ptr[Shader], uniformName: CString): CInt = extern

  @name("__sn_wrap_GetShaderLocationAttrib")
  private[libraylib] def __sn_wrap_GetShaderLocationAttrib(shader: Ptr[Shader], attribName: CString): CInt = extern

  @name("__sn_wrap_GetTouchPosition")
  private[libraylib] def __sn_wrap_GetTouchPosition(index: CInt, __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetWindowPosition")
  private[libraylib] def __sn_wrap_GetWindowPosition(__return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetWindowScaleDPI")
  private[libraylib] def __sn_wrap_GetWindowScaleDPI(__return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetWorldToScreen")
  private[libraylib] def __sn_wrap_GetWorldToScreen(position: Ptr[Vector3], camera: Ptr[Camera], __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetWorldToScreen2D")
  private[libraylib] def __sn_wrap_GetWorldToScreen2D(position: Ptr[Vector2], camera: Ptr[Camera2D], __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_GetWorldToScreenEx")
  private[libraylib] def __sn_wrap_GetWorldToScreenEx(position: Ptr[Vector3], camera: Ptr[Camera], width: CInt, height: CInt, __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_ImageAlphaClear")
  private[libraylib] def __sn_wrap_ImageAlphaClear(image: Ptr[Image], color: Ptr[Color], threshold: Float): Unit = extern

  @name("__sn_wrap_ImageAlphaMask")
  private[libraylib] def __sn_wrap_ImageAlphaMask(image: Ptr[Image], alphaMask: Ptr[Image]): Unit = extern

  @name("__sn_wrap_ImageClearBackground")
  private[libraylib] def __sn_wrap_ImageClearBackground(dst: Ptr[Image], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageColorReplace")
  private[libraylib] def __sn_wrap_ImageColorReplace(image: Ptr[Image], color: Ptr[Color], replace: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageColorTint")
  private[libraylib] def __sn_wrap_ImageColorTint(image: Ptr[Image], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageCopy")
  private[libraylib] def __sn_wrap_ImageCopy(image: Ptr[Image], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_ImageCrop")
  private[libraylib] def __sn_wrap_ImageCrop(image: Ptr[Image], crop: Ptr[Rectangle]): Unit = extern

  @name("__sn_wrap_ImageDraw")
  private[libraylib] def __sn_wrap_ImageDraw(dst: Ptr[Image], src: Ptr[Image], srcRec: Ptr[Rectangle], dstRec: Ptr[Rectangle], tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawCircle")
  private[libraylib] def __sn_wrap_ImageDrawCircle(dst: Ptr[Image], centerX: CInt, centerY: CInt, radius: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawCircleV")
  private[libraylib] def __sn_wrap_ImageDrawCircleV(dst: Ptr[Image], center: Ptr[Vector2], radius: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawLine")
  private[libraylib] def __sn_wrap_ImageDrawLine(dst: Ptr[Image], startPosX: CInt, startPosY: CInt, endPosX: CInt, endPosY: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawLineV")
  private[libraylib] def __sn_wrap_ImageDrawLineV(dst: Ptr[Image], start: Ptr[Vector2], end: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawPixel")
  private[libraylib] def __sn_wrap_ImageDrawPixel(dst: Ptr[Image], posX: CInt, posY: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawPixelV")
  private[libraylib] def __sn_wrap_ImageDrawPixelV(dst: Ptr[Image], position: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawRectangle")
  private[libraylib] def __sn_wrap_ImageDrawRectangle(dst: Ptr[Image], posX: CInt, posY: CInt, width: CInt, height: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawRectangleLines")
  private[libraylib] def __sn_wrap_ImageDrawRectangleLines(dst: Ptr[Image], rec: Ptr[Rectangle], thick: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawRectangleRec")
  private[libraylib] def __sn_wrap_ImageDrawRectangleRec(dst: Ptr[Image], rec: Ptr[Rectangle], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawRectangleV")
  private[libraylib] def __sn_wrap_ImageDrawRectangleV(dst: Ptr[Image], position: Ptr[Vector2], size: Ptr[Vector2], color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawText")
  private[libraylib] def __sn_wrap_ImageDrawText(dst: Ptr[Image], text: CString, posX: CInt, posY: CInt, fontSize: CInt, color: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageDrawTextEx")
  private[libraylib] def __sn_wrap_ImageDrawTextEx(dst: Ptr[Image], font: Ptr[Font], text: CString, position: Ptr[Vector2], fontSize: Float, spacing: Float, tint: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageFromImage")
  private[libraylib] def __sn_wrap_ImageFromImage(image: Ptr[Image], rec: Ptr[Rectangle], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_ImageResizeCanvas")
  private[libraylib] def __sn_wrap_ImageResizeCanvas(image: Ptr[Image], newWidth: CInt, newHeight: CInt, offsetX: CInt, offsetY: CInt, fill: Ptr[Color]): Unit = extern

  @name("__sn_wrap_ImageText")
  private[libraylib] def __sn_wrap_ImageText(text: CString, fontSize: CInt, color: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_ImageTextEx")
  private[libraylib] def __sn_wrap_ImageTextEx(font: Ptr[Font], text: CString, fontSize: Float, spacing: Float, tint: Ptr[Color], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_ImageToPOT")
  private[libraylib] def __sn_wrap_ImageToPOT(image: Ptr[Image], fill: Ptr[Color]): Unit = extern

  @name("__sn_wrap_LoadAudioStream")
  private[libraylib] def __sn_wrap_LoadAudioStream(sampleRate: CUnsignedInt, sampleSize: CUnsignedInt, channels: CUnsignedInt, __return: Ptr[AudioStream]): Unit = extern

  @name("__sn_wrap_LoadFont")
  private[libraylib] def __sn_wrap_LoadFont(fileName: CString, __return: Ptr[Font]): Unit = extern

  @name("__sn_wrap_LoadFontEx")
  private[libraylib] def __sn_wrap_LoadFontEx(fileName: CString, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt, __return: Ptr[Font]): Unit = extern

  @name("__sn_wrap_LoadFontFromImage")
  private[libraylib] def __sn_wrap_LoadFontFromImage(image: Ptr[Image], key: Ptr[Color], firstChar: CInt, __return: Ptr[Font]): Unit = extern

  @name("__sn_wrap_LoadFontFromMemory")
  private[libraylib] def __sn_wrap_LoadFontFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt, __return: Ptr[Font]): Unit = extern

  @name("__sn_wrap_LoadImage")
  private[libraylib] def __sn_wrap_LoadImage(fileName: CString, __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_LoadImageAnim")
  private[libraylib] def __sn_wrap_LoadImageAnim(fileName: CString, frames: Ptr[CInt], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_LoadImageColors")
  private[libraylib] def __sn_wrap_LoadImageColors(image: Ptr[Image]): Ptr[Color] = extern

  @name("__sn_wrap_LoadImageFromMemory")
  private[libraylib] def __sn_wrap_LoadImageFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt, __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_LoadImageFromScreen")
  private[libraylib] def __sn_wrap_LoadImageFromScreen(__return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_LoadImageFromTexture")
  private[libraylib] def __sn_wrap_LoadImageFromTexture(texture: Ptr[Texture2D], __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_LoadImagePalette")
  private[libraylib] def __sn_wrap_LoadImagePalette(image: Ptr[Image], maxPaletteSize: CInt, colorCount: Ptr[CInt]): Ptr[Color] = extern

  @name("__sn_wrap_LoadImageRaw")
  private[libraylib] def __sn_wrap_LoadImageRaw(fileName: CString, width: CInt, height: CInt, format: CInt, headerSize: CInt, __return: Ptr[Image]): Unit = extern

  @name("__sn_wrap_LoadMaterialDefault")
  private[libraylib] def __sn_wrap_LoadMaterialDefault(__return: Ptr[Material]): Unit = extern

  @name("__sn_wrap_LoadModel")
  private[libraylib] def __sn_wrap_LoadModel(fileName: CString, __return: Ptr[Model]): Unit = extern

  @name("__sn_wrap_LoadModelFromMesh")
  private[libraylib] def __sn_wrap_LoadModelFromMesh(mesh: Ptr[Mesh], __return: Ptr[Model]): Unit = extern

  @name("__sn_wrap_LoadMusicStream")
  private[libraylib] def __sn_wrap_LoadMusicStream(fileName: CString, __return: Ptr[Music]): Unit = extern

  @name("__sn_wrap_LoadMusicStreamFromMemory")
  private[libraylib] def __sn_wrap_LoadMusicStreamFromMemory(fileType: CString, data: Ptr[CUnsignedChar], dataSize: CInt, __return: Ptr[Music]): Unit = extern

  @name("__sn_wrap_LoadRenderTexture")
  private[libraylib] def __sn_wrap_LoadRenderTexture(width: CInt, height: CInt, __return: Ptr[RenderTexture2D]): Unit = extern

  @name("__sn_wrap_LoadShader")
  private[libraylib] def __sn_wrap_LoadShader(vsFileName: CString, fsFileName: CString, __return: Ptr[Shader]): Unit = extern

  @name("__sn_wrap_LoadShaderFromMemory")
  private[libraylib] def __sn_wrap_LoadShaderFromMemory(vsCode: CString, fsCode: CString, __return: Ptr[Shader]): Unit = extern

  @name("__sn_wrap_LoadSound")
  private[libraylib] def __sn_wrap_LoadSound(fileName: CString, __return: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_LoadSoundFromWave")
  private[libraylib] def __sn_wrap_LoadSoundFromWave(wave: Ptr[Wave], __return: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_LoadTexture")
  private[libraylib] def __sn_wrap_LoadTexture(fileName: CString, __return: Ptr[Texture2D]): Unit = extern

  @name("__sn_wrap_LoadTextureCubemap")
  private[libraylib] def __sn_wrap_LoadTextureCubemap(image: Ptr[Image], layout: CInt, __return: Ptr[TextureCubemap]): Unit = extern

  @name("__sn_wrap_LoadTextureFromImage")
  private[libraylib] def __sn_wrap_LoadTextureFromImage(image: Ptr[Image], __return: Ptr[Texture2D]): Unit = extern

  @name("__sn_wrap_LoadVrStereoConfig")
  private[libraylib] def __sn_wrap_LoadVrStereoConfig(device: Ptr[VrDeviceInfo], __return: Ptr[VrStereoConfig]): Unit = extern

  @name("__sn_wrap_LoadWave")
  private[libraylib] def __sn_wrap_LoadWave(fileName: CString, __return: Ptr[Wave]): Unit = extern

  @name("__sn_wrap_LoadWaveFromMemory")
  private[libraylib] def __sn_wrap_LoadWaveFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt, __return: Ptr[Wave]): Unit = extern

  @name("__sn_wrap_LoadWaveSamples")
  private[libraylib] def __sn_wrap_LoadWaveSamples(wave: Ptr[Wave]): Ptr[Float] = extern

  @name("__sn_wrap_MeasureTextEx")
  private[libraylib] def __sn_wrap_MeasureTextEx(font: Ptr[Font], text: CString, fontSize: Float, spacing: Float, __return: Ptr[Vector2]): Unit = extern

  @name("__sn_wrap_PauseAudioStream")
  private[libraylib] def __sn_wrap_PauseAudioStream(stream: Ptr[AudioStream]): Unit = extern

  @name("__sn_wrap_PauseMusicStream")
  private[libraylib] def __sn_wrap_PauseMusicStream(music: Ptr[Music]): Unit = extern

  @name("__sn_wrap_PauseSound")
  private[libraylib] def __sn_wrap_PauseSound(sound: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_PlayAudioStream")
  private[libraylib] def __sn_wrap_PlayAudioStream(stream: Ptr[AudioStream]): Unit = extern

  @name("__sn_wrap_PlayMusicStream")
  private[libraylib] def __sn_wrap_PlayMusicStream(music: Ptr[Music]): Unit = extern

  @name("__sn_wrap_PlaySound")
  private[libraylib] def __sn_wrap_PlaySound(sound: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_PlaySoundMulti")
  private[libraylib] def __sn_wrap_PlaySoundMulti(sound: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_ResumeAudioStream")
  private[libraylib] def __sn_wrap_ResumeAudioStream(stream: Ptr[AudioStream]): Unit = extern

  @name("__sn_wrap_ResumeMusicStream")
  private[libraylib] def __sn_wrap_ResumeMusicStream(music: Ptr[Music]): Unit = extern

  @name("__sn_wrap_ResumeSound")
  private[libraylib] def __sn_wrap_ResumeSound(sound: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_SeekMusicStream")
  private[libraylib] def __sn_wrap_SeekMusicStream(music: Ptr[Music], position: Float): Unit = extern

  @name("__sn_wrap_SetAudioStreamPitch")
  private[libraylib] def __sn_wrap_SetAudioStreamPitch(stream: Ptr[AudioStream], pitch: Float): Unit = extern

  @name("__sn_wrap_SetAudioStreamVolume")
  private[libraylib] def __sn_wrap_SetAudioStreamVolume(stream: Ptr[AudioStream], volume: Float): Unit = extern

  @name("__sn_wrap_SetCameraMode")
  private[libraylib] def __sn_wrap_SetCameraMode(camera: Ptr[Camera], mode: CInt): Unit = extern

  @name("__sn_wrap_SetMaterialTexture")
  private[libraylib] def __sn_wrap_SetMaterialTexture(material: Ptr[Material], mapType: CInt, texture: Ptr[Texture2D]): Unit = extern

  @name("__sn_wrap_SetMusicPitch")
  private[libraylib] def __sn_wrap_SetMusicPitch(music: Ptr[Music], pitch: Float): Unit = extern

  @name("__sn_wrap_SetMusicVolume")
  private[libraylib] def __sn_wrap_SetMusicVolume(music: Ptr[Music], volume: Float): Unit = extern

  @name("__sn_wrap_SetPixelColor")
  private[libraylib] def __sn_wrap_SetPixelColor(dstPtr: Ptr[Byte], color: Ptr[Color], format: CInt): Unit = extern

  @name("__sn_wrap_SetShaderValue")
  private[libraylib] def __sn_wrap_SetShaderValue(shader: Ptr[Shader], locIndex: CInt, value: Ptr[Byte], uniformType: CInt): Unit = extern

  @name("__sn_wrap_SetShaderValueMatrix")
  private[libraylib] def __sn_wrap_SetShaderValueMatrix(shader: Ptr[Shader], locIndex: CInt, mat: Ptr[Matrix]): Unit = extern

  @name("__sn_wrap_SetShaderValueTexture")
  private[libraylib] def __sn_wrap_SetShaderValueTexture(shader: Ptr[Shader], locIndex: CInt, texture: Ptr[Texture2D]): Unit = extern

  @name("__sn_wrap_SetShaderValueV")
  private[libraylib] def __sn_wrap_SetShaderValueV(shader: Ptr[Shader], locIndex: CInt, value: Ptr[Byte], uniformType: CInt, count: CInt): Unit = extern

  @name("__sn_wrap_SetShapesTexture")
  private[libraylib] def __sn_wrap_SetShapesTexture(texture: Ptr[Texture2D], source: Ptr[Rectangle]): Unit = extern

  @name("__sn_wrap_SetSoundPitch")
  private[libraylib] def __sn_wrap_SetSoundPitch(sound: Ptr[Sound], pitch: Float): Unit = extern

  @name("__sn_wrap_SetSoundVolume")
  private[libraylib] def __sn_wrap_SetSoundVolume(sound: Ptr[Sound], volume: Float): Unit = extern

  @name("__sn_wrap_SetTextureFilter")
  private[libraylib] def __sn_wrap_SetTextureFilter(texture: Ptr[Texture2D], filter: CInt): Unit = extern

  @name("__sn_wrap_SetTextureWrap")
  private[libraylib] def __sn_wrap_SetTextureWrap(texture: Ptr[Texture2D], wrap: CInt): Unit = extern

  @name("__sn_wrap_SetWindowIcon")
  private[libraylib] def __sn_wrap_SetWindowIcon(image: Ptr[Image]): Unit = extern

  @name("__sn_wrap_StopAudioStream")
  private[libraylib] def __sn_wrap_StopAudioStream(stream: Ptr[AudioStream]): Unit = extern

  @name("__sn_wrap_StopMusicStream")
  private[libraylib] def __sn_wrap_StopMusicStream(music: Ptr[Music]): Unit = extern

  @name("__sn_wrap_StopSound")
  private[libraylib] def __sn_wrap_StopSound(sound: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_UnloadAudioStream")
  private[libraylib] def __sn_wrap_UnloadAudioStream(stream: Ptr[AudioStream]): Unit = extern

  @name("__sn_wrap_UnloadFont")
  private[libraylib] def __sn_wrap_UnloadFont(font: Ptr[Font]): Unit = extern

  @name("__sn_wrap_UnloadImage")
  private[libraylib] def __sn_wrap_UnloadImage(image: Ptr[Image]): Unit = extern

  @name("__sn_wrap_UnloadMaterial")
  private[libraylib] def __sn_wrap_UnloadMaterial(material: Ptr[Material]): Unit = extern

  @name("__sn_wrap_UnloadMesh")
  private[libraylib] def __sn_wrap_UnloadMesh(mesh: Ptr[Mesh]): Unit = extern

  @name("__sn_wrap_UnloadModel")
  private[libraylib] def __sn_wrap_UnloadModel(model: Ptr[Model]): Unit = extern

  @name("__sn_wrap_UnloadModelAnimation")
  private[libraylib] def __sn_wrap_UnloadModelAnimation(anim: Ptr[ModelAnimation]): Unit = extern

  @name("__sn_wrap_UnloadModelKeepMeshes")
  private[libraylib] def __sn_wrap_UnloadModelKeepMeshes(model: Ptr[Model]): Unit = extern

  @name("__sn_wrap_UnloadMusicStream")
  private[libraylib] def __sn_wrap_UnloadMusicStream(music: Ptr[Music]): Unit = extern

  @name("__sn_wrap_UnloadRenderTexture")
  private[libraylib] def __sn_wrap_UnloadRenderTexture(target: Ptr[RenderTexture2D]): Unit = extern

  @name("__sn_wrap_UnloadShader")
  private[libraylib] def __sn_wrap_UnloadShader(shader: Ptr[Shader]): Unit = extern

  @name("__sn_wrap_UnloadSound")
  private[libraylib] def __sn_wrap_UnloadSound(sound: Ptr[Sound]): Unit = extern

  @name("__sn_wrap_UnloadTexture")
  private[libraylib] def __sn_wrap_UnloadTexture(texture: Ptr[Texture2D]): Unit = extern

  @name("__sn_wrap_UnloadVrStereoConfig")
  private[libraylib] def __sn_wrap_UnloadVrStereoConfig(config: Ptr[VrStereoConfig]): Unit = extern

  @name("__sn_wrap_UnloadWave")
  private[libraylib] def __sn_wrap_UnloadWave(wave: Ptr[Wave]): Unit = extern

  @name("__sn_wrap_UpdateAudioStream")
  private[libraylib] def __sn_wrap_UpdateAudioStream(stream: Ptr[AudioStream], data: Ptr[Byte], frameCount: CInt): Unit = extern

  @name("__sn_wrap_UpdateMeshBuffer")
  private[libraylib] def __sn_wrap_UpdateMeshBuffer(mesh: Ptr[Mesh], index: CInt, data: Ptr[Byte], dataSize: CInt, offset: CInt): Unit = extern

  @name("__sn_wrap_UpdateModelAnimation")
  private[libraylib] def __sn_wrap_UpdateModelAnimation(model: Ptr[Model], anim: Ptr[ModelAnimation], frame: CInt): Unit = extern

  @name("__sn_wrap_UpdateMusicStream")
  private[libraylib] def __sn_wrap_UpdateMusicStream(music: Ptr[Music]): Unit = extern

  @name("__sn_wrap_UpdateSound")
  private[libraylib] def __sn_wrap_UpdateSound(sound: Ptr[Sound], data: Ptr[Byte], sampleCount: CInt): Unit = extern

  @name("__sn_wrap_UpdateTexture")
  private[libraylib] def __sn_wrap_UpdateTexture(texture: Ptr[Texture2D], pixels: Ptr[Byte]): Unit = extern

  @name("__sn_wrap_UpdateTextureRec")
  private[libraylib] def __sn_wrap_UpdateTextureRec(texture: Ptr[Texture2D], rec: Ptr[Rectangle], pixels: Ptr[Byte]): Unit = extern

  @name("__sn_wrap_WaveCopy")
  private[libraylib] def __sn_wrap_WaveCopy(wave: Ptr[Wave], __return: Ptr[Wave]): Unit = extern

object functions: 
  import types.*, extern_functions.*

  export extern_functions.*

  def BeginMode2D(camera: Camera2D)(using Zone): Unit = 
    val _ptr_0 = alloc[Camera2D](1)
    !_ptr_0 = camera
    __sn_wrap_BeginMode2D(_ptr_0)

  def BeginMode3D(camera: Camera3D)(using Zone): Unit = 
    val _ptr_0 = alloc[Camera3D](1)
    !_ptr_0 = camera
    __sn_wrap_BeginMode3D(_ptr_0)

  def BeginShaderMode(shader: Shader)(using Zone): Unit = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    __sn_wrap_BeginShaderMode(_ptr_0)

  def BeginTextureMode(target: RenderTexture2D)(using Zone): Unit = 
    val _ptr_0 = alloc[RenderTexture2D](1)
    !_ptr_0 = target
    __sn_wrap_BeginTextureMode(_ptr_0)

  def BeginVrStereoMode(config: VrStereoConfig)(using Zone): Unit = 
    val _ptr_0 = alloc[VrStereoConfig](1)
    !_ptr_0 = config
    __sn_wrap_BeginVrStereoMode(_ptr_0)

  def ClearBackground(color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = color
    __sn_wrap_ClearBackground(_ptr_0)

  def ColorAlpha(color: Color, alpha: Float)(using Zone): Color = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = color
    val _ptr_return = alloc[Color](1)
    __sn_wrap_ColorAlpha(_ptr_0, alpha, _ptr_return)
    !_ptr_return

  def ColorAlphaBlend(dst: Color, src: Color, tint: Color)(using Zone): Color = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = dst
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = src
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = tint
    val _ptr_return = alloc[Color](1)
    __sn_wrap_ColorAlphaBlend(_ptr_0, _ptr_1, _ptr_2, _ptr_return)
    !_ptr_return

  def ColorFromHSV(hue: Float, saturation: Float, value: Float)(using Zone): Color = 
    val _ptr_return = alloc[Color](1)
    __sn_wrap_ColorFromHSV(hue, saturation, value, _ptr_return)
    !_ptr_return

  def ColorFromNormalized(normalized: Vector4)(using Zone): Color = 
    val _ptr_0 = alloc[Vector4](1)
    !_ptr_0 = normalized
    val _ptr_return = alloc[Color](1)
    __sn_wrap_ColorFromNormalized(_ptr_0, _ptr_return)
    !_ptr_return

  def ColorNormalize(color: Color)(using Zone): Vector4 = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = color
    val _ptr_return = alloc[Vector4](1)
    __sn_wrap_ColorNormalize(_ptr_0, _ptr_return)
    !_ptr_return

  def ColorToHSV(color: Color)(using Zone): Vector3 = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = color
    val _ptr_return = alloc[Vector3](1)
    __sn_wrap_ColorToHSV(_ptr_0, _ptr_return)
    !_ptr_return

  def ColorToInt(color: Color)(using Zone): CInt = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = color
    __sn_wrap_ColorToInt(_ptr_0)

  def DrawBillboard(camera: Camera, texture: Texture2D, position: Vector3, size: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Camera](1)
    !_ptr_0 = camera
    val _ptr_1 = alloc[Texture2D](1)
    !_ptr_1 = texture
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = position
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = tint
    __sn_wrap_DrawBillboard(_ptr_0, _ptr_1, _ptr_2, size, _ptr_4)

  def DrawBillboardPro(camera: Camera, texture: Texture2D, source: Rectangle, position: Vector3, up: Vector3, size: Vector2, origin: Vector2, rotation: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Camera](1)
    !_ptr_0 = camera
    val _ptr_1 = alloc[Texture2D](1)
    !_ptr_1 = texture
    val _ptr_2 = alloc[Rectangle](1)
    !_ptr_2 = source
    val _ptr_3 = alloc[Vector3](1)
    !_ptr_3 = position
    val _ptr_4 = alloc[Vector3](1)
    !_ptr_4 = up
    val _ptr_5 = alloc[Vector2](1)
    !_ptr_5 = size
    val _ptr_6 = alloc[Vector2](1)
    !_ptr_6 = origin
    val _ptr_8 = alloc[Color](1)
    !_ptr_8 = tint
    __sn_wrap_DrawBillboardPro(_ptr_0, _ptr_1, _ptr_2, _ptr_3, _ptr_4, _ptr_5, _ptr_6, rotation, _ptr_8)

  def DrawBillboardRec(camera: Camera, texture: Texture2D, source: Rectangle, position: Vector3, size: Vector2, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Camera](1)
    !_ptr_0 = camera
    val _ptr_1 = alloc[Texture2D](1)
    !_ptr_1 = texture
    val _ptr_2 = alloc[Rectangle](1)
    !_ptr_2 = source
    val _ptr_3 = alloc[Vector3](1)
    !_ptr_3 = position
    val _ptr_4 = alloc[Vector2](1)
    !_ptr_4 = size
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawBillboardRec(_ptr_0, _ptr_1, _ptr_2, _ptr_3, _ptr_4, _ptr_5)

  def DrawBoundingBox(box: BoundingBox, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[BoundingBox](1)
    !_ptr_0 = box
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_DrawBoundingBox(_ptr_0, _ptr_1)

  def DrawCircle(centerX: CInt, centerY: CInt, radius: Float, color: Color)(using Zone): Unit = 
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawCircle(centerX, centerY, radius, _ptr_3)

  def DrawCircle3D(center: Vector3, radius: Float, rotationAxis: Vector3, rotationAngle: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = center
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = rotationAxis
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawCircle3D(_ptr_0, radius, _ptr_2, rotationAngle, _ptr_4)

  def DrawCircleGradient(centerX: CInt, centerY: CInt, radius: Float, color1: Color, color2: Color)(using Zone): Unit = 
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color1
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color2
    __sn_wrap_DrawCircleGradient(centerX, centerY, radius, _ptr_3, _ptr_4)

  def DrawCircleLines(centerX: CInt, centerY: CInt, radius: Float, color: Color)(using Zone): Unit = 
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawCircleLines(centerX, centerY, radius, _ptr_3)

  def DrawCircleSector(center: Vector2, radius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCircleSector(_ptr_0, radius, startAngle, endAngle, segments, _ptr_5)

  def DrawCircleSectorLines(center: Vector2, radius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCircleSectorLines(_ptr_0, radius, startAngle, endAngle, segments, _ptr_5)

  def DrawCircleV(center: Vector2, radius: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawCircleV(_ptr_0, radius, _ptr_2)

  def DrawCube(position: Vector3, width: Float, height: Float, length: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawCube(_ptr_0, width, height, length, _ptr_4)

  def DrawCubeTexture(texture: Texture2D, position: Vector3, width: Float, height: Float, length: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = position
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCubeTexture(_ptr_0, _ptr_1, width, height, length, _ptr_5)

  def DrawCubeTextureRec(texture: Texture2D, source: Rectangle, position: Vector3, width: Float, height: Float, length: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = source
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = position
    val _ptr_6 = alloc[Color](1)
    !_ptr_6 = color
    __sn_wrap_DrawCubeTextureRec(_ptr_0, _ptr_1, _ptr_2, width, height, length, _ptr_6)

  def DrawCubeV(position: Vector3, size: Vector3, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = size
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawCubeV(_ptr_0, _ptr_1, _ptr_2)

  def DrawCubeWires(position: Vector3, width: Float, height: Float, length: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawCubeWires(_ptr_0, width, height, length, _ptr_4)

  def DrawCubeWiresV(position: Vector3, size: Vector3, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = size
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawCubeWiresV(_ptr_0, _ptr_1, _ptr_2)

  def DrawCylinder(position: Vector3, radiusTop: Float, radiusBottom: Float, height: Float, slices: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCylinder(_ptr_0, radiusTop, radiusBottom, height, slices, _ptr_5)

  def DrawCylinderEx(startPos: Vector3, endPos: Vector3, startRadius: Float, endRadius: Float, sides: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = endPos
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCylinderEx(_ptr_0, _ptr_1, startRadius, endRadius, sides, _ptr_5)

  def DrawCylinderWires(position: Vector3, radiusTop: Float, radiusBottom: Float, height: Float, slices: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCylinderWires(_ptr_0, radiusTop, radiusBottom, height, slices, _ptr_5)

  def DrawCylinderWiresEx(startPos: Vector3, endPos: Vector3, startRadius: Float, endRadius: Float, sides: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = endPos
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawCylinderWiresEx(_ptr_0, _ptr_1, startRadius, endRadius, sides, _ptr_5)

  def DrawEllipse(centerX: CInt, centerY: CInt, radiusH: Float, radiusV: Float, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawEllipse(centerX, centerY, radiusH, radiusV, _ptr_4)

  def DrawEllipseLines(centerX: CInt, centerY: CInt, radiusH: Float, radiusV: Float, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawEllipseLines(centerX, centerY, radiusH, radiusV, _ptr_4)

  def DrawLine(startPosX: CInt, startPosY: CInt, endPosX: CInt, endPosY: CInt, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawLine(startPosX, startPosY, endPosX, endPosY, _ptr_4)

  def DrawLine3D(startPos: Vector3, endPos: Vector3, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = endPos
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawLine3D(_ptr_0, _ptr_1, _ptr_2)

  def DrawLineBezier(startPos: Vector2, endPos: Vector2, thick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = endPos
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawLineBezier(_ptr_0, _ptr_1, thick, _ptr_3)

  def DrawLineBezierCubic(startPos: Vector2, endPos: Vector2, startControlPos: Vector2, endControlPos: Vector2, thick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = endPos
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = startControlPos
    val _ptr_3 = alloc[Vector2](1)
    !_ptr_3 = endControlPos
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawLineBezierCubic(_ptr_0, _ptr_1, _ptr_2, _ptr_3, thick, _ptr_5)

  def DrawLineBezierQuad(startPos: Vector2, endPos: Vector2, controlPos: Vector2, thick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = endPos
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = controlPos
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawLineBezierQuad(_ptr_0, _ptr_1, _ptr_2, thick, _ptr_4)

  def DrawLineEx(startPos: Vector2, endPos: Vector2, thick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = endPos
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawLineEx(_ptr_0, _ptr_1, thick, _ptr_3)

  def DrawLineStrip(points: Ptr[Vector2], pointCount: CInt, color: Color)(using Zone): Unit = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawLineStrip(points, pointCount, _ptr_2)

  def DrawLineV(startPos: Vector2, endPos: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = startPos
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = endPos
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawLineV(_ptr_0, _ptr_1, _ptr_2)

  def DrawMesh(mesh: Mesh, material: Material, transform: Matrix)(using Zone): Unit = 
    val _ptr_0 = alloc[Mesh](1)
    !_ptr_0 = mesh
    val _ptr_1 = alloc[Material](1)
    !_ptr_1 = material
    val _ptr_2 = alloc[Matrix](1)
    !_ptr_2 = transform
    __sn_wrap_DrawMesh(_ptr_0, _ptr_1, _ptr_2)

  def DrawMeshInstanced(mesh: Mesh, material: Material, transforms: Ptr[Matrix], instances: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Mesh](1)
    !_ptr_0 = mesh
    val _ptr_1 = alloc[Material](1)
    !_ptr_1 = material
    __sn_wrap_DrawMeshInstanced(_ptr_0, _ptr_1, transforms, instances)

  def DrawModel(model: Model, position: Vector3, scale: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = position
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = tint
    __sn_wrap_DrawModel(_ptr_0, _ptr_1, scale, _ptr_3)

  def DrawModelEx(model: Model, position: Vector3, rotationAxis: Vector3, rotationAngle: Float, scale: Vector3, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = position
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = rotationAxis
    val _ptr_4 = alloc[Vector3](1)
    !_ptr_4 = scale
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawModelEx(_ptr_0, _ptr_1, _ptr_2, rotationAngle, _ptr_4, _ptr_5)

  def DrawModelWires(model: Model, position: Vector3, scale: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = position
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = tint
    __sn_wrap_DrawModelWires(_ptr_0, _ptr_1, scale, _ptr_3)

  def DrawModelWiresEx(model: Model, position: Vector3, rotationAxis: Vector3, rotationAngle: Float, scale: Vector3, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = position
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = rotationAxis
    val _ptr_4 = alloc[Vector3](1)
    !_ptr_4 = scale
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawModelWiresEx(_ptr_0, _ptr_1, _ptr_2, rotationAngle, _ptr_4, _ptr_5)

  def DrawPixel(posX: CInt, posY: CInt, color: Color)(using Zone): Unit = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawPixel(posX, posY, _ptr_2)

  def DrawPixelV(position: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_DrawPixelV(_ptr_0, _ptr_1)

  def DrawPlane(centerPos: Vector3, size: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = centerPos
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = size
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawPlane(_ptr_0, _ptr_1, _ptr_2)

  def DrawPoint3D(position: Vector3, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_DrawPoint3D(_ptr_0, _ptr_1)

  def DrawPoly(center: Vector2, sides: CInt, radius: Float, rotation: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawPoly(_ptr_0, sides, radius, rotation, _ptr_4)

  def DrawPolyLines(center: Vector2, sides: CInt, radius: Float, rotation: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawPolyLines(_ptr_0, sides, radius, rotation, _ptr_4)

  def DrawPolyLinesEx(center: Vector2, sides: CInt, radius: Float, rotation: Float, lineThick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_DrawPolyLinesEx(_ptr_0, sides, radius, rotation, lineThick, _ptr_5)

  def DrawRay(ray: Ray, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_DrawRay(_ptr_0, _ptr_1)

  def DrawRectangle(posX: CInt, posY: CInt, width: CInt, height: CInt, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawRectangle(posX, posY, width, height, _ptr_4)

  def DrawRectangleGradientEx(rec: Rectangle, col1: Color, col2: Color, col3: Color, col4: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = col1
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = col2
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = col3
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = col4
    __sn_wrap_DrawRectangleGradientEx(_ptr_0, _ptr_1, _ptr_2, _ptr_3, _ptr_4)

  def DrawRectangleGradientH(posX: CInt, posY: CInt, width: CInt, height: CInt, color1: Color, color2: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color1
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color2
    __sn_wrap_DrawRectangleGradientH(posX, posY, width, height, _ptr_4, _ptr_5)

  def DrawRectangleGradientV(posX: CInt, posY: CInt, width: CInt, height: CInt, color1: Color, color2: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color1
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color2
    __sn_wrap_DrawRectangleGradientV(posX, posY, width, height, _ptr_4, _ptr_5)

  def DrawRectangleLines(posX: CInt, posY: CInt, width: CInt, height: CInt, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawRectangleLines(posX, posY, width, height, _ptr_4)

  def DrawRectangleLinesEx(rec: Rectangle, lineThick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawRectangleLinesEx(_ptr_0, lineThick, _ptr_2)

  def DrawRectanglePro(rec: Rectangle, origin: Vector2, rotation: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = origin
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawRectanglePro(_ptr_0, _ptr_1, rotation, _ptr_3)

  def DrawRectangleRec(rec: Rectangle, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_DrawRectangleRec(_ptr_0, _ptr_1)

  def DrawRectangleRounded(rec: Rectangle, roundness: Float, segments: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawRectangleRounded(_ptr_0, roundness, segments, _ptr_3)

  def DrawRectangleRoundedLines(rec: Rectangle, roundness: Float, segments: CInt, lineThick: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawRectangleRoundedLines(_ptr_0, roundness, segments, lineThick, _ptr_4)

  def DrawRectangleV(position: Vector2, size: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = size
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawRectangleV(_ptr_0, _ptr_1, _ptr_2)

  def DrawRing(center: Vector2, innerRadius: Float, outerRadius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_6 = alloc[Color](1)
    !_ptr_6 = color
    __sn_wrap_DrawRing(_ptr_0, innerRadius, outerRadius, startAngle, endAngle, segments, _ptr_6)

  def DrawRingLines(center: Vector2, innerRadius: Float, outerRadius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = center
    val _ptr_6 = alloc[Color](1)
    !_ptr_6 = color
    __sn_wrap_DrawRingLines(_ptr_0, innerRadius, outerRadius, startAngle, endAngle, segments, _ptr_6)

  def DrawSphere(centerPos: Vector3, radius: Float, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = centerPos
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawSphere(_ptr_0, radius, _ptr_2)

  def DrawSphereEx(centerPos: Vector3, radius: Float, rings: CInt, slices: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = centerPos
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawSphereEx(_ptr_0, radius, rings, slices, _ptr_4)

  def DrawSphereWires(centerPos: Vector3, radius: Float, rings: CInt, slices: CInt, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = centerPos
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawSphereWires(_ptr_0, radius, rings, slices, _ptr_4)

  def DrawText(text: CString, posX: CInt, posY: CInt, fontSize: CInt, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_DrawText(text, posX, posY, fontSize, _ptr_4)

  def DrawTextCodepoint(font: Font, codepoint: CInt, position: Vector2, fontSize: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = position
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = tint
    __sn_wrap_DrawTextCodepoint(_ptr_0, codepoint, _ptr_2, fontSize, _ptr_4)

  def DrawTextEx(font: Font, text: CString, position: Vector2, fontSize: Float, spacing: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = position
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawTextEx(_ptr_0, text, _ptr_2, fontSize, spacing, _ptr_5)

  def DrawTextPro(font: Font, text: CString, position: Vector2, origin: Vector2, rotation: Float, fontSize: Float, spacing: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = position
    val _ptr_3 = alloc[Vector2](1)
    !_ptr_3 = origin
    val _ptr_7 = alloc[Color](1)
    !_ptr_7 = tint
    __sn_wrap_DrawTextPro(_ptr_0, text, _ptr_2, _ptr_3, rotation, fontSize, spacing, _ptr_7)

  def DrawTexture(texture: Texture2D, posX: CInt, posY: CInt, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = tint
    __sn_wrap_DrawTexture(_ptr_0, posX, posY, _ptr_3)

  def DrawTextureEx(texture: Texture2D, position: Vector2, rotation: Float, scale: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = position
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = tint
    __sn_wrap_DrawTextureEx(_ptr_0, _ptr_1, rotation, scale, _ptr_4)

  def DrawTextureNPatch(texture: Texture2D, nPatchInfo: NPatchInfo, dest: Rectangle, origin: Vector2, rotation: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[NPatchInfo](1)
    !_ptr_1 = nPatchInfo
    val _ptr_2 = alloc[Rectangle](1)
    !_ptr_2 = dest
    val _ptr_3 = alloc[Vector2](1)
    !_ptr_3 = origin
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawTextureNPatch(_ptr_0, _ptr_1, _ptr_2, _ptr_3, rotation, _ptr_5)

  def DrawTexturePoly(texture: Texture2D, center: Vector2, points: Ptr[Vector2], texcoords: Ptr[Vector2], pointCount: CInt, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = center
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawTexturePoly(_ptr_0, _ptr_1, points, texcoords, pointCount, _ptr_5)

  def DrawTexturePro(texture: Texture2D, source: Rectangle, dest: Rectangle, origin: Vector2, rotation: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = source
    val _ptr_2 = alloc[Rectangle](1)
    !_ptr_2 = dest
    val _ptr_3 = alloc[Vector2](1)
    !_ptr_3 = origin
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = tint
    __sn_wrap_DrawTexturePro(_ptr_0, _ptr_1, _ptr_2, _ptr_3, rotation, _ptr_5)

  def DrawTextureQuad(texture: Texture2D, tiling: Vector2, offset: Vector2, quad: Rectangle, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = tiling
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = offset
    val _ptr_3 = alloc[Rectangle](1)
    !_ptr_3 = quad
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = tint
    __sn_wrap_DrawTextureQuad(_ptr_0, _ptr_1, _ptr_2, _ptr_3, _ptr_4)

  def DrawTextureRec(texture: Texture2D, source: Rectangle, position: Vector2, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = source
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = position
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = tint
    __sn_wrap_DrawTextureRec(_ptr_0, _ptr_1, _ptr_2, _ptr_3)

  def DrawTextureTiled(texture: Texture2D, source: Rectangle, dest: Rectangle, origin: Vector2, rotation: Float, scale: Float, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = source
    val _ptr_2 = alloc[Rectangle](1)
    !_ptr_2 = dest
    val _ptr_3 = alloc[Vector2](1)
    !_ptr_3 = origin
    val _ptr_6 = alloc[Color](1)
    !_ptr_6 = tint
    __sn_wrap_DrawTextureTiled(_ptr_0, _ptr_1, _ptr_2, _ptr_3, rotation, scale, _ptr_6)

  def DrawTextureV(texture: Texture2D, position: Vector2, tint: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = position
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = tint
    __sn_wrap_DrawTextureV(_ptr_0, _ptr_1, _ptr_2)

  def DrawTriangle(v1: Vector2, v2: Vector2, v3: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = v1
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = v2
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = v3
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawTriangle(_ptr_0, _ptr_1, _ptr_2, _ptr_3)

  def DrawTriangle3D(v1: Vector3, v2: Vector3, v3: Vector3, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = v1
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = v2
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = v3
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawTriangle3D(_ptr_0, _ptr_1, _ptr_2, _ptr_3)

  def DrawTriangleFan(points: Ptr[Vector2], pointCount: CInt, color: Color)(using Zone): Unit = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawTriangleFan(points, pointCount, _ptr_2)

  def DrawTriangleLines(v1: Vector2, v2: Vector2, v3: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = v1
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = v2
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = v3
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_DrawTriangleLines(_ptr_0, _ptr_1, _ptr_2, _ptr_3)

  def DrawTriangleStrip(points: Ptr[Vector2], pointCount: CInt, color: Color)(using Zone): Unit = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawTriangleStrip(points, pointCount, _ptr_2)

  def DrawTriangleStrip3D(points: Ptr[Vector3], pointCount: CInt, color: Color)(using Zone): Unit = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_DrawTriangleStrip3D(points, pointCount, _ptr_2)

  def Fade(color: Color, alpha: Float)(using Zone): Color = 
    val _ptr_0 = alloc[Color](1)
    !_ptr_0 = color
    val _ptr_return = alloc[Color](1)
    __sn_wrap_Fade(_ptr_0, alpha, _ptr_return)
    !_ptr_return

  def GenImageCellular(width: CInt, height: CInt, tileSize: CInt)(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageCellular(width, height, tileSize, _ptr_return)
    !_ptr_return

  def GenImageChecked(width: CInt, height: CInt, checksX: CInt, checksY: CInt, col1: Color, col2: Color)(using Zone): Image = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = col1
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = col2
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageChecked(width, height, checksX, checksY, _ptr_4, _ptr_5, _ptr_return)
    !_ptr_return

  def GenImageColor(width: CInt, height: CInt, color: Color)(using Zone): Image = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageColor(width, height, _ptr_2, _ptr_return)
    !_ptr_return

  def GenImageFontAtlas(chars: Ptr[GlyphInfo], recs: Ptr[Ptr[Rectangle]], glyphCount: CInt, fontSize: CInt, padding: CInt, packMethod: CInt)(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageFontAtlas(chars, recs, glyphCount, fontSize, padding, packMethod, _ptr_return)
    !_ptr_return

  def GenImageGradientH(width: CInt, height: CInt, left: Color, right: Color)(using Zone): Image = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = left
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = right
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageGradientH(width, height, _ptr_2, _ptr_3, _ptr_return)
    !_ptr_return

  def GenImageGradientRadial(width: CInt, height: CInt, density: Float, inner: Color, outer: Color)(using Zone): Image = 
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = inner
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = outer
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageGradientRadial(width, height, density, _ptr_3, _ptr_4, _ptr_return)
    !_ptr_return

  def GenImageGradientV(width: CInt, height: CInt, top: Color, bottom: Color)(using Zone): Image = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = top
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = bottom
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageGradientV(width, height, _ptr_2, _ptr_3, _ptr_return)
    !_ptr_return

  def GenImageWhiteNoise(width: CInt, height: CInt, factor: Float)(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_GenImageWhiteNoise(width, height, factor, _ptr_return)
    !_ptr_return

  def GenMeshCone(radius: Float, height: Float, slices: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshCone(radius, height, slices, _ptr_return)
    !_ptr_return

  def GenMeshCube(width: Float, height: Float, length: Float)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshCube(width, height, length, _ptr_return)
    !_ptr_return

  def GenMeshCubicmap(cubicmap: Image, cubeSize: Vector3)(using Zone): Mesh = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = cubicmap
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = cubeSize
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshCubicmap(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GenMeshCylinder(radius: Float, height: Float, slices: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshCylinder(radius, height, slices, _ptr_return)
    !_ptr_return

  def GenMeshHeightmap(heightmap: Image, size: Vector3)(using Zone): Mesh = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = heightmap
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = size
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshHeightmap(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GenMeshHemiSphere(radius: Float, rings: CInt, slices: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshHemiSphere(radius, rings, slices, _ptr_return)
    !_ptr_return

  def GenMeshKnot(radius: Float, size: Float, radSeg: CInt, sides: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshKnot(radius, size, radSeg, sides, _ptr_return)
    !_ptr_return

  def GenMeshPlane(width: Float, length: Float, resX: CInt, resZ: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshPlane(width, length, resX, resZ, _ptr_return)
    !_ptr_return

  def GenMeshPoly(sides: CInt, radius: Float)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshPoly(sides, radius, _ptr_return)
    !_ptr_return

  def GenMeshSphere(radius: Float, rings: CInt, slices: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshSphere(radius, rings, slices, _ptr_return)
    !_ptr_return

  def GenMeshTorus(radius: Float, size: Float, radSeg: CInt, sides: CInt)(using Zone): Mesh = 
    val _ptr_return = alloc[Mesh](1)
    __sn_wrap_GenMeshTorus(radius, size, radSeg, sides, _ptr_return)
    !_ptr_return

  def GetCameraMatrix(camera: Camera)(using Zone): Matrix = 
    val _ptr_0 = alloc[Camera](1)
    !_ptr_0 = camera
    val _ptr_return = alloc[Matrix](1)
    __sn_wrap_GetCameraMatrix(_ptr_0, _ptr_return)
    !_ptr_return

  def GetCameraMatrix2D(camera: Camera2D)(using Zone): Matrix = 
    val _ptr_0 = alloc[Camera2D](1)
    !_ptr_0 = camera
    val _ptr_return = alloc[Matrix](1)
    __sn_wrap_GetCameraMatrix2D(_ptr_0, _ptr_return)
    !_ptr_return

  def GetCollisionRec(rec1: Rectangle, rec2: Rectangle)(using Zone): Rectangle = 
    val _ptr_0 = alloc[Rectangle](1)
    !_ptr_0 = rec1
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = rec2
    val _ptr_return = alloc[Rectangle](1)
    __sn_wrap_GetCollisionRec(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetColor(hexValue: CUnsignedInt)(using Zone): Color = 
    val _ptr_return = alloc[Color](1)
    __sn_wrap_GetColor(hexValue, _ptr_return)
    !_ptr_return

  def GetFontDefault()(using Zone): Font = 
    val _ptr_return = alloc[Font](1)
    __sn_wrap_GetFontDefault(_ptr_return)
    !_ptr_return

  def GetGestureDragVector()(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetGestureDragVector(_ptr_return)
    !_ptr_return

  def GetGesturePinchVector()(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetGesturePinchVector(_ptr_return)
    !_ptr_return

  def GetGlyphAtlasRec(font: Font, codepoint: CInt)(using Zone): Rectangle = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_return = alloc[Rectangle](1)
    __sn_wrap_GetGlyphAtlasRec(_ptr_0, codepoint, _ptr_return)
    !_ptr_return

  def GetGlyphIndex(font: Font, codepoint: CInt)(using Zone): CInt = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    __sn_wrap_GetGlyphIndex(_ptr_0, codepoint)

  def GetGlyphInfo(font: Font, codepoint: CInt)(using Zone): GlyphInfo = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_return = alloc[GlyphInfo](1)
    __sn_wrap_GetGlyphInfo(_ptr_0, codepoint, _ptr_return)
    !_ptr_return

  def GetImageAlphaBorder(image: Image, threshold: Float)(using Zone): Rectangle = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_return = alloc[Rectangle](1)
    __sn_wrap_GetImageAlphaBorder(_ptr_0, threshold, _ptr_return)
    !_ptr_return

  def GetImageColor(image: Image, x: CInt, y: CInt)(using Zone): Color = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_return = alloc[Color](1)
    __sn_wrap_GetImageColor(_ptr_0, x, y, _ptr_return)
    !_ptr_return

  def GetMeshBoundingBox(mesh: Mesh)(using Zone): BoundingBox = 
    val _ptr_0 = alloc[Mesh](1)
    !_ptr_0 = mesh
    val _ptr_return = alloc[BoundingBox](1)
    __sn_wrap_GetMeshBoundingBox(_ptr_0, _ptr_return)
    !_ptr_return

  def GetModelBoundingBox(model: Model)(using Zone): BoundingBox = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    val _ptr_return = alloc[BoundingBox](1)
    __sn_wrap_GetModelBoundingBox(_ptr_0, _ptr_return)
    !_ptr_return

  def GetMonitorPosition(monitor: CInt)(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetMonitorPosition(monitor, _ptr_return)
    !_ptr_return

  def GetMouseDelta()(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetMouseDelta(_ptr_return)
    !_ptr_return

  def GetMousePosition()(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetMousePosition(_ptr_return)
    !_ptr_return

  def GetMouseRay(mousePosition: Vector2, camera: Camera)(using Zone): Ray = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = mousePosition
    val _ptr_1 = alloc[Camera](1)
    !_ptr_1 = camera
    val _ptr_return = alloc[Ray](1)
    __sn_wrap_GetMouseRay(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetMusicTimeLength(music: Music)(using Zone): Float = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_GetMusicTimeLength(_ptr_0)

  def GetMusicTimePlayed(music: Music)(using Zone): Float = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_GetMusicTimePlayed(_ptr_0)

  def GetPixelColor(srcPtr: Ptr[Byte], format: CInt)(using Zone): Color = 
    val _ptr_return = alloc[Color](1)
    __sn_wrap_GetPixelColor(srcPtr, format, _ptr_return)
    !_ptr_return

  def GetRayCollisionBox(ray: Ray, box: BoundingBox)(using Zone): RayCollision = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[BoundingBox](1)
    !_ptr_1 = box
    val _ptr_return = alloc[RayCollision](1)
    __sn_wrap_GetRayCollisionBox(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetRayCollisionMesh(ray: Ray, mesh: Mesh, transform: Matrix)(using Zone): RayCollision = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[Mesh](1)
    !_ptr_1 = mesh
    val _ptr_2 = alloc[Matrix](1)
    !_ptr_2 = transform
    val _ptr_return = alloc[RayCollision](1)
    __sn_wrap_GetRayCollisionMesh(_ptr_0, _ptr_1, _ptr_2, _ptr_return)
    !_ptr_return

  def GetRayCollisionModel(ray: Ray, model: Model)(using Zone): RayCollision = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[Model](1)
    !_ptr_1 = model
    val _ptr_return = alloc[RayCollision](1)
    __sn_wrap_GetRayCollisionModel(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetRayCollisionQuad(ray: Ray, p1: Vector3, p2: Vector3, p3: Vector3, p4: Vector3)(using Zone): RayCollision = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = p1
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = p2
    val _ptr_3 = alloc[Vector3](1)
    !_ptr_3 = p3
    val _ptr_4 = alloc[Vector3](1)
    !_ptr_4 = p4
    val _ptr_return = alloc[RayCollision](1)
    __sn_wrap_GetRayCollisionQuad(_ptr_0, _ptr_1, _ptr_2, _ptr_3, _ptr_4, _ptr_return)
    !_ptr_return

  def GetRayCollisionSphere(ray: Ray, center: Vector3, radius: Float)(using Zone): RayCollision = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = center
    val _ptr_return = alloc[RayCollision](1)
    __sn_wrap_GetRayCollisionSphere(_ptr_0, _ptr_1, radius, _ptr_return)
    !_ptr_return

  def GetRayCollisionTriangle(ray: Ray, p1: Vector3, p2: Vector3, p3: Vector3)(using Zone): RayCollision = 
    val _ptr_0 = alloc[Ray](1)
    !_ptr_0 = ray
    val _ptr_1 = alloc[Vector3](1)
    !_ptr_1 = p1
    val _ptr_2 = alloc[Vector3](1)
    !_ptr_2 = p2
    val _ptr_3 = alloc[Vector3](1)
    !_ptr_3 = p3
    val _ptr_return = alloc[RayCollision](1)
    __sn_wrap_GetRayCollisionTriangle(_ptr_0, _ptr_1, _ptr_2, _ptr_3, _ptr_return)
    !_ptr_return

  def GetScreenToWorld2D(position: Vector2, camera: Camera2D)(using Zone): Vector2 = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Camera2D](1)
    !_ptr_1 = camera
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetScreenToWorld2D(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetShaderLocation(shader: Shader, uniformName: CString)(using Zone): CInt = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    __sn_wrap_GetShaderLocation(_ptr_0, uniformName)

  def GetShaderLocationAttrib(shader: Shader, attribName: CString)(using Zone): CInt = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    __sn_wrap_GetShaderLocationAttrib(_ptr_0, attribName)

  def GetTouchPosition(index: CInt)(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetTouchPosition(index, _ptr_return)
    !_ptr_return

  def GetWindowPosition()(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetWindowPosition(_ptr_return)
    !_ptr_return

  def GetWindowScaleDPI()(using Zone): Vector2 = 
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetWindowScaleDPI(_ptr_return)
    !_ptr_return

  def GetWorldToScreen(position: Vector3, camera: Camera)(using Zone): Vector2 = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Camera](1)
    !_ptr_1 = camera
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetWorldToScreen(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetWorldToScreen2D(position: Vector2, camera: Camera2D)(using Zone): Vector2 = 
    val _ptr_0 = alloc[Vector2](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Camera2D](1)
    !_ptr_1 = camera
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetWorldToScreen2D(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def GetWorldToScreenEx(position: Vector3, camera: Camera, width: CInt, height: CInt)(using Zone): Vector2 = 
    val _ptr_0 = alloc[Vector3](1)
    !_ptr_0 = position
    val _ptr_1 = alloc[Camera](1)
    !_ptr_1 = camera
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_GetWorldToScreenEx(_ptr_0, _ptr_1, width, height, _ptr_return)
    !_ptr_return

  def ImageAlphaClear(image: Ptr[Image], color: Color, threshold: Float)(using Zone): Unit = 
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_ImageAlphaClear(image, _ptr_1, threshold)

  def ImageAlphaMask(image: Ptr[Image], alphaMask: Image)(using Zone): Unit = 
    val _ptr_1 = alloc[Image](1)
    !_ptr_1 = alphaMask
    __sn_wrap_ImageAlphaMask(image, _ptr_1)

  def ImageClearBackground(dst: Ptr[Image], color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_ImageClearBackground(dst, _ptr_1)

  def ImageColorReplace(image: Ptr[Image], color: Color, replace: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = replace
    __sn_wrap_ImageColorReplace(image, _ptr_1, _ptr_2)

  def ImageColorTint(image: Ptr[Image], color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_ImageColorTint(image, _ptr_1)

  def ImageCopy(image: Image)(using Zone): Image = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_return = alloc[Image](1)
    __sn_wrap_ImageCopy(_ptr_0, _ptr_return)
    !_ptr_return

  def ImageCrop(image: Ptr[Image], crop: Rectangle)(using Zone): Unit = 
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = crop
    __sn_wrap_ImageCrop(image, _ptr_1)

  def ImageDraw(dst: Ptr[Image], src: Image, srcRec: Rectangle, dstRec: Rectangle, tint: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Image](1)
    !_ptr_1 = src
    val _ptr_2 = alloc[Rectangle](1)
    !_ptr_2 = srcRec
    val _ptr_3 = alloc[Rectangle](1)
    !_ptr_3 = dstRec
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = tint
    __sn_wrap_ImageDraw(dst, _ptr_1, _ptr_2, _ptr_3, _ptr_4)

  def ImageDrawCircle(dst: Ptr[Image], centerX: CInt, centerY: CInt, radius: CInt, color: Color)(using Zone): Unit = 
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = color
    __sn_wrap_ImageDrawCircle(dst, centerX, centerY, radius, _ptr_4)

  def ImageDrawCircleV(dst: Ptr[Image], center: Vector2, radius: CInt, color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = center
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_ImageDrawCircleV(dst, _ptr_1, radius, _ptr_3)

  def ImageDrawLine(dst: Ptr[Image], startPosX: CInt, startPosY: CInt, endPosX: CInt, endPosY: CInt, color: Color)(using Zone): Unit = 
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_ImageDrawLine(dst, startPosX, startPosY, endPosX, endPosY, _ptr_5)

  def ImageDrawLineV(dst: Ptr[Image], start: Vector2, end: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = start
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = end
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_ImageDrawLineV(dst, _ptr_1, _ptr_2, _ptr_3)

  def ImageDrawPixel(dst: Ptr[Image], posX: CInt, posY: CInt, color: Color)(using Zone): Unit = 
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_ImageDrawPixel(dst, posX, posY, _ptr_3)

  def ImageDrawPixelV(dst: Ptr[Image], position: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = position
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_ImageDrawPixelV(dst, _ptr_1, _ptr_2)

  def ImageDrawRectangle(dst: Ptr[Image], posX: CInt, posY: CInt, width: CInt, height: CInt, color: Color)(using Zone): Unit = 
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_ImageDrawRectangle(dst, posX, posY, width, height, _ptr_5)

  def ImageDrawRectangleLines(dst: Ptr[Image], rec: Rectangle, thick: CInt, color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = rec
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_ImageDrawRectangleLines(dst, _ptr_1, thick, _ptr_3)

  def ImageDrawRectangleRec(dst: Ptr[Image], rec: Rectangle, color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = rec
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    __sn_wrap_ImageDrawRectangleRec(dst, _ptr_1, _ptr_2)

  def ImageDrawRectangleV(dst: Ptr[Image], position: Vector2, size: Vector2, color: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Vector2](1)
    !_ptr_1 = position
    val _ptr_2 = alloc[Vector2](1)
    !_ptr_2 = size
    val _ptr_3 = alloc[Color](1)
    !_ptr_3 = color
    __sn_wrap_ImageDrawRectangleV(dst, _ptr_1, _ptr_2, _ptr_3)

  def ImageDrawText(dst: Ptr[Image], text: CString, posX: CInt, posY: CInt, fontSize: CInt, color: Color)(using Zone): Unit = 
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = color
    __sn_wrap_ImageDrawText(dst, text, posX, posY, fontSize, _ptr_5)

  def ImageDrawTextEx(dst: Ptr[Image], font: Font, text: CString, position: Vector2, fontSize: Float, spacing: Float, tint: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Font](1)
    !_ptr_1 = font
    val _ptr_3 = alloc[Vector2](1)
    !_ptr_3 = position
    val _ptr_6 = alloc[Color](1)
    !_ptr_6 = tint
    __sn_wrap_ImageDrawTextEx(dst, _ptr_1, text, _ptr_3, fontSize, spacing, _ptr_6)

  def ImageFromImage(image: Image, rec: Rectangle)(using Zone): Image = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = rec
    val _ptr_return = alloc[Image](1)
    __sn_wrap_ImageFromImage(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def ImageResizeCanvas(image: Ptr[Image], newWidth: CInt, newHeight: CInt, offsetX: CInt, offsetY: CInt, fill: Color)(using Zone): Unit = 
    val _ptr_5 = alloc[Color](1)
    !_ptr_5 = fill
    __sn_wrap_ImageResizeCanvas(image, newWidth, newHeight, offsetX, offsetY, _ptr_5)

  def ImageText(text: CString, fontSize: CInt, color: Color)(using Zone): Image = 
    val _ptr_2 = alloc[Color](1)
    !_ptr_2 = color
    val _ptr_return = alloc[Image](1)
    __sn_wrap_ImageText(text, fontSize, _ptr_2, _ptr_return)
    !_ptr_return

  def ImageTextEx(font: Font, text: CString, fontSize: Float, spacing: Float, tint: Color)(using Zone): Image = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_4 = alloc[Color](1)
    !_ptr_4 = tint
    val _ptr_return = alloc[Image](1)
    __sn_wrap_ImageTextEx(_ptr_0, text, fontSize, spacing, _ptr_4, _ptr_return)
    !_ptr_return

  def ImageToPOT(image: Ptr[Image], fill: Color)(using Zone): Unit = 
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = fill
    __sn_wrap_ImageToPOT(image, _ptr_1)

  def LoadAudioStream(sampleRate: CUnsignedInt, sampleSize: CUnsignedInt, channels: CUnsignedInt)(using Zone): AudioStream = 
    val _ptr_return = alloc[AudioStream](1)
    __sn_wrap_LoadAudioStream(sampleRate, sampleSize, channels, _ptr_return)
    !_ptr_return

  def LoadFont(fileName: CString)(using Zone): Font = 
    val _ptr_return = alloc[Font](1)
    __sn_wrap_LoadFont(fileName, _ptr_return)
    !_ptr_return

  def LoadFontEx(fileName: CString, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt)(using Zone): Font = 
    val _ptr_return = alloc[Font](1)
    __sn_wrap_LoadFontEx(fileName, fontSize, fontChars, glyphCount, _ptr_return)
    !_ptr_return

  def LoadFontFromImage(image: Image, key: Color, firstChar: CInt)(using Zone): Font = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = key
    val _ptr_return = alloc[Font](1)
    __sn_wrap_LoadFontFromImage(_ptr_0, _ptr_1, firstChar, _ptr_return)
    !_ptr_return

  def LoadFontFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt)(using Zone): Font = 
    val _ptr_return = alloc[Font](1)
    __sn_wrap_LoadFontFromMemory(fileType, fileData, dataSize, fontSize, fontChars, glyphCount, _ptr_return)
    !_ptr_return

  def LoadImage(fileName: CString)(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_LoadImage(fileName, _ptr_return)
    !_ptr_return

  def LoadImageAnim(fileName: CString, frames: Ptr[CInt])(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_LoadImageAnim(fileName, frames, _ptr_return)
    !_ptr_return

  def LoadImageColors(image: Image)(using Zone): Ptr[Color] = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    __sn_wrap_LoadImageColors(_ptr_0)

  def LoadImageFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt)(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_LoadImageFromMemory(fileType, fileData, dataSize, _ptr_return)
    !_ptr_return

  def LoadImageFromScreen()(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_LoadImageFromScreen(_ptr_return)
    !_ptr_return

  def LoadImageFromTexture(texture: Texture2D)(using Zone): Image = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_return = alloc[Image](1)
    __sn_wrap_LoadImageFromTexture(_ptr_0, _ptr_return)
    !_ptr_return

  def LoadImagePalette(image: Image, maxPaletteSize: CInt, colorCount: Ptr[CInt])(using Zone): Ptr[Color] = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    __sn_wrap_LoadImagePalette(_ptr_0, maxPaletteSize, colorCount)

  def LoadImageRaw(fileName: CString, width: CInt, height: CInt, format: CInt, headerSize: CInt)(using Zone): Image = 
    val _ptr_return = alloc[Image](1)
    __sn_wrap_LoadImageRaw(fileName, width, height, format, headerSize, _ptr_return)
    !_ptr_return

  def LoadMaterialDefault()(using Zone): Material = 
    val _ptr_return = alloc[Material](1)
    __sn_wrap_LoadMaterialDefault(_ptr_return)
    !_ptr_return

  def LoadModel(fileName: CString)(using Zone): Model = 
    val _ptr_return = alloc[Model](1)
    __sn_wrap_LoadModel(fileName, _ptr_return)
    !_ptr_return

  def LoadModelFromMesh(mesh: Mesh)(using Zone): Model = 
    val _ptr_0 = alloc[Mesh](1)
    !_ptr_0 = mesh
    val _ptr_return = alloc[Model](1)
    __sn_wrap_LoadModelFromMesh(_ptr_0, _ptr_return)
    !_ptr_return

  def LoadMusicStream(fileName: CString)(using Zone): Music = 
    val _ptr_return = alloc[Music](1)
    __sn_wrap_LoadMusicStream(fileName, _ptr_return)
    !_ptr_return

  def LoadMusicStreamFromMemory(fileType: CString, data: Ptr[CUnsignedChar], dataSize: CInt)(using Zone): Music = 
    val _ptr_return = alloc[Music](1)
    __sn_wrap_LoadMusicStreamFromMemory(fileType, data, dataSize, _ptr_return)
    !_ptr_return

  def LoadRenderTexture(width: CInt, height: CInt)(using Zone): RenderTexture2D = 
    val _ptr_return = alloc[RenderTexture2D](1)
    __sn_wrap_LoadRenderTexture(width, height, _ptr_return)
    !_ptr_return

  def LoadShader(vsFileName: CString, fsFileName: CString)(using Zone): Shader = 
    val _ptr_return = alloc[Shader](1)
    __sn_wrap_LoadShader(vsFileName, fsFileName, _ptr_return)
    !_ptr_return

  def LoadShaderFromMemory(vsCode: CString, fsCode: CString)(using Zone): Shader = 
    val _ptr_return = alloc[Shader](1)
    __sn_wrap_LoadShaderFromMemory(vsCode, fsCode, _ptr_return)
    !_ptr_return

  def LoadSound(fileName: CString)(using Zone): Sound = 
    val _ptr_return = alloc[Sound](1)
    __sn_wrap_LoadSound(fileName, _ptr_return)
    !_ptr_return

  def LoadSoundFromWave(wave: Wave)(using Zone): Sound = 
    val _ptr_0 = alloc[Wave](1)
    !_ptr_0 = wave
    val _ptr_return = alloc[Sound](1)
    __sn_wrap_LoadSoundFromWave(_ptr_0, _ptr_return)
    !_ptr_return

  def LoadTexture(fileName: CString)(using Zone): Texture2D = 
    val _ptr_return = alloc[Texture2D](1)
    __sn_wrap_LoadTexture(fileName, _ptr_return)
    !_ptr_return

  def LoadTextureCubemap(image: Image, layout: CInt)(using Zone): TextureCubemap = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_return = alloc[TextureCubemap](1)
    __sn_wrap_LoadTextureCubemap(_ptr_0, layout, _ptr_return)
    !_ptr_return

  def LoadTextureFromImage(image: Image)(using Zone): Texture2D = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    val _ptr_return = alloc[Texture2D](1)
    __sn_wrap_LoadTextureFromImage(_ptr_0, _ptr_return)
    !_ptr_return

  def LoadVrStereoConfig(device: VrDeviceInfo)(using Zone): VrStereoConfig = 
    val _ptr_0 = alloc[VrDeviceInfo](1)
    !_ptr_0 = device
    val _ptr_return = alloc[VrStereoConfig](1)
    __sn_wrap_LoadVrStereoConfig(_ptr_0, _ptr_return)
    !_ptr_return

  def LoadWave(fileName: CString)(using Zone): Wave = 
    val _ptr_return = alloc[Wave](1)
    __sn_wrap_LoadWave(fileName, _ptr_return)
    !_ptr_return

  def LoadWaveFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt)(using Zone): Wave = 
    val _ptr_return = alloc[Wave](1)
    __sn_wrap_LoadWaveFromMemory(fileType, fileData, dataSize, _ptr_return)
    !_ptr_return

  def LoadWaveSamples(wave: Wave)(using Zone): Ptr[Float] = 
    val _ptr_0 = alloc[Wave](1)
    !_ptr_0 = wave
    __sn_wrap_LoadWaveSamples(_ptr_0)

  def MeasureTextEx(font: Font, text: CString, fontSize: Float, spacing: Float)(using Zone): Vector2 = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    val _ptr_return = alloc[Vector2](1)
    __sn_wrap_MeasureTextEx(_ptr_0, text, fontSize, spacing, _ptr_return)
    !_ptr_return

  def PauseAudioStream(stream: AudioStream)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_PauseAudioStream(_ptr_0)

  def PauseMusicStream(music: Music)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_PauseMusicStream(_ptr_0)

  def PauseSound(sound: Sound)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_PauseSound(_ptr_0)

  def PlayAudioStream(stream: AudioStream)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_PlayAudioStream(_ptr_0)

  def PlayMusicStream(music: Music)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_PlayMusicStream(_ptr_0)

  def PlaySound(sound: Sound)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_PlaySound(_ptr_0)

  def PlaySoundMulti(sound: Sound)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_PlaySoundMulti(_ptr_0)

  def ResumeAudioStream(stream: AudioStream)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_ResumeAudioStream(_ptr_0)

  def ResumeMusicStream(music: Music)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_ResumeMusicStream(_ptr_0)

  def ResumeSound(sound: Sound)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_ResumeSound(_ptr_0)

  def SeekMusicStream(music: Music, position: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_SeekMusicStream(_ptr_0, position)

  def SetAudioStreamPitch(stream: AudioStream, pitch: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_SetAudioStreamPitch(_ptr_0, pitch)

  def SetAudioStreamVolume(stream: AudioStream, volume: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_SetAudioStreamVolume(_ptr_0, volume)

  def SetCameraMode(camera: Camera, mode: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Camera](1)
    !_ptr_0 = camera
    __sn_wrap_SetCameraMode(_ptr_0, mode)

  def SetMaterialTexture(material: Ptr[Material], mapType: CInt, texture: Texture2D)(using Zone): Unit = 
    val _ptr_2 = alloc[Texture2D](1)
    !_ptr_2 = texture
    __sn_wrap_SetMaterialTexture(material, mapType, _ptr_2)

  def SetMusicPitch(music: Music, pitch: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_SetMusicPitch(_ptr_0, pitch)

  def SetMusicVolume(music: Music, volume: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_SetMusicVolume(_ptr_0, volume)

  def SetPixelColor(dstPtr: Ptr[Byte], color: Color, format: CInt)(using Zone): Unit = 
    val _ptr_1 = alloc[Color](1)
    !_ptr_1 = color
    __sn_wrap_SetPixelColor(dstPtr, _ptr_1, format)

  def SetShaderValue(shader: Shader, locIndex: CInt, value: Ptr[Byte], uniformType: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    __sn_wrap_SetShaderValue(_ptr_0, locIndex, value, uniformType)

  def SetShaderValueMatrix(shader: Shader, locIndex: CInt, mat: Matrix)(using Zone): Unit = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    val _ptr_2 = alloc[Matrix](1)
    !_ptr_2 = mat
    __sn_wrap_SetShaderValueMatrix(_ptr_0, locIndex, _ptr_2)

  def SetShaderValueTexture(shader: Shader, locIndex: CInt, texture: Texture2D)(using Zone): Unit = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    val _ptr_2 = alloc[Texture2D](1)
    !_ptr_2 = texture
    __sn_wrap_SetShaderValueTexture(_ptr_0, locIndex, _ptr_2)

  def SetShaderValueV(shader: Shader, locIndex: CInt, value: Ptr[Byte], uniformType: CInt, count: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    __sn_wrap_SetShaderValueV(_ptr_0, locIndex, value, uniformType, count)

  def SetShapesTexture(texture: Texture2D, source: Rectangle)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = source
    __sn_wrap_SetShapesTexture(_ptr_0, _ptr_1)

  def SetSoundPitch(sound: Sound, pitch: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_SetSoundPitch(_ptr_0, pitch)

  def SetSoundVolume(sound: Sound, volume: Float)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_SetSoundVolume(_ptr_0, volume)

  def SetTextureFilter(texture: Texture2D, filter: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    __sn_wrap_SetTextureFilter(_ptr_0, filter)

  def SetTextureWrap(texture: Texture2D, wrap: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    __sn_wrap_SetTextureWrap(_ptr_0, wrap)

  def SetWindowIcon(image: Image)(using Zone): Unit = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    __sn_wrap_SetWindowIcon(_ptr_0)

  def StopAudioStream(stream: AudioStream)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_StopAudioStream(_ptr_0)

  def StopMusicStream(music: Music)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_StopMusicStream(_ptr_0)

  def StopSound(sound: Sound)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_StopSound(_ptr_0)

  def UnloadAudioStream(stream: AudioStream)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_UnloadAudioStream(_ptr_0)

  def UnloadFont(font: Font)(using Zone): Unit = 
    val _ptr_0 = alloc[Font](1)
    !_ptr_0 = font
    __sn_wrap_UnloadFont(_ptr_0)

  def UnloadImage(image: Image)(using Zone): Unit = 
    val _ptr_0 = alloc[Image](1)
    !_ptr_0 = image
    __sn_wrap_UnloadImage(_ptr_0)

  def UnloadMaterial(material: Material)(using Zone): Unit = 
    val _ptr_0 = alloc[Material](1)
    !_ptr_0 = material
    __sn_wrap_UnloadMaterial(_ptr_0)

  def UnloadMesh(mesh: Mesh)(using Zone): Unit = 
    val _ptr_0 = alloc[Mesh](1)
    !_ptr_0 = mesh
    __sn_wrap_UnloadMesh(_ptr_0)

  def UnloadModel(model: Model)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    __sn_wrap_UnloadModel(_ptr_0)

  def UnloadModelAnimation(anim: ModelAnimation)(using Zone): Unit = 
    val _ptr_0 = alloc[ModelAnimation](1)
    !_ptr_0 = anim
    __sn_wrap_UnloadModelAnimation(_ptr_0)

  def UnloadModelKeepMeshes(model: Model)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    __sn_wrap_UnloadModelKeepMeshes(_ptr_0)

  def UnloadMusicStream(music: Music)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_UnloadMusicStream(_ptr_0)

  def UnloadRenderTexture(target: RenderTexture2D)(using Zone): Unit = 
    val _ptr_0 = alloc[RenderTexture2D](1)
    !_ptr_0 = target
    __sn_wrap_UnloadRenderTexture(_ptr_0)

  def UnloadShader(shader: Shader)(using Zone): Unit = 
    val _ptr_0 = alloc[Shader](1)
    !_ptr_0 = shader
    __sn_wrap_UnloadShader(_ptr_0)

  def UnloadSound(sound: Sound)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_UnloadSound(_ptr_0)

  def UnloadTexture(texture: Texture2D)(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    __sn_wrap_UnloadTexture(_ptr_0)

  def UnloadVrStereoConfig(config: VrStereoConfig)(using Zone): Unit = 
    val _ptr_0 = alloc[VrStereoConfig](1)
    !_ptr_0 = config
    __sn_wrap_UnloadVrStereoConfig(_ptr_0)

  def UnloadWave(wave: Wave)(using Zone): Unit = 
    val _ptr_0 = alloc[Wave](1)
    !_ptr_0 = wave
    __sn_wrap_UnloadWave(_ptr_0)

  def UpdateAudioStream(stream: AudioStream, data: Ptr[Byte], frameCount: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[AudioStream](1)
    !_ptr_0 = stream
    __sn_wrap_UpdateAudioStream(_ptr_0, data, frameCount)

  def UpdateMeshBuffer(mesh: Mesh, index: CInt, data: Ptr[Byte], dataSize: CInt, offset: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Mesh](1)
    !_ptr_0 = mesh
    __sn_wrap_UpdateMeshBuffer(_ptr_0, index, data, dataSize, offset)

  def UpdateModelAnimation(model: Model, anim: ModelAnimation, frame: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Model](1)
    !_ptr_0 = model
    val _ptr_1 = alloc[ModelAnimation](1)
    !_ptr_1 = anim
    __sn_wrap_UpdateModelAnimation(_ptr_0, _ptr_1, frame)

  def UpdateMusicStream(music: Music)(using Zone): Unit = 
    val _ptr_0 = alloc[Music](1)
    !_ptr_0 = music
    __sn_wrap_UpdateMusicStream(_ptr_0)

  def UpdateSound(sound: Sound, data: Ptr[Byte], sampleCount: CInt)(using Zone): Unit = 
    val _ptr_0 = alloc[Sound](1)
    !_ptr_0 = sound
    __sn_wrap_UpdateSound(_ptr_0, data, sampleCount)

  def UpdateTexture(texture: Texture2D, pixels: Ptr[Byte])(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    __sn_wrap_UpdateTexture(_ptr_0, pixels)

  def UpdateTextureRec(texture: Texture2D, rec: Rectangle, pixels: Ptr[Byte])(using Zone): Unit = 
    val _ptr_0 = alloc[Texture2D](1)
    !_ptr_0 = texture
    val _ptr_1 = alloc[Rectangle](1)
    !_ptr_1 = rec
    __sn_wrap_UpdateTextureRec(_ptr_0, _ptr_1, pixels)

  def WaveCopy(wave: Wave)(using Zone): Wave = 
    val _ptr_0 = alloc[Wave](1)
    !_ptr_0 = wave
    val _ptr_return = alloc[Wave](1)
    __sn_wrap_WaveCopy(_ptr_0, _ptr_return)
    !_ptr_return


