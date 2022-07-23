package lectures.part2oop.exercises

object Exercises1 extends App{
  val pauloAuthor = new Writer("Paulo", "Zen", 1992)
  val impostor = new Writer("Paulo", "Zen", 1992)
  val myNovel = new Novel("ScalaNovel", 2022, pauloAuthor)
//  println(pauloAuthor.fullName)

//  println(myNovel.authorAge)
//  println(myNovel.isWrittenBy(impostor))

//  val myNovelRemasted = myNovel.copy(2024)
//  println(myNovel.releaseYear)
//  println(myNovelRemasted.releaseYear)

  // Counter
  val myCounter = new Counter()
  myCounter.inc.print
  myCounter.inc.inc.inc.print
  myCounter.inc(10).print


//  println(myNewCounter.currentCount)
//
//  println(myNewCounter.changeAmount(5))
//  println(myNewCounter.changeAmount(20, decrease = true))


}

/*
Novel and a Writer
Writer: first name, surname, year
  - method fullname
Novel: name, year of release, author (instance o writer)
  - authorAge
  - isWrittenBy(author)
  - copy (new year of release) = new instance of Novel
 */

class Writer(firstName: String, surname: String, val year: Int){
  def fullName(): String = {
    this.firstName + " " + this.surname
  }
}

class Novel(name: String, val releaseYear: Int, author: Writer) {
  def authorAge(): Int = releaseYear - author.year
  def isWrittenBy(author: Writer) = author == this.author

  def copy(newReleaseYear: Int) = new Novel(this.name, newReleaseYear, this.author)
}
/*
Counter class
- receives an Int value
- method current count
- method to increment/decrement => new Counter
- overload int/dec to receive an amount
*/

class Counter(val number: Int= 0){
  def currentCount(): Int = number

  def inc() = {
    println("Incermenting")
    new Counter(number + 1)
  } // immutability

  // wherever is the modifications that we need to make to an instance, we need to return a new instance
  def dec() = {
    println("Decrementing")
    new Counter(number - 1)
  }
  // overload
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }
  def dec(n: Int): Counter = {
    if (n<=0) this
    else dec.dec(n-1)
  }

  def print = println(currentCount)

}


// OBS: when we define a VAL for a class parameter is equivalent to define a "getter"
