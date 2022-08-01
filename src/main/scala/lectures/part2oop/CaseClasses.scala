package lectures.part2oop

object CaseClasses extends App{
  /*
  equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are promoted to fields
  val jim = new Person("Jim", 29)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntatic sugar
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 29)
  println(jim == jim2)

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 45) // we are not using new in this case (apply is running in the object)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns == CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand MyList - use case classes and case objects
   */
}
