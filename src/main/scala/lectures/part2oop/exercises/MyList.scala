package lectures.part2oop.exercises

abstract class MyList {
  /*
  head = first element of the list
  tail = remainder of the list
  isEmpty = is this list empty?
  add(int) => new list with this element added
  toString => a string representation of the list
   */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(int: Int): MyList
  def printElements: String
  // polymorphic call
  override def toString: String = "[" + printElements + "]" // needs to be overrided beacuse toString is present in AnyClass
}

object Empty extends MyList{
  def head: Int = throw new scala.NoSuchElementException
  def tail: MyList = throw new scala.NoSuchElementException
  def isEmpty: Boolean = true
  def add(int: Int): MyList = new Cons(int, Empty)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(int: Int): MyList = new Cons(int, this)

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
  }
}

object ListTest extends App{
  val list = new Cons(1, new Cons (2, new Cons(3, Empty)))
  println(list.tail.head)
  println(list.add(4).head)
  println(list.isEmpty)


  println(list.toString)

}
