package stariq.oop

object Inheritance extends App {

  // Single class inheritance
  class Animal {
    protected def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch")
    }
  }

  val cat = new Cat
  cat.crunch
}
