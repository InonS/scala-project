package scala5marklewis.scala51ippsus

/**
  * scala-project
  * Created by admin on 2016-06-07.
  */
object Scala2MatchExpression {

  /** tail recursion
    * Base case: fact(n|n<1) = 1
    */
  def fact(n: Int): Int = if (n < 1) 1 else n * fact(n - 1)

  /**
    * another tail recursion
    * Base case: sumSquares(n|n<2) = 1
    */
  def sumSquares(n: Int): Int = if (n < 2) 1 else n * n + sumSquares(n - 1)

  /**
    * tail recursive procedure with side effects
    */
  def countDown(n: Int): Unit =
    if (n > 0) {
      println(n)
      countDown(n - 1)
    }

  def matchCasePatternExample(expr: Any, pattern1: Any, pattern2: Any): Unit = {

    println("expression to match = " + expr)
    expr match {

      case `pattern1` => {
        println(expr + " matched first pattern  = " + pattern1)
        /* now do something... */
      }

      case `pattern2` => {
        println(expr + " matched next pattern = " + pattern2 + ", since previous one/s didn't match")
        /* so do something else... */
      }

      case _ => {
        println("catch-all: pattern to match if " + expr + " not matched by any previous patterns")
        /* ok, do something else completely... */
      }
    }
  }

  /**
    * factorial function using match expression
    *
    * @note Scala does not support arithmetic match patterns ({{{n < 1}}})!
    *
    *       This implementation will fail for negative {{{n}}}!
    */
  def caseFact(n: Int): Int = n match {
    case 0 => 1
    case `n` => n * caseFact(n - 1)
  }

  def caseSumSquares(n: Int): Int = n match {
    case 1 => 1
    case `n` => n * n + caseSumSquares(n - 1)
  }

  def caseCountDown(n: Int): Unit = n match {
    case 0 =>
    case `n` => println(n); caseCountDown(n - 1)
  }

  def main(args: Array[String]) {

    println("match-case pattern example:")
    matchCasePatternExample(1, 2, 3)

    println("match-case factorial:")
    println(caseFact(5))


    println("match-case sum of squares:")
    println(caseSumSquares(5))

    println("match-case count-down:")
    caseCountDown(10)
  }

}
