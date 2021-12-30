import scala.scalanative.unsafe.*

@main def hello =
  import libcjson as json

  val js = json.functions.cJSON_Parse(c"""{"hello": 25}""")

  val before = fromCString(json.functions.cJSON_Print(js))
  json.functions.cJSON_ReplaceItemInObjectCaseSensitive(
    js,
    c"hello",
    json.functions.cJSON_CreateFalse()
  )
  val after = fromCString(json.functions.cJSON_Print(js))
  println(s"Before: $before, after: $after")
end hello
