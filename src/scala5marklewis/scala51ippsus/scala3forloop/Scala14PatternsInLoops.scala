package scala5marklewis.scala51ippsus.scala3forloop

/**
  * scala-project
  * Created by admin on 2016-09-01.
  */
object Scala14PatternsInLoops {
  def main(args: Array[String]) {
    var tuples = List[(Int, Int)]()
    for (i <- 1 to 5) {
      tuples = (i, i + 1) :: tuples
    }

    for ((n1, n2) <- tuples) println("(" + n1 + ',' + n2 + ')')

    // within 'for' loop, unmatched cases are just skipped (matching doesn't have to be exhaustive)
    for ((1, n2) <- tuples) println("(" + 1 + ',' + n2 + ')')
    for ((n1, n2) <- tuples if n1 % 2 == 0) println("(" + n1 + ',' + n2 + ')')
    // loop variables, too!
    for ((n1, n2) <- tuples; q = n1 % 2; if q == 0) println(q + ": (" + n1 + ',' + n2 + ')')
    // same thing, multiline 'for' block
    for {
      (n1, n2) <- tuples
      q = n1 % 2
      if q == 0
    } println(q + ": (" + n1 + ',' + n2 + ')')

    println(splitMapMatch("1,2,3"))
  }

  /**
    * If you know in advance the exact type you're parsing, you can use non-exhaustive pattern matching as well
    */
  def splitMapMatch(tripleFiledCsv: String): (Int, Int, Int) = {
    val Array(a, b, c) = tripleFiledCsv.split(",").map(_.toInt)
    (a, b, c)
  }
}
