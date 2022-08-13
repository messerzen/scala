package lectures.part3fp

object MapFlatmapFilterFor extends App{
  val list: List[Int] = List(1, 2, 3)

  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_  + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List (x, x+1)
  println(list.flatMap(toPair))

  // print all combinations between two lists
  val numbers = List(1, 2, 3, 4)
  val chars = List("a", "b", "c", "d")
  val colors = List("White", "black", "blue")

  // println List("a1", "a2", ..., "d4")

  // two loops -> map inside a flatMap
  // three loops -> map inside a flatMap insde a flatmap
  val combine = numbers.flatMap(n => chars.map(c =>  "" + c + n))
  println(combine)


  // foreach (similar to map)
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  // equivalent to numbers.foreach(println)
  for {
    n <- numbers
  } println(n)

  // synthax overload
  list.map { x =>
    x * 2
  }

  val total = 23
  val msg: String = "Total de ".concat(total.toString).concat(" linhas")
  println(msg)
}
