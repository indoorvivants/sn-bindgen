package lib_test_typedefs

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object predef:
  private[lib_test_typedefs] trait _BindgenEnumCUnsignedInt[T](using eq: T =:= CUnsignedInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (inline t: T)
     inline def value: CUnsignedInt = eq.apply(t)
     inline def int: CInt = eq.apply(t).toInt
     inline def uint: CUnsignedInt = eq.apply(t)


object enumerations:
  import predef.*
  opaque type DUCKDB_TYPEs = CUnsignedInt
  object DUCKDB_TYPEs extends _BindgenEnumCUnsignedInt[DUCKDB_TYPEs]:
    given _tag: Tag[DUCKDB_TYPEs] = Tag.UInt
    inline def define(inline a: Long): DUCKDB_TYPEs = a.toUInt
    val DUCKDB_TYPE_INVALID = define(0)
    val DUCKDB_TYPE_JSON = define(1)
    inline def getName(inline value: DUCKDB_TYPEs): Option[String] =
      inline value match
        case DUCKDB_TYPE_INVALID => Some("DUCKDB_TYPE_INVALID")
        case DUCKDB_TYPE_JSON => Some("DUCKDB_TYPE_JSON")
        case _ => _root_.scala.None
    extension (a: DUCKDB_TYPEs)
      inline def &(b: DUCKDB_TYPEs): DUCKDB_TYPEs = a & b
      inline def |(b: DUCKDB_TYPEs): DUCKDB_TYPEs = a | b
      inline def is(b: DUCKDB_TYPEs): Boolean = (a & b) == b

object aliases:
  import _root_.lib_test_typedefs.enumerations.*
  import _root_.lib_test_typedefs.predef.*
  import _root_.lib_test_typedefs.aliases.*
  import _root_.lib_test_typedefs.structs.*
  type duckdb_type = DUCKDB_TYPEs
  object duckdb_type: 
    given _tag: Tag[duckdb_type] = DUCKDB_TYPEs._tag
    inline def apply(inline o: DUCKDB_TYPEs): duckdb_type = o
    extension (v: duckdb_type)
      inline def value: DUCKDB_TYPEs = v

object structs:
  import _root_.lib_test_typedefs.enumerations.*
  import _root_.lib_test_typedefs.predef.*
  import _root_.lib_test_typedefs.aliases.*
  import _root_.lib_test_typedefs.structs.*
  opaque type DUCKDB_COLUMNs = CStruct3[duckdb_type, CString, Ptr[Byte]]
  object DUCKDB_COLUMNs:
    given _tag: Tag[DUCKDB_COLUMNs] = Tag.materializeCStruct3Tag[duckdb_type, CString, Ptr[Byte]]
    def apply()(using Zone): Ptr[DUCKDB_COLUMNs] = scala.scalanative.unsafe.alloc[DUCKDB_COLUMNs](1)
    def apply(`type` : duckdb_type, name : CString, internal_data : Ptr[Byte])(using Zone): Ptr[DUCKDB_COLUMNs] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).name = name
      (!____ptr).internal_data = internal_data
      ____ptr
    extension (struct: DUCKDB_COLUMNs)
      def `type` : duckdb_type = struct._1
      def type_=(value: duckdb_type): Unit = !struct.at1 = value
      def name : CString = struct._2
      def name_=(value: CString): Unit = !struct.at2 = value
      def internal_data : Ptr[Byte] = struct._3
      def internal_data_=(value: Ptr[Byte]): Unit = !struct.at3 = value

  opaque type Hello = CStruct1[Ptr[duckdb_column]]
  object Hello:
    given _tag: Tag[Hello] = Tag.materializeCStruct1Tag[Ptr[duckdb_column]]
    def apply()(using Zone): Ptr[Hello] = scala.scalanative.unsafe.alloc[Hello](1)
    def apply(h : Ptr[duckdb_column])(using Zone): Ptr[Hello] = 
      val ____ptr = apply()
      (!____ptr).h = h
      ____ptr
    extension (struct: Hello)
      def h : Ptr[duckdb_column] = struct._1
      def h_=(value: Ptr[duckdb_column]): Unit = !struct.at1 = value

  opaque type duckdb_column = CStruct3[duckdb_type, CString, Ptr[Byte]]
  object duckdb_column:
    given _tag: Tag[duckdb_column] = Tag.materializeCStruct3Tag[duckdb_type, CString, Ptr[Byte]]
    def apply()(using Zone): Ptr[duckdb_column] = scala.scalanative.unsafe.alloc[duckdb_column](1)
    def apply(`type` : duckdb_type, name : CString, internal_data : Ptr[Byte])(using Zone): Ptr[duckdb_column] = 
      val ____ptr = apply()
      (!____ptr).`type` = `type`
      (!____ptr).name = name
      (!____ptr).internal_data = internal_data
      ____ptr
    extension (struct: duckdb_column)
      def `type` : duckdb_type = struct._1
      def type_=(value: duckdb_type): Unit = !struct.at1 = value
      def name : CString = struct._2
      def name_=(value: CString): Unit = !struct.at2 = value
      def internal_data : Ptr[Byte] = struct._3
      def internal_data_=(value: Ptr[Byte]): Unit = !struct.at3 = value

object types:
  export _root_.lib_test_typedefs.structs.*
  export _root_.lib_test_typedefs.aliases.*
  export _root_.lib_test_typedefs.enumerations.*

object all:
  export _root_.lib_test_typedefs.enumerations.DUCKDB_TYPEs
  export _root_.lib_test_typedefs.aliases.duckdb_type
  export _root_.lib_test_typedefs.structs.DUCKDB_COLUMNs
  export _root_.lib_test_typedefs.structs.Hello
  export _root_.lib_test_typedefs.structs.duckdb_column