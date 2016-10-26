package scala5marklewis.scala51ippsus.scala2collections

/**
  * scala-project
  * Created by admin on 2016-06-19.
  *
  * Combinatorics scale exponentially. Using an Iterator (lazy evaluation) conserves memory.
  *
  */
object Scala8IteratorsForCombinatorics {

  def main(args: Array[String]) {
    val nums = Array(1, 2, 3, 4, 5)

    fiveChooseTwo(nums)
    (nums permutations).foreach(a => println(a mkString ","))
    println(nums.permutations.toArray)
    (nums grouped 3).foreach(a => println(a mkString ","))
    (nums sliding 3).foreach(a => println(a mkString ","))
  }

  private def fiveChooseTwo(nums: Array[Int]) {
    println(nums combinations 2)

    val iter: Iterator[Array[Int]] = nums combinations 2
    println(iter hasNext)
    println((iter next) mkString ",")
    println(iter hasNext)
    println((iter next) mkString ",")
    println(iter hasNext)

    (nums combinations 2).foreach(a => println(a mkString ","))
  }
}
