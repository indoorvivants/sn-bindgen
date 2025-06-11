package lib_test_conflicting_names

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

object aliases:
  import _root_.lib_test_conflicting_names.aliases.*
  opaque type EVP_MD_CTX = CInt
  object EVP_MD_CTX:
    given _tag: Tag[EVP_MD_CTX] = Tag.Int
    inline def apply(inline o: CInt): EVP_MD_CTX = o
    extension (v: EVP_MD_CTX) inline def value: CInt = v

  opaque type bla_bla = CInt
  object bla_bla:
    given _tag: Tag[bla_bla] = Tag.Int
    inline def apply(inline o: CInt): bla_bla = o
    extension (v: bla_bla) inline def value: CInt = v
end aliases

@extern
private[lib_test_conflicting_names] object extern_functions:
  import _root_.lib_test_conflicting_names.aliases.*
  def EVP_MD_CTX_update_fn(
      ctx: Ptr[EVP_MD_CTX]
  ): CFuncPtr3[Ptr[EVP_MD_CTX], Ptr[Byte], bla_bla, CInt] = extern

object functions:
  import _root_.lib_test_conflicting_names.aliases.*
  import extern_functions.*
  export extern_functions.*

object types:
  export _root_.lib_test_conflicting_names.aliases.*

object all:
  export _root_.lib_test_conflicting_names.aliases.EVP_MD_CTX
  export _root_.lib_test_conflicting_names.aliases.bla_bla
  export _root_.lib_test_conflicting_names.functions.EVP_MD_CTX_update_fn
