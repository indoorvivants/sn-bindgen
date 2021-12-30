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
    extension (struct: BoneInfo)
      def name: CArray[CChar, Nat.Digit2[Nat._3, Nat._2]] = struct._1
      def name_=(value: CArray[CChar, Nat.Digit2[Nat._3, Nat._2]]): Unit = !struct.at1 = value
      def parent: CInt = struct._2
      def parent_=(value: CInt): Unit = !struct.at2 = value

  opaque type BoundingBox = CStruct2[Vector3, Vector3]
  object BoundingBox:
    given _tag: Tag[BoundingBox] = Tag.materializeCStruct2Tag[Vector3, Vector3]
    extension (struct: BoundingBox)
      def min: Vector3 = struct._1
      def min_=(value: Vector3): Unit = !struct.at1 = value
      def max: Vector3 = struct._2
      def max_=(value: Vector3): Unit = !struct.at2 = value

  opaque type Camera2D = CStruct4[Vector2, Vector2, Float, Float]
  object Camera2D:
    given _tag: Tag[Camera2D] = Tag.materializeCStruct4Tag[Vector2, Vector2, Float, Float]
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
    extension (struct: Ray)
      def position: Vector3 = struct._1
      def position_=(value: Vector3): Unit = !struct.at1 = value
      def direction: Vector3 = struct._2
      def direction_=(value: Vector3): Unit = !struct.at2 = value

  opaque type RayCollision = CStruct4[CInt, Float, Vector3, Vector3]
  object RayCollision:
    given _tag: Tag[RayCollision] = Tag.materializeCStruct4Tag[CInt, Float, Vector3, Vector3]
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
    extension (struct: Shader)
      def id: CUnsignedInt = struct._1
      def id_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def locs: Ptr[CInt] = struct._2
      def locs_=(value: Ptr[CInt]): Unit = !struct.at2 = value

  opaque type Sound = CStruct2[AudioStream, CUnsignedInt]
  object Sound:
    given _tag: Tag[Sound] = Tag.materializeCStruct2Tag[AudioStream, CUnsignedInt]
    extension (struct: Sound)
      def stream: AudioStream = struct._1
      def stream_=(value: AudioStream): Unit = !struct.at1 = value
      def frameCount: CUnsignedInt = struct._2
      def frameCount_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type Texture = CStruct5[CUnsignedInt, CInt, CInt, CInt, CInt]
  object Texture:
    given _tag: Tag[Texture] = Tag.materializeCStruct5Tag[CUnsignedInt, CInt, CInt, CInt, CInt]
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
    extension (struct: Vector2)
      def x: Float = struct._1
      def x_=(value: Float): Unit = !struct.at1 = value
      def y: Float = struct._2
      def y_=(value: Float): Unit = !struct.at2 = value

  opaque type Vector3 = CStruct3[Float, Float, Float]
  object Vector3:
    given _tag: Tag[Vector3] = Tag.materializeCStruct3Tag[Float, Float, Float]
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
@link("ray")
@extern
object functions: 
  import types.*

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPlane(centerPos: Vector3, size: Vector2, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextureRec(texture: Texture2D, source: Rectangle, position: Vector2, tint: Color): Unit = extern

  def GetFileNameWithoutExt(filePath: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadFont(fileName: CString): Font = extern

  def InitAudioDevice(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTexturePro(texture: Texture2D, source: Rectangle, dest: Rectangle, origin: Vector2, rotation: Float, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadFontEx(fileName: CString, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt): Font = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawMesh(mesh: Mesh, material: Material, transform: Matrix): Unit = extern

  def DecompressData(compData: Ptr[CUnsignedChar], compDataLength: CInt, dataLength: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def ImageMipmaps(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageText(text: CString, fontSize: CInt, color: Color): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ResumeAudioStream(stream: AudioStream): Unit = extern

  def EncodeDataBase64(data: Ptr[CUnsignedChar], dataLength: CInt, outputLength: Ptr[CInt]): CString = extern

  def DirectoryExists(): CInt = extern

  def GetMonitorPhysicalHeight(monitor: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadMesh(mesh: Mesh): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetScreenToWorld2D(position: Vector2, camera: Camera2D): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetGlyphAtlasRec(font: Font, codepoint: CInt): Rectangle = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetRayCollisionBox(ray: Ray, box: BoundingBox): RayCollision = extern

  def UnloadCodepoints(codepoints: Ptr[CInt]): Unit = extern

  def GetRenderHeight(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetAudioStreamPitch(stream: AudioStream, pitch: Float): Unit = extern

  def IsGamepadAvailable(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def BeginShaderMode(shader: Shader): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PauseAudioStream(stream: AudioStream): Unit = extern

  def SetMasterVolume(volume: Float): Unit = extern

  def CheckCollisionPointLine(): CInt = extern

  def ImageResizeNN(image: Ptr[Image], newWidth: CInt, newHeight: CInt): Unit = extern

  def IsGamepadButtonDown(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextureQuad(texture: Texture2D, tiling: Vector2, offset: Vector2, quad: Rectangle, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPoly(center: Vector2, sides: CInt, radius: Float, rotation: Float, color: Color): Unit = extern

  def GetMouseWheelMove(): Float = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawModel(model: Model, position: Vector3, scale: Float, tint: Color): Unit = extern

  def GetFileName(filePath: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadMusicStream(fileName: CString): Music = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawBillboard(camera: Camera, texture: Texture2D, position: Vector3, size: Float, tint: Color): Unit = extern

  def LoadFileData(fileName: CString, bytesRead: Ptr[CUnsignedInt]): Ptr[CUnsignedChar] = extern

  def SetGesturesEnabled(flags: CUnsignedInt): Unit = extern

  def SetAudioStreamBufferSizeDefault(size: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetCollisionRec(rec1: Rectangle, rec2: Rectangle): Rectangle = extern

  def GetRenderWidth(): CInt = extern

  def SetRandomSeed(seed: CUnsignedInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ResumeSound(sound: Sound): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMusicTimeLength(music: Music): Float = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateModelAnimation(model: Model, anim: ModelAnimation, frame: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetPixelColor(dstPtr: Ptr[Byte], color: Color, format: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawMeshInstanced(mesh: Mesh, material: Material, transforms: Ptr[Matrix], instances: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadModel(fileName: CString): Model = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PlayAudioStream(stream: AudioStream): Unit = extern

  def TextToLower(text: CString): CString = extern

  def GetGestureDragAngle(): Float = extern

  def SetExitKey(key: CInt): Unit = extern

  def GetDirectoryPath(filePath: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetWorldToScreen2D(position: Vector2, camera: Camera2D): Vector2 = extern

  def IsGamepadButtonReleased(): CInt = extern

  def ImageAlphaPremultiply(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadModel(model: Model): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawCircle(dst: Ptr[Image], centerX: CInt, centerY: CInt, radius: CInt, color: Color): Unit = extern

  def GenTextureMipmaps(texture: Ptr[Texture2D]): Unit = extern

  def DrawGrid(slices: CInt, spacing: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawBillboardRec(camera: Camera, texture: Texture2D, source: Rectangle, position: Vector3, size: Vector2, tint: Color): Unit = extern

  def ExportWaveAsCode(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTriangle3D(v1: Vector3, v2: Vector3, v3: Vector3, color: Color): Unit = extern

  def SetTraceLogLevel(logLevel: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetModelBoundingBox(model: Model): BoundingBox = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadVrStereoConfig(device: VrDeviceInfo): VrStereoConfig = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetShaderLocation(shader: Shader, uniformName: CString): CInt = extern

  def LoadModelAnimations(fileName: CString, animCount: Ptr[CUnsignedInt]): Ptr[ModelAnimation] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshHemiSphere(radius: Float, rings: CInt, slices: CInt): Mesh = extern

  def UnloadFontData(chars: Ptr[GlyphInfo], glyphCount: CInt): Unit = extern

  def GetRandomValue(min: CInt, max: CInt): CInt = extern

  def UnloadFileData(data: Ptr[CUnsignedChar]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshPlane(width: Float, length: Float, resX: CInt, resZ: CInt): Mesh = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetCameraMode(camera: Camera, mode: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageWhiteNoise(width: CInt, height: CInt, factor: Float): Image = extern

  def TextToPascal(text: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadTexture(texture: Texture2D): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadSoundFromWave(wave: Wave): Sound = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetWindowIcon(image: Image): Unit = extern

  def WaitTime(ms: Float): Unit = extern

  def UnloadModelAnimations(animations: Ptr[ModelAnimation], count: CUnsignedInt): Unit = extern

  def EnableCursor(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def StopMusicStream(music: Music): Unit = extern

  def SetGamepadMappings(mappings: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def BeginMode3D(camera: Camera3D): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadShader(vsFileName: CString, fsFileName: CString): Shader = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawModelWires(model: Model, position: Vector3, scale: Float, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadFontFromImage(image: Image, key: Color, firstChar: CInt): Font = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshTorus(radius: Float, size: Float, radSeg: CInt, sides: CInt): Mesh = extern

  def SetLoadFileTextCallback(callback: LoadFileTextCallback): Unit = extern

  def ImageFlipVertical(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMusicTimePlayed(music: Music): Float = extern

  def TextToUpper(text: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetGestureDragVector(): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadModelFromMesh(mesh: Mesh): Model = extern

  def TakeScreenshot(fileName: CString): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPolyLinesEx(center: Vector2, sides: CInt, radius: Float, rotation: Float, lineThick: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircle3D(center: Vector3, radius: Float, rotationAxis: Vector3, rotationAngle: Float, color: Color): Unit = extern

  def ExportMesh(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PlaySound(sound: Sound): Unit = extern

  def IsMouseButtonReleased(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPixelV(position: Vector2, color: Color): Unit = extern

  def SaveStorageValue(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetShaderValueTexture(shader: Shader, locIndex: CInt, texture: Texture2D): Unit = extern

  def SetCameraSmoothZoomControl(keySmoothZoom: CInt): Unit = extern

  def CheckCollisionLines(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPoint3D(position: Vector3, color: Color): Unit = extern

  def SaveFileData(): CInt = extern

  def TextSubtext(text: CString, position: CInt, length: CInt): CString = extern

  def GetGamepadName(gamepad: CInt): CString = extern

  def GetGamepadAxisCount(gamepad: CInt): CInt = extern

  def WaveCrop(wave: Ptr[Wave], initSample: CInt, finalSample: CInt): Unit = extern

  def DecodeDataBase64(data: Ptr[CUnsignedChar], outputLength: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetRayCollisionModel(ray: Ray, model: Model): RayCollision = extern

  def GetScreenWidth(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def StopSound(sound: Sound): Unit = extern

  def ExportImageAsCode(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPixel(posX: CInt, posY: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadAudioStream(stream: AudioStream): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCylinderWiresEx(startPos: Vector3, endPos: Vector3, startRadius: Float, endRadius: Float, sides: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetMusicVolume(music: Music, volume: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleLines(posX: CInt, posY: CInt, width: CInt, height: CInt, color: Color): Unit = extern

  def GetTouchY(): CInt = extern

  def GetMouseY(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadMaterial(material: Material): Unit = extern

  def LoadMaterials(fileName: CString, materialCount: Ptr[CInt]): Ptr[Material] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRing(center: Vector2, innerRadius: Float, outerRadius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color): Unit = extern

  def ImageColorInvert(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetWorldToScreenEx(position: Vector3, camera: Camera, width: CInt, height: CInt): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImageFromScreen(): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTriangleFan(points: Ptr[Vector2], pointCount: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawSphereWires(centerPos: Vector3, radius: Float, rings: CInt, slices: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTriangleStrip(points: Ptr[Vector2], pointCount: CInt, color: Color): Unit = extern

  def DisableCursor(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetTextureFilter(texture: Texture2D, filter: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawModelWiresEx(model: Model, position: Vector3, rotationAxis: Vector3, rotationAngle: Float, scale: Vector3, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircleLines(centerX: CInt, centerY: CInt, radius: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetMaterialTexture(material: Ptr[Material], mapType: CInt, texture: Texture2D): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadVrStereoConfig(config: VrStereoConfig): Unit = extern

  def IsGamepadButtonPressed(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMeshBoundingBox(mesh: Mesh): BoundingBox = extern

  def ShowCursor(): Unit = extern

  def SetTraceLogCallback(callback: TraceLogCallback): Unit = extern

  def ClearWindowState(flags: CUnsignedInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetRayCollisionSphere(ray: Ray, center: Vector3, radius: Float): RayCollision = extern

  def EndVrStereoMode(): Unit = extern

  def IsGestureDetected(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadWave(wave: Wave): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorFromNormalized(normalized: Vector4): Color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadImage(image: Image): Unit = extern

  def CheckCollisionPointRec(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTriangleLines(v1: Vector2, v2: Vector2, v3: Vector2, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorToInt(color: Color): CInt = extern

  def CheckCollisionCircles(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextCodepoint(font: Font, codepoint: CInt, position: Vector2, fontSize: Float, tint: Color): Unit = extern

  def TextFindIndex(text: CString, find: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageTextEx(font: Font, text: CString, fontSize: Float, spacing: Float, tint: Color): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadRenderTexture(target: RenderTexture2D): Unit = extern

  def IsMouseButtonPressed(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawText(dst: Ptr[Image], text: CString, posX: CInt, posY: CInt, fontSize: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetShaderValue(shader: Shader, locIndex: CInt, value: Ptr[Byte], uniformType: CInt): Unit = extern

  def GetMouseX(): CInt = extern

  def SetMouseScale(scaleX: Float, scaleY: Float): Unit = extern

  def GetDroppedFiles(count: Ptr[CInt]): Ptr[CString] = extern

  def GetFileModTime(fileName: CString): CLongInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMonitorPosition(monitor: CInt): Vector2 = extern

  def IsMusicStreamPlaying(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageColor(width: CInt, height: CInt, color: Color): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTexture(texture: Texture2D, posX: CInt, posY: CInt, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadFontFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt): Font = extern

  def GetMonitorWidth(monitor: CInt): CInt = extern

  def GetClipboardText(): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTriangleStrip3D(points: Ptr[Vector3], pointCount: CInt, color: Color): Unit = extern

  def SetSaveFileTextCallback(callback: SaveFileTextCallback): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadWaveFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt): Wave = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshSphere(radius: Float, rings: CInt, slices: CInt): Mesh = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateSound(sound: Sound, data: Ptr[Byte], sampleCount: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTexturePoly(texture: Texture2D, center: Vector2, points: Ptr[Vector2], texcoords: Ptr[Vector2], pointCount: CInt, tint: Color): Unit = extern

  def EndBlendMode(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateMusicStream(music: Music): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateTexture(texture: Texture2D, pixels: Ptr[Byte]): Unit = extern

  def HideCursor(): Unit = extern

  def LoadStorageValue(position: CUnsignedInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshPoly(sides: CInt, radius: Float): Mesh = extern

  def IsFileDropped(): CInt = extern

  def SetWindowMonitor(monitor: CInt): Unit = extern

  def BeginScissorMode(x: CInt, y: CInt, width: CInt, height: CInt): Unit = extern

  def GetWorkingDirectory(): CString = extern

  def UnloadImagePalette(colors: Ptr[Color]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageFontAtlas(chars: Ptr[GlyphInfo], recs: Ptr[Ptr[Rectangle]], glyphCount: CInt, fontSize: CInt, padding: CInt, packMethod: CInt): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadSound(fileName: CString): Sound = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshCube(width: Float, height: Float, length: Float): Mesh = extern

  def ImageColorBrightness(image: Ptr[Image], brightness: CInt): Unit = extern

  def GetMonitorRefreshRate(monitor: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshHeightmap(heightmap: Image, size: Vector3): Mesh = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRingLines(center: Vector2, innerRadius: Float, outerRadius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawBillboardPro(camera: Camera, texture: Texture2D, source: Rectangle, position: Vector3, up: Vector3, size: Vector2, origin: Vector2, rotation: Float, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetRayCollisionTriangle(ray: Ray, p1: Vector3, p2: Vector3, p3: Vector3): RayCollision = extern

  def GetGestureHoldDuration(): Float = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawBoundingBox(box: BoundingBox, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLineBezierQuad(startPos: Vector2, endPos: Vector2, controlPos: Vector2, thick: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawPixelV(dst: Ptr[Image], position: Vector2, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetWorldToScreen(position: Vector3, camera: Camera): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorNormalize(color: Color): Vector4 = extern

  def ImageDither(image: Ptr[Image], rBpp: CInt, gBpp: CInt, bBpp: CInt, aBpp: CInt): Unit = extern

  def SetMouseOffset(offsetX: CInt, offsetY: CInt): Unit = extern

  def TraceLog(logLevel: CInt, text: CString): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImageFromMemory(fileType: CString, fileData: Ptr[CUnsignedChar], dataSize: CInt): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawPolyLines(center: Vector2, sides: CInt, radius: Float, rotation: Float, color: Color): Unit = extern

  def TextToInteger(text: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageChecked(width: CInt, height: CInt, checksX: CInt, checksY: CInt, col1: Color, col2: Color): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleGradientH(posX: CInt, posY: CInt, width: CInt, height: CInt, color1: Color, color2: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawLine(dst: Ptr[Image], startPosX: CInt, startPosY: CInt, endPosX: CInt, endPosY: CInt, color: Color): Unit = extern

  def ImageAlphaCrop(image: Ptr[Image], threshold: Float): Unit = extern

  def CloseAudioDevice(): Unit = extern

  def MemRealloc(ptr: Ptr[Byte], size: CInt): Ptr[Byte] = extern

  def GetTouchPointCount(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageResizeCanvas(image: Ptr[Image], newWidth: CInt, newHeight: CInt, offsetX: CInt, offsetY: CInt, fill: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadModelAnimation(anim: ModelAnimation): Unit = extern

  def CheckCollisionBoxes(): CInt = extern

  def SetWindowPosition(x: CInt, y: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetMusicPitch(music: Music, pitch: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLineBezierCubic(startPos: Vector2, endPos: Vector2, startControlPos: Vector2, endControlPos: Vector2, thick: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageColorTint(image: Ptr[Image], color: Color): Unit = extern

  def GenMeshTangents(mesh: Ptr[Mesh]): Unit = extern

  def ImageRotateCCW(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetImageColor(image: Image, x: CInt, y: CInt): Color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCylinder(position: Vector3, radiusTop: Float, radiusBottom: Float, height: Float, slices: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetWindowPosition(): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def Fade(color: Color, alpha: Float): Color = extern

  def TextLength(text: CString): CUnsignedInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadWave(fileName: CString): Wave = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PlayMusicStream(music: Music): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetGlyphIndex(font: Font, codepoint: CInt): CInt = extern

  def ImageResize(image: Ptr[Image], newWidth: CInt, newHeight: CInt): Unit = extern

  def CodepointToUTF8(codepoint: CInt, byteSize: Ptr[CInt]): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetSoundVolume(sound: Sound, volume: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextureTiled(texture: Texture2D, source: Rectangle, dest: Rectangle, origin: Vector2, rotation: Float, scale: Float, tint: Color): Unit = extern

  def TextInsert(text: CString, insert: CString, position: CInt): CString = extern

  def ImageRotateCW(image: Ptr[Image]): Unit = extern

  def DrawFPS(posX: CInt, posY: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageColorReplace(image: Ptr[Image], color: Color, replace: Color): Unit = extern

  def SetModelMeshMaterial(model: Ptr[Model], meshId: CInt, materialId: CInt): Unit = extern

  def CheckCollisionSpheres(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadSound(sound: Sound): Unit = extern

  def SetCameraAltControl(keyAlt: CInt): Unit = extern

  def GetCodepointCount(text: CString): CInt = extern

  def StopSoundMulti(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetAudioStreamVolume(stream: AudioStream, volume: Float): Unit = extern

  def IsAudioStreamPlaying(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImageColors(image: Image): Ptr[Color] = extern

  def CheckCollisionPointTriangle(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadFont(font: Font): Unit = extern

  def CheckCollisionRecs(): CInt = extern

  def SetWindowMinSize(width: CInt, height: CInt): Unit = extern

  def GetFileExtension(fileName: CString): CString = extern

  def ImageColorContrast(image: Ptr[Image], contrast: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def BeginVrStereoMode(config: VrStereoConfig): Unit = extern

  def IsWindowResized(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetSoundPitch(sound: Sound, pitch: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircleV(center: Vector2, radius: Float, color: Color): Unit = extern

  def TextIsEqual(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImageRaw(fileName: CString, width: CInt, height: CInt, format: CInt, headerSize: CInt): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextPro(font: Font, text: CString, position: Vector2, origin: Vector2, rotation: Float, fontSize: Float, spacing: Float, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageAlphaMask(image: Ptr[Image], alphaMask: Image): Unit = extern

  def GetGamepadButtonPressed(): CInt = extern

  def TextCodepointsToUTF8(codepoints: Ptr[CInt], length: CInt): CString = extern

  def IsKeyUp(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawRectangleLines(dst: Ptr[Image], rec: Rectangle, thick: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLineStrip(points: Ptr[Vector2], pointCount: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetRayCollisionQuad(ray: Ray, p1: Vector3, p2: Vector3, p3: Vector3, p4: Vector3): RayCollision = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextureNPatch(texture: Texture2D, nPatchInfo: NPatchInfo, dest: Rectangle, origin: Vector2, rotation: Float, tint: Color): Unit = extern

  def GetFPS(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawPixel(dst: Ptr[Image], posX: CInt, posY: CInt, color: Color): Unit = extern

  def WaveFormat(wave: Ptr[Wave], sampleRate: CInt, sampleSize: CInt, channels: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadTexture(fileName: CString): Texture2D = extern

  def IsMouseButtonUp(): CInt = extern

  def GetGesturePinchAngle(): Float = extern

  def IsKeyDown(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawRectangleV(dst: Ptr[Image], position: Vector2, size: Vector2, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLineV(startPos: Vector2, endPos: Vector2, color: Color): Unit = extern

  def MeasureText(text: CString, fontSize: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorAlpha(color: Color, alpha: Float): Color = extern

  def ImageColorGrayscale(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawLineV(dst: Ptr[Image], start: Vector2, end: Vector2, color: Color): Unit = extern

  def GetTouchX(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangle(posX: CInt, posY: CInt, width: CInt, height: CInt, color: Color): Unit = extern

  def BeginBlendMode(mode: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateTextureRec(texture: Texture2D, rec: Rectangle, pixels: Ptr[Byte]): Unit = extern

  def SetCameraPanControl(keyPan: CInt): Unit = extern

  def MemFree(ptr: Ptr[Byte]): Unit = extern

  def LoadFileText(fileName: CString): CString = extern

  def GetTouchPointId(index: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageCellular(width: CInt, height: CInt, tileSize: CInt): Image = extern

  def TextReplace(text: CString, replace: CString, by: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawRectangleRec(dst: Ptr[Image], rec: Rectangle, color: Color): Unit = extern

  def GetScreenHeight(): CInt = extern

  def EndScissorMode(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadMusicStream(music: Music): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadMusicStreamFromMemory(fileType: CString, data: Ptr[CUnsignedChar], dataSize: CInt): Music = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImageFromTexture(texture: Texture2D): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshCone(radius: Float, height: Float, slices: CInt): Mesh = extern

  def IsAudioDeviceReady(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLine(startPosX: CInt, startPosY: CInt, endPosX: CInt, endPosY: CInt, color: Color): Unit = extern

  def SetWindowState(flags: CUnsignedInt): Unit = extern

  def GetPrevDirectoryPath(dirPath: CString): CString = extern

  def IsModelAnimationValid(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetShapesTexture(texture: Texture2D, source: Rectangle): Unit = extern

  def TextSplit(text: CString, delimiter: CChar, count: Ptr[CInt]): Ptr[CString] = extern

  def GetCurrentMonitor(): CInt = extern

  def SetTargetFPS(fps: CInt): Unit = extern

  def GetCharPressed(): CInt = extern

  def GetMonitorCount(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadMaterialDefault(): Material = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageGradientH(width: CInt, height: CInt, left: Color, right: Color): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def BeginTextureMode(target: RenderTexture2D): Unit = extern

  def TextJoin(textList: Ptr[CString], count: CInt, delimiter: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetGlyphInfo(font: Font, codepoint: CInt): GlyphInfo = extern

  def SetWindowOpacity(opacity: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawEllipseLines(centerX: CInt, centerY: CInt, radiusH: Float, radiusV: Float, color: Color): Unit = extern

  def ExportImage(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCylinderEx(startPos: Vector3, endPos: Vector3, startRadius: Float, endRadius: Float, sides: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleGradientV(posX: CInt, posY: CInt, width: CInt, height: CInt, color1: Color, color2: Color): Unit = extern

  def ClearDroppedFiles(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImagePalette(image: Image, maxPaletteSize: CInt, colorCount: Ptr[CInt]): Ptr[Color] = extern

  def GetGestureDetected(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircleGradient(centerX: CInt, centerY: CInt, radius: Float, color1: Color, color2: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateMeshBuffer(mesh: Mesh, index: CInt, data: Ptr[Byte], dataSize: CInt, offset: CInt): Unit = extern

  def SetClipboardText(text: CString): Unit = extern

  def IsSoundPlaying(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleLinesEx(rec: Rectangle, lineThick: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawRectangle(dst: Ptr[Image], posX: CInt, posY: CInt, width: CInt, height: CInt, color: Color): Unit = extern

  def SaveFileText(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDraw(dst: Ptr[Image], src: Image, srcRec: Rectangle, dstRec: Rectangle, tint: Color): Unit = extern

  def GetPixelDataSize(width: CInt, height: CInt, format: CInt): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetShaderValueMatrix(shader: Shader, locIndex: CInt, mat: Matrix): Unit = extern

  def GetGamepadAxisMovement(gamepad: CInt, axis: CInt): Float = extern

  def ImageFormat(image: Ptr[Image], newFormat: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTriangle(v1: Vector2, v2: Vector2, v3: Vector2, color: Color): Unit = extern

  def UploadMesh(mesh: Ptr[Mesh], dynamic: bool): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetGesturePinchVector(): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadShaderFromMemory(vsCode: CString, fsCode: CString): Shader = extern

  def EndMode3D(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCubeTexture(texture: Texture2D, position: Vector3, width: Float, height: Float, length: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawText(text: CString, posX: CInt, posY: CInt, fontSize: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLineEx(startPos: Vector2, endPos: Vector2, thick: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageGradientRadial(width: CInt, height: CInt, density: Float, inner: Color, outer: Color): Image = extern

  def UnloadFileText(text: CString): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetShaderValueV(shader: Shader, locIndex: CInt, value: Ptr[Byte], uniformType: CInt, count: CInt): Unit = extern

  def ExportWave(): CInt = extern

  def GetSoundsPlaying(): CInt = extern

  def SetMousePosition(x: CInt, y: CInt): Unit = extern

  def SetLoadFileDataCallback(callback: LoadFileDataCallback): Unit = extern

  def IsWindowFullscreen(): CInt = extern

  def IsWindowMaximized(): CInt = extern

  def SetMouseCursor(cursor: CInt): Unit = extern

  def SetWindowSize(width: CInt, height: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetImageAlphaBorder(image: Image, threshold: Float): Rectangle = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetPixelColor(srcPtr: Ptr[Byte], format: CInt): Color = extern

  def IsCursorOnScreen(): CInt = extern

  def CheckCollisionCircleRec(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetCameraMatrix(camera: Camera): Matrix = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCubeTextureRec(texture: Texture2D, source: Rectangle, position: Vector3, width: Float, height: Float, length: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawSphere(centerPos: Vector3, radius: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageFromImage(image: Image, rec: Rectangle): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UpdateAudioStream(stream: AudioStream, data: Ptr[Byte], frameCount: CInt): Unit = extern

  def UpdateCamera(camera: Ptr[Camera]): Unit = extern

  def ImageFlipHorizontal(image: Ptr[Image]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImage(fileName: CString): Image = extern

  def GetFrameTime(): Float = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageCrop(image: Ptr[Image], crop: Rectangle): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshKnot(radius: Float, size: Float, radSeg: CInt, sides: CInt): Mesh = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadTextureFromImage(image: Image): Texture2D = extern

  def IsKeyReleased(): CInt = extern

  def GetTime(): Double = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircleSectorLines(center: Vector2, radius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color): Unit = extern

  def GetKeyPressed(): CInt = extern

  def RestoreWindow(): Unit = extern

  def BeginDrawing(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ResumeMusicStream(music: Music): Unit = extern

  def TextFormat(text: CString): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircleSector(center: Vector2, radius: Float, startAngle: Float, endAngle: Float, segments: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SeekMusicStream(music: Music, position: Float): Unit = extern

  def SetCameraMoveControls(keyFront: CInt, keyBack: CInt, keyRight: CInt, keyLeft: CInt, keyUp: CInt, keyDown: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextureEx(texture: Texture2D, position: Vector2, rotation: Float, scale: Float, tint: Color): Unit = extern

  def GetMonitorPhysicalWidth(monitor: CInt): CInt = extern

  def TextAppend(text: CString, append: CString, position: Ptr[CInt]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshCylinder(radius: Float, height: Float, slices: CInt): Mesh = extern

  def MinimizeWindow(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadShader(shader: Shader): Unit = extern

  def IsWindowReady(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorFromHSV(hue: Float, saturation: Float, value: Float): Color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def MeasureTextEx(font: Font, text: CString, fontSize: Float, spacing: Float): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadAudioStream(sampleRate: CUnsignedInt, sampleSize: CUnsignedInt, channels: CUnsignedInt): AudioStream = extern

  def IsMouseButtonDown(): CInt = extern

  def OpenURL(url: CString): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCubeV(position: Vector3, size: Vector3, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCubeWires(position: Vector3, width: Float, height: Float, length: Float, color: Color): Unit = extern

  def IsGamepadButtonUp(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorAlphaBlend(dst: Color, src: Color, tint: Color): Color = extern

  def IsWindowFocused(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleGradientEx(rec: Rectangle, col1: Color, col2: Color, col3: Color, col4: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenImageGradientV(width: CInt, height: CInt, top: Color, bottom: Color): Image = extern
  def GetDirectoryFiles(dirPath: CString, count: Ptr[CInt]): Ptr[CString] = extern

  def SwapScreenBuffer(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ClearBackground(color: Color): Unit = extern

  def IsAudioStreamProcessed(): CInt = extern

  def PollInputEvents(): Unit = extern

  def InitWindow(width: CInt, height: CInt, title: CString): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRay(ray: Ray, color: Color): Unit = extern

  def WindowShouldClose(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageClearBackground(dst: Ptr[Image], color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadTextureCubemap(image: Image, layout: CInt): TextureCubemap = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextEx(font: Font, text: CString, position: Vector2, fontSize: Float, spacing: Float, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetFontDefault(): Font = extern

  def ChangeDirectory(): CInt = extern

  def SetWindowTitle(title: CString): Unit = extern

  def MaximizeWindow(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PlaySoundMulti(sound: Sound): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ColorToHSV(color: Color): Vector3 = extern

  def IsWindowHidden(): CInt = extern

  def EndDrawing(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetRayCollisionMesh(ray: Ray, mesh: Mesh, transform: Matrix): RayCollision = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCubeWiresV(position: Vector3, size: Vector3, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLineBezier(startPos: Vector2, endPos: Vector2, thick: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GenMeshCubicmap(cubicmap: Image, cubeSize: Vector3): Mesh = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCylinderWires(position: Vector3, radiusTop: Float, radiusBottom: Float, height: Float, slices: CInt, color: Color): Unit = extern

  def SetConfigFlags(flags: CUnsignedInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadRenderTexture(width: CInt, height: CInt): RenderTexture2D = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageCopy(image: Image): Image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectanglePro(rec: Rectangle, origin: Vector2, rotation: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCircle(centerX: CInt, centerY: CInt, radius: Float, color: Color): Unit = extern

  def CheckCollisionPointCircle(): CInt = extern

  def LoadFontData(fileData: Ptr[CUnsignedChar], dataSize: CInt, fontSize: CInt, fontChars: Ptr[CInt], glyphCount: CInt, `type`: CInt): Ptr[GlyphInfo] = extern

  def TextCopy(dst: CString, src: CString): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawModelEx(model: Model, position: Vector3, rotationAxis: Vector3, rotationAngle: Float, scale: Vector3, tint: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetShaderLocationAttrib(shader: Shader, attribName: CString): CInt = extern

  def IsWindowState(): CInt = extern

  def SetSaveFileDataCallback(callback: CInt): Unit = extern

  def GetWindowHandle(): Ptr[Byte] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawTextEx(dst: Ptr[Image], font: Font, text: CString, position: Vector2, fontSize: Float, spacing: Float, tint: Color): Unit = extern

  def IsWindowMinimized(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawSphereEx(centerPos: Vector3, radius: Float, rings: CInt, slices: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetColor(hexValue: CUnsignedInt): Color = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleV(position: Vector2, size: Vector2, color: Color): Unit = extern

  def EndMode2D(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageAlphaClear(image: Ptr[Image], color: Color, threshold: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def UnloadModelKeepMeshes(model: Model): Unit = extern

  def GenMeshBinormals(mesh: Ptr[Mesh]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetWindowScaleDPI(): Vector2 = extern

  def ToggleFullscreen(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadWaveSamples(wave: Wave): Ptr[Float] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def WaveCopy(wave: Wave): Wave = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawLine3D(startPos: Vector3, endPos: Vector3, color: Color): Unit = extern

  def IsFileExtension(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleRec(rec: Rectangle, color: Color): Unit = extern

  def UnloadImageColors(colors: Ptr[Color]): Unit = extern

  def CloseWindow(): Unit = extern

  def UnloadWaveSamples(samples: Ptr[Float]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMouseRay(mousePosition: Vector2, camera: Camera): Ray = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageDrawCircleV(dst: Ptr[Image], center: Vector2, radius: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def ImageToPOT(image: Ptr[Image], fill: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetTouchPosition(index: CInt): Vector2 = extern

  def GetCodepoint(text: CString, bytesProcessed: Ptr[CInt]): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def BeginMode2D(camera: Camera2D): Unit = extern

  def CompressData(data: Ptr[CUnsignedChar], dataLength: CInt, compDataLength: Ptr[CInt]): Ptr[CUnsignedChar] = extern

  def IsCursorHidden(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def SetTextureWrap(texture: Texture2D, wrap: CInt): Unit = extern

  def FileExists(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PauseSound(sound: Sound): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def StopAudioStream(stream: AudioStream): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleRounded(rec: Rectangle, roundness: Float, segments: CInt, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMousePosition(): Vector2 = extern

  def EndShaderMode(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawCube(position: Vector3, width: Float, height: Float, length: Float, color: Color): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def LoadImageAnim(fileName: CString, frames: Ptr[CInt]): Image = extern

  def MemAlloc(size: CInt): Ptr[Byte] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawTextureV(texture: Texture2D, position: Vector2, tint: Color): Unit = extern

  def GetMonitorHeight(monitor: CInt): CInt = extern

  def EndTextureMode(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetCameraMatrix2D(camera: Camera2D): Matrix = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def PauseMusicStream(music: Music): Unit = extern

  def IsKeyPressed(): CInt = extern

  def GetMonitorName(monitor: CInt): CString = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def GetMouseDelta(): Vector2 = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawEllipse(centerX: CInt, centerY: CInt, radiusH: Float, radiusV: Float, color: Color): Unit = extern

  def CheckCollisionBoxSphere(): CInt = extern

  def LoadCodepoints(text: CString, count: Ptr[CInt]): Ptr[CInt] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def DrawRectangleRoundedLines(rec: Rectangle, roundness: Float, segments: CInt, lineThick: Float, color: Color): Unit = extern

  def ClearDirectoryFiles(): Unit = extern


