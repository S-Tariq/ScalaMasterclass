package stariq.oop

object MethodNotations extends App {

  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = {
      movie == favouriteMovie
    }
    def +(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}."
    }
    def +(nickname: String): Person =  {
      new Person(s"$name ($nickname)", favouriteMovie)
    }
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie."
    def apply(n: Int): String = s"$name watched $favouriteMovie $n times."
    def learns(thing: String) = s"$name is learning $thing."
    def learnsScala() = this learns "Scala" // learns("Scala")
  }

  val mary = new Person("Mary", "Inception")

  // Infix/operator notation
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  // "Operators"
  val tom = new Person("Tom", "Fight club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  // All operators are methods.

  // Prefix notation - only works with - + ~ !
  val x = -1
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  // Postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary())

  /*
  Exercise:
  1. Overload the + operator
      mary + "the rockstar" => new person "Mary (the rockstar)"

  2. Add an age to the Person class
      Add a unary + operator => new person with the age + 1
      +mary => mary with the age incrementer

  3. Add a "learns" method in the Person class => "Mary learns Scala"
      Add a learnsScala method, calls learns method with "Scala"
      Use it in postfix notation

  4. Overload the apply method
      mary.apply(2) => "Mary watched Inception 2 times"
   */

  // Calls the apply method on the new person object created by the overloaded + method.
  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())

  // Returns age incremented by the unary_+ method.
  println((+mary).age)

  // Calls the learns method with Scala passed in.
  println(mary learnsScala)

  // Calls the overloaded apply method which takes in n.
  println(mary(10))
  println(mary.apply(10))
}
