package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else {
      println("Computing factorial of " + n + " - I First need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)

      result
    }
  }

  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression
    }
    factorialHelper(n, 1)
  }

  /*
  anotherFactorial(10) = factHelper(10, 1)
  = factorialHelper(9, 10 * 1)
  = factorialHelper(8, 9 * 10 * 1)
  = factorialHelper(7, 8 * 9 * 10 * 1)
  = .....
  = factorialHelper(2, 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
  = factorialHelper(1, 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1)
  = 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1

   */
  println(factorial(10))
  println(anotherFactorial(50))

  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION

  /*
  1. Concatenate a string n times using tail recursion
  2. Prime function tail recursive
  3. Fibonacci function, tail recursive
   */
}
