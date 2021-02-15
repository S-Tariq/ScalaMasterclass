package stariq.basics

object Functions extends App {

  def aFunction(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("a", 3))

  def aBigFunction(n: Int): Int = {
    def aSmallFunction(a: Int, b: Int): Int = a + b
    aSmallFunction(n, n-1)
  }
  println(aBigFunction(6))

  /*
    1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
    2. Factorial function 1 * 2 * 3 * .. * n (Recursive)
    3. A Fibonacci function (Recursive)
        f(1) = 1
        f(2) = 1
        f(n) = f(n - 1) + f(n - 2)
    4. Tests if a number is prime
   */

  def greeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  println(greeting("Tim", 12))

  def factorial(n : Int): Int = {
    if(n == 1) n
    else n * factorial(n-1)
  }
  println(factorial(5))

  def fibonacci(n: Int): Int = {
    if(n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(37)) // Prime
  println(isPrime(2003)) // Prime
  println(isPrime(37 * 17)) // Not prime

  // Another way of solving:
  def isPrime2(n: Int): Boolean = {
    Range(2,n) forall(x => n % x != 0)
  }
  println(isPrime2(37)) // Prime
  println(isPrime2(2003)) // Prime
  println(isPrime2(37 * 17)) // Not prime
}
