package libclang

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

private[libclang] trait _BindgenEnumCInt[T](using eq: T =:= CInt):
  given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
  extension (inline t: T)
   inline def value: CInt = eq.apply(t)
   inline def int: CInt = eq.apply(t).toInt
private[libclang] trait _BindgenEnumCUnsignedInt[T](using eq: T =:= CUnsignedInt):
  given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
  extension (inline t: T)
   inline def value: CUnsignedInt = eq.apply(t)
   inline def int: CInt = eq.apply(t).toInt
   inline def uint: CUnsignedInt = eq.apply(t)
/**
 * Describes the availability of a particular entity, which indicates whether the use of this entity will result in a warning or error due to it being deprecated or unavailable.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXAvailabilityKind = CUnsignedInt
object CXAvailabilityKind extends _BindgenEnumCUnsignedInt[CXAvailabilityKind]:
  given _tag: Tag[CXAvailabilityKind] = Tag.UInt
  inline def define(inline a: Long): CXAvailabilityKind = a.toUInt
  val CXAvailability_Available = define(0)
  val CXAvailability_Deprecated = define(1)
  val CXAvailability_NotAvailable = define(2)
  val CXAvailability_NotAccessible = define(3)
  inline def getName(inline value: CXAvailabilityKind): Option[String] =
    inline value match
      case CXAvailability_Available => Some("CXAvailability_Available")
      case CXAvailability_Deprecated => Some("CXAvailability_Deprecated")
      case CXAvailability_NotAvailable => Some("CXAvailability_NotAvailable")
      case CXAvailability_NotAccessible => Some("CXAvailability_NotAccessible")
      case _ => _root_.scala.None
  extension (a: CXAvailabilityKind)
    inline def &(b: CXAvailabilityKind): CXAvailabilityKind = a & b
    inline def |(b: CXAvailabilityKind): CXAvailabilityKind = a | b
    inline def is(b: CXAvailabilityKind): Boolean = (a & b) == b

/**
 * Describes the kind of binary operators.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXBinaryOperatorKind = CUnsignedInt
object CXBinaryOperatorKind extends _BindgenEnumCUnsignedInt[CXBinaryOperatorKind]:
  given _tag: Tag[CXBinaryOperatorKind] = Tag.UInt
  inline def define(inline a: Long): CXBinaryOperatorKind = a.toUInt
  val CXBinaryOperator_Invalid = define(0)
  val CXBinaryOperator_PtrMemD = define(1)
  val CXBinaryOperator_PtrMemI = define(2)
  val CXBinaryOperator_Mul = define(3)
  val CXBinaryOperator_Div = define(4)
  val CXBinaryOperator_Rem = define(5)
  val CXBinaryOperator_Add = define(6)
  val CXBinaryOperator_Sub = define(7)
  val CXBinaryOperator_Shl = define(8)
  val CXBinaryOperator_Shr = define(9)
  val CXBinaryOperator_Cmp = define(10)
  val CXBinaryOperator_LT = define(11)
  val CXBinaryOperator_GT = define(12)
  val CXBinaryOperator_LE = define(13)
  val CXBinaryOperator_GE = define(14)
  val CXBinaryOperator_EQ = define(15)
  val CXBinaryOperator_NE = define(16)
  val CXBinaryOperator_And = define(17)
  val CXBinaryOperator_Xor = define(18)
  val CXBinaryOperator_Or = define(19)
  val CXBinaryOperator_LAnd = define(20)
  val CXBinaryOperator_LOr = define(21)
  val CXBinaryOperator_Assign = define(22)
  val CXBinaryOperator_MulAssign = define(23)
  val CXBinaryOperator_DivAssign = define(24)
  val CXBinaryOperator_RemAssign = define(25)
  val CXBinaryOperator_AddAssign = define(26)
  val CXBinaryOperator_SubAssign = define(27)
  val CXBinaryOperator_ShlAssign = define(28)
  val CXBinaryOperator_ShrAssign = define(29)
  val CXBinaryOperator_AndAssign = define(30)
  val CXBinaryOperator_XorAssign = define(31)
  val CXBinaryOperator_OrAssign = define(32)
  val CXBinaryOperator_Comma = define(33)
  inline def getName(inline value: CXBinaryOperatorKind): Option[String] =
    inline value match
      case CXBinaryOperator_Invalid => Some("CXBinaryOperator_Invalid")
      case CXBinaryOperator_PtrMemD => Some("CXBinaryOperator_PtrMemD")
      case CXBinaryOperator_PtrMemI => Some("CXBinaryOperator_PtrMemI")
      case CXBinaryOperator_Mul => Some("CXBinaryOperator_Mul")
      case CXBinaryOperator_Div => Some("CXBinaryOperator_Div")
      case CXBinaryOperator_Rem => Some("CXBinaryOperator_Rem")
      case CXBinaryOperator_Add => Some("CXBinaryOperator_Add")
      case CXBinaryOperator_Sub => Some("CXBinaryOperator_Sub")
      case CXBinaryOperator_Shl => Some("CXBinaryOperator_Shl")
      case CXBinaryOperator_Shr => Some("CXBinaryOperator_Shr")
      case CXBinaryOperator_Cmp => Some("CXBinaryOperator_Cmp")
      case CXBinaryOperator_LT => Some("CXBinaryOperator_LT")
      case CXBinaryOperator_GT => Some("CXBinaryOperator_GT")
      case CXBinaryOperator_LE => Some("CXBinaryOperator_LE")
      case CXBinaryOperator_GE => Some("CXBinaryOperator_GE")
      case CXBinaryOperator_EQ => Some("CXBinaryOperator_EQ")
      case CXBinaryOperator_NE => Some("CXBinaryOperator_NE")
      case CXBinaryOperator_And => Some("CXBinaryOperator_And")
      case CXBinaryOperator_Xor => Some("CXBinaryOperator_Xor")
      case CXBinaryOperator_Or => Some("CXBinaryOperator_Or")
      case CXBinaryOperator_LAnd => Some("CXBinaryOperator_LAnd")
      case CXBinaryOperator_LOr => Some("CXBinaryOperator_LOr")
      case CXBinaryOperator_Assign => Some("CXBinaryOperator_Assign")
      case CXBinaryOperator_MulAssign => Some("CXBinaryOperator_MulAssign")
      case CXBinaryOperator_DivAssign => Some("CXBinaryOperator_DivAssign")
      case CXBinaryOperator_RemAssign => Some("CXBinaryOperator_RemAssign")
      case CXBinaryOperator_AddAssign => Some("CXBinaryOperator_AddAssign")
      case CXBinaryOperator_SubAssign => Some("CXBinaryOperator_SubAssign")
      case CXBinaryOperator_ShlAssign => Some("CXBinaryOperator_ShlAssign")
      case CXBinaryOperator_ShrAssign => Some("CXBinaryOperator_ShrAssign")
      case CXBinaryOperator_AndAssign => Some("CXBinaryOperator_AndAssign")
      case CXBinaryOperator_XorAssign => Some("CXBinaryOperator_XorAssign")
      case CXBinaryOperator_OrAssign => Some("CXBinaryOperator_OrAssign")
      case CXBinaryOperator_Comma => Some("CXBinaryOperator_Comma")
      case _ => _root_.scala.None
  extension (a: CXBinaryOperatorKind)
    inline def &(b: CXBinaryOperatorKind): CXBinaryOperatorKind = a & b
    inline def |(b: CXBinaryOperatorKind): CXBinaryOperatorKind = a | b
    inline def is(b: CXBinaryOperatorKind): Boolean = (a & b) == b

/**
 * Describes the calling convention of a function type

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCallingConv = CUnsignedInt
object CXCallingConv extends _BindgenEnumCUnsignedInt[CXCallingConv]:
  given _tag: Tag[CXCallingConv] = Tag.UInt
  inline def define(inline a: Long): CXCallingConv = a.toUInt
  val CXCallingConv_Default = define(0)
  val CXCallingConv_C = define(1)
  val CXCallingConv_X86StdCall = define(2)
  val CXCallingConv_X86FastCall = define(3)
  val CXCallingConv_X86ThisCall = define(4)
  val CXCallingConv_X86Pascal = define(5)
  val CXCallingConv_AAPCS = define(6)
  val CXCallingConv_AAPCS_VFP = define(7)
  val CXCallingConv_X86RegCall = define(8)
  val CXCallingConv_IntelOclBicc = define(9)
  val CXCallingConv_Win64 = define(10)
  val CXCallingConv_X86_64Win64 = define(10)
  val CXCallingConv_X86_64SysV = define(11)
  val CXCallingConv_X86VectorCall = define(12)
  val CXCallingConv_Swift = define(13)
  val CXCallingConv_PreserveMost = define(14)
  val CXCallingConv_PreserveAll = define(15)
  val CXCallingConv_AArch64VectorCall = define(16)
  val CXCallingConv_SwiftAsync = define(17)
  val CXCallingConv_AArch64SVEPCS = define(18)
  val CXCallingConv_M68kRTD = define(19)
  val CXCallingConv_PreserveNone = define(20)
  val CXCallingConv_RISCVVectorCall = define(21)
  val CXCallingConv_Invalid = define(100)
  val CXCallingConv_Unexposed = define(200)
  inline def getName(inline value: CXCallingConv): Option[String] =
    inline value match
      case CXCallingConv_Default => Some("CXCallingConv_Default")
      case CXCallingConv_C => Some("CXCallingConv_C")
      case CXCallingConv_X86StdCall => Some("CXCallingConv_X86StdCall")
      case CXCallingConv_X86FastCall => Some("CXCallingConv_X86FastCall")
      case CXCallingConv_X86ThisCall => Some("CXCallingConv_X86ThisCall")
      case CXCallingConv_X86Pascal => Some("CXCallingConv_X86Pascal")
      case CXCallingConv_AAPCS => Some("CXCallingConv_AAPCS")
      case CXCallingConv_AAPCS_VFP => Some("CXCallingConv_AAPCS_VFP")
      case CXCallingConv_X86RegCall => Some("CXCallingConv_X86RegCall")
      case CXCallingConv_IntelOclBicc => Some("CXCallingConv_IntelOclBicc")
      case CXCallingConv_Win64 => Some("CXCallingConv_Win64")
      case CXCallingConv_X86_64Win64 => Some("CXCallingConv_X86_64Win64")
      case CXCallingConv_X86_64SysV => Some("CXCallingConv_X86_64SysV")
      case CXCallingConv_X86VectorCall => Some("CXCallingConv_X86VectorCall")
      case CXCallingConv_Swift => Some("CXCallingConv_Swift")
      case CXCallingConv_PreserveMost => Some("CXCallingConv_PreserveMost")
      case CXCallingConv_PreserveAll => Some("CXCallingConv_PreserveAll")
      case CXCallingConv_AArch64VectorCall => Some("CXCallingConv_AArch64VectorCall")
      case CXCallingConv_SwiftAsync => Some("CXCallingConv_SwiftAsync")
      case CXCallingConv_AArch64SVEPCS => Some("CXCallingConv_AArch64SVEPCS")
      case CXCallingConv_M68kRTD => Some("CXCallingConv_M68kRTD")
      case CXCallingConv_PreserveNone => Some("CXCallingConv_PreserveNone")
      case CXCallingConv_RISCVVectorCall => Some("CXCallingConv_RISCVVectorCall")
      case CXCallingConv_Invalid => Some("CXCallingConv_Invalid")
      case CXCallingConv_Unexposed => Some("CXCallingConv_Unexposed")
      case _ => _root_.scala.None
  extension (a: CXCallingConv)
    inline def &(b: CXCallingConv): CXCallingConv = a & b
    inline def |(b: CXCallingConv): CXCallingConv = a | b
    inline def is(b: CXCallingConv): Boolean = (a & b) == b

/**
 * Describes how the traversal of the children of a particular cursor should proceed after visiting a particular child cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXChildVisitResult = CUnsignedInt
object CXChildVisitResult extends _BindgenEnumCUnsignedInt[CXChildVisitResult]:
  given _tag: Tag[CXChildVisitResult] = Tag.UInt
  inline def define(inline a: Long): CXChildVisitResult = a.toUInt
  val CXChildVisit_Break = define(0)
  val CXChildVisit_Continue = define(1)
  val CXChildVisit_Recurse = define(2)
  inline def getName(inline value: CXChildVisitResult): Option[String] =
    inline value match
      case CXChildVisit_Break => Some("CXChildVisit_Break")
      case CXChildVisit_Continue => Some("CXChildVisit_Continue")
      case CXChildVisit_Recurse => Some("CXChildVisit_Recurse")
      case _ => _root_.scala.None
  extension (a: CXChildVisitResult)
    inline def &(b: CXChildVisitResult): CXChildVisitResult = a & b
    inline def |(b: CXChildVisitResult): CXChildVisitResult = a | b
    inline def is(b: CXChildVisitResult): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXChoice = CUnsignedInt
object CXChoice extends _BindgenEnumCUnsignedInt[CXChoice]:
  given _tag: Tag[CXChoice] = Tag.UInt
  inline def define(inline a: Long): CXChoice = a.toUInt
  val CXChoice_Default = define(0)
  val CXChoice_Enabled = define(1)
  val CXChoice_Disabled = define(2)
  inline def getName(inline value: CXChoice): Option[String] =
    inline value match
      case CXChoice_Default => Some("CXChoice_Default")
      case CXChoice_Enabled => Some("CXChoice_Enabled")
      case CXChoice_Disabled => Some("CXChoice_Disabled")
      case _ => _root_.scala.None
  extension (a: CXChoice)
    inline def &(b: CXChoice): CXChoice = a & b
    inline def |(b: CXChoice): CXChoice = a | b
    inline def is(b: CXChoice): Boolean = (a & b) == b

/**
 * Flags that can be passed to clang_codeCompleteAt() to modify its behavior.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCodeComplete_Flags = CUnsignedInt
object CXCodeComplete_Flags extends _BindgenEnumCUnsignedInt[CXCodeComplete_Flags]:
  given _tag: Tag[CXCodeComplete_Flags] = Tag.UInt
  inline def define(inline a: Long): CXCodeComplete_Flags = a.toUInt
  val CXCodeComplete_IncludeMacros = define(1)
  val CXCodeComplete_IncludeCodePatterns = define(2)
  val CXCodeComplete_IncludeBriefComments = define(4)
  val CXCodeComplete_SkipPreamble = define(8)
  val CXCodeComplete_IncludeCompletionsWithFixIts = define(16)
  inline def getName(inline value: CXCodeComplete_Flags): Option[String] =
    inline value match
      case CXCodeComplete_IncludeMacros => Some("CXCodeComplete_IncludeMacros")
      case CXCodeComplete_IncludeCodePatterns => Some("CXCodeComplete_IncludeCodePatterns")
      case CXCodeComplete_IncludeBriefComments => Some("CXCodeComplete_IncludeBriefComments")
      case CXCodeComplete_SkipPreamble => Some("CXCodeComplete_SkipPreamble")
      case CXCodeComplete_IncludeCompletionsWithFixIts => Some("CXCodeComplete_IncludeCompletionsWithFixIts")
      case _ => _root_.scala.None
  extension (a: CXCodeComplete_Flags)
    inline def &(b: CXCodeComplete_Flags): CXCodeComplete_Flags = a & b
    inline def |(b: CXCodeComplete_Flags): CXCodeComplete_Flags = a | b
    inline def is(b: CXCodeComplete_Flags): Boolean = (a & b) == b

/**
 * Describes a single piece of text within a code-completion string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCompletionChunkKind = CUnsignedInt
object CXCompletionChunkKind extends _BindgenEnumCUnsignedInt[CXCompletionChunkKind]:
  given _tag: Tag[CXCompletionChunkKind] = Tag.UInt
  inline def define(inline a: Long): CXCompletionChunkKind = a.toUInt
  val CXCompletionChunk_Optional = define(0)
  val CXCompletionChunk_TypedText = define(1)
  val CXCompletionChunk_Text = define(2)
  val CXCompletionChunk_Placeholder = define(3)
  val CXCompletionChunk_Informative = define(4)
  val CXCompletionChunk_CurrentParameter = define(5)
  val CXCompletionChunk_LeftParen = define(6)
  val CXCompletionChunk_RightParen = define(7)
  val CXCompletionChunk_LeftBracket = define(8)
  val CXCompletionChunk_RightBracket = define(9)
  val CXCompletionChunk_LeftBrace = define(10)
  val CXCompletionChunk_RightBrace = define(11)
  val CXCompletionChunk_LeftAngle = define(12)
  val CXCompletionChunk_RightAngle = define(13)
  val CXCompletionChunk_Comma = define(14)
  val CXCompletionChunk_ResultType = define(15)
  val CXCompletionChunk_Colon = define(16)
  val CXCompletionChunk_SemiColon = define(17)
  val CXCompletionChunk_Equal = define(18)
  val CXCompletionChunk_HorizontalSpace = define(19)
  val CXCompletionChunk_VerticalSpace = define(20)
  inline def getName(inline value: CXCompletionChunkKind): Option[String] =
    inline value match
      case CXCompletionChunk_Optional => Some("CXCompletionChunk_Optional")
      case CXCompletionChunk_TypedText => Some("CXCompletionChunk_TypedText")
      case CXCompletionChunk_Text => Some("CXCompletionChunk_Text")
      case CXCompletionChunk_Placeholder => Some("CXCompletionChunk_Placeholder")
      case CXCompletionChunk_Informative => Some("CXCompletionChunk_Informative")
      case CXCompletionChunk_CurrentParameter => Some("CXCompletionChunk_CurrentParameter")
      case CXCompletionChunk_LeftParen => Some("CXCompletionChunk_LeftParen")
      case CXCompletionChunk_RightParen => Some("CXCompletionChunk_RightParen")
      case CXCompletionChunk_LeftBracket => Some("CXCompletionChunk_LeftBracket")
      case CXCompletionChunk_RightBracket => Some("CXCompletionChunk_RightBracket")
      case CXCompletionChunk_LeftBrace => Some("CXCompletionChunk_LeftBrace")
      case CXCompletionChunk_RightBrace => Some("CXCompletionChunk_RightBrace")
      case CXCompletionChunk_LeftAngle => Some("CXCompletionChunk_LeftAngle")
      case CXCompletionChunk_RightAngle => Some("CXCompletionChunk_RightAngle")
      case CXCompletionChunk_Comma => Some("CXCompletionChunk_Comma")
      case CXCompletionChunk_ResultType => Some("CXCompletionChunk_ResultType")
      case CXCompletionChunk_Colon => Some("CXCompletionChunk_Colon")
      case CXCompletionChunk_SemiColon => Some("CXCompletionChunk_SemiColon")
      case CXCompletionChunk_Equal => Some("CXCompletionChunk_Equal")
      case CXCompletionChunk_HorizontalSpace => Some("CXCompletionChunk_HorizontalSpace")
      case CXCompletionChunk_VerticalSpace => Some("CXCompletionChunk_VerticalSpace")
      case _ => _root_.scala.None
  extension (a: CXCompletionChunkKind)
    inline def &(b: CXCompletionChunkKind): CXCompletionChunkKind = a & b
    inline def |(b: CXCompletionChunkKind): CXCompletionChunkKind = a | b
    inline def is(b: CXCompletionChunkKind): Boolean = (a & b) == b

/**
 * Bits that represent the context under which completion is occurring.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCompletionContext = CUnsignedInt
object CXCompletionContext extends _BindgenEnumCUnsignedInt[CXCompletionContext]:
  given _tag: Tag[CXCompletionContext] = Tag.UInt
  inline def define(inline a: Long): CXCompletionContext = a.toUInt
  val CXCompletionContext_Unexposed = define(0)
  val CXCompletionContext_AnyType = define(1)
  val CXCompletionContext_AnyValue = define(2)
  val CXCompletionContext_ObjCObjectValue = define(4)
  val CXCompletionContext_ObjCSelectorValue = define(8)
  val CXCompletionContext_CXXClassTypeValue = define(16)
  val CXCompletionContext_DotMemberAccess = define(32)
  val CXCompletionContext_ArrowMemberAccess = define(64)
  val CXCompletionContext_ObjCPropertyAccess = define(128)
  val CXCompletionContext_EnumTag = define(256)
  val CXCompletionContext_UnionTag = define(512)
  val CXCompletionContext_StructTag = define(1024)
  val CXCompletionContext_ClassTag = define(2048)
  val CXCompletionContext_Namespace = define(4096)
  val CXCompletionContext_NestedNameSpecifier = define(8192)
  val CXCompletionContext_ObjCInterface = define(16384)
  val CXCompletionContext_ObjCProtocol = define(32768)
  val CXCompletionContext_ObjCCategory = define(65536)
  val CXCompletionContext_ObjCInstanceMessage = define(131072)
  val CXCompletionContext_ObjCClassMessage = define(262144)
  val CXCompletionContext_ObjCSelectorName = define(524288)
  val CXCompletionContext_MacroName = define(1048576)
  val CXCompletionContext_NaturalLanguage = define(2097152)
  val CXCompletionContext_IncludedFile = define(4194304)
  val CXCompletionContext_Unknown = define(8388607)
  inline def getName(inline value: CXCompletionContext): Option[String] =
    inline value match
      case CXCompletionContext_Unexposed => Some("CXCompletionContext_Unexposed")
      case CXCompletionContext_AnyType => Some("CXCompletionContext_AnyType")
      case CXCompletionContext_AnyValue => Some("CXCompletionContext_AnyValue")
      case CXCompletionContext_ObjCObjectValue => Some("CXCompletionContext_ObjCObjectValue")
      case CXCompletionContext_ObjCSelectorValue => Some("CXCompletionContext_ObjCSelectorValue")
      case CXCompletionContext_CXXClassTypeValue => Some("CXCompletionContext_CXXClassTypeValue")
      case CXCompletionContext_DotMemberAccess => Some("CXCompletionContext_DotMemberAccess")
      case CXCompletionContext_ArrowMemberAccess => Some("CXCompletionContext_ArrowMemberAccess")
      case CXCompletionContext_ObjCPropertyAccess => Some("CXCompletionContext_ObjCPropertyAccess")
      case CXCompletionContext_EnumTag => Some("CXCompletionContext_EnumTag")
      case CXCompletionContext_UnionTag => Some("CXCompletionContext_UnionTag")
      case CXCompletionContext_StructTag => Some("CXCompletionContext_StructTag")
      case CXCompletionContext_ClassTag => Some("CXCompletionContext_ClassTag")
      case CXCompletionContext_Namespace => Some("CXCompletionContext_Namespace")
      case CXCompletionContext_NestedNameSpecifier => Some("CXCompletionContext_NestedNameSpecifier")
      case CXCompletionContext_ObjCInterface => Some("CXCompletionContext_ObjCInterface")
      case CXCompletionContext_ObjCProtocol => Some("CXCompletionContext_ObjCProtocol")
      case CXCompletionContext_ObjCCategory => Some("CXCompletionContext_ObjCCategory")
      case CXCompletionContext_ObjCInstanceMessage => Some("CXCompletionContext_ObjCInstanceMessage")
      case CXCompletionContext_ObjCClassMessage => Some("CXCompletionContext_ObjCClassMessage")
      case CXCompletionContext_ObjCSelectorName => Some("CXCompletionContext_ObjCSelectorName")
      case CXCompletionContext_MacroName => Some("CXCompletionContext_MacroName")
      case CXCompletionContext_NaturalLanguage => Some("CXCompletionContext_NaturalLanguage")
      case CXCompletionContext_IncludedFile => Some("CXCompletionContext_IncludedFile")
      case CXCompletionContext_Unknown => Some("CXCompletionContext_Unknown")
      case _ => _root_.scala.None
  extension (a: CXCompletionContext)
    inline def &(b: CXCompletionContext): CXCompletionContext = a & b
    inline def |(b: CXCompletionContext): CXCompletionContext = a | b
    inline def is(b: CXCompletionContext): Boolean = (a & b) == b

/**
 * Describes the kind of entity that a cursor refers to.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCursorKind = CUnsignedInt
object CXCursorKind extends _BindgenEnumCUnsignedInt[CXCursorKind]:
  given _tag: Tag[CXCursorKind] = Tag.UInt
  inline def define(inline a: Long): CXCursorKind = a.toUInt
  val CXCursor_UnexposedDecl = define(1)
  val CXCursor_StructDecl = define(2)
  val CXCursor_UnionDecl = define(3)
  val CXCursor_ClassDecl = define(4)
  val CXCursor_EnumDecl = define(5)
  val CXCursor_FieldDecl = define(6)
  val CXCursor_EnumConstantDecl = define(7)
  val CXCursor_FunctionDecl = define(8)
  val CXCursor_VarDecl = define(9)
  val CXCursor_ParmDecl = define(10)
  val CXCursor_ObjCInterfaceDecl = define(11)
  val CXCursor_ObjCCategoryDecl = define(12)
  val CXCursor_ObjCProtocolDecl = define(13)
  val CXCursor_ObjCPropertyDecl = define(14)
  val CXCursor_ObjCIvarDecl = define(15)
  val CXCursor_ObjCInstanceMethodDecl = define(16)
  val CXCursor_ObjCClassMethodDecl = define(17)
  val CXCursor_ObjCImplementationDecl = define(18)
  val CXCursor_ObjCCategoryImplDecl = define(19)
  val CXCursor_TypedefDecl = define(20)
  val CXCursor_CXXMethod = define(21)
  val CXCursor_Namespace = define(22)
  val CXCursor_LinkageSpec = define(23)
  val CXCursor_Constructor = define(24)
  val CXCursor_Destructor = define(25)
  val CXCursor_ConversionFunction = define(26)
  val CXCursor_TemplateTypeParameter = define(27)
  val CXCursor_NonTypeTemplateParameter = define(28)
  val CXCursor_TemplateTemplateParameter = define(29)
  val CXCursor_FunctionTemplate = define(30)
  val CXCursor_ClassTemplate = define(31)
  val CXCursor_ClassTemplatePartialSpecialization = define(32)
  val CXCursor_NamespaceAlias = define(33)
  val CXCursor_UsingDirective = define(34)
  val CXCursor_UsingDeclaration = define(35)
  val CXCursor_TypeAliasDecl = define(36)
  val CXCursor_ObjCSynthesizeDecl = define(37)
  val CXCursor_ObjCDynamicDecl = define(38)
  val CXCursor_CXXAccessSpecifier = define(39)
  val CXCursor_FirstDecl = define(1)
  val CXCursor_LastDecl = define(39)
  val CXCursor_FirstRef = define(40)
  val CXCursor_ObjCSuperClassRef = define(40)
  val CXCursor_ObjCProtocolRef = define(41)
  val CXCursor_ObjCClassRef = define(42)
  val CXCursor_TypeRef = define(43)
  val CXCursor_CXXBaseSpecifier = define(44)
  val CXCursor_TemplateRef = define(45)
  val CXCursor_NamespaceRef = define(46)
  val CXCursor_MemberRef = define(47)
  val CXCursor_LabelRef = define(48)
  val CXCursor_OverloadedDeclRef = define(49)
  val CXCursor_VariableRef = define(50)
  val CXCursor_LastRef = define(50)
  val CXCursor_FirstInvalid = define(70)
  val CXCursor_InvalidFile = define(70)
  val CXCursor_NoDeclFound = define(71)
  val CXCursor_NotImplemented = define(72)
  val CXCursor_InvalidCode = define(73)
  val CXCursor_LastInvalid = define(73)
  val CXCursor_FirstExpr = define(100)
  val CXCursor_UnexposedExpr = define(100)
  val CXCursor_DeclRefExpr = define(101)
  val CXCursor_MemberRefExpr = define(102)
  val CXCursor_CallExpr = define(103)
  val CXCursor_ObjCMessageExpr = define(104)
  val CXCursor_BlockExpr = define(105)
  val CXCursor_IntegerLiteral = define(106)
  val CXCursor_FloatingLiteral = define(107)
  val CXCursor_ImaginaryLiteral = define(108)
  val CXCursor_StringLiteral = define(109)
  val CXCursor_CharacterLiteral = define(110)
  val CXCursor_ParenExpr = define(111)
  val CXCursor_UnaryOperator = define(112)
  val CXCursor_ArraySubscriptExpr = define(113)
  val CXCursor_BinaryOperator = define(114)
  val CXCursor_CompoundAssignOperator = define(115)
  val CXCursor_ConditionalOperator = define(116)
  val CXCursor_CStyleCastExpr = define(117)
  val CXCursor_CompoundLiteralExpr = define(118)
  val CXCursor_InitListExpr = define(119)
  val CXCursor_AddrLabelExpr = define(120)
  val CXCursor_StmtExpr = define(121)
  val CXCursor_GenericSelectionExpr = define(122)
  val CXCursor_GNUNullExpr = define(123)
  val CXCursor_CXXStaticCastExpr = define(124)
  val CXCursor_CXXDynamicCastExpr = define(125)
  val CXCursor_CXXReinterpretCastExpr = define(126)
  val CXCursor_CXXConstCastExpr = define(127)
  val CXCursor_CXXFunctionalCastExpr = define(128)
  val CXCursor_CXXTypeidExpr = define(129)
  val CXCursor_CXXBoolLiteralExpr = define(130)
  val CXCursor_CXXNullPtrLiteralExpr = define(131)
  val CXCursor_CXXThisExpr = define(132)
  val CXCursor_CXXThrowExpr = define(133)
  val CXCursor_CXXNewExpr = define(134)
  val CXCursor_CXXDeleteExpr = define(135)
  val CXCursor_UnaryExpr = define(136)
  val CXCursor_ObjCStringLiteral = define(137)
  val CXCursor_ObjCEncodeExpr = define(138)
  val CXCursor_ObjCSelectorExpr = define(139)
  val CXCursor_ObjCProtocolExpr = define(140)
  val CXCursor_ObjCBridgedCastExpr = define(141)
  val CXCursor_PackExpansionExpr = define(142)
  val CXCursor_SizeOfPackExpr = define(143)
  val CXCursor_LambdaExpr = define(144)
  val CXCursor_ObjCBoolLiteralExpr = define(145)
  val CXCursor_ObjCSelfExpr = define(146)
  val CXCursor_ArraySectionExpr = define(147)
  val CXCursor_ObjCAvailabilityCheckExpr = define(148)
  val CXCursor_FixedPointLiteral = define(149)
  val CXCursor_OMPArrayShapingExpr = define(150)
  val CXCursor_OMPIteratorExpr = define(151)
  val CXCursor_CXXAddrspaceCastExpr = define(152)
  val CXCursor_ConceptSpecializationExpr = define(153)
  val CXCursor_RequiresExpr = define(154)
  val CXCursor_CXXParenListInitExpr = define(155)
  val CXCursor_PackIndexingExpr = define(156)
  val CXCursor_LastExpr = define(156)
  val CXCursor_FirstStmt = define(200)
  val CXCursor_UnexposedStmt = define(200)
  val CXCursor_LabelStmt = define(201)
  val CXCursor_CompoundStmt = define(202)
  val CXCursor_CaseStmt = define(203)
  val CXCursor_DefaultStmt = define(204)
  val CXCursor_IfStmt = define(205)
  val CXCursor_SwitchStmt = define(206)
  val CXCursor_WhileStmt = define(207)
  val CXCursor_DoStmt = define(208)
  val CXCursor_ForStmt = define(209)
  val CXCursor_GotoStmt = define(210)
  val CXCursor_IndirectGotoStmt = define(211)
  val CXCursor_ContinueStmt = define(212)
  val CXCursor_BreakStmt = define(213)
  val CXCursor_ReturnStmt = define(214)
  val CXCursor_GCCAsmStmt = define(215)
  val CXCursor_AsmStmt = define(215)
  val CXCursor_ObjCAtTryStmt = define(216)
  val CXCursor_ObjCAtCatchStmt = define(217)
  val CXCursor_ObjCAtFinallyStmt = define(218)
  val CXCursor_ObjCAtThrowStmt = define(219)
  val CXCursor_ObjCAtSynchronizedStmt = define(220)
  val CXCursor_ObjCAutoreleasePoolStmt = define(221)
  val CXCursor_ObjCForCollectionStmt = define(222)
  val CXCursor_CXXCatchStmt = define(223)
  val CXCursor_CXXTryStmt = define(224)
  val CXCursor_CXXForRangeStmt = define(225)
  val CXCursor_SEHTryStmt = define(226)
  val CXCursor_SEHExceptStmt = define(227)
  val CXCursor_SEHFinallyStmt = define(228)
  val CXCursor_MSAsmStmt = define(229)
  val CXCursor_NullStmt = define(230)
  val CXCursor_DeclStmt = define(231)
  val CXCursor_OMPParallelDirective = define(232)
  val CXCursor_OMPSimdDirective = define(233)
  val CXCursor_OMPForDirective = define(234)
  val CXCursor_OMPSectionsDirective = define(235)
  val CXCursor_OMPSectionDirective = define(236)
  val CXCursor_OMPSingleDirective = define(237)
  val CXCursor_OMPParallelForDirective = define(238)
  val CXCursor_OMPParallelSectionsDirective = define(239)
  val CXCursor_OMPTaskDirective = define(240)
  val CXCursor_OMPMasterDirective = define(241)
  val CXCursor_OMPCriticalDirective = define(242)
  val CXCursor_OMPTaskyieldDirective = define(243)
  val CXCursor_OMPBarrierDirective = define(244)
  val CXCursor_OMPTaskwaitDirective = define(245)
  val CXCursor_OMPFlushDirective = define(246)
  val CXCursor_SEHLeaveStmt = define(247)
  val CXCursor_OMPOrderedDirective = define(248)
  val CXCursor_OMPAtomicDirective = define(249)
  val CXCursor_OMPForSimdDirective = define(250)
  val CXCursor_OMPParallelForSimdDirective = define(251)
  val CXCursor_OMPTargetDirective = define(252)
  val CXCursor_OMPTeamsDirective = define(253)
  val CXCursor_OMPTaskgroupDirective = define(254)
  val CXCursor_OMPCancellationPointDirective = define(255)
  val CXCursor_OMPCancelDirective = define(256)
  val CXCursor_OMPTargetDataDirective = define(257)
  val CXCursor_OMPTaskLoopDirective = define(258)
  val CXCursor_OMPTaskLoopSimdDirective = define(259)
  val CXCursor_OMPDistributeDirective = define(260)
  val CXCursor_OMPTargetEnterDataDirective = define(261)
  val CXCursor_OMPTargetExitDataDirective = define(262)
  val CXCursor_OMPTargetParallelDirective = define(263)
  val CXCursor_OMPTargetParallelForDirective = define(264)
  val CXCursor_OMPTargetUpdateDirective = define(265)
  val CXCursor_OMPDistributeParallelForDirective = define(266)
  val CXCursor_OMPDistributeParallelForSimdDirective = define(267)
  val CXCursor_OMPDistributeSimdDirective = define(268)
  val CXCursor_OMPTargetParallelForSimdDirective = define(269)
  val CXCursor_OMPTargetSimdDirective = define(270)
  val CXCursor_OMPTeamsDistributeDirective = define(271)
  val CXCursor_OMPTeamsDistributeSimdDirective = define(272)
  val CXCursor_OMPTeamsDistributeParallelForSimdDirective = define(273)
  val CXCursor_OMPTeamsDistributeParallelForDirective = define(274)
  val CXCursor_OMPTargetTeamsDirective = define(275)
  val CXCursor_OMPTargetTeamsDistributeDirective = define(276)
  val CXCursor_OMPTargetTeamsDistributeParallelForDirective = define(277)
  val CXCursor_OMPTargetTeamsDistributeParallelForSimdDirective = define(278)
  val CXCursor_OMPTargetTeamsDistributeSimdDirective = define(279)
  val CXCursor_BuiltinBitCastExpr = define(280)
  val CXCursor_OMPMasterTaskLoopDirective = define(281)
  val CXCursor_OMPParallelMasterTaskLoopDirective = define(282)
  val CXCursor_OMPMasterTaskLoopSimdDirective = define(283)
  val CXCursor_OMPParallelMasterTaskLoopSimdDirective = define(284)
  val CXCursor_OMPParallelMasterDirective = define(285)
  val CXCursor_OMPDepobjDirective = define(286)
  val CXCursor_OMPScanDirective = define(287)
  val CXCursor_OMPTileDirective = define(288)
  val CXCursor_OMPCanonicalLoop = define(289)
  val CXCursor_OMPInteropDirective = define(290)
  val CXCursor_OMPDispatchDirective = define(291)
  val CXCursor_OMPMaskedDirective = define(292)
  val CXCursor_OMPUnrollDirective = define(293)
  val CXCursor_OMPMetaDirective = define(294)
  val CXCursor_OMPGenericLoopDirective = define(295)
  val CXCursor_OMPTeamsGenericLoopDirective = define(296)
  val CXCursor_OMPTargetTeamsGenericLoopDirective = define(297)
  val CXCursor_OMPParallelGenericLoopDirective = define(298)
  val CXCursor_OMPTargetParallelGenericLoopDirective = define(299)
  val CXCursor_OMPParallelMaskedDirective = define(300)
  val CXCursor_OMPMaskedTaskLoopDirective = define(301)
  val CXCursor_OMPMaskedTaskLoopSimdDirective = define(302)
  val CXCursor_OMPParallelMaskedTaskLoopDirective = define(303)
  val CXCursor_OMPParallelMaskedTaskLoopSimdDirective = define(304)
  val CXCursor_OMPErrorDirective = define(305)
  val CXCursor_OMPScopeDirective = define(306)
  val CXCursor_OMPReverseDirective = define(307)
  val CXCursor_OMPInterchangeDirective = define(308)
  val CXCursor_OpenACCComputeConstruct = define(320)
  val CXCursor_OpenACCLoopConstruct = define(321)
  val CXCursor_LastStmt = define(321)
  val CXCursor_TranslationUnit = define(350)
  val CXCursor_FirstAttr = define(400)
  val CXCursor_UnexposedAttr = define(400)
  val CXCursor_IBActionAttr = define(401)
  val CXCursor_IBOutletAttr = define(402)
  val CXCursor_IBOutletCollectionAttr = define(403)
  val CXCursor_CXXFinalAttr = define(404)
  val CXCursor_CXXOverrideAttr = define(405)
  val CXCursor_AnnotateAttr = define(406)
  val CXCursor_AsmLabelAttr = define(407)
  val CXCursor_PackedAttr = define(408)
  val CXCursor_PureAttr = define(409)
  val CXCursor_ConstAttr = define(410)
  val CXCursor_NoDuplicateAttr = define(411)
  val CXCursor_CUDAConstantAttr = define(412)
  val CXCursor_CUDADeviceAttr = define(413)
  val CXCursor_CUDAGlobalAttr = define(414)
  val CXCursor_CUDAHostAttr = define(415)
  val CXCursor_CUDASharedAttr = define(416)
  val CXCursor_VisibilityAttr = define(417)
  val CXCursor_DLLExport = define(418)
  val CXCursor_DLLImport = define(419)
  val CXCursor_NSReturnsRetained = define(420)
  val CXCursor_NSReturnsNotRetained = define(421)
  val CXCursor_NSReturnsAutoreleased = define(422)
  val CXCursor_NSConsumesSelf = define(423)
  val CXCursor_NSConsumed = define(424)
  val CXCursor_ObjCException = define(425)
  val CXCursor_ObjCNSObject = define(426)
  val CXCursor_ObjCIndependentClass = define(427)
  val CXCursor_ObjCPreciseLifetime = define(428)
  val CXCursor_ObjCReturnsInnerPointer = define(429)
  val CXCursor_ObjCRequiresSuper = define(430)
  val CXCursor_ObjCRootClass = define(431)
  val CXCursor_ObjCSubclassingRestricted = define(432)
  val CXCursor_ObjCExplicitProtocolImpl = define(433)
  val CXCursor_ObjCDesignatedInitializer = define(434)
  val CXCursor_ObjCRuntimeVisible = define(435)
  val CXCursor_ObjCBoxable = define(436)
  val CXCursor_FlagEnum = define(437)
  val CXCursor_ConvergentAttr = define(438)
  val CXCursor_WarnUnusedAttr = define(439)
  val CXCursor_WarnUnusedResultAttr = define(440)
  val CXCursor_AlignedAttr = define(441)
  val CXCursor_LastAttr = define(441)
  val CXCursor_PreprocessingDirective = define(500)
  val CXCursor_MacroDefinition = define(501)
  val CXCursor_MacroExpansion = define(502)
  val CXCursor_MacroInstantiation = define(502)
  val CXCursor_InclusionDirective = define(503)
  val CXCursor_FirstPreprocessing = define(500)
  val CXCursor_LastPreprocessing = define(503)
  val CXCursor_ModuleImportDecl = define(600)
  val CXCursor_TypeAliasTemplateDecl = define(601)
  val CXCursor_StaticAssert = define(602)
  val CXCursor_FriendDecl = define(603)
  val CXCursor_ConceptDecl = define(604)
  val CXCursor_FirstExtraDecl = define(600)
  val CXCursor_LastExtraDecl = define(604)
  val CXCursor_OverloadCandidate = define(700)
  inline def getName(inline value: CXCursorKind): Option[String] =
    inline value match
      case CXCursor_UnexposedDecl => Some("CXCursor_UnexposedDecl")
      case CXCursor_StructDecl => Some("CXCursor_StructDecl")
      case CXCursor_UnionDecl => Some("CXCursor_UnionDecl")
      case CXCursor_ClassDecl => Some("CXCursor_ClassDecl")
      case CXCursor_EnumDecl => Some("CXCursor_EnumDecl")
      case CXCursor_FieldDecl => Some("CXCursor_FieldDecl")
      case CXCursor_EnumConstantDecl => Some("CXCursor_EnumConstantDecl")
      case CXCursor_FunctionDecl => Some("CXCursor_FunctionDecl")
      case CXCursor_VarDecl => Some("CXCursor_VarDecl")
      case CXCursor_ParmDecl => Some("CXCursor_ParmDecl")
      case CXCursor_ObjCInterfaceDecl => Some("CXCursor_ObjCInterfaceDecl")
      case CXCursor_ObjCCategoryDecl => Some("CXCursor_ObjCCategoryDecl")
      case CXCursor_ObjCProtocolDecl => Some("CXCursor_ObjCProtocolDecl")
      case CXCursor_ObjCPropertyDecl => Some("CXCursor_ObjCPropertyDecl")
      case CXCursor_ObjCIvarDecl => Some("CXCursor_ObjCIvarDecl")
      case CXCursor_ObjCInstanceMethodDecl => Some("CXCursor_ObjCInstanceMethodDecl")
      case CXCursor_ObjCClassMethodDecl => Some("CXCursor_ObjCClassMethodDecl")
      case CXCursor_ObjCImplementationDecl => Some("CXCursor_ObjCImplementationDecl")
      case CXCursor_ObjCCategoryImplDecl => Some("CXCursor_ObjCCategoryImplDecl")
      case CXCursor_TypedefDecl => Some("CXCursor_TypedefDecl")
      case CXCursor_CXXMethod => Some("CXCursor_CXXMethod")
      case CXCursor_Namespace => Some("CXCursor_Namespace")
      case CXCursor_LinkageSpec => Some("CXCursor_LinkageSpec")
      case CXCursor_Constructor => Some("CXCursor_Constructor")
      case CXCursor_Destructor => Some("CXCursor_Destructor")
      case CXCursor_ConversionFunction => Some("CXCursor_ConversionFunction")
      case CXCursor_TemplateTypeParameter => Some("CXCursor_TemplateTypeParameter")
      case CXCursor_NonTypeTemplateParameter => Some("CXCursor_NonTypeTemplateParameter")
      case CXCursor_TemplateTemplateParameter => Some("CXCursor_TemplateTemplateParameter")
      case CXCursor_FunctionTemplate => Some("CXCursor_FunctionTemplate")
      case CXCursor_ClassTemplate => Some("CXCursor_ClassTemplate")
      case CXCursor_ClassTemplatePartialSpecialization => Some("CXCursor_ClassTemplatePartialSpecialization")
      case CXCursor_NamespaceAlias => Some("CXCursor_NamespaceAlias")
      case CXCursor_UsingDirective => Some("CXCursor_UsingDirective")
      case CXCursor_UsingDeclaration => Some("CXCursor_UsingDeclaration")
      case CXCursor_TypeAliasDecl => Some("CXCursor_TypeAliasDecl")
      case CXCursor_ObjCSynthesizeDecl => Some("CXCursor_ObjCSynthesizeDecl")
      case CXCursor_ObjCDynamicDecl => Some("CXCursor_ObjCDynamicDecl")
      case CXCursor_CXXAccessSpecifier => Some("CXCursor_CXXAccessSpecifier")
      case CXCursor_FirstDecl => Some("CXCursor_FirstDecl")
      case CXCursor_LastDecl => Some("CXCursor_LastDecl")
      case CXCursor_FirstRef => Some("CXCursor_FirstRef")
      case CXCursor_ObjCSuperClassRef => Some("CXCursor_ObjCSuperClassRef")
      case CXCursor_ObjCProtocolRef => Some("CXCursor_ObjCProtocolRef")
      case CXCursor_ObjCClassRef => Some("CXCursor_ObjCClassRef")
      case CXCursor_TypeRef => Some("CXCursor_TypeRef")
      case CXCursor_CXXBaseSpecifier => Some("CXCursor_CXXBaseSpecifier")
      case CXCursor_TemplateRef => Some("CXCursor_TemplateRef")
      case CXCursor_NamespaceRef => Some("CXCursor_NamespaceRef")
      case CXCursor_MemberRef => Some("CXCursor_MemberRef")
      case CXCursor_LabelRef => Some("CXCursor_LabelRef")
      case CXCursor_OverloadedDeclRef => Some("CXCursor_OverloadedDeclRef")
      case CXCursor_VariableRef => Some("CXCursor_VariableRef")
      case CXCursor_LastRef => Some("CXCursor_LastRef")
      case CXCursor_FirstInvalid => Some("CXCursor_FirstInvalid")
      case CXCursor_InvalidFile => Some("CXCursor_InvalidFile")
      case CXCursor_NoDeclFound => Some("CXCursor_NoDeclFound")
      case CXCursor_NotImplemented => Some("CXCursor_NotImplemented")
      case CXCursor_InvalidCode => Some("CXCursor_InvalidCode")
      case CXCursor_LastInvalid => Some("CXCursor_LastInvalid")
      case CXCursor_FirstExpr => Some("CXCursor_FirstExpr")
      case CXCursor_UnexposedExpr => Some("CXCursor_UnexposedExpr")
      case CXCursor_DeclRefExpr => Some("CXCursor_DeclRefExpr")
      case CXCursor_MemberRefExpr => Some("CXCursor_MemberRefExpr")
      case CXCursor_CallExpr => Some("CXCursor_CallExpr")
      case CXCursor_ObjCMessageExpr => Some("CXCursor_ObjCMessageExpr")
      case CXCursor_BlockExpr => Some("CXCursor_BlockExpr")
      case CXCursor_IntegerLiteral => Some("CXCursor_IntegerLiteral")
      case CXCursor_FloatingLiteral => Some("CXCursor_FloatingLiteral")
      case CXCursor_ImaginaryLiteral => Some("CXCursor_ImaginaryLiteral")
      case CXCursor_StringLiteral => Some("CXCursor_StringLiteral")
      case CXCursor_CharacterLiteral => Some("CXCursor_CharacterLiteral")
      case CXCursor_ParenExpr => Some("CXCursor_ParenExpr")
      case CXCursor_UnaryOperator => Some("CXCursor_UnaryOperator")
      case CXCursor_ArraySubscriptExpr => Some("CXCursor_ArraySubscriptExpr")
      case CXCursor_BinaryOperator => Some("CXCursor_BinaryOperator")
      case CXCursor_CompoundAssignOperator => Some("CXCursor_CompoundAssignOperator")
      case CXCursor_ConditionalOperator => Some("CXCursor_ConditionalOperator")
      case CXCursor_CStyleCastExpr => Some("CXCursor_CStyleCastExpr")
      case CXCursor_CompoundLiteralExpr => Some("CXCursor_CompoundLiteralExpr")
      case CXCursor_InitListExpr => Some("CXCursor_InitListExpr")
      case CXCursor_AddrLabelExpr => Some("CXCursor_AddrLabelExpr")
      case CXCursor_StmtExpr => Some("CXCursor_StmtExpr")
      case CXCursor_GenericSelectionExpr => Some("CXCursor_GenericSelectionExpr")
      case CXCursor_GNUNullExpr => Some("CXCursor_GNUNullExpr")
      case CXCursor_CXXStaticCastExpr => Some("CXCursor_CXXStaticCastExpr")
      case CXCursor_CXXDynamicCastExpr => Some("CXCursor_CXXDynamicCastExpr")
      case CXCursor_CXXReinterpretCastExpr => Some("CXCursor_CXXReinterpretCastExpr")
      case CXCursor_CXXConstCastExpr => Some("CXCursor_CXXConstCastExpr")
      case CXCursor_CXXFunctionalCastExpr => Some("CXCursor_CXXFunctionalCastExpr")
      case CXCursor_CXXTypeidExpr => Some("CXCursor_CXXTypeidExpr")
      case CXCursor_CXXBoolLiteralExpr => Some("CXCursor_CXXBoolLiteralExpr")
      case CXCursor_CXXNullPtrLiteralExpr => Some("CXCursor_CXXNullPtrLiteralExpr")
      case CXCursor_CXXThisExpr => Some("CXCursor_CXXThisExpr")
      case CXCursor_CXXThrowExpr => Some("CXCursor_CXXThrowExpr")
      case CXCursor_CXXNewExpr => Some("CXCursor_CXXNewExpr")
      case CXCursor_CXXDeleteExpr => Some("CXCursor_CXXDeleteExpr")
      case CXCursor_UnaryExpr => Some("CXCursor_UnaryExpr")
      case CXCursor_ObjCStringLiteral => Some("CXCursor_ObjCStringLiteral")
      case CXCursor_ObjCEncodeExpr => Some("CXCursor_ObjCEncodeExpr")
      case CXCursor_ObjCSelectorExpr => Some("CXCursor_ObjCSelectorExpr")
      case CXCursor_ObjCProtocolExpr => Some("CXCursor_ObjCProtocolExpr")
      case CXCursor_ObjCBridgedCastExpr => Some("CXCursor_ObjCBridgedCastExpr")
      case CXCursor_PackExpansionExpr => Some("CXCursor_PackExpansionExpr")
      case CXCursor_SizeOfPackExpr => Some("CXCursor_SizeOfPackExpr")
      case CXCursor_LambdaExpr => Some("CXCursor_LambdaExpr")
      case CXCursor_ObjCBoolLiteralExpr => Some("CXCursor_ObjCBoolLiteralExpr")
      case CXCursor_ObjCSelfExpr => Some("CXCursor_ObjCSelfExpr")
      case CXCursor_ArraySectionExpr => Some("CXCursor_ArraySectionExpr")
      case CXCursor_ObjCAvailabilityCheckExpr => Some("CXCursor_ObjCAvailabilityCheckExpr")
      case CXCursor_FixedPointLiteral => Some("CXCursor_FixedPointLiteral")
      case CXCursor_OMPArrayShapingExpr => Some("CXCursor_OMPArrayShapingExpr")
      case CXCursor_OMPIteratorExpr => Some("CXCursor_OMPIteratorExpr")
      case CXCursor_CXXAddrspaceCastExpr => Some("CXCursor_CXXAddrspaceCastExpr")
      case CXCursor_ConceptSpecializationExpr => Some("CXCursor_ConceptSpecializationExpr")
      case CXCursor_RequiresExpr => Some("CXCursor_RequiresExpr")
      case CXCursor_CXXParenListInitExpr => Some("CXCursor_CXXParenListInitExpr")
      case CXCursor_PackIndexingExpr => Some("CXCursor_PackIndexingExpr")
      case CXCursor_LastExpr => Some("CXCursor_LastExpr")
      case CXCursor_FirstStmt => Some("CXCursor_FirstStmt")
      case CXCursor_UnexposedStmt => Some("CXCursor_UnexposedStmt")
      case CXCursor_LabelStmt => Some("CXCursor_LabelStmt")
      case CXCursor_CompoundStmt => Some("CXCursor_CompoundStmt")
      case CXCursor_CaseStmt => Some("CXCursor_CaseStmt")
      case CXCursor_DefaultStmt => Some("CXCursor_DefaultStmt")
      case CXCursor_IfStmt => Some("CXCursor_IfStmt")
      case CXCursor_SwitchStmt => Some("CXCursor_SwitchStmt")
      case CXCursor_WhileStmt => Some("CXCursor_WhileStmt")
      case CXCursor_DoStmt => Some("CXCursor_DoStmt")
      case CXCursor_ForStmt => Some("CXCursor_ForStmt")
      case CXCursor_GotoStmt => Some("CXCursor_GotoStmt")
      case CXCursor_IndirectGotoStmt => Some("CXCursor_IndirectGotoStmt")
      case CXCursor_ContinueStmt => Some("CXCursor_ContinueStmt")
      case CXCursor_BreakStmt => Some("CXCursor_BreakStmt")
      case CXCursor_ReturnStmt => Some("CXCursor_ReturnStmt")
      case CXCursor_GCCAsmStmt => Some("CXCursor_GCCAsmStmt")
      case CXCursor_AsmStmt => Some("CXCursor_AsmStmt")
      case CXCursor_ObjCAtTryStmt => Some("CXCursor_ObjCAtTryStmt")
      case CXCursor_ObjCAtCatchStmt => Some("CXCursor_ObjCAtCatchStmt")
      case CXCursor_ObjCAtFinallyStmt => Some("CXCursor_ObjCAtFinallyStmt")
      case CXCursor_ObjCAtThrowStmt => Some("CXCursor_ObjCAtThrowStmt")
      case CXCursor_ObjCAtSynchronizedStmt => Some("CXCursor_ObjCAtSynchronizedStmt")
      case CXCursor_ObjCAutoreleasePoolStmt => Some("CXCursor_ObjCAutoreleasePoolStmt")
      case CXCursor_ObjCForCollectionStmt => Some("CXCursor_ObjCForCollectionStmt")
      case CXCursor_CXXCatchStmt => Some("CXCursor_CXXCatchStmt")
      case CXCursor_CXXTryStmt => Some("CXCursor_CXXTryStmt")
      case CXCursor_CXXForRangeStmt => Some("CXCursor_CXXForRangeStmt")
      case CXCursor_SEHTryStmt => Some("CXCursor_SEHTryStmt")
      case CXCursor_SEHExceptStmt => Some("CXCursor_SEHExceptStmt")
      case CXCursor_SEHFinallyStmt => Some("CXCursor_SEHFinallyStmt")
      case CXCursor_MSAsmStmt => Some("CXCursor_MSAsmStmt")
      case CXCursor_NullStmt => Some("CXCursor_NullStmt")
      case CXCursor_DeclStmt => Some("CXCursor_DeclStmt")
      case CXCursor_OMPParallelDirective => Some("CXCursor_OMPParallelDirective")
      case CXCursor_OMPSimdDirective => Some("CXCursor_OMPSimdDirective")
      case CXCursor_OMPForDirective => Some("CXCursor_OMPForDirective")
      case CXCursor_OMPSectionsDirective => Some("CXCursor_OMPSectionsDirective")
      case CXCursor_OMPSectionDirective => Some("CXCursor_OMPSectionDirective")
      case CXCursor_OMPSingleDirective => Some("CXCursor_OMPSingleDirective")
      case CXCursor_OMPParallelForDirective => Some("CXCursor_OMPParallelForDirective")
      case CXCursor_OMPParallelSectionsDirective => Some("CXCursor_OMPParallelSectionsDirective")
      case CXCursor_OMPTaskDirective => Some("CXCursor_OMPTaskDirective")
      case CXCursor_OMPMasterDirective => Some("CXCursor_OMPMasterDirective")
      case CXCursor_OMPCriticalDirective => Some("CXCursor_OMPCriticalDirective")
      case CXCursor_OMPTaskyieldDirective => Some("CXCursor_OMPTaskyieldDirective")
      case CXCursor_OMPBarrierDirective => Some("CXCursor_OMPBarrierDirective")
      case CXCursor_OMPTaskwaitDirective => Some("CXCursor_OMPTaskwaitDirective")
      case CXCursor_OMPFlushDirective => Some("CXCursor_OMPFlushDirective")
      case CXCursor_SEHLeaveStmt => Some("CXCursor_SEHLeaveStmt")
      case CXCursor_OMPOrderedDirective => Some("CXCursor_OMPOrderedDirective")
      case CXCursor_OMPAtomicDirective => Some("CXCursor_OMPAtomicDirective")
      case CXCursor_OMPForSimdDirective => Some("CXCursor_OMPForSimdDirective")
      case CXCursor_OMPParallelForSimdDirective => Some("CXCursor_OMPParallelForSimdDirective")
      case CXCursor_OMPTargetDirective => Some("CXCursor_OMPTargetDirective")
      case CXCursor_OMPTeamsDirective => Some("CXCursor_OMPTeamsDirective")
      case CXCursor_OMPTaskgroupDirective => Some("CXCursor_OMPTaskgroupDirective")
      case CXCursor_OMPCancellationPointDirective => Some("CXCursor_OMPCancellationPointDirective")
      case CXCursor_OMPCancelDirective => Some("CXCursor_OMPCancelDirective")
      case CXCursor_OMPTargetDataDirective => Some("CXCursor_OMPTargetDataDirective")
      case CXCursor_OMPTaskLoopDirective => Some("CXCursor_OMPTaskLoopDirective")
      case CXCursor_OMPTaskLoopSimdDirective => Some("CXCursor_OMPTaskLoopSimdDirective")
      case CXCursor_OMPDistributeDirective => Some("CXCursor_OMPDistributeDirective")
      case CXCursor_OMPTargetEnterDataDirective => Some("CXCursor_OMPTargetEnterDataDirective")
      case CXCursor_OMPTargetExitDataDirective => Some("CXCursor_OMPTargetExitDataDirective")
      case CXCursor_OMPTargetParallelDirective => Some("CXCursor_OMPTargetParallelDirective")
      case CXCursor_OMPTargetParallelForDirective => Some("CXCursor_OMPTargetParallelForDirective")
      case CXCursor_OMPTargetUpdateDirective => Some("CXCursor_OMPTargetUpdateDirective")
      case CXCursor_OMPDistributeParallelForDirective => Some("CXCursor_OMPDistributeParallelForDirective")
      case CXCursor_OMPDistributeParallelForSimdDirective => Some("CXCursor_OMPDistributeParallelForSimdDirective")
      case CXCursor_OMPDistributeSimdDirective => Some("CXCursor_OMPDistributeSimdDirective")
      case CXCursor_OMPTargetParallelForSimdDirective => Some("CXCursor_OMPTargetParallelForSimdDirective")
      case CXCursor_OMPTargetSimdDirective => Some("CXCursor_OMPTargetSimdDirective")
      case CXCursor_OMPTeamsDistributeDirective => Some("CXCursor_OMPTeamsDistributeDirective")
      case CXCursor_OMPTeamsDistributeSimdDirective => Some("CXCursor_OMPTeamsDistributeSimdDirective")
      case CXCursor_OMPTeamsDistributeParallelForSimdDirective => Some("CXCursor_OMPTeamsDistributeParallelForSimdDirective")
      case CXCursor_OMPTeamsDistributeParallelForDirective => Some("CXCursor_OMPTeamsDistributeParallelForDirective")
      case CXCursor_OMPTargetTeamsDirective => Some("CXCursor_OMPTargetTeamsDirective")
      case CXCursor_OMPTargetTeamsDistributeDirective => Some("CXCursor_OMPTargetTeamsDistributeDirective")
      case CXCursor_OMPTargetTeamsDistributeParallelForDirective => Some("CXCursor_OMPTargetTeamsDistributeParallelForDirective")
      case CXCursor_OMPTargetTeamsDistributeParallelForSimdDirective => Some("CXCursor_OMPTargetTeamsDistributeParallelForSimdDirective")
      case CXCursor_OMPTargetTeamsDistributeSimdDirective => Some("CXCursor_OMPTargetTeamsDistributeSimdDirective")
      case CXCursor_BuiltinBitCastExpr => Some("CXCursor_BuiltinBitCastExpr")
      case CXCursor_OMPMasterTaskLoopDirective => Some("CXCursor_OMPMasterTaskLoopDirective")
      case CXCursor_OMPParallelMasterTaskLoopDirective => Some("CXCursor_OMPParallelMasterTaskLoopDirective")
      case CXCursor_OMPMasterTaskLoopSimdDirective => Some("CXCursor_OMPMasterTaskLoopSimdDirective")
      case CXCursor_OMPParallelMasterTaskLoopSimdDirective => Some("CXCursor_OMPParallelMasterTaskLoopSimdDirective")
      case CXCursor_OMPParallelMasterDirective => Some("CXCursor_OMPParallelMasterDirective")
      case CXCursor_OMPDepobjDirective => Some("CXCursor_OMPDepobjDirective")
      case CXCursor_OMPScanDirective => Some("CXCursor_OMPScanDirective")
      case CXCursor_OMPTileDirective => Some("CXCursor_OMPTileDirective")
      case CXCursor_OMPCanonicalLoop => Some("CXCursor_OMPCanonicalLoop")
      case CXCursor_OMPInteropDirective => Some("CXCursor_OMPInteropDirective")
      case CXCursor_OMPDispatchDirective => Some("CXCursor_OMPDispatchDirective")
      case CXCursor_OMPMaskedDirective => Some("CXCursor_OMPMaskedDirective")
      case CXCursor_OMPUnrollDirective => Some("CXCursor_OMPUnrollDirective")
      case CXCursor_OMPMetaDirective => Some("CXCursor_OMPMetaDirective")
      case CXCursor_OMPGenericLoopDirective => Some("CXCursor_OMPGenericLoopDirective")
      case CXCursor_OMPTeamsGenericLoopDirective => Some("CXCursor_OMPTeamsGenericLoopDirective")
      case CXCursor_OMPTargetTeamsGenericLoopDirective => Some("CXCursor_OMPTargetTeamsGenericLoopDirective")
      case CXCursor_OMPParallelGenericLoopDirective => Some("CXCursor_OMPParallelGenericLoopDirective")
      case CXCursor_OMPTargetParallelGenericLoopDirective => Some("CXCursor_OMPTargetParallelGenericLoopDirective")
      case CXCursor_OMPParallelMaskedDirective => Some("CXCursor_OMPParallelMaskedDirective")
      case CXCursor_OMPMaskedTaskLoopDirective => Some("CXCursor_OMPMaskedTaskLoopDirective")
      case CXCursor_OMPMaskedTaskLoopSimdDirective => Some("CXCursor_OMPMaskedTaskLoopSimdDirective")
      case CXCursor_OMPParallelMaskedTaskLoopDirective => Some("CXCursor_OMPParallelMaskedTaskLoopDirective")
      case CXCursor_OMPParallelMaskedTaskLoopSimdDirective => Some("CXCursor_OMPParallelMaskedTaskLoopSimdDirective")
      case CXCursor_OMPErrorDirective => Some("CXCursor_OMPErrorDirective")
      case CXCursor_OMPScopeDirective => Some("CXCursor_OMPScopeDirective")
      case CXCursor_OMPReverseDirective => Some("CXCursor_OMPReverseDirective")
      case CXCursor_OMPInterchangeDirective => Some("CXCursor_OMPInterchangeDirective")
      case CXCursor_OpenACCComputeConstruct => Some("CXCursor_OpenACCComputeConstruct")
      case CXCursor_OpenACCLoopConstruct => Some("CXCursor_OpenACCLoopConstruct")
      case CXCursor_LastStmt => Some("CXCursor_LastStmt")
      case CXCursor_TranslationUnit => Some("CXCursor_TranslationUnit")
      case CXCursor_FirstAttr => Some("CXCursor_FirstAttr")
      case CXCursor_UnexposedAttr => Some("CXCursor_UnexposedAttr")
      case CXCursor_IBActionAttr => Some("CXCursor_IBActionAttr")
      case CXCursor_IBOutletAttr => Some("CXCursor_IBOutletAttr")
      case CXCursor_IBOutletCollectionAttr => Some("CXCursor_IBOutletCollectionAttr")
      case CXCursor_CXXFinalAttr => Some("CXCursor_CXXFinalAttr")
      case CXCursor_CXXOverrideAttr => Some("CXCursor_CXXOverrideAttr")
      case CXCursor_AnnotateAttr => Some("CXCursor_AnnotateAttr")
      case CXCursor_AsmLabelAttr => Some("CXCursor_AsmLabelAttr")
      case CXCursor_PackedAttr => Some("CXCursor_PackedAttr")
      case CXCursor_PureAttr => Some("CXCursor_PureAttr")
      case CXCursor_ConstAttr => Some("CXCursor_ConstAttr")
      case CXCursor_NoDuplicateAttr => Some("CXCursor_NoDuplicateAttr")
      case CXCursor_CUDAConstantAttr => Some("CXCursor_CUDAConstantAttr")
      case CXCursor_CUDADeviceAttr => Some("CXCursor_CUDADeviceAttr")
      case CXCursor_CUDAGlobalAttr => Some("CXCursor_CUDAGlobalAttr")
      case CXCursor_CUDAHostAttr => Some("CXCursor_CUDAHostAttr")
      case CXCursor_CUDASharedAttr => Some("CXCursor_CUDASharedAttr")
      case CXCursor_VisibilityAttr => Some("CXCursor_VisibilityAttr")
      case CXCursor_DLLExport => Some("CXCursor_DLLExport")
      case CXCursor_DLLImport => Some("CXCursor_DLLImport")
      case CXCursor_NSReturnsRetained => Some("CXCursor_NSReturnsRetained")
      case CXCursor_NSReturnsNotRetained => Some("CXCursor_NSReturnsNotRetained")
      case CXCursor_NSReturnsAutoreleased => Some("CXCursor_NSReturnsAutoreleased")
      case CXCursor_NSConsumesSelf => Some("CXCursor_NSConsumesSelf")
      case CXCursor_NSConsumed => Some("CXCursor_NSConsumed")
      case CXCursor_ObjCException => Some("CXCursor_ObjCException")
      case CXCursor_ObjCNSObject => Some("CXCursor_ObjCNSObject")
      case CXCursor_ObjCIndependentClass => Some("CXCursor_ObjCIndependentClass")
      case CXCursor_ObjCPreciseLifetime => Some("CXCursor_ObjCPreciseLifetime")
      case CXCursor_ObjCReturnsInnerPointer => Some("CXCursor_ObjCReturnsInnerPointer")
      case CXCursor_ObjCRequiresSuper => Some("CXCursor_ObjCRequiresSuper")
      case CXCursor_ObjCRootClass => Some("CXCursor_ObjCRootClass")
      case CXCursor_ObjCSubclassingRestricted => Some("CXCursor_ObjCSubclassingRestricted")
      case CXCursor_ObjCExplicitProtocolImpl => Some("CXCursor_ObjCExplicitProtocolImpl")
      case CXCursor_ObjCDesignatedInitializer => Some("CXCursor_ObjCDesignatedInitializer")
      case CXCursor_ObjCRuntimeVisible => Some("CXCursor_ObjCRuntimeVisible")
      case CXCursor_ObjCBoxable => Some("CXCursor_ObjCBoxable")
      case CXCursor_FlagEnum => Some("CXCursor_FlagEnum")
      case CXCursor_ConvergentAttr => Some("CXCursor_ConvergentAttr")
      case CXCursor_WarnUnusedAttr => Some("CXCursor_WarnUnusedAttr")
      case CXCursor_WarnUnusedResultAttr => Some("CXCursor_WarnUnusedResultAttr")
      case CXCursor_AlignedAttr => Some("CXCursor_AlignedAttr")
      case CXCursor_LastAttr => Some("CXCursor_LastAttr")
      case CXCursor_PreprocessingDirective => Some("CXCursor_PreprocessingDirective")
      case CXCursor_MacroDefinition => Some("CXCursor_MacroDefinition")
      case CXCursor_MacroExpansion => Some("CXCursor_MacroExpansion")
      case CXCursor_MacroInstantiation => Some("CXCursor_MacroInstantiation")
      case CXCursor_InclusionDirective => Some("CXCursor_InclusionDirective")
      case CXCursor_FirstPreprocessing => Some("CXCursor_FirstPreprocessing")
      case CXCursor_LastPreprocessing => Some("CXCursor_LastPreprocessing")
      case CXCursor_ModuleImportDecl => Some("CXCursor_ModuleImportDecl")
      case CXCursor_TypeAliasTemplateDecl => Some("CXCursor_TypeAliasTemplateDecl")
      case CXCursor_StaticAssert => Some("CXCursor_StaticAssert")
      case CXCursor_FriendDecl => Some("CXCursor_FriendDecl")
      case CXCursor_ConceptDecl => Some("CXCursor_ConceptDecl")
      case CXCursor_FirstExtraDecl => Some("CXCursor_FirstExtraDecl")
      case CXCursor_LastExtraDecl => Some("CXCursor_LastExtraDecl")
      case CXCursor_OverloadCandidate => Some("CXCursor_OverloadCandidate")
      case _ => _root_.scala.None
  extension (a: CXCursorKind)
    inline def &(b: CXCursorKind): CXCursorKind = a & b
    inline def |(b: CXCursorKind): CXCursorKind = a | b
    inline def is(b: CXCursorKind): Boolean = (a & b) == b

/**
 * Describes the exception specification of a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCursor_ExceptionSpecificationKind = CUnsignedInt
object CXCursor_ExceptionSpecificationKind extends _BindgenEnumCUnsignedInt[CXCursor_ExceptionSpecificationKind]:
  given _tag: Tag[CXCursor_ExceptionSpecificationKind] = Tag.UInt
  inline def define(inline a: Long): CXCursor_ExceptionSpecificationKind = a.toUInt
  val CXCursor_ExceptionSpecificationKind_None = define(0)
  val CXCursor_ExceptionSpecificationKind_DynamicNone = define(1)
  val CXCursor_ExceptionSpecificationKind_Dynamic = define(2)
  val CXCursor_ExceptionSpecificationKind_MSAny = define(3)
  val CXCursor_ExceptionSpecificationKind_BasicNoexcept = define(4)
  val CXCursor_ExceptionSpecificationKind_ComputedNoexcept = define(5)
  val CXCursor_ExceptionSpecificationKind_Unevaluated = define(6)
  val CXCursor_ExceptionSpecificationKind_Uninstantiated = define(7)
  val CXCursor_ExceptionSpecificationKind_Unparsed = define(8)
  val CXCursor_ExceptionSpecificationKind_NoThrow = define(9)
  inline def getName(inline value: CXCursor_ExceptionSpecificationKind): Option[String] =
    inline value match
      case CXCursor_ExceptionSpecificationKind_None => Some("CXCursor_ExceptionSpecificationKind_None")
      case CXCursor_ExceptionSpecificationKind_DynamicNone => Some("CXCursor_ExceptionSpecificationKind_DynamicNone")
      case CXCursor_ExceptionSpecificationKind_Dynamic => Some("CXCursor_ExceptionSpecificationKind_Dynamic")
      case CXCursor_ExceptionSpecificationKind_MSAny => Some("CXCursor_ExceptionSpecificationKind_MSAny")
      case CXCursor_ExceptionSpecificationKind_BasicNoexcept => Some("CXCursor_ExceptionSpecificationKind_BasicNoexcept")
      case CXCursor_ExceptionSpecificationKind_ComputedNoexcept => Some("CXCursor_ExceptionSpecificationKind_ComputedNoexcept")
      case CXCursor_ExceptionSpecificationKind_Unevaluated => Some("CXCursor_ExceptionSpecificationKind_Unevaluated")
      case CXCursor_ExceptionSpecificationKind_Uninstantiated => Some("CXCursor_ExceptionSpecificationKind_Uninstantiated")
      case CXCursor_ExceptionSpecificationKind_Unparsed => Some("CXCursor_ExceptionSpecificationKind_Unparsed")
      case CXCursor_ExceptionSpecificationKind_NoThrow => Some("CXCursor_ExceptionSpecificationKind_NoThrow")
      case _ => _root_.scala.None
  extension (a: CXCursor_ExceptionSpecificationKind)
    inline def &(b: CXCursor_ExceptionSpecificationKind): CXCursor_ExceptionSpecificationKind = a & b
    inline def |(b: CXCursor_ExceptionSpecificationKind): CXCursor_ExceptionSpecificationKind = a | b
    inline def is(b: CXCursor_ExceptionSpecificationKind): Boolean = (a & b) == b

/**
 * Options to control the display of diagnostics.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
opaque type CXDiagnosticDisplayOptions = CUnsignedInt
object CXDiagnosticDisplayOptions extends _BindgenEnumCUnsignedInt[CXDiagnosticDisplayOptions]:
  given _tag: Tag[CXDiagnosticDisplayOptions] = Tag.UInt
  inline def define(inline a: Long): CXDiagnosticDisplayOptions = a.toUInt
  val CXDiagnostic_DisplaySourceLocation = define(1)
  val CXDiagnostic_DisplayColumn = define(2)
  val CXDiagnostic_DisplaySourceRanges = define(4)
  val CXDiagnostic_DisplayOption = define(8)
  val CXDiagnostic_DisplayCategoryId = define(16)
  val CXDiagnostic_DisplayCategoryName = define(32)
  inline def getName(inline value: CXDiagnosticDisplayOptions): Option[String] =
    inline value match
      case CXDiagnostic_DisplaySourceLocation => Some("CXDiagnostic_DisplaySourceLocation")
      case CXDiagnostic_DisplayColumn => Some("CXDiagnostic_DisplayColumn")
      case CXDiagnostic_DisplaySourceRanges => Some("CXDiagnostic_DisplaySourceRanges")
      case CXDiagnostic_DisplayOption => Some("CXDiagnostic_DisplayOption")
      case CXDiagnostic_DisplayCategoryId => Some("CXDiagnostic_DisplayCategoryId")
      case CXDiagnostic_DisplayCategoryName => Some("CXDiagnostic_DisplayCategoryName")
      case _ => _root_.scala.None
  extension (a: CXDiagnosticDisplayOptions)
    inline def &(b: CXDiagnosticDisplayOptions): CXDiagnosticDisplayOptions = a & b
    inline def |(b: CXDiagnosticDisplayOptions): CXDiagnosticDisplayOptions = a | b
    inline def is(b: CXDiagnosticDisplayOptions): Boolean = (a & b) == b

/**
 * Describes the severity of a particular diagnostic.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
opaque type CXDiagnosticSeverity = CUnsignedInt
object CXDiagnosticSeverity extends _BindgenEnumCUnsignedInt[CXDiagnosticSeverity]:
  given _tag: Tag[CXDiagnosticSeverity] = Tag.UInt
  inline def define(inline a: Long): CXDiagnosticSeverity = a.toUInt
  val CXDiagnostic_Ignored = define(0)
  val CXDiagnostic_Note = define(1)
  val CXDiagnostic_Warning = define(2)
  val CXDiagnostic_Error = define(3)
  val CXDiagnostic_Fatal = define(4)
  inline def getName(inline value: CXDiagnosticSeverity): Option[String] =
    inline value match
      case CXDiagnostic_Ignored => Some("CXDiagnostic_Ignored")
      case CXDiagnostic_Note => Some("CXDiagnostic_Note")
      case CXDiagnostic_Warning => Some("CXDiagnostic_Warning")
      case CXDiagnostic_Error => Some("CXDiagnostic_Error")
      case CXDiagnostic_Fatal => Some("CXDiagnostic_Fatal")
      case _ => _root_.scala.None
  extension (a: CXDiagnosticSeverity)
    inline def &(b: CXDiagnosticSeverity): CXDiagnosticSeverity = a & b
    inline def |(b: CXDiagnosticSeverity): CXDiagnosticSeverity = a | b
    inline def is(b: CXDiagnosticSeverity): Boolean = (a & b) == b

/**
 * Error codes returned by libclang routines.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXErrorCode.h
*/
opaque type CXErrorCode = CUnsignedInt
object CXErrorCode extends _BindgenEnumCUnsignedInt[CXErrorCode]:
  given _tag: Tag[CXErrorCode] = Tag.UInt
  inline def define(inline a: Long): CXErrorCode = a.toUInt
  val CXError_Success = define(0)
  val CXError_Failure = define(1)
  val CXError_Crashed = define(2)
  val CXError_InvalidArguments = define(3)
  val CXError_ASTReadError = define(4)
  inline def getName(inline value: CXErrorCode): Option[String] =
    inline value match
      case CXError_Success => Some("CXError_Success")
      case CXError_Failure => Some("CXError_Failure")
      case CXError_Crashed => Some("CXError_Crashed")
      case CXError_InvalidArguments => Some("CXError_InvalidArguments")
      case CXError_ASTReadError => Some("CXError_ASTReadError")
      case _ => _root_.scala.None
  extension (a: CXErrorCode)
    inline def &(b: CXErrorCode): CXErrorCode = a & b
    inline def |(b: CXErrorCode): CXErrorCode = a | b
    inline def is(b: CXErrorCode): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXEvalResultKind = CUnsignedInt
