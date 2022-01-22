package bindgen
package rendering

import scala.collection.mutable.ListBuffer

def isDirectStructAccess(typ: CType)(using AliasResolver): Boolean =
  import CType.*
  typ match
    case _: Struct  => true
    case _: Pointer => false
    case Reference(Name.Model(name)) =>
      isDirectStructAccess(aliasResolver(name))
    case _ => false

case class Allocations(
    params: Set[Int],
    returnValue: Boolean
):
  def hasAny: Boolean = params.nonEmpty || returnValue

enum ScalaFunctionBody:
  case Extern
  case Delegate(to: String, allocations: Allocations)

enum CFunctionBody:
  case Delegate(to: String, dereference: Set[Int], returnAsWell: Boolean)

enum GeneratedFunction:
  case ScalaFunction(
      name: String,
      returnType: CType,
      arguments: List[List[FunctionParameter]],
      body: ScalaFunctionBody,
      public: Boolean
  )

  case CFunction(
      name: String,
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
    externFuncName(bad.name),
    returnType,
    List(parameters.result),
    ScalaFunctionBody.Extern,
    public = false
  )
end scalaForwarderFunction

private def scalaAllocatingFunction(bad: Def.Function)(using
    Config,
    AliasResolver
): GeneratedFunction.ScalaFunction =
  val invokes = externFuncName(bad.name)
  GeneratedFunction.ScalaFunction(
    bad.name,
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
    public = true
  )
end scalaAllocatingFunction

private def scalaPtrFunctions(bad: Def.Function)(using
    Config,
    AliasResolver
): List[GeneratedFunction] =
  val invokes = externFuncName(bad.name)
  val returnAsWell = isDirectStructAccess(bad.returnType)

  val gen = List.newBuilder[GeneratedFunction]
  gen.addOne {
    GeneratedFunction.ScalaFunction(
      bad.name,
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
      public = true
    )
  }

  if returnAsWell then
    gen.addOne {
      GeneratedFunction.ScalaFunction(
        bad.name,
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
        public = true
      )

    }
  end if

  gen.result
end scalaPtrFunctions

private def cForwarderFunction(
    bad: Def.Function
)(using Config, AliasResolver): GeneratedFunction.CFunction =
  GeneratedFunction.CFunction(
    externFuncName(bad.name),
    bad.returnType,
    bad.originalCType,
    bad.parameters.toList,
    CFunctionBody.Delegate(
      bad.name,
      bad.parameters.map(_.typ).zipWithIndex.toSet.flatMap { (p, i) =>
        if isDirectStructAccess(p) then Some(i)
        else None
      },
      isDirectStructAccess(bad.returnType)
    )
  )

def functionRewriter(badFunction: Def.Function)(using
    AliasResolver,
    Config
): Seq[GeneratedFunction] =
  val isReturnTypeAStruct = isDirectStructAccess(badFunction.returnType)
  val anyParameterIsAStruct =
    badFunction.parameters.map(_._2).exists(isDirectStructAccess)

  if isReturnTypeAStruct || anyParameterIsAStruct then
    // we will generate three functions
    val generated = Seq.newBuilder[GeneratedFunction]
    // 1. a private Scala forwarder function
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
        badFunction.name,
        badFunction.returnType,
        List(badFunction.parameters.toList),
        ScalaFunctionBody.Extern,
        public = true
      )
    )
  end if

end functionRewriter
