package lectures.part2oop

object Inheritance extends App{

  // SUBCLASS only heritance NON-PRIVATE MEMBERS
  // Single class inheritance -> One class heritance at a time

//final class Animal { // prevents the entire class to be extend

      sealed class Animal {

//    private def eat = println("nomnomnom") // only accessed by ANIMAL CLASS
      val creatureType = "wild"

//      protected def eat = println("nomnomnom") // only used within this class only and within subclasses
// but not accessable outsite the class
//    def eat = println("nomnomnom") // only used within this class only and within subclasses
    def eat = println("nomnomnom") // prevents derived classes from overriding eat method

  }

  class Cat extends Animal{ //
    def crunch = {
      eat
      println("crunch crunch")
    }
  } // Cat subclass | Animal Superclass

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

//  // overriding
//  class Dog(override val creatureType: String) extends Animal {
////    override val creatureType: String = "domestic" // overriding a val
//    override def eat = println("crunch, crunch")
//  }
//
  // another implementation

//  class Dog(animalType: String) extends Animal {
//    override val creatureType: String = animalType
//    override def eat = println("crunch, crunch")
//  }

  class Dog(animalType: String) extends Animal {
    override val creatureType: String = animalType

    override def eat = {
      super.eat // SUPER -> refer to the method Eat in the superclass
      println("crunch, crunch")
    }
  }

  val dog = new Dog("k9")
  dog.eat
  println(dog.creatureType)


  // type substitution (BROAD: POLYMORPHISM)
  val unknowAnimal: Animal = new Dog("K9")
  unknowAnimal.eat

  // oveRIDING -> supplying a different implementation in derived classes
  // overLOADING -> multiple methods with different signatures with same name in the same class


  // Super

  // preventing overrides
  // 1 -> use "final" on member
  // 2 -> use "final" on class
  // 3 -> seal the class = extends classes in THIS FILE, prevent extension in other files
}
