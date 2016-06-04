package matthiasjdeja

/**
  * EOLN semicolons are inferred
  *
  */

/**
  * Created by admin on 2016-06-04.
  *
  * Scala for Java programmers, the Euler way
  *
  * If we list all the natural numbers below 10 that are multiple of 3 or 5,
  * we get 3, 5, 6, and 9. The sum of these multiples is 23.
  *
  * Find the sum of all multiples of 3 and 5 below 1000.
  *
  *
  * object is a singleton class (and its instance):
  * 1. Cannot be instantiated
  * 2. Cannot be inherited
  */
object Euler001 {

  /** No public or static keywords. Public is default, static is inferred by context.
    * Generics are written in square brackets, because angular brackets are used for native, explicit XML support
    *
    * @param args command-line arguments
    */
  def main(args: Array[String]) {
    val sum: Int = lambdaVersion()
    println(sum) // included in Predef, which is an always-present static import
  }

  // procedural, imperative paradigm
  private def mostJavaesqueVersion(): Int = {
    var sum: Int = 0 // Int has methods in Scala, but is primitive in bytecode
    for (n <- 1 until 1000)
    /*
      no C `for` statement in Scala, i.e. `for (int i = 0 ; i < imax ; ++i)`
      n's type is inferred.
      `<-` is iteration syntax.
      Scala Stream is similar to a Python generator, allowing to work with sequences of unknown length (even infinitely long).
      `until` is end-exclusive (like xrange), `to` is end-inclusive
      Period corrector (`.`) and function call parens are inferred (operator syntax / infix notation), IFF it is unambiguous: A single object method call taking a single parameter
     */
      if (n % 3 == 0 || n % 5 == 0) sum += n
    sum
  }

  /**
    * still procedural & imperative
    * functions taking no arguments may be defined without the call parens (those will be inferred by the compiler). The caller can then choose to leave out the call parens, as well
    */
  private def filteredLoopVersion: Int = {
    var sum = 0 // inferred type
    // additional filters (or nested loop variables) can be introduced within the same `for` statement
    for (n <- 1 until 1000; if n % 3 == 0 || n % 5 == 0) sum += n
    sum
  }

  /** c.f. Java Streams */
  private def functionalVersion(): Int = {
    val range: Range = 1 until 1000
    val predicate: (Int) => Boolean = n => n % 3 == 0 || n % 5 == 0
    range.filter(predicate).sum // "reduce" = `foldLeft` or `foldRight`
  }

  private def lambdaVersion(): Int = {
    // (1 until 1000).filter({ (n: Int) => n % 3 == 0 || n % 5 == 0 }).sum
    (1 until 1000 filter (n => n % 3 == 0 || n % 5 == 0)).sum
    // can't replace `n` with an implicit parameter (`_`) because it's used twice (once for 3, and nother for 5)
  }
}
