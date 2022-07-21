package lectures.part1basics.exercises

object Exercises extends App{
  /*
  * The solutions of these exercises are in exercises package
  1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  2. Factorial function 1 * 2 * 3 * .. * n
  3. A Fibonacci function
      f(1) = 1
      f(2) = 1
      f(n) = f(n-1) + f(n-2)
  4. Tests if a number is prime
   */

  // 1
  def greetingFunction(name: String, age:Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }

//  println("Answer for Q1:")
//  println(greetingFunction("Paulo", 29))

  // 2
  def factorial(n: Int): Int = {
    if (n == 1) 1
    else (n)*factorial(n-1)
  }

//  println("Answer for Q2:")
//  println(factorial(9))

  // 3
  def fibonnacci(n: Int): Int = {
    if (n <= 2) 1
    else
      fibonnacci(n-1) + fibonnacci(n-2)
  }

//  println("Answer for Q3:")
//  println(fibonnacci(9))

  // 4
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else (n % t != 0) && isPrimeUntil(t - 1)
    }
    isPrimeUntil(n / 2)
  }


//  println("Answer for Q4:")
  val number = 37
//  println("Number " + number + " is prime? R: " + isPrime(number))

  /*
1. Concatenate a string n times using tail recursion
2. Prime function tail recursive
3. Fibonacci function, tail recursive
 */

  // TAIL_REC EXERCISES
//  1. Concatenate a string n times using tail recursion
  def greetingsRecursive(name: String, n: Int): String = {
    def helperGreetings(x: Int, accumString: String): String = {
      if(x == 1) accumString
      else
        helperGreetings(x - 1, accumString + name)
    }
    helperGreetings(n, name)
  }

  println(greetingsRecursive("Paulo",5))


  def isPrime2(n: Int): Boolean = {
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t-1, (n % t != 0) && (isStillPrime))
    }
    isPrimeTailRec(n / 2, true)
  }

//  3. Fibonacci function, tail recursive

  def fibonacciTail(n: Int): Int = {
    def helpFibbo(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else helpFibbo(i + 1, last + nextToLast, last)
    }
    if(n <= 2) 1
    else helpFibbo(2, 1, 1)
  }

  println(fibonacciTail(4))
  }
