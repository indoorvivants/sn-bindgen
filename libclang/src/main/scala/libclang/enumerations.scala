package libclang

object enumerations:
  opaque type CXIdxEntityLanguage = Int
  object CXIdxEntityLanguage extends CEnum[CXIdxEntityLanguage]:
    val CXIdxEntityLang_None: CXIdxEntityLanguage = 0
    val CXIdxEntityLang_C: CXIdxEntityLanguage = 1
    val CXIdxEntityLang_ObjC: CXIdxEntityLanguage = 2
    val CXIdxEntityLang_CXX: CXIdxEntityLanguage = 3
    val CXIdxEntityLang_Swift: CXIdxEntityLanguage = 4

  opaque type CXVisitorResult = Int
  object CXVisitorResult extends CEnum[CXVisitorResult]:
    val CXVisit_Break: CXVisitorResult = 0
    val CXVisit_Continue: CXVisitorResult = 1

  opaque type CXNameRefFlags = Int
  object CXNameRefFlags extends CEnum[CXNameRefFlags]:
    val CXNameRange_WantQualifier: CXNameRefFlags = 1
    val CXNameRange_WantTemplateArgs: CXNameRefFlags = 2
    val CXNameRange_WantSinglePiece: CXNameRefFlags = 4

  opaque type CXCompletionChunkKind = Int
  object CXCompletionChunkKind extends CEnum[CXCompletionChunkKind]:
    val CXCompletionChunk_Optional: CXCompletionChunkKind = 0
    val CXCompletionChunk_TypedText: CXCompletionChunkKind = 1
    val CXCompletionChunk_Text: CXCompletionChunkKind = 2
    val CXCompletionChunk_Placeholder: CXCompletionChunkKind = 3
    val CXCompletionChunk_Informative: CXCompletionChunkKind = 4
    val CXCompletionChunk_CurrentParameter: CXCompletionChunkKind = 5
    val CXCompletionChunk_LeftParen: CXCompletionChunkKind = 6
    val CXCompletionChunk_RightParen: CXCompletionChunkKind = 7
    val CXCompletionChunk_LeftBracket: CXCompletionChunkKind = 8
    val CXCompletionChunk_RightBracket: CXCompletionChunkKind = 9
    val CXCompletionChunk_LeftBrace: CXCompletionChunkKind = 10
    val CXCompletionChunk_RightBrace: CXCompletionChunkKind = 11
    val CXCompletionChunk_LeftAngle: CXCompletionChunkKind = 12
    val CXCompletionChunk_RightAngle: CXCompletionChunkKind = 13
    val CXCompletionChunk_Comma: CXCompletionChunkKind = 14
    val CXCompletionChunk_ResultType: CXCompletionChunkKind = 15
    val CXCompletionChunk_Colon: CXCompletionChunkKind = 16
    val CXCompletionChunk_SemiColon: CXCompletionChunkKind = 17
    val CXCompletionChunk_Equal: CXCompletionChunkKind = 18
    val CXCompletionChunk_HorizontalSpace: CXCompletionChunkKind = 19
    val CXCompletionChunk_VerticalSpace: CXCompletionChunkKind = 20

  opaque type CXCursorKind = Int
  object CXCursorKind extends CEnum[CXCursorKind]:
    val CXCursor_UnexposedDecl: CXCursorKind = 1
    val CXCursor_StructDecl: CXCursorKind = 2
    val CXCursor_UnionDecl: CXCursorKind = 3
    val CXCursor_ClassDecl: CXCursorKind = 4
    val CXCursor_EnumDecl: CXCursorKind = 5
    val CXCursor_FieldDecl: CXCursorKind = 6
    val CXCursor_EnumConstantDecl: CXCursorKind = 7
    val CXCursor_FunctionDecl: CXCursorKind = 8
    val CXCursor_VarDecl: CXCursorKind = 9
    val CXCursor_ParmDecl: CXCursorKind = 10
    val CXCursor_ObjCInterfaceDecl: CXCursorKind = 11
    val CXCursor_ObjCCategoryDecl: CXCursorKind = 12
    val CXCursor_ObjCProtocolDecl: CXCursorKind = 13
    val CXCursor_ObjCPropertyDecl: CXCursorKind = 14
    val CXCursor_ObjCIvarDecl: CXCursorKind = 15
    val CXCursor_ObjCInstanceMethodDecl: CXCursorKind = 16
    val CXCursor_ObjCClassMethodDecl: CXCursorKind = 17
    val CXCursor_ObjCImplementationDecl: CXCursorKind = 18
    val CXCursor_ObjCCategoryImplDecl: CXCursorKind = 19
    val CXCursor_TypedefDecl: CXCursorKind = 20
    val CXCursor_CXXMethod: CXCursorKind = 21
    val CXCursor_Namespace: CXCursorKind = 22
    val CXCursor_LinkageSpec: CXCursorKind = 23
    val CXCursor_Constructor: CXCursorKind = 24
    val CXCursor_Destructor: CXCursorKind = 25
    val CXCursor_ConversionFunction: CXCursorKind = 26
    val CXCursor_TemplateTypeParameter: CXCursorKind = 27
    val CXCursor_NonTypeTemplateParameter: CXCursorKind = 28
    val CXCursor_TemplateTemplateParameter: CXCursorKind = 29
    val CXCursor_FunctionTemplate: CXCursorKind = 30
    val CXCursor_ClassTemplate: CXCursorKind = 31
    val CXCursor_ClassTemplatePartialSpecialization: CXCursorKind = 32
    val CXCursor_NamespaceAlias: CXCursorKind = 33
    val CXCursor_UsingDirective: CXCursorKind = 34
    val CXCursor_UsingDeclaration: CXCursorKind = 35
    val CXCursor_TypeAliasDecl: CXCursorKind = 36
    val CXCursor_ObjCSynthesizeDecl: CXCursorKind = 37
    val CXCursor_ObjCDynamicDecl: CXCursorKind = 38
    val CXCursor_CXXAccessSpecifier: CXCursorKind = 39
    val CXCursor_FirstDecl: CXCursorKind = 1
    val CXCursor_LastDecl: CXCursorKind = 39
    val CXCursor_FirstRef: CXCursorKind = 40
    val CXCursor_ObjCSuperClassRef: CXCursorKind = 40
    val CXCursor_ObjCProtocolRef: CXCursorKind = 41
    val CXCursor_ObjCClassRef: CXCursorKind = 42
    val CXCursor_TypeRef: CXCursorKind = 43
    val CXCursor_CXXBaseSpecifier: CXCursorKind = 44
    val CXCursor_TemplateRef: CXCursorKind = 45
    val CXCursor_NamespaceRef: CXCursorKind = 46
    val CXCursor_MemberRef: CXCursorKind = 47
    val CXCursor_LabelRef: CXCursorKind = 48
    val CXCursor_OverloadedDeclRef: CXCursorKind = 49
    val CXCursor_VariableRef: CXCursorKind = 50
    val CXCursor_LastRef: CXCursorKind = 50
    val CXCursor_FirstInvalid: CXCursorKind = 70
    val CXCursor_InvalidFile: CXCursorKind = 70
    val CXCursor_NoDeclFound: CXCursorKind = 71
    val CXCursor_NotImplemented: CXCursorKind = 72
    val CXCursor_InvalidCode: CXCursorKind = 73
    val CXCursor_LastInvalid: CXCursorKind = 73
    val CXCursor_FirstExpr: CXCursorKind = 100
    val CXCursor_UnexposedExpr: CXCursorKind = 100
    val CXCursor_DeclRefExpr: CXCursorKind = 101
    val CXCursor_MemberRefExpr: CXCursorKind = 102
    val CXCursor_CallExpr: CXCursorKind = 103
    val CXCursor_ObjCMessageExpr: CXCursorKind = 104
    val CXCursor_BlockExpr: CXCursorKind = 105
    val CXCursor_IntegerLiteral: CXCursorKind = 106
    val CXCursor_FloatingLiteral: CXCursorKind = 107
    val CXCursor_ImaginaryLiteral: CXCursorKind = 108
    val CXCursor_StringLiteral: CXCursorKind = 109
    val CXCursor_CharacterLiteral: CXCursorKind = 110
    val CXCursor_ParenExpr: CXCursorKind = 111
    val CXCursor_UnaryOperator: CXCursorKind = 112
    val CXCursor_ArraySubscriptExpr: CXCursorKind = 113
    val CXCursor_BinaryOperator: CXCursorKind = 114
    val CXCursor_CompoundAssignOperator: CXCursorKind = 115
    val CXCursor_ConditionalOperator: CXCursorKind = 116
    val CXCursor_CStyleCastExpr: CXCursorKind = 117
    val CXCursor_CompoundLiteralExpr: CXCursorKind = 118
    val CXCursor_InitListExpr: CXCursorKind = 119
    val CXCursor_AddrLabelExpr: CXCursorKind = 120
    val CXCursor_StmtExpr: CXCursorKind = 121
    val CXCursor_GenericSelectionExpr: CXCursorKind = 122
    val CXCursor_GNUNullExpr: CXCursorKind = 123
    val CXCursor_CXXStaticCastExpr: CXCursorKind = 124
    val CXCursor_CXXDynamicCastExpr: CXCursorKind = 125
    val CXCursor_CXXReinterpretCastExpr: CXCursorKind = 126
    val CXCursor_CXXConstCastExpr: CXCursorKind = 127
    val CXCursor_CXXFunctionalCastExpr: CXCursorKind = 128
    val CXCursor_CXXTypeidExpr: CXCursorKind = 129
    val CXCursor_CXXBoolLiteralExpr: CXCursorKind = 130
    val CXCursor_CXXNullPtrLiteralExpr: CXCursorKind = 131
    val CXCursor_CXXThisExpr: CXCursorKind = 132
    val CXCursor_CXXThrowExpr: CXCursorKind = 133
    val CXCursor_CXXNewExpr: CXCursorKind = 134
    val CXCursor_CXXDeleteExpr: CXCursorKind = 135
    val CXCursor_UnaryExpr: CXCursorKind = 136
    val CXCursor_ObjCStringLiteral: CXCursorKind = 137
    val CXCursor_ObjCEncodeExpr: CXCursorKind = 138
    val CXCursor_ObjCSelectorExpr: CXCursorKind = 139
    val CXCursor_ObjCProtocolExpr: CXCursorKind = 140
    val CXCursor_ObjCBridgedCastExpr: CXCursorKind = 141
    val CXCursor_PackExpansionExpr: CXCursorKind = 142
    val CXCursor_SizeOfPackExpr: CXCursorKind = 143
    val CXCursor_LambdaExpr: CXCursorKind = 144
    val CXCursor_ObjCBoolLiteralExpr: CXCursorKind = 145
    val CXCursor_ObjCSelfExpr: CXCursorKind = 146
    val CXCursor_OMPArraySectionExpr: CXCursorKind = 147
    val CXCursor_ObjCAvailabilityCheckExpr: CXCursorKind = 148
    val CXCursor_FixedPointLiteral: CXCursorKind = 149
    val CXCursor_OMPArrayShapingExpr: CXCursorKind = 150
    val CXCursor_OMPIteratorExpr: CXCursorKind = 151
    val CXCursor_CXXAddrspaceCastExpr: CXCursorKind = 152
    val CXCursor_LastExpr: CXCursorKind = 152
    val CXCursor_FirstStmt: CXCursorKind = 200
    val CXCursor_UnexposedStmt: CXCursorKind = 200
    val CXCursor_LabelStmt: CXCursorKind = 201
    val CXCursor_CompoundStmt: CXCursorKind = 202
    val CXCursor_CaseStmt: CXCursorKind = 203
    val CXCursor_DefaultStmt: CXCursorKind = 204
    val CXCursor_IfStmt: CXCursorKind = 205
    val CXCursor_SwitchStmt: CXCursorKind = 206
    val CXCursor_WhileStmt: CXCursorKind = 207
    val CXCursor_DoStmt: CXCursorKind = 208
    val CXCursor_ForStmt: CXCursorKind = 209
    val CXCursor_GotoStmt: CXCursorKind = 210
    val CXCursor_IndirectGotoStmt: CXCursorKind = 211
    val CXCursor_ContinueStmt: CXCursorKind = 212
    val CXCursor_BreakStmt: CXCursorKind = 213
    val CXCursor_ReturnStmt: CXCursorKind = 214
    val CXCursor_GCCAsmStmt: CXCursorKind = 215
    val CXCursor_AsmStmt: CXCursorKind = 215
    val CXCursor_ObjCAtTryStmt: CXCursorKind = 216
    val CXCursor_ObjCAtCatchStmt: CXCursorKind = 217
    val CXCursor_ObjCAtFinallyStmt: CXCursorKind = 218
    val CXCursor_ObjCAtThrowStmt: CXCursorKind = 219
    val CXCursor_ObjCAtSynchronizedStmt: CXCursorKind = 220
    val CXCursor_ObjCAutoreleasePoolStmt: CXCursorKind = 221
    val CXCursor_ObjCForCollectionStmt: CXCursorKind = 222
    val CXCursor_CXXCatchStmt: CXCursorKind = 223
    val CXCursor_CXXTryStmt: CXCursorKind = 224
    val CXCursor_CXXForRangeStmt: CXCursorKind = 225
    val CXCursor_SEHTryStmt: CXCursorKind = 226
    val CXCursor_SEHExceptStmt: CXCursorKind = 227
    val CXCursor_SEHFinallyStmt: CXCursorKind = 228
    val CXCursor_MSAsmStmt: CXCursorKind = 229
    val CXCursor_NullStmt: CXCursorKind = 230
    val CXCursor_DeclStmt: CXCursorKind = 231
    val CXCursor_OMPParallelDirective: CXCursorKind = 232
    val CXCursor_OMPSimdDirective: CXCursorKind = 233
    val CXCursor_OMPForDirective: CXCursorKind = 234
    val CXCursor_OMPSectionsDirective: CXCursorKind = 235
    val CXCursor_OMPSectionDirective: CXCursorKind = 236
    val CXCursor_OMPSingleDirective: CXCursorKind = 237
    val CXCursor_OMPParallelForDirective: CXCursorKind = 238
    val CXCursor_OMPParallelSectionsDirective: CXCursorKind = 239
    val CXCursor_OMPTaskDirective: CXCursorKind = 240
    val CXCursor_OMPMasterDirective: CXCursorKind = 241
    val CXCursor_OMPCriticalDirective: CXCursorKind = 242
    val CXCursor_OMPTaskyieldDirective: CXCursorKind = 243
    val CXCursor_OMPBarrierDirective: CXCursorKind = 244
    val CXCursor_OMPTaskwaitDirective: CXCursorKind = 245
    val CXCursor_OMPFlushDirective: CXCursorKind = 246
    val CXCursor_SEHLeaveStmt: CXCursorKind = 247
    val CXCursor_OMPOrderedDirective: CXCursorKind = 248
    val CXCursor_OMPAtomicDirective: CXCursorKind = 249
    val CXCursor_OMPForSimdDirective: CXCursorKind = 250
    val CXCursor_OMPParallelForSimdDirective: CXCursorKind = 251
    val CXCursor_OMPTargetDirective: CXCursorKind = 252
    val CXCursor_OMPTeamsDirective: CXCursorKind = 253
    val CXCursor_OMPTaskgroupDirective: CXCursorKind = 254
    val CXCursor_OMPCancellationPointDirective: CXCursorKind = 255
    val CXCursor_OMPCancelDirective: CXCursorKind = 256
    val CXCursor_OMPTargetDataDirective: CXCursorKind = 257
    val CXCursor_OMPTaskLoopDirective: CXCursorKind = 258
    val CXCursor_OMPTaskLoopSimdDirective: CXCursorKind = 259
    val CXCursor_OMPDistributeDirective: CXCursorKind = 260
    val CXCursor_OMPTargetEnterDataDirective: CXCursorKind = 261
    val CXCursor_OMPTargetExitDataDirective: CXCursorKind = 262
    val CXCursor_OMPTargetParallelDirective: CXCursorKind = 263
    val CXCursor_OMPTargetParallelForDirective: CXCursorKind = 264
    val CXCursor_OMPTargetUpdateDirective: CXCursorKind = 265
    val CXCursor_OMPDistributeParallelForDirective: CXCursorKind = 266
    val CXCursor_OMPDistributeParallelForSimdDirective: CXCursorKind = 267
    val CXCursor_OMPDistributeSimdDirective: CXCursorKind = 268
    val CXCursor_OMPTargetParallelForSimdDirective: CXCursorKind = 269
    val CXCursor_OMPTargetSimdDirective: CXCursorKind = 270
    val CXCursor_OMPTeamsDistributeDirective: CXCursorKind = 271
    val CXCursor_OMPTeamsDistributeSimdDirective: CXCursorKind = 272
    val CXCursor_OMPTeamsDistributeParallelForSimdDirective: CXCursorKind = 273
    val CXCursor_OMPTeamsDistributeParallelForDirective: CXCursorKind = 274
    val CXCursor_OMPTargetTeamsDirective: CXCursorKind = 275
    val CXCursor_OMPTargetTeamsDistributeDirective: CXCursorKind = 276
    val CXCursor_OMPTargetTeamsDistributeParallelForDirective: CXCursorKind = 277
    val CXCursor_OMPTargetTeamsDistributeParallelForSimdDirective: CXCursorKind = 278
    val CXCursor_OMPTargetTeamsDistributeSimdDirective: CXCursorKind = 279
    val CXCursor_BuiltinBitCastExpr: CXCursorKind = 280
    val CXCursor_OMPMasterTaskLoopDirective: CXCursorKind = 281
    val CXCursor_OMPParallelMasterTaskLoopDirective: CXCursorKind = 282
    val CXCursor_OMPMasterTaskLoopSimdDirective: CXCursorKind = 283
    val CXCursor_OMPParallelMasterTaskLoopSimdDirective: CXCursorKind = 284
    val CXCursor_OMPParallelMasterDirective: CXCursorKind = 285
    val CXCursor_OMPDepobjDirective: CXCursorKind = 286
    val CXCursor_OMPScanDirective: CXCursorKind = 287
    val CXCursor_OMPTileDirective: CXCursorKind = 288
    val CXCursor_OMPCanonicalLoop: CXCursorKind = 289
    val CXCursor_OMPInteropDirective: CXCursorKind = 290
    val CXCursor_OMPDispatchDirective: CXCursorKind = 291
    val CXCursor_OMPMaskedDirective: CXCursorKind = 292
    val CXCursor_OMPUnrollDirective: CXCursorKind = 293
    val CXCursor_OMPMetaDirective: CXCursorKind = 294
    val CXCursor_OMPGenericLoopDirective: CXCursorKind = 295
    val CXCursor_LastStmt: CXCursorKind = 295
    val CXCursor_TranslationUnit: CXCursorKind = 300
    val CXCursor_FirstAttr: CXCursorKind = 400
    val CXCursor_UnexposedAttr: CXCursorKind = 400
    val CXCursor_IBActionAttr: CXCursorKind = 401
    val CXCursor_IBOutletAttr: CXCursorKind = 402
    val CXCursor_IBOutletCollectionAttr: CXCursorKind = 403
    val CXCursor_CXXFinalAttr: CXCursorKind = 404
    val CXCursor_CXXOverrideAttr: CXCursorKind = 405
    val CXCursor_AnnotateAttr: CXCursorKind = 406
    val CXCursor_AsmLabelAttr: CXCursorKind = 407
    val CXCursor_PackedAttr: CXCursorKind = 408
    val CXCursor_PureAttr: CXCursorKind = 409
    val CXCursor_ConstAttr: CXCursorKind = 410
    val CXCursor_NoDuplicateAttr: CXCursorKind = 411
    val CXCursor_CUDAConstantAttr: CXCursorKind = 412
    val CXCursor_CUDADeviceAttr: CXCursorKind = 413
    val CXCursor_CUDAGlobalAttr: CXCursorKind = 414
    val CXCursor_CUDAHostAttr: CXCursorKind = 415
    val CXCursor_CUDASharedAttr: CXCursorKind = 416
    val CXCursor_VisibilityAttr: CXCursorKind = 417
    val CXCursor_DLLExport: CXCursorKind = 418
    val CXCursor_DLLImport: CXCursorKind = 419
    val CXCursor_NSReturnsRetained: CXCursorKind = 420
    val CXCursor_NSReturnsNotRetained: CXCursorKind = 421
    val CXCursor_NSReturnsAutoreleased: CXCursorKind = 422
    val CXCursor_NSConsumesSelf: CXCursorKind = 423
    val CXCursor_NSConsumed: CXCursorKind = 424
    val CXCursor_ObjCException: CXCursorKind = 425
    val CXCursor_ObjCNSObject: CXCursorKind = 426
    val CXCursor_ObjCIndependentClass: CXCursorKind = 427
    val CXCursor_ObjCPreciseLifetime: CXCursorKind = 428
    val CXCursor_ObjCReturnsInnerPointer: CXCursorKind = 429
    val CXCursor_ObjCRequiresSuper: CXCursorKind = 430
    val CXCursor_ObjCRootClass: CXCursorKind = 431
    val CXCursor_ObjCSubclassingRestricted: CXCursorKind = 432
    val CXCursor_ObjCExplicitProtocolImpl: CXCursorKind = 433
    val CXCursor_ObjCDesignatedInitializer: CXCursorKind = 434
    val CXCursor_ObjCRuntimeVisible: CXCursorKind = 435
    val CXCursor_ObjCBoxable: CXCursorKind = 436
    val CXCursor_FlagEnum: CXCursorKind = 437
    val CXCursor_ConvergentAttr: CXCursorKind = 438
    val CXCursor_WarnUnusedAttr: CXCursorKind = 439
    val CXCursor_WarnUnusedResultAttr: CXCursorKind = 440
    val CXCursor_AlignedAttr: CXCursorKind = 441
    val CXCursor_LastAttr: CXCursorKind = 441
    val CXCursor_PreprocessingDirective: CXCursorKind = 500
    val CXCursor_MacroDefinition: CXCursorKind = 501
    val CXCursor_MacroExpansion: CXCursorKind = 502
    val CXCursor_MacroInstantiation: CXCursorKind = 502
    val CXCursor_InclusionDirective: CXCursorKind = 503
    val CXCursor_FirstPreprocessing: CXCursorKind = 500
    val CXCursor_LastPreprocessing: CXCursorKind = 503
    val CXCursor_ModuleImportDecl: CXCursorKind = 600
    val CXCursor_TypeAliasTemplateDecl: CXCursorKind = 601
    val CXCursor_StaticAssert: CXCursorKind = 602
    val CXCursor_FriendDecl: CXCursorKind = 603
    val CXCursor_FirstExtraDecl: CXCursorKind = 600
    val CXCursor_LastExtraDecl: CXCursorKind = 603
    val CXCursor_OverloadCandidate: CXCursorKind = 700

  opaque type CXReparse_Flags = Int
  object CXReparse_Flags extends CEnum[CXReparse_Flags]:
    val CXReparse_None: CXReparse_Flags = 0

  opaque type CXTranslationUnit_Flags = Int
  object CXTranslationUnit_Flags extends CEnum[CXTranslationUnit_Flags]:
    val CXTranslationUnit_None: CXTranslationUnit_Flags = 0
    val CXTranslationUnit_DetailedPreprocessingRecord: CXTranslationUnit_Flags = 1
    val CXTranslationUnit_Incomplete: CXTranslationUnit_Flags = 2
    val CXTranslationUnit_PrecompiledPreamble: CXTranslationUnit_Flags = 4
    val CXTranslationUnit_CacheCompletionResults: CXTranslationUnit_Flags = 8
    val CXTranslationUnit_ForSerialization: CXTranslationUnit_Flags = 16
    val CXTranslationUnit_CXXChainedPCH: CXTranslationUnit_Flags = 32
    val CXTranslationUnit_SkipFunctionBodies: CXTranslationUnit_Flags = 64
    val CXTranslationUnit_IncludeBriefCommentsInCodeCompletion: CXTranslationUnit_Flags = 128
    val CXTranslationUnit_CreatePreambleOnFirstParse: CXTranslationUnit_Flags = 256
    val CXTranslationUnit_KeepGoing: CXTranslationUnit_Flags = 512
    val CXTranslationUnit_SingleFileParse: CXTranslationUnit_Flags = 1024
    val CXTranslationUnit_LimitSkipFunctionBodiesToPreamble: CXTranslationUnit_Flags = 2048
    val CXTranslationUnit_IncludeAttributedTypes: CXTranslationUnit_Flags = 4096
    val CXTranslationUnit_VisitImplicitAttributes: CXTranslationUnit_Flags = 8192
    val CXTranslationUnit_IgnoreNonErrorsFromIncludedFiles: CXTranslationUnit_Flags = 16384
    val CXTranslationUnit_RetainExcludedConditionalBlocks: CXTranslationUnit_Flags = 32768
    
    extension (d: CXTranslationUnit_Flags)
      def `|`(other: CXTranslationUnit_Flags): CXTranslationUnit_Flags = d | other

  opaque type CXLoadDiag_Error = Int
  object CXLoadDiag_Error extends CEnum[CXLoadDiag_Error]:
    val CXLoadDiag_None: CXLoadDiag_Error = 0
    val CXLoadDiag_Unknown: CXLoadDiag_Error = 1
    val CXLoadDiag_CannotLoad: CXLoadDiag_Error = 2
    val CXLoadDiag_InvalidFile: CXLoadDiag_Error = 3

  opaque type clockid_t = Int
  object clockid_t extends CEnum[clockid_t]:
    val _CLOCK_REALTIME: clockid_t = 0
    val _CLOCK_MONOTONIC: clockid_t = 6
    val _CLOCK_MONOTONIC_RAW: clockid_t = 4
    val _CLOCK_MONOTONIC_RAW_APPROX: clockid_t = 5
    val _CLOCK_UPTIME_RAW: clockid_t = 8
    val _CLOCK_UPTIME_RAW_APPROX: clockid_t = 9
    val _CLOCK_PROCESS_CPUTIME_ID: clockid_t = 12
    val _CLOCK_THREAD_CPUTIME_ID: clockid_t = 16

  opaque type CXResult = Int
  object CXResult extends CEnum[CXResult]:
    val CXResult_Success: CXResult = 0
    val CXResult_Invalid: CXResult = 1
    val CXResult_VisitBreak: CXResult = 2

  opaque type CXLanguageKind = Int
  object CXLanguageKind extends CEnum[CXLanguageKind]:
    val CXLanguage_Invalid: CXLanguageKind = 0
    val CXLanguage_C: CXLanguageKind = 1
    val CXLanguage_ObjC: CXLanguageKind = 2
    val CXLanguage_CPlusPlus: CXLanguageKind = 3

  opaque type CXTypeKind = Int
  object CXTypeKind extends CEnum[CXTypeKind]:
    val CXType_Invalid: CXTypeKind = 0
    val CXType_Unexposed: CXTypeKind = 1
    val CXType_Void: CXTypeKind = 2
    val CXType_Bool: CXTypeKind = 3
    val CXType_Char_U: CXTypeKind = 4
    val CXType_UChar: CXTypeKind = 5
    val CXType_Char16: CXTypeKind = 6
    val CXType_Char32: CXTypeKind = 7
    val CXType_UShort: CXTypeKind = 8
    val CXType_UInt: CXTypeKind = 9
    val CXType_ULong: CXTypeKind = 10
    val CXType_ULongLong: CXTypeKind = 11
    val CXType_UInt128: CXTypeKind = 12
    val CXType_Char_S: CXTypeKind = 13
    val CXType_SChar: CXTypeKind = 14
    val CXType_WChar: CXTypeKind = 15
    val CXType_Short: CXTypeKind = 16
    val CXType_Int: CXTypeKind = 17
    val CXType_Long: CXTypeKind = 18
    val CXType_LongLong: CXTypeKind = 19
    val CXType_Int128: CXTypeKind = 20
    val CXType_Float: CXTypeKind = 21
    val CXType_Double: CXTypeKind = 22
    val CXType_LongDouble: CXTypeKind = 23
    val CXType_NullPtr: CXTypeKind = 24
    val CXType_Overload: CXTypeKind = 25
    val CXType_Dependent: CXTypeKind = 26
    val CXType_ObjCId: CXTypeKind = 27
    val CXType_ObjCClass: CXTypeKind = 28
    val CXType_ObjCSel: CXTypeKind = 29
    val CXType_Float128: CXTypeKind = 30
    val CXType_Half: CXTypeKind = 31
    val CXType_Float16: CXTypeKind = 32
    val CXType_ShortAccum: CXTypeKind = 33
    val CXType_Accum: CXTypeKind = 34
    val CXType_LongAccum: CXTypeKind = 35
    val CXType_UShortAccum: CXTypeKind = 36
    val CXType_UAccum: CXTypeKind = 37
    val CXType_ULongAccum: CXTypeKind = 38
    val CXType_BFloat16: CXTypeKind = 39
    val CXType_Ibm128: CXTypeKind = 40
    val CXType_FirstBuiltin: CXTypeKind = 2
    val CXType_LastBuiltin: CXTypeKind = 40
    val CXType_Complex: CXTypeKind = 100
    val CXType_Pointer: CXTypeKind = 101
    val CXType_BlockPointer: CXTypeKind = 102
    val CXType_LValueReference: CXTypeKind = 103
    val CXType_RValueReference: CXTypeKind = 104
    val CXType_Record: CXTypeKind = 105
    val CXType_Enum: CXTypeKind = 106
    val CXType_Typedef: CXTypeKind = 107
    val CXType_ObjCInterface: CXTypeKind = 108
    val CXType_ObjCObjectPointer: CXTypeKind = 109
    val CXType_FunctionNoProto: CXTypeKind = 110
    val CXType_FunctionProto: CXTypeKind = 111
    val CXType_ConstantArray: CXTypeKind = 112
    val CXType_Vector: CXTypeKind = 113
    val CXType_IncompleteArray: CXTypeKind = 114
    val CXType_VariableArray: CXTypeKind = 115
    val CXType_DependentSizedArray: CXTypeKind = 116
    val CXType_MemberPointer: CXTypeKind = 117
    val CXType_Auto: CXTypeKind = 118
    val CXType_Elaborated: CXTypeKind = 119
    val CXType_Pipe: CXTypeKind = 120
    val CXType_OCLImage1dRO: CXTypeKind = 121
    val CXType_OCLImage1dArrayRO: CXTypeKind = 122
    val CXType_OCLImage1dBufferRO: CXTypeKind = 123
    val CXType_OCLImage2dRO: CXTypeKind = 124
    val CXType_OCLImage2dArrayRO: CXTypeKind = 125
    val CXType_OCLImage2dDepthRO: CXTypeKind = 126
    val CXType_OCLImage2dArrayDepthRO: CXTypeKind = 127
    val CXType_OCLImage2dMSAARO: CXTypeKind = 128
    val CXType_OCLImage2dArrayMSAARO: CXTypeKind = 129
    val CXType_OCLImage2dMSAADepthRO: CXTypeKind = 130
    val CXType_OCLImage2dArrayMSAADepthRO: CXTypeKind = 131
    val CXType_OCLImage3dRO: CXTypeKind = 132
    val CXType_OCLImage1dWO: CXTypeKind = 133
    val CXType_OCLImage1dArrayWO: CXTypeKind = 134
    val CXType_OCLImage1dBufferWO: CXTypeKind = 135
    val CXType_OCLImage2dWO: CXTypeKind = 136
    val CXType_OCLImage2dArrayWO: CXTypeKind = 137
    val CXType_OCLImage2dDepthWO: CXTypeKind = 138
    val CXType_OCLImage2dArrayDepthWO: CXTypeKind = 139
    val CXType_OCLImage2dMSAAWO: CXTypeKind = 140
    val CXType_OCLImage2dArrayMSAAWO: CXTypeKind = 141
    val CXType_OCLImage2dMSAADepthWO: CXTypeKind = 142
    val CXType_OCLImage2dArrayMSAADepthWO: CXTypeKind = 143
    val CXType_OCLImage3dWO: CXTypeKind = 144
    val CXType_OCLImage1dRW: CXTypeKind = 145
    val CXType_OCLImage1dArrayRW: CXTypeKind = 146
    val CXType_OCLImage1dBufferRW: CXTypeKind = 147
    val CXType_OCLImage2dRW: CXTypeKind = 148
    val CXType_OCLImage2dArrayRW: CXTypeKind = 149
    val CXType_OCLImage2dDepthRW: CXTypeKind = 150
    val CXType_OCLImage2dArrayDepthRW: CXTypeKind = 151
    val CXType_OCLImage2dMSAARW: CXTypeKind = 152
    val CXType_OCLImage2dArrayMSAARW: CXTypeKind = 153
    val CXType_OCLImage2dMSAADepthRW: CXTypeKind = 154
    val CXType_OCLImage2dArrayMSAADepthRW: CXTypeKind = 155
    val CXType_OCLImage3dRW: CXTypeKind = 156
    val CXType_OCLSampler: CXTypeKind = 157
    val CXType_OCLEvent: CXTypeKind = 158
    val CXType_OCLQueue: CXTypeKind = 159
    val CXType_OCLReserveID: CXTypeKind = 160
    val CXType_ObjCObject: CXTypeKind = 161
    val CXType_ObjCTypeParam: CXTypeKind = 162
    val CXType_Attributed: CXTypeKind = 163
    val CXType_OCLIntelSubgroupAVCMcePayload: CXTypeKind = 164
    val CXType_OCLIntelSubgroupAVCImePayload: CXTypeKind = 165
    val CXType_OCLIntelSubgroupAVCRefPayload: CXTypeKind = 166
    val CXType_OCLIntelSubgroupAVCSicPayload: CXTypeKind = 167
    val CXType_OCLIntelSubgroupAVCMceResult: CXTypeKind = 168
    val CXType_OCLIntelSubgroupAVCImeResult: CXTypeKind = 169
    val CXType_OCLIntelSubgroupAVCRefResult: CXTypeKind = 170
    val CXType_OCLIntelSubgroupAVCSicResult: CXTypeKind = 171
    val CXType_OCLIntelSubgroupAVCImeResultSingleRefStreamout: CXTypeKind = 172
    val CXType_OCLIntelSubgroupAVCImeResultDualRefStreamout: CXTypeKind = 173
    val CXType_OCLIntelSubgroupAVCImeSingleRefStreamin: CXTypeKind = 174
    val CXType_OCLIntelSubgroupAVCImeDualRefStreamin: CXTypeKind = 175
    val CXType_ExtVector: CXTypeKind = 176
    val CXType_Atomic: CXTypeKind = 177

  opaque type CXVisibilityKind = Int
  object CXVisibilityKind extends CEnum[CXVisibilityKind]:
    val CXVisibility_Invalid: CXVisibilityKind = 0
    val CXVisibility_Hidden: CXVisibilityKind = 1
    val CXVisibility_Protected: CXVisibilityKind = 2
    val CXVisibility_Default: CXVisibilityKind = 3

  opaque type CXIdxEntityKind = Int
  object CXIdxEntityKind extends CEnum[CXIdxEntityKind]:
    val CXIdxEntity_Unexposed: CXIdxEntityKind = 0
    val CXIdxEntity_Typedef: CXIdxEntityKind = 1
    val CXIdxEntity_Function: CXIdxEntityKind = 2
    val CXIdxEntity_Variable: CXIdxEntityKind = 3
    val CXIdxEntity_Field: CXIdxEntityKind = 4
    val CXIdxEntity_EnumConstant: CXIdxEntityKind = 5
    val CXIdxEntity_ObjCClass: CXIdxEntityKind = 6
    val CXIdxEntity_ObjCProtocol: CXIdxEntityKind = 7
    val CXIdxEntity_ObjCCategory: CXIdxEntityKind = 8
    val CXIdxEntity_ObjCInstanceMethod: CXIdxEntityKind = 9
    val CXIdxEntity_ObjCClassMethod: CXIdxEntityKind = 10
    val CXIdxEntity_ObjCProperty: CXIdxEntityKind = 11
    val CXIdxEntity_ObjCIvar: CXIdxEntityKind = 12
    val CXIdxEntity_Enum: CXIdxEntityKind = 13
    val CXIdxEntity_Struct: CXIdxEntityKind = 14
    val CXIdxEntity_Union: CXIdxEntityKind = 15
    val CXIdxEntity_CXXClass: CXIdxEntityKind = 16
    val CXIdxEntity_CXXNamespace: CXIdxEntityKind = 17
    val CXIdxEntity_CXXNamespaceAlias: CXIdxEntityKind = 18
    val CXIdxEntity_CXXStaticVariable: CXIdxEntityKind = 19
    val CXIdxEntity_CXXStaticMethod: CXIdxEntityKind = 20
    val CXIdxEntity_CXXInstanceMethod: CXIdxEntityKind = 21
    val CXIdxEntity_CXXConstructor: CXIdxEntityKind = 22
    val CXIdxEntity_CXXDestructor: CXIdxEntityKind = 23
    val CXIdxEntity_CXXConversionFunction: CXIdxEntityKind = 24
    val CXIdxEntity_CXXTypeAlias: CXIdxEntityKind = 25
    val CXIdxEntity_CXXInterface: CXIdxEntityKind = 26

  opaque type CXDiagnosticDisplayOptions = Int
  object CXDiagnosticDisplayOptions extends CEnum[CXDiagnosticDisplayOptions]:
    val CXDiagnostic_DisplaySourceLocation: CXDiagnosticDisplayOptions = 1
    val CXDiagnostic_DisplayColumn: CXDiagnosticDisplayOptions = 2
    val CXDiagnostic_DisplaySourceRanges: CXDiagnosticDisplayOptions = 4
    val CXDiagnostic_DisplayOption: CXDiagnosticDisplayOptions = 8
    val CXDiagnostic_DisplayCategoryId: CXDiagnosticDisplayOptions = 16
    val CXDiagnostic_DisplayCategoryName: CXDiagnosticDisplayOptions = 32

  opaque type CXCallingConv = Int
  object CXCallingConv extends CEnum[CXCallingConv]:
    val CXCallingConv_Default: CXCallingConv = 0
    val CXCallingConv_C: CXCallingConv = 1
    val CXCallingConv_X86StdCall: CXCallingConv = 2
    val CXCallingConv_X86FastCall: CXCallingConv = 3
    val CXCallingConv_X86ThisCall: CXCallingConv = 4
    val CXCallingConv_X86Pascal: CXCallingConv = 5
    val CXCallingConv_AAPCS: CXCallingConv = 6
    val CXCallingConv_AAPCS_VFP: CXCallingConv = 7
    val CXCallingConv_X86RegCall: CXCallingConv = 8
    val CXCallingConv_IntelOclBicc: CXCallingConv = 9
    val CXCallingConv_Win64: CXCallingConv = 10
    val CXCallingConv_X86_64Win64: CXCallingConv = 10
    val CXCallingConv_X86_64SysV: CXCallingConv = 11
    val CXCallingConv_X86VectorCall: CXCallingConv = 12
    val CXCallingConv_Swift: CXCallingConv = 13
    val CXCallingConv_PreserveMost: CXCallingConv = 14
    val CXCallingConv_PreserveAll: CXCallingConv = 15
    val CXCallingConv_AArch64VectorCall: CXCallingConv = 16
    val CXCallingConv_SwiftAsync: CXCallingConv = 17
    val CXCallingConv_Invalid: CXCallingConv = 100
    val CXCallingConv_Unexposed: CXCallingConv = 200

  opaque type CXEvalResultKind = Int
  object CXEvalResultKind extends CEnum[CXEvalResultKind]:
    val CXEval_Int: CXEvalResultKind = 1
    val CXEval_Float: CXEvalResultKind = 2
    val CXEval_ObjCStrLiteral: CXEvalResultKind = 3
    val CXEval_StrLiteral: CXEvalResultKind = 4
    val CXEval_CFStr: CXEvalResultKind = 5
    val CXEval_Other: CXEvalResultKind = 6
    val CXEval_UnExposed: CXEvalResultKind = 0

  opaque type CXCompletionContext = Int
  object CXCompletionContext extends CEnum[CXCompletionContext]:
    val CXCompletionContext_Unexposed: CXCompletionContext = 0
    val CXCompletionContext_AnyType: CXCompletionContext = 1
    val CXCompletionContext_AnyValue: CXCompletionContext = 2
    val CXCompletionContext_ObjCObjectValue: CXCompletionContext = 4
    val CXCompletionContext_ObjCSelectorValue: CXCompletionContext = 8
    val CXCompletionContext_CXXClassTypeValue: CXCompletionContext = 16
    val CXCompletionContext_DotMemberAccess: CXCompletionContext = 32
    val CXCompletionContext_ArrowMemberAccess: CXCompletionContext = 64
    val CXCompletionContext_ObjCPropertyAccess: CXCompletionContext = 128
    val CXCompletionContext_EnumTag: CXCompletionContext = 256
    val CXCompletionContext_UnionTag: CXCompletionContext = 512
    val CXCompletionContext_StructTag: CXCompletionContext = 1024
    val CXCompletionContext_ClassTag: CXCompletionContext = 2048
    val CXCompletionContext_Namespace: CXCompletionContext = 4096
    val CXCompletionContext_NestedNameSpecifier: CXCompletionContext = 8192
    val CXCompletionContext_ObjCInterface: CXCompletionContext = 16384
    val CXCompletionContext_ObjCProtocol: CXCompletionContext = 32768
    val CXCompletionContext_ObjCCategory: CXCompletionContext = 65536
    val CXCompletionContext_ObjCInstanceMessage: CXCompletionContext = 131072
    val CXCompletionContext_ObjCClassMessage: CXCompletionContext = 262144
    val CXCompletionContext_ObjCSelectorName: CXCompletionContext = 524288
    val CXCompletionContext_MacroName: CXCompletionContext = 1048576
    val CXCompletionContext_NaturalLanguage: CXCompletionContext = 2097152
    val CXCompletionContext_IncludedFile: CXCompletionContext = 4194304
    val CXCompletionContext_Unknown: CXCompletionContext = 8388607

  opaque type CX_StorageClass = Int
  object CX_StorageClass extends CEnum[CX_StorageClass]:
    val CX_SC_Invalid: CX_StorageClass = 0
    val CX_SC_None: CX_StorageClass = 1
    val CX_SC_Extern: CX_StorageClass = 2
    val CX_SC_Static: CX_StorageClass = 3
    val CX_SC_PrivateExtern: CX_StorageClass = 4
    val CX_SC_OpenCLWorkGroupLocal: CX_StorageClass = 5
    val CX_SC_Auto: CX_StorageClass = 6
    val CX_SC_Register: CX_StorageClass = 7

  opaque type CXIdxEntityCXXTemplateKind = Int
  object CXIdxEntityCXXTemplateKind extends CEnum[CXIdxEntityCXXTemplateKind]:
    val CXIdxEntity_NonTemplate: CXIdxEntityCXXTemplateKind = 0
    val CXIdxEntity_Template: CXIdxEntityCXXTemplateKind = 1
    val CXIdxEntity_TemplatePartialSpecialization: CXIdxEntityCXXTemplateKind = 2
    val CXIdxEntity_TemplateSpecialization: CXIdxEntityCXXTemplateKind = 3

  opaque type CXTypeLayoutError = Int
  object CXTypeLayoutError extends CEnum[CXTypeLayoutError]:
    val CXTypeLayoutError_Invalid: CXTypeLayoutError = -1
    val CXTypeLayoutError_Incomplete: CXTypeLayoutError = -2
    val CXTypeLayoutError_Dependent: CXTypeLayoutError = -3
    val CXTypeLayoutError_NotConstantSize: CXTypeLayoutError = -4
    val CXTypeLayoutError_InvalidFieldName: CXTypeLayoutError = -5
    val CXTypeLayoutError_Undeduced: CXTypeLayoutError = -6

  opaque type CXTUResourceUsageKind = Int
  object CXTUResourceUsageKind extends CEnum[CXTUResourceUsageKind]:
    val CXTUResourceUsage_AST: CXTUResourceUsageKind = 1
    val CXTUResourceUsage_Identifiers: CXTUResourceUsageKind = 2
    val CXTUResourceUsage_Selectors: CXTUResourceUsageKind = 3
    val CXTUResourceUsage_GlobalCompletionResults: CXTUResourceUsageKind = 4
    val CXTUResourceUsage_SourceManagerContentCache: CXTUResourceUsageKind = 5
    val CXTUResourceUsage_AST_SideTables: CXTUResourceUsageKind = 6
    val CXTUResourceUsage_SourceManager_Membuffer_Malloc: CXTUResourceUsageKind = 7
    val CXTUResourceUsage_SourceManager_Membuffer_MMap: CXTUResourceUsageKind = 8
    val CXTUResourceUsage_ExternalASTSource_Membuffer_Malloc: CXTUResourceUsageKind = 9
    val CXTUResourceUsage_ExternalASTSource_Membuffer_MMap: CXTUResourceUsageKind = 10
    val CXTUResourceUsage_Preprocessor: CXTUResourceUsageKind = 11
    val CXTUResourceUsage_PreprocessingRecord: CXTUResourceUsageKind = 12
    val CXTUResourceUsage_SourceManager_DataStructures: CXTUResourceUsageKind = 13
    val CXTUResourceUsage_Preprocessor_HeaderSearch: CXTUResourceUsageKind = 14
    val CXTUResourceUsage_MEMORY_IN_BYTES_BEGIN: CXTUResourceUsageKind = 1
    val CXTUResourceUsage_MEMORY_IN_BYTES_END: CXTUResourceUsageKind = 14
    val CXTUResourceUsage_First: CXTUResourceUsageKind = 1
    val CXTUResourceUsage_Last: CXTUResourceUsageKind = 14

  opaque type CXTypeNullabilityKind = Int
  object CXTypeNullabilityKind extends CEnum[CXTypeNullabilityKind]:
    val CXTypeNullability_NonNull: CXTypeNullabilityKind = 0
    val CXTypeNullability_Nullable: CXTypeNullabilityKind = 1
    val CXTypeNullability_Unspecified: CXTypeNullabilityKind = 2
    val CXTypeNullability_Invalid: CXTypeNullabilityKind = 3
    val CXTypeNullability_NullableResult: CXTypeNullabilityKind = 4

  opaque type CXTokenKind = Int
  object CXTokenKind extends CEnum[CXTokenKind]:
    val CXToken_Punctuation: CXTokenKind = 0
    val CXToken_Keyword: CXTokenKind = 1
    val CXToken_Identifier: CXTokenKind = 2
    val CXToken_Literal: CXTokenKind = 3
    val CXToken_Comment: CXTokenKind = 4

  opaque type CXSaveTranslationUnit_Flags = Int
  object CXSaveTranslationUnit_Flags extends CEnum[CXSaveTranslationUnit_Flags]:
    val CXSaveTranslationUnit_None: CXSaveTranslationUnit_Flags = 0

  opaque type CXGlobalOptFlags = Int
  object CXGlobalOptFlags extends CEnum[CXGlobalOptFlags]:
    val CXGlobalOpt_None: CXGlobalOptFlags = 0
    val CXGlobalOpt_ThreadBackgroundPriorityForIndexing: CXGlobalOptFlags = 1
    val CXGlobalOpt_ThreadBackgroundPriorityForEditing: CXGlobalOptFlags = 2
    val CXGlobalOpt_ThreadBackgroundPriorityForAll: CXGlobalOptFlags = 3

  opaque type CXCursor_ExceptionSpecificationKind = Int
  object CXCursor_ExceptionSpecificationKind extends CEnum[CXCursor_ExceptionSpecificationKind]:
    val CXCursor_ExceptionSpecificationKind_None: CXCursor_ExceptionSpecificationKind = 0
    val CXCursor_ExceptionSpecificationKind_DynamicNone: CXCursor_ExceptionSpecificationKind = 1
    val CXCursor_ExceptionSpecificationKind_Dynamic: CXCursor_ExceptionSpecificationKind = 2
    val CXCursor_ExceptionSpecificationKind_MSAny: CXCursor_ExceptionSpecificationKind = 3
    val CXCursor_ExceptionSpecificationKind_BasicNoexcept: CXCursor_ExceptionSpecificationKind = 4
    val CXCursor_ExceptionSpecificationKind_ComputedNoexcept: CXCursor_ExceptionSpecificationKind = 5
    val CXCursor_ExceptionSpecificationKind_Unevaluated: CXCursor_ExceptionSpecificationKind = 6
    val CXCursor_ExceptionSpecificationKind_Uninstantiated: CXCursor_ExceptionSpecificationKind = 7
    val CXCursor_ExceptionSpecificationKind_Unparsed: CXCursor_ExceptionSpecificationKind = 8
    val CXCursor_ExceptionSpecificationKind_NoThrow: CXCursor_ExceptionSpecificationKind = 9


  // opaque type CXErrorCode = Int
  // object CXErrorCode extends CEnum[CXErrorCode]:

  opaque type CXAvailabilityKind = Int
  object CXAvailabilityKind extends CEnum[CXAvailabilityKind]:
    val CXAvailability_Available: CXAvailabilityKind = 0
    val CXAvailability_Deprecated: CXAvailabilityKind = 1
    val CXAvailability_NotAvailable: CXAvailabilityKind = 2
    val CXAvailability_NotAccessible: CXAvailabilityKind = 3

  opaque type CXCodeComplete_Flags = Int
  object CXCodeComplete_Flags extends CEnum[CXCodeComplete_Flags]:
    val CXCodeComplete_IncludeMacros: CXCodeComplete_Flags = 1
    val CXCodeComplete_IncludeCodePatterns: CXCodeComplete_Flags = 2
    val CXCodeComplete_IncludeBriefComments: CXCodeComplete_Flags = 4
    val CXCodeComplete_SkipPreamble: CXCodeComplete_Flags = 8
    val CXCodeComplete_IncludeCompletionsWithFixIts: CXCodeComplete_Flags = 16

  opaque type CXLinkageKind = Int
  object CXLinkageKind extends CEnum[CXLinkageKind]:
    val CXLinkage_Invalid: CXLinkageKind = 0
    val CXLinkage_NoLinkage: CXLinkageKind = 1
    val CXLinkage_Internal: CXLinkageKind = 2
    val CXLinkage_UniqueExternal: CXLinkageKind = 3
    val CXLinkage_External: CXLinkageKind = 4

  opaque type CXPrintingPolicyProperty = Int
  object CXPrintingPolicyProperty extends CEnum[CXPrintingPolicyProperty]:
    val CXPrintingPolicy_Indentation: CXPrintingPolicyProperty = 0
    val CXPrintingPolicy_SuppressSpecifiers: CXPrintingPolicyProperty = 1
    val CXPrintingPolicy_SuppressTagKeyword: CXPrintingPolicyProperty = 2
    val CXPrintingPolicy_IncludeTagDefinition: CXPrintingPolicyProperty = 3
    val CXPrintingPolicy_SuppressScope: CXPrintingPolicyProperty = 4
    val CXPrintingPolicy_SuppressUnwrittenScope: CXPrintingPolicyProperty = 5
    val CXPrintingPolicy_SuppressInitializers: CXPrintingPolicyProperty = 6
    val CXPrintingPolicy_ConstantArraySizeAsWritten: CXPrintingPolicyProperty = 7
    val CXPrintingPolicy_AnonymousTagLocations: CXPrintingPolicyProperty = 8
    val CXPrintingPolicy_SuppressStrongLifetime: CXPrintingPolicyProperty = 9
    val CXPrintingPolicy_SuppressLifetimeQualifiers: CXPrintingPolicyProperty = 10
    val CXPrintingPolicy_SuppressTemplateArgsInCXXConstructors: CXPrintingPolicyProperty = 11
    val CXPrintingPolicy_Bool: CXPrintingPolicyProperty = 12
    val CXPrintingPolicy_Restrict: CXPrintingPolicyProperty = 13
    val CXPrintingPolicy_Alignof: CXPrintingPolicyProperty = 14
    val CXPrintingPolicy_UnderscoreAlignof: CXPrintingPolicyProperty = 15
    val CXPrintingPolicy_UseVoidForZeroParams: CXPrintingPolicyProperty = 16
    val CXPrintingPolicy_TerseOutput: CXPrintingPolicyProperty = 17
    val CXPrintingPolicy_PolishForDeclaration: CXPrintingPolicyProperty = 18
    val CXPrintingPolicy_Half: CXPrintingPolicyProperty = 19
    val CXPrintingPolicy_MSWChar: CXPrintingPolicyProperty = 20
    val CXPrintingPolicy_IncludeNewlines: CXPrintingPolicyProperty = 21
    val CXPrintingPolicy_MSVCFormatting: CXPrintingPolicyProperty = 22
    val CXPrintingPolicy_ConstantsAsWritten: CXPrintingPolicyProperty = 23
    val CXPrintingPolicy_SuppressImplicitBase: CXPrintingPolicyProperty = 24
    val CXPrintingPolicy_FullyQualifiedName: CXPrintingPolicyProperty = 25
    val CXPrintingPolicy_LastProperty: CXPrintingPolicyProperty = 25

  opaque type CXObjCDeclQualifierKind = Int
  object CXObjCDeclQualifierKind extends CEnum[CXObjCDeclQualifierKind]:
    val CXObjCDeclQualifier_None: CXObjCDeclQualifierKind = 0
    val CXObjCDeclQualifier_In: CXObjCDeclQualifierKind = 1
    val CXObjCDeclQualifier_Inout: CXObjCDeclQualifierKind = 2
    val CXObjCDeclQualifier_Out: CXObjCDeclQualifierKind = 4
    val CXObjCDeclQualifier_Bycopy: CXObjCDeclQualifierKind = 8
    val CXObjCDeclQualifier_Byref: CXObjCDeclQualifierKind = 16
    val CXObjCDeclQualifier_Oneway: CXObjCDeclQualifierKind = 32

  opaque type CXDiagnosticSeverity = Int
  object CXDiagnosticSeverity extends CEnum[CXDiagnosticSeverity]:
    val CXDiagnostic_Ignored: CXDiagnosticSeverity = 0
    val CXDiagnostic_Note: CXDiagnosticSeverity = 1
    val CXDiagnostic_Warning: CXDiagnosticSeverity = 2
    val CXDiagnostic_Error: CXDiagnosticSeverity = 3
    val CXDiagnostic_Fatal: CXDiagnosticSeverity = 4

  opaque type CXTLSKind = Int
  object CXTLSKind extends CEnum[CXTLSKind]:
    val CXTLS_None: CXTLSKind = 0
    val CXTLS_Dynamic: CXTLSKind = 1
    val CXTLS_Static: CXTLSKind = 2

  opaque type CXIdxObjCContainerKind = Int
  object CXIdxObjCContainerKind extends CEnum[CXIdxObjCContainerKind]:
    val CXIdxObjCContainer_ForwardRef: CXIdxObjCContainerKind = 0
    val CXIdxObjCContainer_Interface: CXIdxObjCContainerKind = 1
    val CXIdxObjCContainer_Implementation: CXIdxObjCContainerKind = 2

  opaque type CXIndexOptFlags = Int
  object CXIndexOptFlags extends CEnum[CXIndexOptFlags]:
    val CXIndexOpt_None: CXIndexOptFlags = 0
    val CXIndexOpt_SuppressRedundantRefs: CXIndexOptFlags = 1
    val CXIndexOpt_IndexFunctionLocalSymbols: CXIndexOptFlags = 2
    val CXIndexOpt_IndexImplicitTemplateInstantiations: CXIndexOptFlags = 4
    val CXIndexOpt_SuppressWarnings: CXIndexOptFlags = 8
    val CXIndexOpt_SkipParsedBodiesInSession: CXIndexOptFlags = 16
  opaque type CXSymbolRole = Int
  object CXSymbolRole extends CEnum[CXSymbolRole]:
    val CXSymbolRole_None: CXSymbolRole = 0
    val CXSymbolRole_Declaration: CXSymbolRole = 1
    val CXSymbolRole_Definition: CXSymbolRole = 2
    val CXSymbolRole_Reference: CXSymbolRole = 4
    val CXSymbolRole_Read: CXSymbolRole = 8
    val CXSymbolRole_Write: CXSymbolRole = 16
    val CXSymbolRole_Call: CXSymbolRole = 32
    val CXSymbolRole_Dynamic: CXSymbolRole = 64
    val CXSymbolRole_AddressOf: CXSymbolRole = 128
    val CXSymbolRole_Implicit: CXSymbolRole = 256

  opaque type CX_CXXAccessSpecifier = Int
  object CX_CXXAccessSpecifier extends CEnum[CX_CXXAccessSpecifier]:
    val CX_CXXInvalidAccessSpecifier: CX_CXXAccessSpecifier = 0
    val CX_CXXPublic: CX_CXXAccessSpecifier = 1
    val CX_CXXProtected: CX_CXXAccessSpecifier = 2
    val CX_CXXPrivate: CX_CXXAccessSpecifier = 3

  opaque type CXIdxDeclInfoFlags = Int
  object CXIdxDeclInfoFlags extends CEnum[CXIdxDeclInfoFlags]:
    val CXIdxDeclFlag_Skipped: CXIdxDeclInfoFlags = 1

  opaque type CXObjCPropertyAttrKind = Int
  object CXObjCPropertyAttrKind extends CEnum[CXObjCPropertyAttrKind]:
    val CXObjCPropertyAttr_noattr: CXObjCPropertyAttrKind = 0
    val CXObjCPropertyAttr_readonly: CXObjCPropertyAttrKind = 1
    val CXObjCPropertyAttr_getter: CXObjCPropertyAttrKind = 2
    val CXObjCPropertyAttr_assign: CXObjCPropertyAttrKind = 4
    val CXObjCPropertyAttr_readwrite: CXObjCPropertyAttrKind = 8
    val CXObjCPropertyAttr_retain: CXObjCPropertyAttrKind = 16
    val CXObjCPropertyAttr_copy: CXObjCPropertyAttrKind = 32
    val CXObjCPropertyAttr_nonatomic: CXObjCPropertyAttrKind = 64
    val CXObjCPropertyAttr_setter: CXObjCPropertyAttrKind = 128
    val CXObjCPropertyAttr_atomic: CXObjCPropertyAttrKind = 256
    val CXObjCPropertyAttr_weak: CXObjCPropertyAttrKind = 512
    val CXObjCPropertyAttr_strong: CXObjCPropertyAttrKind = 1024
    val CXObjCPropertyAttr_unsafe_unretained: CXObjCPropertyAttrKind = 2048
    val CXObjCPropertyAttr_class: CXObjCPropertyAttrKind = 4096

  opaque type CXRefQualifierKind = Int
  object CXRefQualifierKind extends CEnum[CXRefQualifierKind]:
    val CXRefQualifier_None: CXRefQualifierKind = 0
    val CXRefQualifier_LValue: CXRefQualifierKind = 1
    val CXRefQualifier_RValue: CXRefQualifierKind = 2

  opaque type CXTemplateArgumentKind = Int
  object CXTemplateArgumentKind extends CEnum[CXTemplateArgumentKind]:
    val CXTemplateArgumentKind_Null: CXTemplateArgumentKind = 0
    val CXTemplateArgumentKind_Type: CXTemplateArgumentKind = 1
    val CXTemplateArgumentKind_Declaration: CXTemplateArgumentKind = 2
    val CXTemplateArgumentKind_NullPtr: CXTemplateArgumentKind = 3
    val CXTemplateArgumentKind_Integral: CXTemplateArgumentKind = 4
    val CXTemplateArgumentKind_Template: CXTemplateArgumentKind = 5
    val CXTemplateArgumentKind_TemplateExpansion: CXTemplateArgumentKind = 6
    val CXTemplateArgumentKind_Expression: CXTemplateArgumentKind = 7
    val CXTemplateArgumentKind_Pack: CXTemplateArgumentKind = 8
    val CXTemplateArgumentKind_Invalid: CXTemplateArgumentKind = 9

  opaque type CXIdxEntityRefKind = Int
  object CXIdxEntityRefKind extends CEnum[CXIdxEntityRefKind]:
    val CXIdxEntityRef_Direct: CXIdxEntityRefKind = 1
    val CXIdxEntityRef_Implicit: CXIdxEntityRefKind = 2

  opaque type CXSaveError = Int
  object CXSaveError extends CEnum[CXSaveError]:
    val CXSaveError_None: CXSaveError = 0
    val CXSaveError_Unknown: CXSaveError = 1
    val CXSaveError_TranslationErrors: CXSaveError = 2
    val CXSaveError_InvalidTU: CXSaveError = 3

  opaque type CXIdxAttrKind = Int
  object CXIdxAttrKind extends CEnum[CXIdxAttrKind]:
    val CXIdxAttr_Unexposed: CXIdxAttrKind = 0
    val CXIdxAttr_IBAction: CXIdxAttrKind = 1
    val CXIdxAttr_IBOutlet: CXIdxAttrKind = 2
    val CXIdxAttr_IBOutletCollection: CXIdxAttrKind = 3
  
