package libclang
package structs

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

import _root_.libclang.enumerations.*
import _root_.libclang.aliases.*
import _root_.libclang.structs.*

/** Contains the results of code-completion.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXCodeCompleteResults =
  CStruct2[Ptr[CXCompletionResult], CUnsignedInt]
object CXCodeCompleteResults:
  given _tag: Tag[CXCodeCompleteResults] =
    Tag.materializeCStruct2Tag[Ptr[CXCompletionResult], CUnsignedInt]
  def apply()(using Zone): Ptr[CXCodeCompleteResults] =
    scala.scalanative.unsafe.alloc[CXCodeCompleteResults](1)
  def apply(Results: Ptr[CXCompletionResult], NumResults: CUnsignedInt)(using
      Zone
  ): Ptr[CXCodeCompleteResults] =
    val ____ptr = apply()
    (!____ptr).Results = Results
    (!____ptr).NumResults = NumResults
    ____ptr
  extension (struct: CXCodeCompleteResults)
    def Results: Ptr[CXCompletionResult] = struct._1
    def Results_=(value: Ptr[CXCompletionResult]): Unit = !struct.at1 = value
    def NumResults: CUnsignedInt = struct._2
    def NumResults_=(value: CUnsignedInt): Unit = !struct.at2 = value
end CXCodeCompleteResults

/** A single result of code completion.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXCompletionResult = CStruct2[CXCursorKind, CXCompletionString]
object CXCompletionResult:
  given _tag: Tag[CXCompletionResult] =
    Tag.materializeCStruct2Tag[CXCursorKind, CXCompletionString]
  def apply()(using Zone): Ptr[CXCompletionResult] =
    scala.scalanative.unsafe.alloc[CXCompletionResult](1)
  def apply(CursorKind: CXCursorKind, CompletionString: CXCompletionString)(
      using Zone
  ): Ptr[CXCompletionResult] =
    val ____ptr = apply()
    (!____ptr).CursorKind = CursorKind
    (!____ptr).CompletionString = CompletionString
    ____ptr
  extension (struct: CXCompletionResult)
    def CursorKind: CXCursorKind = struct._1
    def CursorKind_=(value: CXCursorKind): Unit = !struct.at1 = value
    def CompletionString: CXCompletionString = struct._2
    def CompletionString_=(value: CXCompletionString): Unit = !struct.at2 =
      value
end CXCompletionResult

/** A cursor representing some element in the abstract syntax tree for a
  * translation unit.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXCursor = CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
object CXCursor:
  given _tag: Tag[CXCursor] =
    Tag.materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
  def apply()(using Zone): Ptr[CXCursor] =
    scala.scalanative.unsafe.alloc[CXCursor](1)
  def apply(kind: CXCursorKind, xdata: CInt, data: CArray[Ptr[Byte], Nat._3])(
      using Zone
  ): Ptr[CXCursor] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).xdata = xdata
    (!____ptr).data = data
    ____ptr
  extension (struct: CXCursor)
    def kind: CXCursorKind = struct._1
    def kind_=(value: CXCursorKind): Unit = !struct.at1 = value
    def xdata: CInt = struct._2
    def xdata_=(value: CInt): Unit = !struct.at2 = value
    def data: CArray[Ptr[Byte], Nat._3] = struct._3
    def data_=(value: CArray[Ptr[Byte], Nat._3]): Unit = !struct.at3 = value
end CXCursor

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXCursorAndRangeVisitor = CStruct2[Ptr[Byte], CFuncPtr3[Ptr[
  Byte
], CXCursor, CXSourceRange, CXVisitorResult]]
object CXCursorAndRangeVisitor:
  given _tag: Tag[CXCursorAndRangeVisitor] = Tag.materializeCStruct2Tag[Ptr[
    Byte
  ], CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]]
  def apply()(using Zone): Ptr[CXCursorAndRangeVisitor] =
    scala.scalanative.unsafe.alloc[CXCursorAndRangeVisitor](1)
  def apply(
      context: Ptr[Byte],
      visit: CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]
  )(using Zone): Ptr[CXCursorAndRangeVisitor] =
    val ____ptr = apply()
    (!____ptr).context = context
    (!____ptr).visit = visit
    ____ptr
  extension (struct: CXCursorAndRangeVisitor)
    def context: Ptr[Byte] = struct._1
    def context_=(value: Ptr[Byte]): Unit = !struct.at1 = value
    def visit: CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult] =
      struct._2
    def visit_=(
        value: CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]
    ): Unit = !struct.at2 = value
end CXCursorAndRangeVisitor

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXCursorSetImpl = CStruct0
object CXCursorSetImpl:
  given _tag: Tag[CXCursorSetImpl] = Tag.materializeCStruct0Tag

/** Uniquely identifies a CXFile, that refers to the same underlying file,
  * across an indexing session.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXFileUniqueID = CStruct1[CArray[CUnsignedLongLong, Nat._3]]
object CXFileUniqueID:
  given _tag: Tag[CXFileUniqueID] =
    Tag.materializeCStruct1Tag[CArray[CUnsignedLongLong, Nat._3]]
  def apply()(using Zone): Ptr[CXFileUniqueID] =
    scala.scalanative.unsafe.alloc[CXFileUniqueID](1)
  def apply(data: CArray[CUnsignedLongLong, Nat._3])(using
      Zone
  ): Ptr[CXFileUniqueID] =
    val ____ptr = apply()
    (!____ptr).data = data
    ____ptr
  extension (struct: CXFileUniqueID)
    def data: CArray[CUnsignedLongLong, Nat._3] = struct._1
    def data_=(value: CArray[CUnsignedLongLong, Nat._3]): Unit = !struct.at1 =
      value
end CXFileUniqueID

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxAttrInfo = CStruct3[CXIdxAttrKind, CXCursor, CXIdxLoc]
object CXIdxAttrInfo:
  given _tag: Tag[CXIdxAttrInfo] =
    Tag.materializeCStruct3Tag[CXIdxAttrKind, CXCursor, CXIdxLoc]
  def apply()(using Zone): Ptr[CXIdxAttrInfo] =
    scala.scalanative.unsafe.alloc[CXIdxAttrInfo](1)
  def apply(kind: CXIdxAttrKind, cursor: CXCursor, loc: CXIdxLoc)(using
      Zone
  ): Ptr[CXIdxAttrInfo] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    ____ptr
  extension (struct: CXIdxAttrInfo)
    def kind: CXIdxAttrKind = struct._1
    def kind_=(value: CXIdxAttrKind): Unit = !struct.at1 = value
    def cursor: CXCursor = struct._2
    def cursor_=(value: CXCursor): Unit = !struct.at2 = value
    def loc: CXIdxLoc = struct._3
    def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
end CXIdxAttrInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxBaseClassInfo =
  CStruct3[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
object CXIdxBaseClassInfo:
  given _tag: Tag[CXIdxBaseClassInfo] =
    Tag.materializeCStruct3Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
  def apply()(using Zone): Ptr[CXIdxBaseClassInfo] =
    scala.scalanative.unsafe.alloc[CXIdxBaseClassInfo](1)
  def apply(base: Ptr[CXIdxEntityInfo], cursor: CXCursor, loc: CXIdxLoc)(using
      Zone
  ): Ptr[CXIdxBaseClassInfo] =
    val ____ptr = apply()
    (!____ptr).base = base
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    ____ptr
  extension (struct: CXIdxBaseClassInfo)
    def base: Ptr[CXIdxEntityInfo] = struct._1
    def base_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at1 = value
    def cursor: CXCursor = struct._2
    def cursor_=(value: CXCursor): Unit = !struct.at2 = value
    def loc: CXIdxLoc = struct._3
    def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
end CXIdxBaseClassInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxCXXClassDeclInfo =
  CStruct3[Ptr[CXIdxDeclInfo], Ptr[Ptr[CXIdxBaseClassInfo]], CUnsignedInt]
object CXIdxCXXClassDeclInfo:
  given _tag: Tag[CXIdxCXXClassDeclInfo] = Tag.materializeCStruct3Tag[Ptr[
    CXIdxDeclInfo
  ], Ptr[Ptr[CXIdxBaseClassInfo]], CUnsignedInt]
  def apply()(using Zone): Ptr[CXIdxCXXClassDeclInfo] =
    scala.scalanative.unsafe.alloc[CXIdxCXXClassDeclInfo](1)
  def apply(
      declInfo: Ptr[CXIdxDeclInfo],
      bases: Ptr[Ptr[CXIdxBaseClassInfo]],
      numBases: CUnsignedInt
  )(using Zone): Ptr[CXIdxCXXClassDeclInfo] =
    val ____ptr = apply()
    (!____ptr).declInfo = declInfo
    (!____ptr).bases = bases
    (!____ptr).numBases = numBases
    ____ptr
  end apply
  extension (struct: CXIdxCXXClassDeclInfo)
    def declInfo: Ptr[CXIdxDeclInfo] = struct._1
    def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
    def bases: Ptr[Ptr[CXIdxBaseClassInfo]] = struct._2
    def bases_=(value: Ptr[Ptr[CXIdxBaseClassInfo]]): Unit = !struct.at2 = value
    def numBases: CUnsignedInt = struct._3
    def numBases_=(value: CUnsignedInt): Unit = !struct.at3 = value
end CXIdxCXXClassDeclInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxContainerInfo = CStruct1[CXCursor]
object CXIdxContainerInfo:
  given _tag: Tag[CXIdxContainerInfo] = Tag.materializeCStruct1Tag[CXCursor]
  def apply()(using Zone): Ptr[CXIdxContainerInfo] =
    scala.scalanative.unsafe.alloc[CXIdxContainerInfo](1)
  def apply(cursor: CXCursor)(using Zone): Ptr[CXIdxContainerInfo] =
    val ____ptr = apply()
    (!____ptr).cursor = cursor
    ____ptr
  extension (struct: CXIdxContainerInfo)
    def cursor: CXCursor = struct._1
    def cursor_=(value: CXCursor): Unit = !struct.at1 = value
end CXIdxContainerInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxDeclInfo =
  CStruct13[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[
    CXIdxContainerInfo
  ], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[
    CXIdxContainerInfo
  ], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]
object CXIdxDeclInfo:
  given _tag: Tag[CXIdxDeclInfo] =
    Tag.materializeCStruct13Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[
      CXIdxContainerInfo
    ], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[
      CXIdxContainerInfo
    ], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]
  def apply()(using Zone): Ptr[CXIdxDeclInfo] =
    scala.scalanative.unsafe.alloc[CXIdxDeclInfo](1)
  def apply(
      entityInfo: Ptr[CXIdxEntityInfo],
      cursor: CXCursor,
      loc: CXIdxLoc,
      semanticContainer: Ptr[CXIdxContainerInfo],
      lexicalContainer: Ptr[CXIdxContainerInfo],
      isRedeclaration: CInt,
      isDefinition: CInt,
      isContainer: CInt,
      declAsContainer: Ptr[CXIdxContainerInfo],
      isImplicit: CInt,
      attributes: Ptr[Ptr[CXIdxAttrInfo]],
      numAttributes: CUnsignedInt,
      flags: CUnsignedInt
  )(using Zone): Ptr[CXIdxDeclInfo] =
    val ____ptr = apply()
    (!____ptr).entityInfo = entityInfo
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    (!____ptr).semanticContainer = semanticContainer
    (!____ptr).lexicalContainer = lexicalContainer
    (!____ptr).isRedeclaration = isRedeclaration
    (!____ptr).isDefinition = isDefinition
    (!____ptr).isContainer = isContainer
    (!____ptr).declAsContainer = declAsContainer
    (!____ptr).isImplicit = isImplicit
    (!____ptr).attributes = attributes
    (!____ptr).numAttributes = numAttributes
    (!____ptr).flags = flags
    ____ptr
  end apply
  extension (struct: CXIdxDeclInfo)
    def entityInfo: Ptr[CXIdxEntityInfo] = struct._1
    def entityInfo_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at1 = value
    def cursor: CXCursor = struct._2
    def cursor_=(value: CXCursor): Unit = !struct.at2 = value
    def loc: CXIdxLoc = struct._3
    def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
    def semanticContainer: Ptr[CXIdxContainerInfo] = struct._4
    def semanticContainer_=(value: Ptr[CXIdxContainerInfo]): Unit =
      !struct.at4 = value
    def lexicalContainer: Ptr[CXIdxContainerInfo] = struct._5
    def lexicalContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at5 =
      value
    def isRedeclaration: CInt = struct._6
    def isRedeclaration_=(value: CInt): Unit = !struct.at6 = value
    def isDefinition: CInt = struct._7
    def isDefinition_=(value: CInt): Unit = !struct.at7 = value
    def isContainer: CInt = struct._8
    def isContainer_=(value: CInt): Unit = !struct.at8 = value
    def declAsContainer: Ptr[CXIdxContainerInfo] = struct._9
    def declAsContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at9 =
      value
    def isImplicit: CInt = struct._10
    def isImplicit_=(value: CInt): Unit = !struct.at10 = value
    def attributes: Ptr[Ptr[CXIdxAttrInfo]] = struct._11
    def attributes_=(value: Ptr[Ptr[CXIdxAttrInfo]]): Unit = !struct.at11 =
      value
    def numAttributes: CUnsignedInt = struct._12
    def numAttributes_=(value: CUnsignedInt): Unit = !struct.at12 = value
    def flags: CUnsignedInt = struct._13
    def flags_=(value: CUnsignedInt): Unit = !struct.at13 = value
  end extension
end CXIdxDeclInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxEntityInfo = CStruct8[
  CXIdxEntityKind,
  CXIdxEntityCXXTemplateKind,
  CXIdxEntityLanguage,
  CString,
  CString,
  CXCursor,
  Ptr[Ptr[CXIdxAttrInfo]],
  CUnsignedInt
]
object CXIdxEntityInfo:
  given _tag: Tag[CXIdxEntityInfo] = Tag.materializeCStruct8Tag[
    CXIdxEntityKind,
    CXIdxEntityCXXTemplateKind,
    CXIdxEntityLanguage,
    CString,
    CString,
    CXCursor,
    Ptr[Ptr[CXIdxAttrInfo]],
    CUnsignedInt
  ]
  def apply()(using Zone): Ptr[CXIdxEntityInfo] =
    scala.scalanative.unsafe.alloc[CXIdxEntityInfo](1)
  def apply(
      kind: CXIdxEntityKind,
      templateKind: CXIdxEntityCXXTemplateKind,
      lang: CXIdxEntityLanguage,
      name: CString,
      USR: CString,
      cursor: CXCursor,
      attributes: Ptr[Ptr[CXIdxAttrInfo]],
      numAttributes: CUnsignedInt
  )(using Zone): Ptr[CXIdxEntityInfo] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).templateKind = templateKind
    (!____ptr).lang = lang
    (!____ptr).name = name
    (!____ptr).USR = USR
    (!____ptr).cursor = cursor
    (!____ptr).attributes = attributes
    (!____ptr).numAttributes = numAttributes
    ____ptr
  end apply
  extension (struct: CXIdxEntityInfo)
    def kind: CXIdxEntityKind = struct._1
    def kind_=(value: CXIdxEntityKind): Unit = !struct.at1 = value
    def templateKind: CXIdxEntityCXXTemplateKind = struct._2
    def templateKind_=(value: CXIdxEntityCXXTemplateKind): Unit = !struct.at2 =
      value
    def lang: CXIdxEntityLanguage = struct._3
    def lang_=(value: CXIdxEntityLanguage): Unit = !struct.at3 = value
    def name: CString = struct._4
    def name_=(value: CString): Unit = !struct.at4 = value
    def USR: CString = struct._5
    def USR_=(value: CString): Unit = !struct.at5 = value
    def cursor: CXCursor = struct._6
    def cursor_=(value: CXCursor): Unit = !struct.at6 = value
    def attributes: Ptr[Ptr[CXIdxAttrInfo]] = struct._7
    def attributes_=(value: Ptr[Ptr[CXIdxAttrInfo]]): Unit = !struct.at7 = value
    def numAttributes: CUnsignedInt = struct._8
    def numAttributes_=(value: CUnsignedInt): Unit = !struct.at8 = value
  end extension
end CXIdxEntityInfo

/** Data for IndexerCallbacks#indexEntityReference.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxEntityRefInfo =
  CStruct7[CXIdxEntityRefKind, CXCursor, CXIdxLoc, Ptr[CXIdxEntityInfo], Ptr[
    CXIdxEntityInfo
  ], Ptr[CXIdxContainerInfo], CXSymbolRole]
object CXIdxEntityRefInfo:
  given _tag: Tag[CXIdxEntityRefInfo] =
    Tag.materializeCStruct7Tag[CXIdxEntityRefKind, CXCursor, CXIdxLoc, Ptr[
      CXIdxEntityInfo
    ], Ptr[CXIdxEntityInfo], Ptr[CXIdxContainerInfo], CXSymbolRole]
  def apply()(using Zone): Ptr[CXIdxEntityRefInfo] =
    scala.scalanative.unsafe.alloc[CXIdxEntityRefInfo](1)
  def apply(
      kind: CXIdxEntityRefKind,
      cursor: CXCursor,
      loc: CXIdxLoc,
      referencedEntity: Ptr[CXIdxEntityInfo],
      parentEntity: Ptr[CXIdxEntityInfo],
      container: Ptr[CXIdxContainerInfo],
      role: CXSymbolRole
  )(using Zone): Ptr[CXIdxEntityRefInfo] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    (!____ptr).referencedEntity = referencedEntity
    (!____ptr).parentEntity = parentEntity
    (!____ptr).container = container
    (!____ptr).role = role
    ____ptr
  end apply
  extension (struct: CXIdxEntityRefInfo)
    def kind: CXIdxEntityRefKind = struct._1
    def kind_=(value: CXIdxEntityRefKind): Unit = !struct.at1 = value
    def cursor: CXCursor = struct._2
    def cursor_=(value: CXCursor): Unit = !struct.at2 = value
    def loc: CXIdxLoc = struct._3
    def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
    def referencedEntity: Ptr[CXIdxEntityInfo] = struct._4
    def referencedEntity_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at4 =
      value
    def parentEntity: Ptr[CXIdxEntityInfo] = struct._5
    def parentEntity_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at5 = value
    def container: Ptr[CXIdxContainerInfo] = struct._6
    def container_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at6 = value
    def role: CXSymbolRole = struct._7
    def role_=(value: CXSymbolRole): Unit = !struct.at7 = value
  end extension
end CXIdxEntityRefInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxIBOutletCollectionAttrInfo =
  CStruct4[Ptr[CXIdxAttrInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
object CXIdxIBOutletCollectionAttrInfo:
  given _tag: Tag[CXIdxIBOutletCollectionAttrInfo] =
    Tag.materializeCStruct4Tag[Ptr[CXIdxAttrInfo], Ptr[
      CXIdxEntityInfo
    ], CXCursor, CXIdxLoc]
  def apply()(using Zone): Ptr[CXIdxIBOutletCollectionAttrInfo] =
    scala.scalanative.unsafe.alloc[CXIdxIBOutletCollectionAttrInfo](1)
  def apply(
      attrInfo: Ptr[CXIdxAttrInfo],
      objcClass: Ptr[CXIdxEntityInfo],
      classCursor: CXCursor,
      classLoc: CXIdxLoc
  )(using Zone): Ptr[CXIdxIBOutletCollectionAttrInfo] =
    val ____ptr = apply()
    (!____ptr).attrInfo = attrInfo
    (!____ptr).objcClass = objcClass
    (!____ptr).classCursor = classCursor
    (!____ptr).classLoc = classLoc
    ____ptr
  end apply
  extension (struct: CXIdxIBOutletCollectionAttrInfo)
    def attrInfo: Ptr[CXIdxAttrInfo] = struct._1
    def attrInfo_=(value: Ptr[CXIdxAttrInfo]): Unit = !struct.at1 = value
    def objcClass: Ptr[CXIdxEntityInfo] = struct._2
    def objcClass_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at2 = value
    def classCursor: CXCursor = struct._3
    def classCursor_=(value: CXCursor): Unit = !struct.at3 = value
    def classLoc: CXIdxLoc = struct._4
    def classLoc_=(value: CXIdxLoc): Unit = !struct.at4 = value
end CXIdxIBOutletCollectionAttrInfo

/** Data for IndexerCallbacks#importedASTFile.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxImportedASTFileInfo =
  CStruct4[CXFile, CXModule, CXIdxLoc, CInt]
object CXIdxImportedASTFileInfo:
  given _tag: Tag[CXIdxImportedASTFileInfo] =
    Tag.materializeCStruct4Tag[CXFile, CXModule, CXIdxLoc, CInt]
  def apply()(using Zone): Ptr[CXIdxImportedASTFileInfo] =
    scala.scalanative.unsafe.alloc[CXIdxImportedASTFileInfo](1)
  def apply(file: CXFile, module: CXModule, loc: CXIdxLoc, isImplicit: CInt)(
      using Zone
  ): Ptr[CXIdxImportedASTFileInfo] =
    val ____ptr = apply()
    (!____ptr).file = file
    (!____ptr).module = module
    (!____ptr).loc = loc
    (!____ptr).isImplicit = isImplicit
    ____ptr
  extension (struct: CXIdxImportedASTFileInfo)
    def file: CXFile = struct._1
    def file_=(value: CXFile): Unit = !struct.at1 = value
    def module: CXModule = struct._2
    def module_=(value: CXModule): Unit = !struct.at2 = value
    def loc: CXIdxLoc = struct._3
    def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
    def isImplicit: CInt = struct._4
    def isImplicit_=(value: CInt): Unit = !struct.at4 = value
end CXIdxImportedASTFileInfo

/** Data for ppIncludedFile callback.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxIncludedFileInfo =
  CStruct6[CXIdxLoc, CString, CXFile, CInt, CInt, CInt]
object CXIdxIncludedFileInfo:
  given _tag: Tag[CXIdxIncludedFileInfo] =
    Tag.materializeCStruct6Tag[CXIdxLoc, CString, CXFile, CInt, CInt, CInt]
  def apply()(using Zone): Ptr[CXIdxIncludedFileInfo] =
    scala.scalanative.unsafe.alloc[CXIdxIncludedFileInfo](1)
  def apply(
      hashLoc: CXIdxLoc,
      filename: CString,
      file: CXFile,
      isImport: CInt,
      isAngled: CInt,
      isModuleImport: CInt
  )(using Zone): Ptr[CXIdxIncludedFileInfo] =
    val ____ptr = apply()
    (!____ptr).hashLoc = hashLoc
    (!____ptr).filename = filename
    (!____ptr).file = file
    (!____ptr).isImport = isImport
    (!____ptr).isAngled = isAngled
    (!____ptr).isModuleImport = isModuleImport
    ____ptr
  end apply
  extension (struct: CXIdxIncludedFileInfo)
    def hashLoc: CXIdxLoc = struct._1
    def hashLoc_=(value: CXIdxLoc): Unit = !struct.at1 = value
    def filename: CString = struct._2
    def filename_=(value: CString): Unit = !struct.at2 = value
    def file: CXFile = struct._3
    def file_=(value: CXFile): Unit = !struct.at3 = value
    def isImport: CInt = struct._4
    def isImport_=(value: CInt): Unit = !struct.at4 = value
    def isAngled: CInt = struct._5
    def isAngled_=(value: CInt): Unit = !struct.at5 = value
    def isModuleImport: CInt = struct._6
    def isModuleImport_=(value: CInt): Unit = !struct.at6 = value
  end extension
end CXIdxIncludedFileInfo

/** Source location passed to index callbacks.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxLoc = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
object CXIdxLoc:
  given _tag: Tag[CXIdxLoc] =
    Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  def apply()(using Zone): Ptr[CXIdxLoc] =
    scala.scalanative.unsafe.alloc[CXIdxLoc](1)
  def apply(ptr_data: CArray[Ptr[Byte], Nat._2], int_data: CUnsignedInt)(using
      Zone
  ): Ptr[CXIdxLoc] =
    val ____ptr = apply()
    (!____ptr).ptr_data = ptr_data
    (!____ptr).int_data = int_data
    ____ptr
  extension (struct: CXIdxLoc)
    def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
    def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
    def int_data: CUnsignedInt = struct._2
    def int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value
end CXIdxLoc

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxObjCCategoryDeclInfo = CStruct5[Ptr[
  CXIdxObjCContainerDeclInfo
], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]
object CXIdxObjCCategoryDeclInfo:
  given _tag: Tag[CXIdxObjCCategoryDeclInfo] =
    Tag.materializeCStruct5Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[
      CXIdxEntityInfo
    ], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]
  def apply()(using Zone): Ptr[CXIdxObjCCategoryDeclInfo] =
    scala.scalanative.unsafe.alloc[CXIdxObjCCategoryDeclInfo](1)
  def apply(
      containerInfo: Ptr[CXIdxObjCContainerDeclInfo],
      objcClass: Ptr[CXIdxEntityInfo],
      classCursor: CXCursor,
      classLoc: CXIdxLoc,
      protocols: Ptr[CXIdxObjCProtocolRefListInfo]
  )(using Zone): Ptr[CXIdxObjCCategoryDeclInfo] =
    val ____ptr = apply()
    (!____ptr).containerInfo = containerInfo
    (!____ptr).objcClass = objcClass
    (!____ptr).classCursor = classCursor
    (!____ptr).classLoc = classLoc
    (!____ptr).protocols = protocols
    ____ptr
  end apply
  extension (struct: CXIdxObjCCategoryDeclInfo)
    def containerInfo: Ptr[CXIdxObjCContainerDeclInfo] = struct._1
    def containerInfo_=(value: Ptr[CXIdxObjCContainerDeclInfo]): Unit =
      !struct.at1 = value
    def objcClass: Ptr[CXIdxEntityInfo] = struct._2
    def objcClass_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at2 = value
    def classCursor: CXCursor = struct._3
    def classCursor_=(value: CXCursor): Unit = !struct.at3 = value
    def classLoc: CXIdxLoc = struct._4
    def classLoc_=(value: CXIdxLoc): Unit = !struct.at4 = value
    def protocols: Ptr[CXIdxObjCProtocolRefListInfo] = struct._5
    def protocols_=(value: Ptr[CXIdxObjCProtocolRefListInfo]): Unit =
      !struct.at5 = value
  end extension
end CXIdxObjCCategoryDeclInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxObjCContainerDeclInfo =
  CStruct2[Ptr[CXIdxDeclInfo], CXIdxObjCContainerKind]
object CXIdxObjCContainerDeclInfo:
  given _tag: Tag[CXIdxObjCContainerDeclInfo] =
    Tag.materializeCStruct2Tag[Ptr[CXIdxDeclInfo], CXIdxObjCContainerKind]
  def apply()(using Zone): Ptr[CXIdxObjCContainerDeclInfo] =
    scala.scalanative.unsafe.alloc[CXIdxObjCContainerDeclInfo](1)
  def apply(declInfo: Ptr[CXIdxDeclInfo], kind: CXIdxObjCContainerKind)(using
      Zone
  ): Ptr[CXIdxObjCContainerDeclInfo] =
    val ____ptr = apply()
    (!____ptr).declInfo = declInfo
    (!____ptr).kind = kind
    ____ptr
  extension (struct: CXIdxObjCContainerDeclInfo)
    def declInfo: Ptr[CXIdxDeclInfo] = struct._1
    def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
    def kind: CXIdxObjCContainerKind = struct._2
    def kind_=(value: CXIdxObjCContainerKind): Unit = !struct.at2 = value
end CXIdxObjCContainerDeclInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxObjCInterfaceDeclInfo = CStruct3[Ptr[
  CXIdxObjCContainerDeclInfo
], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]
object CXIdxObjCInterfaceDeclInfo:
  given _tag: Tag[CXIdxObjCInterfaceDeclInfo] = Tag.materializeCStruct3Tag[Ptr[
    CXIdxObjCContainerDeclInfo
  ], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]
  def apply()(using Zone): Ptr[CXIdxObjCInterfaceDeclInfo] =
    scala.scalanative.unsafe.alloc[CXIdxObjCInterfaceDeclInfo](1)
  def apply(
      containerInfo: Ptr[CXIdxObjCContainerDeclInfo],
      superInfo: Ptr[CXIdxBaseClassInfo],
      protocols: Ptr[CXIdxObjCProtocolRefListInfo]
  )(using Zone): Ptr[CXIdxObjCInterfaceDeclInfo] =
    val ____ptr = apply()
    (!____ptr).containerInfo = containerInfo
    (!____ptr).superInfo = superInfo
    (!____ptr).protocols = protocols
    ____ptr
  end apply
  extension (struct: CXIdxObjCInterfaceDeclInfo)
    def containerInfo: Ptr[CXIdxObjCContainerDeclInfo] = struct._1
    def containerInfo_=(value: Ptr[CXIdxObjCContainerDeclInfo]): Unit =
      !struct.at1 = value
    def superInfo: Ptr[CXIdxBaseClassInfo] = struct._2
    def superInfo_=(value: Ptr[CXIdxBaseClassInfo]): Unit = !struct.at2 = value
    def protocols: Ptr[CXIdxObjCProtocolRefListInfo] = struct._3
    def protocols_=(value: Ptr[CXIdxObjCProtocolRefListInfo]): Unit =
      !struct.at3 = value
end CXIdxObjCInterfaceDeclInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxObjCPropertyDeclInfo =
  CStruct3[Ptr[CXIdxDeclInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo]]
object CXIdxObjCPropertyDeclInfo:
  given _tag: Tag[CXIdxObjCPropertyDeclInfo] = Tag.materializeCStruct3Tag[Ptr[
    CXIdxDeclInfo
  ], Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo]]
  def apply()(using Zone): Ptr[CXIdxObjCPropertyDeclInfo] =
    scala.scalanative.unsafe.alloc[CXIdxObjCPropertyDeclInfo](1)
  def apply(
      declInfo: Ptr[CXIdxDeclInfo],
      getter: Ptr[CXIdxEntityInfo],
      setter: Ptr[CXIdxEntityInfo]
  )(using Zone): Ptr[CXIdxObjCPropertyDeclInfo] =
    val ____ptr = apply()
    (!____ptr).declInfo = declInfo
    (!____ptr).getter = getter
    (!____ptr).setter = setter
    ____ptr
  end apply
  extension (struct: CXIdxObjCPropertyDeclInfo)
    def declInfo: Ptr[CXIdxDeclInfo] = struct._1
    def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
    def getter: Ptr[CXIdxEntityInfo] = struct._2
    def getter_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at2 = value
    def setter: Ptr[CXIdxEntityInfo] = struct._3
    def setter_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at3 = value
end CXIdxObjCPropertyDeclInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxObjCProtocolRefInfo =
  CStruct3[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
object CXIdxObjCProtocolRefInfo:
  given _tag: Tag[CXIdxObjCProtocolRefInfo] =
    Tag.materializeCStruct3Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
  def apply()(using Zone): Ptr[CXIdxObjCProtocolRefInfo] =
    scala.scalanative.unsafe.alloc[CXIdxObjCProtocolRefInfo](1)
  def apply(protocol: Ptr[CXIdxEntityInfo], cursor: CXCursor, loc: CXIdxLoc)(
      using Zone
  ): Ptr[CXIdxObjCProtocolRefInfo] =
    val ____ptr = apply()
    (!____ptr).protocol = protocol
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    ____ptr
  extension (struct: CXIdxObjCProtocolRefInfo)
    def protocol: Ptr[CXIdxEntityInfo] = struct._1
    def protocol_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at1 = value
    def cursor: CXCursor = struct._2
    def cursor_=(value: CXCursor): Unit = !struct.at2 = value
    def loc: CXIdxLoc = struct._3
    def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
end CXIdxObjCProtocolRefInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXIdxObjCProtocolRefListInfo =
  CStruct2[Ptr[Ptr[CXIdxObjCProtocolRefInfo]], CUnsignedInt]
object CXIdxObjCProtocolRefListInfo:
  given _tag: Tag[CXIdxObjCProtocolRefListInfo] =
    Tag.materializeCStruct2Tag[Ptr[Ptr[CXIdxObjCProtocolRefInfo]], CUnsignedInt]
  def apply()(using Zone): Ptr[CXIdxObjCProtocolRefListInfo] =
    scala.scalanative.unsafe.alloc[CXIdxObjCProtocolRefListInfo](1)
  def apply(
      protocols: Ptr[Ptr[CXIdxObjCProtocolRefInfo]],
      numProtocols: CUnsignedInt
  )(using Zone): Ptr[CXIdxObjCProtocolRefListInfo] =
    val ____ptr = apply()
    (!____ptr).protocols = protocols
    (!____ptr).numProtocols = numProtocols
    ____ptr
  extension (struct: CXIdxObjCProtocolRefListInfo)
    def protocols: Ptr[Ptr[CXIdxObjCProtocolRefInfo]] = struct._1
    def protocols_=(value: Ptr[Ptr[CXIdxObjCProtocolRefInfo]]): Unit =
      !struct.at1 = value
    def numProtocols: CUnsignedInt = struct._2
    def numProtocols_=(value: CUnsignedInt): Unit = !struct.at2 = value
end CXIdxObjCProtocolRefListInfo

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/BuildSystem.h
  */
