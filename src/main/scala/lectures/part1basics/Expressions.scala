package lectures.part1basics

object Expressions extends App{
  val x  = 1 + 2 // 1+2 is an Expression. Expressions are evaluated to a value and has a type (Int in this case)
  println(x)

  println(2 + 3 * 4) // math expression
  // + - * / & | ^ << >> >>>(right shift with zero extension)

  println(1 == x) // evaluated to a boolean
  // ==  !=  >  >=  <  <=

  println(!(1 == x))
  // !  &&  ||

  var aVariable = 2
  aVariable += 3 // also works with -=  *=  /= (only works with variable -> var) .... side effects
  println(aVariable)

  // Instructions(something that we tell the computer to do -> Imperative paradigm) -> ARE EXECUTED
  // vs
  // Expressions(Somenthing that has a value and a type. Everything computes a value) -> ARE EVALUATED

  // IF  Expression

  val aCondition = true

  val aConditionValue = if(aCondition) 5 else 3 // IF EXPRESSION (NOT INSTRUCTION like Imperative)
  println(aConditionValue)
  println(if(aCondition) 5 else 3) // evaluated to 5 like (1+3) is evaluated to 4

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS WHILE AGAIN.

  // EVERYTHING in Scala is an Expression!

  val aWeirdvalue = (aVariable  = 3) // Unit == VOID
  println(aWeirdvalue) // The only value Unit type can hold is ()

  // SIDE EFFECTS IN SCALA ARE EXPRESSIONS RETURNING UNIT

  // side effects example: println(), whiles, reassigning

  // Code blocks -> Special kinds of expressions

  val aCodeBlock = {
    val y = 2

    val z = y + 2
    if (z > 2) "hello" else "goodbye"
  } // a code block is an expression
  // A value of a a block is the value of its last expression

  // 1. Difference between "hello world" vs println("hello world")?
  // R: Hello World is a value evaluated as String type
  // and println("hello world") is an expression evaluated as Unit

  val someValue ={
    2 < 3
  }
  // 2.What is the value of "someValue". R: True

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  // 2.What is the value of "someOtherValue". R: 42

}
