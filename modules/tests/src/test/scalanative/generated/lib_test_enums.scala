package lib_test_enums

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
    private[lib_test_enums] trait _BindgenEnumCUnsignedChar[T](using eq: T =:= CUnsignedChar):
      given Tag[T] = Tag.UByte.asInstanceOf[Tag[T]]
      extension (inline t: T)
        inline def value: CUnsignedChar = eq.apply(t)
        inline def uint: CUnsignedInt = eq.apply(t)
    private[lib_test_enums] trait _BindgenEnumCInt[T](using eq: T =:= CInt):
      given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
      extension (inline t: T)
        inline def value: CInt = eq.apply(t)
        inline def int: CInt = eq.apply(t).toInt
    private[lib_test_enums] trait _BindgenEnumCUnsignedInt[T](using eq: T =:= CUnsignedInt):
      given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
      extension (inline t: T)
        inline def value: CUnsignedInt = eq.apply(t)
        inline def int: CInt = eq.apply(t).toInt
        inline def uint: CUnsignedInt = eq.apply(t)

object enumerations:
  import predef.*
  opaque type Enum1 = CUnsignedInt
  object Enum1 extends _BindgenEnumCUnsignedInt[Enum1]:
    given _tag: Tag[Enum1] = Tag.UInt
    inline def define(inline a: Long): Enum1 = a.toUInt
    val ONE = define(1)
    val TWO = define(2)
    val THREE = define(3)
    inline def getName(inline value: Enum1): Option[String] =
      inline value match
        case ONE => Some("ONE")
        case TWO => Some("TWO")
        case THREE => Some("THREE")
        case _ => _root_.scala.None
    extension (a: Enum1)
      inline def &(b: Enum1): Enum1 = a & b
      inline def |(b: Enum1): Enum1 = a | b
      inline def is(b: Enum1): Boolean = (a & b) == b

  opaque type Enum2 = CInt
  object Enum2 extends _BindgenEnumCInt[Enum2]:
    given _tag: Tag[Enum2] = Tag.Int
    inline def define(inline a: CInt): Enum2 = a
    val MINUS_ONE = define(-1)
    val MINUS_TWO = define(-2)
    val FOUR = define(4)
    inline def getName(inline value: Enum2): Option[String] =
      inline value match
        case MINUS_ONE => Some("MINUS_ONE")
        case MINUS_TWO => Some("MINUS_TWO")
        case FOUR => Some("FOUR")
        case _ => _root_.scala.None
    extension (a: Enum2)
      inline def &(b: Enum2): Enum2 = a & b
      inline def |(b: Enum2): Enum2 = a | b
      inline def is(b: Enum2): Boolean = (a & b) == b

  opaque type EnumBitwiseOperations = CUnsignedInt
  object EnumBitwiseOperations extends _BindgenEnumCUnsignedInt[EnumBitwiseOperations]:
    given _tag: Tag[EnumBitwiseOperations] = Tag.UInt
    inline def define(inline a: Long): EnumBitwiseOperations = a.toUInt
    val BITWISE_ONE = define(1)
    val BITWISE_TWO = define(2)
    val BITWISE_THREE = define(3)
    inline def getName(inline value: EnumBitwiseOperations): Option[String] =
      inline value match
        case BITWISE_ONE => Some("BITWISE_ONE")
        case BITWISE_TWO => Some("BITWISE_TWO")
        case BITWISE_THREE => Some("BITWISE_THREE")
        case _ => _root_.scala.None
    extension (a: EnumBitwiseOperations)
      inline def &(b: EnumBitwiseOperations): EnumBitwiseOperations = a & b
      inline def |(b: EnumBitwiseOperations): EnumBitwiseOperations = a | b
      inline def is(b: EnumBitwiseOperations): Boolean = (a & b) == b

  opaque type EnumKeywords = CUnsignedInt
  object EnumKeywords extends _BindgenEnumCUnsignedInt[EnumKeywords]:
    given _tag: Tag[EnumKeywords] = Tag.UInt
    inline def define(inline a: Long): EnumKeywords = a.toUInt
    val `match` = define(1)
    val `true` = define(2)
    val `false` = define(3)
    val `class` = define(4)
    val `object` = define(5)
    val `null` = define(6)
    val `type` = define(7)
    val `val` = define(8)
    val `var` = define(9)
    val `def` = define(10)
    inline def getName(inline value: EnumKeywords): Option[String] =
      inline value match
        case `match` => Some("`match`")
        case `true` => Some("`true`")
        case `false` => Some("`false`")
        case `class` => Some("`class`")
        case `object` => Some("`object`")
        case `null` => Some("`null`")
        case `type` => Some("`type`")
        case `val` => Some("`val`")
        case `var` => Some("`var`")
        case `def` => Some("`def`")
        case _ => _root_.scala.None
    extension (a: EnumKeywords)
      inline def &(b: EnumKeywords): EnumKeywords = a & b
      inline def |(b: EnumKeywords): EnumKeywords = a | b
      inline def is(b: EnumKeywords): Boolean = (a & b) == b

  opaque type PackedEnum8 = CUnsignedChar
  object PackedEnum8 extends _BindgenEnumCUnsignedChar[PackedEnum8]:
    given _tag: Tag[PackedEnum8] = Tag.UByte
    inline def define(inline a: Long): PackedEnum8 = a.toUByte
    val TOP = define(1)
    val CENTER = define(2)
    inline def getName(inline value: PackedEnum8): Option[String] =
      inline value match
        case TOP => Some("TOP")
        case CENTER => Some("CENTER")
        case _ => _root_.scala.None
    extension (a: PackedEnum8)
      inline def &(b: PackedEnum8): PackedEnum8 = ((a & b) & 0xff.toUInt).toUByte
      inline def |(b: PackedEnum8): PackedEnum8 = ((a | b) & 0xff.toUInt).toUByte
      inline def is(b: PackedEnum8): Boolean = (a & b) == b

