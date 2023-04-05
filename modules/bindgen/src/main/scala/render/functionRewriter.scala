package bindgen
package rendering

import scala.collection.mutable.ListBuffer
import opaque_newtypes.*

def functionRewriter(badFunction: Def.Function)(using
    AliasResolver,
    Config
): Seq[GeneratedFunction] =
  val isReturnTypeAStruct = isDirectStructAccess(badFunction.returnType)
  val anyParameterIsAStruct =
    badFunction.parameters.map(_._2).exists(isDirectStructAccess)

  if isReturnTypeAStruct || anyParameterIsAStruct then
    if badFunction.variadic then
      warning(
        s"Function ${badFunction.name} was not generated because it " +
          "requires forwarders (as it passes structs by value), but fowarders cannot have variadic arguments"
      )
      Seq.empty
    else
      // we will generate three functions
      val generated = Seq.newBuilder[GeneratedFunction]
      // 1. a private Scala forwarder function
      if !badFunction.variadic then
        generated.addOne(scalaForwarderFunction(badFunction))
      // 2. a public Scala wrapper function, which leaves parameter types untouched
      generated.addOne(scalaAllocatingFunction(badFunction))
      // 2.1. a public Scala wrapper function, which takes parameters by references
      generated.addAll(scalaPtrFunctions(badFunction))
      // 3. a C forwarder function
      generated.addOne(cForwarderFunction(badFunction))

      generated.result
  else
    Seq(
      GeneratedFunction.ScalaFunction(
        badFunction.name.into(ScalaFunctionName),
        badFunction.returnType,
        List(badFunction.parameters.toList),
        ScalaFunctionBody.Extern,
        public = true,
        variadic = badFunction.variadic,
        meta = Some(badFunction.meta)
      )
    )
  end if

end functionRewriter

private def isDirectStructAccess(typ: CType)(using AliasResolver): Boolean =
  import CType.*
  typ match
    case _: Struct  => true
    case _: Pointer => false
    case Reference(Name.Model(name, _)) =>
      isDirectStructAccess(aliasResolver(name))
    case _ => false

case class Allocations(
    params: Set[Int],
    returnValue: Boolean
):
  def hasAny: Boolean = params.nonEmpty || returnValue

opaque type CFunctionName = String
object CFunctionName extends OpaqueString[CFunctionName]

opaque type ScalaFunctionName = String
object ScalaFunctionName extends OpaqueString[ScalaFunctionName]

enum ScalaFunctionBody:
  case Extern
  case Delegate(to: ScalaFunctionName, allocations: Allocations)

enum CFunctionBody:
  case Delegate(to: CFunctionName, dereference: Set[Int], returnAsWell: Boolean)

enum GeneratedFunction:
  case ScalaFunction(
      name: ScalaFunctionName,
      returnType: CType,
      arguments: List[List[FunctionParameter]],
      body: ScalaFunctionBody,
      public: Boolean,
      variadic: Boolean,
      meta: Option[Meta]
  )

  case CFunction(
      name: CFunctionName,
      returnType: CType,
      originalCType: OriginalCType,
      arguments: List[FunctionParameter],
      body: CFunctionBody
  )
end GeneratedFunction

private def externFuncName(s: String)(using c: Config) =
  s"__sn_wrap_${c.packageName.value}_" + s

private def scalaForwarderFunction(
    bad: Def.Function
)(using AliasResolver, Config): GeneratedFunction.ScalaFunction =
  val returnAsWell = isDirectStructAccess(bad.returnType)

  val parameters = List.newBuilder[FunctionParameter]

  bad.parameters.foreach { fp =>
    if isDirectStructAccess(fp.typ) then
      parameters.addOne(fp.copy(typ = CType.Pointer(fp.typ)))
    else parameters.addOne(fp)
  }

  if returnAsWell then
    parameters.addOne(
      FunctionParameter(
        "__return",
        CType.Pointer(bad.returnType),
        bad.originalCType,
        generatedName = false
      )
    )
  end if

  val returnType = if returnAsWell then CType.Void else bad.returnType

  GeneratedFunction.ScalaFunction(
    ScalaFunctionName(externFuncName(bad.name.value)),
    returnType,
    List(parameters.result),
    ScalaFunctionBody.Extern,
    public = false,
    variadic = bad.variadic,
    meta = None
  )
end scalaForwarderFunction

private def scalaAllocatingFunction(bad: Def.Function)(using
    Config,
    AliasResolver
): GeneratedFunction.ScalaFunction =
  val invokes = externFuncName(bad.name.value)
  GeneratedFunction.ScalaFunction(
    ScalaFunctionName(bad.name.value),
    bad.returnType,
    List(bad.parameters.toList),
    ScalaFunctionBody.Delegate(
      invokes,
      Allocations(
        params =
          bad.parameters.map(_.typ).zipWithIndex.toSet.flatMap { (p, i) =>
            if isDirectStructAccess(p) then Some(i)
            else None
          },
        returnValue = isDirectStructAccess(bad.returnType)
      )
    ),
    public = true,
    variadic = bad.variadic,
    meta = Some(bad.meta)
  )
end scalaAllocatingFunction

private def scalaPtrFunctions(bad: Def.Function)(using
    Config,
    AliasResolver
): List[GeneratedFunction] =
  val invokes = externFuncName(bad.name.value)
  val returnAsWell = isDirectStructAccess(bad.returnType)

  val gen = List.newBuilder[GeneratedFunction]
  gen.addOne {
    GeneratedFunction.ScalaFunction(
      bad.name.into(ScalaFunctionName),
      bad.returnType,
      List(bad.parameters.toList.map { fp =>
        if isDirectStructAccess(fp.typ) then
          fp.copy(typ = CType.Pointer(fp.typ))
        else fp
      }),
      ScalaFunctionBody.Delegate(
        invokes,
        Allocations(
          params = Set.empty,
          returnValue = returnAsWell
        )
      ),
      public = true,
      variadic = bad.variadic,
      meta = Some(bad.meta)
    )
  }

  if returnAsWell then
    gen.addOne {
      GeneratedFunction.ScalaFunction(
        bad.name.into(ScalaFunctionName),
        CType.Void,
        List(bad.parameters.toList.map { fp =>
          if isDirectStructAccess(fp.typ) then
            fp.copy(typ = CType.Pointer(fp.typ))
          else fp
        }) :+ List(
          FunctionParameter(
            "__return",
            CType.Pointer(bad.returnType),
            OriginalCType(bad.returnType, ""),
            true
          )
        ),
        ScalaFunctionBody.Delegate(
          invokes,
          Allocations(
            params = Set.empty,
            returnValue = false
          )
        ),
        public = true,
        variadic = bad.variadic,
        meta = Some(bad.meta)
      )

    }
  end if

  gen.result
end scalaPtrFunctions

private def cForwarderFunction(
    bad: Def.Function
)(using Config, AliasResolver): GeneratedFunction.CFunction =
  GeneratedFunction.CFunction(
    externFuncName(bad.name.into(CFunctionName)),
    bad.returnType,
    bad.originalCType,
    bad.parameters.toList,
    CFunctionBody.Delegate(
      bad.name.into(CFunctionName),
      bad.parameters.map(_.typ).zipWithIndex.toSet.flatMap { (p, i) =>
        if isDirectStructAccess(p) then Some(i)
        else None
      },
      isDirectStructAccess(bad.returnType)
    )
  )
