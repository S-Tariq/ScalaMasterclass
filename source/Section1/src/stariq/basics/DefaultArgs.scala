package stariq.basics

object DefaultArgs extends App {

  // Tail recursion of factorial
  def factorial(n: Int, acc: Int = 1): Unit = {
    if(n <= 1) acc
    else factorial(n - 1, n * acc)
  }

  // The accumulator starts with 1 for every single factorial n.
  // This can be defined at parameter level.
  val fact10 = factorial(10)

  def savePicture(format: String, width: Int, height: Int): Unit = print("Saving picture")
}
