package lectures.part2oop

object OOBasics extends App{
  val person = new Person("Paulo", 26)
//  println(person.age)
  println(person.x)

  person.greet("Joao")
  person.greet
}

// Class constructor
class Person(name: String, val age: Int = 0) {
  // Body
  val x = 2 // a val or var implementation inside a class body is A FIELD

  println(1 + 3)

  // method
  def greet(name: String): Unit = println(s"${this.name} says Hi: $name")

  // overloading
  def greet(): Unit = println(s"Hi, I am ${name}") // name is implied to be the class argument (name = this.name)
//  def greet(): Int = 42 -> methods with same name and same parameters cannot return different types

  // multiple constructors
//  def this(name: String) = this(name, 0) // It can be solved with default parameters in class signature class Person(name: String, val age: Int = 0)
//  def this() = this("Paulo")
}



// Class parameters ARE NOT FIELDS
// Class parameters: Person(name: String, age: Int)
// Class fields: Person(name: String, val age: Int) -> with val (or var) we convert class parameters to class fiedls
