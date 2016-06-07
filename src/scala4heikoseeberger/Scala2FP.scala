package scala4heikoseeberger

/**
  * scala-project
  * Created by admin on 2016-06-07.
  */
object Scala2FP {

  def main(args: Array[String]) {

    // ternary operator (if-else)
    val x = if (true) 1 else 2
    println(x)

    //
    val numbers = List(1, 2, 3, 4) // val collection works like Java final
    println(numbers.size)
    println(numbers.head)
    println(numbers.tail)
    println(numbers take 3)
    println(numbers drop 2)

    /** even better performance characteristics with [[Vector]] */

    // add 1 to each element
    println(for (n <- numbers) yield n + 1)

    // declarative (transformer), not imperative (iteration/recursion)
    println(numbers map (_ + 1))

    // filter
    println(numbers filter (_ % 2 == 0))

    // complex declarative statement (c.f. SQL)
    println(for (n <- numbers if n % 2 == 0) yield n + 1) // iterates once over collection
    println(numbers map (_ + 1) filter (_ % 2 == 0)) // iterates twice over collection

    // streaming pipeline
    println(numbers.toStream map (_ + 1) filter (_ % 2 == 0) toList) // iterates once over collection


  }
}
