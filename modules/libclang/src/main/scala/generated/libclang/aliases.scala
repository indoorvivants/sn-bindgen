package libclang
package aliases

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

import _root_.libclang.enumerations.*
import _root_.libclang.aliases.*
import _root_.libclang.structs.*

opaque type CXClientData = Ptr[Byte]
object CXClientData:
  given _tag: Tag[CXClientData] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXClientData = o
  extension (v: CXClientData) inline def value: Ptr[Byte] = v

opaque type CXCompletionString = Ptr[Byte]
object CXCompletionString:
  given _tag: Tag[CXCompletionString] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXCompletionString = o
  extension (v: CXCompletionString) inline def value: Ptr[Byte] = v

type CXCursorAndRangeVisitorBlock = Unit
object CXCursorAndRangeVisitorBlock:
  given _tag: Tag[CXCursorAndRangeVisitorBlock] = Tag.Unit
  inline def apply(inline o: Unit): CXCursorAndRangeVisitorBlock = o
  extension (v: CXCursorAndRangeVisitorBlock) inline def value: Unit = v

opaque type CXCursorSet = Ptr[CXCursorSetImpl]
object CXCursorSet:
  given _tag: Tag[CXCursorSet] = Tag.Ptr[CXCursorSetImpl](CXCursorSetImpl._tag)
  inline def apply(inline o: Ptr[CXCursorSetImpl]): CXCursorSet = o
  extension (v: CXCursorSet) inline def value: Ptr[CXCursorSetImpl] = v

opaque type CXCursorVisitor =
  CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]
object CXCursorVisitor:
  given _tag: Tag[CXCursorVisitor] = Tag
    .materializeCFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]
  inline def apply(
      inline o: CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]
  ): CXCursorVisitor = o
  extension (v: CXCursorVisitor)
    inline def value
        : CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult] = v

type CXCursorVisitorBlock = Unit
object CXCursorVisitorBlock:
  given _tag: Tag[CXCursorVisitorBlock] = Tag.Unit
  inline def apply(inline o: Unit): CXCursorVisitorBlock = o
  extension (v: CXCursorVisitorBlock) inline def value: Unit = v

opaque type CXDiagnostic = Ptr[Byte]
object CXDiagnostic:
  given _tag: Tag[CXDiagnostic] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXDiagnostic = o
  extension (v: CXDiagnostic) inline def value: Ptr[Byte] = v

opaque type CXDiagnosticSet = Ptr[Byte]
object CXDiagnosticSet:
  given _tag: Tag[CXDiagnosticSet] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXDiagnosticSet = o
  extension (v: CXDiagnosticSet) inline def value: Ptr[Byte] = v

opaque type CXEvalResult = Ptr[Byte]
object CXEvalResult:
  given _tag: Tag[CXEvalResult] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXEvalResult = o
  extension (v: CXEvalResult) inline def value: Ptr[Byte] = v

opaque type CXFieldVisitor = CFuncPtr2[CXCursor, CXClientData, CXVisitorResult]
object CXFieldVisitor:
  given _tag: Tag[CXFieldVisitor] =
    Tag.materializeCFuncPtr2[CXCursor, CXClientData, CXVisitorResult]
  inline def apply(
      inline o: CFuncPtr2[CXCursor, CXClientData, CXVisitorResult]
  ): CXFieldVisitor = o
  extension (v: CXFieldVisitor)
    inline def value: CFuncPtr2[CXCursor, CXClientData, CXVisitorResult] = v

opaque type CXFile = Ptr[Byte]
object CXFile:
  given _tag: Tag[CXFile] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXFile = o
  extension (v: CXFile) inline def value: Ptr[Byte] = v

opaque type CXIdxClientASTFile = Ptr[Byte]
object CXIdxClientASTFile:
  given _tag: Tag[CXIdxClientASTFile] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXIdxClientASTFile = o
  extension (v: CXIdxClientASTFile) inline def value: Ptr[Byte] = v

opaque type CXIdxClientContainer = Ptr[Byte]
object CXIdxClientContainer:
  given _tag: Tag[CXIdxClientContainer] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXIdxClientContainer = o
  extension (v: CXIdxClientContainer) inline def value: Ptr[Byte] = v

opaque type CXIdxClientEntity = Ptr[Byte]
object CXIdxClientEntity:
  given _tag: Tag[CXIdxClientEntity] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXIdxClientEntity = o
  extension (v: CXIdxClientEntity) inline def value: Ptr[Byte] = v

opaque type CXIdxClientFile = Ptr[Byte]
object CXIdxClientFile:
  given _tag: Tag[CXIdxClientFile] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXIdxClientFile = o
  extension (v: CXIdxClientFile) inline def value: Ptr[Byte] = v

