package lectures.part1basics

object CallByNameValue extends App{
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = { // => REPRESENTS CALL BY NAME
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime()) // The parameters are evaluated before evaluate de code block (equal other languages)
  calledByName(System.nanoTime()) // The parameters are passed literally as is (by name).

  // BY VALUE -> THE PARAMETER IS EVALUATED ONCE -> Equivalent to calledByValue(8915398310930L)
  // BY NAME -> THE PAREMETER IS EVALUATED EVERY TIME IS CALLED -> Equivalent to calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int): Unit = println(x)

//  printFirst(infinite(), 34) // Crash with STACK OVERFLOW error
  printFirst(34, infinite()) // Infinite is not evaluated
}
