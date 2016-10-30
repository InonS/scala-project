package scala5marklewis.scala51ippsus.scala513forloop

/**
  * scala-project
  * Created by admin on 2016-09-01.
  */
object Scala15Multidimensions {
  def main(args: Array[String]) {
    println(multiplicationFactors)
    println(multiplicationTable)
  }

  /**
    * 'for' comprehended as 'flatMap'
    */
  def multiplicationFactors = {
    for (x <- 1 to 10; y <- 1 to 10) yield x * y
  }

  /**
    * 'for' comprehended as chained 'map's
    */
  def multiplicationTable = {
    for (x <- 1 to 10) yield {
      for (y <- 1 to 10) yield {
        x * y
      }
    }
  }
}
