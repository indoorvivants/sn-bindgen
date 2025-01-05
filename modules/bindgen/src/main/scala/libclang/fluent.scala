package libclang
package fluent

import scala.annotation.targetName
import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*

extension (cxs: CXString)
  def string(using Zone): String =
    val orig = clang_getCString(cxs)
    val str = fromCString(orig)
    clang_disposeString(cxs)
    str

opaque type CXCursorVisitorPtr =
  CFuncPtr3[Ptr[CXCursor], Ptr[CXCursor], CXClientData, CXChildVisitResult]

object CXCursorVisitorPtr:
  inline def apply(
      inline visitor: CFuncPtr3[Ptr[CXCursor], Ptr[
        CXCursor
      ], CXClientData, CXChildVisitResult]
  ): CXCursorVisitorPtr = visitor
end CXCursorVisitorPtr

@extern
private[libclang] def __sn_wrap_clang_visitChildren(
    parent: Ptr[CXCursor],
    visitor: CXCursorVisitorPtr,
    data: CXClientData
): UInt = extern

def clang_visitChildren(
    parent: CXCursor,
    visitor: CXCursorVisitorPtr,
    data: CXClientData
)(using Zone): UInt =
  val __ptr_0: Ptr[CXCursor] = alloc[CXCursor](1)
  !(__ptr_0 + 0) = parent
  __sn_wrap_clang_visitChildren(
    (__ptr_0 + 0),
    visitor,
    data
  )
end clang_visitChildren

extension (cursor: CXCursor)
  def location(using Zone): CXSourceLocation = clang_getCursorLocation(cursor)
  def spelling(using Zone): String = clang_getCursorSpelling(cursor).string
  def tpe(using Zone): CXType = clang_getCursorType(cursor)

extension (cursorKind: CXCursorKind)
  def spelling(using Zone) = clang_getCursorKindSpelling(cursorKind).string

extension (tpe: CXType)
  @targetName("tpe_spelling")
  def spelling(using Zone): String = clang_getTypeSpelling(tpe).string
  def kindSpelling(using Zone): String = clang_getTypeKindSpelling(
    tpe.kind
  ).string

extension (loc: CXSourceLocation)
  def isFromMainFile(using Zone): Boolean =
    clang_Location_isFromMainFile(loc) == 1
  def isFromSystemHeader(using Zone): Boolean =
    clang_Location_isInSystemHeader(loc) == 1
  def getFilename(using Zone) =
    val file = stackalloc[CXFile](1)
    clang_getFileLocation(loc, file, null, null, null)
    clang_getFileName(!file).string
end extension

extension (cx: CXClientData.type)
  inline def wrap[T: Tag](ptr: Ptr[T]): CXClientData =
    CXClientData(ptr.asInstanceOf[Ptr[Byte]])

extension (cxd: CXClientData)
  inline def unwrap[T: Tag]: Ptr[T] = cxd.asInstanceOf[Ptr[T]]
