package lectures.part2oop

object Exceptions extends App{

  val x: String = null
//  println(x.length)
  // this ^^ will crash with a NPE

  // throwing and catching exceptions
  // 1. how to throw exceptions
//  val aWeirdValue: String = throw new NullPointerException // new -> exceptions are instances of classes

  // throwable classes extends the Throwable class
  // Exceptions and Error are t he major Throwable subtypes

  // 2. how to catch exceptions

  def getInt(withExceptions: Boolean): Int = {
    if (withExceptions) throw new RuntimeException("No int for you")
    else 42
  }
  val potentialFail = try {
    // code that might throw
    getInt(false)
  } catch {
    case e: RuntimeException =>  43 //println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects (logging)
    println("finally")
  }

  println(potentialFail)

  // 3. how to define our own exception
  class MyException extends Exception
  val exception = new MyException
//  throw  exception

  /*
  1. Crash a program with an OutOfMemoryError
  2. Crash with StackOverflowError
  3. Pocket calculator
    - add(x,y)
    - subtract(x,y)
    - multiply(x,y)
    - divide(x,y)

    Throw:
    - OverflowException if add(x,y) exceeds Int.MAX_VALUE
    - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
    - MathCalculationException for division by 0
   */

//  throw new OutOfMemoryError
//  throw new StackOverflowError

  class OverflowError extends RuntimeException
  class UnderflowError extends RuntimeException
  class MathCalculationException extends RuntimeException("Division by zero")

  object PocketCalculator {
    def add(x: Int, y:Int): Int = {
      val result: Int = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowError
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowError
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result: Int = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowError
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowError
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result: Int = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowError
      else if (x < 0 && y < 0 && result < 0) throw new OverflowError
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowError
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowError
      else result
    }
    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

//  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))
  println(PocketCalculator.add(Int.MaxValue, 10))
}
