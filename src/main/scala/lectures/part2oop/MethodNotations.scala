package lectures.part2oop

import scala.language.postfixOps

object MethodNotations extends App{

  class Person(val name: String, favoriteMovie: String){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hanginOutWith(person: Person): String = s"${this.name} is hanging outr with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging outr with ${person.name}"
    def unary_! : String = s"$name, what the heck?!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi my name is $name and I like $favoriteMovie"


  }

  val paulo = new Person("Paulo", "Pulp Fiction")
  println(paulo.likes("Pulp Fiction"))
  println(paulo likes "Inception") // equivalent
  // infix notation = operator notation (syntatic sugar)-> It only works with methods with one parameter

  // "operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(paulo hanginOutWith tom)
  println(paulo + tom)
  println(paulo.+(tom))

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS
  // Akka actors have ! ?


  // Prefix notation

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  // unary_- only works with few operators: - + ~ !
  println(!tom)
  println(tom.unary_!)

  // Postfix notation -> Only works with methods without parameters
  println(tom.isAlive)
  println(tom isAlive)

  // apply
  println(tom.apply())
  println(tom()) // equivalent -> Object called like a function it looks for a definition of apply in that particular class

}
