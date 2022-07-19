package lectures.part1basics

object ValuesVariablesTypes extends App{
  val x: Int = 64
  println(x)
   // x = 1 VALs ARE IMMUTABLE
  val y = 64 // Types are optional -> COMPILE Type inference

  // val aString: String = "hello"; val anotherString = "Another string" // BAD STYLE
  val aString: String = "hello"
  val anotherString = "Another string"

  val aBoolean: Boolean = true // false
  val aChar: Char = 'a'
  val aInt: Int = x // 4 bytes
  val aShort: Short = 4613 // Integer types with limit -> 2 bytes
  val aLong: Long = 4531564533124865L // Integer types with double of representation -> 8 bytes
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // Variables -> They can be reassigned -> Side effects
  var aVariable: Int = 4
  aVariable = 5 // Side effects







}
