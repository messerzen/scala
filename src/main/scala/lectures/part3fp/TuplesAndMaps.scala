package lectures.part3fp

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "Scala") // Tuple2[Int,String] = (Int, String)
  val anotherTuple = (2, "Scala", 3.65)

  println(aTuple._1) // first element
  println(aTuple.copy(_2 = "goodbye Java")) // modify but no in place
  println(aTuple)

  println(aTuple.swap) // change de order

  // Maps - keys => values
  val aMap: Map[String, Int] = Map("Paulo" -> 29, "Nathy" -> 29)
  println(aMap)
  println(aMap.get("Paulo"))

  val phoneBook = Map(("Paulo", 48), ("Nathy", 48))
  val phoneBookWithDefault = Map(("Paulo", 48), ("Nathy", 48)).withDefaultValue(-1)
  println(phoneBook)

  // a -> b is sugar for (a,b)
  println(phoneBook)

  // map ops

  println(phoneBook.contains("Jim"))
  println(phoneBook.contains("Paulo"))
  println(phoneBook.apply("Paulo")) // only if key exists
  println(phoneBookWithDefault.apply("Jim"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functions on maps
  // map, flatMap, filter

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phoneBook.view.filterKeys(x => x.startsWith("P")).toMap)

  // mapValues
  println(phoneBook.view.mapValues(number => number * 100).toMap)

  // conversions
  println(phoneBook.toList)
  println(List(("Daniel", 555)).toMap)

  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  // Strava

  val myMap = Map(("Activity", "Ride"), ("Distance", 24000), ("Name", "Morning Ride"))

  println(myMap)
  println(myMap.get("Activity"))


}
