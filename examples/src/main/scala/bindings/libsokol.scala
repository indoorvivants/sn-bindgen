package libsokol

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
  opaque type sg_action = CUnsignedInt
  object sg_action extends CEnumU[sg_action]:
    inline def define(inline a: Long): sg_action = a.toUInt
    val _SG_ACTION_DEFAULT = define(0)
    val SG_ACTION_CLEAR = define(1)
    val SG_ACTION_LOAD = define(2)
    val SG_ACTION_DONTCARE = define(3)
    val _SG_ACTION_NUM = define(4)
    val _SG_ACTION_FORCE_U32 = define(2147483647)

  opaque type sg_backend = CUnsignedInt
  object sg_backend extends CEnumU[sg_backend]:
    inline def define(inline a: Long): sg_backend = a.toUInt
    val SG_BACKEND_GLCORE33 = define(0)
    val SG_BACKEND_GLES2 = define(1)
    val SG_BACKEND_GLES3 = define(2)
    val SG_BACKEND_D3D11 = define(3)
    val SG_BACKEND_METAL_IOS = define(4)
    val SG_BACKEND_METAL_MACOS = define(5)
    val SG_BACKEND_METAL_SIMULATOR = define(6)
    val SG_BACKEND_WGPU = define(7)
    val SG_BACKEND_DUMMY = define(8)

  opaque type sg_blend_factor = CUnsignedInt
  object sg_blend_factor extends CEnumU[sg_blend_factor]:
    inline def define(inline a: Long): sg_blend_factor = a.toUInt
    val _SG_BLENDFACTOR_DEFAULT = define(0)
    val SG_BLENDFACTOR_ZERO = define(1)
    val SG_BLENDFACTOR_ONE = define(2)
    val SG_BLENDFACTOR_SRC_COLOR = define(3)
    val SG_BLENDFACTOR_ONE_MINUS_SRC_COLOR = define(4)
    val SG_BLENDFACTOR_SRC_ALPHA = define(5)
    val SG_BLENDFACTOR_ONE_MINUS_SRC_ALPHA = define(6)
    val SG_BLENDFACTOR_DST_COLOR = define(7)
    val SG_BLENDFACTOR_ONE_MINUS_DST_COLOR = define(8)
    val SG_BLENDFACTOR_DST_ALPHA = define(9)
    val SG_BLENDFACTOR_ONE_MINUS_DST_ALPHA = define(10)
    val SG_BLENDFACTOR_SRC_ALPHA_SATURATED = define(11)
    val SG_BLENDFACTOR_BLEND_COLOR = define(12)
    val SG_BLENDFACTOR_ONE_MINUS_BLEND_COLOR = define(13)
    val SG_BLENDFACTOR_BLEND_ALPHA = define(14)
    val SG_BLENDFACTOR_ONE_MINUS_BLEND_ALPHA = define(15)
    val _SG_BLENDFACTOR_NUM = define(16)
    val _SG_BLENDFACTOR_FORCE_U32 = define(2147483647)

  opaque type sg_blend_op = CUnsignedInt
  object sg_blend_op extends CEnumU[sg_blend_op]:
    inline def define(inline a: Long): sg_blend_op = a.toUInt
    val _SG_BLENDOP_DEFAULT = define(0)
    val SG_BLENDOP_ADD = define(1)
    val SG_BLENDOP_SUBTRACT = define(2)
    val SG_BLENDOP_REVERSE_SUBTRACT = define(3)
    val _SG_BLENDOP_NUM = define(4)
    val _SG_BLENDOP_FORCE_U32 = define(2147483647)

  opaque type sg_border_color = CUnsignedInt
  object sg_border_color extends CEnumU[sg_border_color]:
    inline def define(inline a: Long): sg_border_color = a.toUInt
    val _SG_BORDERCOLOR_DEFAULT = define(0)
    val SG_BORDERCOLOR_TRANSPARENT_BLACK = define(1)
    val SG_BORDERCOLOR_OPAQUE_BLACK = define(2)
    val SG_BORDERCOLOR_OPAQUE_WHITE = define(3)
    val _SG_BORDERCOLOR_NUM = define(4)
    val _SG_BORDERCOLOR_FORCE_U32 = define(2147483647)

  opaque type sg_buffer_type = CUnsignedInt
  object sg_buffer_type extends CEnumU[sg_buffer_type]:
    inline def define(inline a: Long): sg_buffer_type = a.toUInt
    val _SG_BUFFERTYPE_DEFAULT = define(0)
    val SG_BUFFERTYPE_VERTEXBUFFER = define(1)
    val SG_BUFFERTYPE_INDEXBUFFER = define(2)
    val _SG_BUFFERTYPE_NUM = define(3)
    val _SG_BUFFERTYPE_FORCE_U32 = define(2147483647)

  opaque type sg_color_mask = CUnsignedInt
  object sg_color_mask extends CEnumU[sg_color_mask]:
    inline def define(inline a: Long): sg_color_mask = a.toUInt
    val _SG_COLORMASK_DEFAULT = define(0)
    val SG_COLORMASK_NONE = define(16)
    val SG_COLORMASK_R = define(1)
    val SG_COLORMASK_G = define(2)
    val SG_COLORMASK_RG = define(3)
    val SG_COLORMASK_B = define(4)
    val SG_COLORMASK_RB = define(5)
    val SG_COLORMASK_GB = define(6)
    val SG_COLORMASK_RGB = define(7)
    val SG_COLORMASK_A = define(8)
    val SG_COLORMASK_RA = define(9)
    val SG_COLORMASK_GA = define(10)
    val SG_COLORMASK_RGA = define(11)
    val SG_COLORMASK_BA = define(12)
    val SG_COLORMASK_RBA = define(13)
    val SG_COLORMASK_GBA = define(14)
    val SG_COLORMASK_RGBA = define(15)
    val _SG_COLORMASK_FORCE_U32 = define(2147483647)

  opaque type sg_compare_func = CUnsignedInt
  object sg_compare_func extends CEnumU[sg_compare_func]:
    inline def define(inline a: Long): sg_compare_func = a.toUInt
    val _SG_COMPAREFUNC_DEFAULT = define(0)
    val SG_COMPAREFUNC_NEVER = define(1)
    val SG_COMPAREFUNC_LESS = define(2)
    val SG_COMPAREFUNC_EQUAL = define(3)
    val SG_COMPAREFUNC_LESS_EQUAL = define(4)
    val SG_COMPAREFUNC_GREATER = define(5)
    val SG_COMPAREFUNC_NOT_EQUAL = define(6)
    val SG_COMPAREFUNC_GREATER_EQUAL = define(7)
    val SG_COMPAREFUNC_ALWAYS = define(8)
    val _SG_COMPAREFUNC_NUM = define(9)
    val _SG_COMPAREFUNC_FORCE_U32 = define(2147483647)

  opaque type sg_cube_face = CUnsignedInt
  object sg_cube_face extends CEnumU[sg_cube_face]:
    inline def define(inline a: Long): sg_cube_face = a.toUInt
    val SG_CUBEFACE_POS_X = define(0)
    val SG_CUBEFACE_NEG_X = define(1)
    val SG_CUBEFACE_POS_Y = define(2)
    val SG_CUBEFACE_NEG_Y = define(3)
    val SG_CUBEFACE_POS_Z = define(4)
    val SG_CUBEFACE_NEG_Z = define(5)
    val SG_CUBEFACE_NUM = define(6)
    val _SG_CUBEFACE_FORCE_U32 = define(2147483647)

  opaque type sg_cull_mode = CUnsignedInt
  object sg_cull_mode extends CEnumU[sg_cull_mode]:
    inline def define(inline a: Long): sg_cull_mode = a.toUInt
    val _SG_CULLMODE_DEFAULT = define(0)
    val SG_CULLMODE_NONE = define(1)
    val SG_CULLMODE_FRONT = define(2)
    val SG_CULLMODE_BACK = define(3)
    val _SG_CULLMODE_NUM = define(4)
    val _SG_CULLMODE_FORCE_U32 = define(2147483647)

  opaque type sg_face_winding = CUnsignedInt
  object sg_face_winding extends CEnumU[sg_face_winding]:
    inline def define(inline a: Long): sg_face_winding = a.toUInt
    val _SG_FACEWINDING_DEFAULT = define(0)
    val SG_FACEWINDING_CCW = define(1)
    val SG_FACEWINDING_CW = define(2)
    val _SG_FACEWINDING_NUM = define(3)
    val _SG_FACEWINDING_FORCE_U32 = define(2147483647)

  opaque type sg_filter = CUnsignedInt
  object sg_filter extends CEnumU[sg_filter]:
    inline def define(inline a: Long): sg_filter = a.toUInt
    val _SG_FILTER_DEFAULT = define(0)
    val SG_FILTER_NEAREST = define(1)
    val SG_FILTER_LINEAR = define(2)
    val SG_FILTER_NEAREST_MIPMAP_NEAREST = define(3)
    val SG_FILTER_NEAREST_MIPMAP_LINEAR = define(4)
    val SG_FILTER_LINEAR_MIPMAP_NEAREST = define(5)
    val SG_FILTER_LINEAR_MIPMAP_LINEAR = define(6)
    val _SG_FILTER_NUM = define(7)
    val _SG_FILTER_FORCE_U32 = define(2147483647)

  opaque type sg_image_type = CUnsignedInt
  object sg_image_type extends CEnumU[sg_image_type]:
    inline def define(inline a: Long): sg_image_type = a.toUInt
    val _SG_IMAGETYPE_DEFAULT = define(0)
    val SG_IMAGETYPE_2D = define(1)
    val SG_IMAGETYPE_CUBE = define(2)
    val SG_IMAGETYPE_3D = define(3)
    val SG_IMAGETYPE_ARRAY = define(4)
    val _SG_IMAGETYPE_NUM = define(5)
    val _SG_IMAGETYPE_FORCE_U32 = define(2147483647)

  opaque type sg_index_type = CUnsignedInt
  object sg_index_type extends CEnumU[sg_index_type]:
    inline def define(inline a: Long): sg_index_type = a.toUInt
    val _SG_INDEXTYPE_DEFAULT = define(0)
    val SG_INDEXTYPE_NONE = define(1)
    val SG_INDEXTYPE_UINT16 = define(2)
    val SG_INDEXTYPE_UINT32 = define(3)
    val _SG_INDEXTYPE_NUM = define(4)
    val _SG_INDEXTYPE_FORCE_U32 = define(2147483647)

  opaque type sg_pixel_format = CUnsignedInt
  object sg_pixel_format extends CEnumU[sg_pixel_format]:
    inline def define(inline a: Long): sg_pixel_format = a.toUInt
    val _SG_PIXELFORMAT_DEFAULT = define(0)
    val SG_PIXELFORMAT_NONE = define(1)
    val SG_PIXELFORMAT_R8 = define(2)
    val SG_PIXELFORMAT_R8SN = define(3)
    val SG_PIXELFORMAT_R8UI = define(4)
    val SG_PIXELFORMAT_R8SI = define(5)
    val SG_PIXELFORMAT_R16 = define(6)
    val SG_PIXELFORMAT_R16SN = define(7)
    val SG_PIXELFORMAT_R16UI = define(8)
    val SG_PIXELFORMAT_R16SI = define(9)
    val SG_PIXELFORMAT_R16F = define(10)
    val SG_PIXELFORMAT_RG8 = define(11)
    val SG_PIXELFORMAT_RG8SN = define(12)
    val SG_PIXELFORMAT_RG8UI = define(13)
    val SG_PIXELFORMAT_RG8SI = define(14)
    val SG_PIXELFORMAT_R32UI = define(15)
    val SG_PIXELFORMAT_R32SI = define(16)
    val SG_PIXELFORMAT_R32F = define(17)
    val SG_PIXELFORMAT_RG16 = define(18)
    val SG_PIXELFORMAT_RG16SN = define(19)
    val SG_PIXELFORMAT_RG16UI = define(20)
    val SG_PIXELFORMAT_RG16SI = define(21)
    val SG_PIXELFORMAT_RG16F = define(22)
    val SG_PIXELFORMAT_RGBA8 = define(23)
    val SG_PIXELFORMAT_RGBA8SN = define(24)
    val SG_PIXELFORMAT_RGBA8UI = define(25)
    val SG_PIXELFORMAT_RGBA8SI = define(26)
    val SG_PIXELFORMAT_BGRA8 = define(27)
    val SG_PIXELFORMAT_RGB10A2 = define(28)
    val SG_PIXELFORMAT_RG11B10F = define(29)
    val SG_PIXELFORMAT_RG32UI = define(30)
    val SG_PIXELFORMAT_RG32SI = define(31)
    val SG_PIXELFORMAT_RG32F = define(32)
    val SG_PIXELFORMAT_RGBA16 = define(33)
    val SG_PIXELFORMAT_RGBA16SN = define(34)
    val SG_PIXELFORMAT_RGBA16UI = define(35)
    val SG_PIXELFORMAT_RGBA16SI = define(36)
    val SG_PIXELFORMAT_RGBA16F = define(37)
    val SG_PIXELFORMAT_RGBA32UI = define(38)
    val SG_PIXELFORMAT_RGBA32SI = define(39)
    val SG_PIXELFORMAT_RGBA32F = define(40)
    val SG_PIXELFORMAT_DEPTH = define(41)
    val SG_PIXELFORMAT_DEPTH_STENCIL = define(42)
    val SG_PIXELFORMAT_BC1_RGBA = define(43)
    val SG_PIXELFORMAT_BC2_RGBA = define(44)
    val SG_PIXELFORMAT_BC3_RGBA = define(45)
    val SG_PIXELFORMAT_BC4_R = define(46)
    val SG_PIXELFORMAT_BC4_RSN = define(47)
    val SG_PIXELFORMAT_BC5_RG = define(48)
    val SG_PIXELFORMAT_BC5_RGSN = define(49)
    val SG_PIXELFORMAT_BC6H_RGBF = define(50)
    val SG_PIXELFORMAT_BC6H_RGBUF = define(51)
    val SG_PIXELFORMAT_BC7_RGBA = define(52)
    val SG_PIXELFORMAT_PVRTC_RGB_2BPP = define(53)
    val SG_PIXELFORMAT_PVRTC_RGB_4BPP = define(54)
    val SG_PIXELFORMAT_PVRTC_RGBA_2BPP = define(55)
    val SG_PIXELFORMAT_PVRTC_RGBA_4BPP = define(56)
    val SG_PIXELFORMAT_ETC2_RGB8 = define(57)
    val SG_PIXELFORMAT_ETC2_RGB8A1 = define(58)
    val SG_PIXELFORMAT_ETC2_RGBA8 = define(59)
    val SG_PIXELFORMAT_ETC2_RG11 = define(60)
    val SG_PIXELFORMAT_ETC2_RG11SN = define(61)
    val _SG_PIXELFORMAT_NUM = define(62)
    val _SG_PIXELFORMAT_FORCE_U32 = define(2147483647)

  opaque type sg_primitive_type = CUnsignedInt
  object sg_primitive_type extends CEnumU[sg_primitive_type]:
    inline def define(inline a: Long): sg_primitive_type = a.toUInt
    val _SG_PRIMITIVETYPE_DEFAULT = define(0)
    val SG_PRIMITIVETYPE_POINTS = define(1)
    val SG_PRIMITIVETYPE_LINES = define(2)
    val SG_PRIMITIVETYPE_LINE_STRIP = define(3)
    val SG_PRIMITIVETYPE_TRIANGLES = define(4)
    val SG_PRIMITIVETYPE_TRIANGLE_STRIP = define(5)
    val _SG_PRIMITIVETYPE_NUM = define(6)
    val _SG_PRIMITIVETYPE_FORCE_U32 = define(2147483647)

  opaque type sg_resource_state = CUnsignedInt
  object sg_resource_state extends CEnumU[sg_resource_state]:
    inline def define(inline a: Long): sg_resource_state = a.toUInt
    val SG_RESOURCESTATE_INITIAL = define(0)
    val SG_RESOURCESTATE_ALLOC = define(1)
    val SG_RESOURCESTATE_VALID = define(2)
    val SG_RESOURCESTATE_FAILED = define(3)
    val SG_RESOURCESTATE_INVALID = define(4)
    val _SG_RESOURCESTATE_FORCE_U32 = define(2147483647)

  opaque type sg_sampler_type = CUnsignedInt
  object sg_sampler_type extends CEnumU[sg_sampler_type]:
    inline def define(inline a: Long): sg_sampler_type = a.toUInt
    val _SG_SAMPLERTYPE_DEFAULT = define(0)
    val SG_SAMPLERTYPE_FLOAT = define(1)
    val SG_SAMPLERTYPE_SINT = define(2)
    val SG_SAMPLERTYPE_UINT = define(3)

  opaque type sg_shader_stage = CUnsignedInt
  object sg_shader_stage extends CEnumU[sg_shader_stage]:
    inline def define(inline a: Long): sg_shader_stage = a.toUInt
    val SG_SHADERSTAGE_VS = define(0)
    val SG_SHADERSTAGE_FS = define(1)
    val _SG_SHADERSTAGE_FORCE_U32 = define(2147483647)

  opaque type sg_stencil_op = CUnsignedInt
  object sg_stencil_op extends CEnumU[sg_stencil_op]:
    inline def define(inline a: Long): sg_stencil_op = a.toUInt
    val _SG_STENCILOP_DEFAULT = define(0)
    val SG_STENCILOP_KEEP = define(1)
    val SG_STENCILOP_ZERO = define(2)
    val SG_STENCILOP_REPLACE = define(3)
    val SG_STENCILOP_INCR_CLAMP = define(4)
    val SG_STENCILOP_DECR_CLAMP = define(5)
    val SG_STENCILOP_INVERT = define(6)
    val SG_STENCILOP_INCR_WRAP = define(7)
    val SG_STENCILOP_DECR_WRAP = define(8)
    val _SG_STENCILOP_NUM = define(9)
    val _SG_STENCILOP_FORCE_U32 = define(2147483647)

  opaque type sg_uniform_type = CUnsignedInt
  object sg_uniform_type extends CEnumU[sg_uniform_type]:
    inline def define(inline a: Long): sg_uniform_type = a.toUInt
    val SG_UNIFORMTYPE_INVALID = define(0)
    val SG_UNIFORMTYPE_FLOAT = define(1)
    val SG_UNIFORMTYPE_FLOAT2 = define(2)
    val SG_UNIFORMTYPE_FLOAT3 = define(3)
    val SG_UNIFORMTYPE_FLOAT4 = define(4)
    val SG_UNIFORMTYPE_MAT4 = define(5)
    val _SG_UNIFORMTYPE_NUM = define(6)
    val _SG_UNIFORMTYPE_FORCE_U32 = define(2147483647)

  opaque type sg_usage = CUnsignedInt
  object sg_usage extends CEnumU[sg_usage]:
    inline def define(inline a: Long): sg_usage = a.toUInt
    val _SG_USAGE_DEFAULT = define(0)
    val SG_USAGE_IMMUTABLE = define(1)
    val SG_USAGE_DYNAMIC = define(2)
    val SG_USAGE_STREAM = define(3)
    val _SG_USAGE_NUM = define(4)
    val _SG_USAGE_FORCE_U32 = define(2147483647)

  opaque type sg_vertex_format = CUnsignedInt
  object sg_vertex_format extends CEnumU[sg_vertex_format]:
    inline def define(inline a: Long): sg_vertex_format = a.toUInt
    val SG_VERTEXFORMAT_INVALID = define(0)
    val SG_VERTEXFORMAT_FLOAT = define(1)
    val SG_VERTEXFORMAT_FLOAT2 = define(2)
    val SG_VERTEXFORMAT_FLOAT3 = define(3)
    val SG_VERTEXFORMAT_FLOAT4 = define(4)
    val SG_VERTEXFORMAT_BYTE4 = define(5)
    val SG_VERTEXFORMAT_BYTE4N = define(6)
    val SG_VERTEXFORMAT_UBYTE4 = define(7)
    val SG_VERTEXFORMAT_UBYTE4N = define(8)
    val SG_VERTEXFORMAT_SHORT2 = define(9)
    val SG_VERTEXFORMAT_SHORT2N = define(10)
    val SG_VERTEXFORMAT_USHORT2N = define(11)
    val SG_VERTEXFORMAT_SHORT4 = define(12)
    val SG_VERTEXFORMAT_SHORT4N = define(13)
    val SG_VERTEXFORMAT_USHORT4N = define(14)
    val SG_VERTEXFORMAT_UINT10_N2 = define(15)
    val _SG_VERTEXFORMAT_NUM = define(16)
    val _SG_VERTEXFORMAT_FORCE_U32 = define(2147483647)

  opaque type sg_vertex_step = CUnsignedInt
  object sg_vertex_step extends CEnumU[sg_vertex_step]:
    inline def define(inline a: Long): sg_vertex_step = a.toUInt
    val _SG_VERTEXSTEP_DEFAULT = define(0)
    val SG_VERTEXSTEP_PER_VERTEX = define(1)
    val SG_VERTEXSTEP_PER_INSTANCE = define(2)
    val _SG_VERTEXSTEP_NUM = define(3)
    val _SG_VERTEXSTEP_FORCE_U32 = define(2147483647)

  opaque type sg_wrap = CUnsignedInt
  object sg_wrap extends CEnumU[sg_wrap]:
    inline def define(inline a: Long): sg_wrap = a.toUInt
    val _SG_WRAP_DEFAULT = define(0)
    val SG_WRAP_REPEAT = define(1)
    val SG_WRAP_CLAMP_TO_EDGE = define(2)
    val SG_WRAP_CLAMP_TO_BORDER = define(3)
    val SG_WRAP_MIRRORED_REPEAT = define(4)
    val _SG_WRAP_NUM = define(5)
    val _SG_WRAP_FORCE_U32 = define(2147483647)

  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o

  type __darwin_blkcnt_t = __int64_t
  object __darwin_blkcnt_t: 
    given _tag: Tag[__darwin_blkcnt_t] = __int64_t._tag

  type __darwin_blksize_t = __int32_t
  object __darwin_blksize_t: 
    given _tag: Tag[__darwin_blksize_t] = __int32_t._tag

  opaque type __darwin_clock_t = CUnsignedLongInt
  object __darwin_clock_t: 
    given _tag: Tag[__darwin_clock_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_clock_t = o

  opaque type __darwin_ct_rune_t = CInt
  object __darwin_ct_rune_t: 
    given _tag: Tag[__darwin_ct_rune_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_ct_rune_t = o

  type __darwin_dev_t = __int32_t
  object __darwin_dev_t: 
    given _tag: Tag[__darwin_dev_t] = __int32_t._tag

  opaque type __darwin_fsblkcnt_t = CUnsignedInt
  object __darwin_fsblkcnt_t: 
    given _tag: Tag[__darwin_fsblkcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsblkcnt_t = o

  opaque type __darwin_fsfilcnt_t = CUnsignedInt
  object __darwin_fsfilcnt_t: 
    given _tag: Tag[__darwin_fsfilcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsfilcnt_t = o

  type __darwin_gid_t = __uint32_t
  object __darwin_gid_t: 
    given _tag: Tag[__darwin_gid_t] = __uint32_t._tag

  type __darwin_id_t = __uint32_t
  object __darwin_id_t: 
    given _tag: Tag[__darwin_id_t] = __uint32_t._tag

  type __darwin_ino64_t = __uint64_t
  object __darwin_ino64_t: 
    given _tag: Tag[__darwin_ino64_t] = __uint64_t._tag

  type __darwin_ino_t = __darwin_ino64_t
  object __darwin_ino_t: 
    given _tag: Tag[__darwin_ino_t] = __darwin_ino64_t._tag

  opaque type __darwin_intptr_t = CLongInt
  object __darwin_intptr_t: 
    given _tag: Tag[__darwin_intptr_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_intptr_t = o

  type __darwin_mach_port_name_t = __darwin_natural_t
  object __darwin_mach_port_name_t: 
    given _tag: Tag[__darwin_mach_port_name_t] = __darwin_natural_t._tag

  type __darwin_mach_port_t = __darwin_mach_port_name_t
  object __darwin_mach_port_t: 
    given _tag: Tag[__darwin_mach_port_t] = __darwin_mach_port_name_t._tag

  type __darwin_mbstate_t = __mbstate_t
  object __darwin_mbstate_t: 
    given _tag: Tag[__darwin_mbstate_t] = __mbstate_t._tag

  type __darwin_mode_t = __uint16_t
  object __darwin_mode_t: 
    given _tag: Tag[__darwin_mode_t] = __uint16_t._tag

  opaque type __darwin_natural_t = CUnsignedInt
  object __darwin_natural_t: 
    given _tag: Tag[__darwin_natural_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_natural_t = o

  opaque type __darwin_nl_item = CInt
  object __darwin_nl_item: 
    given _tag: Tag[__darwin_nl_item] = Tag.Int
    inline def apply(inline o: CInt): __darwin_nl_item = o

  type __darwin_off_t = __int64_t
  object __darwin_off_t: 
    given _tag: Tag[__darwin_off_t] = __int64_t._tag

  type __darwin_pid_t = __int32_t
  object __darwin_pid_t: 
    given _tag: Tag[__darwin_pid_t] = __int32_t._tag

  opaque type __darwin_pthread_key_t = CUnsignedLongInt
  object __darwin_pthread_key_t: 
    given _tag: Tag[__darwin_pthread_key_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_pthread_key_t = o

  opaque type __darwin_pthread_t = Ptr[_opaque_pthread_t]
  object __darwin_pthread_t: 
    given _tag: Tag[__darwin_pthread_t] = Tag.Ptr[_opaque_pthread_t](_opaque_pthread_t._tag)
    inline def apply(inline o: Ptr[_opaque_pthread_t]): __darwin_pthread_t = o

  opaque type __darwin_ptrdiff_t = CLongInt
  object __darwin_ptrdiff_t: 
    given _tag: Tag[__darwin_ptrdiff_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ptrdiff_t = o

  type __darwin_rune_t = __darwin_wchar_t
  object __darwin_rune_t: 
    given _tag: Tag[__darwin_rune_t] = __darwin_wchar_t._tag

  type __darwin_sigset_t = __uint32_t
  object __darwin_sigset_t: 
    given _tag: Tag[__darwin_sigset_t] = __uint32_t._tag

  opaque type __darwin_size_t = CUnsignedLongInt
  object __darwin_size_t: 
    given _tag: Tag[__darwin_size_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_size_t = o

  type __darwin_socklen_t = __uint32_t
  object __darwin_socklen_t: 
    given _tag: Tag[__darwin_socklen_t] = __uint32_t._tag

  opaque type __darwin_ssize_t = CLongInt
  object __darwin_ssize_t: 
    given _tag: Tag[__darwin_ssize_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ssize_t = o

  type __darwin_suseconds_t = __int32_t
  object __darwin_suseconds_t: 
    given _tag: Tag[__darwin_suseconds_t] = __int32_t._tag

  opaque type __darwin_time_t = CLongInt
  object __darwin_time_t: 
    given _tag: Tag[__darwin_time_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_time_t = o

  type __darwin_uid_t = __uint32_t
  object __darwin_uid_t: 
    given _tag: Tag[__darwin_uid_t] = __uint32_t._tag

  type __darwin_useconds_t = __uint32_t
  object __darwin_useconds_t: 
    given _tag: Tag[__darwin_useconds_t] = __uint32_t._tag

  opaque type __darwin_uuid_string_t = CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]
  object __darwin_uuid_string_t: 
    given _tag: Tag[__darwin_uuid_string_t] = Tag.CArray[CChar, Nat.Digit2[Nat._3, Nat._7]](Tag.Byte, Tag.Digit2[Nat._3, Nat._7](Tag.Nat3, Tag.Nat7))
    inline def apply(inline o: CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]): __darwin_uuid_string_t = o

  opaque type __darwin_uuid_t = CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]
  object __darwin_uuid_t: 
    given _tag: Tag[__darwin_uuid_t] = Tag.CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]](Tag.UByte, Tag.Digit2[Nat._1, Nat._6](Tag.Nat1, Tag.Nat6))
    inline def apply(inline o: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]): __darwin_uuid_t = o

  type __darwin_va_list = __builtin_va_list
  object __darwin_va_list: 
    given _tag: Tag[__darwin_va_list] = __builtin_va_list._tag

  opaque type __darwin_wchar_t = CInt
  object __darwin_wchar_t: 
    given _tag: Tag[__darwin_wchar_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wchar_t = o

  opaque type __darwin_wctrans_t = CInt
  object __darwin_wctrans_t: 
    given _tag: Tag[__darwin_wctrans_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wctrans_t = o

  type __darwin_wctype_t = __uint32_t
  object __darwin_wctype_t: 
    given _tag: Tag[__darwin_wctype_t] = __uint32_t._tag

  opaque type __darwin_wint_t = CInt
  object __darwin_wint_t: 
    given _tag: Tag[__darwin_wint_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wint_t = o

  opaque type __int16_t = CShort
  object __int16_t: 
    given _tag: Tag[__int16_t] = Tag.Short
    inline def apply(inline o: CShort): __int16_t = o

  opaque type __int32_t = CInt
  object __int32_t: 
    given _tag: Tag[__int32_t] = Tag.Int
    inline def apply(inline o: CInt): __int32_t = o

  opaque type __int64_t = CLongLong
  object __int64_t: 
    given _tag: Tag[__int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): __int64_t = o

  opaque type __int8_t = CChar
  object __int8_t: 
    given _tag: Tag[__int8_t] = Tag.Byte
    inline def apply(inline o: CChar): __int8_t = o

  opaque type __uint16_t = CUnsignedShort
  object __uint16_t: 
    given _tag: Tag[__uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): __uint16_t = o

  opaque type __uint32_t = CUnsignedInt
  object __uint32_t: 
    given _tag: Tag[__uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __uint32_t = o

  opaque type __uint64_t = CUnsignedLongLong
  object __uint64_t: 
    given _tag: Tag[__uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): __uint64_t = o

  opaque type __uint8_t = CUnsignedChar
  object __uint8_t: 
    given _tag: Tag[__uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): __uint8_t = o

  opaque type int16_t = CShort
  object int16_t: 
    given _tag: Tag[int16_t] = Tag.Short
    inline def apply(inline o: CShort): int16_t = o

  opaque type int32_t = CInt
  object int32_t: 
    given _tag: Tag[int32_t] = Tag.Int
    inline def apply(inline o: CInt): int32_t = o

  opaque type int64_t = CLongLong
  object int64_t: 
    given _tag: Tag[int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): int64_t = o

  opaque type int8_t = CChar
  object int8_t: 
    given _tag: Tag[int8_t] = Tag.Byte
    inline def apply(inline o: CChar): int8_t = o

  type int_fast16_t = int16_t
  object int_fast16_t: 
    given _tag: Tag[int_fast16_t] = int16_t._tag

  type int_fast32_t = int32_t
  object int_fast32_t: 
    given _tag: Tag[int_fast32_t] = int32_t._tag

  type int_fast64_t = int64_t
  object int_fast64_t: 
    given _tag: Tag[int_fast64_t] = int64_t._tag

  type int_fast8_t = int8_t
  object int_fast8_t: 
    given _tag: Tag[int_fast8_t] = int8_t._tag

  type int_least16_t = int16_t
  object int_least16_t: 
    given _tag: Tag[int_least16_t] = int16_t._tag

  type int_least32_t = int32_t
  object int_least32_t: 
    given _tag: Tag[int_least32_t] = int32_t._tag

  type int_least64_t = int64_t
  object int_least64_t: 
    given _tag: Tag[int_least64_t] = int64_t._tag

  type int_least8_t = int8_t
  object int_least8_t: 
    given _tag: Tag[int_least8_t] = int8_t._tag

  opaque type intmax_t = CLongInt
  object intmax_t: 
    given _tag: Tag[intmax_t] = Tag.Long
    inline def apply(inline o: CLongInt): intmax_t = o

  type intptr_t = __darwin_intptr_t
  object intptr_t: 
    given _tag: Tag[intptr_t] = __darwin_intptr_t._tag

  opaque type max_align_t = Double
  object max_align_t: 
    given _tag: Tag[max_align_t] = Tag.Double
    inline def apply(inline o: Double): max_align_t = o

  type ptrdiff_t = __darwin_ptrdiff_t
  object ptrdiff_t: 
    given _tag: Tag[ptrdiff_t] = __darwin_ptrdiff_t._tag

  type register_t = int64_t
  object register_t: 
    given _tag: Tag[register_t] = int64_t._tag

  type rsize_t = __darwin_size_t
  object rsize_t: 
    given _tag: Tag[rsize_t] = __darwin_size_t._tag

  type size_t = __darwin_size_t
  object size_t: 
    given _tag: Tag[size_t] = __darwin_size_t._tag

  type syscall_arg_t = u_int64_t
  object syscall_arg_t: 
    given _tag: Tag[syscall_arg_t] = u_int64_t._tag

  opaque type u_int16_t = CUnsignedShort
  object u_int16_t: 
    given _tag: Tag[u_int16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): u_int16_t = o

  opaque type u_int32_t = CUnsignedInt
  object u_int32_t: 
    given _tag: Tag[u_int32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): u_int32_t = o

  opaque type u_int64_t = CUnsignedLongLong
  object u_int64_t: 
    given _tag: Tag[u_int64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): u_int64_t = o

  opaque type u_int8_t = CUnsignedChar
  object u_int8_t: 
    given _tag: Tag[u_int8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): u_int8_t = o

  opaque type uint16_t = CUnsignedShort
  object uint16_t: 
    given _tag: Tag[uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): uint16_t = o

  opaque type uint32_t = CUnsignedInt
  object uint32_t: 
    given _tag: Tag[uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): uint32_t = o

  opaque type uint64_t = CUnsignedLongLong
  object uint64_t: 
    given _tag: Tag[uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): uint64_t = o

  opaque type uint8_t = CUnsignedChar
  object uint8_t: 
    given _tag: Tag[uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): uint8_t = o

  type uint_fast16_t = uint16_t
  object uint_fast16_t: 
    given _tag: Tag[uint_fast16_t] = uint16_t._tag

  type uint_fast32_t = uint32_t
  object uint_fast32_t: 
    given _tag: Tag[uint_fast32_t] = uint32_t._tag

  type uint_fast64_t = uint64_t
  object uint_fast64_t: 
    given _tag: Tag[uint_fast64_t] = uint64_t._tag

  type uint_fast8_t = uint8_t
  object uint_fast8_t: 
    given _tag: Tag[uint_fast8_t] = uint8_t._tag

  type uint_least16_t = uint16_t
  object uint_least16_t: 
    given _tag: Tag[uint_least16_t] = uint16_t._tag

  type uint_least32_t = uint32_t
  object uint_least32_t: 
    given _tag: Tag[uint_least32_t] = uint32_t._tag

  type uint_least64_t = uint64_t
  object uint_least64_t: 
    given _tag: Tag[uint_least64_t] = uint64_t._tag

  type uint_least8_t = uint8_t
  object uint_least8_t: 
    given _tag: Tag[uint_least8_t] = uint8_t._tag

  opaque type uintmax_t = CUnsignedLongInt
  object uintmax_t: 
    given _tag: Tag[uintmax_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintmax_t = o

  opaque type uintptr_t = CUnsignedLongInt
  object uintptr_t: 
    given _tag: Tag[uintptr_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintptr_t = o

  type user_addr_t = u_int64_t
  object user_addr_t: 
    given _tag: Tag[user_addr_t] = u_int64_t._tag

  type user_long_t = int64_t
  object user_long_t: 
    given _tag: Tag[user_long_t] = int64_t._tag

  type user_off_t = int64_t
  object user_off_t: 
    given _tag: Tag[user_off_t] = int64_t._tag

  type user_size_t = u_int64_t
  object user_size_t: 
    given _tag: Tag[user_size_t] = u_int64_t._tag

  type user_ssize_t = int64_t
  object user_ssize_t: 
    given _tag: Tag[user_ssize_t] = int64_t._tag

  type user_time_t = int64_t
  object user_time_t: 
    given _tag: Tag[user_time_t] = int64_t._tag

  type user_ulong_t = u_int64_t
  object user_ulong_t: 
    given _tag: Tag[user_ulong_t] = u_int64_t._tag

  type wchar_t = __darwin_wchar_t
  object wchar_t: 
    given _tag: Tag[wchar_t] = __darwin_wchar_t._tag

  type wint_t = __darwin_wint_t
  object wint_t: 
    given _tag: Tag[wint_t] = __darwin_wint_t._tag
  opaque type __darwin_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_attr_t:
    given _tag: Tag[__darwin_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    extension (struct: __darwin_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2

  opaque type __darwin_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object __darwin_pthread_cond_t:
    given _tag: Tag[__darwin_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    extension (struct: __darwin_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2

  opaque type __darwin_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_condattr_t:
    given _tag: Tag[__darwin_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: __darwin_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat._8] = struct._2

  opaque type __darwin_pthread_handler_rec = CStruct3[Ptr[CFuncPtr1[Ptr[Byte], Unit]], Ptr[Byte], Ptr[Byte]]
  object __darwin_pthread_handler_rec:
    given _tag: Tag[__darwin_pthread_handler_rec] = Tag.materializeCStruct3Tag[Ptr[CFuncPtr1[Ptr[Byte], Unit]], Ptr[Byte], Ptr[Byte]]
    extension (struct: __darwin_pthread_handler_rec)
      def __routine: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = struct._1
      def __arg: Ptr[Byte] = struct._2
      def __next: Ptr[__darwin_pthread_handler_rec] = struct._3.asInstanceOf[Ptr[__darwin_pthread_handler_rec]]

  opaque type __darwin_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_mutex_t:
    given _tag: Tag[__darwin_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    extension (struct: __darwin_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2

  opaque type __darwin_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_mutexattr_t:
    given _tag: Tag[__darwin_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: __darwin_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat._8] = struct._2

  opaque type __darwin_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_once_t:
    given _tag: Tag[__darwin_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: __darwin_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat._8] = struct._2

  opaque type __darwin_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object __darwin_pthread_rwlock_t:
    given _tag: Tag[__darwin_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    extension (struct: __darwin_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2

  opaque type __darwin_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object __darwin_pthread_rwlockattr_t:
    given _tag: Tag[__darwin_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: __darwin_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2

  opaque type _opaque_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_attr_t:
    given _tag: Tag[_opaque_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    extension (struct: _opaque_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2

  opaque type _opaque_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object _opaque_pthread_cond_t:
    given _tag: Tag[_opaque_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    extension (struct: _opaque_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2

  opaque type _opaque_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_condattr_t:
    given _tag: Tag[_opaque_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: _opaque_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat._8] = struct._2

  opaque type _opaque_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_mutex_t:
    given _tag: Tag[_opaque_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    extension (struct: _opaque_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2

  opaque type _opaque_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_mutexattr_t:
    given _tag: Tag[_opaque_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: _opaque_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat._8] = struct._2

  opaque type _opaque_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_once_t:
    given _tag: Tag[_opaque_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: _opaque_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat._8] = struct._2

  opaque type _opaque_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object _opaque_pthread_rwlock_t:
    given _tag: Tag[_opaque_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    extension (struct: _opaque_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2

  opaque type _opaque_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object _opaque_pthread_rwlockattr_t:
    given _tag: Tag[_opaque_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: _opaque_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2

  opaque type _opaque_pthread_t = CStruct3[CLongInt, Ptr[__darwin_pthread_handler_rec], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
  object _opaque_pthread_t:
    given _tag: Tag[_opaque_pthread_t] = Tag.materializeCStruct3Tag[CLongInt, Ptr[__darwin_pthread_handler_rec], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
    extension (struct: _opaque_pthread_t)
      def __sig: CLongInt = struct._1
      def __cleanup_stack: Ptr[__darwin_pthread_handler_rec] = struct._2
      def __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]] = struct._3

  opaque type sg_bindings = CStruct8[uint32_t, CArray[sg_buffer, Nat._8], CArray[CInt, Nat._8], sg_buffer, CInt, CArray[sg_image, Nat.Digit2[Nat._1, Nat._2]], CArray[sg_image, Nat.Digit2[Nat._1, Nat._2]], uint32_t]
  object sg_bindings:
    given _tag: Tag[sg_bindings] = Tag.materializeCStruct8Tag[uint32_t, CArray[sg_buffer, Nat._8], CArray[CInt, Nat._8], sg_buffer, CInt, CArray[sg_image, Nat.Digit2[Nat._1, Nat._2]], CArray[sg_image, Nat.Digit2[Nat._1, Nat._2]], uint32_t]
    extension (struct: sg_bindings)
      def _start_canary: uint32_t = struct._1
      def vertex_buffers: CArray[sg_buffer, Nat._8] = struct._2
      def vertex_buffer_offsets: CArray[CInt, Nat._8] = struct._3
      def index_buffer: sg_buffer = struct._4
      def index_buffer_offset: CInt = struct._5
      def vs_images: CArray[sg_image, Nat.Digit2[Nat._1, Nat._2]] = struct._6
      def fs_images: CArray[sg_image, Nat.Digit2[Nat._1, Nat._2]] = struct._7
      def _end_canary: uint32_t = struct._8

  opaque type sg_blend_state = CStruct7[CInt, sg_blend_factor, sg_blend_factor, sg_blend_op, sg_blend_factor, sg_blend_factor, sg_blend_op]
  object sg_blend_state:
    given _tag: Tag[sg_blend_state] = Tag.materializeCStruct7Tag[CInt, sg_blend_factor, sg_blend_factor, sg_blend_op, sg_blend_factor, sg_blend_factor, sg_blend_op]
    extension (struct: sg_blend_state)
      def enabled: CInt = struct._1
      def src_factor_rgb: sg_blend_factor = struct._2
      def dst_factor_rgb: sg_blend_factor = struct._3
      def op_rgb: sg_blend_op = struct._4
      def src_factor_alpha: sg_blend_factor = struct._5
      def dst_factor_alpha: sg_blend_factor = struct._6
      def op_alpha: sg_blend_op = struct._7

  opaque type sg_buffer = CStruct1[uint32_t]
  object sg_buffer:
    given _tag: Tag[sg_buffer] = Tag.materializeCStruct1Tag[uint32_t]
    extension (struct: sg_buffer)
      def id: uint32_t = struct._1

  opaque type sg_buffer_desc = CStruct11[uint32_t, size_t, sg_buffer_type, sg_usage, sg_range, CString, CArray[uint32_t, Nat._2], CArray[Ptr[Byte], Nat._2], Ptr[Byte], Ptr[Byte], uint32_t]
  object sg_buffer_desc:
    given _tag: Tag[sg_buffer_desc] = Tag.materializeCStruct11Tag[uint32_t, size_t, sg_buffer_type, sg_usage, sg_range, CString, CArray[uint32_t, Nat._2], CArray[Ptr[Byte], Nat._2], Ptr[Byte], Ptr[Byte], uint32_t]
    extension (struct: sg_buffer_desc)
      def _start_canary: uint32_t = struct._1
      def size: size_t = struct._2
      def `type`: sg_buffer_type = struct._3
      def usage: sg_usage = struct._4
      def data: sg_range = struct._5
      def label: CString = struct._6
      def gl_buffers: CArray[uint32_t, Nat._2] = struct._7
      def mtl_buffers: CArray[Ptr[Byte], Nat._2] = struct._8
      def d3d11_buffer: Ptr[Byte] = struct._9
      def wgpu_buffer: Ptr[Byte] = struct._10
      def _end_canary: uint32_t = struct._11

  opaque type sg_buffer_info = CStruct7[sg_slot_info, uint32_t, uint32_t, CInt, CInt, CInt, CInt]
  object sg_buffer_info:
    given _tag: Tag[sg_buffer_info] = Tag.materializeCStruct7Tag[sg_slot_info, uint32_t, uint32_t, CInt, CInt, CInt, CInt]
    extension (struct: sg_buffer_info)
      def slot: sg_slot_info = struct._1
      def update_frame_index: uint32_t = struct._2
      def append_frame_index: uint32_t = struct._3
      def append_pos: CInt = struct._4
      def append_overflow: CInt = struct._5
      def num_slots: CInt = struct._6
      def active_slot: CInt = struct._7

  opaque type sg_buffer_layout_desc = CStruct3[CInt, sg_vertex_step, CInt]
  object sg_buffer_layout_desc:
    given _tag: Tag[sg_buffer_layout_desc] = Tag.materializeCStruct3Tag[CInt, sg_vertex_step, CInt]
    extension (struct: sg_buffer_layout_desc)
      def stride: CInt = struct._1
      def step_func: sg_vertex_step = struct._2
      def step_rate: CInt = struct._3

  opaque type sg_color = CStruct4[Float, Float, Float, Float]
  object sg_color:
    given _tag: Tag[sg_color] = Tag.materializeCStruct4Tag[Float, Float, Float, Float]
    extension (struct: sg_color)
      def r: Float = struct._1
      def g: Float = struct._2
      def b: Float = struct._3
      def a: Float = struct._4

  opaque type sg_color_attachment_action = CStruct2[sg_action, sg_color]
  object sg_color_attachment_action:
    given _tag: Tag[sg_color_attachment_action] = Tag.materializeCStruct2Tag[sg_action, sg_color]
    extension (struct: sg_color_attachment_action)
      def action: sg_action = struct._1
      def value: sg_color = struct._2

  opaque type sg_color_state = CStruct3[sg_pixel_format, sg_color_mask, sg_blend_state]
  object sg_color_state:
    given _tag: Tag[sg_color_state] = Tag.materializeCStruct3Tag[sg_pixel_format, sg_color_mask, sg_blend_state]
    extension (struct: sg_color_state)
      def pixel_format: sg_pixel_format = struct._1
      def write_mask: sg_color_mask = struct._2
      def blend: sg_blend_state = struct._3

  opaque type sg_context = CStruct1[uint32_t]
  object sg_context:
    given _tag: Tag[sg_context] = Tag.materializeCStruct1Tag[uint32_t]
    extension (struct: sg_context)
      def id: uint32_t = struct._1

  opaque type sg_context_desc = CStruct7[sg_pixel_format, sg_pixel_format, CInt, sg_gl_context_desc, sg_metal_context_desc, sg_d3d11_context_desc, sg_wgpu_context_desc]
  object sg_context_desc:
    given _tag: Tag[sg_context_desc] = Tag.materializeCStruct7Tag[sg_pixel_format, sg_pixel_format, CInt, sg_gl_context_desc, sg_metal_context_desc, sg_d3d11_context_desc, sg_wgpu_context_desc]
    extension (struct: sg_context_desc)
      def color_format: sg_pixel_format = struct._1
      def depth_format: sg_pixel_format = struct._2
      def sample_count: CInt = struct._3
      def gl: sg_gl_context_desc = struct._4
      def metal: sg_metal_context_desc = struct._5
      def d3d11: sg_d3d11_context_desc = struct._6
      def wgpu: sg_wgpu_context_desc = struct._7

  opaque type sg_d3d11_context_desc = CStruct7[Ptr[Byte], Ptr[Byte], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[Byte]]
  object sg_d3d11_context_desc:
    given _tag: Tag[sg_d3d11_context_desc] = Tag.materializeCStruct7Tag[Ptr[Byte], Ptr[Byte], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[Byte]]
    extension (struct: sg_d3d11_context_desc)
      def device: Ptr[Byte] = struct._1
      def device_context: Ptr[Byte] = struct._2
      def render_target_view_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._3
      def render_target_view_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._4
      def depth_stencil_view_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._5
      def depth_stencil_view_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._6
      def user_data: Ptr[Byte] = struct._7

  opaque type sg_depth_attachment_action = CStruct2[sg_action, Float]
  object sg_depth_attachment_action:
    given _tag: Tag[sg_depth_attachment_action] = Tag.materializeCStruct2Tag[sg_action, Float]
    extension (struct: sg_depth_attachment_action)
      def action: sg_action = struct._1
      def value: Float = struct._2

  opaque type sg_depth_state = CStruct6[sg_pixel_format, sg_compare_func, CInt, Float, Float, Float]
  object sg_depth_state:
    given _tag: Tag[sg_depth_state] = Tag.materializeCStruct6Tag[sg_pixel_format, sg_compare_func, CInt, Float, Float, Float]
    extension (struct: sg_depth_state)
      def pixel_format: sg_pixel_format = struct._1
      def compare: sg_compare_func = struct._2
      def write_enabled: CInt = struct._3
      def bias: Float = struct._4
      def bias_slope_scale: Float = struct._5
      def bias_clamp: Float = struct._6

  opaque type sg_desc = CStruct12[uint32_t, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, sg_context_desc, uint32_t]
  object sg_desc:
    given _tag: Tag[sg_desc] = Tag.materializeCStruct12Tag[uint32_t, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, sg_context_desc, uint32_t]
    extension (struct: sg_desc)
      def _start_canary: uint32_t = struct._1
      def buffer_pool_size: CInt = struct._2
      def image_pool_size: CInt = struct._3
      def shader_pool_size: CInt = struct._4
      def pipeline_pool_size: CInt = struct._5
      def pass_pool_size: CInt = struct._6
      def context_pool_size: CInt = struct._7
      def uniform_buffer_size: CInt = struct._8
      def staging_buffer_size: CInt = struct._9
      def sampler_cache_size: CInt = struct._10
      def context: sg_context_desc = struct._11
      def _end_canary: uint32_t = struct._12

  opaque type sg_features = CStruct9[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt]
  object sg_features:
    given _tag: Tag[sg_features] = Tag.materializeCStruct9Tag[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt]
    extension (struct: sg_features)
      def instancing: CInt = struct._1
      def origin_top_left: CInt = struct._2
      def multiple_render_targets: CInt = struct._3
      def msaa_render_targets: CInt = struct._4
      def imagetype_3d: CInt = struct._5
      def imagetype_array: CInt = struct._6
      def image_clamp_to_border: CInt = struct._7
      def mrt_independent_blend_state: CInt = struct._8
      def mrt_independent_write_mask: CInt = struct._9

  opaque type sg_gl_context_desc = CStruct1[CInt]
  object sg_gl_context_desc:
    given _tag: Tag[sg_gl_context_desc] = Tag.materializeCStruct1Tag[CInt]
    extension (struct: sg_gl_context_desc)
      def force_gles2: CInt = struct._1

  opaque type sg_image = CStruct1[uint32_t]
  object sg_image:
    given _tag: Tag[sg_image] = Tag.materializeCStruct1Tag[uint32_t]
    extension (struct: sg_image)
      def id: uint32_t = struct._1

  opaque type sg_image_data = CStruct1[CArray[CArray[sg_range, Nat.Digit2[Nat._1, Nat._6]], Nat._6]]
  object sg_image_data:
    given _tag: Tag[sg_image_data] = Tag.materializeCStruct1Tag[CArray[CArray[sg_range, Nat.Digit2[Nat._1, Nat._6]], Nat._6]]
    extension (struct: sg_image_data)
      def subimage: CArray[CArray[sg_range, Nat.Digit2[Nat._1, Nat._6]], Nat._6] = struct._1

  opaque type sg_image_desc = CArray[Byte, Nat.Digit4[Nat._1, Nat._6, Nat._8, Nat._8]]
  object sg_image_desc:
    given _tag: Tag[sg_image_desc] = Tag.CArray[CChar, Nat.Digit4[Nat._1, Nat._6, Nat._8, Nat._8]](Tag.Byte, Tag.Digit4[Nat._1, Nat._6, Nat._8, Nat._8](Tag.Nat1, Tag.Nat6, Tag.Nat8, Tag.Nat8))
    extension (struct: sg_image_desc)
      def _start_canary: uint32_t = !struct.at(0).asInstanceOf[Ptr[uint32_t]]
      def `type`: sg_image_type = !struct.at(4).asInstanceOf[Ptr[sg_image_type]]
      def render_target: CInt = !struct.at(8).asInstanceOf[Ptr[CInt]]
      def width: CInt = !struct.at(12).asInstanceOf[Ptr[CInt]]
      def height: CInt = !struct.at(16).asInstanceOf[Ptr[CInt]]
      def num_slices: CInt = !struct.at(20).asInstanceOf[Ptr[CInt]]
      def num_mipmaps: CInt = !struct.at(24).asInstanceOf[Ptr[CInt]]
      def usage: sg_usage = !struct.at(28).asInstanceOf[Ptr[sg_usage]]
      def pixel_format: sg_pixel_format = !struct.at(32).asInstanceOf[Ptr[sg_pixel_format]]
      def sample_count: CInt = !struct.at(36).asInstanceOf[Ptr[CInt]]
      def min_filter: sg_filter = !struct.at(40).asInstanceOf[Ptr[sg_filter]]
      def mag_filter: sg_filter = !struct.at(44).asInstanceOf[Ptr[sg_filter]]
      def wrap_u: sg_wrap = !struct.at(48).asInstanceOf[Ptr[sg_wrap]]
      def wrap_v: sg_wrap = !struct.at(52).asInstanceOf[Ptr[sg_wrap]]
      def wrap_w: sg_wrap = !struct.at(56).asInstanceOf[Ptr[sg_wrap]]
      def border_color: sg_border_color = !struct.at(60).asInstanceOf[Ptr[sg_border_color]]
      def max_anisotropy: uint32_t = !struct.at(64).asInstanceOf[Ptr[uint32_t]]
      def min_lod: Float = !struct.at(68).asInstanceOf[Ptr[Float]]
      def max_lod: Float = !struct.at(72).asInstanceOf[Ptr[Float]]
      def data: sg_image_data = !struct.at(80).asInstanceOf[Ptr[sg_image_data]]
      def label: CString = !struct.at(1616).asInstanceOf[Ptr[CString]]
      def gl_textures: CArray[uint32_t, Nat._2] = !struct.at(1624).asInstanceOf[Ptr[CArray[uint32_t, Nat._2]]]
      def gl_texture_target: uint32_t = !struct.at(1632).asInstanceOf[Ptr[uint32_t]]
      def mtl_textures: CArray[Ptr[Byte], Nat._2] = !struct.at(1640).asInstanceOf[Ptr[CArray[Ptr[Byte], Nat._2]]]
      def d3d11_texture: Ptr[Byte] = !struct.at(1656).asInstanceOf[Ptr[Ptr[Byte]]]
      def d3d11_shader_resource_view: Ptr[Byte] = !struct.at(1664).asInstanceOf[Ptr[Ptr[Byte]]]
      def wgpu_texture: Ptr[Byte] = !struct.at(1672).asInstanceOf[Ptr[Ptr[Byte]]]
      def _end_canary: uint32_t = !struct.at(1680).asInstanceOf[Ptr[uint32_t]]

  opaque type sg_image_info = CStruct6[sg_slot_info, uint32_t, CInt, CInt, CInt, CInt]
  object sg_image_info:
    given _tag: Tag[sg_image_info] = Tag.materializeCStruct6Tag[sg_slot_info, uint32_t, CInt, CInt, CInt, CInt]
    extension (struct: sg_image_info)
      def slot: sg_slot_info = struct._1
      def upd_frame_index: uint32_t = struct._2
      def num_slots: CInt = struct._3
      def active_slot: CInt = struct._4
      def width: CInt = struct._5
      def height: CInt = struct._6

  opaque type sg_layout_desc = CStruct2[CArray[sg_buffer_layout_desc, Nat._8], CArray[sg_vertex_attr_desc, Nat.Digit2[Nat._1, Nat._6]]]
  object sg_layout_desc:
    given _tag: Tag[sg_layout_desc] = Tag.materializeCStruct2Tag[CArray[sg_buffer_layout_desc, Nat._8], CArray[sg_vertex_attr_desc, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: sg_layout_desc)
      def buffers: CArray[sg_buffer_layout_desc, Nat._8] = struct._1
      def attrs: CArray[sg_vertex_attr_desc, Nat.Digit2[Nat._1, Nat._6]] = struct._2

  opaque type sg_limits = CStruct7[CInt, CInt, CInt, CInt, CInt, CInt, CInt]
  object sg_limits:
    given _tag: Tag[sg_limits] = Tag.materializeCStruct7Tag[CInt, CInt, CInt, CInt, CInt, CInt, CInt]
    extension (struct: sg_limits)
      def max_image_size_2d: CInt = struct._1
      def max_image_size_cube: CInt = struct._2
      def max_image_size_3d: CInt = struct._3
      def max_image_size_array: CInt = struct._4
      def max_image_array_layers: CInt = struct._5
      def max_vertex_attrs: CInt = struct._6
      def gl_max_vertex_uniform_vectors: CInt = struct._7

  opaque type sg_metal_context_desc = CStruct6[Ptr[Byte], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[Byte]]
  object sg_metal_context_desc:
    given _tag: Tag[sg_metal_context_desc] = Tag.materializeCStruct6Tag[Ptr[Byte], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[Byte]]
    extension (struct: sg_metal_context_desc)
      def device: Ptr[Byte] = struct._1
      def renderpass_descriptor_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._2
      def renderpass_descriptor_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._3
      def drawable_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._4
      def drawable_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._5
      def user_data: Ptr[Byte] = struct._6

  opaque type sg_pass = CStruct1[uint32_t]
  object sg_pass:
    given _tag: Tag[sg_pass] = Tag.materializeCStruct1Tag[uint32_t]
    extension (struct: sg_pass)
      def id: uint32_t = struct._1

  opaque type sg_pass_action = CStruct5[uint32_t, CArray[sg_color_attachment_action, Nat._4], sg_depth_attachment_action, sg_stencil_attachment_action, uint32_t]
  object sg_pass_action:
    given _tag: Tag[sg_pass_action] = Tag.materializeCStruct5Tag[uint32_t, CArray[sg_color_attachment_action, Nat._4], sg_depth_attachment_action, sg_stencil_attachment_action, uint32_t]
    extension (struct: sg_pass_action)
      def _start_canary: uint32_t = struct._1
      def colors: CArray[sg_color_attachment_action, Nat._4] = struct._2
      def depth: sg_depth_attachment_action = struct._3
      def stencil: sg_stencil_attachment_action = struct._4
      def _end_canary: uint32_t = struct._5

  opaque type sg_pass_attachment_desc = CStruct3[sg_image, CInt, CInt]
  object sg_pass_attachment_desc:
    given _tag: Tag[sg_pass_attachment_desc] = Tag.materializeCStruct3Tag[sg_image, CInt, CInt]
    extension (struct: sg_pass_attachment_desc)
      def image: sg_image = struct._1
      def mip_level: CInt = struct._2
      def slice: CInt = struct._3

  opaque type sg_pass_desc = CStruct5[uint32_t, CArray[sg_pass_attachment_desc, Nat._4], sg_pass_attachment_desc, CString, uint32_t]
  object sg_pass_desc:
    given _tag: Tag[sg_pass_desc] = Tag.materializeCStruct5Tag[uint32_t, CArray[sg_pass_attachment_desc, Nat._4], sg_pass_attachment_desc, CString, uint32_t]
    extension (struct: sg_pass_desc)
      def _start_canary: uint32_t = struct._1
      def color_attachments: CArray[sg_pass_attachment_desc, Nat._4] = struct._2
      def depth_stencil_attachment: sg_pass_attachment_desc = struct._3
      def label: CString = struct._4
      def _end_canary: uint32_t = struct._5

  opaque type sg_pass_info = CStruct1[sg_slot_info]
  object sg_pass_info:
    given _tag: Tag[sg_pass_info] = Tag.materializeCStruct1Tag[sg_slot_info]
    extension (struct: sg_pass_info)
      def slot: sg_slot_info = struct._1

  opaque type sg_pipeline = CStruct1[uint32_t]
  object sg_pipeline:
    given _tag: Tag[sg_pipeline] = Tag.materializeCStruct1Tag[uint32_t]
    extension (struct: sg_pipeline)
      def id: uint32_t = struct._1

  opaque type sg_pipeline_desc = CStruct16[uint32_t, sg_shader, sg_layout_desc, sg_depth_state, sg_stencil_state, CInt, CArray[sg_color_state, Nat._4], sg_primitive_type, sg_index_type, sg_cull_mode, sg_face_winding, CInt, sg_color, CInt, CString, uint32_t]
  object sg_pipeline_desc:
    given _tag: Tag[sg_pipeline_desc] = Tag.materializeCStruct16Tag[uint32_t, sg_shader, sg_layout_desc, sg_depth_state, sg_stencil_state, CInt, CArray[sg_color_state, Nat._4], sg_primitive_type, sg_index_type, sg_cull_mode, sg_face_winding, CInt, sg_color, CInt, CString, uint32_t]
    extension (struct: sg_pipeline_desc)
      def _start_canary: uint32_t = struct._1
      def shader: sg_shader = struct._2
      def layout: sg_layout_desc = struct._3
      def depth: sg_depth_state = struct._4
      def stencil: sg_stencil_state = struct._5
      def color_count: CInt = struct._6
      def colors: CArray[sg_color_state, Nat._4] = struct._7
      def primitive_type: sg_primitive_type = struct._8
      def index_type: sg_index_type = struct._9
      def cull_mode: sg_cull_mode = struct._10
      def face_winding: sg_face_winding = struct._11
      def sample_count: CInt = struct._12
      def blend_color: sg_color = struct._13
      def alpha_to_coverage_enabled: CInt = struct._14
      def label: CString = struct._15
      def _end_canary: uint32_t = struct._16

  opaque type sg_pipeline_info = CStruct1[sg_slot_info]
  object sg_pipeline_info:
    given _tag: Tag[sg_pipeline_info] = Tag.materializeCStruct1Tag[sg_slot_info]
    extension (struct: sg_pipeline_info)
      def slot: sg_slot_info = struct._1

  opaque type sg_pixelformat_info = CStruct6[CInt, CInt, CInt, CInt, CInt, CInt]
  object sg_pixelformat_info:
    given _tag: Tag[sg_pixelformat_info] = Tag.materializeCStruct6Tag[CInt, CInt, CInt, CInt, CInt, CInt]
    extension (struct: sg_pixelformat_info)
      def sample: CInt = struct._1
      def filter: CInt = struct._2
      def render: CInt = struct._3
      def blend: CInt = struct._4
      def msaa: CInt = struct._5
      def depth: CInt = struct._6

  opaque type sg_range = CStruct2[Ptr[Byte], size_t]
  object sg_range:
    given _tag: Tag[sg_range] = Tag.materializeCStruct2Tag[Ptr[Byte], size_t]
    extension (struct: sg_range)
      def ptr: Ptr[Byte] = struct._1
      def size: size_t = struct._2

  opaque type sg_shader = CStruct1[uint32_t]
  object sg_shader:
    given _tag: Tag[sg_shader] = Tag.materializeCStruct1Tag[uint32_t]
    extension (struct: sg_shader)
      def id: uint32_t = struct._1

  opaque type sg_shader_attr_desc = CStruct3[CString, CString, CInt]
  object sg_shader_attr_desc:
    given _tag: Tag[sg_shader_attr_desc] = Tag.materializeCStruct3Tag[CString, CString, CInt]
    extension (struct: sg_shader_attr_desc)
      def name: CString = struct._1
      def sem_name: CString = struct._2
      def sem_index: CInt = struct._3

  opaque type sg_shader_desc = CStruct6[uint32_t, CArray[sg_shader_attr_desc, Nat.Digit2[Nat._1, Nat._6]], sg_shader_stage_desc, sg_shader_stage_desc, CString, uint32_t]
  object sg_shader_desc:
    given _tag: Tag[sg_shader_desc] = Tag.materializeCStruct6Tag[uint32_t, CArray[sg_shader_attr_desc, Nat.Digit2[Nat._1, Nat._6]], sg_shader_stage_desc, sg_shader_stage_desc, CString, uint32_t]
    extension (struct: sg_shader_desc)
      def _start_canary: uint32_t = struct._1
      def attrs: CArray[sg_shader_attr_desc, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def vs: sg_shader_stage_desc = struct._3
      def fs: sg_shader_stage_desc = struct._4
      def label: CString = struct._5
      def _end_canary: uint32_t = struct._6

  opaque type sg_shader_image_desc = CStruct3[CString, sg_image_type, sg_sampler_type]
  object sg_shader_image_desc:
    given _tag: Tag[sg_shader_image_desc] = Tag.materializeCStruct3Tag[CString, sg_image_type, sg_sampler_type]
    extension (struct: sg_shader_image_desc)
      def name: CString = struct._1
      def image_type: sg_image_type = struct._2
      def sampler_type: sg_sampler_type = struct._3

  opaque type sg_shader_info = CStruct1[sg_slot_info]
  object sg_shader_info:
    given _tag: Tag[sg_shader_info] = Tag.materializeCStruct1Tag[sg_slot_info]
    extension (struct: sg_shader_info)
      def slot: sg_slot_info = struct._1

  opaque type sg_shader_stage_desc = CStruct6[CString, sg_range, CString, CString, CArray[sg_shader_uniform_block_desc, Nat._4], CArray[sg_shader_image_desc, Nat.Digit2[Nat._1, Nat._2]]]
  object sg_shader_stage_desc:
    given _tag: Tag[sg_shader_stage_desc] = Tag.materializeCStruct6Tag[CString, sg_range, CString, CString, CArray[sg_shader_uniform_block_desc, Nat._4], CArray[sg_shader_image_desc, Nat.Digit2[Nat._1, Nat._2]]]
    extension (struct: sg_shader_stage_desc)
      def source: CString = struct._1
      def bytecode: sg_range = struct._2
      def entry: CString = struct._3
      def d3d11_target: CString = struct._4
      def uniform_blocks: CArray[sg_shader_uniform_block_desc, Nat._4] = struct._5
      def images: CArray[sg_shader_image_desc, Nat.Digit2[Nat._1, Nat._2]] = struct._6

  opaque type sg_shader_uniform_block_desc = CStruct2[size_t, CArray[sg_shader_uniform_desc, Nat.Digit2[Nat._1, Nat._6]]]
  object sg_shader_uniform_block_desc:
    given _tag: Tag[sg_shader_uniform_block_desc] = Tag.materializeCStruct2Tag[size_t, CArray[sg_shader_uniform_desc, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: sg_shader_uniform_block_desc)
      def size: size_t = struct._1
      def uniforms: CArray[sg_shader_uniform_desc, Nat.Digit2[Nat._1, Nat._6]] = struct._2

  opaque type sg_shader_uniform_desc = CStruct3[CString, sg_uniform_type, CInt]
  object sg_shader_uniform_desc:
    given _tag: Tag[sg_shader_uniform_desc] = Tag.materializeCStruct3Tag[CString, sg_uniform_type, CInt]
    extension (struct: sg_shader_uniform_desc)
      def name: CString = struct._1
      def `type`: sg_uniform_type = struct._2
      def array_count: CInt = struct._3

  opaque type sg_slot_info = CStruct3[sg_resource_state, uint32_t, uint32_t]
  object sg_slot_info:
    given _tag: Tag[sg_slot_info] = Tag.materializeCStruct3Tag[sg_resource_state, uint32_t, uint32_t]
    extension (struct: sg_slot_info)
      def state: sg_resource_state = struct._1
      def res_id: uint32_t = struct._2
      def ctx_id: uint32_t = struct._3

  opaque type sg_stencil_attachment_action = CStruct2[sg_action, uint8_t]
  object sg_stencil_attachment_action:
    given _tag: Tag[sg_stencil_attachment_action] = Tag.materializeCStruct2Tag[sg_action, uint8_t]
    extension (struct: sg_stencil_attachment_action)
      def action: sg_action = struct._1
      def value: uint8_t = struct._2

  opaque type sg_stencil_face_state = CStruct4[sg_compare_func, sg_stencil_op, sg_stencil_op, sg_stencil_op]
  object sg_stencil_face_state:
    given _tag: Tag[sg_stencil_face_state] = Tag.materializeCStruct4Tag[sg_compare_func, sg_stencil_op, sg_stencil_op, sg_stencil_op]
    extension (struct: sg_stencil_face_state)
      def compare: sg_compare_func = struct._1
      def fail_op: sg_stencil_op = struct._2
      def depth_fail_op: sg_stencil_op = struct._3
      def pass_op: sg_stencil_op = struct._4

  opaque type sg_stencil_state = CStruct6[CInt, sg_stencil_face_state, sg_stencil_face_state, uint8_t, uint8_t, uint8_t]
  object sg_stencil_state:
    given _tag: Tag[sg_stencil_state] = Tag.materializeCStruct6Tag[CInt, sg_stencil_face_state, sg_stencil_face_state, uint8_t, uint8_t, uint8_t]
    extension (struct: sg_stencil_state)
      def enabled: CInt = struct._1
      def front: sg_stencil_face_state = struct._2
      def back: sg_stencil_face_state = struct._3
      def read_mask: uint8_t = struct._4
      def write_mask: uint8_t = struct._5
      def ref: uint8_t = struct._6

  opaque type sg_trace_hooks = CArray[Byte, Nat.Digit3[Nat._4, Nat._8, Nat._8]]
  object sg_trace_hooks:
    given _tag: Tag[sg_trace_hooks] = Tag.CArray[CChar, Nat.Digit3[Nat._4, Nat._8, Nat._8]](Tag.Byte, Tag.Digit3[Nat._4, Nat._8, Nat._8](Tag.Nat4, Tag.Nat8, Tag.Nat8))
    extension (struct: sg_trace_hooks)
      def user_data: Ptr[Byte] = !struct.at(0).asInstanceOf[Ptr[Ptr[Byte]]]
      def reset_state_cache: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(8).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def make_buffer: Ptr[CFuncPtr3[Ptr[sg_buffer_desc], sg_buffer, Ptr[Byte], Unit]] = !struct.at(16).asInstanceOf[Ptr[Ptr[CFuncPtr3[Ptr[sg_buffer_desc], sg_buffer, Ptr[Byte], Unit]]]]
      def make_image: Ptr[CFuncPtr3[Ptr[sg_image_desc], sg_image, Ptr[Byte], Unit]] = !struct.at(24).asInstanceOf[Ptr[Ptr[CFuncPtr3[Ptr[sg_image_desc], sg_image, Ptr[Byte], Unit]]]]
      def make_shader: Ptr[CFuncPtr3[Ptr[sg_shader_desc], sg_shader, Ptr[Byte], Unit]] = !struct.at(32).asInstanceOf[Ptr[Ptr[CFuncPtr3[Ptr[sg_shader_desc], sg_shader, Ptr[Byte], Unit]]]]
      def make_pipeline: Ptr[CFuncPtr3[Ptr[sg_pipeline_desc], sg_pipeline, Ptr[Byte], Unit]] = !struct.at(40).asInstanceOf[Ptr[Ptr[CFuncPtr3[Ptr[sg_pipeline_desc], sg_pipeline, Ptr[Byte], Unit]]]]
      def make_pass: Ptr[CFuncPtr3[Ptr[sg_pass_desc], sg_pass, Ptr[Byte], Unit]] = !struct.at(48).asInstanceOf[Ptr[Ptr[CFuncPtr3[Ptr[sg_pass_desc], sg_pass, Ptr[Byte], Unit]]]]
      def destroy_buffer: Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]] = !struct.at(56).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]]]]
      def destroy_image: Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]] = !struct.at(64).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]]]]
      def destroy_shader: Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]] = !struct.at(72).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]]]]
      def destroy_pipeline: Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]] = !struct.at(80).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]]]]
      def destroy_pass: Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]] = !struct.at(88).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]]]]
      def update_buffer: Ptr[CFuncPtr3[sg_buffer, Ptr[sg_range], Ptr[Byte], Unit]] = !struct.at(96).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_buffer, Ptr[sg_range], Ptr[Byte], Unit]]]]
      def update_image: Ptr[CFuncPtr3[sg_image, Ptr[sg_image_data], Ptr[Byte], Unit]] = !struct.at(104).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_image, Ptr[sg_image_data], Ptr[Byte], Unit]]]]
      def append_buffer: Ptr[CFuncPtr4[sg_buffer, Ptr[sg_range], CInt, Ptr[Byte], Unit]] = !struct.at(112).asInstanceOf[Ptr[Ptr[CFuncPtr4[sg_buffer, Ptr[sg_range], CInt, Ptr[Byte], Unit]]]]
      def begin_default_pass: Ptr[CFuncPtr4[Ptr[sg_pass_action], CInt, CInt, Ptr[Byte], Unit]] = !struct.at(120).asInstanceOf[Ptr[Ptr[CFuncPtr4[Ptr[sg_pass_action], CInt, CInt, Ptr[Byte], Unit]]]]
      def begin_pass: Ptr[CFuncPtr3[sg_pass, Ptr[sg_pass_action], Ptr[Byte], Unit]] = !struct.at(128).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_pass, Ptr[sg_pass_action], Ptr[Byte], Unit]]]]
      def apply_viewport: Ptr[CFuncPtr6[CInt, CInt, CInt, CInt, CInt, Ptr[Byte], Unit]] = !struct.at(136).asInstanceOf[Ptr[Ptr[CFuncPtr6[CInt, CInt, CInt, CInt, CInt, Ptr[Byte], Unit]]]]
      def apply_scissor_rect: Ptr[CFuncPtr6[CInt, CInt, CInt, CInt, CInt, Ptr[Byte], Unit]] = !struct.at(144).asInstanceOf[Ptr[Ptr[CFuncPtr6[CInt, CInt, CInt, CInt, CInt, Ptr[Byte], Unit]]]]
      def apply_pipeline: Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]] = !struct.at(152).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]]]]
      def apply_bindings: Ptr[CFuncPtr2[Ptr[sg_bindings], Ptr[Byte], Unit]] = !struct.at(160).asInstanceOf[Ptr[Ptr[CFuncPtr2[Ptr[sg_bindings], Ptr[Byte], Unit]]]]
      def apply_uniforms: Ptr[CFuncPtr4[sg_shader_stage, CInt, Ptr[sg_range], Ptr[Byte], Unit]] = !struct.at(168).asInstanceOf[Ptr[Ptr[CFuncPtr4[sg_shader_stage, CInt, Ptr[sg_range], Ptr[Byte], Unit]]]]
      def draw: Ptr[CFuncPtr4[CInt, CInt, CInt, Ptr[Byte], Unit]] = !struct.at(176).asInstanceOf[Ptr[Ptr[CFuncPtr4[CInt, CInt, CInt, Ptr[Byte], Unit]]]]
      def end_pass: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(184).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def commit: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(192).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def alloc_buffer: Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]] = !struct.at(200).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]]]]
      def alloc_image: Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]] = !struct.at(208).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]]]]
      def alloc_shader: Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]] = !struct.at(216).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]]]]
      def alloc_pipeline: Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]] = !struct.at(224).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]]]]
      def alloc_pass: Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]] = !struct.at(232).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]]]]
      def dealloc_buffer: Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]] = !struct.at(240).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]]]]
      def dealloc_image: Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]] = !struct.at(248).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]]]]
      def dealloc_shader: Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]] = !struct.at(256).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]]]]
      def dealloc_pipeline: Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]] = !struct.at(264).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]]]]
      def dealloc_pass: Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]] = !struct.at(272).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]]]]
      def init_buffer: Ptr[CFuncPtr3[sg_buffer, Ptr[sg_buffer_desc], Ptr[Byte], Unit]] = !struct.at(280).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_buffer, Ptr[sg_buffer_desc], Ptr[Byte], Unit]]]]
      def init_image: Ptr[CFuncPtr3[sg_image, Ptr[sg_image_desc], Ptr[Byte], Unit]] = !struct.at(288).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_image, Ptr[sg_image_desc], Ptr[Byte], Unit]]]]
      def init_shader: Ptr[CFuncPtr3[sg_shader, Ptr[sg_shader_desc], Ptr[Byte], Unit]] = !struct.at(296).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_shader, Ptr[sg_shader_desc], Ptr[Byte], Unit]]]]
      def init_pipeline: Ptr[CFuncPtr3[sg_pipeline, Ptr[sg_pipeline_desc], Ptr[Byte], Unit]] = !struct.at(304).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_pipeline, Ptr[sg_pipeline_desc], Ptr[Byte], Unit]]]]
      def init_pass: Ptr[CFuncPtr3[sg_pass, Ptr[sg_pass_desc], Ptr[Byte], Unit]] = !struct.at(312).asInstanceOf[Ptr[Ptr[CFuncPtr3[sg_pass, Ptr[sg_pass_desc], Ptr[Byte], Unit]]]]
      def uninit_buffer: Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]] = !struct.at(320).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]]]]
      def uninit_image: Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]] = !struct.at(328).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]]]]
      def uninit_shader: Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]] = !struct.at(336).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]]]]
      def uninit_pipeline: Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]] = !struct.at(344).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]]]]
      def uninit_pass: Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]] = !struct.at(352).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]]]]
      def fail_buffer: Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]] = !struct.at(360).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_buffer, Ptr[Byte], Unit]]]]
      def fail_image: Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]] = !struct.at(368).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_image, Ptr[Byte], Unit]]]]
      def fail_shader: Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]] = !struct.at(376).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_shader, Ptr[Byte], Unit]]]]
      def fail_pipeline: Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]] = !struct.at(384).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pipeline, Ptr[Byte], Unit]]]]
      def fail_pass: Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]] = !struct.at(392).asInstanceOf[Ptr[Ptr[CFuncPtr2[sg_pass, Ptr[Byte], Unit]]]]
      def push_debug_group: Ptr[CFuncPtr2[CString, Ptr[Byte], Unit]] = !struct.at(400).asInstanceOf[Ptr[Ptr[CFuncPtr2[CString, Ptr[Byte], Unit]]]]
      def pop_debug_group: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(408).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_buffer_pool_exhausted: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(416).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_image_pool_exhausted: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(424).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_shader_pool_exhausted: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(432).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_pipeline_pool_exhausted: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(440).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_pass_pool_exhausted: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(448).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_context_mismatch: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(456).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_pass_invalid: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(464).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_draw_invalid: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(472).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]
      def err_bindings_invalid: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = !struct.at(480).asInstanceOf[Ptr[Ptr[CFuncPtr1[Ptr[Byte], Unit]]]]

  opaque type sg_vertex_attr_desc = CStruct3[CInt, CInt, sg_vertex_format]
  object sg_vertex_attr_desc:
    given _tag: Tag[sg_vertex_attr_desc] = Tag.materializeCStruct3Tag[CInt, CInt, sg_vertex_format]
    extension (struct: sg_vertex_attr_desc)
      def buffer_index: CInt = struct._1
      def offset: CInt = struct._2
      def format: sg_vertex_format = struct._3

  opaque type sg_wgpu_context_desc = CStruct8[Ptr[Byte], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[Byte]]
  object sg_wgpu_context_desc:
    given _tag: Tag[sg_wgpu_context_desc] = Tag.materializeCStruct8Tag[Ptr[Byte], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[CFuncPtr0[Ptr[Byte]]], Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]], Ptr[Byte]]
    extension (struct: sg_wgpu_context_desc)
      def device: Ptr[Byte] = struct._1
      def render_view_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._2
      def render_view_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._3
      def resolve_view_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._4
      def resolve_view_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._5
      def depth_stencil_view_cb: Ptr[CFuncPtr0[Ptr[Byte]]] = struct._6
      def depth_stencil_view_userdata_cb: Ptr[CFuncPtr1[Ptr[Byte], Ptr[Byte]]] = struct._7
      def user_data: Ptr[Byte] = struct._8
  opaque type __mbstate_t = CArray[Byte, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
  object __mbstate_t:
    given _tag: Tag[__mbstate_t] = Tag.CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]](Tag.Byte, Tag.Digit3[Nat._1, Nat._2, Nat._8](Tag.Nat1, Tag.Nat2, Tag.Nat8))
    extension (struct: __mbstate_t)
      def __mbstate8: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]] = !struct.at(0).asInstanceOf[Ptr[CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]]]
      def _mbstateL: CLongLong = !struct.at(0).asInstanceOf[Ptr[CLongLong]]
