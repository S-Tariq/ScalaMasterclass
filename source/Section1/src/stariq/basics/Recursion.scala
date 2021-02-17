package stariq.basics

object Recursion extends App {

  // Works with smaller numbers
  def factorial(n : Int): Int = {
    if(n == 1) n
    else {
      println("Computing factorial of " + n + " - First need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computed factorial of " + n)
      result
    }
  }
  println(factorial(10))
  // Stack overflow - does not work with big numbers.
  //println(factorial(5000))

  // Works with bigger numbers
  // The inside function can run on its own without the outside function.
  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x == 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }
    factorialHelper(n , 1)
  }
  // This will return zero because of overflow of Int representation. Change Int to BigInt.
  println(anotherFactorial(5000))

  /*
  Step by step:
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1) The accumulator becomes 10 as it is being passed in as a parameter.
    = factorialHelper(8, 9 * 10) // 9 * 10 * 1
    = factorialHelper(7, 8 * 90) // 8 * 9 * 10 * 1
    = ...
    = factorialHelper(2, 3 * 4 * .. 10 * 1)
    = factorialHelper(1, 2 * 3 * 4 * .. 10 * 1)
    The factorial x is now 1 which enters the if statement and
    returns the accumulator which is already factorial of n
    as it is 1 * 2 * 3 * 4 * ... * 10 (moved the 1 to the front)
   */

  // The reason why the first method factorial fails but the second method anotherFactorial does not fail
  // for big numbers is because in the second method, the recursive method is written as the last expression
  // whereas in the first one, it is not on its own as last expression because it is multiplying by n.
}
