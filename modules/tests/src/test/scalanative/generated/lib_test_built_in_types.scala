package lib_test_built_in_types

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object aliases:
  import _root_.lib_test_built_in_types.aliases.*
  import _root_.lib_test_built_in_types.structs.*
  type Test_fpos_t = fpos_t
  object Test_fpos_t: 
    given _tag: Tag[Test_fpos_t] = fpos_t._tag
    inline def apply(inline o: fpos_t): Test_fpos_t = o
    extension (v: Test_fpos_t)
      inline def value: fpos_t = v

  type Test_size_t = size_t
  object Test_size_t: 
    given _tag: Tag[Test_size_t] = size_t._tag
    inline def apply(inline o: size_t): Test_size_t = o
    extension (v: Test_size_t)
      inline def value: size_t = v

  type Test_ssize_t = ssize_t
  object Test_ssize_t: 
    given _tag: Tag[Test_ssize_t] = ssize_t._tag
    inline def apply(inline o: ssize_t): Test_ssize_t = o
    extension (v: Test_ssize_t)
      inline def value: ssize_t = v

  type Test_time_t = time_t
  object Test_time_t: 
    given _tag: Tag[Test_time_t] = time_t._tag
    inline def apply(inline o: time_t): Test_time_t = o
    extension (v: Test_time_t)
      inline def value: time_t = v

  type Test_va_list = va_list
  object Test_va_list: 
    given _tag: Tag[Test_va_list] = va_list._tag
    inline def apply(inline o: va_list): Test_va_list = o
    extension (v: Test_va_list)
      inline def value: va_list = v

  type fpos_t = libc.stdio.fpos_t
  object fpos_t: 
    val _tag: Tag[fpos_t] = summon[Tag[libc.stdio.fpos_t]]
    inline def apply(inline o: libc.stdio.fpos_t): fpos_t = o
    extension (v: fpos_t)
      inline def value: libc.stdio.fpos_t = v

  type imaxdiv_t = libc.inttypes.imaxdiv_t
  object imaxdiv_t: 
    val _tag: Tag[imaxdiv_t] = summon[Tag[libc.inttypes.imaxdiv_t]]
    inline def apply(inline o: libc.inttypes.imaxdiv_t): imaxdiv_t = o
    extension (v: imaxdiv_t)
      inline def value: libc.inttypes.imaxdiv_t = v

  type int16_t = scala.Short
  object int16_t: 
    val _tag: Tag[int16_t] = summon[Tag[scala.Short]]
    inline def apply(inline o: scala.Short): int16_t = o
    extension (v: int16_t)
      inline def value: scala.Short = v

  type int32_t = scala.scalanative.unsafe.CInt
  object int32_t: 
    val _tag: Tag[int32_t] = summon[Tag[scala.scalanative.unsafe.CInt]]
    inline def apply(inline o: scala.scalanative.unsafe.CInt): int32_t = o
    extension (v: int32_t)
      inline def value: scala.scalanative.unsafe.CInt = v

  type int8_t = scala.scalanative.unsafe.CChar
  object int8_t: 
    val _tag: Tag[int8_t] = summon[Tag[scala.scalanative.unsafe.CChar]]
    inline def apply(inline o: scala.scalanative.unsafe.CChar): int8_t = o
    extension (v: int8_t)
      inline def value: scala.scalanative.unsafe.CChar = v

  type size_t = libc.stddef.size_t
  object size_t: 
    val _tag: Tag[size_t] = summon[Tag[libc.stddef.size_t]]
    inline def apply(inline o: libc.stddef.size_t): size_t = o
    extension (v: size_t)
      inline def value: libc.stddef.size_t = v

  type sockaddr = posix.sys.socket.sockaddr
  object sockaddr: 
    val _tag: Tag[sockaddr] = summon[Tag[posix.sys.socket.sockaddr]]
    inline def apply(inline o: posix.sys.socket.sockaddr): sockaddr = o
    extension (v: sockaddr)
      inline def value: posix.sys.socket.sockaddr = v

  type ssize_t = posix.sys.types.ssize_t
  object ssize_t: 
    val _tag: Tag[ssize_t] = summon[Tag[posix.sys.types.ssize_t]]
    inline def apply(inline o: posix.sys.types.ssize_t): ssize_t = o
    extension (v: ssize_t)
      inline def value: posix.sys.types.ssize_t = v

  type time_t = posix.sys.types.time_t
  object time_t: 
    val _tag: Tag[time_t] = summon[Tag[posix.sys.types.time_t]]
    inline def apply(inline o: posix.sys.types.time_t): time_t = o
    extension (v: time_t)
      inline def value: posix.sys.types.time_t = v

  type uint16_t = scala.scalanative.unsigned.UShort
  object uint16_t: 
    val _tag: Tag[uint16_t] = summon[Tag[scala.scalanative.unsigned.UShort]]
    inline def apply(inline o: scala.scalanative.unsigned.UShort): uint16_t = o
    extension (v: uint16_t)
      inline def value: scala.scalanative.unsigned.UShort = v

  type uint32_t = scala.scalanative.unsigned.UInt
  object uint32_t: 
    val _tag: Tag[uint32_t] = summon[Tag[scala.scalanative.unsigned.UInt]]
    inline def apply(inline o: scala.scalanative.unsigned.UInt): uint32_t = o
    extension (v: uint32_t)
      inline def value: scala.scalanative.unsigned.UInt = v

  type uint8_t = scala.scalanative.unsigned.UByte
  object uint8_t: 
    val _tag: Tag[uint8_t] = summon[Tag[scala.scalanative.unsigned.UByte]]
    inline def apply(inline o: scala.scalanative.unsigned.UByte): uint8_t = o
    extension (v: uint8_t)
      inline def value: scala.scalanative.unsigned.UByte = v

  type va_list = unsafe.CVarArgList
  object va_list: 
    val _tag: Tag[va_list] = summon[Tag[unsafe.CVarArgList]]
    inline def apply(inline o: unsafe.CVarArgList): va_list = o
    extension (v: va_list)
      inline def value: unsafe.CVarArgList = v

