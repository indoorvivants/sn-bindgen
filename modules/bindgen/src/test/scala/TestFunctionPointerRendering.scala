package bindgen

import org.junit.Assert.*
import org.junit.Test

import bindgen.rendering.*

class TestFunctionPointerRendering:

  // Helper to create a minimal Config for testing
  given Config = Config.withDefaults()

  // Helper to create a minimal AliasResolver for testing
  given AliasResolver = AliasResolver(_ => CType.Void)

  @Test def test_function_pointer_parameter_rendering(): Unit =
    // Test case for issue #378: function pointer parameters should be rendered as
    // "void (*callback)(void *)" not "void (*)(void *) callback"

    val lb = LineBuilder()
    val line: Appender = s => lb.appendLine(s)

    val funcPtrParam = FunctionParameter(
      name = "callback",
      typ = CType.Function(
        CType.Void,
        List(CType.Parameter(None, CType.Pointer(CType.Void)))
      ),
      originalTyp = OriginalCType(
        CType.Function(
          CType.Void,
          List(CType.Parameter(None, CType.Pointer(CType.Void)))
        ),
        "void (*)(void *)" // This is what libclang returns
      ),
      generatedName = false
    )

    val func: GeneratedFunction.CFunction = GeneratedFunction.CFunction(
      name = CFunctionName("test_func"),
      returnType = CType.Void,
      originalCType = OriginalCType(CType.Void, "void"),
      arguments = List(funcPtrParam),
      body = CFunctionBody.Delegate(
        to = CFunctionName("original_func"),
        dereference = Set.empty,
        returnAsWell = false
      )
    )

    cFunctionForwarder(func, line)

    val result = lb.result
    // Should contain "void (*callback)(void *)" not "void (*)(void *) callback"
    assertTrue(
      s"Expected 'void (*callback)(void *)' in output, but got: $result",
      result.contains("void (*callback)(void *)")
    )
    assertFalse(
      s"Should not contain 'void (*)(void *) callback' in output, but got: $result",
      result.contains("void (*)(void *) callback")
    )
  end test_function_pointer_parameter_rendering

  @Test def test_non_function_pointer_parameter_unchanged(): Unit =
    // Ensure regular (non-function-pointer) parameters still work

    val lb = LineBuilder()
    val line: Appender = s => lb.appendLine(s)

    val regularParam = FunctionParameter(
      name = "value",
      typ = CType.NumericIntegral(IntegralBase.Int, SignType.Signed),
      originalTyp = OriginalCType(
        CType.NumericIntegral(IntegralBase.Int, SignType.Signed),
        "int"
      ),
      generatedName = false
    )

    val func: GeneratedFunction.CFunction = GeneratedFunction.CFunction(
      name = CFunctionName("test_regular_func"),
      returnType = CType.Void,
      originalCType = OriginalCType(CType.Void, "void"),
      arguments = List(regularParam),
      body = CFunctionBody.Delegate(
        to = CFunctionName("original_regular_func"),
        dereference = Set.empty,
        returnAsWell = false
      )
    )

    cFunctionForwarder(func, line)

    val result = lb.result
    assertTrue(
      s"Expected 'int value' in output, but got: $result",
      result.contains("int value")
    )
  end test_non_function_pointer_parameter_unchanged

end TestFunctionPointerRendering
