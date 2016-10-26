package scala5marklewis.scala51ippsus.scala5case

/**
  * scala-project
  * Created by admin on 2016-10-26.
  */
object Scala19Zipping {

  val nums = List(1, 2, 3)
  val chars = "a b c" split ' ' map (_.charAt(0))

  /**
    * Merge two [[scala.collection]]s into a single [[scala.collection]] of element-wise [[Tuple2]], eager
    */
  def zip() {
    val zipped_ = nums zip chars
    println(zipped_)
    val asciiMultiplication = zipped_ map ((tpl: (Int, Char)) => tpl._2 * tpl._1)
    println(asciiMultiplication)
  }

  /**
    * Generator from two [[scala.collection]], lazy
    * Can handle either Tuple syntax: `zipped_.map((tpl: (Int, Char)) => tpl._2 * tpl._1)`
    * or explicit argument syntax: `zipped_.map((i: Int, c: Char) => c * i)`
    */
  def zipped() {
    val zipped_ = (nums, chars).zipped
    println(zipped_)
    val asciiMultiplication_ = zipped_.map((i: Int, c: Char) => c * i)
    println(asciiMultiplication_)

    val bools = List(false, true)
    val zipped__ = (nums, chars, bools).zipped
    println(zipped__)
    val asciiMultiplication__ = zipped__.map((i: Int, c: Char, b: Boolean) => if (b) c * i else c)
    println(asciiMultiplication__)
  }

  def main(args: Array[String]) {
    zip()
    zipped()
  }
}