object CXEvalResultKind extends _BindgenEnumCUnsignedInt[CXEvalResultKind]:
  given _tag: Tag[CXEvalResultKind] = Tag.UInt
  inline def define(inline a: Long): CXEvalResultKind = a.toUInt
  val CXEval_Int = define(1)
  val CXEval_Float = define(2)
  val CXEval_ObjCStrLiteral = define(3)
  val CXEval_StrLiteral = define(4)
  val CXEval_CFStr = define(5)
  val CXEval_Other = define(6)
  val CXEval_UnExposed = define(0)
  inline def getName(inline value: CXEvalResultKind): Option[String] =
    inline value match
      case CXEval_Int => Some("CXEval_Int")
      case CXEval_Float => Some("CXEval_Float")
      case CXEval_ObjCStrLiteral => Some("CXEval_ObjCStrLiteral")
      case CXEval_StrLiteral => Some("CXEval_StrLiteral")
      case CXEval_CFStr => Some("CXEval_CFStr")
      case CXEval_Other => Some("CXEval_Other")
      case CXEval_UnExposed => Some("CXEval_UnExposed")
      case _ => _root_.scala.None
  extension (a: CXEvalResultKind)
    inline def &(b: CXEvalResultKind): CXEvalResultKind = a & b
    inline def |(b: CXEvalResultKind): CXEvalResultKind = a | b
    inline def is(b: CXEvalResultKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXGlobalOptFlags = CUnsignedInt
object CXGlobalOptFlags extends _BindgenEnumCUnsignedInt[CXGlobalOptFlags]:
  given _tag: Tag[CXGlobalOptFlags] = Tag.UInt
  inline def define(inline a: Long): CXGlobalOptFlags = a.toUInt
  val CXGlobalOpt_None = define(0)
  val CXGlobalOpt_ThreadBackgroundPriorityForIndexing = define(1)
  val CXGlobalOpt_ThreadBackgroundPriorityForEditing = define(2)
  val CXGlobalOpt_ThreadBackgroundPriorityForAll = define(3)
  inline def getName(inline value: CXGlobalOptFlags): Option[String] =
    inline value match
      case CXGlobalOpt_None => Some("CXGlobalOpt_None")
      case CXGlobalOpt_ThreadBackgroundPriorityForIndexing => Some("CXGlobalOpt_ThreadBackgroundPriorityForIndexing")
      case CXGlobalOpt_ThreadBackgroundPriorityForEditing => Some("CXGlobalOpt_ThreadBackgroundPriorityForEditing")
      case CXGlobalOpt_ThreadBackgroundPriorityForAll => Some("CXGlobalOpt_ThreadBackgroundPriorityForAll")
      case _ => _root_.scala.None
  extension (a: CXGlobalOptFlags)
    inline def &(b: CXGlobalOptFlags): CXGlobalOptFlags = a & b
    inline def |(b: CXGlobalOptFlags): CXGlobalOptFlags = a | b
    inline def is(b: CXGlobalOptFlags): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxAttrKind = CUnsignedInt
object CXIdxAttrKind extends _BindgenEnumCUnsignedInt[CXIdxAttrKind]:
  given _tag: Tag[CXIdxAttrKind] = Tag.UInt
  inline def define(inline a: Long): CXIdxAttrKind = a.toUInt
  val CXIdxAttr_Unexposed = define(0)
  val CXIdxAttr_IBAction = define(1)
  val CXIdxAttr_IBOutlet = define(2)
  val CXIdxAttr_IBOutletCollection = define(3)
  inline def getName(inline value: CXIdxAttrKind): Option[String] =
    inline value match
      case CXIdxAttr_Unexposed => Some("CXIdxAttr_Unexposed")
      case CXIdxAttr_IBAction => Some("CXIdxAttr_IBAction")
      case CXIdxAttr_IBOutlet => Some("CXIdxAttr_IBOutlet")
      case CXIdxAttr_IBOutletCollection => Some("CXIdxAttr_IBOutletCollection")
      case _ => _root_.scala.None
  extension (a: CXIdxAttrKind)
    inline def &(b: CXIdxAttrKind): CXIdxAttrKind = a & b
    inline def |(b: CXIdxAttrKind): CXIdxAttrKind = a | b
    inline def is(b: CXIdxAttrKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxDeclInfoFlags = CUnsignedInt
object CXIdxDeclInfoFlags extends _BindgenEnumCUnsignedInt[CXIdxDeclInfoFlags]:
  given _tag: Tag[CXIdxDeclInfoFlags] = Tag.UInt
  inline def define(inline a: Long): CXIdxDeclInfoFlags = a.toUInt
  val CXIdxDeclFlag_Skipped = define(1)
  inline def getName(inline value: CXIdxDeclInfoFlags): Option[String] =
    inline value match
      case CXIdxDeclFlag_Skipped => Some("CXIdxDeclFlag_Skipped")
      case _ => _root_.scala.None
  extension (a: CXIdxDeclInfoFlags)
    inline def &(b: CXIdxDeclInfoFlags): CXIdxDeclInfoFlags = a & b
    inline def |(b: CXIdxDeclInfoFlags): CXIdxDeclInfoFlags = a | b
    inline def is(b: CXIdxDeclInfoFlags): Boolean = (a & b) == b

/**
 * Extra C++ template information for an entity. This can apply to: CXIdxEntity_Function CXIdxEntity_CXXClass CXIdxEntity_CXXStaticMethod CXIdxEntity_CXXInstanceMethod CXIdxEntity_CXXConstructor CXIdxEntity_CXXConversionFunction CXIdxEntity_CXXTypeAlias

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxEntityCXXTemplateKind = CUnsignedInt
object CXIdxEntityCXXTemplateKind extends _BindgenEnumCUnsignedInt[CXIdxEntityCXXTemplateKind]:
  given _tag: Tag[CXIdxEntityCXXTemplateKind] = Tag.UInt
  inline def define(inline a: Long): CXIdxEntityCXXTemplateKind = a.toUInt
  val CXIdxEntity_NonTemplate = define(0)
  val CXIdxEntity_Template = define(1)
  val CXIdxEntity_TemplatePartialSpecialization = define(2)
  val CXIdxEntity_TemplateSpecialization = define(3)
  inline def getName(inline value: CXIdxEntityCXXTemplateKind): Option[String] =
    inline value match
      case CXIdxEntity_NonTemplate => Some("CXIdxEntity_NonTemplate")
      case CXIdxEntity_Template => Some("CXIdxEntity_Template")
      case CXIdxEntity_TemplatePartialSpecialization => Some("CXIdxEntity_TemplatePartialSpecialization")
      case CXIdxEntity_TemplateSpecialization => Some("CXIdxEntity_TemplateSpecialization")
      case _ => _root_.scala.None
  extension (a: CXIdxEntityCXXTemplateKind)
    inline def &(b: CXIdxEntityCXXTemplateKind): CXIdxEntityCXXTemplateKind = a & b
    inline def |(b: CXIdxEntityCXXTemplateKind): CXIdxEntityCXXTemplateKind = a | b
    inline def is(b: CXIdxEntityCXXTemplateKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxEntityKind = CUnsignedInt
object CXIdxEntityKind extends _BindgenEnumCUnsignedInt[CXIdxEntityKind]:
  given _tag: Tag[CXIdxEntityKind] = Tag.UInt
  inline def define(inline a: Long): CXIdxEntityKind = a.toUInt
  val CXIdxEntity_Unexposed = define(0)
  val CXIdxEntity_Typedef = define(1)
  val CXIdxEntity_Function = define(2)
  val CXIdxEntity_Variable = define(3)
  val CXIdxEntity_Field = define(4)
  val CXIdxEntity_EnumConstant = define(5)
  val CXIdxEntity_ObjCClass = define(6)
  val CXIdxEntity_ObjCProtocol = define(7)
  val CXIdxEntity_ObjCCategory = define(8)
  val CXIdxEntity_ObjCInstanceMethod = define(9)
  val CXIdxEntity_ObjCClassMethod = define(10)
  val CXIdxEntity_ObjCProperty = define(11)
  val CXIdxEntity_ObjCIvar = define(12)
  val CXIdxEntity_Enum = define(13)
  val CXIdxEntity_Struct = define(14)
  val CXIdxEntity_Union = define(15)
  val CXIdxEntity_CXXClass = define(16)
  val CXIdxEntity_CXXNamespace = define(17)
  val CXIdxEntity_CXXNamespaceAlias = define(18)
  val CXIdxEntity_CXXStaticVariable = define(19)
  val CXIdxEntity_CXXStaticMethod = define(20)
  val CXIdxEntity_CXXInstanceMethod = define(21)
  val CXIdxEntity_CXXConstructor = define(22)
  val CXIdxEntity_CXXDestructor = define(23)
  val CXIdxEntity_CXXConversionFunction = define(24)
  val CXIdxEntity_CXXTypeAlias = define(25)
  val CXIdxEntity_CXXInterface = define(26)
  val CXIdxEntity_CXXConcept = define(27)
  inline def getName(inline value: CXIdxEntityKind): Option[String] =
    inline value match
      case CXIdxEntity_Unexposed => Some("CXIdxEntity_Unexposed")
      case CXIdxEntity_Typedef => Some("CXIdxEntity_Typedef")
      case CXIdxEntity_Function => Some("CXIdxEntity_Function")
      case CXIdxEntity_Variable => Some("CXIdxEntity_Variable")
      case CXIdxEntity_Field => Some("CXIdxEntity_Field")
      case CXIdxEntity_EnumConstant => Some("CXIdxEntity_EnumConstant")
      case CXIdxEntity_ObjCClass => Some("CXIdxEntity_ObjCClass")
      case CXIdxEntity_ObjCProtocol => Some("CXIdxEntity_ObjCProtocol")
      case CXIdxEntity_ObjCCategory => Some("CXIdxEntity_ObjCCategory")
      case CXIdxEntity_ObjCInstanceMethod => Some("CXIdxEntity_ObjCInstanceMethod")
      case CXIdxEntity_ObjCClassMethod => Some("CXIdxEntity_ObjCClassMethod")
      case CXIdxEntity_ObjCProperty => Some("CXIdxEntity_ObjCProperty")
      case CXIdxEntity_ObjCIvar => Some("CXIdxEntity_ObjCIvar")
      case CXIdxEntity_Enum => Some("CXIdxEntity_Enum")
      case CXIdxEntity_Struct => Some("CXIdxEntity_Struct")
      case CXIdxEntity_Union => Some("CXIdxEntity_Union")
      case CXIdxEntity_CXXClass => Some("CXIdxEntity_CXXClass")
      case CXIdxEntity_CXXNamespace => Some("CXIdxEntity_CXXNamespace")
      case CXIdxEntity_CXXNamespaceAlias => Some("CXIdxEntity_CXXNamespaceAlias")
      case CXIdxEntity_CXXStaticVariable => Some("CXIdxEntity_CXXStaticVariable")
      case CXIdxEntity_CXXStaticMethod => Some("CXIdxEntity_CXXStaticMethod")
      case CXIdxEntity_CXXInstanceMethod => Some("CXIdxEntity_CXXInstanceMethod")
      case CXIdxEntity_CXXConstructor => Some("CXIdxEntity_CXXConstructor")
      case CXIdxEntity_CXXDestructor => Some("CXIdxEntity_CXXDestructor")
      case CXIdxEntity_CXXConversionFunction => Some("CXIdxEntity_CXXConversionFunction")
      case CXIdxEntity_CXXTypeAlias => Some("CXIdxEntity_CXXTypeAlias")
      case CXIdxEntity_CXXInterface => Some("CXIdxEntity_CXXInterface")
      case CXIdxEntity_CXXConcept => Some("CXIdxEntity_CXXConcept")
      case _ => _root_.scala.None
  extension (a: CXIdxEntityKind)
    inline def &(b: CXIdxEntityKind): CXIdxEntityKind = a & b
    inline def |(b: CXIdxEntityKind): CXIdxEntityKind = a | b
    inline def is(b: CXIdxEntityKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxEntityLanguage = CUnsignedInt
object CXIdxEntityLanguage extends _BindgenEnumCUnsignedInt[CXIdxEntityLanguage]:
  given _tag: Tag[CXIdxEntityLanguage] = Tag.UInt
  inline def define(inline a: Long): CXIdxEntityLanguage = a.toUInt
  val CXIdxEntityLang_None = define(0)
  val CXIdxEntityLang_C = define(1)
  val CXIdxEntityLang_ObjC = define(2)
  val CXIdxEntityLang_CXX = define(3)
  val CXIdxEntityLang_Swift = define(4)
  inline def getName(inline value: CXIdxEntityLanguage): Option[String] =
    inline value match
      case CXIdxEntityLang_None => Some("CXIdxEntityLang_None")
      case CXIdxEntityLang_C => Some("CXIdxEntityLang_C")
      case CXIdxEntityLang_ObjC => Some("CXIdxEntityLang_ObjC")
      case CXIdxEntityLang_CXX => Some("CXIdxEntityLang_CXX")
      case CXIdxEntityLang_Swift => Some("CXIdxEntityLang_Swift")
      case _ => _root_.scala.None
  extension (a: CXIdxEntityLanguage)
    inline def &(b: CXIdxEntityLanguage): CXIdxEntityLanguage = a & b
    inline def |(b: CXIdxEntityLanguage): CXIdxEntityLanguage = a | b
    inline def is(b: CXIdxEntityLanguage): Boolean = (a & b) == b

/**
 * Data for IndexerCallbacks#indexEntityReference.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxEntityRefKind = CUnsignedInt
object CXIdxEntityRefKind extends _BindgenEnumCUnsignedInt[CXIdxEntityRefKind]:
  given _tag: Tag[CXIdxEntityRefKind] = Tag.UInt
  inline def define(inline a: Long): CXIdxEntityRefKind = a.toUInt
  val CXIdxEntityRef_Direct = define(1)
  val CXIdxEntityRef_Implicit = define(2)
  inline def getName(inline value: CXIdxEntityRefKind): Option[String] =
    inline value match
      case CXIdxEntityRef_Direct => Some("CXIdxEntityRef_Direct")
      case CXIdxEntityRef_Implicit => Some("CXIdxEntityRef_Implicit")
      case _ => _root_.scala.None
  extension (a: CXIdxEntityRefKind)
    inline def &(b: CXIdxEntityRefKind): CXIdxEntityRefKind = a & b
    inline def |(b: CXIdxEntityRefKind): CXIdxEntityRefKind = a | b
    inline def is(b: CXIdxEntityRefKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCContainerKind = CUnsignedInt
object CXIdxObjCContainerKind extends _BindgenEnumCUnsignedInt[CXIdxObjCContainerKind]:
  given _tag: Tag[CXIdxObjCContainerKind] = Tag.UInt
  inline def define(inline a: Long): CXIdxObjCContainerKind = a.toUInt
  val CXIdxObjCContainer_ForwardRef = define(0)
  val CXIdxObjCContainer_Interface = define(1)
  val CXIdxObjCContainer_Implementation = define(2)
  inline def getName(inline value: CXIdxObjCContainerKind): Option[String] =
    inline value match
      case CXIdxObjCContainer_ForwardRef => Some("CXIdxObjCContainer_ForwardRef")
      case CXIdxObjCContainer_Interface => Some("CXIdxObjCContainer_Interface")
      case CXIdxObjCContainer_Implementation => Some("CXIdxObjCContainer_Implementation")
      case _ => _root_.scala.None
  extension (a: CXIdxObjCContainerKind)
    inline def &(b: CXIdxObjCContainerKind): CXIdxObjCContainerKind = a & b
    inline def |(b: CXIdxObjCContainerKind): CXIdxObjCContainerKind = a | b
    inline def is(b: CXIdxObjCContainerKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIndexOptFlags = CUnsignedInt
object CXIndexOptFlags extends _BindgenEnumCUnsignedInt[CXIndexOptFlags]:
  given _tag: Tag[CXIndexOptFlags] = Tag.UInt
  inline def define(inline a: Long): CXIndexOptFlags = a.toUInt
  val CXIndexOpt_None = define(0)
  val CXIndexOpt_SuppressRedundantRefs = define(1)
  val CXIndexOpt_IndexFunctionLocalSymbols = define(2)
  val CXIndexOpt_IndexImplicitTemplateInstantiations = define(4)
  val CXIndexOpt_SuppressWarnings = define(8)
  val CXIndexOpt_SkipParsedBodiesInSession = define(16)
  inline def getName(inline value: CXIndexOptFlags): Option[String] =
    inline value match
      case CXIndexOpt_None => Some("CXIndexOpt_None")
      case CXIndexOpt_SuppressRedundantRefs => Some("CXIndexOpt_SuppressRedundantRefs")
      case CXIndexOpt_IndexFunctionLocalSymbols => Some("CXIndexOpt_IndexFunctionLocalSymbols")
      case CXIndexOpt_IndexImplicitTemplateInstantiations => Some("CXIndexOpt_IndexImplicitTemplateInstantiations")
      case CXIndexOpt_SuppressWarnings => Some("CXIndexOpt_SuppressWarnings")
      case CXIndexOpt_SkipParsedBodiesInSession => Some("CXIndexOpt_SkipParsedBodiesInSession")
      case _ => _root_.scala.None
  extension (a: CXIndexOptFlags)
    inline def &(b: CXIndexOptFlags): CXIndexOptFlags = a & b
    inline def |(b: CXIndexOptFlags): CXIndexOptFlags = a | b
    inline def is(b: CXIndexOptFlags): Boolean = (a & b) == b

/**
 * Describe the "language" of the entity referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXLanguageKind = CUnsignedInt
object CXLanguageKind extends _BindgenEnumCUnsignedInt[CXLanguageKind]:
  given _tag: Tag[CXLanguageKind] = Tag.UInt
  inline def define(inline a: Long): CXLanguageKind = a.toUInt
  val CXLanguage_Invalid = define(0)
  val CXLanguage_C = define(1)
  val CXLanguage_ObjC = define(2)
  val CXLanguage_CPlusPlus = define(3)
  inline def getName(inline value: CXLanguageKind): Option[String] =
    inline value match
      case CXLanguage_Invalid => Some("CXLanguage_Invalid")
      case CXLanguage_C => Some("CXLanguage_C")
      case CXLanguage_ObjC => Some("CXLanguage_ObjC")
      case CXLanguage_CPlusPlus => Some("CXLanguage_CPlusPlus")
      case _ => _root_.scala.None
  extension (a: CXLanguageKind)
    inline def &(b: CXLanguageKind): CXLanguageKind = a & b
    inline def |(b: CXLanguageKind): CXLanguageKind = a | b
    inline def is(b: CXLanguageKind): Boolean = (a & b) == b

/**
 * Describe the linkage of the entity referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXLinkageKind = CUnsignedInt
object CXLinkageKind extends _BindgenEnumCUnsignedInt[CXLinkageKind]:
  given _tag: Tag[CXLinkageKind] = Tag.UInt
  inline def define(inline a: Long): CXLinkageKind = a.toUInt
  val CXLinkage_Invalid = define(0)
  val CXLinkage_NoLinkage = define(1)
  val CXLinkage_Internal = define(2)
  val CXLinkage_UniqueExternal = define(3)
  val CXLinkage_External = define(4)
  inline def getName(inline value: CXLinkageKind): Option[String] =
    inline value match
      case CXLinkage_Invalid => Some("CXLinkage_Invalid")
      case CXLinkage_NoLinkage => Some("CXLinkage_NoLinkage")
      case CXLinkage_Internal => Some("CXLinkage_Internal")
      case CXLinkage_UniqueExternal => Some("CXLinkage_UniqueExternal")
      case CXLinkage_External => Some("CXLinkage_External")
      case _ => _root_.scala.None
  extension (a: CXLinkageKind)
    inline def &(b: CXLinkageKind): CXLinkageKind = a & b
    inline def |(b: CXLinkageKind): CXLinkageKind = a | b
    inline def is(b: CXLinkageKind): Boolean = (a & b) == b

/**
 * Describes the kind of error that occurred (if any) in a call to clang_loadDiagnostics.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXDiagnostic.h
*/
opaque type CXLoadDiag_Error = CUnsignedInt
object CXLoadDiag_Error extends _BindgenEnumCUnsignedInt[CXLoadDiag_Error]:
  given _tag: Tag[CXLoadDiag_Error] = Tag.UInt
  inline def define(inline a: Long): CXLoadDiag_Error = a.toUInt
  val CXLoadDiag_None = define(0)
  val CXLoadDiag_Unknown = define(1)
  val CXLoadDiag_CannotLoad = define(2)
  val CXLoadDiag_InvalidFile = define(3)
  inline def getName(inline value: CXLoadDiag_Error): Option[String] =
    inline value match
      case CXLoadDiag_None => Some("CXLoadDiag_None")
      case CXLoadDiag_Unknown => Some("CXLoadDiag_Unknown")
      case CXLoadDiag_CannotLoad => Some("CXLoadDiag_CannotLoad")
      case CXLoadDiag_InvalidFile => Some("CXLoadDiag_InvalidFile")
      case _ => _root_.scala.None
  extension (a: CXLoadDiag_Error)
    inline def &(b: CXLoadDiag_Error): CXLoadDiag_Error = a & b
    inline def |(b: CXLoadDiag_Error): CXLoadDiag_Error = a | b
    inline def is(b: CXLoadDiag_Error): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXNameRefFlags = CUnsignedInt
object CXNameRefFlags extends _BindgenEnumCUnsignedInt[CXNameRefFlags]:
  given _tag: Tag[CXNameRefFlags] = Tag.UInt
  inline def define(inline a: Long): CXNameRefFlags = a.toUInt
  val CXNameRange_WantQualifier = define(1)
  val CXNameRange_WantTemplateArgs = define(2)
  val CXNameRange_WantSinglePiece = define(4)
  inline def getName(inline value: CXNameRefFlags): Option[String] =
    inline value match
      case CXNameRange_WantQualifier => Some("CXNameRange_WantQualifier")
      case CXNameRange_WantTemplateArgs => Some("CXNameRange_WantTemplateArgs")
      case CXNameRange_WantSinglePiece => Some("CXNameRange_WantSinglePiece")
      case _ => _root_.scala.None
  extension (a: CXNameRefFlags)
    inline def &(b: CXNameRefFlags): CXNameRefFlags = a & b
    inline def |(b: CXNameRefFlags): CXNameRefFlags = a | b
    inline def is(b: CXNameRefFlags): Boolean = (a & b) == b

/**
 * 'Qualifiers' written next to the return and parameter types in Objective-C method declarations.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXObjCDeclQualifierKind = CUnsignedInt
object CXObjCDeclQualifierKind extends _BindgenEnumCUnsignedInt[CXObjCDeclQualifierKind]:
  given _tag: Tag[CXObjCDeclQualifierKind] = Tag.UInt
  inline def define(inline a: Long): CXObjCDeclQualifierKind = a.toUInt
  val CXObjCDeclQualifier_None = define(0)
  val CXObjCDeclQualifier_In = define(1)
  val CXObjCDeclQualifier_Inout = define(2)
  val CXObjCDeclQualifier_Out = define(4)
  val CXObjCDeclQualifier_Bycopy = define(8)
  val CXObjCDeclQualifier_Byref = define(16)
  val CXObjCDeclQualifier_Oneway = define(32)
  inline def getName(inline value: CXObjCDeclQualifierKind): Option[String] =
    inline value match
      case CXObjCDeclQualifier_None => Some("CXObjCDeclQualifier_None")
      case CXObjCDeclQualifier_In => Some("CXObjCDeclQualifier_In")
      case CXObjCDeclQualifier_Inout => Some("CXObjCDeclQualifier_Inout")
      case CXObjCDeclQualifier_Out => Some("CXObjCDeclQualifier_Out")
      case CXObjCDeclQualifier_Bycopy => Some("CXObjCDeclQualifier_Bycopy")
      case CXObjCDeclQualifier_Byref => Some("CXObjCDeclQualifier_Byref")
      case CXObjCDeclQualifier_Oneway => Some("CXObjCDeclQualifier_Oneway")
      case _ => _root_.scala.None
  extension (a: CXObjCDeclQualifierKind)
    inline def &(b: CXObjCDeclQualifierKind): CXObjCDeclQualifierKind = a & b
    inline def |(b: CXObjCDeclQualifierKind): CXObjCDeclQualifierKind = a | b
    inline def is(b: CXObjCDeclQualifierKind): Boolean = (a & b) == b

/**
 * Property attributes for a CXCursor_ObjCPropertyDecl.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXObjCPropertyAttrKind = CUnsignedInt
object CXObjCPropertyAttrKind extends _BindgenEnumCUnsignedInt[CXObjCPropertyAttrKind]:
  given _tag: Tag[CXObjCPropertyAttrKind] = Tag.UInt
  inline def define(inline a: Long): CXObjCPropertyAttrKind = a.toUInt
  val CXObjCPropertyAttr_noattr = define(0)
  val CXObjCPropertyAttr_readonly = define(1)
  val CXObjCPropertyAttr_getter = define(2)
  val CXObjCPropertyAttr_assign = define(4)
  val CXObjCPropertyAttr_readwrite = define(8)
  val CXObjCPropertyAttr_retain = define(16)
  val CXObjCPropertyAttr_copy = define(32)
  val CXObjCPropertyAttr_nonatomic = define(64)
  val CXObjCPropertyAttr_setter = define(128)
  val CXObjCPropertyAttr_atomic = define(256)
  val CXObjCPropertyAttr_weak = define(512)
  val CXObjCPropertyAttr_strong = define(1024)
  val CXObjCPropertyAttr_unsafe_unretained = define(2048)
  val CXObjCPropertyAttr_class = define(4096)
  inline def getName(inline value: CXObjCPropertyAttrKind): Option[String] =
    inline value match
      case CXObjCPropertyAttr_noattr => Some("CXObjCPropertyAttr_noattr")
      case CXObjCPropertyAttr_readonly => Some("CXObjCPropertyAttr_readonly")
      case CXObjCPropertyAttr_getter => Some("CXObjCPropertyAttr_getter")
      case CXObjCPropertyAttr_assign => Some("CXObjCPropertyAttr_assign")
      case CXObjCPropertyAttr_readwrite => Some("CXObjCPropertyAttr_readwrite")
      case CXObjCPropertyAttr_retain => Some("CXObjCPropertyAttr_retain")
      case CXObjCPropertyAttr_copy => Some("CXObjCPropertyAttr_copy")
      case CXObjCPropertyAttr_nonatomic => Some("CXObjCPropertyAttr_nonatomic")
      case CXObjCPropertyAttr_setter => Some("CXObjCPropertyAttr_setter")
      case CXObjCPropertyAttr_atomic => Some("CXObjCPropertyAttr_atomic")
      case CXObjCPropertyAttr_weak => Some("CXObjCPropertyAttr_weak")
      case CXObjCPropertyAttr_strong => Some("CXObjCPropertyAttr_strong")
      case CXObjCPropertyAttr_unsafe_unretained => Some("CXObjCPropertyAttr_unsafe_unretained")
      case CXObjCPropertyAttr_class => Some("CXObjCPropertyAttr_class")
      case _ => _root_.scala.None
  extension (a: CXObjCPropertyAttrKind)
    inline def &(b: CXObjCPropertyAttrKind): CXObjCPropertyAttrKind = a & b
    inline def |(b: CXObjCPropertyAttrKind): CXObjCPropertyAttrKind = a | b
    inline def is(b: CXObjCPropertyAttrKind): Boolean = (a & b) == b

/**
 * Properties for the printing policy.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXPrintingPolicyProperty = CUnsignedInt
object CXPrintingPolicyProperty extends _BindgenEnumCUnsignedInt[CXPrintingPolicyProperty]:
  given _tag: Tag[CXPrintingPolicyProperty] = Tag.UInt
  inline def define(inline a: Long): CXPrintingPolicyProperty = a.toUInt
  val CXPrintingPolicy_Indentation = define(0)
  val CXPrintingPolicy_SuppressSpecifiers = define(1)
  val CXPrintingPolicy_SuppressTagKeyword = define(2)
  val CXPrintingPolicy_IncludeTagDefinition = define(3)
  val CXPrintingPolicy_SuppressScope = define(4)
  val CXPrintingPolicy_SuppressUnwrittenScope = define(5)
  val CXPrintingPolicy_SuppressInitializers = define(6)
  val CXPrintingPolicy_ConstantArraySizeAsWritten = define(7)
  val CXPrintingPolicy_AnonymousTagLocations = define(8)
  val CXPrintingPolicy_SuppressStrongLifetime = define(9)
  val CXPrintingPolicy_SuppressLifetimeQualifiers = define(10)
  val CXPrintingPolicy_SuppressTemplateArgsInCXXConstructors = define(11)
  val CXPrintingPolicy_Bool = define(12)
  val CXPrintingPolicy_Restrict = define(13)
  val CXPrintingPolicy_Alignof = define(14)
  val CXPrintingPolicy_UnderscoreAlignof = define(15)
  val CXPrintingPolicy_UseVoidForZeroParams = define(16)
  val CXPrintingPolicy_TerseOutput = define(17)
  val CXPrintingPolicy_PolishForDeclaration = define(18)
  val CXPrintingPolicy_Half = define(19)
  val CXPrintingPolicy_MSWChar = define(20)
  val CXPrintingPolicy_IncludeNewlines = define(21)
  val CXPrintingPolicy_MSVCFormatting = define(22)
  val CXPrintingPolicy_ConstantsAsWritten = define(23)
  val CXPrintingPolicy_SuppressImplicitBase = define(24)
  val CXPrintingPolicy_FullyQualifiedName = define(25)
  val CXPrintingPolicy_LastProperty = define(25)
  inline def getName(inline value: CXPrintingPolicyProperty): Option[String] =
    inline value match
      case CXPrintingPolicy_Indentation => Some("CXPrintingPolicy_Indentation")
      case CXPrintingPolicy_SuppressSpecifiers => Some("CXPrintingPolicy_SuppressSpecifiers")
      case CXPrintingPolicy_SuppressTagKeyword => Some("CXPrintingPolicy_SuppressTagKeyword")
      case CXPrintingPolicy_IncludeTagDefinition => Some("CXPrintingPolicy_IncludeTagDefinition")
      case CXPrintingPolicy_SuppressScope => Some("CXPrintingPolicy_SuppressScope")
      case CXPrintingPolicy_SuppressUnwrittenScope => Some("CXPrintingPolicy_SuppressUnwrittenScope")
      case CXPrintingPolicy_SuppressInitializers => Some("CXPrintingPolicy_SuppressInitializers")
      case CXPrintingPolicy_ConstantArraySizeAsWritten => Some("CXPrintingPolicy_ConstantArraySizeAsWritten")
      case CXPrintingPolicy_AnonymousTagLocations => Some("CXPrintingPolicy_AnonymousTagLocations")
      case CXPrintingPolicy_SuppressStrongLifetime => Some("CXPrintingPolicy_SuppressStrongLifetime")
      case CXPrintingPolicy_SuppressLifetimeQualifiers => Some("CXPrintingPolicy_SuppressLifetimeQualifiers")
      case CXPrintingPolicy_SuppressTemplateArgsInCXXConstructors => Some("CXPrintingPolicy_SuppressTemplateArgsInCXXConstructors")
      case CXPrintingPolicy_Bool => Some("CXPrintingPolicy_Bool")
      case CXPrintingPolicy_Restrict => Some("CXPrintingPolicy_Restrict")
      case CXPrintingPolicy_Alignof => Some("CXPrintingPolicy_Alignof")
      case CXPrintingPolicy_UnderscoreAlignof => Some("CXPrintingPolicy_UnderscoreAlignof")
      case CXPrintingPolicy_UseVoidForZeroParams => Some("CXPrintingPolicy_UseVoidForZeroParams")
      case CXPrintingPolicy_TerseOutput => Some("CXPrintingPolicy_TerseOutput")
      case CXPrintingPolicy_PolishForDeclaration => Some("CXPrintingPolicy_PolishForDeclaration")
      case CXPrintingPolicy_Half => Some("CXPrintingPolicy_Half")
      case CXPrintingPolicy_MSWChar => Some("CXPrintingPolicy_MSWChar")
      case CXPrintingPolicy_IncludeNewlines => Some("CXPrintingPolicy_IncludeNewlines")
      case CXPrintingPolicy_MSVCFormatting => Some("CXPrintingPolicy_MSVCFormatting")
      case CXPrintingPolicy_ConstantsAsWritten => Some("CXPrintingPolicy_ConstantsAsWritten")
      case CXPrintingPolicy_SuppressImplicitBase => Some("CXPrintingPolicy_SuppressImplicitBase")
      case CXPrintingPolicy_FullyQualifiedName => Some("CXPrintingPolicy_FullyQualifiedName")
      case CXPrintingPolicy_LastProperty => Some("CXPrintingPolicy_LastProperty")
      case _ => _root_.scala.None
  extension (a: CXPrintingPolicyProperty)
    inline def &(b: CXPrintingPolicyProperty): CXPrintingPolicyProperty = a & b
    inline def |(b: CXPrintingPolicyProperty): CXPrintingPolicyProperty = a | b
    inline def is(b: CXPrintingPolicyProperty): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXRefQualifierKind = CUnsignedInt
object CXRefQualifierKind extends _BindgenEnumCUnsignedInt[CXRefQualifierKind]:
  given _tag: Tag[CXRefQualifierKind] = Tag.UInt
  inline def define(inline a: Long): CXRefQualifierKind = a.toUInt
  val CXRefQualifier_None = define(0)
  val CXRefQualifier_LValue = define(1)
  val CXRefQualifier_RValue = define(2)
  inline def getName(inline value: CXRefQualifierKind): Option[String] =
    inline value match
      case CXRefQualifier_None => Some("CXRefQualifier_None")
      case CXRefQualifier_LValue => Some("CXRefQualifier_LValue")
      case CXRefQualifier_RValue => Some("CXRefQualifier_RValue")
      case _ => _root_.scala.None
  extension (a: CXRefQualifierKind)
    inline def &(b: CXRefQualifierKind): CXRefQualifierKind = a & b
    inline def |(b: CXRefQualifierKind): CXRefQualifierKind = a | b
    inline def is(b: CXRefQualifierKind): Boolean = (a & b) == b

/**
 * Flags that control the reparsing of translation units.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXReparse_Flags = CUnsignedInt
object CXReparse_Flags extends _BindgenEnumCUnsignedInt[CXReparse_Flags]:
  given _tag: Tag[CXReparse_Flags] = Tag.UInt
  inline def define(inline a: Long): CXReparse_Flags = a.toUInt
  val CXReparse_None = define(0)
  inline def getName(inline value: CXReparse_Flags): Option[String] =
    inline value match
      case CXReparse_None => Some("CXReparse_None")
      case _ => _root_.scala.None
  extension (a: CXReparse_Flags)
    inline def &(b: CXReparse_Flags): CXReparse_Flags = a & b
    inline def |(b: CXReparse_Flags): CXReparse_Flags = a | b
    inline def is(b: CXReparse_Flags): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXResult = CUnsignedInt
object CXResult extends _BindgenEnumCUnsignedInt[CXResult]:
  given _tag: Tag[CXResult] = Tag.UInt
  inline def define(inline a: Long): CXResult = a.toUInt
  val CXResult_Success = define(0)
  val CXResult_Invalid = define(1)
  val CXResult_VisitBreak = define(2)
  inline def getName(inline value: CXResult): Option[String] =
    inline value match
      case CXResult_Success => Some("CXResult_Success")
      case CXResult_Invalid => Some("CXResult_Invalid")
      case CXResult_VisitBreak => Some("CXResult_VisitBreak")
      case _ => _root_.scala.None
  extension (a: CXResult)
    inline def &(b: CXResult): CXResult = a & b
    inline def |(b: CXResult): CXResult = a | b
    inline def is(b: CXResult): Boolean = (a & b) == b

/**
 * Describes the kind of error that occurred (if any) in a call to clang_saveTranslationUnit().

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXSaveError = CUnsignedInt
object CXSaveError extends _BindgenEnumCUnsignedInt[CXSaveError]:
  given _tag: Tag[CXSaveError] = Tag.UInt
  inline def define(inline a: Long): CXSaveError = a.toUInt
  val CXSaveError_None = define(0)
  val CXSaveError_Unknown = define(1)
  val CXSaveError_TranslationErrors = define(2)
  val CXSaveError_InvalidTU = define(3)
  inline def getName(inline value: CXSaveError): Option[String] =
    inline value match
      case CXSaveError_None => Some("CXSaveError_None")
      case CXSaveError_Unknown => Some("CXSaveError_Unknown")
      case CXSaveError_TranslationErrors => Some("CXSaveError_TranslationErrors")
      case CXSaveError_InvalidTU => Some("CXSaveError_InvalidTU")
      case _ => _root_.scala.None
  extension (a: CXSaveError)
    inline def &(b: CXSaveError): CXSaveError = a & b
    inline def |(b: CXSaveError): CXSaveError = a | b
    inline def is(b: CXSaveError): Boolean = (a & b) == b

/**
 * Flags that control how translation units are saved.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXSaveTranslationUnit_Flags = CUnsignedInt
object CXSaveTranslationUnit_Flags extends _BindgenEnumCUnsignedInt[CXSaveTranslationUnit_Flags]:
  given _tag: Tag[CXSaveTranslationUnit_Flags] = Tag.UInt
  inline def define(inline a: Long): CXSaveTranslationUnit_Flags = a.toUInt
  val CXSaveTranslationUnit_None = define(0)
  inline def getName(inline value: CXSaveTranslationUnit_Flags): Option[String] =
    inline value match
      case CXSaveTranslationUnit_None => Some("CXSaveTranslationUnit_None")
      case _ => _root_.scala.None
  extension (a: CXSaveTranslationUnit_Flags)
    inline def &(b: CXSaveTranslationUnit_Flags): CXSaveTranslationUnit_Flags = a & b
    inline def |(b: CXSaveTranslationUnit_Flags): CXSaveTranslationUnit_Flags = a | b
    inline def is(b: CXSaveTranslationUnit_Flags): Boolean = (a & b) == b

/**
 * Roles that are attributed to symbol occurrences.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXSymbolRole = CUnsignedInt
object CXSymbolRole extends _BindgenEnumCUnsignedInt[CXSymbolRole]:
  given _tag: Tag[CXSymbolRole] = Tag.UInt
  inline def define(inline a: Long): CXSymbolRole = a.toUInt
  val CXSymbolRole_None = define(0)
  val CXSymbolRole_Declaration = define(1)
  val CXSymbolRole_Definition = define(2)
  val CXSymbolRole_Reference = define(4)
  val CXSymbolRole_Read = define(8)
  val CXSymbolRole_Write = define(16)
  val CXSymbolRole_Call = define(32)
  val CXSymbolRole_Dynamic = define(64)
  val CXSymbolRole_AddressOf = define(128)
  val CXSymbolRole_Implicit = define(256)
  inline def getName(inline value: CXSymbolRole): Option[String] =
    inline value match
      case CXSymbolRole_None => Some("CXSymbolRole_None")
      case CXSymbolRole_Declaration => Some("CXSymbolRole_Declaration")
      case CXSymbolRole_Definition => Some("CXSymbolRole_Definition")
      case CXSymbolRole_Reference => Some("CXSymbolRole_Reference")
      case CXSymbolRole_Read => Some("CXSymbolRole_Read")
      case CXSymbolRole_Write => Some("CXSymbolRole_Write")
      case CXSymbolRole_Call => Some("CXSymbolRole_Call")
      case CXSymbolRole_Dynamic => Some("CXSymbolRole_Dynamic")
      case CXSymbolRole_AddressOf => Some("CXSymbolRole_AddressOf")
      case CXSymbolRole_Implicit => Some("CXSymbolRole_Implicit")
      case _ => _root_.scala.None
  extension (a: CXSymbolRole)
    inline def &(b: CXSymbolRole): CXSymbolRole = a & b
    inline def |(b: CXSymbolRole): CXSymbolRole = a | b
    inline def is(b: CXSymbolRole): Boolean = (a & b) == b

/**
 * Describe the "thread-local storage (TLS) kind" of the declaration referred to by a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTLSKind = CUnsignedInt
object CXTLSKind extends _BindgenEnumCUnsignedInt[CXTLSKind]:
  given _tag: Tag[CXTLSKind] = Tag.UInt
  inline def define(inline a: Long): CXTLSKind = a.toUInt
  val CXTLS_None = define(0)
  val CXTLS_Dynamic = define(1)
  val CXTLS_Static = define(2)
  inline def getName(inline value: CXTLSKind): Option[String] =
    inline value match
      case CXTLS_None => Some("CXTLS_None")
      case CXTLS_Dynamic => Some("CXTLS_Dynamic")
      case CXTLS_Static => Some("CXTLS_Static")
      case _ => _root_.scala.None
  extension (a: CXTLSKind)
    inline def &(b: CXTLSKind): CXTLSKind = a & b
    inline def |(b: CXTLSKind): CXTLSKind = a | b
    inline def is(b: CXTLSKind): Boolean = (a & b) == b

/**
 * Categorizes how memory is being used by a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTUResourceUsageKind = CUnsignedInt
object CXTUResourceUsageKind extends _BindgenEnumCUnsignedInt[CXTUResourceUsageKind]:
  given _tag: Tag[CXTUResourceUsageKind] = Tag.UInt
  inline def define(inline a: Long): CXTUResourceUsageKind = a.toUInt
  val CXTUResourceUsage_AST = define(1)
  val CXTUResourceUsage_Identifiers = define(2)
  val CXTUResourceUsage_Selectors = define(3)
  val CXTUResourceUsage_GlobalCompletionResults = define(4)
  val CXTUResourceUsage_SourceManagerContentCache = define(5)
  val CXTUResourceUsage_AST_SideTables = define(6)
  val CXTUResourceUsage_SourceManager_Membuffer_Malloc = define(7)
  val CXTUResourceUsage_SourceManager_Membuffer_MMap = define(8)
  val CXTUResourceUsage_ExternalASTSource_Membuffer_Malloc = define(9)
  val CXTUResourceUsage_ExternalASTSource_Membuffer_MMap = define(10)
  val CXTUResourceUsage_Preprocessor = define(11)
  val CXTUResourceUsage_PreprocessingRecord = define(12)
  val CXTUResourceUsage_SourceManager_DataStructures = define(13)
  val CXTUResourceUsage_Preprocessor_HeaderSearch = define(14)
  val CXTUResourceUsage_MEMORY_IN_BYTES_BEGIN = define(1)
  val CXTUResourceUsage_MEMORY_IN_BYTES_END = define(14)
  val CXTUResourceUsage_First = define(1)
  val CXTUResourceUsage_Last = define(14)
  inline def getName(inline value: CXTUResourceUsageKind): Option[String] =
    inline value match
      case CXTUResourceUsage_AST => Some("CXTUResourceUsage_AST")
      case CXTUResourceUsage_Identifiers => Some("CXTUResourceUsage_Identifiers")
      case CXTUResourceUsage_Selectors => Some("CXTUResourceUsage_Selectors")
      case CXTUResourceUsage_GlobalCompletionResults => Some("CXTUResourceUsage_GlobalCompletionResults")
      case CXTUResourceUsage_SourceManagerContentCache => Some("CXTUResourceUsage_SourceManagerContentCache")
      case CXTUResourceUsage_AST_SideTables => Some("CXTUResourceUsage_AST_SideTables")
      case CXTUResourceUsage_SourceManager_Membuffer_Malloc => Some("CXTUResourceUsage_SourceManager_Membuffer_Malloc")
      case CXTUResourceUsage_SourceManager_Membuffer_MMap => Some("CXTUResourceUsage_SourceManager_Membuffer_MMap")
      case CXTUResourceUsage_ExternalASTSource_Membuffer_Malloc => Some("CXTUResourceUsage_ExternalASTSource_Membuffer_Malloc")
      case CXTUResourceUsage_ExternalASTSource_Membuffer_MMap => Some("CXTUResourceUsage_ExternalASTSource_Membuffer_MMap")
      case CXTUResourceUsage_Preprocessor => Some("CXTUResourceUsage_Preprocessor")
      case CXTUResourceUsage_PreprocessingRecord => Some("CXTUResourceUsage_PreprocessingRecord")
      case CXTUResourceUsage_SourceManager_DataStructures => Some("CXTUResourceUsage_SourceManager_DataStructures")
      case CXTUResourceUsage_Preprocessor_HeaderSearch => Some("CXTUResourceUsage_Preprocessor_HeaderSearch")
      case CXTUResourceUsage_MEMORY_IN_BYTES_BEGIN => Some("CXTUResourceUsage_MEMORY_IN_BYTES_BEGIN")
      case CXTUResourceUsage_MEMORY_IN_BYTES_END => Some("CXTUResourceUsage_MEMORY_IN_BYTES_END")
      case CXTUResourceUsage_First => Some("CXTUResourceUsage_First")
      case CXTUResourceUsage_Last => Some("CXTUResourceUsage_Last")
      case _ => _root_.scala.None
  extension (a: CXTUResourceUsageKind)
    inline def &(b: CXTUResourceUsageKind): CXTUResourceUsageKind = a & b
    inline def |(b: CXTUResourceUsageKind): CXTUResourceUsageKind = a | b
    inline def is(b: CXTUResourceUsageKind): Boolean = (a & b) == b

/**
 * Describes the kind of a template argument.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTemplateArgumentKind = CUnsignedInt
object CXTemplateArgumentKind extends _BindgenEnumCUnsignedInt[CXTemplateArgumentKind]:
  given _tag: Tag[CXTemplateArgumentKind] = Tag.UInt
  inline def define(inline a: Long): CXTemplateArgumentKind = a.toUInt
  val CXTemplateArgumentKind_Null = define(0)
  val CXTemplateArgumentKind_Type = define(1)
  val CXTemplateArgumentKind_Declaration = define(2)
  val CXTemplateArgumentKind_NullPtr = define(3)
  val CXTemplateArgumentKind_Integral = define(4)
  val CXTemplateArgumentKind_Template = define(5)
  val CXTemplateArgumentKind_TemplateExpansion = define(6)
  val CXTemplateArgumentKind_Expression = define(7)
  val CXTemplateArgumentKind_Pack = define(8)
  val CXTemplateArgumentKind_Invalid = define(9)
  inline def getName(inline value: CXTemplateArgumentKind): Option[String] =
    inline value match
      case CXTemplateArgumentKind_Null => Some("CXTemplateArgumentKind_Null")
      case CXTemplateArgumentKind_Type => Some("CXTemplateArgumentKind_Type")
      case CXTemplateArgumentKind_Declaration => Some("CXTemplateArgumentKind_Declaration")
      case CXTemplateArgumentKind_NullPtr => Some("CXTemplateArgumentKind_NullPtr")
      case CXTemplateArgumentKind_Integral => Some("CXTemplateArgumentKind_Integral")
      case CXTemplateArgumentKind_Template => Some("CXTemplateArgumentKind_Template")
      case CXTemplateArgumentKind_TemplateExpansion => Some("CXTemplateArgumentKind_TemplateExpansion")
      case CXTemplateArgumentKind_Expression => Some("CXTemplateArgumentKind_Expression")
      case CXTemplateArgumentKind_Pack => Some("CXTemplateArgumentKind_Pack")
      case CXTemplateArgumentKind_Invalid => Some("CXTemplateArgumentKind_Invalid")
      case _ => _root_.scala.None
  extension (a: CXTemplateArgumentKind)
    inline def &(b: CXTemplateArgumentKind): CXTemplateArgumentKind = a & b
    inline def |(b: CXTemplateArgumentKind): CXTemplateArgumentKind = a | b
    inline def is(b: CXTemplateArgumentKind): Boolean = (a & b) == b

/**
 * Describes a kind of token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTokenKind = CUnsignedInt
object CXTokenKind extends _BindgenEnumCUnsignedInt[CXTokenKind]:
  given _tag: Tag[CXTokenKind] = Tag.UInt
  inline def define(inline a: Long): CXTokenKind = a.toUInt
  val CXToken_Punctuation = define(0)
  val CXToken_Keyword = define(1)
  val CXToken_Identifier = define(2)
  val CXToken_Literal = define(3)
  val CXToken_Comment = define(4)
  inline def getName(inline value: CXTokenKind): Option[String] =
    inline value match
      case CXToken_Punctuation => Some("CXToken_Punctuation")
      case CXToken_Keyword => Some("CXToken_Keyword")
      case CXToken_Identifier => Some("CXToken_Identifier")
      case CXToken_Literal => Some("CXToken_Literal")
      case CXToken_Comment => Some("CXToken_Comment")
      case _ => _root_.scala.None
  extension (a: CXTokenKind)
    inline def &(b: CXTokenKind): CXTokenKind = a & b
    inline def |(b: CXTokenKind): CXTokenKind = a | b
    inline def is(b: CXTokenKind): Boolean = (a & b) == b

/**
 * Flags that control the creation of translation units.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTranslationUnit_Flags = CUnsignedInt
object CXTranslationUnit_Flags extends _BindgenEnumCUnsignedInt[CXTranslationUnit_Flags]:
  given _tag: Tag[CXTranslationUnit_Flags] = Tag.UInt
  inline def define(inline a: Long): CXTranslationUnit_Flags = a.toUInt
  val CXTranslationUnit_None = define(0)
  val CXTranslationUnit_DetailedPreprocessingRecord = define(1)
  val CXTranslationUnit_Incomplete = define(2)
  val CXTranslationUnit_PrecompiledPreamble = define(4)
  val CXTranslationUnit_CacheCompletionResults = define(8)
  val CXTranslationUnit_ForSerialization = define(16)
  val CXTranslationUnit_CXXChainedPCH = define(32)
  val CXTranslationUnit_SkipFunctionBodies = define(64)
  val CXTranslationUnit_IncludeBriefCommentsInCodeCompletion = define(128)
  val CXTranslationUnit_CreatePreambleOnFirstParse = define(256)
  val CXTranslationUnit_KeepGoing = define(512)
  val CXTranslationUnit_SingleFileParse = define(1024)
  val CXTranslationUnit_LimitSkipFunctionBodiesToPreamble = define(2048)
  val CXTranslationUnit_IncludeAttributedTypes = define(4096)
  val CXTranslationUnit_VisitImplicitAttributes = define(8192)
  val CXTranslationUnit_IgnoreNonErrorsFromIncludedFiles = define(16384)
  val CXTranslationUnit_RetainExcludedConditionalBlocks = define(32768)
  inline def getName(inline value: CXTranslationUnit_Flags): Option[String] =
    inline value match
      case CXTranslationUnit_None => Some("CXTranslationUnit_None")
      case CXTranslationUnit_DetailedPreprocessingRecord => Some("CXTranslationUnit_DetailedPreprocessingRecord")
      case CXTranslationUnit_Incomplete => Some("CXTranslationUnit_Incomplete")
      case CXTranslationUnit_PrecompiledPreamble => Some("CXTranslationUnit_PrecompiledPreamble")
      case CXTranslationUnit_CacheCompletionResults => Some("CXTranslationUnit_CacheCompletionResults")
      case CXTranslationUnit_ForSerialization => Some("CXTranslationUnit_ForSerialization")
      case CXTranslationUnit_CXXChainedPCH => Some("CXTranslationUnit_CXXChainedPCH")
      case CXTranslationUnit_SkipFunctionBodies => Some("CXTranslationUnit_SkipFunctionBodies")
      case CXTranslationUnit_IncludeBriefCommentsInCodeCompletion => Some("CXTranslationUnit_IncludeBriefCommentsInCodeCompletion")
      case CXTranslationUnit_CreatePreambleOnFirstParse => Some("CXTranslationUnit_CreatePreambleOnFirstParse")
      case CXTranslationUnit_KeepGoing => Some("CXTranslationUnit_KeepGoing")
      case CXTranslationUnit_SingleFileParse => Some("CXTranslationUnit_SingleFileParse")
      case CXTranslationUnit_LimitSkipFunctionBodiesToPreamble => Some("CXTranslationUnit_LimitSkipFunctionBodiesToPreamble")
      case CXTranslationUnit_IncludeAttributedTypes => Some("CXTranslationUnit_IncludeAttributedTypes")
      case CXTranslationUnit_VisitImplicitAttributes => Some("CXTranslationUnit_VisitImplicitAttributes")
      case CXTranslationUnit_IgnoreNonErrorsFromIncludedFiles => Some("CXTranslationUnit_IgnoreNonErrorsFromIncludedFiles")
      case CXTranslationUnit_RetainExcludedConditionalBlocks => Some("CXTranslationUnit_RetainExcludedConditionalBlocks")
      case _ => _root_.scala.None
  extension (a: CXTranslationUnit_Flags)
    inline def &(b: CXTranslationUnit_Flags): CXTranslationUnit_Flags = a & b
    inline def |(b: CXTranslationUnit_Flags): CXTranslationUnit_Flags = a | b
    inline def is(b: CXTranslationUnit_Flags): Boolean = (a & b) == b

/**
 * Describes the kind of type

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTypeKind = CUnsignedInt
object CXTypeKind extends _BindgenEnumCUnsignedInt[CXTypeKind]:
  given _tag: Tag[CXTypeKind] = Tag.UInt
  inline def define(inline a: Long): CXTypeKind = a.toUInt
  val CXType_Invalid = define(0)
  val CXType_Unexposed = define(1)
  val CXType_Void = define(2)
  val CXType_Bool = define(3)
  val CXType_Char_U = define(4)
  val CXType_UChar = define(5)
  val CXType_Char16 = define(6)
  val CXType_Char32 = define(7)
  val CXType_UShort = define(8)
  val CXType_UInt = define(9)
  val CXType_ULong = define(10)
  val CXType_ULongLong = define(11)
  val CXType_UInt128 = define(12)
  val CXType_Char_S = define(13)
  val CXType_SChar = define(14)
  val CXType_WChar = define(15)
  val CXType_Short = define(16)
  val CXType_Int = define(17)
  val CXType_Long = define(18)
  val CXType_LongLong = define(19)
  val CXType_Int128 = define(20)
  val CXType_Float = define(21)
  val CXType_Double = define(22)
  val CXType_LongDouble = define(23)
  val CXType_NullPtr = define(24)
  val CXType_Overload = define(25)
  val CXType_Dependent = define(26)
  val CXType_ObjCId = define(27)
  val CXType_ObjCClass = define(28)
  val CXType_ObjCSel = define(29)
  val CXType_Float128 = define(30)
  val CXType_Half = define(31)
  val CXType_Float16 = define(32)
  val CXType_ShortAccum = define(33)
  val CXType_Accum = define(34)
  val CXType_LongAccum = define(35)
  val CXType_UShortAccum = define(36)
  val CXType_UAccum = define(37)
  val CXType_ULongAccum = define(38)
  val CXType_BFloat16 = define(39)
  val CXType_Ibm128 = define(40)
  val CXType_FirstBuiltin = define(2)
  val CXType_LastBuiltin = define(40)
  val CXType_Complex = define(100)
  val CXType_Pointer = define(101)
  val CXType_BlockPointer = define(102)
  val CXType_LValueReference = define(103)
  val CXType_RValueReference = define(104)
  val CXType_Record = define(105)
  val CXType_Enum = define(106)
  val CXType_Typedef = define(107)
  val CXType_ObjCInterface = define(108)
  val CXType_ObjCObjectPointer = define(109)
  val CXType_FunctionNoProto = define(110)
  val CXType_FunctionProto = define(111)
  val CXType_ConstantArray = define(112)
  val CXType_Vector = define(113)
  val CXType_IncompleteArray = define(114)
  val CXType_VariableArray = define(115)
  val CXType_DependentSizedArray = define(116)
  val CXType_MemberPointer = define(117)
  val CXType_Auto = define(118)
  val CXType_Elaborated = define(119)
  val CXType_Pipe = define(120)
  val CXType_OCLImage1dRO = define(121)
  val CXType_OCLImage1dArrayRO = define(122)
  val CXType_OCLImage1dBufferRO = define(123)
  val CXType_OCLImage2dRO = define(124)
  val CXType_OCLImage2dArrayRO = define(125)
  val CXType_OCLImage2dDepthRO = define(126)
  val CXType_OCLImage2dArrayDepthRO = define(127)
  val CXType_OCLImage2dMSAARO = define(128)
  val CXType_OCLImage2dArrayMSAARO = define(129)
  val CXType_OCLImage2dMSAADepthRO = define(130)
  val CXType_OCLImage2dArrayMSAADepthRO = define(131)
  val CXType_OCLImage3dRO = define(132)
  val CXType_OCLImage1dWO = define(133)
  val CXType_OCLImage1dArrayWO = define(134)
  val CXType_OCLImage1dBufferWO = define(135)
  val CXType_OCLImage2dWO = define(136)
  val CXType_OCLImage2dArrayWO = define(137)
  val CXType_OCLImage2dDepthWO = define(138)
  val CXType_OCLImage2dArrayDepthWO = define(139)
  val CXType_OCLImage2dMSAAWO = define(140)
  val CXType_OCLImage2dArrayMSAAWO = define(141)
  val CXType_OCLImage2dMSAADepthWO = define(142)
  val CXType_OCLImage2dArrayMSAADepthWO = define(143)
  val CXType_OCLImage3dWO = define(144)
  val CXType_OCLImage1dRW = define(145)
  val CXType_OCLImage1dArrayRW = define(146)
  val CXType_OCLImage1dBufferRW = define(147)
  val CXType_OCLImage2dRW = define(148)
  val CXType_OCLImage2dArrayRW = define(149)
  val CXType_OCLImage2dDepthRW = define(150)
  val CXType_OCLImage2dArrayDepthRW = define(151)
  val CXType_OCLImage2dMSAARW = define(152)
  val CXType_OCLImage2dArrayMSAARW = define(153)
  val CXType_OCLImage2dMSAADepthRW = define(154)
  val CXType_OCLImage2dArrayMSAADepthRW = define(155)
  val CXType_OCLImage3dRW = define(156)
  val CXType_OCLSampler = define(157)
  val CXType_OCLEvent = define(158)
  val CXType_OCLQueue = define(159)
  val CXType_OCLReserveID = define(160)
  val CXType_ObjCObject = define(161)
  val CXType_ObjCTypeParam = define(162)
  val CXType_Attributed = define(163)
  val CXType_OCLIntelSubgroupAVCMcePayload = define(164)
  val CXType_OCLIntelSubgroupAVCImePayload = define(165)
  val CXType_OCLIntelSubgroupAVCRefPayload = define(166)
  val CXType_OCLIntelSubgroupAVCSicPayload = define(167)
  val CXType_OCLIntelSubgroupAVCMceResult = define(168)
  val CXType_OCLIntelSubgroupAVCImeResult = define(169)
  val CXType_OCLIntelSubgroupAVCRefResult = define(170)
  val CXType_OCLIntelSubgroupAVCSicResult = define(171)
  val CXType_OCLIntelSubgroupAVCImeResultSingleReferenceStreamout = define(172)
  val CXType_OCLIntelSubgroupAVCImeResultDualReferenceStreamout = define(173)
  val CXType_OCLIntelSubgroupAVCImeSingleReferenceStreamin = define(174)
  val CXType_OCLIntelSubgroupAVCImeDualReferenceStreamin = define(175)
  val CXType_OCLIntelSubgroupAVCImeResultSingleRefStreamout = define(172)
  val CXType_OCLIntelSubgroupAVCImeResultDualRefStreamout = define(173)
  val CXType_OCLIntelSubgroupAVCImeSingleRefStreamin = define(174)
  val CXType_OCLIntelSubgroupAVCImeDualRefStreamin = define(175)
  val CXType_ExtVector = define(176)
  val CXType_Atomic = define(177)
  val CXType_BTFTagAttributed = define(178)
  inline def getName(inline value: CXTypeKind): Option[String] =
    inline value match
      case CXType_Invalid => Some("CXType_Invalid")
      case CXType_Unexposed => Some("CXType_Unexposed")
      case CXType_Void => Some("CXType_Void")
      case CXType_Bool => Some("CXType_Bool")
      case CXType_Char_U => Some("CXType_Char_U")
      case CXType_UChar => Some("CXType_UChar")
      case CXType_Char16 => Some("CXType_Char16")
      case CXType_Char32 => Some("CXType_Char32")
      case CXType_UShort => Some("CXType_UShort")
      case CXType_UInt => Some("CXType_UInt")
      case CXType_ULong => Some("CXType_ULong")
      case CXType_ULongLong => Some("CXType_ULongLong")
      case CXType_UInt128 => Some("CXType_UInt128")
      case CXType_Char_S => Some("CXType_Char_S")
      case CXType_SChar => Some("CXType_SChar")
      case CXType_WChar => Some("CXType_WChar")
      case CXType_Short => Some("CXType_Short")
      case CXType_Int => Some("CXType_Int")
      case CXType_Long => Some("CXType_Long")
      case CXType_LongLong => Some("CXType_LongLong")
      case CXType_Int128 => Some("CXType_Int128")
      case CXType_Float => Some("CXType_Float")
      case CXType_Double => Some("CXType_Double")
      case CXType_LongDouble => Some("CXType_LongDouble")
      case CXType_NullPtr => Some("CXType_NullPtr")
      case CXType_Overload => Some("CXType_Overload")
      case CXType_Dependent => Some("CXType_Dependent")
      case CXType_ObjCId => Some("CXType_ObjCId")
      case CXType_ObjCClass => Some("CXType_ObjCClass")
      case CXType_ObjCSel => Some("CXType_ObjCSel")
      case CXType_Float128 => Some("CXType_Float128")
      case CXType_Half => Some("CXType_Half")
      case CXType_Float16 => Some("CXType_Float16")
      case CXType_ShortAccum => Some("CXType_ShortAccum")
      case CXType_Accum => Some("CXType_Accum")
      case CXType_LongAccum => Some("CXType_LongAccum")
      case CXType_UShortAccum => Some("CXType_UShortAccum")
      case CXType_UAccum => Some("CXType_UAccum")
      case CXType_ULongAccum => Some("CXType_ULongAccum")
      case CXType_BFloat16 => Some("CXType_BFloat16")
      case CXType_Ibm128 => Some("CXType_Ibm128")
      case CXType_FirstBuiltin => Some("CXType_FirstBuiltin")
      case CXType_LastBuiltin => Some("CXType_LastBuiltin")
      case CXType_Complex => Some("CXType_Complex")
      case CXType_Pointer => Some("CXType_Pointer")
      case CXType_BlockPointer => Some("CXType_BlockPointer")
      case CXType_LValueReference => Some("CXType_LValueReference")
      case CXType_RValueReference => Some("CXType_RValueReference")
      case CXType_Record => Some("CXType_Record")
      case CXType_Enum => Some("CXType_Enum")
      case CXType_Typedef => Some("CXType_Typedef")
      case CXType_ObjCInterface => Some("CXType_ObjCInterface")
      case CXType_ObjCObjectPointer => Some("CXType_ObjCObjectPointer")
      case CXType_FunctionNoProto => Some("CXType_FunctionNoProto")
      case CXType_FunctionProto => Some("CXType_FunctionProto")
      case CXType_ConstantArray => Some("CXType_ConstantArray")
      case CXType_Vector => Some("CXType_Vector")
      case CXType_IncompleteArray => Some("CXType_IncompleteArray")
      case CXType_VariableArray => Some("CXType_VariableArray")
      case CXType_DependentSizedArray => Some("CXType_DependentSizedArray")
      case CXType_MemberPointer => Some("CXType_MemberPointer")
      case CXType_Auto => Some("CXType_Auto")
      case CXType_Elaborated => Some("CXType_Elaborated")
      case CXType_Pipe => Some("CXType_Pipe")
      case CXType_OCLImage1dRO => Some("CXType_OCLImage1dRO")
      case CXType_OCLImage1dArrayRO => Some("CXType_OCLImage1dArrayRO")
      case CXType_OCLImage1dBufferRO => Some("CXType_OCLImage1dBufferRO")
      case CXType_OCLImage2dRO => Some("CXType_OCLImage2dRO")
      case CXType_OCLImage2dArrayRO => Some("CXType_OCLImage2dArrayRO")
      case CXType_OCLImage2dDepthRO => Some("CXType_OCLImage2dDepthRO")
      case CXType_OCLImage2dArrayDepthRO => Some("CXType_OCLImage2dArrayDepthRO")
      case CXType_OCLImage2dMSAARO => Some("CXType_OCLImage2dMSAARO")
      case CXType_OCLImage2dArrayMSAARO => Some("CXType_OCLImage2dArrayMSAARO")
      case CXType_OCLImage2dMSAADepthRO => Some("CXType_OCLImage2dMSAADepthRO")
      case CXType_OCLImage2dArrayMSAADepthRO => Some("CXType_OCLImage2dArrayMSAADepthRO")
      case CXType_OCLImage3dRO => Some("CXType_OCLImage3dRO")
      case CXType_OCLImage1dWO => Some("CXType_OCLImage1dWO")
      case CXType_OCLImage1dArrayWO => Some("CXType_OCLImage1dArrayWO")
      case CXType_OCLImage1dBufferWO => Some("CXType_OCLImage1dBufferWO")
      case CXType_OCLImage2dWO => Some("CXType_OCLImage2dWO")
      case CXType_OCLImage2dArrayWO => Some("CXType_OCLImage2dArrayWO")
      case CXType_OCLImage2dDepthWO => Some("CXType_OCLImage2dDepthWO")
      case CXType_OCLImage2dArrayDepthWO => Some("CXType_OCLImage2dArrayDepthWO")
      case CXType_OCLImage2dMSAAWO => Some("CXType_OCLImage2dMSAAWO")
      case CXType_OCLImage2dArrayMSAAWO => Some("CXType_OCLImage2dArrayMSAAWO")
      case CXType_OCLImage2dMSAADepthWO => Some("CXType_OCLImage2dMSAADepthWO")
      case CXType_OCLImage2dArrayMSAADepthWO => Some("CXType_OCLImage2dArrayMSAADepthWO")
      case CXType_OCLImage3dWO => Some("CXType_OCLImage3dWO")
      case CXType_OCLImage1dRW => Some("CXType_OCLImage1dRW")
      case CXType_OCLImage1dArrayRW => Some("CXType_OCLImage1dArrayRW")
      case CXType_OCLImage1dBufferRW => Some("CXType_OCLImage1dBufferRW")
      case CXType_OCLImage2dRW => Some("CXType_OCLImage2dRW")
      case CXType_OCLImage2dArrayRW => Some("CXType_OCLImage2dArrayRW")
      case CXType_OCLImage2dDepthRW => Some("CXType_OCLImage2dDepthRW")
      case CXType_OCLImage2dArrayDepthRW => Some("CXType_OCLImage2dArrayDepthRW")
      case CXType_OCLImage2dMSAARW => Some("CXType_OCLImage2dMSAARW")
      case CXType_OCLImage2dArrayMSAARW => Some("CXType_OCLImage2dArrayMSAARW")
      case CXType_OCLImage2dMSAADepthRW => Some("CXType_OCLImage2dMSAADepthRW")
      case CXType_OCLImage2dArrayMSAADepthRW => Some("CXType_OCLImage2dArrayMSAADepthRW")
      case CXType_OCLImage3dRW => Some("CXType_OCLImage3dRW")
      case CXType_OCLSampler => Some("CXType_OCLSampler")
      case CXType_OCLEvent => Some("CXType_OCLEvent")
      case CXType_OCLQueue => Some("CXType_OCLQueue")
      case CXType_OCLReserveID => Some("CXType_OCLReserveID")
      case CXType_ObjCObject => Some("CXType_ObjCObject")
      case CXType_ObjCTypeParam => Some("CXType_ObjCTypeParam")
      case CXType_Attributed => Some("CXType_Attributed")
      case CXType_OCLIntelSubgroupAVCMcePayload => Some("CXType_OCLIntelSubgroupAVCMcePayload")
      case CXType_OCLIntelSubgroupAVCImePayload => Some("CXType_OCLIntelSubgroupAVCImePayload")
      case CXType_OCLIntelSubgroupAVCRefPayload => Some("CXType_OCLIntelSubgroupAVCRefPayload")
      case CXType_OCLIntelSubgroupAVCSicPayload => Some("CXType_OCLIntelSubgroupAVCSicPayload")
      case CXType_OCLIntelSubgroupAVCMceResult => Some("CXType_OCLIntelSubgroupAVCMceResult")
      case CXType_OCLIntelSubgroupAVCImeResult => Some("CXType_OCLIntelSubgroupAVCImeResult")
      case CXType_OCLIntelSubgroupAVCRefResult => Some("CXType_OCLIntelSubgroupAVCRefResult")
      case CXType_OCLIntelSubgroupAVCSicResult => Some("CXType_OCLIntelSubgroupAVCSicResult")
      case CXType_OCLIntelSubgroupAVCImeResultSingleReferenceStreamout => Some("CXType_OCLIntelSubgroupAVCImeResultSingleReferenceStreamout")
      case CXType_OCLIntelSubgroupAVCImeResultDualReferenceStreamout => Some("CXType_OCLIntelSubgroupAVCImeResultDualReferenceStreamout")
      case CXType_OCLIntelSubgroupAVCImeSingleReferenceStreamin => Some("CXType_OCLIntelSubgroupAVCImeSingleReferenceStreamin")
      case CXType_OCLIntelSubgroupAVCImeDualReferenceStreamin => Some("CXType_OCLIntelSubgroupAVCImeDualReferenceStreamin")
      case CXType_OCLIntelSubgroupAVCImeResultSingleRefStreamout => Some("CXType_OCLIntelSubgroupAVCImeResultSingleRefStreamout")
      case CXType_OCLIntelSubgroupAVCImeResultDualRefStreamout => Some("CXType_OCLIntelSubgroupAVCImeResultDualRefStreamout")
      case CXType_OCLIntelSubgroupAVCImeSingleRefStreamin => Some("CXType_OCLIntelSubgroupAVCImeSingleRefStreamin")
      case CXType_OCLIntelSubgroupAVCImeDualRefStreamin => Some("CXType_OCLIntelSubgroupAVCImeDualRefStreamin")
      case CXType_ExtVector => Some("CXType_ExtVector")
      case CXType_Atomic => Some("CXType_Atomic")
      case CXType_BTFTagAttributed => Some("CXType_BTFTagAttributed")
      case _ => _root_.scala.None
  extension (a: CXTypeKind)
    inline def &(b: CXTypeKind): CXTypeKind = a & b
    inline def |(b: CXTypeKind): CXTypeKind = a | b
    inline def is(b: CXTypeKind): Boolean = (a & b) == b

/**
 * List the possible error codes for clang_Type_getSizeOf, clang_Type_getAlignOf, clang_Type_getOffsetOf and clang_Cursor_getOffsetOf.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTypeLayoutError = CInt
object CXTypeLayoutError extends _BindgenEnumCInt[CXTypeLayoutError]:
  given _tag: Tag[CXTypeLayoutError] = Tag.Int
  inline def define(inline a: CInt): CXTypeLayoutError = a
  val CXTypeLayoutError_Invalid = define(-1)
  val CXTypeLayoutError_Incomplete = define(-2)
  val CXTypeLayoutError_Dependent = define(-3)
  val CXTypeLayoutError_NotConstantSize = define(-4)
  val CXTypeLayoutError_InvalidFieldName = define(-5)
  val CXTypeLayoutError_Undeduced = define(-6)
  inline def getName(inline value: CXTypeLayoutError): Option[String] =
    inline value match
      case CXTypeLayoutError_Invalid => Some("CXTypeLayoutError_Invalid")
      case CXTypeLayoutError_Incomplete => Some("CXTypeLayoutError_Incomplete")
      case CXTypeLayoutError_Dependent => Some("CXTypeLayoutError_Dependent")
      case CXTypeLayoutError_NotConstantSize => Some("CXTypeLayoutError_NotConstantSize")
      case CXTypeLayoutError_InvalidFieldName => Some("CXTypeLayoutError_InvalidFieldName")
      case CXTypeLayoutError_Undeduced => Some("CXTypeLayoutError_Undeduced")
      case _ => _root_.scala.None
  extension (a: CXTypeLayoutError)
    inline def &(b: CXTypeLayoutError): CXTypeLayoutError = a & b
    inline def |(b: CXTypeLayoutError): CXTypeLayoutError = a | b
    inline def is(b: CXTypeLayoutError): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTypeNullabilityKind = CUnsignedInt
object CXTypeNullabilityKind extends _BindgenEnumCUnsignedInt[CXTypeNullabilityKind]:
  given _tag: Tag[CXTypeNullabilityKind] = Tag.UInt
  inline def define(inline a: Long): CXTypeNullabilityKind = a.toUInt
  val CXTypeNullability_NonNull = define(0)
  val CXTypeNullability_Nullable = define(1)
  val CXTypeNullability_Unspecified = define(2)
  val CXTypeNullability_Invalid = define(3)
  val CXTypeNullability_NullableResult = define(4)
  inline def getName(inline value: CXTypeNullabilityKind): Option[String] =
    inline value match
      case CXTypeNullability_NonNull => Some("CXTypeNullability_NonNull")
      case CXTypeNullability_Nullable => Some("CXTypeNullability_Nullable")
      case CXTypeNullability_Unspecified => Some("CXTypeNullability_Unspecified")
      case CXTypeNullability_Invalid => Some("CXTypeNullability_Invalid")
      case CXTypeNullability_NullableResult => Some("CXTypeNullability_NullableResult")
      case _ => _root_.scala.None
  extension (a: CXTypeNullabilityKind)
    inline def &(b: CXTypeNullabilityKind): CXTypeNullabilityKind = a & b
    inline def |(b: CXTypeNullabilityKind): CXTypeNullabilityKind = a | b
    inline def is(b: CXTypeNullabilityKind): Boolean = (a & b) == b

/**
 * Describes the kind of unary operators.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXUnaryOperatorKind = CUnsignedInt
object CXUnaryOperatorKind extends _BindgenEnumCUnsignedInt[CXUnaryOperatorKind]:
  given _tag: Tag[CXUnaryOperatorKind] = Tag.UInt
  inline def define(inline a: Long): CXUnaryOperatorKind = a.toUInt
  val CXUnaryOperator_Invalid = define(0)
  val CXUnaryOperator_PostInc = define(1)
  val CXUnaryOperator_PostDec = define(2)
  val CXUnaryOperator_PreInc = define(3)
  val CXUnaryOperator_PreDec = define(4)
  val CXUnaryOperator_AddrOf = define(5)
  val CXUnaryOperator_Deref = define(6)
  val CXUnaryOperator_Plus = define(7)
  val CXUnaryOperator_Minus = define(8)
  val CXUnaryOperator_Not = define(9)
  val CXUnaryOperator_LNot = define(10)
  val CXUnaryOperator_Real = define(11)
  val CXUnaryOperator_Imag = define(12)
  val CXUnaryOperator_Extension = define(13)
  val CXUnaryOperator_Coawait = define(14)
  inline def getName(inline value: CXUnaryOperatorKind): Option[String] =
    inline value match
      case CXUnaryOperator_Invalid => Some("CXUnaryOperator_Invalid")
      case CXUnaryOperator_PostInc => Some("CXUnaryOperator_PostInc")
      case CXUnaryOperator_PostDec => Some("CXUnaryOperator_PostDec")
      case CXUnaryOperator_PreInc => Some("CXUnaryOperator_PreInc")
      case CXUnaryOperator_PreDec => Some("CXUnaryOperator_PreDec")
      case CXUnaryOperator_AddrOf => Some("CXUnaryOperator_AddrOf")
      case CXUnaryOperator_Deref => Some("CXUnaryOperator_Deref")
      case CXUnaryOperator_Plus => Some("CXUnaryOperator_Plus")
      case CXUnaryOperator_Minus => Some("CXUnaryOperator_Minus")
      case CXUnaryOperator_Not => Some("CXUnaryOperator_Not")
      case CXUnaryOperator_LNot => Some("CXUnaryOperator_LNot")
      case CXUnaryOperator_Real => Some("CXUnaryOperator_Real")
      case CXUnaryOperator_Imag => Some("CXUnaryOperator_Imag")
      case CXUnaryOperator_Extension => Some("CXUnaryOperator_Extension")
      case CXUnaryOperator_Coawait => Some("CXUnaryOperator_Coawait")
      case _ => _root_.scala.None
  extension (a: CXUnaryOperatorKind)
    inline def &(b: CXUnaryOperatorKind): CXUnaryOperatorKind = a & b
    inline def |(b: CXUnaryOperatorKind): CXUnaryOperatorKind = a | b
    inline def is(b: CXUnaryOperatorKind): Boolean = (a & b) == b

/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXVisibilityKind = CUnsignedInt
object CXVisibilityKind extends _BindgenEnumCUnsignedInt[CXVisibilityKind]:
  given _tag: Tag[CXVisibilityKind] = Tag.UInt
  inline def define(inline a: Long): CXVisibilityKind = a.toUInt
  val CXVisibility_Invalid = define(0)
  val CXVisibility_Hidden = define(1)
  val CXVisibility_Protected = define(2)
  val CXVisibility_Default = define(3)
  inline def getName(inline value: CXVisibilityKind): Option[String] =
    inline value match
      case CXVisibility_Invalid => Some("CXVisibility_Invalid")
      case CXVisibility_Hidden => Some("CXVisibility_Hidden")
      case CXVisibility_Protected => Some("CXVisibility_Protected")
      case CXVisibility_Default => Some("CXVisibility_Default")
      case _ => _root_.scala.None
  extension (a: CXVisibilityKind)
    inline def &(b: CXVisibilityKind): CXVisibilityKind = a & b
    inline def |(b: CXVisibilityKind): CXVisibilityKind = a | b
    inline def is(b: CXVisibilityKind): Boolean = (a & b) == b

/**
 * @{

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXVisitorResult = CUnsignedInt
object CXVisitorResult extends _BindgenEnumCUnsignedInt[CXVisitorResult]:
  given _tag: Tag[CXVisitorResult] = Tag.UInt
  inline def define(inline a: Long): CXVisitorResult = a.toUInt
  val CXVisit_Break = define(0)
  val CXVisit_Continue = define(1)
  inline def getName(inline value: CXVisitorResult): Option[String] =
    inline value match
      case CXVisit_Break => Some("CXVisit_Break")
      case CXVisit_Continue => Some("CXVisit_Continue")
      case _ => _root_.scala.None
  extension (a: CXVisitorResult)
    inline def &(b: CXVisitorResult): CXVisitorResult = a & b
    inline def |(b: CXVisitorResult): CXVisitorResult = a | b
    inline def is(b: CXVisitorResult): Boolean = (a & b) == b

/**
 * Represents a specific kind of binary operator which can appear at a cursor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CX_BinaryOperatorKind = CUnsignedInt
object CX_BinaryOperatorKind extends _BindgenEnumCUnsignedInt[CX_BinaryOperatorKind]:
  given _tag: Tag[CX_BinaryOperatorKind] = Tag.UInt
  inline def define(inline a: Long): CX_BinaryOperatorKind = a.toUInt
  val CX_BO_Invalid = define(0)
  val CX_BO_PtrMemD = define(1)
  val CX_BO_PtrMemI = define(2)
  val CX_BO_Mul = define(3)
  val CX_BO_Div = define(4)
  val CX_BO_Rem = define(5)
  val CX_BO_Add = define(6)
  val CX_BO_Sub = define(7)
  val CX_BO_Shl = define(8)
  val CX_BO_Shr = define(9)
  val CX_BO_Cmp = define(10)
  val CX_BO_LT = define(11)
  val CX_BO_GT = define(12)
  val CX_BO_LE = define(13)
  val CX_BO_GE = define(14)
  val CX_BO_EQ = define(15)
  val CX_BO_NE = define(16)
  val CX_BO_And = define(17)
  val CX_BO_Xor = define(18)
  val CX_BO_Or = define(19)
  val CX_BO_LAnd = define(20)
  val CX_BO_LOr = define(21)
  val CX_BO_Assign = define(22)
  val CX_BO_MulAssign = define(23)
  val CX_BO_DivAssign = define(24)
  val CX_BO_RemAssign = define(25)
  val CX_BO_AddAssign = define(26)
  val CX_BO_SubAssign = define(27)
  val CX_BO_ShlAssign = define(28)
  val CX_BO_ShrAssign = define(29)
  val CX_BO_AndAssign = define(30)
  val CX_BO_XorAssign = define(31)
  val CX_BO_OrAssign = define(32)
  val CX_BO_Comma = define(33)
  val CX_BO_LAST = define(33)
  inline def getName(inline value: CX_BinaryOperatorKind): Option[String] =
    inline value match
      case CX_BO_Invalid => Some("CX_BO_Invalid")
      case CX_BO_PtrMemD => Some("CX_BO_PtrMemD")
      case CX_BO_PtrMemI => Some("CX_BO_PtrMemI")
      case CX_BO_Mul => Some("CX_BO_Mul")
      case CX_BO_Div => Some("CX_BO_Div")
      case CX_BO_Rem => Some("CX_BO_Rem")
      case CX_BO_Add => Some("CX_BO_Add")
      case CX_BO_Sub => Some("CX_BO_Sub")
      case CX_BO_Shl => Some("CX_BO_Shl")
      case CX_BO_Shr => Some("CX_BO_Shr")
      case CX_BO_Cmp => Some("CX_BO_Cmp")
      case CX_BO_LT => Some("CX_BO_LT")
      case CX_BO_GT => Some("CX_BO_GT")
      case CX_BO_LE => Some("CX_BO_LE")
      case CX_BO_GE => Some("CX_BO_GE")
      case CX_BO_EQ => Some("CX_BO_EQ")
      case CX_BO_NE => Some("CX_BO_NE")
      case CX_BO_And => Some("CX_BO_And")
      case CX_BO_Xor => Some("CX_BO_Xor")
      case CX_BO_Or => Some("CX_BO_Or")
      case CX_BO_LAnd => Some("CX_BO_LAnd")
      case CX_BO_LOr => Some("CX_BO_LOr")
      case CX_BO_Assign => Some("CX_BO_Assign")
      case CX_BO_MulAssign => Some("CX_BO_MulAssign")
      case CX_BO_DivAssign => Some("CX_BO_DivAssign")
      case CX_BO_RemAssign => Some("CX_BO_RemAssign")
      case CX_BO_AddAssign => Some("CX_BO_AddAssign")
      case CX_BO_SubAssign => Some("CX_BO_SubAssign")
      case CX_BO_ShlAssign => Some("CX_BO_ShlAssign")
      case CX_BO_ShrAssign => Some("CX_BO_ShrAssign")
      case CX_BO_AndAssign => Some("CX_BO_AndAssign")
      case CX_BO_XorAssign => Some("CX_BO_XorAssign")
      case CX_BO_OrAssign => Some("CX_BO_OrAssign")
      case CX_BO_Comma => Some("CX_BO_Comma")
      case CX_BO_LAST => Some("CX_BO_LAST")
      case _ => _root_.scala.None
  extension (a: CX_BinaryOperatorKind)
    inline def &(b: CX_BinaryOperatorKind): CX_BinaryOperatorKind = a & b
    inline def |(b: CX_BinaryOperatorKind): CX_BinaryOperatorKind = a | b
    inline def is(b: CX_BinaryOperatorKind): Boolean = (a & b) == b

/**
 * Represents the C++ access control level to a base class for a cursor with kind CX_CXXBaseSpecifier.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CX_CXXAccessSpecifier = CUnsignedInt
object CX_CXXAccessSpecifier extends _BindgenEnumCUnsignedInt[CX_CXXAccessSpecifier]:
  given _tag: Tag[CX_CXXAccessSpecifier] = Tag.UInt
  inline def define(inline a: Long): CX_CXXAccessSpecifier = a.toUInt
  val CX_CXXInvalidAccessSpecifier = define(0)
  val CX_CXXPublic = define(1)
  val CX_CXXProtected = define(2)
  val CX_CXXPrivate = define(3)
  inline def getName(inline value: CX_CXXAccessSpecifier): Option[String] =
    inline value match
      case CX_CXXInvalidAccessSpecifier => Some("CX_CXXInvalidAccessSpecifier")
      case CX_CXXPublic => Some("CX_CXXPublic")
      case CX_CXXProtected => Some("CX_CXXProtected")
      case CX_CXXPrivate => Some("CX_CXXPrivate")
      case _ => _root_.scala.None
  extension (a: CX_CXXAccessSpecifier)
    inline def &(b: CX_CXXAccessSpecifier): CX_CXXAccessSpecifier = a & b
    inline def |(b: CX_CXXAccessSpecifier): CX_CXXAccessSpecifier = a | b
    inline def is(b: CX_CXXAccessSpecifier): Boolean = (a & b) == b

/**
 * Represents the storage classes as declared in the source. CX_SC_Invalid was added for the case that the passed cursor in not a declaration.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CX_StorageClass = CUnsignedInt
object CX_StorageClass extends _BindgenEnumCUnsignedInt[CX_StorageClass]:
  given _tag: Tag[CX_StorageClass] = Tag.UInt
  inline def define(inline a: Long): CX_StorageClass = a.toUInt
  val CX_SC_Invalid = define(0)
  val CX_SC_None = define(1)
  val CX_SC_Extern = define(2)
  val CX_SC_Static = define(3)
  val CX_SC_PrivateExtern = define(4)
  val CX_SC_OpenCLWorkGroupLocal = define(5)
  val CX_SC_Auto = define(6)
  val CX_SC_Register = define(7)
  inline def getName(inline value: CX_StorageClass): Option[String] =
    inline value match
      case CX_SC_Invalid => Some("CX_SC_Invalid")
      case CX_SC_None => Some("CX_SC_None")
      case CX_SC_Extern => Some("CX_SC_Extern")
      case CX_SC_Static => Some("CX_SC_Static")
      case CX_SC_PrivateExtern => Some("CX_SC_PrivateExtern")
      case CX_SC_OpenCLWorkGroupLocal => Some("CX_SC_OpenCLWorkGroupLocal")
      case CX_SC_Auto => Some("CX_SC_Auto")
      case CX_SC_Register => Some("CX_SC_Register")
      case _ => _root_.scala.None
  extension (a: CX_StorageClass)
    inline def &(b: CX_StorageClass): CX_StorageClass = a & b
    inline def |(b: CX_StorageClass): CX_StorageClass = a | b
    inline def is(b: CX_StorageClass): Boolean = (a & b) == b