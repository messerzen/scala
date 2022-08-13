package lectures.part3fp

import java.util.Random

object Options extends App {

  val myFirstOption: Option[Int] = Some(1)
  val noOption: Option[Int] = None
  println(myFirstOption)
  println(noOption)

  // WORK with unsafe APIs
  def unsafeMethod(): String = null

  //  val result = Some(unsafeMethod()) // WRONG -> some should always have a value inside
  val result = Option(unsafeMethod()) // Some or None

  println(result)

  // chained methods
  def backupMethod(): String = "A valid result"

  val chainedResult = Option(unsafeMethod()).orElse(Option(backupMethod()))

  def safeMethod(): String = "hell yeah!"

  val chainedResult2 = Option(safeMethod()).orElse(Option(backupMethod()))
  println(chainedResult)
  println(chainedResult2)

  //DESIGN unsafe APIs

  def betterUnsafeMethod(): Option[String] = None

  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()
  println(betterChainedResult)

  // functions on Options

  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // UNSAFE -- DO NOT USE THIS

  // map, flatmap, filter

  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter(x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for-comprehensions
  /*
  Exercise.
   */

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection)
      else None
    }
  }

  // try to establish a connection, if so - print the connected method

  val host = config.get("host")
  val port = config.get("port")

  /*
  if(h != null):
    if(p != null):
      return connection.apply(h, p)
  return null
   */
  val isConnected = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))

  /*
  if(c != null)
    return c.connect
  return null
   */
  val connectionStatus = isConnected.map(c => c.connect)

  // if (connectionStatus == null) println(None) else print (Some(connectionStatus.get))
  println(connectionStatus)

  /*
  if (status != null)
    println(status)
   */
  connectionStatus.foreach(println)


}


