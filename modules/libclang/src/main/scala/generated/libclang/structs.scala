package libclang

import _root_.scala.scalanative.unsafe.*
import _root_.scala.scalanative.unsigned.*
import _root_.scala.scalanative.libc.*
import _root_.scala.scalanative.*

/**
 * Contains the results of code-completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCodeCompleteResults = CStruct2[Ptr[CXCompletionResult], CUnsignedInt]

object CXCodeCompleteResults:
  given _tag: Tag[CXCodeCompleteResults] = Tag.materializeCStruct2Tag[Ptr[CXCompletionResult], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXCodeCompleteResults)
      inline def Results : Ptr[CXCompletionResult] = struct._1
      inline def Results_=(value: Ptr[CXCompletionResult]): Unit = (!struct.at1 = value)
      inline def NumResults : CUnsignedInt = struct._2
      inline def NumResults_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXCodeCompleteResults on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXCodeCompleteResults] = scala.scalanative.unsafe.alloc[CXCodeCompleteResults](1)
  def apply(Results : Ptr[CXCompletionResult], NumResults : CUnsignedInt)(using Zone): Ptr[CXCodeCompleteResults] =
    val ____ptr = apply()
    (!____ptr).Results = Results
    (!____ptr).NumResults = NumResults
    ____ptr



/**
 * A single result of code completion.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCompletionResult = CStruct2[CXCursorKind, CXCompletionString]

object CXCompletionResult:
  given _tag: Tag[CXCompletionResult] = Tag.materializeCStruct2Tag[CXCursorKind, CXCompletionString]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXCompletionResult)
      inline def CursorKind : CXCursorKind = struct._1
      inline def CursorKind_=(value: CXCursorKind): Unit = (!struct.at1 = value)
      inline def CompletionString : CXCompletionString = struct._2
      inline def CompletionString_=(value: CXCompletionString): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXCompletionResult on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXCompletionResult] = scala.scalanative.unsafe.alloc[CXCompletionResult](1)
  def apply(CursorKind : CXCursorKind, CompletionString : CXCompletionString)(using Zone): Ptr[CXCompletionResult] =
    val ____ptr = apply()
    (!____ptr).CursorKind = CursorKind
    (!____ptr).CompletionString = CompletionString
    ____ptr



/**
 * A cursor representing some element in the abstract syntax tree for a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCursor = CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]

object CXCursor:
  given _tag: Tag[CXCursor] = Tag.materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXCursor)
      inline def kind : CXCursorKind = struct._1
      inline def kind_=(value: CXCursorKind): Unit = (!struct.at1 = value)
      inline def xdata : CInt = struct._2
      inline def xdata_=(value: CInt): Unit = (!struct.at2 = value)
      inline def data : CArray[Ptr[Byte], Nat._3] = struct._3
      inline def data_=(value: CArray[Ptr[Byte], Nat._3]): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXCursor on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXCursor] = scala.scalanative.unsafe.alloc[CXCursor](1)
  def apply(kind : CXCursorKind, xdata : CInt, data : CArray[Ptr[Byte], Nat._3])(using Zone): Ptr[CXCursor] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).xdata = xdata
    (!____ptr).data = data
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCursorAndRangeVisitor = CStruct2[Ptr[Byte], CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]]

object CXCursorAndRangeVisitor:
  given _tag: Tag[CXCursorAndRangeVisitor] = Tag.materializeCStruct2Tag[Ptr[Byte], CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXCursorAndRangeVisitor)
      inline def context : Ptr[Byte] = struct._1
      inline def context_=(value: Ptr[Byte]): Unit = (!struct.at1 = value)
      inline def visit : CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult] = struct._2
      inline def visit_=(value: CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXCursorAndRangeVisitor on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXCursorAndRangeVisitor] = scala.scalanative.unsafe.alloc[CXCursorAndRangeVisitor](1)
  def apply(context : Ptr[Byte], visit : CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult])(using Zone): Ptr[CXCursorAndRangeVisitor] =
    val ____ptr = apply()
    (!____ptr).context = context
    (!____ptr).visit = visit
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXCursorSetImpl = CStruct0

object CXCursorSetImpl:
  given _tag: Tag[CXCursorSetImpl] = Tag.materializeCStruct0Tag


/**
 * Uniquely identifies a CXFile, that refers to the same underlying file, across an indexing session.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXFile.h
*/
opaque type CXFileUniqueID = CStruct1[CArray[CUnsignedLongLong, Nat._3]]

object CXFileUniqueID:
  given _tag: Tag[CXFileUniqueID] = Tag.materializeCStruct1Tag[CArray[CUnsignedLongLong, Nat._3]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXFileUniqueID)
      inline def data : CArray[CUnsignedLongLong, Nat._3] = struct._1
      inline def data_=(value: CArray[CUnsignedLongLong, Nat._3]): Unit = (!struct.at1 = value)
    end extension

  // Allocates CXFileUniqueID on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXFileUniqueID] = scala.scalanative.unsafe.alloc[CXFileUniqueID](1)
  def apply(data : CArray[CUnsignedLongLong, Nat._3])(using Zone): Ptr[CXFileUniqueID] =
    val ____ptr = apply()
    (!____ptr).data = data
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxAttrInfo = CStruct3[CXIdxAttrKind, CXCursor, CXIdxLoc]

object CXIdxAttrInfo:
  given _tag: Tag[CXIdxAttrInfo] = Tag.materializeCStruct3Tag[CXIdxAttrKind, CXCursor, CXIdxLoc]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxAttrInfo)
      inline def kind : CXIdxAttrKind = struct._1
      inline def kind_=(value: CXIdxAttrKind): Unit = (!struct.at1 = value)
      inline def cursor : CXCursor = struct._2
      inline def cursor_=(value: CXCursor): Unit = (!struct.at2 = value)
      inline def loc : CXIdxLoc = struct._3
      inline def loc_=(value: CXIdxLoc): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXIdxAttrInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxAttrInfo] = scala.scalanative.unsafe.alloc[CXIdxAttrInfo](1)
  def apply(kind : CXIdxAttrKind, cursor : CXCursor, loc : CXIdxLoc)(using Zone): Ptr[CXIdxAttrInfo] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxBaseClassInfo = CStruct3[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]

