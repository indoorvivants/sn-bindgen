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

  opaque type CXErrorCode = CInt
  object CXErrorCode extends CEnum[CXErrorCode]:
    inline def define(inline a: CInt): CXErrorCode = a

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

  opaque type CXIndex = Ptr[CInt]
  object CXIndex: 
    given _tag: Tag[CXIndex] = Tag.Ptr[CInt](Tag.Int)
    inline def apply(inline o: Ptr[CInt]): CXIndex = o

  opaque type CXIndexAction = Ptr[Byte]
  object CXIndexAction: 
    given _tag: Tag[CXIndexAction] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXIndexAction = o

  opaque type CXModule = Ptr[Byte]
  object CXModule: 
    given _tag: Tag[CXModule] = Tag.Ptr(Tag.Byte)
    inline def apply(inline o: Ptr[Byte]): CXModule = o

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
    extension (struct: CXCodeCompleteResults)
      def Results: Ptr[CXCompletionResult] = struct._1
      def Results_=(value: Ptr[CXCompletionResult]): Unit = !struct.at1 = value
      def NumResults: CUnsignedInt = struct._2
      def NumResults_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXCompletionResult = CStruct2[CXCursorKind, CXCompletionString]
  object CXCompletionResult:
    given _tag: Tag[CXCompletionResult] = Tag.materializeCStruct2Tag[CXCursorKind, CXCompletionString]
    extension (struct: CXCompletionResult)
      def CursorKind: CXCursorKind = struct._1
      def CursorKind_=(value: CXCursorKind): Unit = !struct.at1 = value
      def CompletionString: CXCompletionString = struct._2
      def CompletionString_=(value: CXCompletionString): Unit = !struct.at2 = value

  opaque type CXCursor = CStruct3[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
  object CXCursor:
    given _tag: Tag[CXCursor] = Tag.materializeCStruct3Tag[CXCursorKind, CInt, CArray[Ptr[Byte], Nat._3]]
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
    extension (struct: CXFileUniqueID)
      def data: CArray[CUnsignedLongLong, Nat._3] = struct._1
      def data_=(value: CArray[CUnsignedLongLong, Nat._3]): Unit = !struct.at1 = value

  opaque type CXIdxAttrInfo = CStruct3[CXIdxAttrKind, CXCursor, CXIdxLoc]
  object CXIdxAttrInfo:
    given _tag: Tag[CXIdxAttrInfo] = Tag.materializeCStruct3Tag[CXIdxAttrKind, CXCursor, CXIdxLoc]
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
    extension (struct: CXIdxContainerInfo)
      def cursor: CXCursor = struct._1
      def cursor_=(value: CXCursor): Unit = !struct.at1 = value

  opaque type CXIdxDeclInfo = CStruct13[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxContainerInfo], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[CXIdxContainerInfo], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]
  object CXIdxDeclInfo:
    given _tag: Tag[CXIdxDeclInfo] = Tag.materializeCStruct13Tag[Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxContainerInfo], Ptr[CXIdxContainerInfo], CInt, CInt, CInt, Ptr[CXIdxContainerInfo], CInt, Ptr[Ptr[CXIdxAttrInfo]], CUnsignedInt, CUnsignedInt]
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
    extension (struct: CXIdxLoc)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
      def int_data: CUnsignedInt = struct._2
      def int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXIdxObjCCategoryDeclInfo = CStruct5[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]
  object CXIdxObjCCategoryDeclInfo:
    given _tag: Tag[CXIdxObjCCategoryDeclInfo] = Tag.materializeCStruct5Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxEntityInfo], CXCursor, CXIdxLoc, Ptr[CXIdxObjCProtocolRefListInfo]]
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
    extension (struct: CXIdxObjCContainerDeclInfo)
      def declInfo: Ptr[CXIdxDeclInfo] = struct._1
      def declInfo_=(value: Ptr[CXIdxDeclInfo]): Unit = !struct.at1 = value
      def kind: CXIdxObjCContainerKind = struct._2
      def kind_=(value: CXIdxObjCContainerKind): Unit = !struct.at2 = value

  opaque type CXIdxObjCInterfaceDeclInfo = CStruct3[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]
  object CXIdxObjCInterfaceDeclInfo:
    given _tag: Tag[CXIdxObjCInterfaceDeclInfo] = Tag.materializeCStruct3Tag[Ptr[CXIdxObjCContainerDeclInfo], Ptr[CXIdxBaseClassInfo], Ptr[CXIdxObjCProtocolRefListInfo]]
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
    extension (struct: CXIdxObjCProtocolRefListInfo)
      def protocols: Ptr[Ptr[CXIdxObjCProtocolRefInfo]] = struct._1
      def protocols_=(value: Ptr[Ptr[CXIdxObjCProtocolRefInfo]]): Unit = !struct.at1 = value
      def numProtocols: CUnsignedInt = struct._2
      def numProtocols_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXPlatformAvailability = CStruct6[CInt, CXVersion, CXVersion, CXVersion, CInt, CInt]
  object CXPlatformAvailability:
    given _tag: Tag[CXPlatformAvailability] = Tag.materializeCStruct6Tag[CInt, CXVersion, CXVersion, CXVersion, CInt, CInt]
    extension (struct: CXPlatformAvailability)
      def Platform: CInt = struct._1
      def Platform_=(value: CInt): Unit = !struct.at1 = value
      def Introduced: CXVersion = struct._2
      def Introduced_=(value: CXVersion): Unit = !struct.at2 = value
      def Deprecated: CXVersion = struct._3
      def Deprecated_=(value: CXVersion): Unit = !struct.at3 = value
      def Obsoleted: CXVersion = struct._4
      def Obsoleted_=(value: CXVersion): Unit = !struct.at4 = value
      def Unavailable: CInt = struct._5
      def Unavailable_=(value: CInt): Unit = !struct.at5 = value
      def Message: CInt = struct._6
      def Message_=(value: CInt): Unit = !struct.at6 = value

  opaque type CXSourceLocation = CStruct2[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
  object CXSourceLocation:
    given _tag: Tag[CXSourceLocation] = Tag.materializeCStruct2Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt]
    extension (struct: CXSourceLocation)
      def ptr_data: CArray[Ptr[Byte], Nat._2] = struct._1
      def ptr_data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at1 = value
      def int_data: CUnsignedInt = struct._2
      def int_data_=(value: CUnsignedInt): Unit = !struct.at2 = value

  opaque type CXSourceRange = CStruct3[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]
  object CXSourceRange:
    given _tag: Tag[CXSourceRange] = Tag.materializeCStruct3Tag[CArray[Ptr[Byte], Nat._2], CUnsignedInt, CUnsignedInt]
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
    extension (struct: CXSourceRangeList)
      def count: CUnsignedInt = struct._1
      def count_=(value: CUnsignedInt): Unit = !struct.at1 = value
      def ranges: Ptr[CXSourceRange] = struct._2
      def ranges_=(value: Ptr[CXSourceRange]): Unit = !struct.at2 = value

  opaque type CXTUResourceUsage = CStruct3[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]
  object CXTUResourceUsage:
    given _tag: Tag[CXTUResourceUsage] = Tag.materializeCStruct3Tag[Ptr[Byte], CUnsignedInt, Ptr[CXTUResourceUsageEntry]]
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
    extension (struct: CXType)
      def kind: CXTypeKind = struct._1
      def kind_=(value: CXTypeKind): Unit = !struct.at1 = value
      def data: CArray[Ptr[Byte], Nat._2] = struct._2
      def data_=(value: CArray[Ptr[Byte], Nat._2]): Unit = !struct.at2 = value

  opaque type CXUnsavedFile = CStruct3[CString, CString, CUnsignedLongInt]
  object CXUnsavedFile:
    given _tag: Tag[CXUnsavedFile] = Tag.materializeCStruct3Tag[CString, CString, CUnsignedLongInt]
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
    extension (struct: CXVersion)
      def Major: CInt = struct._1
      def Major_=(value: CInt): Unit = !struct.at1 = value
      def Minor: CInt = struct._2
      def Minor_=(value: CInt): Unit = !struct.at2 = value
      def Subminor: CInt = struct._3
      def Subminor_=(value: CInt): Unit = !struct.at3 = value

  opaque type IndexerCallbacks = CStruct8[Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]], Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]], Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]], Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]]
  object IndexerCallbacks:
    given _tag: Tag[IndexerCallbacks] = Tag.materializeCStruct8Tag[Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CInt]], Ptr[CFuncPtr3[CXClientData, CXDiagnosticSet, Ptr[Byte], Unit]], Ptr[CFuncPtr3[CXClientData, CXFile, Ptr[Byte], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxIncludedFileInfo], CXIdxClientFile]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxImportedASTFileInfo], CXIdxClientASTFile]], Ptr[CFuncPtr2[CXClientData, Ptr[Byte], CXIdxClientContainer]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxDeclInfo], Unit]], Ptr[CFuncPtr2[CXClientData, Ptr[CXIdxEntityRefInfo], Unit]]]
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
    extension (struct: __darwin_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object __darwin_pthread_cond_t:
    given _tag: Tag[__darwin_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    extension (struct: __darwin_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_condattr_t:
    given _tag: Tag[__darwin_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: __darwin_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_handler_rec = CStruct3[Ptr[CFuncPtr1[Ptr[Byte], Unit]], Ptr[Byte], Ptr[Byte]]
  object __darwin_pthread_handler_rec:
    given _tag: Tag[__darwin_pthread_handler_rec] = Tag.materializeCStruct3Tag[Ptr[CFuncPtr1[Ptr[Byte], Unit]], Ptr[Byte], Ptr[Byte]]
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
    extension (struct: __darwin_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_mutexattr_t:
    given _tag: Tag[__darwin_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: __darwin_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object __darwin_pthread_once_t:
    given _tag: Tag[__darwin_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: __darwin_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object __darwin_pthread_rwlock_t:
    given _tag: Tag[__darwin_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    extension (struct: __darwin_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type __darwin_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object __darwin_pthread_rwlockattr_t:
    given _tag: Tag[__darwin_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: __darwin_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_attr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_attr_t:
    given _tag: Tag[_opaque_pthread_attr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    extension (struct: _opaque_pthread_attr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_cond_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
  object _opaque_pthread_cond_t:
    given _tag: Tag[_opaque_pthread_cond_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]]
    extension (struct: _opaque_pthread_cond_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._4, Nat._0]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_condattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_condattr_t:
    given _tag: Tag[_opaque_pthread_condattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: _opaque_pthread_condattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutex_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
  object _opaque_pthread_mutex_t:
    given _tag: Tag[_opaque_pthread_mutex_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]]
    extension (struct: _opaque_pthread_mutex_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._5, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_mutexattr_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_mutexattr_t:
    given _tag: Tag[_opaque_pthread_mutexattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: _opaque_pthread_mutexattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_once_t = CStruct2[CLongInt, CArray[CChar, Nat._8]]
  object _opaque_pthread_once_t:
    given _tag: Tag[_opaque_pthread_once_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat._8]]
    extension (struct: _opaque_pthread_once_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat._8] = struct._2
      def __opaque_=(value: CArray[CChar, Nat._8]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlock_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
  object _opaque_pthread_rwlock_t:
    given _tag: Tag[_opaque_pthread_rwlock_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]]
    extension (struct: _opaque_pthread_rwlock_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit3[Nat._1, Nat._9, Nat._2]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_rwlockattr_t = CStruct2[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
  object _opaque_pthread_rwlockattr_t:
    given _tag: Tag[_opaque_pthread_rwlockattr_t] = Tag.materializeCStruct2Tag[CLongInt, CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]]
    extension (struct: _opaque_pthread_rwlockattr_t)
      def __sig: CLongInt = struct._1
      def __sig_=(value: CLongInt): Unit = !struct.at1 = value
      def __opaque: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]] = struct._2
      def __opaque_=(value: CArray[CChar, Nat.Digit2[Nat._1, Nat._6]]): Unit = !struct.at2 = value

  opaque type _opaque_pthread_t = CStruct3[CLongInt, Ptr[__darwin_pthread_handler_rec], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
  object _opaque_pthread_t:
    given _tag: Tag[_opaque_pthread_t] = Tag.materializeCStruct3Tag[CLongInt, Ptr[__darwin_pthread_handler_rec], CArray[CChar, Nat.Digit4[Nat._8, Nat._1, Nat._7, Nat._6]]]
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
    extension (struct: timespec)
      def tv_sec: __darwin_time_t = struct._1
      def tv_sec_=(value: __darwin_time_t): Unit = !struct.at1 = value
      def tv_nsec: CLongInt = struct._2
      def tv_nsec_=(value: CLongInt): Unit = !struct.at2 = value

  opaque type tm = CStruct11[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CLongInt, CString]
  object tm:
    given _tag: Tag[tm] = Tag.materializeCStruct11Tag[CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CInt, CLongInt, CString]
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

  def asctime(_0: Ptr[tm]): CString = extern

  def asctime_r(_0: Ptr[tm], _1: CString): CString = extern

  def clang_CXCursorSet_contains(): CInt = extern

  def clang_CXCursorSet_insert(): CInt = extern

  def clang_CXIndex_getGlobalOptions(): CInt = extern

  def clang_CXIndex_setGlobalOptions(): CInt = extern

  def clang_CXIndex_setInvocationEmissionPathOption(): CInt = extern

  def clang_CXXConstructor_isConvertingConstructor(): CInt = extern

  def clang_CXXConstructor_isCopyConstructor(): CInt = extern

  def clang_CXXConstructor_isDefaultConstructor(): CInt = extern

  def clang_CXXConstructor_isMoveConstructor(): CInt = extern

  def clang_CXXField_isMutable(): CInt = extern

  def clang_CXXMethod_isConst(): CInt = extern

  def clang_CXXMethod_isDefaulted(): CInt = extern

  def clang_CXXMethod_isPureVirtual(): CInt = extern

  def clang_CXXMethod_isStatic(): CInt = extern

  def clang_CXXMethod_isVirtual(): CInt = extern

  def clang_CXXRecord_isAbstract(): CInt = extern

  def clang_Cursor_getNumArguments(): CInt = extern

  def clang_Cursor_getNumTemplateArguments(): CInt = extern

  def clang_Cursor_getObjCDeclQualifiers(): CInt = extern

  def clang_Cursor_getObjCPropertyAttributes(): CInt = extern

  def clang_Cursor_getObjCSelectorIndex(): CInt = extern

  def clang_Cursor_getOffsetOfField(): CInt = extern

  def clang_Cursor_getStorageClass(): CInt = extern

  def clang_Cursor_getTemplateArgumentKind(): CInt = extern

  def clang_Cursor_getTemplateArgumentUnsignedValue(): CInt = extern

  def clang_Cursor_getTemplateArgumentValue(): CInt = extern

  def clang_Cursor_hasAttrs(): CInt = extern

  def clang_Cursor_hasVarDeclExternalStorage(): CInt = extern

  def clang_Cursor_hasVarDeclGlobalStorage(): CInt = extern

  def clang_Cursor_isAnonymous(): CInt = extern

  def clang_Cursor_isAnonymousRecordDecl(): CInt = extern

  def clang_Cursor_isBitField(): CInt = extern

  def clang_Cursor_isDynamicCall(): CInt = extern

  def clang_Cursor_isExternalSymbol(): CInt = extern

  def clang_Cursor_isFunctionInlined(): CInt = extern

  def clang_Cursor_isInlineNamespace(): CInt = extern

  def clang_Cursor_isMacroBuiltin(): CInt = extern

  def clang_Cursor_isMacroFunctionLike(): CInt = extern

  def clang_Cursor_isNull(): CInt = extern

  def clang_Cursor_isObjCOptional(): CInt = extern

  def clang_Cursor_isVariadic(): CInt = extern

  def clang_EnumDecl_isScoped(): CInt = extern

  def clang_EvalResult_dispose(): CInt = extern

  def clang_EvalResult_getAsDouble(): CInt = extern

  def clang_EvalResult_getAsInt(): CInt = extern

  def clang_EvalResult_getAsLongLong(): CInt = extern

  def clang_EvalResult_getAsStr(): Ptr[CInt] = extern

  def clang_EvalResult_getAsUnsigned(): CInt = extern

  def clang_EvalResult_isUnsignedInt(): CInt = extern

  def clang_File_isEqual(): CInt = extern

  def clang_IndexAction_dispose(): CInt = extern

  def clang_Location_isFromMainFile(): CInt = extern

  def clang_Location_isInSystemHeader(): CInt = extern

  def clang_Module_getNumTopLevelHeaders(): CInt = extern

  def clang_Module_isSystem(): CInt = extern

  def clang_PrintingPolicy_dispose(): CInt = extern

  def clang_PrintingPolicy_getProperty(): CInt = extern

  def clang_PrintingPolicy_setProperty(): CInt = extern

  def clang_Range_isNull(): CInt = extern

  def clang_TargetInfo_dispose(): CInt = extern

  def clang_TargetInfo_getPointerWidth(): CInt = extern

  def clang_Type_getAlignOf(): CInt = extern

  def clang_Type_getCXXRefQualifier(): CInt = extern

  def clang_Type_getNullability(): CInt = extern

  def clang_Type_getNumObjCProtocolRefs(): CInt = extern

  def clang_Type_getNumObjCTypeArgs(): CInt = extern

  def clang_Type_getNumTemplateArguments(): CInt = extern

  def clang_Type_getOffsetOf(): CInt = extern

  def clang_Type_getSizeOf(): CInt = extern

  def clang_Type_isTransparentTagTypedef(): CInt = extern

  def clang_Type_visitFields(): CInt = extern

  def clang_annotateTokens(): CInt = extern

  def clang_codeCompleteGetContainerKind(): CInt = extern

  def clang_codeCompleteGetContexts(): CInt = extern

  def clang_codeCompleteGetNumDiagnostics(): CInt = extern

  def clang_createTranslationUnit2(): CInt = extern

  def clang_defaultCodeCompleteOptions(): CInt = extern

  def clang_defaultDiagnosticDisplayOptions(): CInt = extern

  def clang_defaultEditingTranslationUnitOptions(): CInt = extern

  def clang_defaultReparseOptions(): CInt = extern

  def clang_defaultSaveOptions(): CInt = extern

  def clang_disposeCXCursorSet(): CInt = extern

  def clang_disposeCXPlatformAvailability(): CInt = extern

  def clang_disposeCXTUResourceUsage(): CInt = extern

  def clang_disposeCodeCompleteResults(): CInt = extern

  def clang_disposeDiagnostic(): CInt = extern

  def clang_disposeDiagnosticSet(): CInt = extern

  def clang_disposeIndex(): CInt = extern

  def clang_disposeOverriddenCursors(): CInt = extern

  def clang_disposeSourceRangeList(): CInt = extern

  def clang_disposeTokens(): CInt = extern

  def clang_disposeTranslationUnit(): CInt = extern

  def clang_enableStackTraces(): CInt = extern

  def clang_equalCursors(): CInt = extern

  def clang_equalLocations(): CInt = extern

  def clang_equalRanges(): CInt = extern

  def clang_equalTypes(): CInt = extern

  def clang_executeOnThread(): CInt = extern

  def clang_getAddressSpace(): CInt = extern

  def clang_getArraySize(): CInt = extern

  def clang_getCXXAccessSpecifier(): CInt = extern

  def clang_getCompletionAvailability(): CInt = extern

  def clang_getCompletionChunkKind(): CInt = extern

  def clang_getCompletionNumAnnotations(): CInt = extern

  def clang_getCompletionNumFixIts(): CInt = extern

  def clang_getCompletionPriority(): CInt = extern

  def clang_getCursorAvailability(): CInt = extern

  def clang_getCursorExceptionSpecificationType(): CInt = extern

  def clang_getCursorKind(): CInt = extern

  def clang_getCursorLanguage(): CInt = extern

  def clang_getCursorLinkage(): CInt = extern

  def clang_getCursorPlatformAvailability(): CInt = extern

  def clang_getCursorTLSKind(): CInt = extern

  def clang_getCursorVisibility(): CInt = extern

  def clang_getDefinitionSpellingAndExtent(): CInt = extern

  def clang_getDiagnosticCategory(): CInt = extern

  def clang_getDiagnosticNumFixIts(): CInt = extern

  def clang_getDiagnosticNumRanges(): CInt = extern

  def clang_getDiagnosticSeverity(): CInt = extern

  def clang_getEnumConstantDeclUnsignedValue(): CInt = extern

  def clang_getEnumConstantDeclValue(): CInt = extern

  def clang_getExceptionSpecificationType(): CInt = extern

  def clang_getExpansionLocation(): CInt = extern

  def clang_getFieldDeclBitWidth(): CInt = extern

  def clang_getFileContents(): Ptr[CInt] = extern

  def clang_getFileLocation(): CInt = extern

  def clang_getFileUniqueID(): CInt = extern

  def clang_getFunctionTypeCallingConv(): CInt = extern

  def clang_getInclusions(): CInt = extern

  def clang_getInstantiationLocation(): CInt = extern

  def clang_getNumArgTypes(): CInt = extern

  def clang_getNumCompletionChunks(): CInt = extern

  def clang_getNumDiagnostics(): CInt = extern

  def clang_getNumDiagnosticsInSet(): CInt = extern

  def clang_getNumElements(): CInt = extern

  def clang_getNumOverloadedDecls(): CInt = extern

  def clang_getOverriddenCursors(): CInt = extern

  def clang_getPresumedLocation(): CInt = extern

  def clang_getSpellingLocation(): CInt = extern

  def clang_getTUResourceUsageName(): Ptr[CInt] = extern

  def clang_getTemplateCursorKind(): CInt = extern

  def clang_hashCursor(): CInt = extern

  def clang_indexLoc_getFileLocation(): CInt = extern

  def clang_indexSourceFile(): CInt = extern

  def clang_indexSourceFileFullArgv(): CInt = extern

  def clang_indexTranslationUnit(): CInt = extern

  def clang_index_isEntityObjCContainerKind(): CInt = extern

  def clang_index_setClientContainer(): CInt = extern

  def clang_index_setClientEntity(): CInt = extern

  def clang_isAttribute(): CInt = extern

  def clang_isConstQualifiedType(): CInt = extern

  def clang_isCursorDefinition(): CInt = extern

  def clang_isDeclaration(): CInt = extern

  def clang_isExpression(): CInt = extern

  def clang_isFileMultipleIncludeGuarded(): CInt = extern

  def clang_isFunctionTypeVariadic(): CInt = extern

  def clang_isInvalid(): CInt = extern

  def clang_isInvalidDeclaration(): CInt = extern

  def clang_isPODType(): CInt = extern

  def clang_isPreprocessing(): CInt = extern

  def clang_isReference(): CInt = extern

  def clang_isRestrictQualifiedType(): CInt = extern

  def clang_isStatement(): CInt = extern

  def clang_isTranslationUnit(): CInt = extern

  def clang_isUnexposed(): CInt = extern

  def clang_isVirtualBase(): CInt = extern

  def clang_isVolatileQualifiedType(): CInt = extern

  def clang_parseTranslationUnit2(): CInt = extern

  def clang_parseTranslationUnit2FullArgv(): CInt = extern

  def clang_remap_dispose(): CInt = extern

  def clang_remap_getFilenames(): CInt = extern

  def clang_remap_getNumFiles(): CInt = extern

  def clang_reparseTranslationUnit(): CInt = extern

  def clang_saveTranslationUnit(): CInt = extern

  def clang_sortCodeCompletionResults(): CInt = extern

  def clang_suspendTranslationUnit(): CInt = extern

  def clang_toggleCrashRecovery(): CInt = extern

  def clang_tokenize(): CInt = extern

  def clang_visitChildren(): CInt = extern

  def clang_visitChildrenWithBlock(): CInt = extern

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