@link("sokol")
@extern
object functions: 
  import types.*

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_buffer_state(buf: sg_buffer): sg_resource_state = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_alloc_pipeline(): sg_pipeline = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_dealloc_image(img_id: sg_image): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_make_pipeline(desc: Ptr[sg_pipeline_desc]): sg_pipeline = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_shader_info(shd: sg_shader): sg_shader_info = extern

  def sg_apply_viewport(x: CInt, y: CInt, width: CInt, height: CInt, origin_top_left: CInt): Unit = extern

  def sg_isvalid(): CInt = extern

  def sg_apply_bindings(bindings: Ptr[sg_bindings]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_make_pass(desc: Ptr[sg_pass_desc]): sg_pass = extern

  def sg_uninit_pass(): CInt = extern

  def sg_uninit_shader(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_dealloc_pipeline(pip_id: sg_pipeline): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_init_pipeline(pip_id: sg_pipeline, desc: Ptr[sg_pipeline_desc]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pipeline_state(pip: sg_pipeline): sg_resource_state = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_fail_buffer(buf_id: sg_buffer): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_activate_context(ctx_id: sg_context): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_update_image(img: sg_image, data: Ptr[sg_image_data]): Unit = extern

  def sg_apply_uniforms(stage: sg_shader_stage, ub_index: CInt, data: Ptr[sg_range]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_alloc_shader(): sg_shader = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_desc(): sg_desc = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_install_trace_hooks(trace_hooks: Ptr[sg_trace_hooks]): sg_trace_hooks = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_make_buffer(desc: Ptr[sg_buffer_desc]): sg_buffer = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_image_info(img: sg_image): sg_image_info = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_destroy_buffer(buf: sg_buffer): Unit = extern

  def sg_begin_default_pass(pass_action: Ptr[sg_pass_action], width: CInt, height: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_destroy_pipeline(pip: sg_pipeline): Unit = extern

  def sg_apply_scissor_rect(x: CInt, y: CInt, width: CInt, height: CInt, origin_top_left: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_init_shader(shd_id: sg_shader, desc: Ptr[sg_shader_desc]): Unit = extern

  def sg_shutdown(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pipeline_defaults(desc: Ptr[sg_pipeline_desc]): sg_pipeline_desc = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_image_defaults(desc: Ptr[sg_image_desc]): sg_image_desc = extern

  def sg_mtl_render_command_encoder(): Ptr[Byte] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_fail_pass(pass_id: sg_pass): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_shader_state(shd: sg_shader): sg_resource_state = extern

  def sg_reset_state_cache(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pixelformat(fmt: sg_pixel_format): sg_pixelformat_info = extern

  def sg_mtl_device(): Ptr[Byte] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_make_image(desc: Ptr[sg_image_desc]): sg_image = extern

  def sg_push_debug_group(name: CString): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_fail_shader(shd_id: sg_shader): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_apply_pipeline(pip: sg_pipeline): Unit = extern

  def sg_commit(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_update_buffer(buf: sg_buffer, data: Ptr[sg_range]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pass_state(pass: sg_pass): sg_resource_state = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_discard_context(ctx_id: sg_context): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_shader_defaults(desc: Ptr[sg_shader_desc]): sg_shader_desc = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_init_image(img_id: sg_image, desc: Ptr[sg_image_desc]): Unit = extern
  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_image_state(img: sg_image): sg_resource_state = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_buffer_info(buf: sg_buffer): sg_buffer_info = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_init_pass(pass_id: sg_pass, desc: Ptr[sg_pass_desc]): Unit = extern

  def sg_query_backend(): sg_backend = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_destroy_image(img: sg_image): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pass_defaults(desc: Ptr[sg_pass_desc]): sg_pass_desc = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pass_info(pass: sg_pass): sg_pass_info = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_dealloc_pass(pass_id: sg_pass): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_destroy_pass(pass: sg_pass): Unit = extern

  def sg_d3d11_device(): Ptr[Byte] = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_dealloc_shader(shd_id: sg_shader): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_pipeline_info(pip: sg_pipeline): sg_pipeline_info = extern

  def sg_draw(base_element: CInt, num_elements: CInt, num_instances: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_make_shader(desc: Ptr[sg_shader_desc]): sg_shader = extern

  def sg_uninit_image(): CInt = extern

  def sg_apply_viewportf(x: Float, y: Float, width: Float, height: Float, origin_top_left: CInt): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_begin_pass(pass: sg_pass, pass_action: Ptr[sg_pass_action]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_init_buffer(buf_id: sg_buffer, desc: Ptr[sg_buffer_desc]): Unit = extern

  def sg_begin_default_passf(pass_action: Ptr[sg_pass_action], width: Float, height: Float): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_destroy_shader(shd: sg_shader): Unit = extern

  def sg_apply_scissor_rectf(x: Float, y: Float, width: Float, height: Float, origin_top_left: CInt): Unit = extern

  def sg_uninit_pipeline(): CInt = extern

  def sg_query_buffer_overflow(): CInt = extern

  def sg_pop_debug_group(): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_append_buffer(buf: sg_buffer, data: Ptr[sg_range]): CInt = extern

  def sg_setup(desc: Ptr[sg_desc]): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_dealloc_buffer(buf_id: sg_buffer): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_alloc_image(): sg_image = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_features(): sg_features = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_alloc_buffer(): sg_buffer = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_fail_image(img_id: sg_image): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_setup_context(): sg_context = extern

  def sg_uninit_buffer(): CInt = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_limits(): sg_limits = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_fail_pipeline(pip_id: sg_pipeline): Unit = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_alloc_pass(): sg_pass = extern

  // this function will not work on Scala Native as it has direct Struct parameter or returns a struct
  def sg_query_buffer_defaults(desc: Ptr[sg_buffer_desc]): sg_buffer_desc = extern

  def sg_end_pass(): Unit = extern