object CXIdxBaseClassInfo:
  given _tag: Tag[CXIdxBaseClassInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxBaseClassInfo)
      inline def base : Ptr[CXIdxEntityInfo] = struct._1
      inline def base_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at1 = value)
      inline def cursor : CXCursor = struct._2
      inline def cursor_=(value: CXCursor): Unit = (!struct.at2 = value)
      inline def loc : CXIdxLoc = struct._3
      inline def loc_=(value: CXIdxLoc): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXIdxBaseClassInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxBaseClassInfo] = scala.scalanative.unsafe.alloc[CXIdxBaseClassInfo](1)
  def apply(base : Ptr[CXIdxEntityInfo], cursor : CXCursor, loc : CXIdxLoc)(using Zone): Ptr[CXIdxBaseClassInfo] =
    val ____ptr = apply()
    (!____ptr).base = base
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxCXXClassDeclInfo = CStruct3[Ptr[CXIdxDeclInfo], Ptr[Ptr[CXIdxBaseClassInfo]], CUnsignedInt]

object CXIdxCXXClassDeclInfo:
  given _tag: Tag[CXIdxCXXClassDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxDeclInfo], Ptr[Ptr[CXIdxBaseClassInfo]], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxCXXClassDeclInfo)
      inline def declInfo : Ptr[CXIdxDeclInfo] = struct._1
      inline def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = (!struct.at1 = value)
      inline def bases : Ptr[Ptr[CXIdxBaseClassInfo]] = struct._2
      inline def bases_=(value: Ptr[Ptr[CXIdxBaseClassInfo]]): Unit = (!struct.at2 = value)
      inline def numBases : CUnsignedInt = struct._3
      inline def numBases_=(value: CUnsignedInt): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXIdxCXXClassDeclInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxCXXClassDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxCXXClassDeclInfo](1)
  def apply(declInfo : Ptr[CXIdxDeclInfo], bases : Ptr[Ptr[CXIdxBaseClassInfo]], numBases : CUnsignedInt)(using Zone): Ptr[CXIdxCXXClassDeclInfo] =
    val ____ptr = apply()
    (!____ptr).declInfo = declInfo
    (!____ptr).bases = bases
    (!____ptr).numBases = numBases
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxContainerInfo = CStruct1[CXCursor]

object CXIdxContainerInfo:
  given _tag: Tag[CXIdxContainerInfo] = Tag.materializeCStruct1Tag[CXCursor]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxContainerInfo)
      inline def cursor : CXCursor = struct._1
      inline def cursor_=(value: CXCursor): Unit = (!struct.at1 = value)
    end extension

  // Allocates CXIdxContainerInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxContainerInfo] = scala.scalanative.unsafe.alloc[CXIdxContainerInfo](1)
  def apply(cursor : CXCursor)(using Zone): Ptr[CXIdxContainerInfo] =
    val ____ptr = apply()
    (!____ptr).cursor = cursor
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxDeclInfo = CStruct13[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxContainerInfo], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[CXIdxContainerInfo], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]

object CXIdxDeclInfo:
  given _tag: Tag[CXIdxDeclInfo] = Tag.materializeCStruct13Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxContainerInfo], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[CXIdxContainerInfo], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxDeclInfo)
      inline def entityInfo : Ptr[CXIdxEntityInfo] = struct._1
      inline def entityInfo_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at1 = value)
      inline def cursor : CXCursor = struct._2
      inline def cursor_=(value: CXCursor): Unit = (!struct.at2 = value)
      inline def loc : CXIdxLoc = struct._3
      inline def loc_=(value: CXIdxLoc): Unit = (!struct.at3 = value)
      inline def semanticContainer : Ptr[CXIdxContainerInfo] = struct._4
      inline def semanticContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = (!struct.at4 = value)
      inline def lexicalContainer : Ptr[CXIdxContainerInfo] = struct._5
      inline def lexicalContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = (!struct.at5 = value)
      inline def isRedeclaration : CInt = struct._6
      inline def isRedeclaration_=(value: CInt): Unit = (!struct.at6 = value)
      inline def isDefinition : CInt = struct._7
      inline def isDefinition_=(value: CInt): Unit = (!struct.at7 = value)
      inline def isContainer : CInt = struct._8
      inline def isContainer_=(value: CInt): Unit = (!struct.at8 = value)
      inline def declAsContainer : Ptr[CXIdxContainerInfo] = struct._9
      inline def declAsContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = (!struct.at9 = value)
      inline def isImplicit : CInt = struct._10
      inline def isImplicit_=(value: CInt): Unit = (!struct.at10 = value)
      inline def attributes : Ptr[Ptr[CXIdxAttrInfo]] = struct._11
      inline def attributes_=(value: Ptr[Ptr[CXIdxAttrInfo]]): Unit = (!struct.at11 = value)
      inline def numAttributes : CUnsignedInt = struct._12
      inline def numAttributes_=(value: CUnsignedInt): Unit = (!struct.at12 = value)
      inline def flags : CUnsignedInt = struct._13
      inline def flags_=(value: CUnsignedInt): Unit = (!struct.at13 = value)
    end extension

  // Allocates CXIdxDeclInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxDeclInfo](1)
  def apply(entityInfo : Ptr[CXIdxEntityInfo], cursor : CXCursor, loc : CXIdxLoc, semanticContainer : Ptr[CXIdxContainerInfo], lexicalContainer : Ptr[CXIdxContainerInfo], isRedeclaration : CInt, isDefinition : CInt, isContainer : CInt, declAsContainer : Ptr[CXIdxContainerInfo], isImplicit : CInt, attributes : Ptr[Ptr[CXIdxAttrInfo]], numAttributes : CUnsignedInt, flags : CUnsignedInt)(using Zone): Ptr[CXIdxDeclInfo] =
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



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxEntityInfo = CStruct8[CXIdxEntityKind, CXIdxEntityCXXTemplateKind, CXIdxEntityLanguage, CString, CString, CXCursor, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt]

