package libclang

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import scalanative.libc.*

object predef:  
  abstract class CEnum[T](using eq: T =:= Int):
    given Tag[T] = Tag.Int.asInstanceOf[Tag[T]]
    extension (t: T) def int: CInt = eq.apply(t)
  
  abstract class CEnumU[T](using eq: T =:= UInt):
    given Tag[T] = Tag.UInt.asInstanceOf[Tag[T]]
    extension (t: T)
     def int: CInt = eq.apply(t).toInt
     def uint: CUnsignedInt = eq.apply(t)
      
object types:
  import predef.*
  opaque type CXAvailabilityKind = CUnsignedInt
  object CXAvailabilityKind extends CEnumU[CXAvailabilityKind]:
    inline def define(inline a: Long): CXAvailabilityKind = a.toUInt
    val CXAvailability_Available = define(0)
    val CXAvailability_Deprecated = define(1)
    val CXAvailability_NotAvailable = define(2)
    val CXAvailability_NotAccessible = define(3)

  opaque type CXCallingConv = CUnsignedInt
  object CXCallingConv extends CEnumU[CXCallingConv]:
    inline def define(inline a: Long): CXCallingConv = a.toUInt
    val CXCallingConv_Default = define(0)
    val CXCallingConv_C = define(1)
    val CXCallingConv_X86StdCall = define(2)
    val CXCallingConv_X86FastCall = define(3)
    val CXCallingConv_X86ThisCall = define(4)
    val CXCallingConv_X86Pascal = define(5)
    val CXCallingConv_AAPCS = define(6)
    val CXCallingConv_AAPCS_VFP = define(7)
    val CXCallingConv_X86RegCall = define(8)
    val CXCallingConv_IntelOclBicc = define(9)
    val CXCallingConv_Win64 = define(10)
    val CXCallingConv_X86_64Win64 = define(10)
    val CXCallingConv_X86_64SysV = define(11)
    val CXCallingConv_X86VectorCall = define(12)
    val CXCallingConv_Swift = define(13)
    val CXCallingConv_PreserveMost = define(14)
    val CXCallingConv_PreserveAll = define(15)
    val CXCallingConv_AArch64VectorCall = define(16)
    val CXCallingConv_SwiftAsync = define(17)
    val CXCallingConv_Invalid = define(100)
    val CXCallingConv_Unexposed = define(200)

  opaque type CXChildVisitResult = CUnsignedInt
  object CXChildVisitResult extends CEnumU[CXChildVisitResult]:
    inline def define(inline a: Long): CXChildVisitResult = a.toUInt
    val CXChildVisit_Break = define(0)
    val CXChildVisit_Continue = define(1)
    val CXChildVisit_Recurse = define(2)

  opaque type CXCodeComplete_Flags = CUnsignedInt
  object CXCodeComplete_Flags extends CEnumU[CXCodeComplete_Flags]:
    inline def define(inline a: Long): CXCodeComplete_Flags = a.toUInt
    val CXCodeComplete_IncludeMacros = define(1)
    val CXCodeComplete_IncludeCodePatterns = define(2)
    val CXCodeComplete_IncludeBriefComments = define(4)
    val CXCodeComplete_SkipPreamble = define(8)
    val CXCodeComplete_IncludeCompletionsWithFixIts = define(16)

  opaque type CXCompletionChunkKind = CUnsignedInt
  object CXCompletionChunkKind extends CEnumU[CXCompletionChunkKind]:
    inline def define(inline a: Long): CXCompletionChunkKind = a.toUInt
    val CXCompletionChunk_Optional = define(0)
    val CXCompletionChunk_TypedText = define(1)
    val CXCompletionChunk_Text = define(2)
    val CXCompletionChunk_Placeholder = define(3)
    val CXCompletionChunk_Informative = define(4)
    val CXCompletionChunk_CurrentParameter = define(5)
    val CXCompletionChunk_LeftParen = define(6)
    val CXCompletionChunk_RightParen = define(7)
    val CXCompletionChunk_LeftBracket = define(8)
    val CXCompletionChunk_RightBracket = define(9)
    val CXCompletionChunk_LeftBrace = define(10)
    val CXCompletionChunk_RightBrace = define(11)
    val CXCompletionChunk_LeftAngle = define(12)
    val CXCompletionChunk_RightAngle = define(13)
    val CXCompletionChunk_Comma = define(14)
    val CXCompletionChunk_ResultType = define(15)
    val CXCompletionChunk_Colon = define(16)
    val CXCompletionChunk_SemiColon = define(17)
    val CXCompletionChunk_Equal = define(18)
    val CXCompletionChunk_HorizontalSpace = define(19)
    val CXCompletionChunk_VerticalSpace = define(20)

  opaque type CXCompletionContext = CUnsignedInt
  object CXCompletionContext extends CEnumU[CXCompletionContext]:
    inline def define(inline a: Long): CXCompletionContext = a.toUInt
    val CXCompletionContext_Unexposed = define(0)
    val CXCompletionContext_AnyType = define(1)
    val CXCompletionContext_AnyValue = define(2)
    val CXCompletionContext_ObjCObjectValue = define(4)
    val CXCompletionContext_ObjCSelectorValue = define(8)
    val CXCompletionContext_CXXClassTypeValue = define(16)
    val CXCompletionContext_DotMemberAccess = define(32)
    val CXCompletionContext_ArrowMemberAccess = define(64)
    val CXCompletionContext_ObjCPropertyAccess = define(128)
    val CXCompletionContext_EnumTag = define(256)
    val CXCompletionContext_UnionTag = define(512)
    val CXCompletionContext_StructTag = define(1024)
    val CXCompletionContext_ClassTag = define(2048)
    val CXCompletionContext_Namespace = define(4096)
    val CXCompletionContext_NestedNameSpecifier = define(8192)
    val CXCompletionContext_ObjCInterface = define(16384)
    val CXCompletionContext_ObjCProtocol = define(32768)
    val CXCompletionContext_ObjCCategory = define(65536)
    val CXCompletionContext_ObjCInstanceMessage = define(131072)
    val CXCompletionContext_ObjCClassMessage = define(262144)
    val CXCompletionContext_ObjCSelectorName = define(524288)
    val CXCompletionContext_MacroName = define(1048576)
    val CXCompletionContext_NaturalLanguage = define(2097152)
    val CXCompletionContext_IncludedFile = define(4194304)
    val CXCompletionContext_Unknown = define(8388607)

  opaque type CXCursorKind = CUnsignedInt
  object CXCursorKind extends CEnumU[CXCursorKind]:
    inline def define(inline a: Long): CXCursorKind = a.toUInt
    val CXCursor_UnexposedDecl = define(1)
    val CXCursor_StructDecl = define(2)
    val CXCursor_UnionDecl = define(3)
    val CXCursor_ClassDecl = define(4)
    val CXCursor_EnumDecl = define(5)
    val CXCursor_FieldDecl = define(6)
    val CXCursor_EnumConstantDecl = define(7)
    val CXCursor_FunctionDecl = define(8)
    val CXCursor_VarDecl = define(9)
    val CXCursor_ParmDecl = define(10)
    val CXCursor_ObjCInterfaceDecl = define(11)
    val CXCursor_ObjCCategoryDecl = define(12)
    val CXCursor_ObjCProtocolDecl = define(13)
    val CXCursor_ObjCPropertyDecl = define(14)
    val CXCursor_ObjCIvarDecl = define(15)
    val CXCursor_ObjCInstanceMethodDecl = define(16)
    val CXCursor_ObjCClassMethodDecl = define(17)
    val CXCursor_ObjCImplementationDecl = define(18)
    val CXCursor_ObjCCategoryImplDecl = define(19)
    val CXCursor_TypedefDecl = define(20)
    val CXCursor_CXXMethod = define(21)
    val CXCursor_Namespace = define(22)
    val CXCursor_LinkageSpec = define(23)
    val CXCursor_Constructor = define(24)
    val CXCursor_Destructor = define(25)
    val CXCursor_ConversionFunction = define(26)
    val CXCursor_TemplateTypeParameter = define(27)
    val CXCursor_NonTypeTemplateParameter = define(28)
    val CXCursor_TemplateTemplateParameter = define(29)
    val CXCursor_FunctionTemplate = define(30)
    val CXCursor_ClassTemplate = define(31)
    val CXCursor_ClassTemplatePartialSpecialization = define(32)
    val CXCursor_NamespaceAlias = define(33)
    val CXCursor_UsingDirective = define(34)
    val CXCursor_UsingDeclaration = define(35)
    val CXCursor_TypeAliasDecl = define(36)
    val CXCursor_ObjCSynthesizeDecl = define(37)
    val CXCursor_ObjCDynamicDecl = define(38)
    val CXCursor_CXXAccessSpecifier = define(39)
    val CXCursor_FirstDecl = define(1)
    val CXCursor_LastDecl = define(39)
    val CXCursor_FirstRef = define(40)
    val CXCursor_ObjCSuperClassRef = define(40)
    val CXCursor_ObjCProtocolRef = define(41)
    val CXCursor_ObjCClassRef = define(42)
    val CXCursor_TypeRef = define(43)
    val CXCursor_CXXBaseSpecifier = define(44)
    val CXCursor_TemplateRef = define(45)
    val CXCursor_NamespaceRef = define(46)
    val CXCursor_MemberRef = define(47)
    val CXCursor_LabelRef = define(48)
    val CXCursor_OverloadedDeclRef = define(49)
    val CXCursor_VariableRef = define(50)
    val CXCursor_LastRef = define(50)
    val CXCursor_FirstInvalid = define(70)
    val CXCursor_InvalidFile = define(70)
    val CXCursor_NoDeclFound = define(71)
    val CXCursor_NotImplemented = define(72)
    val CXCursor_InvalidCode = define(73)
    val CXCursor_LastInvalid = define(73)
    val CXCursor_FirstExpr = define(100)
    val CXCursor_UnexposedExpr = define(100)
    val CXCursor_DeclRefExpr = define(101)
    val CXCursor_MemberRefExpr = define(102)
    val CXCursor_CallExpr = define(103)
    val CXCursor_ObjCMessageExpr = define(104)
    val CXCursor_BlockExpr = define(105)
    val CXCursor_IntegerLiteral = define(106)
    val CXCursor_FloatingLiteral = define(107)
    val CXCursor_ImaginaryLiteral = define(108)
    val CXCursor_StringLiteral = define(109)
    val CXCursor_CharacterLiteral = define(110)
    val CXCursor_ParenExpr = define(111)
    val CXCursor_UnaryOperator = define(112)
    val CXCursor_ArraySubscriptExpr = define(113)
    val CXCursor_BinaryOperator = define(114)
    val CXCursor_CompoundAssignOperator = define(115)
    val CXCursor_ConditionalOperator = define(116)
    val CXCursor_CStyleCastExpr = define(117)
    val CXCursor_CompoundLiteralExpr = define(118)
    val CXCursor_InitListExpr = define(119)
    val CXCursor_AddrLabelExpr = define(120)
    val CXCursor_StmtExpr = define(121)
    val CXCursor_GenericSelectionExpr = define(122)
    val CXCursor_GNUNullExpr = define(123)
    val CXCursor_CXXStaticCastExpr = define(124)
    val CXCursor_CXXDynamicCastExpr = define(125)
    val CXCursor_CXXReinterpretCastExpr = define(126)
    val CXCursor_CXXConstCastExpr = define(127)
    val CXCursor_CXXFunctionalCastExpr = define(128)
    val CXCursor_CXXTypeidExpr = define(129)
    val CXCursor_CXXBoolLiteralExpr = define(130)
    val CXCursor_CXXNullPtrLiteralExpr = define(131)
    val CXCursor_CXXThisExpr = define(132)
    val CXCursor_CXXThrowExpr = define(133)
    val CXCursor_CXXNewExpr = define(134)
    val CXCursor_CXXDeleteExpr = define(135)
    val CXCursor_UnaryExpr = define(136)
    val CXCursor_ObjCStringLiteral = define(137)
    val CXCursor_ObjCEncodeExpr = define(138)
    val CXCursor_ObjCSelectorExpr = define(139)
    val CXCursor_ObjCProtocolExpr = define(140)
    val CXCursor_ObjCBridgedCastExpr = define(141)
    val CXCursor_PackExpansionExpr = define(142)
    val CXCursor_SizeOfPackExpr = define(143)
    val CXCursor_LambdaExpr = define(144)
    val CXCursor_ObjCBoolLiteralExpr = define(145)
    val CXCursor_ObjCSelfExpr = define(146)
    val CXCursor_OMPArraySectionExpr = define(147)
    val CXCursor_ObjCAvailabilityCheckExpr = define(148)
    val CXCursor_FixedPointLiteral = define(149)
    val CXCursor_OMPArrayShapingExpr = define(150)
    val CXCursor_OMPIteratorExpr = define(151)
    val CXCursor_CXXAddrspaceCastExpr = define(152)
    val CXCursor_LastExpr = define(152)
    val CXCursor_FirstStmt = define(200)
    val CXCursor_UnexposedStmt = define(200)
    val CXCursor_LabelStmt = define(201)
    val CXCursor_CompoundStmt = define(202)
    val CXCursor_CaseStmt = define(203)
    val CXCursor_DefaultStmt = define(204)
    val CXCursor_IfStmt = define(205)
    val CXCursor_SwitchStmt = define(206)
    val CXCursor_WhileStmt = define(207)
    val CXCursor_DoStmt = define(208)
    val CXCursor_ForStmt = define(209)
    val CXCursor_GotoStmt = define(210)
    val CXCursor_IndirectGotoStmt = define(211)
    val CXCursor_ContinueStmt = define(212)
    val CXCursor_BreakStmt = define(213)
    val CXCursor_ReturnStmt = define(214)
    val CXCursor_GCCAsmStmt = define(215)
    val CXCursor_AsmStmt = define(215)
    val CXCursor_ObjCAtTryStmt = define(216)
    val CXCursor_ObjCAtCatchStmt = define(217)
    val CXCursor_ObjCAtFinallyStmt = define(218)
    val CXCursor_ObjCAtThrowStmt = define(219)
    val CXCursor_ObjCAtSynchronizedStmt = define(220)
    val CXCursor_ObjCAutoreleasePoolStmt = define(221)
    val CXCursor_ObjCForCollectionStmt = define(222)
    val CXCursor_CXXCatchStmt = define(223)
    val CXCursor_CXXTryStmt = define(224)
    val CXCursor_CXXForRangeStmt = define(225)
    val CXCursor_SEHTryStmt = define(226)
    val CXCursor_SEHExceptStmt = define(227)
    val CXCursor_SEHFinallyStmt = define(228)
    val CXCursor_MSAsmStmt = define(229)
    val CXCursor_NullStmt = define(230)
    val CXCursor_DeclStmt = define(231)
    val CXCursor_OMPParallelDirective = define(232)
    val CXCursor_OMPSimdDirective = define(233)
    val CXCursor_OMPForDirective = define(234)
    val CXCursor_OMPSectionsDirective = define(235)
    val CXCursor_OMPSectionDirective = define(236)
    val CXCursor_OMPSingleDirective = define(237)
    val CXCursor_OMPParallelForDirective = define(238)
    val CXCursor_OMPParallelSectionsDirective = define(239)
    val CXCursor_OMPTaskDirective = define(240)
    val CXCursor_OMPMasterDirective = define(241)
    val CXCursor_OMPCriticalDirective = define(242)
    val CXCursor_OMPTaskyieldDirective = define(243)
    val CXCursor_OMPBarrierDirective = define(244)
    val CXCursor_OMPTaskwaitDirective = define(245)
    val CXCursor_OMPFlushDirective = define(246)
    val CXCursor_SEHLeaveStmt = define(247)
    val CXCursor_OMPOrderedDirective = define(248)
    val CXCursor_OMPAtomicDirective = define(249)
    val CXCursor_OMPForSimdDirective = define(250)
    val CXCursor_OMPParallelForSimdDirective = define(251)
    val CXCursor_OMPTargetDirective = define(252)
    val CXCursor_OMPTeamsDirective = define(253)
    val CXCursor_OMPTaskgroupDirective = define(254)
    val CXCursor_OMPCancellationPointDirective = define(255)
    val CXCursor_OMPCancelDirective = define(256)
    val CXCursor_OMPTargetDataDirective = define(257)
    val CXCursor_OMPTaskLoopDirective = define(258)
    val CXCursor_OMPTaskLoopSimdDirective = define(259)
    val CXCursor_OMPDistributeDirective = define(260)
    val CXCursor_OMPTargetEnterDataDirective = define(261)
    val CXCursor_OMPTargetExitDataDirective = define(262)
    val CXCursor_OMPTargetParallelDirective = define(263)
    val CXCursor_OMPTargetParallelForDirective = define(264)
    val CXCursor_OMPTargetUpdateDirective = define(265)
    val CXCursor_OMPDistributeParallelForDirective = define(266)
    val CXCursor_OMPDistributeParallelForSimdDirective = define(267)
    val CXCursor_OMPDistributeSimdDirective = define(268)
    val CXCursor_OMPTargetParallelForSimdDirective = define(269)
    val CXCursor_OMPTargetSimdDirective = define(270)
    val CXCursor_OMPTeamsDistributeDirective = define(271)
    val CXCursor_OMPTeamsDistributeSimdDirective = define(272)
    val CXCursor_OMPTeamsDistributeParallelForSimdDirective = define(273)
    val CXCursor_OMPTeamsDistributeParallelForDirective = define(274)
    val CXCursor_OMPTargetTeamsDirective = define(275)
    val CXCursor_OMPTargetTeamsDistributeDirective = define(276)
    val CXCursor_OMPTargetTeamsDistributeParallelForDirective = define(277)
    val CXCursor_OMPTargetTeamsDistributeParallelForSimdDirective = define(278)
    val CXCursor_OMPTargetTeamsDistributeSimdDirective = define(279)
    val CXCursor_BuiltinBitCastExpr = define(280)
    val CXCursor_OMPMasterTaskLoopDirective = define(281)
    val CXCursor_OMPParallelMasterTaskLoopDirective = define(282)
    val CXCursor_OMPMasterTaskLoopSimdDirective = define(283)
    val CXCursor_OMPParallelMasterTaskLoopSimdDirective = define(284)
    val CXCursor_OMPParallelMasterDirective = define(285)
    val CXCursor_OMPDepobjDirective = define(286)
    val CXCursor_OMPScanDirective = define(287)
    val CXCursor_OMPTileDirective = define(288)
    val CXCursor_OMPCanonicalLoop = define(289)
    val CXCursor_OMPInteropDirective = define(290)
    val CXCursor_OMPDispatchDirective = define(291)
    val CXCursor_OMPMaskedDirective = define(292)
    val CXCursor_OMPUnrollDirective = define(293)
    val CXCursor_OMPMetaDirective = define(294)
    val CXCursor_OMPGenericLoopDirective = define(295)
    val CXCursor_LastStmt = define(295)
    val CXCursor_TranslationUnit = define(300)
    val CXCursor_FirstAttr = define(400)
    val CXCursor_UnexposedAttr = define(400)
    val CXCursor_IBActionAttr = define(401)
    val CXCursor_IBOutletAttr = define(402)
    val CXCursor_IBOutletCollectionAttr = define(403)
    val CXCursor_CXXFinalAttr = define(404)
    val CXCursor_CXXOverrideAttr = define(405)
    val CXCursor_AnnotateAttr = define(406)
    val CXCursor_AsmLabelAttr = define(407)
    val CXCursor_PackedAttr = define(408)
    val CXCursor_PureAttr = define(409)
    val CXCursor_ConstAttr = define(410)
    val CXCursor_NoDuplicateAttr = define(411)
    val CXCursor_CUDAConstantAttr = define(412)
    val CXCursor_CUDADeviceAttr = define(413)
    val CXCursor_CUDAGlobalAttr = define(414)
    val CXCursor_CUDAHostAttr = define(415)
    val CXCursor_CUDASharedAttr = define(416)
    val CXCursor_VisibilityAttr = define(417)
    val CXCursor_DLLExport = define(418)
    val CXCursor_DLLImport = define(419)
    val CXCursor_NSReturnsRetained = define(420)
    val CXCursor_NSReturnsNotRetained = define(421)
    val CXCursor_NSReturnsAutoreleased = define(422)
    val CXCursor_NSConsumesSelf = define(423)
    val CXCursor_NSConsumed = define(424)
    val CXCursor_ObjCException = define(425)
    val CXCursor_ObjCNSObject = define(426)
    val CXCursor_ObjCIndependentClass = define(427)
    val CXCursor_ObjCPreciseLifetime = define(428)
    val CXCursor_ObjCReturnsInnerPointer = define(429)
    val CXCursor_ObjCRequiresSuper = define(430)
    val CXCursor_ObjCRootClass = define(431)
    val CXCursor_ObjCSubclassingRestricted = define(432)
    val CXCursor_ObjCExplicitProtocolImpl = define(433)
    val CXCursor_ObjCDesignatedInitializer = define(434)
    val CXCursor_ObjCRuntimeVisible = define(435)
    val CXCursor_ObjCBoxable = define(436)
    val CXCursor_FlagEnum = define(437)
    val CXCursor_ConvergentAttr = define(438)
    val CXCursor_WarnUnusedAttr = define(439)
    val CXCursor_WarnUnusedResultAttr = define(440)
    val CXCursor_AlignedAttr = define(441)
    val CXCursor_LastAttr = define(441)
    val CXCursor_PreprocessingDirective = define(500)
    val CXCursor_MacroDefinition = define(501)
    val CXCursor_MacroExpansion = define(502)
    val CXCursor_MacroInstantiation = define(502)
    val CXCursor_InclusionDirective = define(503)
    val CXCursor_FirstPreprocessing = define(500)
    val CXCursor_LastPreprocessing = define(503)
    val CXCursor_ModuleImportDecl = define(600)
    val CXCursor_TypeAliasTemplateDecl = define(601)
    val CXCursor_StaticAssert = define(602)
    val CXCursor_FriendDecl = define(603)
    val CXCursor_FirstExtraDecl = define(600)
    val CXCursor_LastExtraDecl = define(603)
    val CXCursor_OverloadCandidate = define(700)

  opaque type CXCursor_ExceptionSpecificationKind = CUnsignedInt
  object CXCursor_ExceptionSpecificationKind extends CEnumU[CXCursor_ExceptionSpecificationKind]:
    inline def define(inline a: Long): CXCursor_ExceptionSpecificationKind = a.toUInt
    val CXCursor_ExceptionSpecificationKind_None = define(0)
    val CXCursor_ExceptionSpecificationKind_DynamicNone = define(1)
    val CXCursor_ExceptionSpecificationKind_Dynamic = define(2)
    val CXCursor_ExceptionSpecificationKind_MSAny = define(3)
    val CXCursor_ExceptionSpecificationKind_BasicNoexcept = define(4)
    val CXCursor_ExceptionSpecificationKind_ComputedNoexcept = define(5)
    val CXCursor_ExceptionSpecificationKind_Unevaluated = define(6)
    val CXCursor_ExceptionSpecificationKind_Uninstantiated = define(7)
    val CXCursor_ExceptionSpecificationKind_Unparsed = define(8)
    val CXCursor_ExceptionSpecificationKind_NoThrow = define(9)

  opaque type CXDiagnosticDisplayOptions = CUnsignedInt
  object CXDiagnosticDisplayOptions extends CEnumU[CXDiagnosticDisplayOptions]:
    inline def define(inline a: Long): CXDiagnosticDisplayOptions = a.toUInt
    val CXDiagnostic_DisplaySourceLocation = define(1)
    val CXDiagnostic_DisplayColumn = define(2)
    val CXDiagnostic_DisplaySourceRanges = define(4)
    val CXDiagnostic_DisplayOption = define(8)
    val CXDiagnostic_DisplayCategoryId = define(16)
    val CXDiagnostic_DisplayCategoryName = define(32)

  opaque type CXDiagnosticSeverity = CUnsignedInt
  object CXDiagnosticSeverity extends CEnumU[CXDiagnosticSeverity]:
    inline def define(inline a: Long): CXDiagnosticSeverity = a.toUInt
    val CXDiagnostic_Ignored = define(0)
    val CXDiagnostic_Note = define(1)
    val CXDiagnostic_Warning = define(2)
    val CXDiagnostic_Error = define(3)
    val CXDiagnostic_Fatal = define(4)

  opaque type CXErrorCode = CUnsignedInt
  object CXErrorCode extends CEnumU[CXErrorCode]:
    inline def define(inline a: Long): CXErrorCode = a.toUInt
    val CXError_Success = define(0)
    val CXError_Failure = define(1)
    val CXError_Crashed = define(2)
    val CXError_InvalidArguments = define(3)
    val CXError_ASTReadError = define(4)

  opaque type CXEvalResultKind = CUnsignedInt
  object CXEvalResultKind extends CEnumU[CXEvalResultKind]:
    inline def define(inline a: Long): CXEvalResultKind = a.toUInt
    val CXEval_Int = define(1)
    val CXEval_Float = define(2)
    val CXEval_ObjCStrLiteral = define(3)
    val CXEval_StrLiteral = define(4)
    val CXEval_CFStr = define(5)
    val CXEval_Other = define(6)
    val CXEval_UnExposed = define(0)

  opaque type CXGlobalOptFlags = CUnsignedInt
  object CXGlobalOptFlags extends CEnumU[CXGlobalOptFlags]:
    inline def define(inline a: Long): CXGlobalOptFlags = a.toUInt
    val CXGlobalOpt_None = define(0)
    val CXGlobalOpt_ThreadBackgroundPriorityForIndexing = define(1)
    val CXGlobalOpt_ThreadBackgroundPriorityForEditing = define(2)
    val CXGlobalOpt_ThreadBackgroundPriorityForAll = define(3)

  opaque type CXIdxAttrKind = CUnsignedInt
  object CXIdxAttrKind extends CEnumU[CXIdxAttrKind]:
    inline def define(inline a: Long): CXIdxAttrKind = a.toUInt
    val CXIdxAttr_Unexposed = define(0)
    val CXIdxAttr_IBAction = define(1)
    val CXIdxAttr_IBOutlet = define(2)
    val CXIdxAttr_IBOutletCollection = define(3)

  opaque type CXIdxDeclInfoFlags = CUnsignedInt
  object CXIdxDeclInfoFlags extends CEnumU[CXIdxDeclInfoFlags]:
    inline def define(inline a: Long): CXIdxDeclInfoFlags = a.toUInt
    val CXIdxDeclFlag_Skipped = define(1)

  opaque type CXIdxEntityCXXTemplateKind = CUnsignedInt
  object CXIdxEntityCXXTemplateKind extends CEnumU[CXIdxEntityCXXTemplateKind]:
    inline def define(inline a: Long): CXIdxEntityCXXTemplateKind = a.toUInt
    val CXIdxEntity_NonTemplate = define(0)
    val CXIdxEntity_Template = define(1)
    val CXIdxEntity_TemplatePartialSpecialization = define(2)
    val CXIdxEntity_TemplateSpecialization = define(3)

  opaque type CXIdxEntityKind = CUnsignedInt
  object CXIdxEntityKind extends CEnumU[CXIdxEntityKind]:
    inline def define(inline a: Long): CXIdxEntityKind = a.toUInt
    val CXIdxEntity_Unexposed = define(0)
    val CXIdxEntity_Typedef = define(1)
    val CXIdxEntity_Function = define(2)
    val CXIdxEntity_Variable = define(3)
    val CXIdxEntity_Field = define(4)
    val CXIdxEntity_EnumConstant = define(5)
    val CXIdxEntity_ObjCClass = define(6)
    val CXIdxEntity_ObjCProtocol = define(7)
    val CXIdxEntity_ObjCCategory = define(8)
    val CXIdxEntity_ObjCInstanceMethod = define(9)
    val CXIdxEntity_ObjCClassMethod = define(10)
    val CXIdxEntity_ObjCProperty = define(11)
    val CXIdxEntity_ObjCIvar = define(12)
    val CXIdxEntity_Enum = define(13)
    val CXIdxEntity_Struct = define(14)
    val CXIdxEntity_Union = define(15)
    val CXIdxEntity_CXXClass = define(16)
    val CXIdxEntity_CXXNamespace = define(17)
    val CXIdxEntity_CXXNamespaceAlias = define(18)
    val CXIdxEntity_CXXStaticVariable = define(19)
    val CXIdxEntity_CXXStaticMethod = define(20)
    val CXIdxEntity_CXXInstanceMethod = define(21)
    val CXIdxEntity_CXXConstructor = define(22)
    val CXIdxEntity_CXXDestructor = define(23)
    val CXIdxEntity_CXXConversionFunction = define(24)
    val CXIdxEntity_CXXTypeAlias = define(25)
    val CXIdxEntity_CXXInterface = define(26)

  opaque type CXIdxEntityLanguage = CUnsignedInt
  object CXIdxEntityLanguage extends CEnumU[CXIdxEntityLanguage]:
    inline def define(inline a: Long): CXIdxEntityLanguage = a.toUInt
    val CXIdxEntityLang_None = define(0)
    val CXIdxEntityLang_C = define(1)
    val CXIdxEntityLang_ObjC = define(2)
    val CXIdxEntityLang_CXX = define(3)
    val CXIdxEntityLang_Swift = define(4)

  opaque type CXIdxEntityRefKind = CUnsignedInt
  object CXIdxEntityRefKind extends CEnumU[CXIdxEntityRefKind]:
    inline def define(inline a: Long): CXIdxEntityRefKind = a.toUInt
    val CXIdxEntityRef_Direct = define(1)
    val CXIdxEntityRef_Implicit = define(2)

  opaque type CXIdxObjCContainerKind = CUnsignedInt
  object CXIdxObjCContainerKind extends CEnumU[CXIdxObjCContainerKind]:
    inline def define(inline a: Long): CXIdxObjCContainerKind = a.toUInt
    val CXIdxObjCContainer_ForwardRef = define(0)
    val CXIdxObjCContainer_Interface = define(1)
    val CXIdxObjCContainer_Implementation = define(2)

  opaque type CXIndexOptFlags = CUnsignedInt
  object CXIndexOptFlags extends CEnumU[CXIndexOptFlags]:
    inline def define(inline a: Long): CXIndexOptFlags = a.toUInt
    val CXIndexOpt_None = define(0)
    val CXIndexOpt_SuppressRedundantRefs = define(1)
    val CXIndexOpt_IndexFunctionLocalSymbols = define(2)
    val CXIndexOpt_IndexImplicitTemplateInstantiations = define(4)
    val CXIndexOpt_SuppressWarnings = define(8)
    val CXIndexOpt_SkipParsedBodiesInSession = define(16)

  opaque type CXLanguageKind = CUnsignedInt
  object CXLanguageKind extends CEnumU[CXLanguageKind]:
    inline def define(inline a: Long): CXLanguageKind = a.toUInt
    val CXLanguage_Invalid = define(0)
    val CXLanguage_C = define(1)
    val CXLanguage_ObjC = define(2)
    val CXLanguage_CPlusPlus = define(3)

  opaque type CXLinkageKind = CUnsignedInt
  object CXLinkageKind extends CEnumU[CXLinkageKind]:
    inline def define(inline a: Long): CXLinkageKind = a.toUInt
    val CXLinkage_Invalid = define(0)
    val CXLinkage_NoLinkage = define(1)
    val CXLinkage_Internal = define(2)
    val CXLinkage_UniqueExternal = define(3)
    val CXLinkage_External = define(4)

  opaque type CXLoadDiag_Error = CUnsignedInt
  object CXLoadDiag_Error extends CEnumU[CXLoadDiag_Error]:
    inline def define(inline a: Long): CXLoadDiag_Error = a.toUInt
    val CXLoadDiag_None = define(0)
    val CXLoadDiag_Unknown = define(1)
    val CXLoadDiag_CannotLoad = define(2)
    val CXLoadDiag_InvalidFile = define(3)

  opaque type CXNameRefFlags = CUnsignedInt
  object CXNameRefFlags extends CEnumU[CXNameRefFlags]:
    inline def define(inline a: Long): CXNameRefFlags = a.toUInt
    val CXNameRange_WantQualifier = define(1)
    val CXNameRange_WantTemplateArgs = define(2)
    val CXNameRange_WantSinglePiece = define(4)

  opaque type CXObjCDeclQualifierKind = CUnsignedInt
  object CXObjCDeclQualifierKind extends CEnumU[CXObjCDeclQualifierKind]:
    inline def define(inline a: Long): CXObjCDeclQualifierKind = a.toUInt
    val CXObjCDeclQualifier_None = define(0)
    val CXObjCDeclQualifier_In = define(1)
    val CXObjCDeclQualifier_Inout = define(2)
    val CXObjCDeclQualifier_Out = define(4)
    val CXObjCDeclQualifier_Bycopy = define(8)
    val CXObjCDeclQualifier_Byref = define(16)
    val CXObjCDeclQualifier_Oneway = define(32)

  opaque type CXObjCPropertyAttrKind = CUnsignedInt
  object CXObjCPropertyAttrKind extends CEnumU[CXObjCPropertyAttrKind]:
    inline def define(inline a: Long): CXObjCPropertyAttrKind = a.toUInt
    val CXObjCPropertyAttr_noattr = define(0)
    val CXObjCPropertyAttr_readonly = define(1)
    val CXObjCPropertyAttr_getter = define(2)
    val CXObjCPropertyAttr_assign = define(4)
    val CXObjCPropertyAttr_readwrite = define(8)
    val CXObjCPropertyAttr_retain = define(16)
    val CXObjCPropertyAttr_copy = define(32)
    val CXObjCPropertyAttr_nonatomic = define(64)
    val CXObjCPropertyAttr_setter = define(128)
    val CXObjCPropertyAttr_atomic = define(256)
    val CXObjCPropertyAttr_weak = define(512)
    val CXObjCPropertyAttr_strong = define(1024)
    val CXObjCPropertyAttr_unsafe_unretained = define(2048)
    val CXObjCPropertyAttr_class = define(4096)

  opaque type CXPrintingPolicyProperty = CUnsignedInt
  object CXPrintingPolicyProperty extends CEnumU[CXPrintingPolicyProperty]:
    inline def define(inline a: Long): CXPrintingPolicyProperty = a.toUInt
    val CXPrintingPolicy_Indentation = define(0)
    val CXPrintingPolicy_SuppressSpecifiers = define(1)
    val CXPrintingPolicy_SuppressTagKeyword = define(2)
    val CXPrintingPolicy_IncludeTagDefinition = define(3)
    val CXPrintingPolicy_SuppressScope = define(4)
    val CXPrintingPolicy_SuppressUnwrittenScope = define(5)
    val CXPrintingPolicy_SuppressInitializers = define(6)
    val CXPrintingPolicy_ConstantArraySizeAsWritten = define(7)
    val CXPrintingPolicy_AnonymousTagLocations = define(8)
    val CXPrintingPolicy_SuppressStrongLifetime = define(9)
    val CXPrintingPolicy_SuppressLifetimeQualifiers = define(10)
    val CXPrintingPolicy_SuppressTemplateArgsInCXXConstructors = define(11)
    val CXPrintingPolicy_Bool = define(12)
    val CXPrintingPolicy_Restrict = define(13)
    val CXPrintingPolicy_Alignof = define(14)
    val CXPrintingPolicy_UnderscoreAlignof = define(15)
    val CXPrintingPolicy_UseVoidForZeroParams = define(16)
    val CXPrintingPolicy_TerseOutput = define(17)
    val CXPrintingPolicy_PolishForDeclaration = define(18)
    val CXPrintingPolicy_Half = define(19)
    val CXPrintingPolicy_MSWChar = define(20)
    val CXPrintingPolicy_IncludeNewlines = define(21)
    val CXPrintingPolicy_MSVCFormatting = define(22)
    val CXPrintingPolicy_ConstantsAsWritten = define(23)
    val CXPrintingPolicy_SuppressImplicitBase = define(24)
    val CXPrintingPolicy_FullyQualifiedName = define(25)
    val CXPrintingPolicy_LastProperty = define(25)

  opaque type CXRefQualifierKind = CUnsignedInt
  object CXRefQualifierKind extends CEnumU[CXRefQualifierKind]:
    inline def define(inline a: Long): CXRefQualifierKind = a.toUInt
    val CXRefQualifier_None = define(0)
    val CXRefQualifier_LValue = define(1)
    val CXRefQualifier_RValue = define(2)

  opaque type CXReparse_Flags = CUnsignedInt
  object CXReparse_Flags extends CEnumU[CXReparse_Flags]:
    inline def define(inline a: Long): CXReparse_Flags = a.toUInt
    val CXReparse_None = define(0)

  opaque type CXResult = CUnsignedInt
  object CXResult extends CEnumU[CXResult]:
    inline def define(inline a: Long): CXResult = a.toUInt
    val CXResult_Success = define(0)
    val CXResult_Invalid = define(1)
    val CXResult_VisitBreak = define(2)

  opaque type CXSaveError = CUnsignedInt
  object CXSaveError extends CEnumU[CXSaveError]:
    inline def define(inline a: Long): CXSaveError = a.toUInt
    val CXSaveError_None = define(0)
    val CXSaveError_Unknown = define(1)
    val CXSaveError_TranslationErrors = define(2)
    val CXSaveError_InvalidTU = define(3)

  opaque type CXSaveTranslationUnit_Flags = CUnsignedInt
  object CXSaveTranslationUnit_Flags extends CEnumU[CXSaveTranslationUnit_Flags]:
    inline def define(inline a: Long): CXSaveTranslationUnit_Flags = a.toUInt
    val CXSaveTranslationUnit_None = define(0)

  opaque type CXSymbolRole = CUnsignedInt
  object CXSymbolRole extends CEnumU[CXSymbolRole]:
    inline def define(inline a: Long): CXSymbolRole = a.toUInt
    val CXSymbolRole_None = define(0)
    val CXSymbolRole_Declaration = define(1)
    val CXSymbolRole_Definition = define(2)
    val CXSymbolRole_Reference = define(4)
    val CXSymbolRole_Read = define(8)
    val CXSymbolRole_Write = define(16)
    val CXSymbolRole_Call = define(32)
    val CXSymbolRole_Dynamic = define(64)
    val CXSymbolRole_AddressOf = define(128)
    val CXSymbolRole_Implicit = define(256)

  opaque type CXTLSKind = CUnsignedInt
  object CXTLSKind extends CEnumU[CXTLSKind]:
    inline def define(inline a: Long): CXTLSKind = a.toUInt
    val CXTLS_None = define(0)
    val CXTLS_Dynamic = define(1)
    val CXTLS_Static = define(2)

  opaque type CXTUResourceUsageKind = CUnsignedInt
  object CXTUResourceUsageKind extends CEnumU[CXTUResourceUsageKind]:
    inline def define(inline a: Long): CXTUResourceUsageKind = a.toUInt
    val CXTUResourceUsage_AST = define(1)
    val CXTUResourceUsage_Identifiers = define(2)
    val CXTUResourceUsage_Selectors = define(3)
    val CXTUResourceUsage_GlobalCompletionResults = define(4)
    val CXTUResourceUsage_SourceManagerContentCache = define(5)
    val CXTUResourceUsage_AST_SideTables = define(6)
    val CXTUResourceUsage_SourceManager_Membuffer_Malloc = define(7)
    val CXTUResourceUsage_SourceManager_Membuffer_MMap = define(8)
    val CXTUResourceUsage_ExternalASTSource_Membuffer_Malloc = define(9)
    val CXTUResourceUsage_ExternalASTSource_Membuffer_MMap = define(10)
    val CXTUResourceUsage_Preprocessor = define(11)
    val CXTUResourceUsage_PreprocessingRecord = define(12)
    val CXTUResourceUsage_SourceManager_DataStructures = define(13)
    val CXTUResourceUsage_Preprocessor_HeaderSearch = define(14)
    val CXTUResourceUsage_MEMORY_IN_BYTES_BEGIN = define(1)
    val CXTUResourceUsage_MEMORY_IN_BYTES_END = define(14)
    val CXTUResourceUsage_First = define(1)
    val CXTUResourceUsage_Last = define(14)

  opaque type CXTemplateArgumentKind = CUnsignedInt
  object CXTemplateArgumentKind extends CEnumU[CXTemplateArgumentKind]:
    inline def define(inline a: Long): CXTemplateArgumentKind = a.toUInt
    val CXTemplateArgumentKind_Null = define(0)
    val CXTemplateArgumentKind_Type = define(1)
    val CXTemplateArgumentKind_Declaration = define(2)
    val CXTemplateArgumentKind_NullPtr = define(3)
    val CXTemplateArgumentKind_Integral = define(4)
    val CXTemplateArgumentKind_Template = define(5)
    val CXTemplateArgumentKind_TemplateExpansion = define(6)
    val CXTemplateArgumentKind_Expression = define(7)
    val CXTemplateArgumentKind_Pack = define(8)
    val CXTemplateArgumentKind_Invalid = define(9)

  opaque type CXTokenKind = CUnsignedInt
  object CXTokenKind extends CEnumU[CXTokenKind]:
    inline def define(inline a: Long): CXTokenKind = a.toUInt
    val CXToken_Punctuation = define(0)
    val CXToken_Keyword = define(1)
    val CXToken_Identifier = define(2)
    val CXToken_Literal = define(3)
    val CXToken_Comment = define(4)

  opaque type CXTranslationUnit_Flags = CUnsignedInt
  object CXTranslationUnit_Flags extends CEnumU[CXTranslationUnit_Flags]:
    inline def define(inline a: Long): CXTranslationUnit_Flags = a.toUInt
    val CXTranslationUnit_None = define(0)
    val CXTranslationUnit_DetailedPreprocessingRecord = define(1)
    val CXTranslationUnit_Incomplete = define(2)
    val CXTranslationUnit_PrecompiledPreamble = define(4)
    val CXTranslationUnit_CacheCompletionResults = define(8)
    val CXTranslationUnit_ForSerialization = define(16)
    val CXTranslationUnit_CXXChainedPCH = define(32)
    val CXTranslationUnit_SkipFunctionBodies = define(64)
    val CXTranslationUnit_IncludeBriefCommentsInCodeCompletion = define(128)
    val CXTranslationUnit_CreatePreambleOnFirstParse = define(256)
    val CXTranslationUnit_KeepGoing = define(512)
    val CXTranslationUnit_SingleFileParse = define(1024)
    val CXTranslationUnit_LimitSkipFunctionBodiesToPreamble = define(2048)
    val CXTranslationUnit_IncludeAttributedTypes = define(4096)
    val CXTranslationUnit_VisitImplicitAttributes = define(8192)
    val CXTranslationUnit_IgnoreNonErrorsFromIncludedFiles = define(16384)
    val CXTranslationUnit_RetainExcludedConditionalBlocks = define(32768)

  opaque type CXTypeKind = CUnsignedInt
  object CXTypeKind extends CEnumU[CXTypeKind]:
    inline def define(inline a: Long): CXTypeKind = a.toUInt
    val CXType_Invalid = define(0)
    val CXType_Unexposed = define(1)
    val CXType_Void = define(2)
    val CXType_Bool = define(3)
    val CXType_Char_U = define(4)
    val CXType_UChar = define(5)
    val CXType_Char16 = define(6)
    val CXType_Char32 = define(7)
    val CXType_UShort = define(8)
    val CXType_UInt = define(9)
    val CXType_ULong = define(10)
    val CXType_ULongLong = define(11)
    val CXType_UInt128 = define(12)
    val CXType_Char_S = define(13)
    val CXType_SChar = define(14)
    val CXType_WChar = define(15)
    val CXType_Short = define(16)
    val CXType_Int = define(17)
    val CXType_Long = define(18)
    val CXType_LongLong = define(19)
    val CXType_Int128 = define(20)
    val CXType_Float = define(21)
    val CXType_Double = define(22)
    val CXType_LongDouble = define(23)
    val CXType_NullPtr = define(24)
    val CXType_Overload = define(25)
    val CXType_Dependent = define(26)
    val CXType_ObjCId = define(27)
    val CXType_ObjCClass = define(28)
    val CXType_ObjCSel = define(29)
    val CXType_Float128 = define(30)
    val CXType_Half = define(31)
    val CXType_Float16 = define(32)
    val CXType_ShortAccum = define(33)
    val CXType_Accum = define(34)
    val CXType_LongAccum = define(35)
    val CXType_UShortAccum = define(36)
    val CXType_UAccum = define(37)
    val CXType_ULongAccum = define(38)
    val CXType_BFloat16 = define(39)
    val CXType_Ibm128 = define(40)
    val CXType_FirstBuiltin = define(2)
    val CXType_LastBuiltin = define(40)
    val CXType_Complex = define(100)
    val CXType_Pointer = define(101)
    val CXType_BlockPointer = define(102)
    val CXType_LValueReference = define(103)
    val CXType_RValueReference = define(104)
    val CXType_Record = define(105)
    val CXType_Enum = define(106)
    val CXType_Typedef = define(107)
    val CXType_ObjCInterface = define(108)
    val CXType_ObjCObjectPointer = define(109)
    val CXType_FunctionNoProto = define(110)
    val CXType_FunctionProto = define(111)
    val CXType_ConstantArray = define(112)
    val CXType_Vector = define(113)
    val CXType_IncompleteArray = define(114)
    val CXType_VariableArray = define(115)
    val CXType_DependentSizedArray = define(116)
    val CXType_MemberPointer = define(117)
    val CXType_Auto = define(118)
    val CXType_Elaborated = define(119)
    val CXType_Pipe = define(120)
    val CXType_OCLImage1dRO = define(121)
    val CXType_OCLImage1dArrayRO = define(122)
    val CXType_OCLImage1dBufferRO = define(123)
    val CXType_OCLImage2dRO = define(124)
    val CXType_OCLImage2dArrayRO = define(125)
    val CXType_OCLImage2dDepthRO = define(126)
    val CXType_OCLImage2dArrayDepthRO = define(127)
    val CXType_OCLImage2dMSAARO = define(128)
    val CXType_OCLImage2dArrayMSAARO = define(129)
    val CXType_OCLImage2dMSAADepthRO = define(130)
    val CXType_OCLImage2dArrayMSAADepthRO = define(131)
    val CXType_OCLImage3dRO = define(132)
    val CXType_OCLImage1dWO = define(133)
    val CXType_OCLImage1dArrayWO = define(134)
    val CXType_OCLImage1dBufferWO = define(135)
    val CXType_OCLImage2dWO = define(136)
    val CXType_OCLImage2dArrayWO = define(137)
    val CXType_OCLImage2dDepthWO = define(138)
    val CXType_OCLImage2dArrayDepthWO = define(139)
    val CXType_OCLImage2dMSAAWO = define(140)
    val CXType_OCLImage2dArrayMSAAWO = define(141)
    val CXType_OCLImage2dMSAADepthWO = define(142)
    val CXType_OCLImage2dArrayMSAADepthWO = define(143)
    val CXType_OCLImage3dWO = define(144)
    val CXType_OCLImage1dRW = define(145)
    val CXType_OCLImage1dArrayRW = define(146)
    val CXType_OCLImage1dBufferRW = define(147)
    val CXType_OCLImage2dRW = define(148)
    val CXType_OCLImage2dArrayRW = define(149)
    val CXType_OCLImage2dDepthRW = define(150)
    val CXType_OCLImage2dArrayDepthRW = define(151)
    val CXType_OCLImage2dMSAARW = define(152)
    val CXType_OCLImage2dArrayMSAARW = define(153)
    val CXType_OCLImage2dMSAADepthRW = define(154)
    val CXType_OCLImage2dArrayMSAADepthRW = define(155)
    val CXType_OCLImage3dRW = define(156)
    val CXType_OCLSampler = define(157)
    val CXType_OCLEvent = define(158)
    val CXType_OCLQueue = define(159)
    val CXType_OCLReserveID = define(160)
    val CXType_ObjCObject = define(161)
    val CXType_ObjCTypeParam = define(162)
    val CXType_Attributed = define(163)
    val CXType_OCLIntelSubgroupAVCMcePayload = define(164)
    val CXType_OCLIntelSubgroupAVCImePayload = define(165)
    val CXType_OCLIntelSubgroupAVCRefPayload = define(166)
    val CXType_OCLIntelSubgroupAVCSicPayload = define(167)
    val CXType_OCLIntelSubgroupAVCMceResult = define(168)
    val CXType_OCLIntelSubgroupAVCImeResult = define(169)
    val CXType_OCLIntelSubgroupAVCRefResult = define(170)
    val CXType_OCLIntelSubgroupAVCSicResult = define(171)
    val CXType_OCLIntelSubgroupAVCImeResultSingleRefStreamout = define(172)
    val CXType_OCLIntelSubgroupAVCImeResultDualRefStreamout = define(173)
    val CXType_OCLIntelSubgroupAVCImeSingleRefStreamin = define(174)
    val CXType_OCLIntelSubgroupAVCImeDualRefStreamin = define(175)
    val CXType_ExtVector = define(176)
    val CXType_Atomic = define(177)

  opaque type CXTypeLayoutError = CInt
  object CXTypeLayoutError extends CEnum[CXTypeLayoutError]:
    inline def define(inline a: CInt): CXTypeLayoutError = a
    val CXTypeLayoutError_Invalid = define(-1)
    val CXTypeLayoutError_Incomplete = define(-2)
    val CXTypeLayoutError_Dependent = define(-3)
    val CXTypeLayoutError_NotConstantSize = define(-4)
    val CXTypeLayoutError_InvalidFieldName = define(-5)
    val CXTypeLayoutError_Undeduced = define(-6)

  opaque type CXTypeNullabilityKind = CUnsignedInt
  object CXTypeNullabilityKind extends CEnumU[CXTypeNullabilityKind]:
    inline def define(inline a: Long): CXTypeNullabilityKind = a.toUInt
    val CXTypeNullability_NonNull = define(0)
    val CXTypeNullability_Nullable = define(1)
    val CXTypeNullability_Unspecified = define(2)
    val CXTypeNullability_Invalid = define(3)
    val CXTypeNullability_NullableResult = define(4)

  opaque type CXVisibilityKind = CUnsignedInt
  object CXVisibilityKind extends CEnumU[CXVisibilityKind]:
    inline def define(inline a: Long): CXVisibilityKind = a.toUInt
    val CXVisibility_Invalid = define(0)
    val CXVisibility_Hidden = define(1)
    val CXVisibility_Protected = define(2)
    val CXVisibility_Default = define(3)

  opaque type CXVisitorResult = CUnsignedInt
  object CXVisitorResult extends CEnumU[CXVisitorResult]:
    inline def define(inline a: Long): CXVisitorResult = a.toUInt
    val CXVisit_Break = define(0)
    val CXVisit_Continue = define(1)

  opaque type CX_CXXAccessSpecifier = CUnsignedInt
  object CX_CXXAccessSpecifier extends CEnumU[CX_CXXAccessSpecifier]:
    inline def define(inline a: Long): CX_CXXAccessSpecifier = a.toUInt
    val CX_CXXInvalidAccessSpecifier = define(0)
    val CX_CXXPublic = define(1)
    val CX_CXXProtected = define(2)
    val CX_CXXPrivate = define(3)

  opaque type CX_StorageClass = CUnsignedInt
  object CX_StorageClass extends CEnumU[CX_StorageClass]:
    inline def define(inline a: Long): CX_StorageClass = a.toUInt
    val CX_SC_Invalid = define(0)
    val CX_SC_None = define(1)
    val CX_SC_Extern = define(2)
    val CX_SC_Static = define(3)
    val CX_SC_PrivateExtern = define(4)
    val CX_SC_OpenCLWorkGroupLocal = define(5)
    val CX_SC_Auto = define(6)
    val CX_SC_Register = define(7)

  opaque type clockid_t = CUnsignedInt
  object clockid_t extends CEnumU[clockid_t]:
    inline def define(inline a: Long): clockid_t = a.toUInt
    val _CLOCK_REALTIME = define(0)
    val _CLOCK_MONOTONIC = define(6)
    val _CLOCK_MONOTONIC_RAW = define(4)
    val _CLOCK_MONOTONIC_RAW_APPROX = define(5)
    val _CLOCK_UPTIME_RAW = define(8)
    val _CLOCK_UPTIME_RAW_APPROX = define(9)
    val _CLOCK_PROCESS_CPUTIME_ID = define(12)
    val _CLOCK_THREAD_CPUTIME_ID = define(16)
  opaque type CXClientData = Ptr[Byte]
  object CXClientData: 
    given _tag: Tag[CXClientData] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXClientData = o

  opaque type CXCompletionString = Ptr[Byte]
  object CXCompletionString: 
    given _tag: Tag[CXCompletionString] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXCompletionString = o

  type CXCursorAndRangeVisitorBlock = Unit
  object CXCursorAndRangeVisitorBlock: 
    given _tag: Tag[CXCursorAndRangeVisitorBlock] = Tag.Unit

  opaque type CXCursorSet = Ptr[CXCursorSetImpl]
  object CXCursorSet: 
    given _tag: Tag[CXCursorSet] = Tag.Ptr[CXCursorSetImpl](CXCursorSetImpl._tag)
    inline def apply(inline o: Ptr[CXCursorSetImpl]): CXCursorSet = o

  opaque type CXCursorVisitor = Ptr[CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]]
  object CXCursorVisitor: 
    given _tag: Tag[CXCursorVisitor] = Tag.Ptr[CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]](Tag.materializeCFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult])
    inline def apply(inline o: Ptr[CFuncPtr3[CXCursor, CXCursor, CXClientData, CXChildVisitResult]]): CXCursorVisitor = o

  type CXCursorVisitorBlock = Unit
  object CXCursorVisitorBlock: 
    given _tag: Tag[CXCursorVisitorBlock] = Tag.Unit

  opaque type CXDiagnostic = Ptr[Byte]
  object CXDiagnostic: 
    given _tag: Tag[CXDiagnostic] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXDiagnostic = o

  opaque type CXDiagnosticSet = Ptr[Byte]
  object CXDiagnosticSet: 
    given _tag: Tag[CXDiagnosticSet] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXDiagnosticSet = o

  opaque type CXEvalResult = Ptr[Byte]
  object CXEvalResult: 
    given _tag: Tag[CXEvalResult] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXEvalResult = o

  opaque type CXFieldVisitor = Ptr[CFuncPtr2[CXCursor, CXClientData, CXVisitorResult]]
  object CXFieldVisitor: 
    given _tag: Tag[CXFieldVisitor] = Tag.Ptr[CFuncPtr2[CXCursor, CXClientData, CXVisitorResult]](Tag.materializeCFuncPtr2[CXCursor, CXClientData, CXVisitorResult])
    inline def apply(inline o: Ptr[CFuncPtr2[CXCursor, CXClientData, CXVisitorResult]]): CXFieldVisitor = o

  opaque type CXFile = Ptr[Byte]
  object CXFile: 
    given _tag: Tag[CXFile] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXFile = o

  opaque type CXIdxClientASTFile = Ptr[Byte]
  object CXIdxClientASTFile: 
    given _tag: Tag[CXIdxClientASTFile] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIdxClientASTFile = o

  opaque type CXIdxClientContainer = Ptr[Byte]
  object CXIdxClientContainer: 
    given _tag: Tag[CXIdxClientContainer] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIdxClientContainer = o

  opaque type CXIdxClientEntity = Ptr[Byte]
  object CXIdxClientEntity: 
    given _tag: Tag[CXIdxClientEntity] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIdxClientEntity = o

  opaque type CXIdxClientFile = Ptr[Byte]
  object CXIdxClientFile: 
    given _tag: Tag[CXIdxClientFile] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIdxClientFile = o

  opaque type CXInclusionVisitor = Ptr[CFuncPtr4[CXFile, Ptr[CXSourceLocation], CUnsignedInt, CXClientData, Unit]]
  object CXInclusionVisitor: 
    given _tag: Tag[CXInclusionVisitor] = Tag.Ptr[CFuncPtr4[CXFile, Ptr[CXSourceLocation], CUnsignedInt, CXClientData, Unit]](Tag.materializeCFuncPtr4[CXFile, Ptr[CXSourceLocation], CUnsignedInt, CXClientData, Unit])
    inline def apply(inline o: Ptr[CFuncPtr4[CXFile, Ptr[CXSourceLocation], CUnsignedInt, CXClientData, Unit]]): CXInclusionVisitor = o

  opaque type CXIndex = Ptr[Byte]
  object CXIndex: 
    given _tag: Tag[CXIndex] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIndex = o

  opaque type CXIndexAction = Ptr[Byte]
  object CXIndexAction: 
    given _tag: Tag[CXIndexAction] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIndexAction = o

  opaque type CXModule = Ptr[Byte]
  object CXModule: 
    given _tag: Tag[CXModule] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXModule = o

  opaque type CXModuleMapDescriptor = Ptr[CXModuleMapDescriptorImpl]
  object CXModuleMapDescriptor: 
    given _tag: Tag[CXModuleMapDescriptor] = Tag.Ptr[CXModuleMapDescriptorImpl](CXModuleMapDescriptorImpl._tag)
    inline def apply(inline o: Ptr[CXModuleMapDescriptorImpl]): CXModuleMapDescriptor = o

  opaque type CXPrintingPolicy = Ptr[Byte]
  object CXPrintingPolicy: 
    given _tag: Tag[CXPrintingPolicy] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXPrintingPolicy = o

  opaque type CXRemapping = Ptr[Byte]
  object CXRemapping: 
    given _tag: Tag[CXRemapping] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXRemapping = o

  opaque type CXTargetInfo = Ptr[CXTargetInfoImpl]
  object CXTargetInfo: 
    given _tag: Tag[CXTargetInfo] = Tag.Ptr[CXTargetInfoImpl](CXTargetInfoImpl._tag)
    inline def apply(inline o: Ptr[CXTargetInfoImpl]): CXTargetInfo = o

  opaque type CXTranslationUnit = Ptr[CXTranslationUnitImpl]
  object CXTranslationUnit: 
    given _tag: Tag[CXTranslationUnit] = Tag.Ptr[CXTranslationUnitImpl](CXTranslationUnitImpl._tag)
    inline def apply(inline o: Ptr[CXTranslationUnitImpl]): CXTranslationUnit = o

  opaque type CXVirtualFileOverlay = Ptr[CXVirtualFileOverlayImpl]
  object CXVirtualFileOverlay: 
    given _tag: Tag[CXVirtualFileOverlay] = Tag.Ptr[CXVirtualFileOverlayImpl](CXVirtualFileOverlayImpl._tag)
    inline def apply(inline o: Ptr[CXVirtualFileOverlayImpl]): CXVirtualFileOverlay = o

  opaque type __builtin_va_list = CString
  object __builtin_va_list: 
    given _tag: Tag[__builtin_va_list] = Tag.Ptr[CChar](Tag.Byte)
    inline def apply(inline o: CString): __builtin_va_list = o

  type __darwin_blkcnt_t = __int64_t
  object __darwin_blkcnt_t: 
    given _tag: Tag[__darwin_blkcnt_t] = __int64_t._tag

  type __darwin_blksize_t = __int32_t
  object __darwin_blksize_t: 
    given _tag: Tag[__darwin_blksize_t] = __int32_t._tag

  opaque type __darwin_clock_t = CUnsignedLongInt
  object __darwin_clock_t: 
    given _tag: Tag[__darwin_clock_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_clock_t = o

  opaque type __darwin_ct_rune_t = CInt
  object __darwin_ct_rune_t: 
    given _tag: Tag[__darwin_ct_rune_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_ct_rune_t = o

  type __darwin_dev_t = __int32_t
  object __darwin_dev_t: 
    given _tag: Tag[__darwin_dev_t] = __int32_t._tag

  opaque type __darwin_fsblkcnt_t = CUnsignedInt
  object __darwin_fsblkcnt_t: 
    given _tag: Tag[__darwin_fsblkcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsblkcnt_t = o

  opaque type __darwin_fsfilcnt_t = CUnsignedInt
  object __darwin_fsfilcnt_t: 
    given _tag: Tag[__darwin_fsfilcnt_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_fsfilcnt_t = o

  type __darwin_gid_t = __uint32_t
  object __darwin_gid_t: 
    given _tag: Tag[__darwin_gid_t] = __uint32_t._tag

  type __darwin_id_t = __uint32_t
  object __darwin_id_t: 
    given _tag: Tag[__darwin_id_t] = __uint32_t._tag

  type __darwin_ino64_t = __uint64_t
  object __darwin_ino64_t: 
    given _tag: Tag[__darwin_ino64_t] = __uint64_t._tag

  type __darwin_ino_t = __darwin_ino64_t
  object __darwin_ino_t: 
    given _tag: Tag[__darwin_ino_t] = __darwin_ino64_t._tag

  opaque type __darwin_intptr_t = CLongInt
  object __darwin_intptr_t: 
    given _tag: Tag[__darwin_intptr_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_intptr_t = o

  type __darwin_mach_port_name_t = __darwin_natural_t
  object __darwin_mach_port_name_t: 
    given _tag: Tag[__darwin_mach_port_name_t] = __darwin_natural_t._tag

  type __darwin_mach_port_t = __darwin_mach_port_name_t
  object __darwin_mach_port_t: 
    given _tag: Tag[__darwin_mach_port_t] = __darwin_mach_port_name_t._tag

  type __darwin_mbstate_t = __mbstate_t
  object __darwin_mbstate_t: 
    given _tag: Tag[__darwin_mbstate_t] = __mbstate_t._tag

  type __darwin_mode_t = __uint16_t
  object __darwin_mode_t: 
    given _tag: Tag[__darwin_mode_t] = __uint16_t._tag

  opaque type __darwin_natural_t = CUnsignedInt
  object __darwin_natural_t: 
    given _tag: Tag[__darwin_natural_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __darwin_natural_t = o

  opaque type __darwin_nl_item = CInt
  object __darwin_nl_item: 
    given _tag: Tag[__darwin_nl_item] = Tag.Int
    inline def apply(inline o: CInt): __darwin_nl_item = o

  type __darwin_off_t = __int64_t
  object __darwin_off_t: 
    given _tag: Tag[__darwin_off_t] = __int64_t._tag

  type __darwin_pid_t = __int32_t
  object __darwin_pid_t: 
    given _tag: Tag[__darwin_pid_t] = __int32_t._tag

  opaque type __darwin_pthread_key_t = CUnsignedLongInt
  object __darwin_pthread_key_t: 
    given _tag: Tag[__darwin_pthread_key_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_pthread_key_t = o

  opaque type __darwin_pthread_t = Ptr[_opaque_pthread_t]
  object __darwin_pthread_t: 
    given _tag: Tag[__darwin_pthread_t] = Tag.Ptr[_opaque_pthread_t](_opaque_pthread_t._tag)
    inline def apply(inline o: Ptr[_opaque_pthread_t]): __darwin_pthread_t = o

  opaque type __darwin_ptrdiff_t = CLongInt
  object __darwin_ptrdiff_t: 
    given _tag: Tag[__darwin_ptrdiff_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ptrdiff_t = o

  type __darwin_rune_t = __darwin_wchar_t
  object __darwin_rune_t: 
    given _tag: Tag[__darwin_rune_t] = __darwin_wchar_t._tag

  type __darwin_sigset_t = __uint32_t
  object __darwin_sigset_t: 
    given _tag: Tag[__darwin_sigset_t] = __uint32_t._tag

  opaque type __darwin_size_t = CUnsignedLongInt
  object __darwin_size_t: 
    given _tag: Tag[__darwin_size_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): __darwin_size_t = o

  type __darwin_socklen_t = __uint32_t
  object __darwin_socklen_t: 
    given _tag: Tag[__darwin_socklen_t] = __uint32_t._tag

  opaque type __darwin_ssize_t = CLongInt
  object __darwin_ssize_t: 
    given _tag: Tag[__darwin_ssize_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_ssize_t = o

  type __darwin_suseconds_t = __int32_t
  object __darwin_suseconds_t: 
    given _tag: Tag[__darwin_suseconds_t] = __int32_t._tag

  opaque type __darwin_time_t = CLongInt
  object __darwin_time_t: 
    given _tag: Tag[__darwin_time_t] = Tag.Long
    inline def apply(inline o: CLongInt): __darwin_time_t = o

  type __darwin_uid_t = __uint32_t
  object __darwin_uid_t: 
    given _tag: Tag[__darwin_uid_t] = __uint32_t._tag

  type __darwin_useconds_t = __uint32_t
  object __darwin_useconds_t: 
    given _tag: Tag[__darwin_useconds_t] = __uint32_t._tag

  opaque type __darwin_uuid_string_t = CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]
  object __darwin_uuid_string_t: 
    given _tag: Tag[__darwin_uuid_string_t] = Tag.CArray[CChar, Nat.Digit2[Nat._3, Nat._7]](Tag.Byte, Tag.Digit2[Nat._3, Nat._7](Tag.Nat3, Tag.Nat7))
    inline def apply(inline o: CArray[CChar, Nat.Digit2[Nat._3, Nat._7]]): __darwin_uuid_string_t = o

  opaque type __darwin_uuid_t = CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]
  object __darwin_uuid_t: 
    given _tag: Tag[__darwin_uuid_t] = Tag.CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]](Tag.UByte, Tag.Digit2[Nat._1, Nat._6](Tag.Nat1, Tag.Nat6))
    inline def apply(inline o: CArray[CUnsignedChar, Nat.Digit2[Nat._1, Nat._6]]): __darwin_uuid_t = o

  type __darwin_va_list = __builtin_va_list
  object __darwin_va_list: 
    given _tag: Tag[__darwin_va_list] = __builtin_va_list._tag

  opaque type __darwin_wchar_t = CInt
  object __darwin_wchar_t: 
    given _tag: Tag[__darwin_wchar_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wchar_t = o

  opaque type __darwin_wctrans_t = CInt
  object __darwin_wctrans_t: 
    given _tag: Tag[__darwin_wctrans_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wctrans_t = o

  type __darwin_wctype_t = __uint32_t
  object __darwin_wctype_t: 
    given _tag: Tag[__darwin_wctype_t] = __uint32_t._tag

  opaque type __darwin_wint_t = CInt
  object __darwin_wint_t: 
    given _tag: Tag[__darwin_wint_t] = Tag.Int
    inline def apply(inline o: CInt): __darwin_wint_t = o

  opaque type __int16_t = CShort
  object __int16_t: 
    given _tag: Tag[__int16_t] = Tag.Short
    inline def apply(inline o: CShort): __int16_t = o

  opaque type __int32_t = CInt
  object __int32_t: 
    given _tag: Tag[__int32_t] = Tag.Int
    inline def apply(inline o: CInt): __int32_t = o

  opaque type __int64_t = CLongLong
  object __int64_t: 
    given _tag: Tag[__int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): __int64_t = o

  opaque type __int8_t = CChar
  object __int8_t: 
    given _tag: Tag[__int8_t] = Tag.Byte
    inline def apply(inline o: CChar): __int8_t = o

  opaque type __uint16_t = CUnsignedShort
  object __uint16_t: 
    given _tag: Tag[__uint16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): __uint16_t = o

  opaque type __uint32_t = CUnsignedInt
  object __uint32_t: 
    given _tag: Tag[__uint32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): __uint32_t = o

  opaque type __uint64_t = CUnsignedLongLong
  object __uint64_t: 
    given _tag: Tag[__uint64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): __uint64_t = o

  opaque type __uint8_t = CUnsignedChar
  object __uint8_t: 
    given _tag: Tag[__uint8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): __uint8_t = o

  type clock_t = __darwin_clock_t
  object clock_t: 
    given _tag: Tag[clock_t] = __darwin_clock_t._tag

  opaque type int16_t = CShort
  object int16_t: 
    given _tag: Tag[int16_t] = Tag.Short
    inline def apply(inline o: CShort): int16_t = o

  opaque type int32_t = CInt
  object int32_t: 
    given _tag: Tag[int32_t] = Tag.Int
    inline def apply(inline o: CInt): int32_t = o

  opaque type int64_t = CLongLong
  object int64_t: 
    given _tag: Tag[int64_t] = Tag.Long
    inline def apply(inline o: CLongLong): int64_t = o

  opaque type int8_t = CChar
  object int8_t: 
    given _tag: Tag[int8_t] = Tag.Byte
    inline def apply(inline o: CChar): int8_t = o

  type intptr_t = __darwin_intptr_t
  object intptr_t: 
    given _tag: Tag[intptr_t] = __darwin_intptr_t._tag

  type register_t = int64_t
  object register_t: 
    given _tag: Tag[register_t] = int64_t._tag

  type size_t = __darwin_size_t
  object size_t: 
    given _tag: Tag[size_t] = __darwin_size_t._tag

  type syscall_arg_t = u_int64_t
  object syscall_arg_t: 
    given _tag: Tag[syscall_arg_t] = u_int64_t._tag

  type time_t = __darwin_time_t
  object time_t: 
    given _tag: Tag[time_t] = __darwin_time_t._tag

  opaque type u_int16_t = CUnsignedShort
  object u_int16_t: 
    given _tag: Tag[u_int16_t] = Tag.UShort
    inline def apply(inline o: CUnsignedShort): u_int16_t = o

  opaque type u_int32_t = CUnsignedInt
  object u_int32_t: 
    given _tag: Tag[u_int32_t] = Tag.UInt
    inline def apply(inline o: CUnsignedInt): u_int32_t = o

  opaque type u_int64_t = CUnsignedLongLong
  object u_int64_t: 
    given _tag: Tag[u_int64_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongLong): u_int64_t = o

  opaque type u_int8_t = CUnsignedChar
  object u_int8_t: 
    given _tag: Tag[u_int8_t] = Tag.UByte
    inline def apply(inline o: CUnsignedChar): u_int8_t = o

  opaque type uintptr_t = CUnsignedLongInt
  object uintptr_t: 
    given _tag: Tag[uintptr_t] = Tag.ULong
    inline def apply(inline o: CUnsignedLongInt): uintptr_t = o

  type user_addr_t = u_int64_t
  object user_addr_t: 
    given _tag: Tag[user_addr_t] = u_int64_t._tag

  type user_long_t = int64_t
  object user_long_t: 
    given _tag: Tag[user_long_t] = int64_t._tag

  type user_off_t = int64_t
  object user_off_t: 
    given _tag: Tag[user_off_t] = int64_t._tag

  type user_size_t = u_int64_t
  object user_size_t: 
    given _tag: Tag[user_size_t] = u_int64_t._tag

  type user_ssize_t = int64_t
  object user_ssize_t: 
    given _tag: Tag[user_ssize_t] = int64_t._tag

  type user_time_t = int64_t
  object user_time_t: 
    given _tag: Tag[user_time_t] = int64_t._tag

  type user_ulong_t = u_int64_t
  object user_ulong_t: 
    given _tag: Tag[user_ulong_t] = u_int64_t._tag
  opaque type CXCodeCompleteResults = CStruct2[Ptr[CXCompletionResult], CUnsignedInt]
  object CXCodeCompleteResults:
    given _tag: Tag[CXCodeCompleteResults] = Tag.materializeCStruct2Tag[Ptr[CXCompletionResult], CUnsignedInt]
    def apply()(using Zone): Ptr[CXCodeCompleteResults] = scala.scalanative.unsafe.alloc[CXCodeCompleteResults](1)
    def apply(Results: Ptr[CXCompletionResult], NumResults: CUnsignedInt)(using Zone): Ptr[CXCodeCompleteResults] = 
      val ____ptr = apply()
      (!____ptr).Results = Results
      (!____ptr).NumResults = NumResults
      ____ptr
    extension (struct: CXCodeCompleteResults)
      def Results: Ptr[CXCompletionResult] = struct._1
      def Results_=(value: Ptr[CXCompletionResult]): Unit = !struct.at1 = value
      def NumResults: CUnsignedInt = struct._2
      def NumResults_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXCompletionResult = CStruct2[CXCursorKind, CXCompletionString]
  object CXCompletionResult:
    given _tag: Tag[CXCompletionResult] = Tag.materializeCStruct2Tag[CXCursorKind, CXCompletionString]
    def apply()(using Zone): Ptr[CXCompletionResult] = scala.scalanative.unsafe.alloc[CXCompletionResult](1)
    def apply(CursorKind: CXCursorKind, CompletionString: CXCompletionString)(using Zone): Ptr[CXCompletionResult] = 
      val ____ptr = apply()
      (!____ptr).CursorKind = CursorKind
      (!____ptr).CompletionString = CompletionString
      ____ptr
    extension (struct: CXCompletionResult)
      def CursorKind: CXCursorKind = struct._1
      def CursorKind_=(value: CXCursorKind): Unit = !struct.at1 = value
      def CompletionString: CXCompletionString = struct._2
      def CompletionString_=(value: CXCompletionString): Unit = !struct.at2 = value

  opaque type CXCursor = CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
  object CXCursor:
    given _tag: Tag[CXCursor] = Tag.materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
    def apply()(using Zone): Ptr[CXCursor] = scala.scalanative.unsafe.alloc[CXCursor](1)
    def apply(kind: CXCursorKind, xdata: CInt, data: CArray[Ptr[Byte], Nat._3])(using Zone): Ptr[CXCursor] = 
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

  opaque type CXCursorAndRangeVisitor = CStruct2[Ptr[Byte], Ptr[CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]]]
  object CXCursorAndRangeVisitor:
    given _tag: Tag[CXCursorAndRangeVisitor] = Tag.materializeCStruct2Tag[Ptr[Byte], Ptr[CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]]]
    def apply()(using Zone): Ptr[CXCursorAndRangeVisitor] = scala.scalanative.unsafe.alloc[CXCursorAndRangeVisitor](1)
    def apply(context: Ptr[Byte], visit: Ptr[CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]])(using Zone): Ptr[CXCursorAndRangeVisitor] = 
      val ____ptr = apply()
      (!____ptr).context = context
      (!____ptr).visit = visit
      ____ptr
    extension (struct: CXCursorAndRangeVisitor)
      def context: Ptr[Byte] = struct._1
      def context_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def visit: Ptr[CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]] = struct._2
      def visit_=(value: Ptr[CFuncPtr3[Ptr[Byte], CXCursor, CXSourceRange, CXVisitorResult]]): Unit = !struct.at2 = value

  opaque type CXCursorSetImpl = CStruct0
  object CXCursorSetImpl:
    given _tag: Tag[CXCursorSetImpl] = Tag.materializeCStruct0Tag

  opaque type CXFileUniqueID = CStruct1[CArray[CUnsignedLongLong, Nat._3]]
  object CXFileUniqueID:
    given _tag: Tag[CXFileUniqueID] = Tag.materializeCStruct1Tag[CArray[CUnsignedLongLong, Nat._3]]
    def apply()(using Zone): Ptr[CXFileUniqueID] = scala.scalanative.unsafe.alloc[CXFileUniqueID](1)
    def apply(data: CArray[CUnsignedLongLong, Nat._3])(using Zone): Ptr[CXFileUniqueID] = 
      val ____ptr = apply()
      (!____ptr).data = data
      ____ptr
    extension (struct: CXFileUniqueID)
      def data: CArray[CUnsignedLongLong, Nat._3] = struct._1
      def data_=(value: CArray[CUnsignedLongLong, Nat._3]): Unit = !struct.at1 = value

  opaque type CXIdxAttrInfo = CStruct3[CXIdxAttrKind, CXCursor, CXIdxLoc]
  object CXIdxAttrInfo:
    given _tag: Tag[CXIdxAttrInfo] = Tag.materializeCStruct3Tag[CXIdxAttrKind, CXCursor, CXIdxLoc]
    def apply()(using Zone): Ptr[CXIdxAttrInfo] = scala.scalanative.unsafe.alloc[CXIdxAttrInfo](1)
    def apply(kind: CXIdxAttrKind, cursor: CXCursor, loc: CXIdxLoc)(using Zone): Ptr[CXIdxAttrInfo] = 
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

  opaque type CXIdxBaseClassInfo = CStruct3[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
  object CXIdxBaseClassInfo:
    given _tag: Tag[CXIdxBaseClassInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
    def apply()(using Zone): Ptr[CXIdxBaseClassInfo] = scala.scalanative.unsafe.alloc[CXIdxBaseClassInfo](1)
    def apply(base: Ptr[CXIdxEntityInfo], cursor: CXCursor, loc: CXIdxLoc)(using Zone): Ptr[CXIdxBaseClassInfo] = 
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

  opaque type CXIdxCXXClassDeclInfo = CStruct3[Ptr[CXIdxDeclInfo], Ptr[Ptr[CXIdxBaseClassInfo]], CUnsignedInt]
  object CXIdxCXXClassDeclInfo:
    given _tag: Tag[CXIdxCXXClassDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxDeclInfo], Ptr[Ptr[CXIdxBaseClassInfo]], CUnsignedInt]
    def apply()(using Zone): Ptr[CXIdxCXXClassDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxCXXClassDeclInfo](1)
    def apply(declInfo: Ptr[CXIdxDeclInfo], bases: Ptr[Ptr[CXIdxBaseClassInfo]], numBases: CUnsignedInt)(using Zone): Ptr[CXIdxCXXClassDeclInfo] = 
      val ____ptr = apply()
      (!____ptr).declInfo = declInfo
      (!____ptr).bases = bases
      (!____ptr).numBases = numBases
      ____ptr
    extension (struct: CXIdxCXXClassDeclInfo)
      def declInfo: Ptr[CXIdxDeclInfo] = struct._1
      def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
      def bases: Ptr[Ptr[CXIdxBaseClassInfo]] = struct._2
      def bases_=(value: Ptr[Ptr[CXIdxBaseClassInfo]]): Unit = !struct.at2 = value
      def numBases: CUnsignedInt = struct._3
      def numBases_=(value: CUnsignedInt): Unit = !struct.at3 = value

  opaque type CXIdxContainerInfo = CStruct1[CXCursor]
  object CXIdxContainerInfo:
    given _tag: Tag[CXIdxContainerInfo] = Tag.materializeCStruct1Tag[CXCursor]
    def apply()(using Zone): Ptr[CXIdxContainerInfo] = scala.scalanative.unsafe.alloc[CXIdxContainerInfo](1)
    def apply(cursor: CXCursor)(using Zone): Ptr[CXIdxContainerInfo] = 
      val ____ptr = apply()
      (!____ptr).cursor = cursor
      ____ptr
    extension (struct: CXIdxContainerInfo)
      def cursor: CXCursor = struct._1
      def cursor_=(value: CXCursor): Unit = !struct.at1 = value

  opaque type CXIdxDeclInfo = CStruct13[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxContainerInfo], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[CXIdxContainerInfo], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]
  object CXIdxDeclInfo:
    given _tag: Tag[CXIdxDeclInfo] = Tag.materializeCStruct13Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxContainerInfo], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[CXIdxContainerInfo], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]
    def apply()(using Zone): Ptr[CXIdxDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxDeclInfo](1)
    def apply(entityInfo: Ptr[CXIdxEntityInfo], cursor: CXCursor, loc: CXIdxLoc, semanticContainer: Ptr[CXIdxContainerInfo], lexicalContainer: Ptr[CXIdxContainerInfo], isRedeclaration: CInt, isDefinition: CInt, isContainer: CInt, declAsContainer: Ptr[CXIdxContainerInfo], isImplicit: CInt, attributes: Ptr[Ptr[CXIdxAttrInfo]], numAttributes: CUnsignedInt, flags: CUnsignedInt)(using Zone): Ptr[CXIdxDeclInfo] = 
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
    extension (struct: CXIdxDeclInfo)
      def entityInfo: Ptr[CXIdxEntityInfo] = struct._1
      def entityInfo_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at1 = value
      def cursor: CXCursor = struct._2
      def cursor_=(value: CXCursor): Unit = !struct.at2 = value
      def loc: CXIdxLoc = struct._3
      def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
      def semanticContainer: Ptr[CXIdxContainerInfo] = struct._4
      def semanticContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at4 = value
      def lexicalContainer: Ptr[CXIdxContainerInfo] = struct._5
      def lexicalContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at5 = value
      def isRedeclaration: CInt = struct._6
      def isRedeclaration_=(value: CInt): Unit = !struct.at6 = value
      def isDefinition: CInt = struct._7
      def isDefinition_=(value: CInt): Unit = !struct.at7 = value
      def isContainer: CInt = struct._8
      def isContainer_=(value: CInt): Unit = !struct.at8 = value
      def declAsContainer: Ptr[CXIdxContainerInfo] = struct._9
      def declAsContainer_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at9 = value
      def isImplicit: CInt = struct._10
      def isImplicit_=(value: CInt): Unit = !struct.at10 = value
      def attributes: Ptr[Ptr[CXIdxAttrInfo]] = struct._11
      def attributes_=(value: Ptr[Ptr[CXIdxAttrInfo]]): Unit = !struct.at11 = value
      def numAttributes: CUnsignedInt = struct._12
      def numAttributes_=(value: CUnsignedInt): Unit = !struct.at12 = value
      def flags: CUnsignedInt = struct._13
      def flags_=(value: CUnsignedInt): Unit = !struct.at13 = value

  opaque type CXIdxEntityInfo = CStruct8[CXIdxEntityKind, CXIdxEntityCXXTemplateKind, CXIdxEntityLanguage, CString, CString, CXCursor, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt]
  object CXIdxEntityInfo:
    given _tag: Tag[CXIdxEntityInfo] = Tag.materializeCStruct8Tag[CXIdxEntityKind, CXIdxEntityCXXTemplateKind, CXIdxEntityLanguage, CString, CString, CXCursor, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt]
    def apply()(using Zone): Ptr[CXIdxEntityInfo] = scala.scalanative.unsafe.alloc[CXIdxEntityInfo](1)
    def apply(kind: CXIdxEntityKind, templateKind: CXIdxEntityCXXTemplateKind, lang: CXIdxEntityLanguage, name: CString, USR: CString, cursor: CXCursor, attributes: Ptr[Ptr[CXIdxAttrInfo]], numAttributes: CUnsignedInt)(using Zone): Ptr[CXIdxEntityInfo] = 
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
    extension (struct: CXIdxEntityInfo)
      def kind: CXIdxEntityKind = struct._1
      def kind_=(value: CXIdxEntityKind): Unit = !struct.at1 = value
      def templateKind: CXIdxEntityCXXTemplateKind = struct._2
      def templateKind_=(value: CXIdxEntityCXXTemplateKind): Unit = !struct.at2 = value
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

  opaque type CXIdxEntityRefInfo = CStruct7[CXIdxEntityRefKind, CXCursor, CXIdxLoc, Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxContainerInfo], CXSymbolRole]
  object CXIdxEntityRefInfo:
    given _tag: Tag[CXIdxEntityRefInfo] = Tag.materializeCStruct7Tag[CXIdxEntityRefKind, CXCursor, CXIdxLoc, Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxContainerInfo], CXSymbolRole]
    def apply()(using Zone): Ptr[CXIdxEntityRefInfo] = scala.scalanative.unsafe.alloc[CXIdxEntityRefInfo](1)
    def apply(kind: CXIdxEntityRefKind, cursor: CXCursor, loc: CXIdxLoc, referencedEntity: Ptr[CXIdxEntityInfo], parentEntity: Ptr[CXIdxEntityInfo], container: Ptr[CXIdxContainerInfo], role: CXSymbolRole)(using Zone): Ptr[CXIdxEntityRefInfo] = 
      val ____ptr = apply()
      (!____ptr).kind = kind
      (!____ptr).cursor = cursor
      (!____ptr).loc = loc
      (!____ptr).referencedEntity = referencedEntity
      (!____ptr).parentEntity = parentEntity
      (!____ptr).container = container
      (!____ptr).role = role
      ____ptr
    extension (struct: CXIdxEntityRefInfo)
      def kind: CXIdxEntityRefKind = struct._1
      def kind_=(value: CXIdxEntityRefKind): Unit = !struct.at1 = value
      def cursor: CXCursor = struct._2
      def cursor_=(value: CXCursor): Unit = !struct.at2 = value
      def loc: CXIdxLoc = struct._3
      def loc_=(value: CXIdxLoc): Unit = !struct.at3 = value
      def referencedEntity: Ptr[CXIdxEntityInfo] = struct._4
      def referencedEntity_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at4 = value
      def parentEntity: Ptr[CXIdxEntityInfo] = struct._5
      def parentEntity_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at5 = value
      def container: Ptr[CXIdxContainerInfo] = struct._6
      def container_=(value: Ptr[CXIdxContainerInfo]): Unit = !struct.at6 = value
      def role: CXSymbolRole = struct._7
      def role_=(value: CXSymbolRole): Unit = !struct.at7 = value

  opaque type CXIdxIBOutletCollectionAttrInfo = CStruct4[Ptr[CXIdxAttrInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
  object CXIdxIBOutletCollectionAttrInfo:
    given _tag: Tag[CXIdxIBOutletCollectionAttrInfo] = Tag.materializeCStruct4Tag[Ptr[CXIdxAttrInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
    def apply()(using Zone): Ptr[CXIdxIBOutletCollectionAttrInfo] = scala.scalanative.unsafe.alloc[CXIdxIBOutletCollectionAttrInfo](1)
    def apply(attrInfo: Ptr[CXIdxAttrInfo], objcClass: Ptr[CXIdxEntityInfo], classCursor: CXCursor, classLoc: CXIdxLoc)(using Zone): Ptr[CXIdxIBOutletCollectionAttrInfo] = 
      val ____ptr = apply()
      (!____ptr).attrInfo = attrInfo
      (!____ptr).objcClass = objcClass
      (!____ptr).classCursor = classCursor
      (!____ptr).classLoc = classLoc
      ____ptr
    extension (struct: CXIdxIBOutletCollectionAttrInfo)
      def attrInfo: Ptr[CXIdxAttrInfo] = struct._1
      def attrInfo_=(value: Ptr[CXIdxAttrInfo]): Unit = !struct.at1 = value
      def objcClass: Ptr[CXIdxEntityInfo] = struct._2
      def objcClass_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at2 = value
      def classCursor: CXCursor = struct._3
      def classCursor_=(value: CXCursor): Unit = !struct.at3 = value
      def classLoc: CXIdxLoc = struct._4
      def classLoc_=(value: CXIdxLoc): Unit = !struct.at4 = value

  opaque type CXIdxImportedASTFileInfo = CStruct4[CXFile, CXModule, CXIdxLoc, CInt]
  object CXIdxImportedASTFileInfo:
    given _tag: Tag[CXIdxImportedASTFileInfo] = Tag.materializeCStruct4Tag[CXFile, CXModule, CXIdxLoc, CInt]
    def apply()(using Zone): Ptr[CXIdxImportedASTFileInfo] = scala.scalanative.unsafe.alloc[CXIdxImportedASTFileInfo](1)
    def apply(file: CXFile, module: CXModule, loc: CXIdxLoc, isImplicit: CInt)(using Zone): Ptr[CXIdxImportedASTFileInfo] = 
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

  opaque type CXIdxIncludedFileInfo = CStruct6[CXIdxLoc, CString, CXFile, CInt, CInt, CInt]
  object CXIdxIncludedFileInfo:
    given _tag: Tag[CXIdxIncludedFileInfo] = Tag.materializeCStruct6Tag[CXIdxLoc, CString, CXFile, CInt, CInt, CInt]
    def apply()(using Zone): Ptr[CXIdxIncludedFileInfo] = scala.scalanative.unsafe.alloc[CXIdxIncludedFileInfo](1)
    def apply(hashLoc: CXIdxLoc, filename: CString, file: CXFile, isImport: CInt, isAngled: CInt, isModuleImport: CInt)(using Zone): Ptr[CXIdxIncludedFileInfo] = 
      val ____ptr = apply()
      (!____ptr).hashLoc = hashLoc
      (!____ptr).filename = filename
      (!____ptr).file = file
      (!____ptr).isImport = isImport
      (!____ptr).isAngled = isAngled
      (!____ptr).isModuleImport = isModuleImport
      ____ptr
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

  opaque type CXIdxLoc = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  object CXIdxLoc:
    given _tag: Tag[CXIdxLoc] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
    def apply()(using Zone): Ptr[CXIdxLoc] = scala.scalanative.unsafe.alloc[CXIdxLoc](1)
    def apply(ptr_data: CArray[Ptr[Byte], Nat._2], int_data: CUnsignedInt)(using Zone): Ptr[CXIdxLoc] = 
      val ____ptr = apply()
      (!____ptr).ptr_data = ptr_data
      (!____ptr).int_data = int_data
      ____ptr
    extension (struct: CXIdxLoc)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
      def int_data: CUnsignedInt = struct._2
      def int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXIdxObjCCategoryDeclInfo = CStruct5[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]
  object CXIdxObjCCategoryDeclInfo:
    given _tag: Tag[CXIdxObjCCategoryDeclInfo] = Tag.materializeCStruct5Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]
    def apply()(using Zone): Ptr[CXIdxObjCCategoryDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCCategoryDeclInfo](1)
    def apply(containerInfo: Ptr[CXIdxObjCContainerDeclInfo], objcClass: Ptr[CXIdxEntityInfo], classCursor: CXCursor, classLoc: CXIdxLoc, protocols: Ptr[CXIdxObjCProtocolRefListInfo])(using Zone): Ptr[CXIdxObjCCategoryDeclInfo] = 
      val ____ptr = apply()
      (!____ptr).containerInfo = containerInfo
      (!____ptr).objcClass = objcClass
      (!____ptr).classCursor = classCursor
      (!____ptr).classLoc = classLoc
      (!____ptr).protocols = protocols
      ____ptr
    extension (struct: CXIdxObjCCategoryDeclInfo)
      def containerInfo: Ptr[CXIdxObjCContainerDeclInfo] = struct._1
      def containerInfo_=(value: Ptr[CXIdxObjCContainerDeclInfo]): Unit = !struct.at1 = value
      def objcClass: Ptr[CXIdxEntityInfo] = struct._2
      def objcClass_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at2 = value
      def classCursor: CXCursor = struct._3
      def classCursor_=(value: CXCursor): Unit = !struct.at3 = value
      def classLoc: CXIdxLoc = struct._4
      def classLoc_=(value: CXIdxLoc): Unit = !struct.at4 = value
      def protocols: Ptr[CXIdxObjCProtocolRefListInfo] = struct._5
      def protocols_=(value: Ptr[CXIdxObjCProtocolRefListInfo]): Unit = !struct.at5 = value

  opaque type CXIdxObjCContainerDeclInfo = CStruct2[Ptr[CXIdxDeclInfo], CXIdxObjCContainerKind]
  object CXIdxObjCContainerDeclInfo:
    given _tag: Tag[CXIdxObjCContainerDeclInfo] = Tag.materializeCStruct2Tag[Ptr[CXIdxDeclInfo], CXIdxObjCContainerKind]
    def apply()(using Zone): Ptr[CXIdxObjCContainerDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCContainerDeclInfo](1)
    def apply(declInfo: Ptr[CXIdxDeclInfo], kind: CXIdxObjCContainerKind)(using Zone): Ptr[CXIdxObjCContainerDeclInfo] = 
      val ____ptr = apply()
      (!____ptr).declInfo = declInfo
      (!____ptr).kind = kind
      ____ptr
    extension (struct: CXIdxObjCContainerDeclInfo)
      def declInfo: Ptr[CXIdxDeclInfo] = struct._1
      def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
      def kind: CXIdxObjCContainerKind = struct._2
      def kind_=(value: CXIdxObjCContainerKind): Unit = !struct.at2 = value

  opaque type CXIdxObjCInterfaceDeclInfo = CStruct3[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]
  object CXIdxObjCInterfaceDeclInfo:
    given _tag: Tag[CXIdxObjCInterfaceDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]
    def apply()(using Zone): Ptr[CXIdxObjCInterfaceDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCInterfaceDeclInfo](1)
    def apply(containerInfo: Ptr[CXIdxObjCContainerDeclInfo], superInfo: Ptr[CXIdxBaseClassInfo], protocols: Ptr[CXIdxObjCProtocolRefListInfo])(using Zone): Ptr[CXIdxObjCInterfaceDeclInfo] = 
      val ____ptr = apply()
      (!____ptr).containerInfo = containerInfo
      (!____ptr).superInfo = superInfo
      (!____ptr).protocols = protocols
      ____ptr
    extension (struct: CXIdxObjCInterfaceDeclInfo)
      def containerInfo: Ptr[CXIdxObjCContainerDeclInfo] = struct._1
      def containerInfo_=(value: Ptr[CXIdxObjCContainerDeclInfo]): Unit = !struct.at1 = value
      def superInfo: Ptr[CXIdxBaseClassInfo] = struct._2
      def superInfo_=(value: Ptr[CXIdxBaseClassInfo]): Unit = !struct.at2 = value
      def protocols: Ptr[CXIdxObjCProtocolRefListInfo] = struct._3
      def protocols_=(value: Ptr[CXIdxObjCProtocolRefListInfo]): Unit = !struct.at3 = value

  opaque type CXIdxObjCPropertyDeclInfo = CStruct3[Ptr[CXIdxDeclInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo]]
  object CXIdxObjCPropertyDeclInfo:
    given _tag: Tag[CXIdxObjCPropertyDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxDeclInfo], Ptr[CXIdxEntityInfo], Ptr[CXIdxEntityInfo]]
    def apply()(using Zone): Ptr[CXIdxObjCPropertyDeclInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCPropertyDeclInfo](1)
    def apply(declInfo: Ptr[CXIdxDeclInfo], getter: Ptr[CXIdxEntityInfo], setter: Ptr[CXIdxEntityInfo])(using Zone): Ptr[CXIdxObjCPropertyDeclInfo] = 
      val ____ptr = apply()
      (!____ptr).declInfo = declInfo
      (!____ptr).getter = getter
      (!____ptr).setter = setter
      ____ptr
    extension (struct: CXIdxObjCPropertyDeclInfo)
      def declInfo: Ptr[CXIdxDeclInfo] = struct._1
      def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
      def getter: Ptr[CXIdxEntityInfo] = struct._2
      def getter_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at2 = value
      def setter: Ptr[CXIdxEntityInfo] = struct._3
      def setter_=(value: Ptr[CXIdxEntityInfo]): Unit = !struct.at3 = value

  opaque type CXIdxObjCProtocolRefInfo = CStruct3[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
  object CXIdxObjCProtocolRefInfo:
    given _tag: Tag[CXIdxObjCProtocolRefInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc]
    def apply()(using Zone): Ptr[CXIdxObjCProtocolRefInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCProtocolRefInfo](1)
    def apply(protocol: Ptr[CXIdxEntityInfo], cursor: CXCursor, loc: CXIdxLoc)(using Zone): Ptr[CXIdxObjCProtocolRefInfo] = 
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

  opaque type CXIdxObjCProtocolRefListInfo = CStruct2[Ptr[Ptr[CXIdxObjCProtocolRefInfo]], CUnsignedInt]
  object CXIdxObjCProtocolRefListInfo:
    given _tag: Tag[CXIdxObjCProtocolRefListInfo] = Tag.materializeCStruct2Tag[Ptr[Ptr[CXIdxObjCProtocolRefInfo]], CUnsignedInt]
    def apply()(using Zone): Ptr[CXIdxObjCProtocolRefListInfo] = scala.scalanative.unsafe.alloc[CXIdxObjCProtocolRefListInfo](1)
    def apply(protocols: Ptr[Ptr[CXIdxObjCProtocolRefInfo]], numProtocols: CUnsignedInt)(using Zone): Ptr[CXIdxObjCProtocolRefListInfo] = 
      val ____ptr = apply()
      (!____ptr).protocols = protocols
      (!____ptr).numProtocols = numProtocols
      ____ptr
    extension (struct: CXIdxObjCProtocolRefListInfo)
      def protocols: Ptr[Ptr[CXIdxObjCProtocolRefInfo]] = struct._1
      def protocols_=(value: Ptr[Ptr[CXIdxObjCProtocolRefInfo]]): Unit = !struct.at1 = value
      def numProtocols: CUnsignedInt = struct._2
      def numProtocols_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXModuleMapDescriptorImpl = CStruct0
  object CXModuleMapDescriptorImpl:
    given _tag: Tag[CXModuleMapDescriptorImpl] = Tag.materializeCStruct0Tag

  opaque type CXPlatformAvailability = CStruct6[CXString, CXVersion, CXVersion, CXVersion, CInt, CXString]
  object CXPlatformAvailability:
    given _tag: Tag[CXPlatformAvailability] = Tag.materializeCStruct6Tag[CXString, CXVersion, CXVersion, CXVersion, CInt, CXString]
    def apply()(using Zone): Ptr[CXPlatformAvailability] = scala.scalanative.unsafe.alloc[CXPlatformAvailability](1)
    def apply(Platform: CXString, Introduced: CXVersion, Deprecated: CXVersion, Obsoleted: CXVersion, Unavailable: CInt, Message: CXString)(using Zone): Ptr[CXPlatformAvailability] = 
      val ____ptr = apply()
      (!____ptr).Platform = Platform
      (!____ptr).Introduced = Introduced
      (!____ptr).Deprecated = Deprecated
      (!____ptr).Obsoleted = Obsoleted
      (!____ptr).Unavailable = Unavailable
      (!____ptr).Message = Message
      ____ptr
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

  opaque type CXSourceLocation = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  object CXSourceLocation:
    given _tag: Tag[CXSourceLocation] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
    def apply()(using Zone): Ptr[CXSourceLocation] = scala.scalanative.unsafe.alloc[CXSourceLocation](1)
    def apply(ptr_data: CArray[Ptr[Byte], Nat._2], int_data: CUnsignedInt)(using Zone): Ptr[CXSourceLocation] = 
      val ____ptr = apply()
      (!____ptr).ptr_data = ptr_data
      (!____ptr).int_data = int_data
      ____ptr
    extension (struct: CXSourceLocation)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
      def int_data: CUnsignedInt = struct._2
      def int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXSourceRange = CStruct3[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]
  object CXSourceRange:
    given _tag: Tag[CXSourceRange] = Tag.materializeCStruct3Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]
    def apply()(using Zone): Ptr[CXSourceRange] = scala.scalanative.unsafe.alloc[CXSourceRange](1)
    def apply(ptr_data: CArray[Ptr[Byte], Nat._2], begin_int_data: CUnsignedInt, end_int_data: CUnsignedInt)(using Zone): Ptr[CXSourceRange] = 
      val ____ptr = apply()
      (!____ptr).ptr_data = ptr_data
      (!____ptr).begin_int_data = begin_int_data
      (!____ptr).end_int_data = end_int_data
      ____ptr
    extension (struct: CXSourceRange)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
      def begin_int_data: CUnsignedInt = struct._2
      def begin_int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def end_int_data: CUnsignedInt = struct._3
      def end_int_data_=(value: CUnsignedInt): Unit = !struct.at3 = value

  opaque type CXSourceRangeList = CStruct2[CUnsignedInt, Ptr[CXSourceRange]]
  object CXSourceRangeList:
    given _tag: Tag[CXSourceRangeList] = Tag.materializeCStruct2Tag[CUnsignedInt, Ptr[CXSourceRange]]
    def apply()(using Zone): Ptr[CXSourceRangeList] = scala.scalanative.unsafe.alloc[CXSourceRangeList](1)
    def apply(count: CUnsignedInt, ranges: Ptr[CXSourceRange])(using Zone): Ptr[CXSourceRangeList] = 
      val ____ptr = apply()
      (!____ptr).count = count
      (!____ptr).ranges = ranges
      ____ptr
    extension (struct: CXSourceRangeList)
      def count: CUnsignedInt = struct._1
      def count_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def ranges: Ptr[CXSourceRange] = struct._2
      def ranges_=(value: Ptr[CXSourceRange]): Unit = !struct.at2 = value

  opaque type CXString = CStruct2[Ptr[Byte], CUnsignedInt]
  object CXString:
    given _tag: Tag[CXString] = Tag.materializeCStruct2Tag[Ptr[Byte], CUnsignedInt]
    def apply()(using Zone): Ptr[CXString] = scala.scalanative.unsafe.alloc[CXString](1)
    def apply(data: Ptr[Byte], private_flags: CUnsignedInt)(using Zone): Ptr[CXString] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).private_flags = private_flags
      ____ptr
    extension (struct: CXString)
      def data: Ptr[Byte] = struct._1
      def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def private_flags: CUnsignedInt = struct._2
      def private_flags_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXStringSet = CStruct2[Ptr[CXString], CUnsignedInt]
  object CXStringSet:
    given _tag: Tag[CXStringSet] = Tag.materializeCStruct2Tag[Ptr[CXString], CUnsignedInt]
    def apply()(using Zone): Ptr[CXStringSet] = scala.scalanative.unsafe.alloc[CXStringSet](1)
    def apply(Strings: Ptr[CXString], Count: CUnsignedInt)(using Zone): Ptr[CXStringSet] = 
      val ____ptr = apply()
      (!____ptr).Strings = Strings
      (!____ptr).Count = Count
      ____ptr
    extension (struct: CXStringSet)
      def Strings: Ptr[CXString] = struct._1
      def Strings_=(value: Ptr[CXString]): Unit = !struct.at1 = value
      def Count: CUnsignedInt = struct._2
      def Count_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXTUResourceUsage = CStruct3[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]
  object CXTUResourceUsage:
    given _tag: Tag[CXTUResourceUsage] = Tag.materializeCStruct3Tag[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]
    def apply()(using Zone): Ptr[CXTUResourceUsage] = scala.scalanative.unsafe.alloc[CXTUResourceUsage](1)
    def apply(data: Ptr[Byte], numEntries: CUnsignedInt, entries: Ptr[CXTUResourceUsageEntry])(using Zone): Ptr[CXTUResourceUsage] = 
      val ____ptr = apply()
      (!____ptr).data = data
      (!____ptr).numEntries = numEntries
      (!____ptr).entries = entries
      ____ptr
    extension (struct: CXTUResourceUsage)
      def data: Ptr[Byte] = struct._1
      def data_=(value: Ptr[Byte]): Unit = !struct.at1 = value
      def numEntries: CUnsignedInt = struct._2
      def numEntries_=(value: CUnsignedInt): Unit = !struct.at2 = value
      def entries: Ptr[CXTUResourceUsageEntry] = struct._3
      def entries_=(value: Ptr[CXTUResourceUsageEntry]): Unit = !struct.at3 = value

  opaque type CXTUResourceUsageEntry = CStruct2[CXTUResourceUsageKind, CUnsignedLongInt]
  object CXTUResourceUsageEntry:
    given _tag: Tag[CXTUResourceUsageEntry] = Tag.materializeCStruct2Tag[CXTUResourceUsageKind, CUnsignedLongInt]
    def apply()(using Zone): Ptr[CXTUResourceUsageEntry] = scala.scalanative.unsafe.alloc[CXTUResourceUsageEntry](1)
    def apply(kind: CXTUResourceUsageKind, amount: CUnsignedLongInt)(using Zone): Ptr[CXTUResourceUsageEntry] = 
      val ____ptr = apply()
      (!____ptr).kind = kind
      (!____ptr).amount = amount
      ____ptr
    extension (struct: CXTUResourceUsageEntry)
      def kind: CXTUResourceUsageKind = struct._1
      def kind_=(value: CXTUResourceUsageKind): Unit = !struct.at1 = value
      def amount: CUnsignedLongInt = struct._2
      def amount_=(value: CUnsignedLongInt): Unit = !struct.at2 = value

  opaque type CXTargetInfoImpl = CStruct0
  object CXTargetInfoImpl:
    given _tag: Tag[CXTargetInfoImpl] = Tag.materializeCStruct0Tag

  opaque type CXToken = CStruct2[CArray[CUnsignedInt, Nat._4], Ptr[Byte]]
  object CXToken:
    given _tag: Tag[CXToken] = Tag.materializeCStruct2Tag[CArray[CUnsignedInt, Nat._4], Ptr[Byte]]
    def apply()(using Zone): Ptr[CXToken] = scala.scalanative.unsafe.alloc[CXToken](1)
    def apply(int_data: CArray[CUnsignedInt, Nat._4], ptr_data: Ptr[Byte])(using Zone): Ptr[CXToken] = 
      val ____ptr = apply()
      (!____ptr).int_data = int_data
      (!____ptr).ptr_data = ptr_data
      ____ptr
    extension (struct: CXToken)
      def int_data: CArray[CUnsignedInt, Nat._4] = struct._1
      def int_data_=(value: CArray[CUnsignedInt, Nat._4]): Unit = !struct.at1 = value
      def ptr_data: Ptr[Byte] = struct._2
      def ptr_data_=(value: Ptr[Byte]): Unit = !struct.at2 = value

  opaque type CXTranslationUnitImpl = CStruct0
  object CXTranslationUnitImpl:
    given _tag: Tag[CXTranslationUnitImpl] = Tag.materializeCStruct0Tag

  opaque type CXType = CStruct2[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
  object CXType:
    given _tag: Tag[CXType] = Tag.materializeCStruct2Tag[CXTypeKind, CArray[Ptr[Byte], Nat._2]]
    def apply()(using Zone): Ptr[CXType] = scala.scalanative.unsafe.alloc[CXType](1)
    def apply(kind: CXTypeKind, data: CArray[Ptr[Byte], Nat._2])(using Zone): Ptr[CXType] = 
      val ____ptr = apply()
      (!____ptr).kind = kind
      (!____ptr).data = data
      ____ptr
    extension (struct: CXType)
      def kind: CXTypeKind = struct._1
      def kind_=(value: CXTypeKind): Unit = !struct.at1 = value
      def data: CArray[Ptr[Byte], Nat._2] = struct._2
      def data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at2 = value

  opaque type CXUnsavedFile = CStruct3[CString, CString, CUnsignedLongInt]
  object CXUnsavedFile:
    given _tag: Tag[CXUnsavedFile] = Tag.materializeCStruct3Tag[CString, CString, CUnsignedLongInt]
    def apply()(using Zone): Ptr[CXUnsavedFile] = scala.scalanative.unsafe.alloc[CXUnsavedFile](1)
    def apply(Filename: CString, Contents: CString, Length: CUnsignedLongInt)(using Zone): Ptr[CXUnsavedFile] = 
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

  opaque type CXVersion = CStruct3[CInt, CInt, CInt]
  object CXVersion:
    given _tag: Tag[CXVersion] = Tag.materializeCStruct3Tag[CInt, CInt, CInt]
    def apply()(using Zone): Ptr[CXVersion] = scala.scalanative.unsafe.alloc[CXVersion](1)
    def apply(Major: CInt, Minor: CInt, Subminor: CInt)(using Zone): Ptr[CXVersion] = 
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

  opaque type CXVirtualFileOverlayImpl = CStruct0
  object CXVirtualFileOverlayImpl:
    given _tag: Tag[CXVirtualFileOverlayImpl] = Tag.materializeCStruct0Tag

  opaque type IndexerCallbacks = CStruct8[Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]], Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]], Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]], Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]]
  object IndexerCallbacks:
    given _tag: Tag[IndexerCallbacks] = Tag.materializeCStruct8Tag[Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]], Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]], Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]], Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]]
    def apply()(using Zone): Ptr[IndexerCallbacks] = scala.scalanative.unsafe.alloc[IndexerCallbacks](1)
    def apply(abortQuery: Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]], diagnostic: Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]], enteredMainFile: Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]], ppIncludedFile: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]], importedASTFile: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]], startedTranslationUnit: Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]], indexDeclaration: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]], indexEntityReference: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]])(using Zone): Ptr[IndexerCallbacks] = 
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
    extension (struct: IndexerCallbacks)
      def abortQuery: Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]] = struct._1
      def abortQuery_=(value: Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]]): Unit = !struct.at1 = value
      def diagnostic: Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]] = struct._2
      def diagnostic_=(value: Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]]): Unit = !struct.at2 = value
      def enteredMainFile: Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]] = struct._3
      def enteredMainFile_=(value: Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]]): Unit = !struct.at3 = value
      def ppIncludedFile: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]] = struct._4
      def ppIncludedFile_=(value: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]]): Unit = !struct.at4 = value
      def importedASTFile: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]] = struct._5
      def importedASTFile_=(value: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]]): Unit = !struct.at5 = value
      def startedTranslationUnit: Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]] = struct._6
      def startedTranslationUnit_=(value: Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]]): Unit = !struct.at6 = value
      def indexDeclaration: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]] = struct._7
      def indexDeclaration_=(value: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]]): Unit = !struct.at7 = value
      def indexEntityReference: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]] = struct._8
      def indexEntityReference_=(value: Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]): Unit = !struct.at8 = value

  opaque type __darwin_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_attr_t:
    given _tag: Tag[__darwin_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_attr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_attr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[__darwin_pthread_attr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object __darwin_pthread_cond_t:
    given _tag: Tag[__darwin_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    def apply()(using Zone): Ptr[__darwin_pthread_cond_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_cond_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using Zone): Ptr[__darwin_pthread_cond_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_condattr_t:
    given _tag: Tag[__darwin_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_condattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_condattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_condattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_handler_rec = CStruct3[Ptr[CFuncPtr1[Ptr[Byte], Unit]], Ptr[Byte], Ptr[Byte]]
  object __darwin_pthread_handler_rec:
    given _tag: Tag[__darwin_pthread_handler_rec] = Tag.materializeCStruct3Tag[Ptr[CFuncPtr1[Ptr[Byte], Unit]], Ptr[Byte], Ptr[Byte]]
    def apply()(using Zone): Ptr[__darwin_pthread_handler_rec] = scala.scalanative.unsafe.alloc[__darwin_pthread_handler_rec](1)
    def apply(__routine: Ptr[CFuncPtr1[Ptr[Byte], Unit]], __arg: Ptr[Byte], __next: Ptr[__darwin_pthread_handler_rec])(using Zone): Ptr[__darwin_pthread_handler_rec] = 
      val ____ptr = apply()
      (!____ptr).__routine = __routine
      (!____ptr).__arg = __arg
      (!____ptr).__next = __next
      ____ptr
    extension (struct: __darwin_pthread_handler_rec)
      def __routine: Ptr[CFuncPtr1[Ptr[Byte], Unit]] = struct._1
      def __routine_=(value: Ptr[CFuncPtr1[Ptr[Byte], Unit]]): Unit = !struct.at1 = value
      def __arg: Ptr[Byte] = struct._2
      def __arg_=(value: Ptr[Byte]): Unit = !struct.at2 = value
      def __next: Ptr[__darwin_pthread_handler_rec] = struct._3.asInstanceOf[Ptr[__darwin_pthread_handler_rec]]
      def __next_=(value: Ptr[__darwin_pthread_handler_rec]): Unit = !struct.at3 = value.asInstanceOf[Ptr[Byte]]

  opaque type __darwin_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object __darwin_pthread_mutex_t:
    given _tag: Tag[__darwin_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_mutex_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_mutex_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[__darwin_pthread_mutex_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_mutexattr_t:
    given _tag: Tag[__darwin_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_mutexattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_mutexattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_mutexattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_once_t:
    given _tag: Tag[__darwin_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[__darwin_pthread_once_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_once_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[__darwin_pthread_once_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object __darwin_pthread_rwlock_t:
    given _tag: Tag[__darwin_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    def apply()(using Zone): Ptr[__darwin_pthread_rwlock_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_rwlock_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]])(using Zone): Ptr[__darwin_pthread_rwlock_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object __darwin_pthread_rwlockattr_t:
    given _tag: Tag[__darwin_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[__darwin_pthread_rwlockattr_t] = scala.scalanative.unsafe.alloc[__darwin_pthread_rwlockattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[__darwin_pthread_rwlockattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: __darwin_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_attr_t:
    given _tag: Tag[_opaque_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_attr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_attr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[_opaque_pthread_attr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object _opaque_pthread_cond_t:
    given _tag: Tag[_opaque_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    def apply()(using Zone): Ptr[_opaque_pthread_cond_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_cond_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]])(using Zone): Ptr[_opaque_pthread_cond_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_condattr_t:
    given _tag: Tag[_opaque_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_condattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_condattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_condattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_mutex_t:
    given _tag: Tag[_opaque_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_mutex_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_mutex_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]])(using Zone): Ptr[_opaque_pthread_mutex_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_mutexattr_t:
    given _tag: Tag[_opaque_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_mutexattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_mutexattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_mutexattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_once_t:
    given _tag: Tag[_opaque_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    def apply()(using Zone): Ptr[_opaque_pthread_once_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_once_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat._8])(using Zone): Ptr[_opaque_pthread_once_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object _opaque_pthread_rwlock_t:
    given _tag: Tag[_opaque_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    def apply()(using Zone): Ptr[_opaque_pthread_rwlock_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_rwlock_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]])(using Zone): Ptr[_opaque_pthread_rwlock_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object _opaque_pthread_rwlockattr_t:
    given _tag: Tag[_opaque_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_rwlockattr_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_rwlockattr_t](1)
    def apply(__sig: CLongInt, __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]])(using Zone): Ptr[_opaque_pthread_rwlockattr_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_t = CStruct3[CLongInt, Ptr[__darwin_pthread_handler_rec], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
  object _opaque_pthread_t:
    given _tag: Tag[_opaque_pthread_t] = Tag.materializeCStruct3Tag[CLongInt, Ptr[__darwin_pthread_handler_rec], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
    def apply()(using Zone): Ptr[_opaque_pthread_t] = scala.scalanative.unsafe.alloc[_opaque_pthread_t](1)
    def apply(__sig: CLongInt, __cleanup_stack: Ptr[__darwin_pthread_handler_rec], __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]])(using Zone): Ptr[_opaque_pthread_t] = 
      val ____ptr = apply()
      (!____ptr).__sig = __sig
      (!____ptr).__cleanup_stack = __cleanup_stack
      (!____ptr).__opaque = __opaque
      ____ptr
    extension (struct: _opaque_pthread_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __cleanup_stack: Ptr[__darwin_pthread_handler_rec] = struct._2
      def __cleanup_stack_=(value: Ptr[__darwin_pthread_handler_rec]): Unit = !struct.at2 = value
      def __opaque: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]] = struct._3
      def __opaque_=(value: CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]): Unit = !struct.at3 = value

  opaque type timespec = CStruct2[__darwin_time_t, CLongInt]
  object timespec:
    given _tag: Tag[timespec] = Tag.materializeCStruct2Tag[__darwin_time_t, CLongInt]
    def apply()(using Zone): Ptr[timespec] = scala.scalanative.unsafe.alloc[timespec](1)
    def apply(tv_sec: __darwin_time_t, tv_nsec: CLongInt)(using Zone): Ptr[timespec] = 
      val ____ptr = apply()
      (!____ptr).tv_sec = tv_sec
      (!____ptr).tv_nsec = tv_nsec
      ____ptr
    extension (struct: timespec)
      def tv_sec: __darwin_time_t = struct._1
      def tv_sec_=(value: __darwin_time_t): Unit = !struct.at1 = value
      def tv_nsec: CLongInt = struct._2
      def tv_nsec_=(value: CLongInt): Unit = !struct.at2 = value

  opaque type tm = CStruct11[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CLongInt, CString]
  object tm:
    given _tag: Tag[tm] = Tag.materializeCStruct11Tag[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CLongInt, CString]
    def apply()(using Zone): Ptr[tm] = scala.scalanative.unsafe.alloc[tm](1)
    def apply(tm_sec: CInt, tm_min: CInt, tm_hour: CInt, tm_mday: CInt, tm_mon: CInt, tm_year: CInt, tm_wday: CInt, tm_yday: CInt, tm_isdst: CInt, tm_gmtoff: CLongInt, tm_zone: CString)(using Zone): Ptr[tm] = 
      val ____ptr = apply()
      (!____ptr).tm_sec = tm_sec
      (!____ptr).tm_min = tm_min
      (!____ptr).tm_hour = tm_hour
      (!____ptr).tm_mday = tm_mday
      (!____ptr).tm_mon = tm_mon
      (!____ptr).tm_year = tm_year
      (!____ptr).tm_wday = tm_wday
      (!____ptr).tm_yday = tm_yday
      (!____ptr).tm_isdst = tm_isdst
      (!____ptr).tm_gmtoff = tm_gmtoff
      (!____ptr).tm_zone = tm_zone
      ____ptr
    extension (struct: tm)
      def tm_sec: CInt = struct._1
      def tm_sec_=(value: CInt): Unit = !struct.at1 = value
      def tm_min: CInt = struct._2
      def tm_min_=(value: CInt): Unit = !struct.at2 = value
      def tm_hour: CInt = struct._3
      def tm_hour_=(value: CInt): Unit = !struct.at3 = value
      def tm_mday: CInt = struct._4
      def tm_mday_=(value: CInt): Unit = !struct.at4 = value
      def tm_mon: CInt = struct._5
      def tm_mon_=(value: CInt): Unit = !struct.at5 = value
      def tm_year: CInt = struct._6
      def tm_year_=(value: CInt): Unit = !struct.at6 = value
      def tm_wday: CInt = struct._7
      def tm_wday_=(value: CInt): Unit = !struct.at7 = value
      def tm_yday: CInt = struct._8
      def tm_yday_=(value: CInt): Unit = !struct.at8 = value
      def tm_isdst: CInt = struct._9
      def tm_isdst_=(value: CInt): Unit = !struct.at9 = value
      def tm_gmtoff: CLongInt = struct._10
      def tm_gmtoff_=(value: CLongInt): Unit = !struct.at10 = value
      def tm_zone: CString = struct._11
      def tm_zone_=(value: CString): Unit = !struct.at11 = value
  opaque type __mbstate_t = CArray[Byte, Nat.Digit3[Nat._1, Nat._2, Nat._8]]
  object __mbstate_t:
    given _tag: Tag[__mbstate_t] = Tag.CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]](Tag.Byte, Tag.Digit3[Nat._1, Nat._2, Nat._8](Tag.Nat1, Tag.Nat2, Tag.Nat8))
    extension (struct: __mbstate_t)
      def __mbstate8: CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]] = !struct.at(0).asInstanceOf[Ptr[CArray[CChar, Nat.Digit3[Nat._1, Nat._2, Nat._8]]]]
      def _mbstateL: CLongLong = !struct.at(0).asInstanceOf[Ptr[CLongLong]]
@link("clang")
@extern
private[libclang] object extern_functions: 
  import types.*

  @name("__sn_wrap_clang_CXCursorSet_contains")
  private[libclang] def __sn_wrap_clang_CXCursorSet_contains(cset: CXCursorSet, cursor: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXCursorSet_insert")
  private[libclang] def __sn_wrap_clang_CXCursorSet_insert(cset: CXCursorSet, cursor: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXConstructor_isConvertingConstructor")
  private[libclang] def __sn_wrap_clang_CXXConstructor_isConvertingConstructor(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXConstructor_isCopyConstructor")
  private[libclang] def __sn_wrap_clang_CXXConstructor_isCopyConstructor(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXConstructor_isDefaultConstructor")
  private[libclang] def __sn_wrap_clang_CXXConstructor_isDefaultConstructor(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXConstructor_isMoveConstructor")
  private[libclang] def __sn_wrap_clang_CXXConstructor_isMoveConstructor(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXField_isMutable")
  private[libclang] def __sn_wrap_clang_CXXField_isMutable(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXMethod_isConst")
  private[libclang] def __sn_wrap_clang_CXXMethod_isConst(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXMethod_isDefaulted")
  private[libclang] def __sn_wrap_clang_CXXMethod_isDefaulted(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXMethod_isPureVirtual")
  private[libclang] def __sn_wrap_clang_CXXMethod_isPureVirtual(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXMethod_isStatic")
  private[libclang] def __sn_wrap_clang_CXXMethod_isStatic(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXMethod_isVirtual")
  private[libclang] def __sn_wrap_clang_CXXMethod_isVirtual(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_CXXRecord_isAbstract")
  private[libclang] def __sn_wrap_clang_CXXRecord_isAbstract(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_Evaluate")
  private[libclang] def __sn_wrap_clang_Cursor_Evaluate(C: Ptr[CXCursor]): CXEvalResult = extern

  @name("__sn_wrap_clang_Cursor_getArgument")
  private[libclang] def __sn_wrap_clang_Cursor_getArgument(C: Ptr[CXCursor], i: CUnsignedInt, __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getBriefCommentText")
  private[libclang] def __sn_wrap_clang_Cursor_getBriefCommentText(C: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getCXXManglings")
  private[libclang] def __sn_wrap_clang_Cursor_getCXXManglings(_0: Ptr[CXCursor]): Ptr[CXStringSet] = extern

  @name("__sn_wrap_clang_Cursor_getCommentRange")
  private[libclang] def __sn_wrap_clang_Cursor_getCommentRange(C: Ptr[CXCursor], __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getMangling")
  private[libclang] def __sn_wrap_clang_Cursor_getMangling(_0: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getModule")
  private[libclang] def __sn_wrap_clang_Cursor_getModule(C: Ptr[CXCursor]): CXModule = extern

  @name("__sn_wrap_clang_Cursor_getNumArguments")
  private[libclang] def __sn_wrap_clang_Cursor_getNumArguments(C: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_getNumTemplateArguments")
  private[libclang] def __sn_wrap_clang_Cursor_getNumTemplateArguments(C: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_getObjCDeclQualifiers")
  private[libclang] def __sn_wrap_clang_Cursor_getObjCDeclQualifiers(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_getObjCManglings")
  private[libclang] def __sn_wrap_clang_Cursor_getObjCManglings(_0: Ptr[CXCursor]): Ptr[CXStringSet] = extern

  @name("__sn_wrap_clang_Cursor_getObjCPropertyAttributes")
  private[libclang] def __sn_wrap_clang_Cursor_getObjCPropertyAttributes(C: Ptr[CXCursor], reserved: CUnsignedInt): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_getObjCPropertyGetterName")
  private[libclang] def __sn_wrap_clang_Cursor_getObjCPropertyGetterName(C: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getObjCPropertySetterName")
  private[libclang] def __sn_wrap_clang_Cursor_getObjCPropertySetterName(C: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getObjCSelectorIndex")
  private[libclang] def __sn_wrap_clang_Cursor_getObjCSelectorIndex(_0: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_getOffsetOfField")
  private[libclang] def __sn_wrap_clang_Cursor_getOffsetOfField(C: Ptr[CXCursor]): CLongLong = extern

  @name("__sn_wrap_clang_Cursor_getRawCommentText")
  private[libclang] def __sn_wrap_clang_Cursor_getRawCommentText(C: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getReceiverType")
  private[libclang] def __sn_wrap_clang_Cursor_getReceiverType(C: Ptr[CXCursor], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getSpellingNameRange")
  private[libclang] def __sn_wrap_clang_Cursor_getSpellingNameRange(_0: Ptr[CXCursor], pieceIndex: CUnsignedInt, options: CUnsignedInt, __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getStorageClass")
  private[libclang] def __sn_wrap_clang_Cursor_getStorageClass(_0: Ptr[CXCursor]): CX_StorageClass = extern

  @name("__sn_wrap_clang_Cursor_getTemplateArgumentKind")
  private[libclang] def __sn_wrap_clang_Cursor_getTemplateArgumentKind(C: Ptr[CXCursor], I: CUnsignedInt): CXTemplateArgumentKind = extern

  @name("__sn_wrap_clang_Cursor_getTemplateArgumentType")
  private[libclang] def __sn_wrap_clang_Cursor_getTemplateArgumentType(C: Ptr[CXCursor], I: CUnsignedInt, __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Cursor_getTemplateArgumentUnsignedValue")
  private[libclang] def __sn_wrap_clang_Cursor_getTemplateArgumentUnsignedValue(C: Ptr[CXCursor], I: CUnsignedInt): CUnsignedLongLong = extern

  @name("__sn_wrap_clang_Cursor_getTemplateArgumentValue")
  private[libclang] def __sn_wrap_clang_Cursor_getTemplateArgumentValue(C: Ptr[CXCursor], I: CUnsignedInt): CLongLong = extern

  @name("__sn_wrap_clang_Cursor_getTranslationUnit")
  private[libclang] def __sn_wrap_clang_Cursor_getTranslationUnit(_0: Ptr[CXCursor]): CXTranslationUnit = extern

  @name("__sn_wrap_clang_Cursor_getVarDeclInitializer")
  private[libclang] def __sn_wrap_clang_Cursor_getVarDeclInitializer(cursor: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_Cursor_hasAttrs")
  private[libclang] def __sn_wrap_clang_Cursor_hasAttrs(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_hasVarDeclExternalStorage")
  private[libclang] def __sn_wrap_clang_Cursor_hasVarDeclExternalStorage(cursor: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_hasVarDeclGlobalStorage")
  private[libclang] def __sn_wrap_clang_Cursor_hasVarDeclGlobalStorage(cursor: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_isAnonymous")
  private[libclang] def __sn_wrap_clang_Cursor_isAnonymous(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isAnonymousRecordDecl")
  private[libclang] def __sn_wrap_clang_Cursor_isAnonymousRecordDecl(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isBitField")
  private[libclang] def __sn_wrap_clang_Cursor_isBitField(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isDynamicCall")
  private[libclang] def __sn_wrap_clang_Cursor_isDynamicCall(C: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_isExternalSymbol")
  private[libclang] def __sn_wrap_clang_Cursor_isExternalSymbol(C: Ptr[CXCursor], language: Ptr[CXString], definedIn: Ptr[CXString], isGenerated: Ptr[CUnsignedInt]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isFunctionInlined")
  private[libclang] def __sn_wrap_clang_Cursor_isFunctionInlined(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isInlineNamespace")
  private[libclang] def __sn_wrap_clang_Cursor_isInlineNamespace(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isMacroBuiltin")
  private[libclang] def __sn_wrap_clang_Cursor_isMacroBuiltin(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isMacroFunctionLike")
  private[libclang] def __sn_wrap_clang_Cursor_isMacroFunctionLike(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isNull")
  private[libclang] def __sn_wrap_clang_Cursor_isNull(cursor: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_Cursor_isObjCOptional")
  private[libclang] def __sn_wrap_clang_Cursor_isObjCOptional(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Cursor_isVariadic")
  private[libclang] def __sn_wrap_clang_Cursor_isVariadic(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_EnumDecl_isScoped")
  private[libclang] def __sn_wrap_clang_EnumDecl_isScoped(C: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_File_tryGetRealPathName")
  private[libclang] def __sn_wrap_clang_File_tryGetRealPathName(file: CXFile, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Location_isFromMainFile")
  private[libclang] def __sn_wrap_clang_Location_isFromMainFile(location: Ptr[CXSourceLocation]): CInt = extern

  @name("__sn_wrap_clang_Location_isInSystemHeader")
  private[libclang] def __sn_wrap_clang_Location_isInSystemHeader(location: Ptr[CXSourceLocation]): CInt = extern

  @name("__sn_wrap_clang_Module_getFullName")
  private[libclang] def __sn_wrap_clang_Module_getFullName(Module: CXModule, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Module_getName")
  private[libclang] def __sn_wrap_clang_Module_getName(Module: CXModule, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Range_isNull")
  private[libclang] def __sn_wrap_clang_Range_isNull(range: Ptr[CXSourceRange]): CInt = extern

  @name("__sn_wrap_clang_TargetInfo_getTriple")
  private[libclang] def __sn_wrap_clang_TargetInfo_getTriple(Info: CXTargetInfo, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Type_getAlignOf")
  private[libclang] def __sn_wrap_clang_Type_getAlignOf(T: Ptr[CXType]): CLongLong = extern

  @name("__sn_wrap_clang_Type_getCXXRefQualifier")
  private[libclang] def __sn_wrap_clang_Type_getCXXRefQualifier(T: Ptr[CXType]): CXRefQualifierKind = extern

  @name("__sn_wrap_clang_Type_getClassType")
  private[libclang] def __sn_wrap_clang_Type_getClassType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_getModifiedType")
  private[libclang] def __sn_wrap_clang_Type_getModifiedType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_getNamedType")
  private[libclang] def __sn_wrap_clang_Type_getNamedType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_getNullability")
  private[libclang] def __sn_wrap_clang_Type_getNullability(T: Ptr[CXType]): CXTypeNullabilityKind = extern

  @name("__sn_wrap_clang_Type_getNumObjCProtocolRefs")
  private[libclang] def __sn_wrap_clang_Type_getNumObjCProtocolRefs(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Type_getNumObjCTypeArgs")
  private[libclang] def __sn_wrap_clang_Type_getNumObjCTypeArgs(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Type_getNumTemplateArguments")
  private[libclang] def __sn_wrap_clang_Type_getNumTemplateArguments(T: Ptr[CXType]): CInt = extern

  @name("__sn_wrap_clang_Type_getObjCEncoding")
  private[libclang] def __sn_wrap_clang_Type_getObjCEncoding(`type`: Ptr[CXType], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_Type_getObjCObjectBaseType")
  private[libclang] def __sn_wrap_clang_Type_getObjCObjectBaseType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_getObjCProtocolDecl")
  private[libclang] def __sn_wrap_clang_Type_getObjCProtocolDecl(T: Ptr[CXType], i: CUnsignedInt, __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_Type_getObjCTypeArg")
  private[libclang] def __sn_wrap_clang_Type_getObjCTypeArg(T: Ptr[CXType], i: CUnsignedInt, __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_getOffsetOf")
  private[libclang] def __sn_wrap_clang_Type_getOffsetOf(T: Ptr[CXType], S: CString): CLongLong = extern

  @name("__sn_wrap_clang_Type_getSizeOf")
  private[libclang] def __sn_wrap_clang_Type_getSizeOf(T: Ptr[CXType]): CLongLong = extern

  @name("__sn_wrap_clang_Type_getTemplateArgumentAsType")
  private[libclang] def __sn_wrap_clang_Type_getTemplateArgumentAsType(T: Ptr[CXType], i: CUnsignedInt, __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_getValueType")
  private[libclang] def __sn_wrap_clang_Type_getValueType(CT: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_Type_isTransparentTagTypedef")
  private[libclang] def __sn_wrap_clang_Type_isTransparentTagTypedef(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_Type_visitFields")
  private[libclang] def __sn_wrap_clang_Type_visitFields(T: Ptr[CXType], visitor: CXFieldVisitor, client_data: CXClientData): CUnsignedInt = extern

  @name("__sn_wrap_clang_codeCompleteGetContainerUSR")
  private[libclang] def __sn_wrap_clang_codeCompleteGetContainerUSR(Results: Ptr[CXCodeCompleteResults], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_codeCompleteGetObjCSelector")
  private[libclang] def __sn_wrap_clang_codeCompleteGetObjCSelector(Results: Ptr[CXCodeCompleteResults], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_constructUSR_ObjCCategory")
  private[libclang] def __sn_wrap_clang_constructUSR_ObjCCategory(class_name: CString, category_name: CString, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_constructUSR_ObjCClass")
  private[libclang] def __sn_wrap_clang_constructUSR_ObjCClass(class_name: CString, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_constructUSR_ObjCIvar")
  private[libclang] def __sn_wrap_clang_constructUSR_ObjCIvar(name: CString, classUSR: Ptr[CXString], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_constructUSR_ObjCMethod")
  private[libclang] def __sn_wrap_clang_constructUSR_ObjCMethod(name: CString, isInstanceMethod: CUnsignedInt, classUSR: Ptr[CXString], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_constructUSR_ObjCProperty")
  private[libclang] def __sn_wrap_clang_constructUSR_ObjCProperty(property: CString, classUSR: Ptr[CXString], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_constructUSR_ObjCProtocol")
  private[libclang] def __sn_wrap_clang_constructUSR_ObjCProtocol(protocol_name: CString, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_disposeCXTUResourceUsage")
  private[libclang] def __sn_wrap_clang_disposeCXTUResourceUsage(usage: Ptr[CXTUResourceUsage]): Unit = extern

  @name("__sn_wrap_clang_disposeString")
  private[libclang] def __sn_wrap_clang_disposeString(string: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_equalCursors")
  private[libclang] def __sn_wrap_clang_equalCursors(_0: Ptr[CXCursor], _1: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_equalLocations")
  private[libclang] def __sn_wrap_clang_equalLocations(loc1: Ptr[CXSourceLocation], loc2: Ptr[CXSourceLocation]): CUnsignedInt = extern

  @name("__sn_wrap_clang_equalRanges")
  private[libclang] def __sn_wrap_clang_equalRanges(range1: Ptr[CXSourceRange], range2: Ptr[CXSourceRange]): CUnsignedInt = extern

  @name("__sn_wrap_clang_equalTypes")
  private[libclang] def __sn_wrap_clang_equalTypes(A: Ptr[CXType], B: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_findIncludesInFile")
  private[libclang] def __sn_wrap_clang_findIncludesInFile(TU: CXTranslationUnit, file: CXFile, visitor: Ptr[CXCursorAndRangeVisitor]): CXResult = extern

  @name("__sn_wrap_clang_findReferencesInFile")
  private[libclang] def __sn_wrap_clang_findReferencesInFile(cursor: Ptr[CXCursor], file: CXFile, visitor: Ptr[CXCursorAndRangeVisitor]): CXResult = extern

  @name("__sn_wrap_clang_findReferencesInFileWithBlock")
  private[libclang] def __sn_wrap_clang_findReferencesInFileWithBlock(_0: Ptr[CXCursor], _1: CXFile, _2: CXCursorAndRangeVisitorBlock): CXResult = extern

  @name("__sn_wrap_clang_formatDiagnostic")
  private[libclang] def __sn_wrap_clang_formatDiagnostic(Diagnostic: CXDiagnostic, Options: CUnsignedInt, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getAddressSpace")
  private[libclang] def __sn_wrap_clang_getAddressSpace(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_getArgType")
  private[libclang] def __sn_wrap_clang_getArgType(T: Ptr[CXType], i: CUnsignedInt, __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getArrayElementType")
  private[libclang] def __sn_wrap_clang_getArrayElementType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getArraySize")
  private[libclang] def __sn_wrap_clang_getArraySize(T: Ptr[CXType]): CLongLong = extern

  @name("__sn_wrap_clang_getCString")
  private[libclang] def __sn_wrap_clang_getCString(string: Ptr[CXString]): CString = extern

  @name("__sn_wrap_clang_getCXTUResourceUsage")
  private[libclang] def __sn_wrap_clang_getCXTUResourceUsage(TU: CXTranslationUnit, __return: Ptr[CXTUResourceUsage]): Unit = extern

  @name("__sn_wrap_clang_getCXXAccessSpecifier")
  private[libclang] def __sn_wrap_clang_getCXXAccessSpecifier(_0: Ptr[CXCursor]): CX_CXXAccessSpecifier = extern

  @name("__sn_wrap_clang_getCanonicalCursor")
  private[libclang] def __sn_wrap_clang_getCanonicalCursor(_0: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getCanonicalType")
  private[libclang] def __sn_wrap_clang_getCanonicalType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getClangVersion")
  private[libclang] def __sn_wrap_clang_getClangVersion(__return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCompletionAnnotation")
  private[libclang] def __sn_wrap_clang_getCompletionAnnotation(completion_string: CXCompletionString, annotation_number: CUnsignedInt, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCompletionBriefComment")
  private[libclang] def __sn_wrap_clang_getCompletionBriefComment(completion_string: CXCompletionString, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCompletionChunkText")
  private[libclang] def __sn_wrap_clang_getCompletionChunkText(completion_string: CXCompletionString, chunk_number: CUnsignedInt, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCompletionFixIt")
  private[libclang] def __sn_wrap_clang_getCompletionFixIt(results: Ptr[CXCodeCompleteResults], completion_index: CUnsignedInt, fixit_index: CUnsignedInt, replacement_range: Ptr[CXSourceRange], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCompletionParent")
  private[libclang] def __sn_wrap_clang_getCompletionParent(completion_string: CXCompletionString, kind: Ptr[CXCursorKind], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCursor")
  private[libclang] def __sn_wrap_clang_getCursor(_0: CXTranslationUnit, _1: Ptr[CXSourceLocation], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getCursorAvailability")
  private[libclang] def __sn_wrap_clang_getCursorAvailability(cursor: Ptr[CXCursor]): CXAvailabilityKind = extern

  @name("__sn_wrap_clang_getCursorCompletionString")
  private[libclang] def __sn_wrap_clang_getCursorCompletionString(cursor: Ptr[CXCursor]): CXCompletionString = extern

  @name("__sn_wrap_clang_getCursorDefinition")
  private[libclang] def __sn_wrap_clang_getCursorDefinition(_0: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getCursorDisplayName")
  private[libclang] def __sn_wrap_clang_getCursorDisplayName(_0: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCursorExceptionSpecificationType")
  private[libclang] def __sn_wrap_clang_getCursorExceptionSpecificationType(C: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_getCursorExtent")
  private[libclang] def __sn_wrap_clang_getCursorExtent(_0: Ptr[CXCursor], __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_getCursorKind")
  private[libclang] def __sn_wrap_clang_getCursorKind(_0: Ptr[CXCursor]): CXCursorKind = extern

  @name("__sn_wrap_clang_getCursorKindSpelling")
  private[libclang] def __sn_wrap_clang_getCursorKindSpelling(Kind: CXCursorKind, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCursorLanguage")
  private[libclang] def __sn_wrap_clang_getCursorLanguage(cursor: Ptr[CXCursor]): CXLanguageKind = extern

  @name("__sn_wrap_clang_getCursorLexicalParent")
  private[libclang] def __sn_wrap_clang_getCursorLexicalParent(cursor: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getCursorLinkage")
  private[libclang] def __sn_wrap_clang_getCursorLinkage(cursor: Ptr[CXCursor]): CXLinkageKind = extern

  @name("__sn_wrap_clang_getCursorLocation")
  private[libclang] def __sn_wrap_clang_getCursorLocation(_0: Ptr[CXCursor], __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getCursorPlatformAvailability")
  private[libclang] def __sn_wrap_clang_getCursorPlatformAvailability(cursor: Ptr[CXCursor], always_deprecated: Ptr[CInt], deprecated_message: Ptr[CXString], always_unavailable: Ptr[CInt], unavailable_message: Ptr[CXString], availability: Ptr[CXPlatformAvailability], availability_size: CInt): CInt = extern

  @name("__sn_wrap_clang_getCursorPrettyPrinted")
  private[libclang] def __sn_wrap_clang_getCursorPrettyPrinted(Cursor: Ptr[CXCursor], Policy: CXPrintingPolicy, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCursorPrintingPolicy")
  private[libclang] def __sn_wrap_clang_getCursorPrintingPolicy(_0: Ptr[CXCursor]): CXPrintingPolicy = extern

  @name("__sn_wrap_clang_getCursorReferenceNameRange")
  private[libclang] def __sn_wrap_clang_getCursorReferenceNameRange(C: Ptr[CXCursor], NameFlags: CUnsignedInt, PieceIndex: CUnsignedInt, __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_getCursorReferenced")
  private[libclang] def __sn_wrap_clang_getCursorReferenced(_0: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getCursorResultType")
  private[libclang] def __sn_wrap_clang_getCursorResultType(C: Ptr[CXCursor], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getCursorSemanticParent")
  private[libclang] def __sn_wrap_clang_getCursorSemanticParent(cursor: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getCursorSpelling")
  private[libclang] def __sn_wrap_clang_getCursorSpelling(_0: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCursorTLSKind")
  private[libclang] def __sn_wrap_clang_getCursorTLSKind(cursor: Ptr[CXCursor]): CXTLSKind = extern

  @name("__sn_wrap_clang_getCursorType")
  private[libclang] def __sn_wrap_clang_getCursorType(C: Ptr[CXCursor], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getCursorUSR")
  private[libclang] def __sn_wrap_clang_getCursorUSR(_0: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getCursorVisibility")
  private[libclang] def __sn_wrap_clang_getCursorVisibility(cursor: Ptr[CXCursor]): CXVisibilityKind = extern

  @name("__sn_wrap_clang_getDeclObjCTypeEncoding")
  private[libclang] def __sn_wrap_clang_getDeclObjCTypeEncoding(C: Ptr[CXCursor], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getDefinitionSpellingAndExtent")
  private[libclang] def __sn_wrap_clang_getDefinitionSpellingAndExtent(_0: Ptr[CXCursor], startBuf: Ptr[CString], endBuf: Ptr[CString], startLine: Ptr[CUnsignedInt], startColumn: Ptr[CUnsignedInt], endLine: Ptr[CUnsignedInt], endColumn: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticCategoryName")
  private[libclang] def __sn_wrap_clang_getDiagnosticCategoryName(Category: CUnsignedInt, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticCategoryText")
  private[libclang] def __sn_wrap_clang_getDiagnosticCategoryText(_0: CXDiagnostic, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticFixIt")
  private[libclang] def __sn_wrap_clang_getDiagnosticFixIt(Diagnostic: CXDiagnostic, FixIt: CUnsignedInt, ReplacementRange: Ptr[CXSourceRange], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticLocation")
  private[libclang] def __sn_wrap_clang_getDiagnosticLocation(_0: CXDiagnostic, __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticOption")
  private[libclang] def __sn_wrap_clang_getDiagnosticOption(Diag: CXDiagnostic, Disable: Ptr[CXString], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticRange")
  private[libclang] def __sn_wrap_clang_getDiagnosticRange(Diagnostic: CXDiagnostic, Range: CUnsignedInt, __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_getDiagnosticSpelling")
  private[libclang] def __sn_wrap_clang_getDiagnosticSpelling(_0: CXDiagnostic, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getElementType")
  private[libclang] def __sn_wrap_clang_getElementType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getEnumConstantDeclUnsignedValue")
  private[libclang] def __sn_wrap_clang_getEnumConstantDeclUnsignedValue(C: Ptr[CXCursor]): CUnsignedLongLong = extern

  @name("__sn_wrap_clang_getEnumConstantDeclValue")
  private[libclang] def __sn_wrap_clang_getEnumConstantDeclValue(C: Ptr[CXCursor]): CLongLong = extern

  @name("__sn_wrap_clang_getEnumDeclIntegerType")
  private[libclang] def __sn_wrap_clang_getEnumDeclIntegerType(C: Ptr[CXCursor], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getExceptionSpecificationType")
  private[libclang] def __sn_wrap_clang_getExceptionSpecificationType(T: Ptr[CXType]): CInt = extern

  @name("__sn_wrap_clang_getExpansionLocation")
  private[libclang] def __sn_wrap_clang_getExpansionLocation(location: Ptr[CXSourceLocation], file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getFieldDeclBitWidth")
  private[libclang] def __sn_wrap_clang_getFieldDeclBitWidth(C: Ptr[CXCursor]): CInt = extern

  @name("__sn_wrap_clang_getFileLocation")
  private[libclang] def __sn_wrap_clang_getFileLocation(location: Ptr[CXSourceLocation], file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getFileName")
  private[libclang] def __sn_wrap_clang_getFileName(SFile: CXFile, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getFunctionTypeCallingConv")
  private[libclang] def __sn_wrap_clang_getFunctionTypeCallingConv(T: Ptr[CXType]): CXCallingConv = extern

  @name("__sn_wrap_clang_getIBOutletCollectionType")
  private[libclang] def __sn_wrap_clang_getIBOutletCollectionType(_0: Ptr[CXCursor], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getIncludedFile")
  private[libclang] def __sn_wrap_clang_getIncludedFile(cursor: Ptr[CXCursor]): CXFile = extern

  @name("__sn_wrap_clang_getInstantiationLocation")
  private[libclang] def __sn_wrap_clang_getInstantiationLocation(location: Ptr[CXSourceLocation], file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getLocation")
  private[libclang] def __sn_wrap_clang_getLocation(tu: CXTranslationUnit, file: CXFile, line: CUnsignedInt, column: CUnsignedInt, __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getLocationForOffset")
  private[libclang] def __sn_wrap_clang_getLocationForOffset(tu: CXTranslationUnit, file: CXFile, offset: CUnsignedInt, __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getNullCursor")
  private[libclang] def __sn_wrap_clang_getNullCursor(__return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getNullLocation")
  private[libclang] def __sn_wrap_clang_getNullLocation(__return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getNullRange")
  private[libclang] def __sn_wrap_clang_getNullRange(__return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_getNumArgTypes")
  private[libclang] def __sn_wrap_clang_getNumArgTypes(T: Ptr[CXType]): CInt = extern

  @name("__sn_wrap_clang_getNumElements")
  private[libclang] def __sn_wrap_clang_getNumElements(T: Ptr[CXType]): CLongLong = extern

  @name("__sn_wrap_clang_getNumOverloadedDecls")
  private[libclang] def __sn_wrap_clang_getNumOverloadedDecls(cursor: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_getOverloadedDecl")
  private[libclang] def __sn_wrap_clang_getOverloadedDecl(cursor: Ptr[CXCursor], index: CUnsignedInt, __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getOverriddenCursors")
  private[libclang] def __sn_wrap_clang_getOverriddenCursors(cursor: Ptr[CXCursor], overridden: Ptr[Ptr[CXCursor]], num_overridden: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getPointeeType")
  private[libclang] def __sn_wrap_clang_getPointeeType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getPresumedLocation")
  private[libclang] def __sn_wrap_clang_getPresumedLocation(location: Ptr[CXSourceLocation], filename: Ptr[CXString], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getRange")
  private[libclang] def __sn_wrap_clang_getRange(begin: Ptr[CXSourceLocation], end: Ptr[CXSourceLocation], __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_getRangeEnd")
  private[libclang] def __sn_wrap_clang_getRangeEnd(range: Ptr[CXSourceRange], __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getRangeStart")
  private[libclang] def __sn_wrap_clang_getRangeStart(range: Ptr[CXSourceRange], __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getResultType")
  private[libclang] def __sn_wrap_clang_getResultType(T: Ptr[CXType], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getSpecializedCursorTemplate")
  private[libclang] def __sn_wrap_clang_getSpecializedCursorTemplate(C: Ptr[CXCursor], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getSpellingLocation")
  private[libclang] def __sn_wrap_clang_getSpellingLocation(location: Ptr[CXSourceLocation], file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_getTemplateCursorKind")
  private[libclang] def __sn_wrap_clang_getTemplateCursorKind(C: Ptr[CXCursor]): CXCursorKind = extern

  @name("__sn_wrap_clang_getToken")
  private[libclang] def __sn_wrap_clang_getToken(TU: CXTranslationUnit, Location: Ptr[CXSourceLocation]): Ptr[CXToken] = extern

  @name("__sn_wrap_clang_getTokenExtent")
  private[libclang] def __sn_wrap_clang_getTokenExtent(_0: CXTranslationUnit, _1: Ptr[CXToken], __return: Ptr[CXSourceRange]): Unit = extern

  @name("__sn_wrap_clang_getTokenKind")
  private[libclang] def __sn_wrap_clang_getTokenKind(_0: Ptr[CXToken]): CXTokenKind = extern

  @name("__sn_wrap_clang_getTokenLocation")
  private[libclang] def __sn_wrap_clang_getTokenLocation(_0: CXTranslationUnit, _1: Ptr[CXToken], __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_getTokenSpelling")
  private[libclang] def __sn_wrap_clang_getTokenSpelling(_0: CXTranslationUnit, _1: Ptr[CXToken], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getTranslationUnitCursor")
  private[libclang] def __sn_wrap_clang_getTranslationUnitCursor(_0: CXTranslationUnit, __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getTranslationUnitSpelling")
  private[libclang] def __sn_wrap_clang_getTranslationUnitSpelling(CTUnit: CXTranslationUnit, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getTypeDeclaration")
  private[libclang] def __sn_wrap_clang_getTypeDeclaration(T: Ptr[CXType], __return: Ptr[CXCursor]): Unit = extern

  @name("__sn_wrap_clang_getTypeKindSpelling")
  private[libclang] def __sn_wrap_clang_getTypeKindSpelling(K: CXTypeKind, __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getTypeSpelling")
  private[libclang] def __sn_wrap_clang_getTypeSpelling(CT: Ptr[CXType], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_getTypedefDeclUnderlyingType")
  private[libclang] def __sn_wrap_clang_getTypedefDeclUnderlyingType(C: Ptr[CXCursor], __return: Ptr[CXType]): Unit = extern

  @name("__sn_wrap_clang_getTypedefName")
  private[libclang] def __sn_wrap_clang_getTypedefName(CT: Ptr[CXType], __return: Ptr[CXString]): Unit = extern

  @name("__sn_wrap_clang_hashCursor")
  private[libclang] def __sn_wrap_clang_hashCursor(_0: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_indexLoc_getCXSourceLocation")
  private[libclang] def __sn_wrap_clang_indexLoc_getCXSourceLocation(loc: Ptr[CXIdxLoc], __return: Ptr[CXSourceLocation]): Unit = extern

  @name("__sn_wrap_clang_indexLoc_getFileLocation")
  private[libclang] def __sn_wrap_clang_indexLoc_getFileLocation(loc: Ptr[CXIdxLoc], indexFile: Ptr[CXIdxClientFile], file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_isConstQualifiedType")
  private[libclang] def __sn_wrap_clang_isConstQualifiedType(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isCursorDefinition")
  private[libclang] def __sn_wrap_clang_isCursorDefinition(_0: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isFunctionTypeVariadic")
  private[libclang] def __sn_wrap_clang_isFunctionTypeVariadic(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isInvalidDeclaration")
  private[libclang] def __sn_wrap_clang_isInvalidDeclaration(_0: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isPODType")
  private[libclang] def __sn_wrap_clang_isPODType(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isRestrictQualifiedType")
  private[libclang] def __sn_wrap_clang_isRestrictQualifiedType(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isVirtualBase")
  private[libclang] def __sn_wrap_clang_isVirtualBase(_0: Ptr[CXCursor]): CUnsignedInt = extern

  @name("__sn_wrap_clang_isVolatileQualifiedType")
  private[libclang] def __sn_wrap_clang_isVolatileQualifiedType(T: Ptr[CXType]): CUnsignedInt = extern

  @name("__sn_wrap_clang_tokenize")
  private[libclang] def __sn_wrap_clang_tokenize(TU: CXTranslationUnit, Range: Ptr[CXSourceRange], Tokens: Ptr[Ptr[CXToken]], NumTokens: Ptr[CUnsignedInt]): Unit = extern

  @name("__sn_wrap_clang_visitChildren")
  private[libclang] def __sn_wrap_clang_visitChildren(parent: Ptr[CXCursor], visitor: CXCursorVisitor, client_data: CXClientData): CUnsignedInt = extern

  @name("__sn_wrap_clang_visitChildrenWithBlock")
  private[libclang] def __sn_wrap_clang_visitChildrenWithBlock(parent: Ptr[CXCursor], block: CXCursorVisitorBlock): CUnsignedInt = extern

  def asctime(_0: Ptr[tm]): CString = extern

  def asctime_r(_0: Ptr[tm], _1: CString): CString = extern

  def clang_CXIndex_getGlobalOptions(_0: CXIndex): CUnsignedInt = extern

  def clang_CXIndex_setGlobalOptions(_0: CXIndex, options: CUnsignedInt): Unit = extern

  def clang_CXIndex_setInvocationEmissionPathOption(_0: CXIndex, Path: CString): Unit = extern

  def clang_EvalResult_dispose(E: CXEvalResult): Unit = extern

  def clang_EvalResult_getAsDouble(E: CXEvalResult): Double = extern

  def clang_EvalResult_getAsInt(E: CXEvalResult): CInt = extern

  def clang_EvalResult_getAsLongLong(E: CXEvalResult): CLongLong = extern

  def clang_EvalResult_getAsStr(E: CXEvalResult): CString = extern

  def clang_EvalResult_getAsUnsigned(E: CXEvalResult): CUnsignedLongLong = extern

  def clang_EvalResult_getKind(E: CXEvalResult): CXEvalResultKind = extern

  def clang_EvalResult_isUnsignedInt(E: CXEvalResult): CUnsignedInt = extern

  def clang_File_isEqual(file1: CXFile, file2: CXFile): CInt = extern

  def clang_IndexAction_create(CIdx: CXIndex): CXIndexAction = extern

  def clang_IndexAction_dispose(_0: CXIndexAction): Unit = extern

  def clang_ModuleMapDescriptor_create(options: CUnsignedInt): CXModuleMapDescriptor = extern

  def clang_ModuleMapDescriptor_dispose(_0: CXModuleMapDescriptor): Unit = extern

  def clang_ModuleMapDescriptor_setFrameworkModuleName(_0: CXModuleMapDescriptor, name: CString): CXErrorCode = extern

  def clang_ModuleMapDescriptor_setUmbrellaHeader(_0: CXModuleMapDescriptor, name: CString): CXErrorCode = extern

  def clang_ModuleMapDescriptor_writeToBuffer(_0: CXModuleMapDescriptor, options: CUnsignedInt, out_buffer_ptr: Ptr[CString], out_buffer_size: Ptr[CUnsignedInt]): CXErrorCode = extern

  def clang_Module_getASTFile(Module: CXModule): CXFile = extern

  def clang_Module_getNumTopLevelHeaders(_0: CXTranslationUnit, Module: CXModule): CUnsignedInt = extern

  def clang_Module_getParent(Module: CXModule): CXModule = extern

  def clang_Module_getTopLevelHeader(_0: CXTranslationUnit, Module: CXModule, Index: CUnsignedInt): CXFile = extern

  def clang_Module_isSystem(Module: CXModule): CInt = extern

  def clang_PrintingPolicy_dispose(Policy: CXPrintingPolicy): Unit = extern

  def clang_PrintingPolicy_getProperty(Policy: CXPrintingPolicy, Property: CXPrintingPolicyProperty): CUnsignedInt = extern

  def clang_PrintingPolicy_setProperty(Policy: CXPrintingPolicy, Property: CXPrintingPolicyProperty, Value: CUnsignedInt): Unit = extern

  def clang_TargetInfo_dispose(Info: CXTargetInfo): Unit = extern

  def clang_TargetInfo_getPointerWidth(Info: CXTargetInfo): CInt = extern

  def clang_VirtualFileOverlay_addFileMapping(_0: CXVirtualFileOverlay, virtualPath: CString, realPath: CString): CXErrorCode = extern

  def clang_VirtualFileOverlay_create(options: CUnsignedInt): CXVirtualFileOverlay = extern

  def clang_VirtualFileOverlay_dispose(_0: CXVirtualFileOverlay): Unit = extern

  def clang_VirtualFileOverlay_setCaseSensitivity(_0: CXVirtualFileOverlay, caseSensitive: CInt): CXErrorCode = extern

  def clang_VirtualFileOverlay_writeToBuffer(_0: CXVirtualFileOverlay, options: CUnsignedInt, out_buffer_ptr: Ptr[CString], out_buffer_size: Ptr[CUnsignedInt]): CXErrorCode = extern

  def clang_annotateTokens(TU: CXTranslationUnit, Tokens: Ptr[CXToken], NumTokens: CUnsignedInt, Cursors: Ptr[CXCursor]): Unit = extern

  def clang_codeCompleteAt(TU: CXTranslationUnit, complete_filename: CString, complete_line: CUnsignedInt, complete_column: CUnsignedInt, unsaved_files: Ptr[CXUnsavedFile], num_unsaved_files: CUnsignedInt, options: CUnsignedInt): Ptr[CXCodeCompleteResults] = extern

  def clang_codeCompleteGetContainerKind(Results: Ptr[CXCodeCompleteResults], IsIncomplete: Ptr[CUnsignedInt]): CXCursorKind = extern

  def clang_codeCompleteGetContexts(Results: Ptr[CXCodeCompleteResults]): CUnsignedLongLong = extern

  def clang_codeCompleteGetDiagnostic(Results: Ptr[CXCodeCompleteResults], Index: CUnsignedInt): CXDiagnostic = extern

  def clang_codeCompleteGetNumDiagnostics(Results: Ptr[CXCodeCompleteResults]): CUnsignedInt = extern

  def clang_createCXCursorSet(): CXCursorSet = extern

  def clang_createIndex(excludeDeclarationsFromPCH: CInt, displayDiagnostics: CInt): CXIndex = extern

  def clang_createTranslationUnit(CIdx: CXIndex, ast_filename: CString): CXTranslationUnit = extern

  def clang_createTranslationUnit2(CIdx: CXIndex, ast_filename: CString, out_TU: Ptr[CXTranslationUnit]): CXErrorCode = extern

  def clang_createTranslationUnitFromSourceFile(CIdx: CXIndex, source_filename: CString, num_clang_command_line_args: CInt, clang_command_line_args: Ptr[CString], num_unsaved_files: CUnsignedInt, unsaved_files: Ptr[CXUnsavedFile]): CXTranslationUnit = extern

  def clang_defaultCodeCompleteOptions(): CUnsignedInt = extern

  def clang_defaultDiagnosticDisplayOptions(): CUnsignedInt = extern

  def clang_defaultEditingTranslationUnitOptions(): CUnsignedInt = extern

  def clang_defaultReparseOptions(TU: CXTranslationUnit): CUnsignedInt = extern

  def clang_defaultSaveOptions(TU: CXTranslationUnit): CUnsignedInt = extern

  def clang_disposeCXCursorSet(cset: CXCursorSet): Unit = extern

  def clang_disposeCXPlatformAvailability(availability: Ptr[CXPlatformAvailability]): Unit = extern

  def clang_disposeCodeCompleteResults(Results: Ptr[CXCodeCompleteResults]): Unit = extern

  def clang_disposeDiagnostic(Diagnostic: CXDiagnostic): Unit = extern

  def clang_disposeDiagnosticSet(Diags: CXDiagnosticSet): Unit = extern

  def clang_disposeIndex(index: CXIndex): Unit = extern

  def clang_disposeOverriddenCursors(overridden: Ptr[CXCursor]): Unit = extern

  def clang_disposeSourceRangeList(ranges: Ptr[CXSourceRangeList]): Unit = extern

  def clang_disposeStringSet(set: Ptr[CXStringSet]): Unit = extern

  def clang_disposeTokens(TU: CXTranslationUnit, Tokens: Ptr[CXToken], NumTokens: CUnsignedInt): Unit = extern

  def clang_disposeTranslationUnit(_0: CXTranslationUnit): Unit = extern

  def clang_enableStackTraces(): Unit = extern

  def clang_executeOnThread(fn: Ptr[CFuncPtr1[Ptr[Byte], Unit]], user_data: Ptr[Byte], stack_size: CUnsignedInt): Unit = extern

  def clang_findIncludesInFileWithBlock(_0: CXTranslationUnit, _1: CXFile, _2: CXCursorAndRangeVisitorBlock): CXResult = extern

  def clang_free(buffer: Ptr[Byte]): Unit = extern

  def clang_getAllSkippedRanges(tu: CXTranslationUnit): Ptr[CXSourceRangeList] = extern

  def clang_getBuildSessionTimestamp(): CUnsignedLongLong = extern

  def clang_getChildDiagnostics(D: CXDiagnostic): CXDiagnosticSet = extern

  def clang_getCompletionAvailability(completion_string: CXCompletionString): CXAvailabilityKind = extern

  def clang_getCompletionChunkCompletionString(completion_string: CXCompletionString, chunk_number: CUnsignedInt): CXCompletionString = extern

  def clang_getCompletionChunkKind(completion_string: CXCompletionString, chunk_number: CUnsignedInt): CXCompletionChunkKind = extern

  def clang_getCompletionNumAnnotations(completion_string: CXCompletionString): CUnsignedInt = extern

  def clang_getCompletionNumFixIts(results: Ptr[CXCodeCompleteResults], completion_index: CUnsignedInt): CUnsignedInt = extern

  def clang_getCompletionPriority(completion_string: CXCompletionString): CUnsignedInt = extern

  def clang_getDiagnostic(Unit: CXTranslationUnit, Index: CUnsignedInt): CXDiagnostic = extern

  def clang_getDiagnosticCategory(_0: CXDiagnostic): CUnsignedInt = extern

  def clang_getDiagnosticInSet(Diags: CXDiagnosticSet, Index: CUnsignedInt): CXDiagnostic = extern

  def clang_getDiagnosticNumFixIts(Diagnostic: CXDiagnostic): CUnsignedInt = extern

  def clang_getDiagnosticNumRanges(_0: CXDiagnostic): CUnsignedInt = extern

  def clang_getDiagnosticSetFromTU(Unit: CXTranslationUnit): CXDiagnosticSet = extern

  def clang_getDiagnosticSeverity(_0: CXDiagnostic): CXDiagnosticSeverity = extern

  def clang_getFile(tu: CXTranslationUnit, file_name: CString): CXFile = extern

  def clang_getFileContents(tu: CXTranslationUnit, file: CXFile, size: Ptr[size_t]): CString = extern

  def clang_getFileTime(SFile: CXFile): time_t = extern

  def clang_getFileUniqueID(file: CXFile, outID: Ptr[CXFileUniqueID]): CInt = extern

  def clang_getInclusions(tu: CXTranslationUnit, visitor: CXInclusionVisitor, client_data: CXClientData): Unit = extern

  def clang_getModuleForFile(_0: CXTranslationUnit, _1: CXFile): CXModule = extern

  def clang_getNumCompletionChunks(completion_string: CXCompletionString): CUnsignedInt = extern

  def clang_getNumDiagnostics(Unit: CXTranslationUnit): CUnsignedInt = extern

  def clang_getNumDiagnosticsInSet(Diags: CXDiagnosticSet): CUnsignedInt = extern

  def clang_getRemappings(path: CString): CXRemapping = extern

  def clang_getRemappingsFromFileList(filePaths: Ptr[CString], numFiles: CUnsignedInt): CXRemapping = extern

  def clang_getSkippedRanges(tu: CXTranslationUnit, file: CXFile): Ptr[CXSourceRangeList] = extern

  def clang_getTUResourceUsageName(kind: CXTUResourceUsageKind): CString = extern

  def clang_getTranslationUnitTargetInfo(CTUnit: CXTranslationUnit): CXTargetInfo = extern

  def clang_indexSourceFile(_0: CXIndexAction, client_data: CXClientData, index_callbacks: Ptr[IndexerCallbacks], index_callbacks_size: CUnsignedInt, index_options: CUnsignedInt, source_filename: CString, command_line_args: Ptr[CString], num_command_line_args: CInt, unsaved_files: Ptr[CXUnsavedFile], num_unsaved_files: CUnsignedInt, out_TU: Ptr[CXTranslationUnit], TU_options: CUnsignedInt): CInt = extern

  def clang_indexSourceFileFullArgv(_0: CXIndexAction, client_data: CXClientData, index_callbacks: Ptr[IndexerCallbacks], index_callbacks_size: CUnsignedInt, index_options: CUnsignedInt, source_filename: CString, command_line_args: Ptr[CString], num_command_line_args: CInt, unsaved_files: Ptr[CXUnsavedFile], num_unsaved_files: CUnsignedInt, out_TU: Ptr[CXTranslationUnit], TU_options: CUnsignedInt): CInt = extern

  def clang_indexTranslationUnit(_0: CXIndexAction, client_data: CXClientData, index_callbacks: Ptr[IndexerCallbacks], index_callbacks_size: CUnsignedInt, index_options: CUnsignedInt, _5: CXTranslationUnit): CInt = extern

  def clang_index_getCXXClassDeclInfo(_0: Ptr[CXIdxDeclInfo]): Ptr[CXIdxCXXClassDeclInfo] = extern

  def clang_index_getClientContainer(_0: Ptr[CXIdxContainerInfo]): CXIdxClientContainer = extern

  def clang_index_getClientEntity(_0: Ptr[CXIdxEntityInfo]): CXIdxClientEntity = extern

  def clang_index_getIBOutletCollectionAttrInfo(_0: Ptr[CXIdxAttrInfo]): Ptr[CXIdxIBOutletCollectionAttrInfo] = extern

  def clang_index_getObjCCategoryDeclInfo(_0: Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCCategoryDeclInfo] = extern

  def clang_index_getObjCContainerDeclInfo(_0: Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCContainerDeclInfo] = extern

  def clang_index_getObjCInterfaceDeclInfo(_0: Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCInterfaceDeclInfo] = extern

  def clang_index_getObjCPropertyDeclInfo(_0: Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCPropertyDeclInfo] = extern

  def clang_index_getObjCProtocolRefListInfo(_0: Ptr[CXIdxDeclInfo]): Ptr[CXIdxObjCProtocolRefListInfo] = extern

  def clang_index_isEntityObjCContainerKind(_0: CXIdxEntityKind): CInt = extern

  def clang_index_setClientContainer(_0: Ptr[CXIdxContainerInfo], _1: CXIdxClientContainer): Unit = extern

  def clang_index_setClientEntity(_0: Ptr[CXIdxEntityInfo], _1: CXIdxClientEntity): Unit = extern

  def clang_isAttribute(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isDeclaration(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isExpression(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isFileMultipleIncludeGuarded(tu: CXTranslationUnit, file: CXFile): CUnsignedInt = extern

  def clang_isInvalid(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isPreprocessing(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isReference(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isStatement(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isTranslationUnit(_0: CXCursorKind): CUnsignedInt = extern

  def clang_isUnexposed(_0: CXCursorKind): CUnsignedInt = extern

  def clang_loadDiagnostics(file: CString, error: Ptr[CXLoadDiag_Error], errorString: Ptr[CXString]): CXDiagnosticSet = extern

  def clang_parseTranslationUnit(CIdx: CXIndex, source_filename: CString, command_line_args: Ptr[CString], num_command_line_args: CInt, unsaved_files: Ptr[CXUnsavedFile], num_unsaved_files: CUnsignedInt, options: CUnsignedInt): CXTranslationUnit = extern

  def clang_parseTranslationUnit2(CIdx: CXIndex, source_filename: CString, command_line_args: Ptr[CString], num_command_line_args: CInt, unsaved_files: Ptr[CXUnsavedFile], num_unsaved_files: CUnsignedInt, options: CUnsignedInt, out_TU: Ptr[CXTranslationUnit]): CXErrorCode = extern

  def clang_parseTranslationUnit2FullArgv(CIdx: CXIndex, source_filename: CString, command_line_args: Ptr[CString], num_command_line_args: CInt, unsaved_files: Ptr[CXUnsavedFile], num_unsaved_files: CUnsignedInt, options: CUnsignedInt, out_TU: Ptr[CXTranslationUnit]): CXErrorCode = extern

  def clang_remap_dispose(_0: CXRemapping): Unit = extern

  def clang_remap_getFilenames(_0: CXRemapping, index: CUnsignedInt, original: Ptr[CXString], transformed: Ptr[CXString]): Unit = extern

  def clang_remap_getNumFiles(_0: CXRemapping): CUnsignedInt = extern

  def clang_reparseTranslationUnit(TU: CXTranslationUnit, num_unsaved_files: CUnsignedInt, unsaved_files: Ptr[CXUnsavedFile], options: CUnsignedInt): CInt = extern

  def clang_saveTranslationUnit(TU: CXTranslationUnit, FileName: CString, options: CUnsignedInt): CInt = extern

  def clang_sortCodeCompletionResults(Results: Ptr[CXCompletionResult], NumResults: CUnsignedInt): Unit = extern

  def clang_suspendTranslationUnit(_0: CXTranslationUnit): CUnsignedInt = extern

  def clang_toggleCrashRecovery(isEnabled: CUnsignedInt): Unit = extern

  def clock(): clock_t = extern

  def clock_getres(__clock_id: clockid_t, __res: Ptr[timespec]): CInt = extern

  def clock_gettime(__clock_id: clockid_t, __tp: Ptr[timespec]): CInt = extern

  def clock_gettime_nsec_np(__clock_id: clockid_t): __uint64_t = extern

  def clock_settime(__clock_id: clockid_t, __tp: Ptr[timespec]): CInt = extern

  def ctime(_0: Ptr[time_t]): CString = extern

  def ctime_r(_0: Ptr[time_t], _1: CString): CString = extern

  def difftime(_0: time_t, _1: time_t): Double = extern

  def getdate(_0: CString): Ptr[tm] = extern

  def gmtime(_0: Ptr[time_t]): Ptr[tm] = extern

  def gmtime_r(_0: Ptr[time_t], _1: Ptr[tm]): Ptr[tm] = extern

  def localtime(_0: Ptr[time_t]): Ptr[tm] = extern

  def localtime_r(_0: Ptr[time_t], _1: Ptr[tm]): Ptr[tm] = extern

  def mktime(_0: Ptr[tm]): time_t = extern

  def nanosleep(__rqtp: Ptr[timespec], __rmtp: Ptr[timespec]): CInt = extern

  def posix2time(_0: time_t): time_t = extern

  def strftime(_0: CString, _1: size_t, _2: CString, _3: Ptr[tm]): size_t = extern

  def strptime(_0: CString, _1: CString, _2: Ptr[tm]): CString = extern

  def time(_0: Ptr[time_t]): time_t = extern

  def time2posix(_0: time_t): time_t = extern

  def timegm(_0: Ptr[tm]): time_t = extern

  def timelocal(_0: Ptr[tm]): time_t = extern

  def timespec_get(ts: Ptr[timespec], base: CInt): CInt = extern

  def tzset(): Unit = extern

  def tzsetwall(): Unit = extern

object functions: 
  import types.*, extern_functions.*

  export extern_functions.*

  def clang_CXCursorSet_contains(cset: CXCursorSet, cursor: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_1 = alloc[CXCursor](1)
    !_ptr_1 = cursor
    __sn_wrap_clang_CXCursorSet_contains(cset, _ptr_1)

  def clang_CXCursorSet_insert(cset: CXCursorSet, cursor: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_1 = alloc[CXCursor](1)
    !_ptr_1 = cursor
    __sn_wrap_clang_CXCursorSet_insert(cset, _ptr_1)

  def clang_CXXConstructor_isConvertingConstructor(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXConstructor_isConvertingConstructor(_ptr_0)

  def clang_CXXConstructor_isCopyConstructor(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXConstructor_isCopyConstructor(_ptr_0)

  def clang_CXXConstructor_isDefaultConstructor(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXConstructor_isDefaultConstructor(_ptr_0)

  def clang_CXXConstructor_isMoveConstructor(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXConstructor_isMoveConstructor(_ptr_0)

  def clang_CXXField_isMutable(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXField_isMutable(_ptr_0)

  def clang_CXXMethod_isConst(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXMethod_isConst(_ptr_0)

  def clang_CXXMethod_isDefaulted(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXMethod_isDefaulted(_ptr_0)

  def clang_CXXMethod_isPureVirtual(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXMethod_isPureVirtual(_ptr_0)

  def clang_CXXMethod_isStatic(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXMethod_isStatic(_ptr_0)

  def clang_CXXMethod_isVirtual(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXMethod_isVirtual(_ptr_0)

  def clang_CXXRecord_isAbstract(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_CXXRecord_isAbstract(_ptr_0)

  def clang_Cursor_Evaluate(C: CXCursor)(using Zone): CXEvalResult = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_Evaluate(_ptr_0)

  def clang_Cursor_getArgument(C: CXCursor, i: CUnsignedInt)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_Cursor_getArgument(_ptr_0, i, _ptr_return)
    !_ptr_return

  def clang_Cursor_getBriefCommentText(C: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Cursor_getBriefCommentText(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getCXXManglings(_0: CXCursor)(using Zone): Ptr[CXStringSet] = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_Cursor_getCXXManglings(_ptr_0)

  def clang_Cursor_getCommentRange(C: CXCursor)(using Zone): CXSourceRange = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_Cursor_getCommentRange(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getMangling(_0: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Cursor_getMangling(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getModule(C: CXCursor)(using Zone): CXModule = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getModule(_ptr_0)

  def clang_Cursor_getNumArguments(C: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getNumArguments(_ptr_0)

  def clang_Cursor_getNumTemplateArguments(C: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getNumTemplateArguments(_ptr_0)

  def clang_Cursor_getObjCDeclQualifiers(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getObjCDeclQualifiers(_ptr_0)

  def clang_Cursor_getObjCManglings(_0: CXCursor)(using Zone): Ptr[CXStringSet] = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_Cursor_getObjCManglings(_ptr_0)

  def clang_Cursor_getObjCPropertyAttributes(C: CXCursor, reserved: CUnsignedInt)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getObjCPropertyAttributes(_ptr_0, reserved)

  def clang_Cursor_getObjCPropertyGetterName(C: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Cursor_getObjCPropertyGetterName(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getObjCPropertySetterName(C: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Cursor_getObjCPropertySetterName(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getObjCSelectorIndex(_0: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_Cursor_getObjCSelectorIndex(_ptr_0)

  def clang_Cursor_getOffsetOfField(C: CXCursor)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getOffsetOfField(_ptr_0)

  def clang_Cursor_getRawCommentText(C: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Cursor_getRawCommentText(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getReceiverType(C: CXCursor)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Cursor_getReceiverType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_getSpellingNameRange(_0: CXCursor, pieceIndex: CUnsignedInt, options: CUnsignedInt)(using Zone): CXSourceRange = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_Cursor_getSpellingNameRange(_ptr_0, pieceIndex, options, _ptr_return)
    !_ptr_return

  def clang_Cursor_getStorageClass(_0: CXCursor)(using Zone): CX_StorageClass = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_Cursor_getStorageClass(_ptr_0)

  def clang_Cursor_getTemplateArgumentKind(C: CXCursor, I: CUnsignedInt)(using Zone): CXTemplateArgumentKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getTemplateArgumentKind(_ptr_0, I)

  def clang_Cursor_getTemplateArgumentType(C: CXCursor, I: CUnsignedInt)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Cursor_getTemplateArgumentType(_ptr_0, I, _ptr_return)
    !_ptr_return

  def clang_Cursor_getTemplateArgumentUnsignedValue(C: CXCursor, I: CUnsignedInt)(using Zone): CUnsignedLongLong = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getTemplateArgumentUnsignedValue(_ptr_0, I)

  def clang_Cursor_getTemplateArgumentValue(C: CXCursor, I: CUnsignedInt)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_getTemplateArgumentValue(_ptr_0, I)

  def clang_Cursor_getTranslationUnit(_0: CXCursor)(using Zone): CXTranslationUnit = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_Cursor_getTranslationUnit(_ptr_0)

  def clang_Cursor_getVarDeclInitializer(cursor: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_Cursor_getVarDeclInitializer(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Cursor_hasAttrs(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_hasAttrs(_ptr_0)

  def clang_Cursor_hasVarDeclExternalStorage(cursor: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_Cursor_hasVarDeclExternalStorage(_ptr_0)

  def clang_Cursor_hasVarDeclGlobalStorage(cursor: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_Cursor_hasVarDeclGlobalStorage(_ptr_0)

  def clang_Cursor_isAnonymous(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isAnonymous(_ptr_0)

  def clang_Cursor_isAnonymousRecordDecl(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isAnonymousRecordDecl(_ptr_0)

  def clang_Cursor_isBitField(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isBitField(_ptr_0)

  def clang_Cursor_isDynamicCall(C: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isDynamicCall(_ptr_0)

  def clang_Cursor_isExternalSymbol(C: CXCursor, language: Ptr[CXString], definedIn: Ptr[CXString], isGenerated: Ptr[CUnsignedInt])(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isExternalSymbol(_ptr_0, language, definedIn, isGenerated)

  def clang_Cursor_isFunctionInlined(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isFunctionInlined(_ptr_0)

  def clang_Cursor_isInlineNamespace(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isInlineNamespace(_ptr_0)

  def clang_Cursor_isMacroBuiltin(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isMacroBuiltin(_ptr_0)

  def clang_Cursor_isMacroFunctionLike(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isMacroFunctionLike(_ptr_0)

  def clang_Cursor_isNull(cursor: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_Cursor_isNull(_ptr_0)

  def clang_Cursor_isObjCOptional(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isObjCOptional(_ptr_0)

  def clang_Cursor_isVariadic(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_Cursor_isVariadic(_ptr_0)

  def clang_EnumDecl_isScoped(C: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_EnumDecl_isScoped(_ptr_0)

  def clang_File_tryGetRealPathName(file: CXFile)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_File_tryGetRealPathName(file, _ptr_return)
    !_ptr_return

  def clang_Location_isFromMainFile(location: CXSourceLocation)(using Zone): CInt = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_Location_isFromMainFile(_ptr_0)

  def clang_Location_isInSystemHeader(location: CXSourceLocation)(using Zone): CInt = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_Location_isInSystemHeader(_ptr_0)

  def clang_Module_getFullName(Module: CXModule)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Module_getFullName(Module, _ptr_return)
    !_ptr_return

  def clang_Module_getName(Module: CXModule)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Module_getName(Module, _ptr_return)
    !_ptr_return

  def clang_Range_isNull(range: CXSourceRange)(using Zone): CInt = 
    val _ptr_0 = alloc[CXSourceRange](1)
    !_ptr_0 = range
    __sn_wrap_clang_Range_isNull(_ptr_0)

  def clang_TargetInfo_getTriple(Info: CXTargetInfo)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_TargetInfo_getTriple(Info, _ptr_return)
    !_ptr_return

  def clang_Type_getAlignOf(T: CXType)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getAlignOf(_ptr_0)

  def clang_Type_getCXXRefQualifier(T: CXType)(using Zone): CXRefQualifierKind = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getCXXRefQualifier(_ptr_0)

  def clang_Type_getClassType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getClassType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Type_getModifiedType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getModifiedType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Type_getNamedType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getNamedType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Type_getNullability(T: CXType)(using Zone): CXTypeNullabilityKind = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getNullability(_ptr_0)

  def clang_Type_getNumObjCProtocolRefs(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getNumObjCProtocolRefs(_ptr_0)

  def clang_Type_getNumObjCTypeArgs(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getNumObjCTypeArgs(_ptr_0)

  def clang_Type_getNumTemplateArguments(T: CXType)(using Zone): CInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getNumTemplateArguments(_ptr_0)

  def clang_Type_getObjCEncoding(`type`: CXType)(using Zone): CXString = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = `type`
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_Type_getObjCEncoding(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Type_getObjCObjectBaseType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getObjCObjectBaseType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Type_getObjCProtocolDecl(T: CXType, i: CUnsignedInt)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_Type_getObjCProtocolDecl(_ptr_0, i, _ptr_return)
    !_ptr_return

  def clang_Type_getObjCTypeArg(T: CXType, i: CUnsignedInt)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getObjCTypeArg(_ptr_0, i, _ptr_return)
    !_ptr_return

  def clang_Type_getOffsetOf(T: CXType, S: CString)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getOffsetOf(_ptr_0, S)

  def clang_Type_getSizeOf(T: CXType)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_getSizeOf(_ptr_0)

  def clang_Type_getTemplateArgumentAsType(T: CXType, i: CUnsignedInt)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getTemplateArgumentAsType(_ptr_0, i, _ptr_return)
    !_ptr_return

  def clang_Type_getValueType(CT: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = CT
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_Type_getValueType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_Type_isTransparentTagTypedef(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_isTransparentTagTypedef(_ptr_0)

  def clang_Type_visitFields(T: CXType, visitor: CXFieldVisitor, client_data: CXClientData)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_Type_visitFields(_ptr_0, visitor, client_data)

  def clang_codeCompleteGetContainerUSR(Results: Ptr[CXCodeCompleteResults])(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_codeCompleteGetContainerUSR(Results, _ptr_return)
    !_ptr_return

  def clang_codeCompleteGetObjCSelector(Results: Ptr[CXCodeCompleteResults])(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_codeCompleteGetObjCSelector(Results, _ptr_return)
    !_ptr_return

  def clang_constructUSR_ObjCCategory(class_name: CString, category_name: CString)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_constructUSR_ObjCCategory(class_name, category_name, _ptr_return)
    !_ptr_return

  def clang_constructUSR_ObjCClass(class_name: CString)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_constructUSR_ObjCClass(class_name, _ptr_return)
    !_ptr_return

  def clang_constructUSR_ObjCIvar(name: CString, classUSR: CXString)(using Zone): CXString = 
    val _ptr_1 = alloc[CXString](1)
    !_ptr_1 = classUSR
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_constructUSR_ObjCIvar(name, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_constructUSR_ObjCMethod(name: CString, isInstanceMethod: CUnsignedInt, classUSR: CXString)(using Zone): CXString = 
    val _ptr_2 = alloc[CXString](1)
    !_ptr_2 = classUSR
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_constructUSR_ObjCMethod(name, isInstanceMethod, _ptr_2, _ptr_return)
    !_ptr_return

  def clang_constructUSR_ObjCProperty(property: CString, classUSR: CXString)(using Zone): CXString = 
    val _ptr_1 = alloc[CXString](1)
    !_ptr_1 = classUSR
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_constructUSR_ObjCProperty(property, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_constructUSR_ObjCProtocol(protocol_name: CString)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_constructUSR_ObjCProtocol(protocol_name, _ptr_return)
    !_ptr_return

  def clang_disposeCXTUResourceUsage(usage: CXTUResourceUsage)(using Zone): Unit = 
    val _ptr_0 = alloc[CXTUResourceUsage](1)
    !_ptr_0 = usage
    __sn_wrap_clang_disposeCXTUResourceUsage(_ptr_0)

  def clang_disposeString(string: CXString)(using Zone): Unit = 
    val _ptr_0 = alloc[CXString](1)
    !_ptr_0 = string
    __sn_wrap_clang_disposeString(_ptr_0)

  def clang_equalCursors(_0: CXCursor, _1: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_1 = alloc[CXCursor](1)
    !_ptr_1 = _1
    __sn_wrap_clang_equalCursors(_ptr_0, _ptr_1)

  def clang_equalLocations(loc1: CXSourceLocation, loc2: CXSourceLocation)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = loc1
    val _ptr_1 = alloc[CXSourceLocation](1)
    !_ptr_1 = loc2
    __sn_wrap_clang_equalLocations(_ptr_0, _ptr_1)

  def clang_equalRanges(range1: CXSourceRange, range2: CXSourceRange)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXSourceRange](1)
    !_ptr_0 = range1
    val _ptr_1 = alloc[CXSourceRange](1)
    !_ptr_1 = range2
    __sn_wrap_clang_equalRanges(_ptr_0, _ptr_1)

  def clang_equalTypes(A: CXType, B: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = A
    val _ptr_1 = alloc[CXType](1)
    !_ptr_1 = B
    __sn_wrap_clang_equalTypes(_ptr_0, _ptr_1)

  def clang_findIncludesInFile(TU: CXTranslationUnit, file: CXFile, visitor: CXCursorAndRangeVisitor)(using Zone): CXResult = 
    val _ptr_2 = alloc[CXCursorAndRangeVisitor](1)
    !_ptr_2 = visitor
    __sn_wrap_clang_findIncludesInFile(TU, file, _ptr_2)

  def clang_findReferencesInFile(cursor: CXCursor, file: CXFile, visitor: CXCursorAndRangeVisitor)(using Zone): CXResult = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    val _ptr_2 = alloc[CXCursorAndRangeVisitor](1)
    !_ptr_2 = visitor
    __sn_wrap_clang_findReferencesInFile(_ptr_0, file, _ptr_2)

  def clang_findReferencesInFileWithBlock(_0: CXCursor, _1: CXFile, _2: CXCursorAndRangeVisitorBlock)(using Zone): CXResult = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_findReferencesInFileWithBlock(_ptr_0, _1, _2)

  def clang_formatDiagnostic(Diagnostic: CXDiagnostic, Options: CUnsignedInt)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_formatDiagnostic(Diagnostic, Options, _ptr_return)
    !_ptr_return

  def clang_getAddressSpace(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_getAddressSpace(_ptr_0)

  def clang_getArgType(T: CXType, i: CUnsignedInt)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getArgType(_ptr_0, i, _ptr_return)
    !_ptr_return

  def clang_getArrayElementType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getArrayElementType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getArraySize(T: CXType)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_getArraySize(_ptr_0)

  def clang_getCString(string: CXString)(using Zone): CString = 
    val _ptr_0 = alloc[CXString](1)
    !_ptr_0 = string
    __sn_wrap_clang_getCString(_ptr_0)

  def clang_getCXTUResourceUsage(TU: CXTranslationUnit)(using Zone): CXTUResourceUsage = 
    val _ptr_return = alloc[CXTUResourceUsage](1)
    __sn_wrap_clang_getCXTUResourceUsage(TU, _ptr_return)
    !_ptr_return

  def clang_getCXXAccessSpecifier(_0: CXCursor)(using Zone): CX_CXXAccessSpecifier = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_getCXXAccessSpecifier(_ptr_0)

  def clang_getCanonicalCursor(_0: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getCanonicalCursor(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCanonicalType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getCanonicalType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getClangVersion()(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getClangVersion(_ptr_return)
    !_ptr_return

  def clang_getCompletionAnnotation(completion_string: CXCompletionString, annotation_number: CUnsignedInt)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCompletionAnnotation(completion_string, annotation_number, _ptr_return)
    !_ptr_return

  def clang_getCompletionBriefComment(completion_string: CXCompletionString)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCompletionBriefComment(completion_string, _ptr_return)
    !_ptr_return

  def clang_getCompletionChunkText(completion_string: CXCompletionString, chunk_number: CUnsignedInt)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCompletionChunkText(completion_string, chunk_number, _ptr_return)
    !_ptr_return

  def clang_getCompletionFixIt(results: Ptr[CXCodeCompleteResults], completion_index: CUnsignedInt, fixit_index: CUnsignedInt, replacement_range: Ptr[CXSourceRange])(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCompletionFixIt(results, completion_index, fixit_index, replacement_range, _ptr_return)
    !_ptr_return

  def clang_getCompletionParent(completion_string: CXCompletionString, kind: Ptr[CXCursorKind])(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCompletionParent(completion_string, kind, _ptr_return)
    !_ptr_return

  def clang_getCursor(_0: CXTranslationUnit, _1: CXSourceLocation)(using Zone): CXCursor = 
    val _ptr_1 = alloc[CXSourceLocation](1)
    !_ptr_1 = _1
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getCursor(_0, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_getCursorAvailability(cursor: CXCursor)(using Zone): CXAvailabilityKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorAvailability(_ptr_0)

  def clang_getCursorCompletionString(cursor: CXCursor)(using Zone): CXCompletionString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorCompletionString(_ptr_0)

  def clang_getCursorDefinition(_0: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getCursorDefinition(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorDisplayName(_0: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCursorDisplayName(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorExceptionSpecificationType(C: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_getCursorExceptionSpecificationType(_ptr_0)

  def clang_getCursorExtent(_0: CXCursor)(using Zone): CXSourceRange = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_getCursorExtent(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorKind(_0: CXCursor)(using Zone): CXCursorKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_getCursorKind(_ptr_0)

  def clang_getCursorKindSpelling(Kind: CXCursorKind)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCursorKindSpelling(Kind, _ptr_return)
    !_ptr_return

  def clang_getCursorLanguage(cursor: CXCursor)(using Zone): CXLanguageKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorLanguage(_ptr_0)

  def clang_getCursorLexicalParent(cursor: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getCursorLexicalParent(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorLinkage(cursor: CXCursor)(using Zone): CXLinkageKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorLinkage(_ptr_0)

  def clang_getCursorLocation(_0: CXCursor)(using Zone): CXSourceLocation = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getCursorLocation(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorPlatformAvailability(cursor: CXCursor, always_deprecated: Ptr[CInt], deprecated_message: Ptr[CXString], always_unavailable: Ptr[CInt], unavailable_message: Ptr[CXString], availability: Ptr[CXPlatformAvailability], availability_size: CInt)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorPlatformAvailability(_ptr_0, always_deprecated, deprecated_message, always_unavailable, unavailable_message, availability, availability_size)

  def clang_getCursorPrettyPrinted(Cursor: CXCursor, Policy: CXPrintingPolicy)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = Cursor
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCursorPrettyPrinted(_ptr_0, Policy, _ptr_return)
    !_ptr_return

  def clang_getCursorPrintingPolicy(_0: CXCursor)(using Zone): CXPrintingPolicy = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_getCursorPrintingPolicy(_ptr_0)

  def clang_getCursorReferenceNameRange(C: CXCursor, NameFlags: CUnsignedInt, PieceIndex: CUnsignedInt)(using Zone): CXSourceRange = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_getCursorReferenceNameRange(_ptr_0, NameFlags, PieceIndex, _ptr_return)
    !_ptr_return

  def clang_getCursorReferenced(_0: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getCursorReferenced(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorResultType(C: CXCursor)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getCursorResultType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorSemanticParent(cursor: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getCursorSemanticParent(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorSpelling(_0: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCursorSpelling(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorTLSKind(cursor: CXCursor)(using Zone): CXTLSKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorTLSKind(_ptr_0)

  def clang_getCursorType(C: CXCursor)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getCursorType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorUSR(_0: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getCursorUSR(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getCursorVisibility(cursor: CXCursor)(using Zone): CXVisibilityKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getCursorVisibility(_ptr_0)

  def clang_getDeclObjCTypeEncoding(C: CXCursor)(using Zone): CXString = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getDeclObjCTypeEncoding(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getDefinitionSpellingAndExtent(_0: CXCursor, startBuf: Ptr[CString], endBuf: Ptr[CString], startLine: Ptr[CUnsignedInt], startColumn: Ptr[CUnsignedInt], endLine: Ptr[CUnsignedInt], endColumn: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_getDefinitionSpellingAndExtent(_ptr_0, startBuf, endBuf, startLine, startColumn, endLine, endColumn)

  def clang_getDiagnosticCategoryName(Category: CUnsignedInt)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getDiagnosticCategoryName(Category, _ptr_return)
    !_ptr_return

  def clang_getDiagnosticCategoryText(_0: CXDiagnostic)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getDiagnosticCategoryText(_0, _ptr_return)
    !_ptr_return

  def clang_getDiagnosticFixIt(Diagnostic: CXDiagnostic, FixIt: CUnsignedInt, ReplacementRange: Ptr[CXSourceRange])(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getDiagnosticFixIt(Diagnostic, FixIt, ReplacementRange, _ptr_return)
    !_ptr_return

  def clang_getDiagnosticLocation(_0: CXDiagnostic)(using Zone): CXSourceLocation = 
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getDiagnosticLocation(_0, _ptr_return)
    !_ptr_return

  def clang_getDiagnosticOption(Diag: CXDiagnostic, Disable: Ptr[CXString])(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getDiagnosticOption(Diag, Disable, _ptr_return)
    !_ptr_return

  def clang_getDiagnosticRange(Diagnostic: CXDiagnostic, Range: CUnsignedInt)(using Zone): CXSourceRange = 
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_getDiagnosticRange(Diagnostic, Range, _ptr_return)
    !_ptr_return

  def clang_getDiagnosticSpelling(_0: CXDiagnostic)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getDiagnosticSpelling(_0, _ptr_return)
    !_ptr_return

  def clang_getElementType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getElementType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getEnumConstantDeclUnsignedValue(C: CXCursor)(using Zone): CUnsignedLongLong = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_getEnumConstantDeclUnsignedValue(_ptr_0)

  def clang_getEnumConstantDeclValue(C: CXCursor)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_getEnumConstantDeclValue(_ptr_0)

  def clang_getEnumDeclIntegerType(C: CXCursor)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getEnumDeclIntegerType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getExceptionSpecificationType(T: CXType)(using Zone): CInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_getExceptionSpecificationType(_ptr_0)

  def clang_getExpansionLocation(location: CXSourceLocation, file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_getExpansionLocation(_ptr_0, file, line, column, offset)

  def clang_getFieldDeclBitWidth(C: CXCursor)(using Zone): CInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_getFieldDeclBitWidth(_ptr_0)

  def clang_getFileLocation(location: CXSourceLocation, file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_getFileLocation(_ptr_0, file, line, column, offset)

  def clang_getFileName(SFile: CXFile)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getFileName(SFile, _ptr_return)
    !_ptr_return

  def clang_getFunctionTypeCallingConv(T: CXType)(using Zone): CXCallingConv = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_getFunctionTypeCallingConv(_ptr_0)

  def clang_getIBOutletCollectionType(_0: CXCursor)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getIBOutletCollectionType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getIncludedFile(cursor: CXCursor)(using Zone): CXFile = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getIncludedFile(_ptr_0)

  def clang_getInstantiationLocation(location: CXSourceLocation, file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_getInstantiationLocation(_ptr_0, file, line, column, offset)

  def clang_getLocation(tu: CXTranslationUnit, file: CXFile, line: CUnsignedInt, column: CUnsignedInt)(using Zone): CXSourceLocation = 
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getLocation(tu, file, line, column, _ptr_return)
    !_ptr_return

  def clang_getLocationForOffset(tu: CXTranslationUnit, file: CXFile, offset: CUnsignedInt)(using Zone): CXSourceLocation = 
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getLocationForOffset(tu, file, offset, _ptr_return)
    !_ptr_return

  def clang_getNullCursor()(using Zone): CXCursor = 
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getNullCursor(_ptr_return)
    !_ptr_return

  def clang_getNullLocation()(using Zone): CXSourceLocation = 
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getNullLocation(_ptr_return)
    !_ptr_return

  def clang_getNullRange()(using Zone): CXSourceRange = 
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_getNullRange(_ptr_return)
    !_ptr_return

  def clang_getNumArgTypes(T: CXType)(using Zone): CInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_getNumArgTypes(_ptr_0)

  def clang_getNumElements(T: CXType)(using Zone): CLongLong = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_getNumElements(_ptr_0)

  def clang_getNumOverloadedDecls(cursor: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getNumOverloadedDecls(_ptr_0)

  def clang_getOverloadedDecl(cursor: CXCursor, index: CUnsignedInt)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getOverloadedDecl(_ptr_0, index, _ptr_return)
    !_ptr_return

  def clang_getOverriddenCursors(cursor: CXCursor, overridden: Ptr[Ptr[CXCursor]], num_overridden: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = cursor
    __sn_wrap_clang_getOverriddenCursors(_ptr_0, overridden, num_overridden)

  def clang_getPointeeType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getPointeeType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getPresumedLocation(location: CXSourceLocation, filename: Ptr[CXString], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_getPresumedLocation(_ptr_0, filename, line, column)

  def clang_getRange(begin: CXSourceLocation, end: CXSourceLocation)(using Zone): CXSourceRange = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = begin
    val _ptr_1 = alloc[CXSourceLocation](1)
    !_ptr_1 = end
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_getRange(_ptr_0, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_getRangeEnd(range: CXSourceRange)(using Zone): CXSourceLocation = 
    val _ptr_0 = alloc[CXSourceRange](1)
    !_ptr_0 = range
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getRangeEnd(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getRangeStart(range: CXSourceRange)(using Zone): CXSourceLocation = 
    val _ptr_0 = alloc[CXSourceRange](1)
    !_ptr_0 = range
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getRangeStart(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getResultType(T: CXType)(using Zone): CXType = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getResultType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getSpecializedCursorTemplate(C: CXCursor)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getSpecializedCursorTemplate(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getSpellingLocation(location: CXSourceLocation, file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXSourceLocation](1)
    !_ptr_0 = location
    __sn_wrap_clang_getSpellingLocation(_ptr_0, file, line, column, offset)

  def clang_getTemplateCursorKind(C: CXCursor)(using Zone): CXCursorKind = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    __sn_wrap_clang_getTemplateCursorKind(_ptr_0)

  def clang_getToken(TU: CXTranslationUnit, Location: CXSourceLocation)(using Zone): Ptr[CXToken] = 
    val _ptr_1 = alloc[CXSourceLocation](1)
    !_ptr_1 = Location
    __sn_wrap_clang_getToken(TU, _ptr_1)

  def clang_getTokenExtent(_0: CXTranslationUnit, _1: CXToken)(using Zone): CXSourceRange = 
    val _ptr_1 = alloc[CXToken](1)
    !_ptr_1 = _1
    val _ptr_return = alloc[CXSourceRange](1)
    __sn_wrap_clang_getTokenExtent(_0, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_getTokenKind(_0: CXToken)(using Zone): CXTokenKind = 
    val _ptr_0 = alloc[CXToken](1)
    !_ptr_0 = _0
    __sn_wrap_clang_getTokenKind(_ptr_0)

  def clang_getTokenLocation(_0: CXTranslationUnit, _1: CXToken)(using Zone): CXSourceLocation = 
    val _ptr_1 = alloc[CXToken](1)
    !_ptr_1 = _1
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_getTokenLocation(_0, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_getTokenSpelling(_0: CXTranslationUnit, _1: CXToken)(using Zone): CXString = 
    val _ptr_1 = alloc[CXToken](1)
    !_ptr_1 = _1
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getTokenSpelling(_0, _ptr_1, _ptr_return)
    !_ptr_return

  def clang_getTranslationUnitCursor(_0: CXTranslationUnit)(using Zone): CXCursor = 
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getTranslationUnitCursor(_0, _ptr_return)
    !_ptr_return

  def clang_getTranslationUnitSpelling(CTUnit: CXTranslationUnit)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getTranslationUnitSpelling(CTUnit, _ptr_return)
    !_ptr_return

  def clang_getTypeDeclaration(T: CXType)(using Zone): CXCursor = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    val _ptr_return = alloc[CXCursor](1)
    __sn_wrap_clang_getTypeDeclaration(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getTypeKindSpelling(K: CXTypeKind)(using Zone): CXString = 
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getTypeKindSpelling(K, _ptr_return)
    !_ptr_return

  def clang_getTypeSpelling(CT: CXType)(using Zone): CXString = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = CT
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getTypeSpelling(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getTypedefDeclUnderlyingType(C: CXCursor)(using Zone): CXType = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = C
    val _ptr_return = alloc[CXType](1)
    __sn_wrap_clang_getTypedefDeclUnderlyingType(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_getTypedefName(CT: CXType)(using Zone): CXString = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = CT
    val _ptr_return = alloc[CXString](1)
    __sn_wrap_clang_getTypedefName(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_hashCursor(_0: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_hashCursor(_ptr_0)

  def clang_indexLoc_getCXSourceLocation(loc: CXIdxLoc)(using Zone): CXSourceLocation = 
    val _ptr_0 = alloc[CXIdxLoc](1)
    !_ptr_0 = loc
    val _ptr_return = alloc[CXSourceLocation](1)
    __sn_wrap_clang_indexLoc_getCXSourceLocation(_ptr_0, _ptr_return)
    !_ptr_return

  def clang_indexLoc_getFileLocation(loc: CXIdxLoc, indexFile: Ptr[CXIdxClientFile], file: Ptr[CXFile], line: Ptr[CUnsignedInt], column: Ptr[CUnsignedInt], offset: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_0 = alloc[CXIdxLoc](1)
    !_ptr_0 = loc
    __sn_wrap_clang_indexLoc_getFileLocation(_ptr_0, indexFile, file, line, column, offset)

  def clang_isConstQualifiedType(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_isConstQualifiedType(_ptr_0)

  def clang_isCursorDefinition(_0: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_isCursorDefinition(_ptr_0)

  def clang_isFunctionTypeVariadic(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_isFunctionTypeVariadic(_ptr_0)

  def clang_isInvalidDeclaration(_0: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_isInvalidDeclaration(_ptr_0)

  def clang_isPODType(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_isPODType(_ptr_0)

  def clang_isRestrictQualifiedType(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_isRestrictQualifiedType(_ptr_0)

  def clang_isVirtualBase(_0: CXCursor)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = _0
    __sn_wrap_clang_isVirtualBase(_ptr_0)

  def clang_isVolatileQualifiedType(T: CXType)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXType](1)
    !_ptr_0 = T
    __sn_wrap_clang_isVolatileQualifiedType(_ptr_0)

  def clang_tokenize(TU: CXTranslationUnit, Range: CXSourceRange, Tokens: Ptr[Ptr[CXToken]], NumTokens: Ptr[CUnsignedInt])(using Zone): Unit = 
    val _ptr_1 = alloc[CXSourceRange](1)
    !_ptr_1 = Range
    __sn_wrap_clang_tokenize(TU, _ptr_1, Tokens, NumTokens)

  def clang_visitChildren(parent: CXCursor, visitor: CXCursorVisitor, client_data: CXClientData)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = parent
    __sn_wrap_clang_visitChildren(_ptr_0, visitor, client_data)

  def clang_visitChildrenWithBlock(parent: CXCursor, block: CXCursorVisitorBlock)(using Zone): CUnsignedInt = 
    val _ptr_0 = alloc[CXCursor](1)
    !_ptr_0 = parent
    __sn_wrap_clang_visitChildrenWithBlock(_ptr_0, block)














































































































































































































