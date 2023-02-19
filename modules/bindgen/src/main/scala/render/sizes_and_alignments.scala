package bindgen.rendering

import scala.scalanative.unsafe.*
import scalanative.unsigned.*

import bindgen.*
import scala.scalanative.annotation.alwaysinline

@alwaysinline def align(
    offset: CSize,
    alignment: CSize
) =
  val alignmentMask = alignment - 1.toULong
  val zeroUL = 0.toULong
  val padding =
    if (offset & alignmentMask) == zeroUL then zeroUL
    else alignment - (offset & alignmentMask)
  offset + padding
end align

def offsets(typ: CType.Struct)(using AliasResolver): List[ULong] =
  def accumulate(fields: List[CType]) =
    var res = 0.toULong
    fields.dropRight(1).foreach { typ =>
      res = align(res, alignment(typ)) + staticSize(typ)
    }
    align(res, alignment(fields.last))

  typ.fields.zipWithIndex.map { case (fieldTyp, idx) =>
    if idx == 0 then align(0.toULong, alignment(fieldTyp))
    else accumulate(typ.fields.take(idx + 1))
  }
end offsets

def alignment(typ: CType)(using AliasResolver): CSize =
  import CType.*
  typ match
    case integral: NumericIntegral => staticSize(integral)
    case real: NumericReal         => staticSize(real)
    case Arr(of, Some(_))          => alignment(of)
    case Pointer(_)                => staticSize(typ)
    case _: Function               => 8.toULong
    case Struct(fields) =>
      fields.map(alignment).maxOption.getOrElse(1.toULong)
    case Bool                           => 1.toULong
    case Reference(Name.Model(name, _)) => alignment(aliasResolver(name))
    case Reference(Name.BuiltIn(name))  => name.alignment
    case IncompleteArray(_)             => 1.toULong
    case Union(fields) =>
      1.toULong // TODO: are unions aligned at all?
  end match
end alignment

def staticSize(typ: CType)(using AliasResolver): CSize =
  import CType.*
  typ match
    case NumericIntegral(base, _) =>
      base match
        case IntegralBase.Char     => 1.toULong
        case IntegralBase.Short    => 2.toULong
        case IntegralBase.Int      => 4.toULong
        case IntegralBase.Long     => 8.toULong
        case IntegralBase.LongLong => 8.toULong
    case NumericReal(base) =>
      base match
        case FloatingBase.Float      => 4.toULong
        case FloatingBase.Double     => 8.toULong
        case FloatingBase.LongDouble => 8.toULong
    case Arr(of, Some(sz)) =>
      sz.toULong * staticSize(of)
    case Pointer(_)       => 8.toULong
    case _: Function      => 8.toULong
    case Enum(underlying) => staticSize(underlying)
    case Struct(fields) =>
      var res = 0.toULong
      fields.foreach { typ =>
        res = align(res, alignment(typ)) + staticSize(typ)
      }

      align(res, alignment(typ))
    case Union(fields) =>
      // TODO: are unions aligned on any boundary?
      fields.map(staticSize).maxOption.getOrElse(1.toULong)
    case Reference(Name.Model(name, _)) => staticSize(aliasResolver(name))
    case Reference(Name.BuiltIn(name))  => name.size
    case Bool                           => 1.toULong

  end match
end staticSize