object CXIdxEntityInfo:
  given _tag: Tag[CXIdxEntityInfo] = Tag.materializeCStruct8Tag[CXIdxEntityKind, CXIdxEntityCXXTemplateKind, CXIdxEntityLanguage, CString, CString, CXCursor, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxEntityInfo)
      inline def kind : CXIdxEntityKind = struct._1
      inline def kind_=(value: CXIdxEntityKind): Unit = (!struct.at1 = value)
      inline def templateKind : CXIdxEntityCXXTemplateKind = struct._2
      inline def templateKind_=(value: CXIdxEntityCXXTemplateKind): Unit = (!struct.at2 = value)
      inline def lang : CXIdxEntityLanguage = struct._3
      inline def lang_=(value: CXIdxEntityLanguage): Unit = (!struct.at3 = value)
      inline def name : CString = struct._4
      inline def name_=(value: CString): Unit = (!struct.at4 = value)
      inline def USR : CString = struct._5
      inline def USR_=(value: CString): Unit = (!struct.at5 = value)
      inline def cursor : CXCursor = struct._6
      inline def cursor_=(value: CXCursor): Unit = (!struct.at6 = value)
      inline def attributes : Ptr[Ptr[CXIdxAttrInfo]] = struct._7
      inline def attributes_=(value: Ptr[Ptr[CXIdxAttrInfo]]): Unit = (!struct.at7 = value)
      inline def numAttributes : CUnsignedInt = struct._8
      inline def numAttributes_=(value: CUnsignedInt): Unit = (!struct.at8 = value)
    end extension

  // Allocates CXIdxEntityInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxEntityInfo] = scala.scalanative.unsafe.alloc[CXIdxEntityInfo](1)
  def apply(kind : CXIdxEntityKind, templateKind : CXIdxEntityCXXTemplateKind, lang : CXIdxEntityLanguage, name : CString, USR : CString, cursor : CXCursor, attributes : Ptr[Ptr[CXIdxAttrInfo]], numAttributes : CUnsignedInt)(using Zone): Ptr[CXIdxEntityInfo] =
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



