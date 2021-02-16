package stariq.basics

object Recursion extends App {

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
  //println(factorial(5000)) // Stack overflow

  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x == 1) accumulator
      else factorialHelper(x - 1, x * accumulator)
    }
    factorialHelper(n , 1)
  }
  // This returns zero because of overflow of Int representation. Change Int to BigInt.
  println(anotherFactorial(5000))

  /*
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
}