object structs:
  import _root_.lib_test_built_in_types.aliases.*
  import _root_.lib_test_built_in_types.structs.*
  opaque type SpecialIntTypes = CStruct6[int8_t, int16_t, int32_t, uint8_t, uint16_t, uint32_t]
  object SpecialIntTypes:
    given _tag: Tag[SpecialIntTypes] = Tag.materializeCStruct6Tag[int8_t, int16_t, int32_t, uint8_t, uint16_t, uint32_t]
    def apply()(using Zone): Ptr[SpecialIntTypes] = scala.scalanative.unsafe.alloc[SpecialIntTypes](1)
    def apply(i8 : int8_t, i16 : int16_t, i32 : int32_t, u8 : uint8_t, u16 : uint16_t, u32 : uint32_t)(using Zone): Ptr[SpecialIntTypes] = 
      val ____ptr = apply()
      (!____ptr).i8 = i8
      (!____ptr).i16 = i16
      (!____ptr).i32 = i32
      (!____ptr).u8 = u8
      (!____ptr).u16 = u16
      (!____ptr).u32 = u32
      ____ptr
    extension (struct: SpecialIntTypes)
      def i8 : int8_t = struct._1
      def i8_=(value: int8_t): Unit = !struct.at1 = value
      def i16 : int16_t = struct._2
      def i16_=(value: int16_t): Unit = !struct.at2 = value
      def i32 : int32_t = struct._3
      def i32_=(value: int32_t): Unit = !struct.at3 = value
      def u8 : uint8_t = struct._4
      def u8_=(value: uint8_t): Unit = !struct.at4 = value
      def u16 : uint16_t = struct._5
      def u16_=(value: uint16_t): Unit = !struct.at5 = value
      def u32 : uint32_t = struct._6
      def u32_=(value: uint32_t): Unit = !struct.at6 = value

  opaque type UsingPosixTypes = CStruct3[imaxdiv_t, sockaddr, group]
  object UsingPosixTypes:
    given _tag: Tag[UsingPosixTypes] = Tag.materializeCStruct3Tag[imaxdiv_t, sockaddr, group]
    def apply()(using Zone): Ptr[UsingPosixTypes] = scala.scalanative.unsafe.alloc[UsingPosixTypes](1)
    def apply(i1 : imaxdiv_t, s2 : sockaddr, g1 : group)(using Zone): Ptr[UsingPosixTypes] = 
      val ____ptr = apply()
      (!____ptr).i1 = i1
      (!____ptr).s2 = s2
      (!____ptr).g1 = g1
      ____ptr
    extension (struct: UsingPosixTypes)
      def i1 : imaxdiv_t = struct._1
      def i1_=(value: imaxdiv_t): Unit = !struct.at1 = value
      def s2 : sockaddr = struct._2
      def s2_=(value: sockaddr): Unit = !struct.at2 = value
      def g1 : group = struct._3
      def g1_=(value: group): Unit = !struct.at3 = value

  opaque type group = CStruct1[CInt]
  object group:
    given _tag: Tag[group] = Tag.materializeCStruct1Tag[CInt]
    def apply()(using Zone): Ptr[group] = scala.scalanative.unsafe.alloc[group](1)
    def apply(i : CInt)(using Zone): Ptr[group] = 
      val ____ptr = apply()
      (!____ptr).i = i
      ____ptr
    extension (struct: group)
      def i : CInt = struct._1
      def i_=(value: CInt): Unit = !struct.at1 = value