/**
 * Data for IndexerCallbacks#indexEntityReference.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxEntityRefInfo = CStruct7[CXIdxEntityRefKind, CXCursor, CXIdxLoc, Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxContainerInfo], CXSymbolRole]

object CXIdxEntityRefInfo:
  given _tag: Tag[CXIdxEntityRefInfo] = Tag.materializeCStruct7Tag[CXIdxEntityRefKind, CXCursor, CXIdxLoc, Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxContainerInfo], CXSymbolRole]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxEntityRefInfo)
      inline def kind : CXIdxEntityRefKind = struct._1
      inline def kind_=(value: CXIdxEntityRefKind): Unit = (!struct.at1 = value)
      inline def cursor : CXCursor = struct._2
      inline def cursor_=(value: CXCursor): Unit = (!struct.at2 = value)
      inline def loc : CXIdxLoc = struct._3
      inline def loc_=(value: CXIdxLoc): Unit = (!struct.at3 = value)
      inline def referencedEntity : Ptr[CXIdxEntityInfo] = struct._4
      inline def referencedEntity_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at4 = value)
      inline def parentEntity : Ptr[CXIdxEntityInfo] = struct._5
      inline def parentEntity_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at5 = value)
      inline def container : Ptr[CXIdxContainerInfo] = struct._6
      inline def container_=(value: Ptr[CXIdxContainerInfo]): Unit = (!struct.at6 = value)
      inline def role : CXSymbolRole = struct._7
      inline def role_=(value: CXSymbolRole): Unit = (!struct.at7 = value)
    end extension

  // Allocates CXIdxEntityRefInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxEntityRefInfo] = scala.scalanative.unsafe.alloc[CXIdxEntityRefInfo](1)
  def apply(kind : CXIdxEntityRefKind, cursor : CXCursor, loc : CXIdxLoc, referencedEntity : Ptr[CXIdxEntityInfo], parentEntity : Ptr[CXIdxEntityInfo], container : Ptr[CXIdxContainerInfo], role : CXSymbolRole)(using Zone): Ptr[CXIdxEntityRefInfo] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    (!____ptr).referencedEntity = referencedEntity
    (!____ptr).parentEntity = parentEntity
    (!____ptr).container = container
    (!____ptr).role = role
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxIBOutletCollectionAttrInfo = CStruct4[Ptr[CXIdxAttrInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]

object CXIdxIBOutletCollectionAttrInfo:
  given _tag: Tag[CXIdxIBOutletCollectionAttrInfo] = Tag.materializeCStruct4Tag[Ptr[CXIdxAttrInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxIBOutletCollectionAttrInfo)
      inline def attrInfo : Ptr[CXIdxAttrInfo] = struct._1
      inline def attrInfo_=(value: Ptr[CXIdxAttrInfo]): Unit = (!struct.at1 = value)
      inline def objcClass : Ptr[CXIdxEntityInfo] = struct._2
      inline def objcClass_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at2 = value)
      inline def classCursor : CXCursor = struct._3
      inline def classCursor_=(value: CXCursor): Unit = (!struct.at3 = value)
      inline def classLoc : CXIdxLoc = struct._4
      inline def classLoc_=(value: CXIdxLoc): Unit = (!struct.at4 = value)
    end extension

  // Allocates CXIdxIBOutletCollectionAttrInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxIBOutletCollectionAttrInfo] = scala.scalanative.unsafe.alloc[CXIdxIBOutletCollectionAttrInfo](1)
  def apply(attrInfo : Ptr[CXIdxAttrInfo], objcClass : Ptr[CXIdxEntityInfo], classCursor : CXCursor, classLoc : CXIdxLoc)(using Zone): Ptr[CXIdxIBOutletCollectionAttrInfo] =
    val ____ptr = apply()
    (!____ptr).attrInfo = attrInfo
    (!____ptr).objcClass = objcClass
    (!____ptr).classCursor = classCursor
    (!____ptr).classLoc = classLoc
    ____ptr



/**
 * Data for IndexerCallbacks#importedASTFile.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxImportedASTFileInfo = CStruct4[CXFile, CXModule, CXIdxLoc, CInt]

object CXIdxImportedASTFileInfo:
  given _tag: Tag[CXIdxImportedASTFileInfo] = Tag.materializeCStruct4Tag[CXFile, CXModule, CXIdxLoc, CInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxImportedASTFileInfo)
      inline def file : CXFile = struct._1
      inline def file_=(value: CXFile): Unit = (!struct.at1 = value)
      inline def module : CXModule = struct._2
      inline def module_=(value: CXModule): Unit = (!struct.at2 = value)
      inline def loc : CXIdxLoc = struct._3
      inline def loc_=(value: CXIdxLoc): Unit = (!struct.at3 = value)
      inline def isImplicit : CInt = struct._4
      inline def isImplicit_=(value: CInt): Unit = (!struct.at4 = value)
    end extension

  // Allocates CXIdxImportedASTFileInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxImportedASTFileInfo] = scala.scalanative.unsafe.alloc[CXIdxImportedASTFileInfo](1)
  def apply(file : CXFile, module : CXModule, loc : CXIdxLoc, isImplicit : CInt)(using Zone): Ptr[CXIdxImportedASTFileInfo] =
    val ____ptr = apply()
    (!____ptr).file = file
    (!____ptr).module = module
    (!____ptr).loc = loc
    (!____ptr).isImplicit = isImplicit
    ____ptr



/**
 * Data for ppIncludedFile callback.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxIncludedFileInfo = CStruct6[CXIdxLoc, CString, CXFile, CInt, CInt, CInt]

object CXIdxIncludedFileInfo:
  given _tag: Tag[CXIdxIncludedFileInfo] = Tag.materializeCStruct6Tag[CXIdxLoc, CString, CXFile, CInt, CInt, CInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxIncludedFileInfo)
      inline def hashLoc : CXIdxLoc = struct._1
      inline def hashLoc_=(value: CXIdxLoc): Unit = (!struct.at1 = value)
      inline def filename : CString = struct._2
      inline def filename_=(value: CString): Unit = (!struct.at2 = value)
      inline def file : CXFile = struct._3
      inline def file_=(value: CXFile): Unit = (!struct.at3 = value)
      inline def isImport : CInt = struct._4
      inline def isImport_=(value: CInt): Unit = (!struct.at4 = value)
      inline def isAngled : CInt = struct._5
      inline def isAngled_=(value: CInt): Unit = (!struct.at5 = value)
      inline def isModuleImport : CInt = struct._6
      inline def isModuleImport_=(value: CInt): Unit = (!struct.at6 = value)
    end extension

  // Allocates CXIdxIncludedFileInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxIncludedFileInfo] = scala.scalanative.unsafe.alloc[CXIdxIncludedFileInfo](1)
  def apply(hashLoc : CXIdxLoc, filename : CString, file : CXFile, isImport : CInt, isAngled : CInt, isModuleImport : CInt)(using Zone): Ptr[CXIdxIncludedFileInfo] =
    val ____ptr = apply()
    (!____ptr).hashLoc = hashLoc
    (!____ptr).filename = filename
    (!____ptr).file = file
    (!____ptr).isImport = isImport
    (!____ptr).isAngled = isAngled
    (!____ptr).isModuleImport = isModuleImport
    ____ptr



/**
 * Source location passed to index callbacks.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxLoc = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]

object CXIdxLoc:
  given _tag: Tag[CXIdxLoc] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxLoc)
      inline def ptr_data : CArray[Ptr[Byte], Nat._2] = struct._1
      inline def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = (!struct.at1 = value)
      inline def int_data : CUnsignedInt = struct._2
      inline def int_data_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXIdxLoc on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxLoc] = scala.scalanative.unsafe.alloc[CXIdxLoc](1)
  def apply(ptr_data : CArray[Ptr[Byte], Nat._2], int_data : CUnsignedInt)(using Zone): Ptr[CXIdxLoc] =
    val ____ptr = apply()
    (!____ptr).ptr_data = ptr_data
    (!____ptr).int_data = int_data
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCCategoryDeclInfo = CStruct5[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]

object CXIdxObjCCategoryDeclInfo:
  given _tag: Tag[CXIdxObjCCategoryDeclInfo] = Tag.materializeCStruct5Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxObjCCategoryDeclInfo)
      inline def containerInfo : Ptr[CXIdxObjCContainerDeclInfo] = struct._1
      inline def containerInfo_=(value: Ptr[CXIdxObjCContainerDeclInfo]): Unit = (!struct.at1 = value)
      inline def objcClass : Ptr[CXIdxEntityInfo] = struct._2
      inline def objcClass_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at2 = value)
      inline def classCursor : CXCursor = struct._3
      inline def classCursor_=(value: CXCursor): Unit = (!struct.at3 = value)
      inline def classLoc : CXIdxLoc = struct._4
      inline def classLoc_=(value: CXIdxLoc): Unit = (!struct.at4 = value)
      inline def protocols : Ptr[CXIdxObjCProtocolRefListInfo] = struct._5
      inline def protocols_=(value: Ptr[CXIdxObjCProtocolRefListInfo]): Unit = (!struct.at5 = value)
    end extension

  // Allocates CXIdxObjCCategoryDeclInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxObjCCategoryDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCCategoryDeclInfo](1)
  def apply(containerInfo : Ptr[CXIdxObjCContainerDeclInfo], objcClass : Ptr[CXIdxEntityInfo], classCursor : CXCursor, classLoc : CXIdxLoc, protocols : Ptr[CXIdxObjCProtocolRefListInfo])(using Zone): Ptr[CXIdxObjCCategoryDeclInfo] =
    val ____ptr = apply()
    (!____ptr).containerInfo = containerInfo
    (!____ptr).objcClass = objcClass
    (!____ptr).classCursor = classCursor
    (!____ptr).classLoc = classLoc
    (!____ptr).protocols = protocols
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCContainerDeclInfo = CStruct2[Ptr[CXIdxDeclInfo], CXIdxObjCContainerKind]

object CXIdxObjCContainerDeclInfo:
  given _tag: Tag[CXIdxObjCContainerDeclInfo] = Tag.materializeCStruct2Tag[Ptr[CXIdxDeclInfo], CXIdxObjCContainerKind]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxObjCContainerDeclInfo)
      inline def declInfo : Ptr[CXIdxDeclInfo] = struct._1
      inline def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = (!struct.at1 = value)
      inline def kind : CXIdxObjCContainerKind = struct._2
      inline def kind_=(value: CXIdxObjCContainerKind): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXIdxObjCContainerDeclInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxObjCContainerDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCContainerDeclInfo](1)
  def apply(declInfo : Ptr[CXIdxDeclInfo], kind : CXIdxObjCContainerKind)(using Zone): Ptr[CXIdxObjCContainerDeclInfo] =
    val ____ptr = apply()
    (!____ptr).declInfo = declInfo
    (!____ptr).kind = kind
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCInterfaceDeclInfo = CStruct3[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]

object CXIdxObjCInterfaceDeclInfo:
  given _tag: Tag[CXIdxObjCInterfaceDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxObjCInterfaceDeclInfo)
      inline def containerInfo : Ptr[CXIdxObjCContainerDeclInfo] = struct._1
      inline def containerInfo_=(value: Ptr[CXIdxObjCContainerDeclInfo]): Unit = (!struct.at1 = value)
      inline def superInfo : Ptr[CXIdxBaseClassInfo] = struct._2
      inline def superInfo_=(value: Ptr[CXIdxBaseClassInfo]): Unit = (!struct.at2 = value)
      inline def protocols : Ptr[CXIdxObjCProtocolRefListInfo] = struct._3
      inline def protocols_=(value: Ptr[CXIdxObjCProtocolRefListInfo]): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXIdxObjCInterfaceDeclInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxObjCInterfaceDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCInterfaceDeclInfo](1)
  def apply(containerInfo : Ptr[CXIdxObjCContainerDeclInfo], superInfo : Ptr[CXIdxBaseClassInfo], protocols : Ptr[CXIdxObjCProtocolRefListInfo])(using Zone): Ptr[CXIdxObjCInterfaceDeclInfo] =
    val ____ptr = apply()
    (!____ptr).containerInfo = containerInfo
    (!____ptr).superInfo = superInfo
    (!____ptr).protocols = protocols
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCPropertyDeclInfo = CStruct3[Ptr[CXIdxDeclInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo]]

object CXIdxObjCPropertyDeclInfo:
  given _tag: Tag[CXIdxObjCPropertyDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxDeclInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxObjCPropertyDeclInfo)
      inline def declInfo : Ptr[CXIdxDeclInfo] = struct._1
      inline def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = (!struct.at1 = value)
      inline def getter : Ptr[CXIdxEntityInfo] = struct._2
      inline def getter_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at2 = value)
      inline def setter : Ptr[CXIdxEntityInfo] = struct._3
      inline def setter_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXIdxObjCPropertyDeclInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxObjCPropertyDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCPropertyDeclInfo](1)
  def apply(declInfo : Ptr[CXIdxDeclInfo], getter : Ptr[CXIdxEntityInfo], setter : Ptr[CXIdxEntityInfo])(using Zone): Ptr[CXIdxObjCPropertyDeclInfo] =
    val ____ptr = apply()
    (!____ptr).declInfo = declInfo
    (!____ptr).getter = getter
    (!____ptr).setter = setter
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCProtocolRefInfo = CStruct3[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]

object CXIdxObjCProtocolRefInfo:
  given _tag: Tag[CXIdxObjCProtocolRefInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxObjCProtocolRefInfo)
      inline def protocol : Ptr[CXIdxEntityInfo] = struct._1
      inline def protocol_=(value: Ptr[CXIdxEntityInfo]): Unit = (!struct.at1 = value)
      inline def cursor : CXCursor = struct._2
      inline def cursor_=(value: CXCursor): Unit = (!struct.at2 = value)
      inline def loc : CXIdxLoc = struct._3
      inline def loc_=(value: CXIdxLoc): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXIdxObjCProtocolRefInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxObjCProtocolRefInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCProtocolRefInfo](1)
  def apply(protocol : Ptr[CXIdxEntityInfo], cursor : CXCursor, loc : CXIdxLoc)(using Zone): Ptr[CXIdxObjCProtocolRefInfo] =
    val ____ptr = apply()
    (!____ptr).protocol = protocol
    (!____ptr).cursor = cursor
    (!____ptr).loc = loc
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIdxObjCProtocolRefListInfo = CStruct2[Ptr[Ptr[CXIdxObjCProtocolRefInfo]], CUnsignedInt]

object CXIdxObjCProtocolRefListInfo:
  given _tag: Tag[CXIdxObjCProtocolRefListInfo] = Tag.materializeCStruct2Tag[Ptr[Ptr[CXIdxObjCProtocolRefInfo]], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIdxObjCProtocolRefListInfo)
      inline def protocols : Ptr[Ptr[CXIdxObjCProtocolRefInfo]] = struct._1
      inline def protocols_=(value: Ptr[Ptr[CXIdxObjCProtocolRefInfo]]): Unit = (!struct.at1 = value)
      inline def numProtocols : CUnsignedInt = struct._2
      inline def numProtocols_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXIdxObjCProtocolRefListInfo on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIdxObjCProtocolRefListInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCProtocolRefListInfo](1)
  def apply(protocols : Ptr[Ptr[CXIdxObjCProtocolRefInfo]], numProtocols : CUnsignedInt)(using Zone): Ptr[CXIdxObjCProtocolRefListInfo] =
    val ____ptr = apply()
    (!____ptr).protocols = protocols
    (!____ptr).numProtocols = numProtocols
    ____ptr



/**
 * Index initialization options.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXIndexOptions = CStruct9[CUnsignedInt, CUnsignedChar, CUnsignedChar, CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, CString, CString]

object CXIndexOptions:
  given _tag: Tag[CXIndexOptions] = Tag.materializeCStruct9Tag[CUnsignedInt, CUnsignedChar, CUnsignedChar, CUnsignedInt, CUnsignedInt, CUnsignedInt, CUnsignedInt, CString, CString]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXIndexOptions)
      inline def Size : CUnsignedInt = struct._1
      inline def Size_=(value: CUnsignedInt): Unit = (!struct.at1 = value)
      inline def ThreadBackgroundPriorityForIndexing : CUnsignedChar = struct._2
      inline def ThreadBackgroundPriorityForIndexing_=(value: CUnsignedChar): Unit = (!struct.at2 = value)
      inline def ThreadBackgroundPriorityForEditing : CUnsignedChar = struct._3
      inline def ThreadBackgroundPriorityForEditing_=(value: CUnsignedChar): Unit = (!struct.at3 = value)
      inline def ExcludeDeclarationsFromPCH : CUnsignedInt = struct._4
      inline def ExcludeDeclarationsFromPCH_=(value: CUnsignedInt): Unit = (!struct.at4 = value)
      inline def DisplayDiagnostics : CUnsignedInt = struct._5
      inline def DisplayDiagnostics_=(value: CUnsignedInt): Unit = (!struct.at5 = value)
      inline def StorePreamblesInMemory : CUnsignedInt = struct._6
      inline def StorePreamblesInMemory_=(value: CUnsignedInt): Unit = (!struct.at6 = value)
      inline def PreambleStoragePath : CString = struct._8
      inline def PreambleStoragePath_=(value: CString): Unit = (!struct.at8 = value)
      inline def InvocationEmissionPath : CString = struct._9
      inline def InvocationEmissionPath_=(value: CString): Unit = (!struct.at9 = value)
    end extension

  // Allocates CXIndexOptions on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXIndexOptions] = scala.scalanative.unsafe.alloc[CXIndexOptions](1)
  def apply(Size : CUnsignedInt, ThreadBackgroundPriorityForIndexing : CUnsignedChar, ThreadBackgroundPriorityForEditing : CUnsignedChar, ExcludeDeclarationsFromPCH : CUnsignedInt, DisplayDiagnostics : CUnsignedInt, StorePreamblesInMemory : CUnsignedInt, _1 : CUnsignedInt, PreambleStoragePath : CString, InvocationEmissionPath : CString)(using Zone): Ptr[CXIndexOptions] =
    val ____ptr = apply()
    (!____ptr).Size = Size
    (!____ptr).ThreadBackgroundPriorityForIndexing = ThreadBackgroundPriorityForIndexing
    (!____ptr).ThreadBackgroundPriorityForEditing = ThreadBackgroundPriorityForEditing
    (!____ptr).ExcludeDeclarationsFromPCH = ExcludeDeclarationsFromPCH
    (!____ptr).DisplayDiagnostics = DisplayDiagnostics
    (!____ptr).StorePreamblesInMemory = StorePreamblesInMemory
    (!____ptr).PreambleStoragePath = PreambleStoragePath
    (!____ptr).InvocationEmissionPath = InvocationEmissionPath
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
opaque type CXModuleMapDescriptorImpl = CStruct0

object CXModuleMapDescriptorImpl:
  given _tag: Tag[CXModuleMapDescriptorImpl] = Tag.materializeCStruct0Tag


/**
 * Describes the availability of a given entity on a particular platform, e.g., a particular class might only be available on Mac OS 10.7 or newer.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXPlatformAvailability = CStruct6[CXString, CXVersion, CXVersion, CXVersion, CInt, CXString]

object CXPlatformAvailability:
  given _tag: Tag[CXPlatformAvailability] = Tag.materializeCStruct6Tag[CXString, CXVersion, CXVersion, CXVersion, CInt, CXString]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXPlatformAvailability)
      inline def Platform : CXString = struct._1
      inline def Platform_=(value: CXString): Unit = (!struct.at1 = value)
      inline def Introduced : CXVersion = struct._2
      inline def Introduced_=(value: CXVersion): Unit = (!struct.at2 = value)
      inline def Deprecated : CXVersion = struct._3
      inline def Deprecated_=(value: CXVersion): Unit = (!struct.at3 = value)
      inline def Obsoleted : CXVersion = struct._4
      inline def Obsoleted_=(value: CXVersion): Unit = (!struct.at4 = value)
      inline def Unavailable : CInt = struct._5
      inline def Unavailable_=(value: CInt): Unit = (!struct.at5 = value)
      inline def Message : CXString = struct._6
      inline def Message_=(value: CXString): Unit = (!struct.at6 = value)
    end extension

  // Allocates CXPlatformAvailability on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXPlatformAvailability] = scala.scalanative.unsafe.alloc[CXPlatformAvailability](1)
  def apply(Platform : CXString, Introduced : CXVersion, Deprecated : CXVersion, Obsoleted : CXVersion, Unavailable : CInt, Message : CXString)(using Zone): Ptr[CXPlatformAvailability] =
    val ____ptr = apply()
    (!____ptr).Platform = Platform
    (!____ptr).Introduced = Introduced
    (!____ptr).Deprecated = Deprecated
    (!____ptr).Obsoleted = Obsoleted
    (!____ptr).Unavailable = Unavailable
    (!____ptr).Message = Message
    ____ptr



/**
 * Identifies a specific source location within a translation unit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
opaque type CXSourceLocation = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]

object CXSourceLocation:
  given _tag: Tag[CXSourceLocation] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXSourceLocation)
      inline def ptr_data : CArray[Ptr[Byte], Nat._2] = struct._1
      inline def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = (!struct.at1 = value)
      inline def int_data : CUnsignedInt = struct._2
      inline def int_data_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXSourceLocation on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXSourceLocation] = scala.scalanative.unsafe.alloc[CXSourceLocation](1)
  def apply(ptr_data : CArray[Ptr[Byte], Nat._2], int_data : CUnsignedInt)(using Zone): Ptr[CXSourceLocation] =
    val ____ptr = apply()
    (!____ptr).ptr_data = ptr_data
    (!____ptr).int_data = int_data
    ____ptr



/**
 * Identifies a half-open character range in the source code.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
opaque type CXSourceRange = CStruct3[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]

object CXSourceRange:
  given _tag: Tag[CXSourceRange] = Tag.materializeCStruct3Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXSourceRange)
      inline def ptr_data : CArray[Ptr[Byte], Nat._2] = struct._1
      inline def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = (!struct.at1 = value)
      inline def begin_int_data : CUnsignedInt = struct._2
      inline def begin_int_data_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
      inline def end_int_data : CUnsignedInt = struct._3
      inline def end_int_data_=(value: CUnsignedInt): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXSourceRange on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXSourceRange] = scala.scalanative.unsafe.alloc[CXSourceRange](1)
  def apply(ptr_data : CArray[Ptr[Byte], Nat._2], begin_int_data : CUnsignedInt, end_int_data : CUnsignedInt)(using Zone): Ptr[CXSourceRange] =
    val ____ptr = apply()
    (!____ptr).ptr_data = ptr_data
    (!____ptr).begin_int_data = begin_int_data
    (!____ptr).end_int_data = end_int_data
    ____ptr



/**
 * Identifies an array of ranges.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXSourceLocation.h
*/
opaque type CXSourceRangeList = CStruct2[CUnsignedInt, Ptr[CXSourceRange]]