opaque type CXModuleMapDescriptorImpl = CStruct0
object CXModuleMapDescriptorImpl:
  given _tag: Tag[CXModuleMapDescriptorImpl] = Tag.materializeCStruct0Tag

/** Describes the availability of a given entity on a particular platform, e.g.,
  * a particular class might only be available on Mac OS 10.7 or newer.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXPlatformAvailability =
  CStruct6[CXString, CXVersion, CXVersion, CXVersion, CInt, CXString]
object CXPlatformAvailability:
  given _tag: Tag[CXPlatformAvailability] = Tag.materializeCStruct6Tag[
    CXString,
    CXVersion,
    CXVersion,
    CXVersion,
    CInt,
    CXString
  ]
  def apply()(using Zone): Ptr[CXPlatformAvailability] =
    scala.scalanative.unsafe.alloc[CXPlatformAvailability](1)
  def apply(
      Platform: CXString,
      Introduced: CXVersion,
      Deprecated: CXVersion,
      Obsoleted: CXVersion,
      Unavailable: CInt,
      Message: CXString
  )(using Zone): Ptr[CXPlatformAvailability] =
    val ____ptr = apply()
    (!____ptr).Platform = Platform
    (!____ptr).Introduced = Introduced
    (!____ptr).Deprecated = Deprecated
    (!____ptr).Obsoleted = Obsoleted
    (!____ptr).Unavailable = Unavailable
    (!____ptr).Message = Message
    ____ptr
  end apply
  extension (struct: CXPlatformAvailability)
    def Platform: CXString = struct._1
    def Platform_=(value: CXString): Unit = !struct.at1 = value
    def Introduced: CXVersion = struct._2
    def Introduced_=(value: CXVersion): Unit = !struct.at2 = value
    def Deprecated: CXVersion = struct._3
    def Deprecated_=(value: CXVersion): Unit = !struct.at3 = value
    def Obsoleted: CXVersion = struct._4
    def Obsoleted_=(value: CXVersion): Unit = !struct.at4 = value
    def Unavailable: CInt = struct._5
    def Unavailable_=(value: CInt): Unit = !struct.at5 = value
    def Message: CXString = struct._6
    def Message_=(value: CXString): Unit = !struct.at6 = value
  end extension
end CXPlatformAvailability

/** Identifies a specific source location within a translation unit.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXSourceLocation = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
object CXSourceLocation:
  given _tag: Tag[CXSourceLocation] =
    Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  def apply()(using Zone): Ptr[CXSourceLocation] =
    scala.scalanative.unsafe.alloc[CXSourceLocation](1)
  def apply(ptr_data: CArray[Ptr[Byte], Nat._2], int_data: CUnsignedInt)(using
      Zone
  ): Ptr[CXSourceLocation] =
    val ____ptr = apply()
    (!____ptr).ptr_data = ptr_data
    (!____ptr).int_data = int_data
    ____ptr
  extension (struct: CXSourceLocation)
    def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
    def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
    def int_data: CUnsignedInt = struct._2
    def int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value
end CXSourceLocation

/** Identifies a half-open character range in the source code.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXSourceRange =
  CStruct3[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]
object CXSourceRange:
  given _tag: Tag[CXSourceRange] = Tag.materializeCStruct3Tag[CArray[Ptr[
    Byte
  ], Nat._2], CUnsignedInt, CUnsignedInt]
  def apply()(using Zone): Ptr[CXSourceRange] =
    scala.scalanative.unsafe.alloc[CXSourceRange](1)
  def apply(
      ptr_data: CArray[Ptr[Byte], Nat._2],
      begin_int_data: CUnsignedInt,
      end_int_data: CUnsignedInt
  )(using Zone): Ptr[CXSourceRange] =
    val ____ptr = apply()
    (!____ptr).ptr_data = ptr_data
    (!____ptr).begin_int_data = begin_int_data
    (!____ptr).end_int_data = end_int_data
    ____ptr
  end apply
  extension (struct: CXSourceRange)
    def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
    def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
    def begin_int_data: CUnsignedInt = struct._2
    def begin_int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value
    def end_int_data: CUnsignedInt = struct._3
    def end_int_data_=(value: CUnsignedInt): Unit = !struct.at3 = value
end CXSourceRange

/** Identifies an array of ranges.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXSourceRangeList = CStruct2[CUnsignedInt, Ptr[CXSourceRange]]
object CXSourceRangeList:
  given _tag: Tag[CXSourceRangeList] =
    Tag.materializeCStruct2Tag[CUnsignedInt, Ptr[CXSourceRange]]
  def apply()(using Zone): Ptr[CXSourceRangeList] =
    scala.scalanative.unsafe.alloc[CXSourceRangeList](1)
  def apply(count: CUnsignedInt, ranges: Ptr[CXSourceRange])(using
      Zone
  ): Ptr[CXSourceRangeList] =
    val ____ptr = apply()
    (!____ptr).count = count
    (!____ptr).ranges = ranges
    ____ptr
  extension (struct: CXSourceRangeList)
    def count: CUnsignedInt = struct._1
    def count_=(value: CUnsignedInt): Unit = !struct.at1 = value
    def ranges: Ptr[CXSourceRange] = struct._2
    def ranges_=(value: Ptr[CXSourceRange]): Unit = !struct.at2 = value
end CXSourceRangeList

/** A character string.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/CXString.h
  */
