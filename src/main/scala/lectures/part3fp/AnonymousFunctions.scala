package lectures.part3fp

object AnonymousFunctions extends App {
  // anonymous function
    val doubler = (x: Int) => x * 2

//  val doubler: Int => Int = (x: Int) => x * 2
//  val doubler: Int => Int = x => x * 2

  // multiple parameters
//  val adder: (Int,Int) => Int = (a: Int, b:Int) => a + b
  val adder = (a: Int, b:Int) => a + b

  // no params
  val justDoSomething = () => 3

  // CAREFUL
  println(justDoSomething)  // function itself
  println(justDoSomething()) // call

  // curly braces with lambdas
  val stringToInt = {(str: String) =>
    str.toInt
  }

  // MOAR syntatic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalent to (x: Int) => x + 1

  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a + b

  /*
  1. MyList: replace all FunctionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous function
   */

  val specialAdder = (x: Int) => (y: Int) => x + y
  println(specialAdder(2)(5))

  println(assert(specialAdder(2)(5) == 7))
}