object CXSourceRangeList:
  given _tag: Tag[CXSourceRangeList] = Tag.materializeCStruct2Tag[CUnsignedInt, Ptr[CXSourceRange]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXSourceRangeList)
      inline def count : CUnsignedInt = struct._1
      inline def count_=(value: CUnsignedInt): Unit = (!struct.at1 = value)
      inline def ranges : Ptr[CXSourceRange] = struct._2
      inline def ranges_=(value: Ptr[CXSourceRange]): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXSourceRangeList on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXSourceRangeList] = scala.scalanative.unsafe.alloc[CXSourceRangeList](1)
  def apply(count : CUnsignedInt, ranges : Ptr[CXSourceRange])(using Zone): Ptr[CXSourceRangeList] =
    val ____ptr = apply()
    (!____ptr).count = count
    (!____ptr).ranges = ranges
    ____ptr



/**
 * A character string.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
opaque type CXString = CStruct2[Ptr[Byte], CUnsignedInt]

object CXString:
  given _tag: Tag[CXString] = Tag.materializeCStruct2Tag[Ptr[Byte], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXString)
      inline def data : Ptr[Byte] = struct._1
      inline def data_=(value: Ptr[Byte]): Unit = (!struct.at1 = value)
      inline def private_flags : CUnsignedInt = struct._2
      inline def private_flags_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXString on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXString] = scala.scalanative.unsafe.alloc[CXString](1)
  def apply(data : Ptr[Byte], private_flags : CUnsignedInt)(using Zone): Ptr[CXString] =
    val ____ptr = apply()
    (!____ptr).data = data
    (!____ptr).private_flags = private_flags
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/CXString.h
*/
opaque type CXStringSet = CStruct2[Ptr[CXString], CUnsignedInt]

