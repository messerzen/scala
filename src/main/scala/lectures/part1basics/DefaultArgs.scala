package lectures.part1basics

object DefaultArgs extends App{

  def trFact(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFact(n-1, n*acc)
  }

  val fact10 = trFact(10, 2)

  def savePicture(format: String = "jpg", width: Int = 800, height: Int = 600): Unit = println("saving picture")
//  savePicture(800)
  savePicture(width = 800)
  /*
  1. pass every leading argument ("bpm")
  2. name the arguments (width=800)
   */

  savePicture(height = 600, width = 500, format="bmp")

}