opaque type CXString = CStruct2[Ptr[Byte], CUnsignedInt]
object CXString:
  given _tag: Tag[CXString] =
    Tag.materializeCStruct2Tag[Ptr[Byte], CUnsignedInt]
  def apply()(using Zone): Ptr[CXString] =
    scala.scalanative.unsafe.alloc[CXString](1)
  def apply(data: Ptr[Byte], private_flags: CUnsignedInt)(using
      Zone
  ): Ptr[CXString] =
    val ____ptr = apply()
    (!____ptr).data = data
    (!____ptr).private_flags = private_flags
    ____ptr
  extension (struct: CXString)
    def data: Ptr[Byte] = struct._1
    def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
    def private_flags: CUnsignedInt = struct._2
    def private_flags_=(value: CUnsignedInt): Unit = !struct.at2 = value
end CXString

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/CXString.h
  */
opaque type CXStringSet = CStruct2[Ptr[CXString], CUnsignedInt]
object CXStringSet:
  given _tag: Tag[CXStringSet] =
    Tag.materializeCStruct2Tag[Ptr[CXString], CUnsignedInt]
  def apply()(using Zone): Ptr[CXStringSet] =
    scala.scalanative.unsafe.alloc[CXStringSet](1)
  def apply(Strings: Ptr[CXString], Count: CUnsignedInt)(using
      Zone
  ): Ptr[CXStringSet] =
    val ____ptr = apply()
    (!____ptr).Strings = Strings
    (!____ptr).Count = Count
    ____ptr
  extension (struct: CXStringSet)
    def Strings: Ptr[CXString] = struct._1
    def Strings_=(value: Ptr[CXString]): Unit = !struct.at1 = value
    def Count: CUnsignedInt = struct._2
    def Count_=(value: CUnsignedInt): Unit = !struct.at2 = value
