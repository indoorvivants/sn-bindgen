package bindgen

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

import CDefinition.*

class BindingBuilder(
    var named: mutable.Map[DefName, BindingDefinition] = mutable.Map.empty,
    var unnamed: ListBuffer[BindingDefinition] = ListBuffer.empty
):
  def add(item: CDefinition, location: Location) =
    item.defName.foreach { n =>
      named.addOne(n -> BindingDefinition(item, location))
    }
    if item.defName.isEmpty then unnamed += BindingDefinition(item, location)
    this

  def remove(name: DefName): BindingBuilder =
    named.remove(name)
    this

  def aliases: Set[CDefinition.Alias] = named.collect {
    case (k, BindingDefinition(item: CDefinition.Alias, _)) => item
  }.toSet

  def unions: Set[CDefinition.Union] = named.collect {
    case (k, BindingDefinition(item: CDefinition.Union, _)) => item
  }.toSet

  def structs: Set[CDefinition.Struct] = named.collect {
    case (k, BindingDefinition(item: CDefinition.Struct, _)) => item
  }.toSet

  def enums: Set[CDefinition.Enum] = named.collect {
    case (k, BindingDefinition(item: CDefinition.Enum, _)) => item
  }.toSet

  def unnamedEnums: Set[CDefinition.Enum] = unnamed.collect {
    case BindingDefinition(item: CDefinition.Enum, _) => item
  }.toSet

  def functions: Set[CDefinition.Function] = named.collect {
    case (k, BindingDefinition(item: CDefinition.Function, _)) => item
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
