package lectures.part2oop.exercises

import scala.language.postfixOps

object Exercises2 extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hanginOutWith(person: Person): String = s"${this.name} is hanging outr with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging outr with ${person.name}"
    // 1
    def +(nickname: String): Person = new Person(name + s"($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"

    // 2
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)

    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"

    //4
    def apply(times: Int) = s"$name watched $favoriteMovie $times times."

    // 3
    def learns(thing: String): String = s"$name learns $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "The Carry")
  val peter = new Person("Peter", "Fight Club")
  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())
  println(mary.+(peter))

  println((+mary).age )
  val oldMary = +mary

  println(oldMary.age)

  println(mary learnsScala)
  println(mary(2))
  println(mary())

  /*
  1. Overload the + operator
  mary + "the rockstar" => new Person "Mary (the rockstar)"

  2. Add an age to the Person class (default = 0)
    add a unary + operator => new person with age + 1
    +mary = mary with the age incrementer (++)

  3. Add a "learns" method in Person class => "Mary learns Scala"
    Add a learnsScala method , calls learns method with "Scala"
    Use it in postfix notation.

   1. Overload the apply method
      mary.apply(2) => "Mary watched $favoriteMovie 2 times"
   */
}