package lectures.part2oop

object AbstractDataTypes extends App{
  // abstract
  abstract class Animal { // Abstract classes cannot be instantiated
//    val creatureType: String = "wild" // creature type is not abstract
    val creatureType: String // creature type is abstract
    def eat: Unit
  }

//  val animal = new Animal -> will return error

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("Crunch Crunch") // override is not mandatory for abstract members
  }

  // traits
  trait Carnivore{
    def eat(animal: Animal): Unit // abstract
    val preferredMeal: String = "Meat" // Non abstract
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    val eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"Im a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  /* traits vs abstract classes
   Abstract classes can hold abstract and non abstract members (traits also)
   1 - Traits don't have constructor parameters (In scala 3 is now possible)
   2 - Multiple traits may be inherited by the same class
   3 - traits = behavior (what the thing Do), abstract class = "thing"
   */
}
