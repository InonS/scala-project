package scala1derekbanas

/**
  * Created by admin on 2016-05-30.
  */
object Scala1ControlFlow {

  // main method, note explicit type hinting
  def main(args: Array[String]) {

    // variable (will be inferred to be Int)
    var i = 0 // look, Ma', no semicolon!

    // while loop
    while (i <= 10) {
      println(i)
      i += 1
    }

    // do-while loop
    do {
      println(i)
      i += 1
    } while (i <= 20)

    // for value in constant range
    for (i <- 1 to 10) println(i)

    val randLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    // for value in variable range ('until' = start inclusive, end exclusive)
    for (i <- 0 until randLetters.length) println(randLetters(i))

    // a List of given elements
    val aList = List(1, 2, 3, 4, 5)

    // for-each loop
    for (i <- aList) println("List items " + i)

    // "generator"?
    var evenList = for {i <- 1 to 20 if (i % 2) == 0} yield i

    // for-each loop
    for (i <- evenList) println(i)

    // multidimensional loop: outer-most loop variable first (like row-major index), separated by semicolon from next expression (i.e. next loop variable)
    for (i <- 1 to 5; j <- 6 to 10) {
      println("i: " + i)
      println("j: " + j)
    }

    // no break or continue statements
    def printPrimes(): Unit = {
      val primeList = List(1, 2, 3, 5, 7, 11)
      for (i <- primeList) {

        // break
        if (i == 11) return


        if (i != 1) {
          println(i)
          return
        }

        println("i is 1")
      }
    }

    // function call does not necessitate paren.s
    printPrimes
  }
}
