package libclang

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*
import scala.annotation.compileTimeOnly

object types:
  import enumerations.*
  opaque type CXIndex = Ptr[Byte]
  opaque type CXTranslationUnit = Ptr[Byte] // TODO: refine
  opaque type CXUnsavedFile = CStruct3[CString, CString, ULong]

  object CXUnsafeFile:
    extension (cxuf: CXUnsavedFile)
      inline def Filename = cxuf._1
      inline def Context = cxuf._2
      inline def Length = cxuf._3

  abstract class Wrapper[T, W <: Ptr[T]](using tg: Tag[T]):
    given Tag[W] = Tag.Ptr(tg).asInstanceOf[Tag[W]]
    inline def allocate(inline n: CSSize)(using zone: Zone): W =
      alloc[T](n)(using tg, zone).asInstanceOf[W]

  opaque type CXCursorImpl =
    CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]

  opaque type CXCursor = Ptr[CXCursorImpl]
  object CXCursor extends Wrapper[CXCursorImpl, CXCursor]:
    val NULL: CXCursor = null
    extension (cursor: CXCursor)
      def kind: CXCursorKind = cursor._1
      def xdata: CInt = cursor._2

    given Tag[CXCursor] =
      Tag.Ptr(
        Tag
          .materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
      )
  end CXCursor

  opaque type CXStringImpl = CStruct2[Ptr[Byte], UInt]
  object CXStringImpl:
    given Tag[CXStringImpl] = Tag.materializeCStruct2Tag[Ptr[Byte], UInt]

  opaque type CXString = Ptr[CXStringImpl]
  object CXString extends Wrapper[CXStringImpl, CXString]:
    extension (cxs: CXString)
      def data: Ptr[Byte] = cxs._1
      def string(using Zone): String =
        val orig = defs.clang_getCString(cxs)
        val str = fromCString(orig)
        defs.clang_disposeString(cxs)
        str

  opaque type CXTypeImpl = CStruct2[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
  opaque type CXType = Ptr[CXTypeImpl]
  object CXType extends Wrapper[CXTypeImpl, CXType]:
    extension (t: CXType) def kind: CXTypeKind = t._1

  opaque type CXSourceLocationImpl = CStruct2[CArray[Ptr[Byte], Nat._2], Int]
  opaque type CXSourceLocation = Ptr[CXSourceLocationImpl]
  object CXSourceLocation
      extends Wrapper[CXSourceLocationImpl, CXSourceLocation]

  opaque type CXClientData = Ptr[Byte]
  object CXClientData:
    val NULL: CXClientData = null
    def wrap[T: Tag](ptr: Ptr[T]): CXClientData = ptr.asInstanceOf[Ptr[Byte]]

    extension (cxd: CXClientData)
      def unwrap[T: Tag]: Ptr[T] = cxd.asInstanceOf[Ptr[T]]

    given Tag[CXClientData] =
      Tag.materializePtrTag[Byte](using Tag.Byte)

  // TODO: this needs to be near the `CXCursorVisitor` for it to compile
  opaque type CXChildVisitResult = Int
  object CXChildVisitResult extends CEnum[CXChildVisitResult]:
    val CXChildVisit_Break: CXChildVisitResult = 0
    val CXChildVisit_Continue: CXChildVisitResult = 1
    val CXChildVisit_Recurse: CXChildVisitResult = 2

  opaque type CXCursorVisitor =
    CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]

  object CXCursorVisitor:
    inline def apply(
        inline f: (CXCursor, CXCursor, CXClientData) => CXChildVisitResult
    ): CXCursorVisitor = CFuncPtr3.fromScalaFunction(f)

  opaque type CXErrorCode = Int
  object CXErrorCode extends CEnum[CXErrorCode]:
    val CXError_Success: CXErrorCode = 0
    val CXError_Failure: CXErrorCode = 1
    val CXError_Crashed: CXErrorCode = 2
    val CXError_InvalidArgument: CXErrorCode = 3
    val CXError_ASTReadError: CXErrorCode = 4

  // opaque type CXDiagnosticDisplayOptions = CUnsignedInt
  // object CXDiagnosticDisplayOptions extends CEnumU[CXDiagnosticDisplayOptions]:
  //   inline def define(inline a: Long): CXDiagnosticDisplayOptions = a.toUInt
  //   val CXDiagnostic_DisplaySourceLocation = define(1)
  //   val CXDiagnostic_DisplayColumn = define(2)
  //   val CXDiagnostic_DisplaySourceRanges = define(4)
  //   val CXDiagnostic_DisplayOption = define(8)
  //   val CXDiagnostic_DisplayCategoryId = define(16)
  //   val CXDiagnostic_DisplayCategoryName = define(32)

  // opaque type CXDiagnosticSeverity = CUnsignedInt
  // object CXDiagnosticSeverity extends CEnumU[CXDiagnosticSeverity]:
  //   inline def define(inline a: Long): CXDiagnosticSeverity = a.toUInt
  //   val CXDiagnostic_Ignored = define(0)
  //   val CXDiagnostic_Note = define(1)
  //   val CXDiagnostic_Warning = define(2)
  //   val CXDiagnostic_Error = define(3)
  //   val CXDiagnostic_Fatal = define(4)

  opaque type CXDiagnostic = Ptr[Byte]
  object CXDiagnostic:
    given _tag: Tag[CXDiagnostic] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXDiagnostic = o

  opaque type CXDiagnosticSet = Ptr[Byte]
  object CXDiagnosticSet:
    given _tag: Tag[CXDiagnosticSet] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXDiagnosticSet = o
end types
