package bindgen
package rendering

import bindgen.{CType, MacroDefinition, ResolvedEnum, ResolvedStruct, *}
import opaque_newtypes.given
import bindgen.warning

// def renderBinding(
//     rawBinding: Binding,
//     outputMode: OutputMode
// )(using
//     Context,
//     Config
// ): RenderedOutput =
//   val binding = rawBinding.filterAll(shouldRender)

//   // In order
//   def anonymousEnumBases(struct: Def.Struct | Def.Union | Def.Enum) =
//     @annotation.tailrec
//     def go(
//         ls: List[Def.Struct | Def.Union | Def.Enum],
//         acc: Set[Option[CType.NumericIntegral]]
//     ): Set[Option[CType.NumericIntegral]] =
//       ls match
//         case Nil                   => acc
//         case (e: Def.Enum) :: rest => go(rest, acc + e.intType)
//         case (u: Def.Union) :: rest =>
//           go(u.anonymous ++ rest, acc)
//         case (u: Def.Struct) :: rest =>
//           go(u.anonymous ++ rest, acc)

//     go(List(struct), Set.empty)
//   end anonymousEnumBases

//   val enumBases =
//     binding.structs.flatMap(anonymousEnumBases) ++
//       binding.unions.flatMap(anonymousEnumBases) ++
//       binding.enums.flatMap(anonymousEnumBases)

//   val hasAnyEnums = enumBases.nonEmpty
//   val hasAnyTopLevelEnums = binding.enums.nonEmpty
//   val hasAliases = binding.aliases.nonEmpty
//   val hasUnions = binding.unions.nonEmpty
//   val hasStructs = binding.structs.nonEmpty
//   val hasConstants = binding.unnamedEnums.nonEmpty || binding.macros.nonEmpty
//   val hasAnyTypes = hasAnyEnums || hasAliases || hasUnions || hasStructs
//   val typeImports = TypeImports(
//     // We only need type imports for top level enums
//     anonEnums = hasAnyEnums && !hasAnyTopLevelEnums,
//     enums = hasAnyTopLevelEnums,
//     aliases = hasAliases,
//     structs = hasStructs,
//     unions = hasUnions
//   )

//   val multiFileMode = outputMode match
//     case _: OutputMode.MultiFile => true
//     case _                       => false

//   val exportMode = summon[Config].exportMode

//   val all = rawBinding.resolve

//   given AliasResolver =
//     AliasResolver.create(all)

//   val resolvedFunctions: scala.collection.mutable.Set[GeneratedFunction] =
//     deduplicateFunctions(binding.functions).flatMap(functionRewriter(_))

//   val resolvedStructs = all.collect { case rs: ResolvedStruct => rs }
//   val resolvedUnions = all.collect { case rs: ResolvedUnion => rs }
//   val resolvedEnums = all.collect { case rs: ResolvedEnum => rs }

//   def create(name: String)(subPackage: String = name) =
//     val lb = LineBuilder()
//     lb.appendLine(s"package $packageName")
//     lb.emptyLine
//     lb.append("""
//       |import _root_.scala.scalanative.unsafe.*
//       |import _root_.scala.scalanative.unsigned.*
//       |import _root_.scala.scalanative.libc.*
//       |import _root_.scala.scalanative.*
//       """.stripMargin.trim)
//     lb.emptyLines(2)

//     lb
//   end create

//   val scalaOutput = create("")()
//   val cOutput = LineBuilder()

//   val exports = List.newBuilder[(String, String)]

//   val multi =
//     collection.mutable.Map.empty[StreamName, LineBuilder]

//   val (stream, renderMode): ((String, String) => LineBuilder, RenderMode) =
//     if multiFileMode then
//       (
//         (str: String, packageName: String) =>
//           warning(s"Creating stream for $str")
//           multi.getOrElseUpdate(StreamName(str), create(str)(packageName))
//         ,
//         RenderMode.Files
//       )
//     else ((_: String, _: String) => scalaOutput, RenderMode.Objects)

//   val simpleStream = (name: String) => stream(name, name)

//   def updateExports(location: String, names: Seq[Exported]) =
//     exports ++= names.collect { case Exported.Yes(v) => v }.map(location -> _)

//   if summon[Context].lang == Lang.Scala then
//     if hasAnyEnums then
//       val enums = simpleStream("enumerations")
//       renderEnumPredef(enums, enumBases = enumBases, mode = renderMode)
//       updateExports(
//         "enumerations",
//         renderEnumerations(
//           enums,
//           resolvedEnums.sortBy(_.name.value).toList,
//           mode = renderMode
//         )
//       )
//     end if

//     if hasAliases then
//       updateExports(
//         "aliases",
//         renderAliases(
//           binding.aliases.toList.sortBy(_.name),
//           simpleStream("aliases"),
//           mode = renderMode,
//           typeImports
//         )
//       )
//     end if