object CXStringSet:
  given _tag: Tag[CXStringSet] = Tag.materializeCStruct2Tag[Ptr[CXString], CUnsignedInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXStringSet)
      inline def Strings : Ptr[CXString] = struct._1
      inline def Strings_=(value: Ptr[CXString]): Unit = (!struct.at1 = value)
      inline def Count : CUnsignedInt = struct._2
      inline def Count_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXStringSet on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXStringSet] = scala.scalanative.unsafe.alloc[CXStringSet](1)
  def apply(Strings : Ptr[CXString], Count : CUnsignedInt)(using Zone): Ptr[CXStringSet] =
    val ____ptr = apply()
    (!____ptr).Strings = Strings
    (!____ptr).Count = Count
    ____ptr



/**
 * The memory usage of a CXTranslationUnit, broken into categories.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTUResourceUsage = CStruct3[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]

object CXTUResourceUsage:
  given _tag: Tag[CXTUResourceUsage] = Tag.materializeCStruct3Tag[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXTUResourceUsage)
      inline def data : Ptr[Byte] = struct._1
      inline def data_=(value: Ptr[Byte]): Unit = (!struct.at1 = value)
      inline def numEntries : CUnsignedInt = struct._2
      inline def numEntries_=(value: CUnsignedInt): Unit = (!struct.at2 = value)
      inline def entries : Ptr[CXTUResourceUsageEntry] = struct._3
      inline def entries_=(value: Ptr[CXTUResourceUsageEntry]): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXTUResourceUsage on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXTUResourceUsage] = scala.scalanative.unsafe.alloc[CXTUResourceUsage](1)
  def apply(data : Ptr[Byte], numEntries : CUnsignedInt, entries : Ptr[CXTUResourceUsageEntry])(using Zone): Ptr[CXTUResourceUsage] =
    val ____ptr = apply()
    (!____ptr).data = data
    (!____ptr).numEntries = numEntries
    (!____ptr).entries = entries
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTUResourceUsageEntry = CStruct2[CXTUResourceUsageKind, CUnsignedLongInt]

object CXTUResourceUsageEntry:
  given _tag: Tag[CXTUResourceUsageEntry] = Tag.materializeCStruct2Tag[CXTUResourceUsageKind, CUnsignedLongInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXTUResourceUsageEntry)
      inline def kind : CXTUResourceUsageKind = struct._1
      inline def kind_=(value: CXTUResourceUsageKind): Unit = (!struct.at1 = value)
      inline def amount : CUnsignedLongInt = struct._2
      inline def amount_=(value: CUnsignedLongInt): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXTUResourceUsageEntry on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXTUResourceUsageEntry] = scala.scalanative.unsafe.alloc[CXTUResourceUsageEntry](1)
  def apply(kind : CXTUResourceUsageKind, amount : CUnsignedLongInt)(using Zone): Ptr[CXTUResourceUsageEntry] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).amount = amount
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTargetInfoImpl = CStruct0

object CXTargetInfoImpl:
  given _tag: Tag[CXTargetInfoImpl] = Tag.materializeCStruct0Tag


/**
 * Describes a single preprocessing token.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXToken = CStruct2[CArray[CUnsignedInt, Nat._4], Ptr[Byte]]

object CXToken:
  given _tag: Tag[CXToken] = Tag.materializeCStruct2Tag[CArray[CUnsignedInt, Nat._4], Ptr[Byte]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXToken)
      inline def int_data : CArray[CUnsignedInt, Nat._4] = struct._1
      inline def int_data_=(value: CArray[CUnsignedInt, Nat._4]): Unit = (!struct.at1 = value)
      inline def ptr_data : Ptr[Byte] = struct._2
      inline def ptr_data_=(value: Ptr[Byte]): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXToken on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXToken] = scala.scalanative.unsafe.alloc[CXToken](1)
  def apply(int_data : CArray[CUnsignedInt, Nat._4], ptr_data : Ptr[Byte])(using Zone): Ptr[CXToken] =
    val ____ptr = apply()
    (!____ptr).int_data = int_data
    (!____ptr).ptr_data = ptr_data
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXTranslationUnitImpl = CStruct0

object CXTranslationUnitImpl:
  given _tag: Tag[CXTranslationUnitImpl] = Tag.materializeCStruct0Tag


/**
 * The type of an element in the abstract syntax tree.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXType = CStruct2[CXTypeKind, CArray[Ptr[Byte], Nat._2]]

object CXType:
  given _tag: Tag[CXType] = Tag.materializeCStruct2Tag[CXTypeKind, CArray[Ptr[Byte], Nat._2]]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXType)
      inline def kind : CXTypeKind = struct._1
      inline def kind_=(value: CXTypeKind): Unit = (!struct.at1 = value)
      inline def data : CArray[Ptr[Byte], Nat._2] = struct._2
      inline def data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = (!struct.at2 = value)
    end extension

  // Allocates CXType on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXType] = scala.scalanative.unsafe.alloc[CXType](1)
  def apply(kind : CXTypeKind, data : CArray[Ptr[Byte], Nat._2])(using Zone): Ptr[CXType] =
    val ____ptr = apply()
    (!____ptr).kind = kind
    (!____ptr).data = data
    ____ptr



/**
 * Provides the contents of a file that has not yet been saved to disk.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXUnsavedFile = CStruct3[CString, CString, CUnsignedLongInt]

object CXUnsavedFile:
  given _tag: Tag[CXUnsavedFile] = Tag.materializeCStruct3Tag[CString, CString, CUnsignedLongInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXUnsavedFile)
      inline def Filename : CString = struct._1
      inline def Filename_=(value: CString): Unit = (!struct.at1 = value)
      inline def Contents : CString = struct._2
      inline def Contents_=(value: CString): Unit = (!struct.at2 = value)
      inline def Length : CUnsignedLongInt = struct._3
      inline def Length_=(value: CUnsignedLongInt): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXUnsavedFile on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXUnsavedFile] = scala.scalanative.unsafe.alloc[CXUnsavedFile](1)
  def apply(Filename : CString, Contents : CString, Length : CUnsignedLongInt)(using Zone): Ptr[CXUnsavedFile] =
    val ____ptr = apply()
    (!____ptr).Filename = Filename
    (!____ptr).Contents = Contents
    (!____ptr).Length = Length
    ____ptr



/**
 * Describes a version number of the form major.minor.subminor.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type CXVersion = CStruct3[CInt, CInt, CInt]

object CXVersion:
  given _tag: Tag[CXVersion] = Tag.materializeCStruct3Tag[CInt, CInt, CInt]

  export fields.*
  private[libclang] object fields:
    extension (struct: CXVersion)
      inline def Major : CInt = struct._1
      inline def Major_=(value: CInt): Unit = (!struct.at1 = value)
      inline def Minor : CInt = struct._2
      inline def Minor_=(value: CInt): Unit = (!struct.at2 = value)
      inline def Subminor : CInt = struct._3
      inline def Subminor_=(value: CInt): Unit = (!struct.at3 = value)
    end extension

  // Allocates CXVersion on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[CXVersion] = scala.scalanative.unsafe.alloc[CXVersion](1)
  def apply(Major : CInt, Minor : CInt, Subminor : CInt)(using Zone): Ptr[CXVersion] =
    val ____ptr = apply()
    (!____ptr).Major = Major
    (!____ptr).Minor = Minor
    (!____ptr).Subminor = Subminor
    ____ptr



/**
 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/BuildSystem.h
*/
opaque type CXVirtualFileOverlayImpl = CStruct0