end CXStringSet

/** The memory usage of a CXTranslationUnit, broken into categories.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXTUResourceUsage =
  CStruct3[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]
object CXTUResourceUsage:
  given _tag: Tag[CXTUResourceUsage] = Tag.materializeCStruct3Tag[Ptr[
    Byte
  ], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]
  def apply()(using Zone): Ptr[CXTUResourceUsage] =
    scala.scalanative.unsafe.alloc[CXTUResourceUsage](1)
  def apply(
      data: Ptr[Byte],
      numEntries: CUnsignedInt,
      entries: Ptr[CXTUResourceUsageEntry]
  )(using Zone): Ptr[CXTUResourceUsage] =
    val ____ptr = apply()
    (!____ptr).data = data
    (!____ptr).numEntries = numEntries
    (!____ptr).entries = entries
    ____ptr
  end apply
  extension (struct: CXTUResourceUsage)
    def data: Ptr[Byte] = struct._1
    def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
    def numEntries: CUnsignedInt = struct._2
    def numEntries_=(value: CUnsignedInt): Unit = !struct.at2 = value
    def entries: Ptr[CXTUResourceUsageEntry] = struct._3
    def entries_=(value: Ptr[CXTUResourceUsageEntry]): Unit = !struct.at3 =
      value
end CXTUResourceUsage

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXTUResourceUsageEntry =
  CStruct2[CXTUResourceUsageKind, CUnsignedLongInt]
object CXTUResourceUsageEntry:
  given _tag: Tag[CXTUResourceUsageEntry] =
    Tag.materializeCStruct2Tag[CXTUResourceUsageKind, CUnsignedLongInt]
  def apply()(using Zone): Ptr[CXTUResourceUsageEntry] =
    scala.scalanative.unsafe.alloc[CXTUResourceUsageEntry](1)
  def apply(kind: CXTUResourceUsageKind, amount: CUnsignedLongInt)(using
      Zone
  ): Ptr[CXTUResourceUsageEntry] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).amount = amount
    ____ptr
  extension (struct: CXTUResourceUsageEntry)
    def kind: CXTUResourceUsageKind = struct._1
    def kind_=(value: CXTUResourceUsageKind): Unit = !struct.at1 = value
    def amount: CUnsignedLongInt = struct._2
    def amount_=(value: CUnsignedLongInt): Unit = !struct.at2 = value
end CXTUResourceUsageEntry

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXTargetInfoImpl = CStruct0
object CXTargetInfoImpl:
  given _tag: Tag[CXTargetInfoImpl] = Tag.materializeCStruct0Tag

/** Describes a single preprocessing token.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXToken = CStruct2[CArray[CUnsignedInt, Nat._4], Ptr[Byte]]
object CXToken:
  given _tag: Tag[CXToken] =
    Tag.materializeCStruct2Tag[CArray[CUnsignedInt, Nat._4], Ptr[Byte]]
  def apply()(using Zone): Ptr[CXToken] =
    scala.scalanative.unsafe.alloc[CXToken](1)
  def apply(int_data: CArray[CUnsignedInt, Nat._4], ptr_data: Ptr[Byte])(using
      Zone
  ): Ptr[CXToken] =
    val ____ptr = apply()
    (!____ptr).int_data = int_data
    (!____ptr).ptr_data = ptr_data
    ____ptr
  extension (struct: CXToken)
    def int_data: CArray[CUnsignedInt, Nat._4] = struct._1
    def int_data_=(value: CArray[CUnsignedInt, Nat._4]): Unit = !struct.at1 =
      value
    def ptr_data: Ptr[Byte] = struct._2
    def ptr_data_=(value: Ptr[Byte]): Unit = !struct.at2 = value
end CXToken

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXTranslationUnitImpl = CStruct0
object CXTranslationUnitImpl:
  given _tag: Tag[CXTranslationUnitImpl] = Tag.materializeCStruct0Tag

/** The type of an element in the abstract syntax tree.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXType = CStruct2[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
object CXType:
  given _tag: Tag[CXType] =
    Tag.materializeCStruct2Tag[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
  def apply()(using Zone): Ptr[CXType] =
    scala.scalanative.unsafe.alloc[CXType](1)
  def apply(kind: CXTypeKind, data: CArray[Ptr[Byte], Nat._2])(using
      Zone
  ): Ptr[CXType] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).data = data
    ____ptr
  extension (struct: CXType)
    def kind: CXTypeKind = struct._1
    def kind_=(value: CXTypeKind): Unit = !struct.at1 = value
    def data: CArray[Ptr[Byte], Nat._2] = struct._2
    def data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at2 = value
end CXType

/** Provides the contents of a file that has not yet been saved to disk.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXUnsavedFile = CStruct3[CString, CString, CUnsignedLongInt]
object CXUnsavedFile:
  given _tag: Tag[CXUnsavedFile] =
    Tag.materializeCStruct3Tag[CString, CString, CUnsignedLongInt]
  def apply()(using Zone): Ptr[CXUnsavedFile] =
    scala.scalanative.unsafe.alloc[CXUnsavedFile](1)
  def apply(Filename: CString, Contents: CString, Length: CUnsignedLongInt)(
      using Zone
  ): Ptr[CXUnsavedFile] =
    val ____ptr = apply()
    (!____ptr).Filename = Filename
    (!____ptr).Contents = Contents
    (!____ptr).Length = Length
    ____ptr
  extension (struct: CXUnsavedFile)
    def Filename: CString = struct._1
    def Filename_=(value: CString): Unit = !struct.at1 = value
    def Contents: CString = struct._2
    def Contents_=(value: CString): Unit = !struct.at2 = value
    def Length: CUnsignedLongInt = struct._3
    def Length_=(value: CUnsignedLongInt): Unit = !struct.at3 = value
end CXUnsavedFile

/** Describes a version number of the form major.minor.subminor.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type CXVersion = CStruct3[CInt, CInt, CInt]
object CXVersion:
  given _tag: Tag[CXVersion] = Tag.materializeCStruct3Tag[CInt, CInt, CInt]
  def apply()(using Zone): Ptr[CXVersion] =
    scala.scalanative.unsafe.alloc[CXVersion](1)
  def apply(Major: CInt, Minor: CInt, Subminor: CInt)(using
      Zone
  ): Ptr[CXVersion] =
    val ____ptr = apply()
    (!____ptr).Major = Major
    (!____ptr).Minor = Minor
    (!____ptr).Subminor = Subminor
    ____ptr
  extension (struct: CXVersion)
    def Major: CInt = struct._1
    def Major_=(value: CInt): Unit = !struct.at1 = value
    def Minor: CInt = struct._2
    def Minor_=(value: CInt): Unit = !struct.at2 = value
    def Subminor: CInt = struct._3
    def Subminor_=(value: CInt): Unit = !struct.at3 = value
end CXVersion

/** [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/BuildSystem.h
  */