//     if hasStructs then
//       updateExports(
//         "structs",
//         renderStructs(
//           resolvedStructs.toList.sortBy(_.name),
//           simpleStream("structs"),
//           mode = renderMode,
//           typeImports
//         )
//       )
//     end if

//     if hasUnions then
//       updateExports(
//         "unions",
//         renderUnions(
//           resolvedUnions.toList.sortBy(_.name),
//           simpleStream("unions"),
//           mode = renderMode,
//           typeImports
//         )
//       )
//     end if

//     if resolvedFunctions.exists(_.isInstanceOf[GeneratedFunction.ScalaFunction])
//     then
//       updateExports(
//         "functions",
//         ScalaFunctionsRenderer(
//           out = simpleStream("functions"),
//           functions = resolvedFunctions.toSet,
//           renderMode = renderMode,
//           // hasAnyTypes = hasAnyTypes,
//           typeImports = typeImports,
//           exportMode = exportMode
//         ).render()
//       )
//     end if
//   end if

//   val cFunctions = resolvedFunctions.collect {
//     case f: GeneratedFunction.CFunction => f
//   }

//   if cFunctions.nonEmpty && summon[Context].lang == Lang.C then
//     to(cOutput)("#include <string.h>")
//     summon[Config].cImports.foreach { s =>
//       to(cOutput)(s"#include \"$s\"")
//     }
//     cOutput.emptyLine

//     renderAll(cFunctions.toList.sortBy(_.name), cOutput, cFunctionForwarder)

//   end if

//   if hasConstants then
//     updateExports(
//       "constants",
//       renderConstants(
//         simpleStream("constants"),
//         binding.unnamedEnums.toList,
//         binding.macros,
//         mode = renderMode
//       )
//     )
//   end if

//   if !multiFileMode && hasAnyTypes then
//     val l = to(simpleStream("types"))
//     objectBlock(l)("object types") {
//       nest {
//         val l = to(simpleStream("types"))
//         if hasStructs then l(s"export _root_.${packageName}.structs.*")
//         if hasAliases then l(s"export _root_.${packageName}.aliases.*")
//         if hasUnions then l(s"export _root_.${packageName}.unions.*")
//         if hasAnyTopLevelEnums then
//           l(s"export _root_.${packageName}.enumerations.*")
//       }
//     }
//   end if

//   if !multiFileMode then
//     renderExports(simpleStream(s"all"), exports.result(), renderMode)

//   if multiFileMode then RenderedOutput.Multi(multi.toMap)
//   else if summon[Context].lang == Lang.C then RenderedOutput.Single(cOutput)
//   else RenderedOutput.Single(scalaOutput)
// end renderBinding

// private def commentException(element: Any, exc: Throwable) =
//   val stackTrace =
//     exc.getStackTrace.map("//    " + _.toString).mkString("\n")

//   throw exc
// end commentException

// private def renderAliases(
//     aliases: List[Def.Alias],
//     out: LineBuilder,
//     mode: RenderMode,
//     typeImports: TypeImports
// )(using Config, AliasResolver, Context) =
//   val exported = List.newBuilder[Exported]
//   maybeObjectBlock(out, mode)("object aliases") {
//     if mode == RenderMode.Objects then typeImports.render(out)
//     exported ++= renderAll(aliases, out, AliasRender(_, _).render())
//   }
//   exported.result()
// end renderAliases

// private def renderExports(
//     out: LineBuilder,
//     exports: List[(String, String)],
//     mode: RenderMode
// )(using Config, Context) =
//   mode match
//     case RenderMode.Objects =>
//       if exports.nonEmpty then
//         out.emptyLine
//         maybeObjectBlock(out, mode)("object all") {
//           exports.distinct.foreach { (scope, name) =>
//             to(out)(s"export _root_.$packageName.$scope.$name")
//           }
//         }
//     case RenderMode.Files =>
//       exports.distinct.foreach { (scope, name) =>
//         to(out)(s"export _root_.$packageName.$scope.$name")
//       }

// end renderExports

// private def renderUnions(
//     unions: List[ResolvedUnion],
//     out: LineBuilder,
//     mode: RenderMode,
//     typeImports: TypeImports
// )(using Config, AliasResolver, Context) =
//   val exported = List.newBuilder[Exported]
//   maybeObjectBlock(out, mode)("object unions") {
//     if mode == RenderMode.Objects then
//       typeImports.render(out)
//       out.emptyLine
//     exported ++= renderAll(unions, out, UnionRenderer(_, _).render())
//   }
//   exported.result()
// end renderUnions

// private def renderStructs(
//     structs: List[ResolvedStruct],
//     out: LineBuilder,
//     mode: RenderMode,
//     typeImports: TypeImports
// )(using Config, AliasResolver, Context) =
//   val exported = List.newBuilder[Exported]
//   maybeObjectBlock(out, mode)("object structs") {
//     if mode == RenderMode.Objects then
//       typeImports.render(out)
//       out.emptyLine
//     exported ++= renderAll(structs, out, struct)
//   }
//   exported.result()
// end renderStructs