opaque type CXInclusionVisitor =
  CFuncPtr4[CXFile, Ptr[CXSourceLocation], CUnsignedInt, CXClientData, Unit]
object CXInclusionVisitor:
  given _tag: Tag[CXInclusionVisitor] = Tag.materializeCFuncPtr4[CXFile, Ptr[
    CXSourceLocation
  ], CUnsignedInt, CXClientData, Unit]
  inline def apply(
      inline o: CFuncPtr4[CXFile, Ptr[
        CXSourceLocation
      ], CUnsignedInt, CXClientData, Unit]
  ): CXInclusionVisitor = o
  extension (v: CXInclusionVisitor)
    inline def value: CFuncPtr4[CXFile, Ptr[
      CXSourceLocation
    ], CUnsignedInt, CXClientData, Unit] = v
end CXInclusionVisitor

opaque type CXIndex = Ptr[Byte]
object CXIndex:
  given _tag: Tag[CXIndex] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXIndex = o
  extension (v: CXIndex) inline def value: Ptr[Byte] = v

opaque type CXIndexAction = Ptr[Byte]
object CXIndexAction:
  given _tag: Tag[CXIndexAction] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXIndexAction = o
  extension (v: CXIndexAction) inline def value: Ptr[Byte] = v

opaque type CXModule = Ptr[Byte]
object CXModule:
  given _tag: Tag[CXModule] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXModule = o
  extension (v: CXModule) inline def value: Ptr[Byte] = v

opaque type CXModuleMapDescriptor = Ptr[CXModuleMapDescriptorImpl]
object CXModuleMapDescriptor:
  given _tag: Tag[CXModuleMapDescriptor] =
    Tag.Ptr[CXModuleMapDescriptorImpl](CXModuleMapDescriptorImpl._tag)
  inline def apply(
      inline o: Ptr[CXModuleMapDescriptorImpl]
  ): CXModuleMapDescriptor = o
  extension (v: CXModuleMapDescriptor)
    inline def value: Ptr[CXModuleMapDescriptorImpl] = v

opaque type CXPrintingPolicy = Ptr[Byte]
object CXPrintingPolicy:
  given _tag: Tag[CXPrintingPolicy] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXPrintingPolicy = o
  extension (v: CXPrintingPolicy) inline def value: Ptr[Byte] = v

opaque type CXRemapping = Ptr[Byte]
object CXRemapping:
  given _tag: Tag[CXRemapping] = Tag.Ptr(Tag.Byte)
  inline def apply(inline o: Ptr[Byte]): CXRemapping = o
  extension (v: CXRemapping) inline def value: Ptr[Byte] = v

opaque type CXTargetInfo = Ptr[CXTargetInfoImpl]
object CXTargetInfo:
  given _tag: Tag[CXTargetInfo] =
    Tag.Ptr[CXTargetInfoImpl](CXTargetInfoImpl._tag)
  inline def apply(inline o: Ptr[CXTargetInfoImpl]): CXTargetInfo = o
  extension (v: CXTargetInfo) inline def value: Ptr[CXTargetInfoImpl] = v

opaque type CXTranslationUnit = Ptr[CXTranslationUnitImpl]
object CXTranslationUnit:
  given _tag: Tag[CXTranslationUnit] =
    Tag.Ptr[CXTranslationUnitImpl](CXTranslationUnitImpl._tag)
  inline def apply(inline o: Ptr[CXTranslationUnitImpl]): CXTranslationUnit = o
  extension (v: CXTranslationUnit)
    inline def value: Ptr[CXTranslationUnitImpl] = v

opaque type CXVirtualFileOverlay = Ptr[CXVirtualFileOverlayImpl]
object CXVirtualFileOverlay:
  given _tag: Tag[CXVirtualFileOverlay] =
    Tag.Ptr[CXVirtualFileOverlayImpl](CXVirtualFileOverlayImpl._tag)
  inline def apply(
      inline o: Ptr[CXVirtualFileOverlayImpl]
  ): CXVirtualFileOverlay = o
  extension (v: CXVirtualFileOverlay)
    inline def value: Ptr[CXVirtualFileOverlayImpl] = v

type size_t = libc.stddef.size_t
object size_t:
  val _tag: Tag[size_t] = summon[Tag[libc.stddef.size_t]]
  inline def apply(inline o: libc.stddef.size_t): size_t = o
  extension (v: size_t) inline def value: libc.stddef.size_t = v

type time_t = posix.sys.types.time_t
object time_t:
  val _tag: Tag[time_t] = summon[Tag[posix.sys.types.time_t]]
  inline def apply(inline o: posix.sys.types.time_t): time_t = o
  extension (v: time_t) inline def value: posix.sys.types.time_t = v
