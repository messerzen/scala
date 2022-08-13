package lectures.part3fp

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App{
  // create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("SUPER FAILURE"))

  println(aSuccess)
  println(aFailure)


  def unsafeMethod(): String = throw new RuntimeException("NO STRING FOR YOU BUSTER")

  // Try objects via the apply methods
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntax sugar
  val anotherPotentialFailure = Try {
    // code might throw
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid result"

  val fallBackTry = Try(unsafeMethod()) orElse Try(backupMethod())

  // IF we design the API

  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException())
  def betterBackupMethod(): Try[String] = Success("A valid string")

  val betterFalbackMethod = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterFalbackMethod)

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
//  println(aSuccess.filter(_ > 10))

  // => for-comprehensions
  /*
  Exercise
   */

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection{
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>..</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService{
    val random = new Random(System.nanoTime())
    def getConnection(host: String, port: String): Connection = {
      if(random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port:String): Try[Connection] = Try(getConnection(host, port))
  }
    // if we get a the html from the connection, print it to the console i.e. call renderHtml

    val possibleConnection = HttpService.getSafeConnection(hostname, port)
    val possibleHtml = possibleConnection.flatMap(connection => connection.getSafe("/home"))
    possibleHtml.foreach(renderHTML)

  // short hand
  HttpService.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for-comprehension
  for {
    connection <- HttpService.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  /*
  try{
    connection = HttpService.getConnection(host,port)
      try {
        connection.get("/home")
      } catch (some other exception) {
      }
    } catch (exception){
    }
   */
}