// private def renderConstants(
//     out: LineBuilder,
//     enums: List[Def.Enum],
//     macros: List[MacroDefinition],
//     mode: RenderMode
// )(using Config, AliasResolver) =
//   val exported = List.newBuilder[Exported]
//   if enums.nonEmpty || macros.nonEmpty then
//     maybeObjectBlock(out, mode)("object constants") {
//       exported ++= constants(Constants(enums, macros), to(out))
//     }

//   exported.result()
// end renderConstants

// private def renderAll[
//     A <: (ResolvedEnum | Def.Alias | ResolvedStruct | ResolvedUnion |
//       GeneratedFunction)
// ](
//     defs: Seq[A],
//     out: LineBuilder,
//     how: (A, Appender) => Exported | Unit
// )(using Config): Seq[Exported] =
//   val exported = List.newBuilder[Exported]
//   defs.zipWithIndex.foreach { case (en, idx) =>
//     en match
//       case df: Def.Alias =>
//         trace(s"Rendering alias ${df.name}")
//       case df: ResolvedEnum =>
//         trace(s"Rendering enum ${df.name}")
//       case df: ResolvedStruct =>
//         trace(s"Rendering struct ${df.fqn}")
//       case df: ResolvedUnion =>
//         trace(s"Rendering union ${df.fqn}")
//       case sf: GeneratedFunction.ScalaFunction =>
//         trace(s"Rendering Scala function '${sf.name}'")
//       case sf: GeneratedFunction.CFunction =>
//         trace(s"Rendering C function '${sf.name}'")
//     end match
//     try
//       how(
//         en,
//         to(out)
//       ) match
//         case ()              =>
//         case other: Exported => exported.addOne(other)

//       out.emptyLine

//     catch exc => to(out)(commentException(en, exc))
//     end try

//   }
//   exported.result
// end renderAll

// private def enumPredef(
//     safePackageName: String,
//     base: Option[CType.NumericIntegral]
// )(using AliasResolver, Config) =
//   val intType: CType.NumericIntegral =
//     base.getOrElse(CType.NumericIntegral(IntegralBase.Int, SignType.Signed))
//   val renderedScalaType = scalaType(intType)
//   val renderedTagName =
//     val prefix = intType.sign match
//       case SignType.Signed   => ""
//       case SignType.Unsigned => "U"

//     val bs = intType.base match
//       case IntegralBase.Char     => "Byte"
//       case IntegralBase.Short    => "Short"
//       case IntegralBase.Int      => "Int"
//       case IntegralBase.Long     => "Long"
//       case IntegralBase.LongLong => "Long"

//     prefix + bs
//   end renderedTagName

//   val lb = LineBuilder()

//   val traitName = enumBaseTraitName(intType)

//   // TODO: remove reliance on `eq.apply`, use explicit `.asInstanceOf`
//   objectBlock(to(lb))(
//     s"private[${safePackageName}] trait $traitName[T](using eq: T =:= $renderedScalaType)"
//   ) {
//     to(lb)(s"given Tag[T] = Tag.$renderedTagName.asInstanceOf[Tag[T]]")
//     defBlock(to(lb))("extension (inline t: T)") {
//       to(lb)(
//         s"inline def value: $renderedScalaType = t.asInstanceOf[$renderedScalaType]"
//       )
//       if intType.base == IntegralBase.Int then
//         to(lb)(s"inline def int: CInt = value.toInt")
//       if intType.sign == SignType.Unsigned then
//         to(lb)(s"inline def uint: CUnsignedInt = value")
//     }
//   }
//   lb.result.linesIterator.toList
// end enumPredef

// private def renderEnumPredef(
//     out: LineBuilder,
//     enumBases: Set[Option[CType.NumericIntegral]],
//     mode: RenderMode
// )(using
//     Config,
//     AliasResolver,
//     Context
// ) =
//   maybeObjectBlock(out, mode)("object predef") {
//     val safePackageName = packageName.split('.').last
//     enumBases.foreach: base =>
//       enumPredef(safePackageName, base).foreach(to(out))
//   }

//   out.emptyLine
// end renderEnumPredef

// enum Stream:
//   case Single(out: LineBuilder)
//   case PerName(f: String => LineBuilder)

// private def renderEnumerations(
//     out: LineBuilder,
//     enums: List[ResolvedEnum],
//     mode: RenderMode
// )(using
//     Config,
//     AliasResolver,
//     Context
// ) =
//   warning(out.toString)
//   val enumBases = enums.map(_.intType).distinct.sorted

//   val exported = List.newBuilder[Exported]

//   if enumBases.nonEmpty then
//     if mode == RenderMode.Objects then out.emptyLine
//     maybeObjectBlock(out, mode)("object enumerations") {
//       if mode == RenderMode.Objects then to(out)("import predef.*")
//       exported ++= renderAll(
//         enums,
//         out,
//         EnumRenderer(_, _).render()
//       )
//     }

//   end if
//   exported.result()
// end renderEnumerations
