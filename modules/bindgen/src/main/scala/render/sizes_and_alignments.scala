package bindgen.rendering

import scala.scalanative.unsafe.*
import scalanative.unsigned.*

import bindgen.*
import scala.scalanative.annotation.alwaysinline

// def align(
//     offset: CSize,
//     alignment: CSize
// ) =
//   val alignmentMask = alignment - 1.toULong
//   val zeroUL = 0.toULong
//   val padding =
//     if (offset & alignmentMask) == zeroUL then zeroUL
//     else alignment - (offset & alignmentMask)
//   offset + padding
// end align

// def offsets(typ: CType.Struct)(using AliasResolver): List[ULong] =
//   def accumulate(fields: List[CType]) =
//     var res = 0.toULong
//     fields.dropRight(1).foreach { typ =>
//       res = align(res, alignment(typ)) + staticSize(typ)
//     }
//     align(res, alignment(fields.last))

//   typ.fields.zipWithIndex.map { case (fieldTyp, idx) =>
//     if idx == 0 then align(0.toULong, alignment(fieldTyp))
//     else accumulate(typ.fields.take(idx + 1))
//   }
// end offsets

// def alignment(typ: CType)(using AliasResolver): CSize =
//   import CType.*
//   typ match
//     case integral: NumericIntegral => staticSize(integral)
//     case real: NumericReal         => staticSize(real)
//     case Arr(of, Some(_))          => alignment(of)
//     case Pointer(_)                => staticSize(typ)
//     case _: Function               => 8.toULong
//     case Struct(fields) =>
//       fields.map(alignment).maxOption.getOrElse(1.toULong)
//     case Bool                           => 1.toULong
//     case Reference(Name.Model(name, _)) => alignment(aliasResolver(name))
//     case Reference(Name.BuiltIn(name))  => name.alignment
//     case IncompleteArray(_)             => 1.toULong
//     case Enum(underlying)               => alignment(underlying)
//     case Union(fields) =>
//       1.toULong // TODO: are unions aligned at all?
//   end match
// end alignment

def staticSize(typ: CType)(using AliasResolver): CSize =
  import CType.*
  typ match
    case NumericIntegral(base, _) =>
      base match
        case IntegralBase.Char     => sizeof[CChar]
        case IntegralBase.Short    => sizeof[Short]
        case IntegralBase.Int      => sizeof[CInt]
        case IntegralBase.Long     => sizeof[CLong]
        case IntegralBase.LongLong => sizeof[CLongLong]
    case NumericReal(base) =>
      base match
        case FloatingBase.Float      => sizeof[CFloat]
        case FloatingBase.Double     => sizeof[CDouble]
        case FloatingBase.LongDouble => sizeof[CDouble]
    case Arr(of, Some(sz)) =>
      sz.toULong * staticSize(of)
    case Pointer(_)                     => sizeof[Ptr[_]]
    case _: Function                    => sizeof[CFuncPtr0[Unit]]
    case Enum(underlying)               => staticSize(underlying)
    case Struct(fields, h)              => h.staticSize.toUInt
    case Union(fields, h)               => h.staticSize.toUInt
    case Reference(Name.Model(name, _)) => staticSize(aliasResolver(name))
    case Reference(Name.BuiltIn(name))  => name.size
    case Bool                           => 1.toULong

  end match
end staticSize
