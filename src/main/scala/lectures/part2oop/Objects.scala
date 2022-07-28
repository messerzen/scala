package lectures.part2oop

object Objects {
  def main(args: Array[String]) {
    // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY ("static")

    // OBJECTS DOES NOT RECEIVE PARAMETERS
    object Person { //type + its only instance
      //    "static"/"class" -> level functionality
      val N_EYES = 2

      def canFly: Boolean = false

      // factory method
//      def apply(mother: Person, father: Person): Person = new Person("Test")
      def apply(name: String): Person = new Person(name)
    }
    class Person(val name: String) {
      // instance-level functionality
    }
    // COMPANIONS -> OBJECT AND CLASS WITH SAME NAME FOR CLASS AND INSTANCE FUNCTIONALITY (samE SCOPE AND NAME)
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val mary = new Person("Mary")
    val peter = new Person("John")
    println(mary == peter)

    val person1 = Person
    val person2 = Person
    println(person1 == person2)

//    val bobbie = Person(mary, peter)
    val bobbie = Person("Bobbie")
    println(bobbie.name)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit

  }
}
