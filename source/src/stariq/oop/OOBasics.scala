package stariq.oop

object OOBasics extends App {

  val person = new Person("John", 26)
  println(person.x)
  person.greet("Sam")
  person.greet()
}

// Class parameters are NOT fields.
// Constructor
class Person(name: String, val age: Int) {
  // Body
  val x = 2
  println(1 + 3)

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading
  def greet(): Unit = println(s"Hi, I am $name")

  def this(name: String) = this(name, 0)
}
