package stariq.oop

object Objects extends App {

  // Companions

  object Person {
    // Class-level functionality
    val eyes = 2
    def canFly: Boolean = false

    // Factory method
    def apply(mother: Person, father: Person) : Person = new Person("Bob")
  }

  class Person(val name: String) {
    // Instance-level functionality
  }

  println(Person.eyes)
  println(Person.canFly)

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  val bob = Person(mary, john)
}
