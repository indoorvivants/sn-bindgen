package bindgen

import org.junit.Assert.*
import org.junit.Test

import bindgen.rendering.*

class TestCFunctionForwarder:

  // Helper to create a minimal Config for testing
  given Config = Config.withDefaults()

  // Helper to create a minimal AliasResolver for testing
  given AliasResolver = AliasResolver(_ => CType.Void)

  @Test def test_array_parameter_rendering(): Unit =
    // Test case for issue #379: array parameters should be rendered as
    // "int64_t bounds[4]" not "int64_t[4] bounds"

    val lb = LineBuilder()
    val line: Appender = s => lb.appendLine(s)

    val arrayParam = FunctionParameter(
      name = "bounds",
      typ = CType.Arr(
        CType.NumericIntegral(IntegralBase.LongLong, SignType.Signed),
        Some(4)
      ),
      originalTyp = OriginalCType(
        CType.Arr(
          CType.NumericIntegral(IntegralBase.LongLong, SignType.Signed),
          Some(4)
        ),
        "int64_t[4]" // This is what libclang returns
      ),
      generatedName = false
    )

    val func: GeneratedFunction.CFunction = GeneratedFunction.CFunction(
      name = CFunctionName("test_func"),
      returnType = CType.Void,
      originalCType = OriginalCType(CType.Void, "void"),
      arguments = List(arrayParam),
      body = CFunctionBody.Delegate(
        to = CFunctionName("original_func"),
        dereference = Set.empty,
        returnAsWell = false
      )
    )

    cFunctionForwarder(func, line)

    val result = lb.result
    // Should contain "int64_t bounds[4]" not "int64_t[4] bounds"
    assertTrue(
      s"Expected 'int64_t bounds[4]' in output, but got: $result",
      result.contains("int64_t bounds[4]")
    )
    assertFalse(
      s"Should not contain 'int64_t[4] bounds' in output, but got: $result",
      result.contains("int64_t[4] bounds")
    )
  end test_array_parameter_rendering

  @Test def test_multidimensional_array_parameter_rendering(): Unit =
    // Test multi-dimensional arrays like int[10][20]

    val lb = LineBuilder()
    val line: Appender = s => lb.appendLine(s)

    val arrayParam = FunctionParameter(
      name = "matrix",
      typ = CType.Arr(
        CType.Arr(CType.NumericIntegral(IntegralBase.Int, SignType.Signed), Some(20)),
        Some(10)
      ),
      originalTyp = OriginalCType(
        CType.Arr(
          CType.Arr(CType.NumericIntegral(IntegralBase.Int, SignType.Signed), Some(20)),
          Some(10)
        ),
        "int[10][20]"
      ),
      generatedName = false
    )

    val func: GeneratedFunction.CFunction = GeneratedFunction.CFunction(
      name = CFunctionName("test_matrix_func"),
      returnType = CType.Void,
      originalCType = OriginalCType(CType.Void, "void"),
      arguments = List(arrayParam),
      body = CFunctionBody.Delegate(
        to = CFunctionName("original_matrix_func"),
        dereference = Set.empty,
        returnAsWell = false
      )
    )

    cFunctionForwarder(func, line)

    val result = lb.result
    // Should contain "int matrix[10][20]" not "int[10][20] matrix"
    assertTrue(
      s"Expected 'int matrix[10][20]' in output, but got: $result",
      result.contains("int matrix[10][20]")
    )
    assertFalse(
      s"Should not contain 'int[10][20] matrix' in output, but got: $result",
      result.contains("int[10][20] matrix")
    )
  end test_multidimensional_array_parameter_rendering

  @Test def test_non_array_parameter_unchanged(): Unit =
    // Ensure regular (non-array) parameters still work

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
  end test_non_array_parameter_unchanged

end TestCFunctionForwarder
