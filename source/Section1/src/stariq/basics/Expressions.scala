package stariq.basics

object Expressions extends App {

  val x = 1 + 2
  println(x)

  // Math operator
  println(2 + 3 * 4)

  // Relational operator
  println(1 == x)

  // Boolean operator
  println(!(1 == x))

  var aVariable = 2
  aVariable += 3 // side effect
  println(aVariable)

  // IF expression
  val aCondition = true
  val aConditionedVal = if(aCondition) 5 else 3
  println(aConditionedVal)

  println(if(aCondition) 5 else 3)

  // While loop returns unit - DISCOURAGED
  var i = 0
  val aWhile = while(i < 10) {
    println(i)
    i += 1
  }

  // Side effects: println(), while, reassignment.
  // Returns unit.
  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)


  // Code block
  // Returns string
  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if(z > 2) "hello" else "goodbye"
  }
  // Returns int
  val anotherCB = {
    val condition: Boolean = true
    if(condition) 42 else 0
  }

  // Exercise:
  // 1. Difference between "hello world" vs println("hello world")?
  // The first one is type string and it is a value.
  // The second one is type unit and it is a side effect.
  // 2. Evaluate the following:

  // This one returns true (boolean) as that is the last and only expression inside the code block.
  val someValue = {
    2 < 3
  }
  println(someValue)

  // This one returns 42 (int) as that is the last expression inside the code block.
  // The if statement is useless.
  val anotherValue = {
    if(someValue) 239 else 976
    42
  }
  println(anotherValue)

}
