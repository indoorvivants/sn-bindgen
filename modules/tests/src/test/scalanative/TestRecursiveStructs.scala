package bindgen

import org.junit.Assert.*
import org.junit.Test

import scala.scalanative.unsafe.*
import scala.scalanative.unsigned.*
import lib_test_recursive_structs.structs.Ptr_Recursive_Array

class TestRecursiveStructs:
  import lib_test_recursive_structs.types.*
  @Test def test_simple_recursive(): Unit =
    zone {
      val nested3 = Recrusive_Simple(null, 333.33)
      val nested2 = Recrusive_Simple(nested3, 222.22)
      val nested1 = Recrusive_Simple(nested2, 111.11)
      val nested0 = Recrusive_Simple(nested1, 0.0)

      assertEquals(111.11, (!(!nested0).hello).d, 0.01d)
      assertEquals(222.22, (!(!nested1).hello).d, 0.01d)
      assertEquals(333.33, (!(!nested2).hello).d, 0.01d)
      assertEquals(null, (!nested3).hello)

      (!(!nested0).hello).hello = nested3
      assertEquals(
        nested3.unary_!.d,
        nested0.unary_!.hello.unary_!.hello.unary_!.d,
        0.01d
      )
    }

  @Test def test_array_recursive(): Unit =
    zone {
      val arr = stackalloc[CArray[Ptr[Ptr_Recursive_Array], Nat._3]]()

      val st1 = Ptr_Recursive_Array(null, _ne = 25)
      val st2 = Ptr_Recursive_Array(null, _ne = 26)
      val st3 = Ptr_Recursive_Array(null, _ne = 27)

      (!arr)(0) = st1
      (!arr)(1) = st2
      (!arr)(2) = st3

      val st_all = Ptr_Recursive_Array(!arr, 150)

      assertEquals((!st_all)._ne, 150)
      assertEquals(25, (!(!st_all).opt(0))._ne)
      assertEquals(26, (!(!st_all).opt(1))._ne)
      assertEquals(27, (!(!st_all).opt(2))._ne)
    }

  @Test def test_mutually_recursive(): Unit =
    zone {
      val struct1 = Recrusive_Struct1(null, 1.0)
      val struct2 = Recursive_Struct2(struct1, c"hello")
      val struct3 = Recursive_Struct3(hello_func(null), 25)
      (!struct1).hello = struct3

      assertEquals(1.0, struct1.unary_!.d, 0.01d)
      assertEquals('h', struct2.unary_!.str(0))

    }

  @Test def test_ptr_recursive: Unit =
    zone {

      val structPtr = Ptr_Recursive(25.0, null)
      val struct = !structPtr
      struct.elements = stackalloc[Ptr[Ptr_Recursive]](1)
      struct.elements(0) = structPtr

      assertEquals(structPtr, struct.elements(0))

    }

  @Test def test_recursive_function_pointer(): Unit =
    zone {
      val struct1 = Recursive_Func(0.5, (_: Ptr[Recursive_Func]) => (), 0)

      assertEquals(0.5, (!struct1).d, 0.0001)
      assertEquals(0, (!struct1).freed)

      val struct2 = Recursive_Func(
        0.0,
        { (rec: Ptr[Recursive_Func]) =>
          val deref = !rec
          if deref.d != 0.5 then
            throw new Exception(
              "Something went wrong with passing function pointers - " +
                s"expected 0.5, got ${deref.d} instead"
            )

          deref.freed = 1
        },
        0
      )

      (!struct2).free(struct1)

      assertEquals(1, (!struct1).freed)

      (!struct1).free(struct2)

      assertEquals(0, (!struct2).freed)
    }
end TestRecursiveStructs
