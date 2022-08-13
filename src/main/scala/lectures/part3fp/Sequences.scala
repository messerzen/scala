package lectures.part3fp

import java.util.Random

object Sequences extends App{

  // Seq
  val aSequence = Seq(1, 4, 3, 2)
  println(aSequence)

  println(aSequence.reverse)
  println(aSequence(2)) // get index 2
  println(aSequence ++ Seq(7,6,8))
  println(aSequence.sorted)

  // Ranges

  val aRange: Seq[Int] = 1 to 10 // until is non-inclusive
  val aRange2: Seq[Int] = 1 until 10
  aRange.foreach(println)
  println('-'*10)
  aRange2.foreach(println)

  println(aRange.map(_ + 2))
  println(aRange.map((x:Int) => x + 3))
  println(aRange.reduce(_ + _))

  // List
  val aList = List(1,2,3)
  val preprended = 43 :: aList
  val preprendedAppended = 43 +: aList :+ 84
  println(preprended)
  println(preprendedAppended)

  val apples5 = List.fill(5)("apple") // curried function
  println(apples5)

  println(aList.mkString("-"))

  //arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[Int](3) // Initalized with default values
  threeElements.foreach(println)

  // mutations
  numbers(2) = 0 // syntax sugar for numbers.update(2,0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq)

  // vector
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // Vector vs Lists

  val maxRuns = 1000
  val maxCapacity = 10000

  def getWriteTime(collection: Seq[Int]): Double = {
  var r = new Random
  val times = for {
    it <- 1 to maxRuns
  } yield {
    val currentTime = System.nanoTime()
    collection.updated(r.nextInt(maxCapacity) , r.nextInt())
    System.nanoTime() - currentTime
  }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail - advantage
  // updaing an element in the middle takes long - disavantage
  println(getWriteTime(numbersList))

  // depth of the tree is small
  // needs to replace an entire 32-elemet chunk
  println(getWriteTime(numbersVector))
}
