package derekbanas

import scala.math.log10

/**
  * Created by admin on 2016-06-04.
  */
object Scala11HeigherOrderFunctions {
  def main(args: Array[String]) {

    val log10func = log10 _ // implicit parameter (`_`) needed to specify that we are referring to the the function, 'log10()', as a function object, and not invoking it right now.
    println(log10func(1000))

    // map
    List(1000.0, 10000.0).map(log10).foreach(println)

    // lambda
    List(1, 2, 3, 4, 5).map((x: Int) => x * 50).foreach(println)

    // lambda using implied lambda parameter
    List(1, 2, 3, 4, 5).map(_ * 50).foreach(println)

    // filter
    List(1, 2, 3, 4, 5).filter(_ % 2 == 0).foreach(println)

    def times3(number: Int) = number * 3
    def times4(number: Int) = number * 4

    // higher-order function (takes an Int to Double func as parameter)
    def multIt(func: (Int) => Double, num: Int): Double = {
      func(num)
    }

    printf("3 * 100 = %.1f\n", multIt(times3, 100))
    printf("4 * 100 = %.1f\n", multIt(times4, 100))


    // closure: A function that depends on a variable defined outside its scope
    val divisor = 5
    val divIt = (num: Double) => num / divisor

    println("5 / 5  = " + divIt(5))
  }
}

