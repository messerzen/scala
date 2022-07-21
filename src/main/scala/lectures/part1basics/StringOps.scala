package lectures.part1basics

object StringOps extends App{

  val str: String = "Hello, I am learning scala"

  println(str.charAt(2)) // zero index
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace("Hello", "Hi"))

  println(str.toLowerCase())
  println(str.toUpperCase)
  println(str.length)

  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString) // PREPENDING 'a' to aNumberString
  println(aNumberString :+ 'z') // APPENDING 'a' to aNumberString
  println(str.reverse)
  println(str.take(2))

  // SCALA SPECIFIC: String Interpolators

  // S-interpolation
  val name = "David"
  val age = 29
  val greeting = s"Hello, my name is $name and I am $age years old."
  println(greeting)
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1}"
  println(anotherGreeting)

  // F-Interpolators

  val speed = 1.5f
  val myth = f"$name can eat $speed%2.2f burgers per minute" // $2.2f  -> 2. (characteres total, minimum) 2 (decimal precision)
  println(myth)

  // raw - Interpolator (like s interporlator)
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"

  println(raw"$escaped") // scala ignores scaped characters inside raw characters in the string
}