object CXVirtualFileOverlayImpl:
  given _tag: Tag[CXVirtualFileOverlayImpl] = Tag.materializeCStruct0Tag


/**
 * A group of callbacks used by #clang_indexSourceFile and #clang_indexTranslationUnit.

 * [bindgen] header: /opt/homebrew/opt/llvm@17/include/clang-c/Index.h
*/
opaque type IndexerCallbacks = CStruct8[CFuncPtr2[CXClientData, Ptr[Byte], CInt], CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit], CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile], CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile], CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile], CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer], CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit], CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]

object IndexerCallbacks:
  given _tag: Tag[IndexerCallbacks] = Tag.materializeCStruct8Tag[CFuncPtr2[CXClientData, Ptr[Byte], CInt], CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit], CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile], CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile], CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile], CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer], CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit], CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]

  export fields.*
  private[libclang] object fields:
    extension (struct: IndexerCallbacks)
      inline def abortQuery : CFuncPtr2[CXClientData, Ptr[Byte], CInt] = struct._1
      inline def abortQuery_=(value: CFuncPtr2[CXClientData, Ptr[Byte], CInt]): Unit = (!struct.at1 = value)
      inline def diagnostic : CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit] = struct._2
      inline def diagnostic_=(value: CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]): Unit = (!struct.at2 = value)
      inline def enteredMainFile : CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile] = struct._3
      inline def enteredMainFile_=(value: CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]): Unit = (!struct.at3 = value)
      inline def ppIncludedFile : CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile] = struct._4
      inline def ppIncludedFile_=(value: CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]): Unit = (!struct.at4 = value)
      inline def importedASTFile : CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile] = struct._5
      inline def importedASTFile_=(value: CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]): Unit = (!struct.at5 = value)
      inline def startedTranslationUnit : CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer] = struct._6
      inline def startedTranslationUnit_=(value: CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]): Unit = (!struct.at6 = value)
      inline def indexDeclaration : CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit] = struct._7
      inline def indexDeclaration_=(value: CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]): Unit = (!struct.at7 = value)
      inline def indexEntityReference : CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit] = struct._8
      inline def indexEntityReference_=(value: CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]): Unit = (!struct.at8 = value)
    end extension

  // Allocates IndexerCallbacks on the heap – fields are not initalised or zeroed out
  def apply()(using Zone): Ptr[IndexerCallbacks] = scala.scalanative.unsafe.alloc[IndexerCallbacks](1)
  def apply(abortQuery : CFuncPtr2[CXClientData, Ptr[Byte], CInt], diagnostic : CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit], enteredMainFile : CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile], ppIncludedFile : CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile], importedASTFile : CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile], startedTranslationUnit : CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer], indexDeclaration : CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit], indexEntityReference : CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit])(using Zone): Ptr[IndexerCallbacks] =
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
