package bindgen

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import libclang.defs.*
import libclang.types.*
import libclang.enumerations.*
import scala.collection.mutable
import libclang.types
import scala.util.control.NoStackTrace

def constructType(typ: CXType)(using
    Zone
): CType =
  import CXTypeKind.*
  val typekind = typ.kind
  lazy val spelling =
    s"""
    |Kind: ${clang_getTypeKindSpelling(typekind).string}, 
    | full type: ${clang_getTypeSpelling(typ).string}
    """.stripMargin

  typekind match
    case CXType_Record =>
      val name = clang_getCursorSpelling(clang_getTypeDeclaration(typ))

      CType.RecordRef(name.string)
    case CXType_Elaborated =>
      val name = constructType(clang_Type_getNamedType(typ))
      name

    case CXType_Enum =>
      val enumName = clang_getCursorSpelling(
        clang_getTypeDeclaration(typ)
      ).string

      CType.Typedef(enumName)

    case CXType_FunctionProto =>
      val resultType = clang_getResultType(typ)
      val numArgs = clang_getNumArgTypes(typ)
      val parameterTypes =
        (0 until numArgs).map(i => constructType(clang_getArgType(typ, i)))

      CType.Function(
        returnType = constructType(resultType),
        parameters =
          parameterTypes.map(ctp => CType.Parameter(None, ctp)).toList
      )

    case CXType_Pointer =>
      val pointee = clang_getPointeeType(typ)
      CType.Pointer(of = constructType(pointee))

    case CXType_Typedef =>
      val definition = clang_getTypedefName(typ)
      CType.Typedef(definition.string)

    case CXType_ConstantArray =>
      val elementType = clang_getArrayElementType(typ)
      val numElements = clang_getArraySize(typ)

      CType.Arr(constructType(elementType), Some(numElements))

    case CXType_Bool => CType.Bool
    case CXType_Void => CType.Void
    // integral types: signed
    case CXType_SChar | CXType_Char_S =>
      CType.NumericIntegral(IntegralBase.Char, SignType.Signed)
    case CXType_Int =>
      CType.NumericIntegral(IntegralBase.Int, SignType.Signed)
    case CXType_Short =>
      CType.NumericIntegral(IntegralBase.Short, SignType.Signed)
    case CXType_Long =>
      CType.NumericIntegral(IntegralBase.Long, SignType.Signed)
    case CXType_LongLong =>
      CType.NumericIntegral(IntegralBase.LongLong, SignType.Signed)

    // integral types: unsigned
    case CXType_UChar | CXType_Char_U =>
      CType.NumericIntegral(IntegralBase.Char, SignType.Unsigned)
    case CXType_UInt =>
      CType.NumericIntegral(IntegralBase.Int, SignType.Unsigned)
    case CXType_UShort =>
      CType.NumericIntegral(IntegralBase.Short, SignType.Unsigned)
    case CXType_ULong =>
      CType.NumericIntegral(IntegralBase.Long, SignType.Unsigned)
    case CXType_ULongLong =>
      CType.NumericIntegral(IntegralBase.LongLong, SignType.Unsigned)

    // floating point types
    case CXType_Float      => CType.NumericReal(FloatingBase.Float)
    case CXType_Double     => CType.NumericReal(FloatingBase.Double)
    case CXType_LongDouble => CType.NumericReal(FloatingBase.LongDouble)

    case other => errln(s"Unknown type: $spelling"); CType.Void;
  end match

end constructType
