package scala5marklewis.scala51ippsus.scala3forloop

/**
  * scala-project
  * Created by admin on 2016-09-01.
  */
object Scala16ParallelFor {
  def main(args: Array[String]): Unit = {
    // sequential
    var x = 0
    for (_ <- 1 to 1000000) x += 1
    println(x)

    // parallel mutable error: race condition!
    x = 0
    for (_ <- (1 to 1000000).par) x += 1
    println(x)
  }
}