object structs:
  import _root_.lib_test_enums.enumerations.*
  import _root_.lib_test_enums.predef.*
  import _root_.lib_test_enums.structs.*
  opaque type EnumAnon = CStruct2[EnumAnon.Enum0, CInt]
  object EnumAnon:
    opaque type Enum0 = CUnsignedInt
    object Enum0 extends _BindgenEnumCUnsignedInt[Enum0]:
      given _tag: Tag[Enum0] = Tag.UInt
      inline def define(inline a: Long): Enum0 = a.toUInt
      val WHAT = define(0)
      val THE = define(1)
      val HELL = define(2)
      inline def getName(inline value: Enum0): Option[String] =
        inline value match
          case WHAT => Some("WHAT")
          case THE => Some("THE")
          case HELL => Some("HELL")
          case _ => _root_.scala.None
      extension (a: Enum0)
        inline def &(b: Enum0): Enum0 = a & b
        inline def |(b: Enum0): Enum0 = a | b
        inline def is(b: Enum0): Boolean = (a & b) == b
    given _tag: Tag[EnumAnon] = Tag.materializeCStruct2Tag[EnumAnon.Enum0, CInt]
    def apply()(using Zone): Ptr[EnumAnon] = scala.scalanative.unsafe.alloc[EnumAnon](1)
    def apply(protocol : EnumAnon.Enum0, howdy : CInt)(using Zone): Ptr[EnumAnon] =
      val ____ptr = apply()
      (!____ptr).protocol = protocol
      (!____ptr).howdy = howdy
      ____ptr
    extension (struct: EnumAnon)
      def protocol : EnumAnon.Enum0 = struct._1
      def protocol_=(value: EnumAnon.Enum0): Unit = !struct.at1 = value
      def howdy : CInt = struct._2
      def howdy_=(value: CInt): Unit = !struct.at2 = value

object constants:
  val WHAT: CUnsignedInt = 0.toUInt
  val THE: CUnsignedInt = 1.toUInt
  val HELL: CUnsignedInt = 2.toUInt
  
object types:
  export _root_.lib_test_enums.structs.*
  export _root_.lib_test_enums.enumerations.*

object all:
  export _root_.lib_test_enums.enumerations.Enum1
  export _root_.lib_test_enums.enumerations.Enum2
  export _root_.lib_test_enums.enumerations.EnumBitwiseOperations
  export _root_.lib_test_enums.enumerations.EnumKeywords
  export _root_.lib_test_enums.enumerations.PackedEnum8
  export _root_.lib_test_enums.structs.EnumAnon