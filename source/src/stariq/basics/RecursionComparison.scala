package stariq.basics

import scala.annotation.tailrec

// Recursion vs Tail Recursion
object RecursionComparison extends App {

  // Recursion
  def concat(s: String, n: Int): String = {
    if(n == 1) s
    else s + concat(s, n - 1)
  }
  println(concat("a", 3)) //aaa

  // Tail recursion
  def concat2(s: String, n: Int): String = {
    @tailrec
    def concatHelper(s: String, n: Int, accumulator: String): String = {
      if(n == 1) accumulator
      else concatHelper(s, n - 1, s + accumulator)
    }
    concatHelper(s, n, s)
  }
  println(concat2("a",3)) //aaa

  // Recursion
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime(7)) //true

  // Tail recursion
  def isPrime2(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      @tailrec
      def primeHelper(t: Int, accumulator: Boolean): Boolean = {
        if(t <= 1) accumulator
        else primeHelper(t - 1, n % t != 0 && accumulator)
      }
      primeHelper(t, true)
    }
    isPrimeUntil(n / 2)
  }
  println(isPrime2(7)) //true

  // Recursion
  def fibonacci(n: Int): Int = {
    if(n == 1 || n == 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  println(fibonacci(8)) //21

  // Tail recursion
  def fibonacci2(n: Int): Int = {
    @tailrec
    def fibHelper(i: Int, accumulator1: Int, accumulator2: Int): Int = {
      if(i >= n) accumulator1
      else fibHelper(i + 1, accumulator1 + accumulator2, accumulator1)
    }
    if(n == 1 || n == 2) 1
    else fibHelper(2, 1, 1)
  }
  println(fibonacci2(8)) //21



}
