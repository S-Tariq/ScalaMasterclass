package stariq.oop

import java.time.Year

/*
Novel and Writer

Writer: first name, surname, year
- method fullname

Novel: name, year of release, author
- method authorAge
- method isWrittenBy(author)
- method copy (new year of release) - new instance of Novel
 */

/*
Counter class:
- receives an int value
- method current count
- method to increment/decrement - new Counter
-overload inc/dec to receive an amount
 */

object OOExercise extends App {

  val author = new Writer("Sam", "Ben", 1999)
  val imposter = new Writer("Sam", "Ben", 1999)
  val novel = new Novel("Great expectations", 2021, imposter)

  println(novel.authorAge())
  // Imposter has same data as author but it returns false as it checks the object reference.
  println(novel.isWrittenBy(author))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print
}

class Writer(firstName: String, surname: String, val year: Int) {
  def fullName(): String = {
    firstName + " " + surname
  }
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge(): Int = {
    year - author.year
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(newYear: Int): Novel = {
    new Novel(name, newYear, author)
  }
}

class Counter(val count: Int = 0) {
  // All methods are immutable.
  def increment = new Counter(count + 1)
  def decrement = new Counter(count - 1)

  // If the methods are used for logging where each event needs to be tracked,
  // you can write a recursive method rather than the following method which skips steps
  // and directly increments/decrements it by n.
//  def increment(n: Int) = new Counter(count + n)
//  def decrement(n: Int) = new Counter(count - n)

  def increment(n: Int): Counter = {
    if(n <= 0) this
    else increment.increment(n - 1)
  }

  def decrement(n: Int): Counter = {
    if(n <= 0) this
    else decrement.decrement(n - 1)
  }

  def print = println(count)

}
