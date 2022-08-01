package lectures.part2oop

object Generics extends App{
  class MyList[+A] { // [A] -> generic type
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = CAT
    B = DOG = animal
     */
  }

  class MyMap[Key, Value]

  trait MyList2[A]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A] // A+ -> represents COVARIANCE
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // animalList.add(new Dog)??? HARD QUESTION. => we return a list o animals


  // 2. NO = INVARIANCE
  class InvariantList[A]
//  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Cat] // error
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal] // error

  // 3. Hell, no! CONTRAVARIANCE
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]


  // bounded types
  class Cage[A <: Animal](animal: A) // Only accepts subclasses of animal (<:Animal) or Only accepts subclasses of animal (>:Animal)
  val cage = new Cage(new Dog)

  class Car
//  val newCage = new Cage(new Car) // compile error




}
