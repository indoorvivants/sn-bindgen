package bindgen

import bindgen.CType.Parameter
import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.scalanative.unsafe.Tag
import scala.scalanative.unsigned.ULong
import Def.*
import CType.*

class BindingBuilder(
    var named: mutable.Map[DefName, BindingDefinition] = mutable.Map.empty,
    var unnamed: ListBuffer[BindingDefinition] = ListBuffer.empty
):
  def add(item: Def, isFromMainFile: Boolean) =
    item.defName.foreach { n =>
      named.addOne(n -> BindingDefinition(item, isFromMainFile))
    }
    if item.defName.isEmpty then
      unnamed += BindingDefinition(item, isFromMainFile)
    this

  def remove(name: DefName): BindingBuilder =
    named.remove(name)
    this

  def aliases: Set[Def.Alias] = named.collect {
    case (k, BindingDefinition(item: Def.Alias, _)) => item
  }.toSet

  def unions: Set[Def.Union] = named.collect {
    case (k, BindingDefinition(item: Def.Union, _)) => item
  }.toSet

  def structs: Set[Def.Struct] = named.collect {
    case (k, BindingDefinition(item: Def.Struct, _)) => item
  }.toSet

  def enums: Set[Def.Enum] = named.collect {
    case (k, BindingDefinition(item: Def.Enum, _)) => item
  }.toSet

  def unnamedEnums: Set[Def.Enum] = unnamed.collect {
    case BindingDefinition(item: Def.Enum, _) => item
  }.toSet

  def functions: Set[Def.Function] = named.collect {
    case (k, BindingDefinition(item: Def.Function, _)) => item
  }.toSet

  def build: Binding =
    Binding(
      aliases = this.aliases,
      unions = this.unions,
      structs = this.structs,
      functions = this.functions,
      enums = this.enums,
      unnamedEnums = this.unnamedEnums
    )
end BindingBuilder
