package bindgen
package rendering

import scala.collection.mutable.ListBuffer

def isDirectStructAccess(typ: CType)(using AliasResolver): Boolean =
  import CType.*
  typ match
    case _: Struct       => true
    case _: Pointer      => false
    case Typedef(name)   => isDirectStructAccess(aliasResolver(name))
    case RecordRef(name) => isDirectStructAccess(aliasResolver(name))
    case _               => false

def functionRewriter(badFunction: Def.Function)(using
    AliasResolver
): Seq[Def.Function] =
  val isReturnTypeAStruct = isDirectStructAccess(badFunction.returnType)
  val anyParameterIsAStruct =
    badFunction.parameters.map(_._2).exists(isDirectStructAccess)

  if isReturnTypeAStruct || anyParameterIsAStruct then

    // first rewrite - function maintaining all of its parameters intact, but allocating
    // transparently for structs.
    val externFuncName =
      "__sn_wrap_" + badFunction.name
    val externed: Def.Function =
      val tail =
        if isReturnTypeAStruct then
          ListBuffer(
            FunctionParameter(
              "__return",
              CType.Pointer(badFunction.returnType),
              badFunction.originalCType,
              generatedName = false
            )
          )
        else ListBuffer.empty

      Def.Function(
        externFuncName,
        returnType =
          if isReturnTypeAStruct then CType.Void else badFunction.returnType,
        parameters = badFunction.parameters.map { case original =>
          if (isDirectStructAccess(original.typ)) then
            original.copy(typ = CType.Pointer(original.typ))
          else original
          end if
        } ++ tail,
        tpe = CFunctionType.ExternRename(
          externFuncName,
          internal = true,
          badFunction.name
        ),
        originalCType =
          if isReturnTypeAStruct then
            OriginalCType(badFunction.returnType, "void")
          else badFunction.originalCType
      )
    end externed

    val delegate: Def.Function =
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
        ),
        originalCType = badFunction.originalCType
      )
    end delegate

    Seq(delegate, externed)
  else Seq(badFunction)
  end if
end functionRewriter
