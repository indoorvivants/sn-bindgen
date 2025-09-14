package analysis

enum LoggingContext:
  case NoContext
  case In(crumbs: Seq[Breadcrumb])

enum Id:
  case Anon(idx: Option[Int])
  case Named(name: String)

enum Breadcrumb:
  case Struct(name: Id)
  case Enum(name: Id)
  case Field(name: Id)