@extern
private[lib_test_built_in_types] object extern_functions:
  import _root_.lib_test_built_in_types.aliases.*
  import _root_.lib_test_built_in_types.structs.*
  def TestVaListArgument(args : va_list): Unit = extern


object functions:
  import _root_.lib_test_built_in_types.aliases.*
  import _root_.lib_test_built_in_types.structs.*
  import extern_functions.*
  export extern_functions.*

object types:
  export _root_.lib_test_built_in_types.structs.*
  export _root_.lib_test_built_in_types.aliases.*

object all:
  export _root_.lib_test_built_in_types.aliases.Test_fpos_t
  export _root_.lib_test_built_in_types.aliases.Test_size_t
  export _root_.lib_test_built_in_types.aliases.Test_ssize_t
  export _root_.lib_test_built_in_types.aliases.Test_time_t
  export _root_.lib_test_built_in_types.aliases.Test_va_list
  export _root_.lib_test_built_in_types.aliases.fpos_t
  export _root_.lib_test_built_in_types.aliases.imaxdiv_t
  export _root_.lib_test_built_in_types.aliases.int16_t
  export _root_.lib_test_built_in_types.aliases.int32_t
  export _root_.lib_test_built_in_types.aliases.int8_t
  export _root_.lib_test_built_in_types.aliases.size_t
  export _root_.lib_test_built_in_types.aliases.sockaddr
  export _root_.lib_test_built_in_types.aliases.ssize_t
  export _root_.lib_test_built_in_types.aliases.time_t
  export _root_.lib_test_built_in_types.aliases.uint16_t
  export _root_.lib_test_built_in_types.aliases.uint32_t
  export _root_.lib_test_built_in_types.aliases.uint8_t
  export _root_.lib_test_built_in_types.aliases.va_list
  export _root_.lib_test_built_in_types.structs.SpecialIntTypes
  export _root_.lib_test_built_in_types.structs.UsingPosixTypes
  export _root_.lib_test_built_in_types.structs.group
  export _root_.lib_test_built_in_types.functions.TestVaListArgument