package bindgen

import libclang.defs.*
import libclang.enumerations.*
import libclang.types
import libclang.fluent.*
import libclang.types.*

import scala.collection.mutable
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scala.util.control.NoStackTrace

import scalanative.libc.*

def constructType(typ: CXType)(using
    Zone,
    Config
): CType =
  import CXTypeKind.*
  val typekind = typ.kind
  lazy val spelling =
    s"""
    Kind: ${clang_getTypeKindSpelling(
        typekind
      ).string}, full type: ${clang_getTypeSpelling(typ).string}
    """.stripMargin.trim

  val result = typekind match
    case CXType_Record =>
      val decl = clang_getTypeDeclaration(typ)
      val name = clang_getCursorSpelling(decl).string

      CType.Reference(if name.isEmpty then Name.Unnamed else Name.Model(name))

    case CXType_Elaborated =>
      val name = constructType(clang_Type_getNamedType(typ))
      name

    case CXType_Enum =>
      val enumName = clang_getCursorSpelling(
        clang_getTypeDeclaration(typ)
      ).string

      CType.Reference(Name.Model(enumName))

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
      val str = definition.string
      val declaration = clang_getTypeDeclaration(typ).kind
      CType.Reference(Name.Model(str))

    case CXType_ConstantArray =>
      val elementType = clang_getArrayElementType(typ)
      val numElements = clang_getArraySize(typ)
      constArrayType(constructType(elementType), numElements)

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

    case CXType_IncompleteArray =>
      val elementType = constructType(clang_getArrayElementType(typ))
      CType.IncompleteArray(elementType)

    case CXType_Vector =>
      val elementType = constructType(clang_getElementType(typ))
      val numElements = clang_getNumElements(typ)

      CType.Struct(List.fill(numElements.toInt)(elementType))

    case other =>
      warning(
        s"Unknown type: $spelling"
      )
      CType.Void;
  end result

  trace(
    s"Constructed type ${result} from: '${typ.spelling}', kind: '${typ.kindSpelling}'"
  )
  result

end constructType

def constArrayType(elementType: CType, numElements: Int) =
  CType.Arr(elementType, Some(numElements))