opaque type CXVirtualFileOverlayImpl = CStruct0
object CXVirtualFileOverlayImpl:
  given _tag: Tag[CXVirtualFileOverlayImpl] = Tag.materializeCStruct0Tag

/** A group of callbacks used by #clang_indexSourceFile and
  * #clang_indexTranslationUnit.
  *
  * [bindgen] header: /opt/homebrew/opt/llvm@14/include/clang-c/Index.h
  */
opaque type IndexerCallbacks = CStruct8[
  CFuncPtr2[CXClientData, Ptr[Byte], CInt],
  CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit],
  CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile],
  CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile],
  CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile],
  CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer],
  CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit],
  CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]
]
object IndexerCallbacks:
  given _tag: Tag[IndexerCallbacks] = Tag
    .materializeCStruct8Tag[CFuncPtr2[CXClientData, Ptr[Byte], CInt], CFuncPtr3[
      CXClientData,
      CXDiagnosticSet,
      Ptr[Byte],
      Unit
    ], CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile], CFuncPtr2[
      CXClientData,
      Ptr[CXIdxIncludedFileInfo],
      CXIdxClientFile
    ], CFuncPtr2[
      CXClientData,
      Ptr[CXIdxImportedASTFileInfo],
      CXIdxClientASTFile
    ], CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer], CFuncPtr2[
      CXClientData,
      Ptr[CXIdxDeclInfo],
      Unit
    ], CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]
  def apply()(using Zone): Ptr[IndexerCallbacks] =
    scala.scalanative.unsafe.alloc[IndexerCallbacks](1)
  def apply(
      abortQuery: CFuncPtr2[CXClientData, Ptr[Byte], CInt],
      diagnostic: CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit],
      enteredMainFile: CFuncPtr3[CXClientData, CXFile, Ptr[
        Byte
      ], CXIdxClientFile],
      ppIncludedFile: CFuncPtr2[CXClientData, Ptr[
        CXIdxIncludedFileInfo
      ], CXIdxClientFile],
      importedASTFile: CFuncPtr2[CXClientData, Ptr[
        CXIdxImportedASTFileInfo
      ], CXIdxClientASTFile],
      startedTranslationUnit: CFuncPtr2[CXClientData, Ptr[
        Byte
      ], CXIdxClientContainer],
      indexDeclaration: CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit],
      indexEntityReference: CFuncPtr2[CXClientData, Ptr[
        CXIdxEntityRefInfo
      ], Unit]
  )(using Zone): Ptr[IndexerCallbacks] =
    val ____ptr = apply()
    (!____ptr).abortQuery = abortQuery
    (!____ptr).diagnostic = diagnostic
    (!____ptr).enteredMainFile = enteredMainFile
    (!____ptr).ppIncludedFile = ppIncludedFile
    (!____ptr).importedASTFile = importedASTFile
    (!____ptr).startedTranslationUnit = startedTranslationUnit
    (!____ptr).indexDeclaration = indexDeclaration
    (!____ptr).indexEntityReference = indexEntityReference
    ____ptr
  end apply
  extension (struct: IndexerCallbacks)
    def abortQuery: CFuncPtr2[CXClientData, Ptr[Byte], CInt] = struct._1
    def abortQuery_=(value: CFuncPtr2[CXClientData, Ptr[Byte], CInt]): Unit =
      !struct.at1 = value
    def diagnostic: CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit] =
      struct._2
    def diagnostic_=(
        value: CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]
    ): Unit = !struct.at2 = value
    def enteredMainFile
        : CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile] =
      struct._3
    def enteredMainFile_=(
        value: CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]
    ): Unit = !struct.at3 = value
    def ppIncludedFile
        : CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile] =
      struct._4
    def ppIncludedFile_=(
        value: CFuncPtr2[CXClientData, Ptr[
          CXIdxIncludedFileInfo
        ], CXIdxClientFile]
    ): Unit = !struct.at4 = value
    def importedASTFile: CFuncPtr2[CXClientData, Ptr[
      CXIdxImportedASTFileInfo
    ], CXIdxClientASTFile] = struct._5
    def importedASTFile_=(
        value: CFuncPtr2[CXClientData, Ptr[
          CXIdxImportedASTFileInfo
        ], CXIdxClientASTFile]
    ): Unit = !struct.at5 = value
    def startedTranslationUnit
        : CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer] = struct._6
    def startedTranslationUnit_=(
        value: CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]
    ): Unit = !struct.at6 = value
    def indexDeclaration: CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit] =
      struct._7
    def indexDeclaration_=(
        value: CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]
    ): Unit = !struct.at7 = value
    def indexEntityReference
        : CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit] = struct._8
    def indexEntityReference_=(
        value: CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]
    ): Unit = !struct.at8 = value
  end extension
end IndexerCallbacks
