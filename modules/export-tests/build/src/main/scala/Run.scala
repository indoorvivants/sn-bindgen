import scalanative.unsafe.*

@extern 
def my_tests(): Unit = extern

@main def run_tests = 
  my_tests()
  println("export tests finished successfully!")
