package scala5marklewis.scala53ooadsus

import scala.util.Random

/**
  * scala-project
  * Created by admin on 2016-10-31.
  */
object Scala1HigherOrderFunc {

  def main(args: Array[String]) {
    /**
      * @param f passed by name: The name of a function returning an [[Int]]. See also the second (i.e. Curryed) parameter [[Array.fill]]
      * @return
      */
    def passByName(f: => Int): Array[Int] = {
      val n = f
      val arr = Array.fill(n)(f)
      arr
    }
    println(passByName(Random.nextInt(1 << 5)).toStream mkString ", ")
  }

}
