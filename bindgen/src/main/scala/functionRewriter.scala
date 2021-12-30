package bindgen

import render.*
import scala.collection.mutable.ListBuffer
def isDirectStructAccess(typ: CType)(using render.AliasResolver): Boolean =
  import CType.*
  typ match
    case _: Struct       => true
    case _: Pointer      => false
    case Typedef(name)   => isDirectStructAccess(aliasResolver(name))
    case RecordRef(name) => isDirectStructAccess(aliasResolver(name))
    case _               => false

def functionRewriter(badFunction: Def.Function)(using
    render.AliasResolver
): Seq[Def.Function] =
  val isReturnTypeAStruct = isDirectStructAccess(badFunction.returnType)
  val anyParameterIsAStruct =
    badFunction.parameters.map(_._2).exists(isDirectStructAccess)

  if isReturnTypeAStruct || anyParameterIsAStruct then

    // first rewrite - function maintaining all of its parameters intact, but allocating
    // transparently for structs.
    val externFuncName =
      "__sn_wrap_" + badFunction.name
    val externed =
      val tail =
        if isReturnTypeAStruct then
          ListBuffer(
            "__return" -> CType.Pointer(badFunction.returnType)
          )
        else ListBuffer.empty

      Def.Function(
        "impl",
        returnType =
          if isReturnTypeAStruct then CType.Void else badFunction.returnType,
        parameters = badFunction.parameters.map { case (name, typ) =>
          if (isDirectStructAccess(typ)) then name -> CType.Pointer(typ)
          else name -> typ
          end if
        } ++ tail,
        tpe = CFunctionType.ExternRename(
          externFuncName,
          internal = true
        )
      )
    end externed

    val delegate =
      val rewriteArgumentIndices = badFunction.parameters
        .map(_._2)
        .zipWithIndex
        .collect {
          case (typ, idx) if isDirectStructAccess(typ) => idx
        }
        .toSet

      Def.Function(
        badFunction.name,
        returnType = badFunction.returnType,
        parameters = badFunction.parameters,
        tpe = CFunctionType.Delegate(
          rewriteArgumentIndices,
          isReturnTypeAStruct,
          externFuncName
        )
      )
    end delegate

    Seq(delegate, externed)
  else Seq(badFunction)
  end if
end functionRewriter
