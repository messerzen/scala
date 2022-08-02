package lectures.part3fp

object HOFsCurries extends App{

  val superFunction: (Int, (String, (Int => Boolean)) => Int) => (Int => Int) = null
  // Higher order function -> a function that receives another function as a parameter or returns a function
  // map, flatMap, filter

  // function that applies a function n times over a value x
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x)) = f(f(f(x)))
  // nTimes(f, n, x) = f(f(....(x))) = nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int =
    if (n <= 0) x
    else nTimes(f, n-1, f(x))

  val plusOne = (x:Int) => x + 1
  println(nTimes(plusOne, 10, 1))

  // nTimesBetter(f,n) = x => f(f(f...(x)))
  // increment10 = ntb(plusOne,10) = x => plusOne(plusOne ....(x))
  // val y = increment10(1)
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne, 10)
  println(plus10(1))
}
