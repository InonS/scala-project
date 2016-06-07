package scala2matthiasjdeja

import scala.collection.immutable.Range.Inclusive

/**
  * Created by admin on 2016-06-04.
  *
  * The sum of the squares of the first ten natural numbers is,
  * 1^2 + 2^2 + ... + 10&#94;2 = 385
  *
  * The square of the sum of the first ten natural numbers is,
  * (1 + 2 + ... + 10)^2 = 55^2 = 3025
  *
  * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
  *
  * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
  *
  */
object Ep3Euler006 {
  def main(args: Array[String]) {
    println(functionalVersion)
  }

  private def mostJavaesqueVersion: Int = {
    var sum = 0
    var ssq = 0
    for (i <- 1 to 100) {
      sum += i
      ssq += i * i // no exponential operator in Scala
    }
    sum * sum - ssq
  }

  private def functionalVersion: Int = {
    val inclusiveRange: Inclusive = 1 to 100
    val sum = inclusiveRange.sum
    val ssq = inclusiveRange.map({ i => i * i }).sum // map is a method of Sequence (so is toSet)
    sum * sum - ssq
  }
}
