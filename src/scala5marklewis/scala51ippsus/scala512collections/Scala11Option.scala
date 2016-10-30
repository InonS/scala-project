package scala5marklewis.scala51ippsus.scala512collections

/**
  * scala-project
  * Created by admin on 2016-07-01.
  */
object Scala11Option {

  def main(args: Array[String]) {
    val lst = List(1, 2, 3, 4)

    findGt(lst, 5)
    findGt(lst, 3)
  }

  private def findGt(lst: List[Int], n: Int) {
    val gtn = lst find (_ > n)
    println(gtn)
    println(gtn isEmpty)
    println(gtn nonEmpty)

    println(gtn getOrElse 0)

    try {
      println(gtn get)
    } catch {
      case e: NoSuchElementException => println(n)
    }

    gtn match {
      case Some(x) => println(x) // implicit parameter not supported?!
      case None => println(n)
    }

    println(gtn map (_ * 2)) // a None is mapped to a None

    println(gtn find (_ % 2 == 0))
  }
}
