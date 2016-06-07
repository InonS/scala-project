package scala1derekbanas

/**
  * Created by admin on 2016-05-31.
  */
object Scala6Tuples {
  def main(args: Array[String]) {

    var tupleMarge = (103, "Marge Simpson", 10.25)

    // accessor
    printf("%s owes us $%.2f\n", tupleMarge._2, tupleMarge._3)

    // product iterator
    tupleMarge.productIterator.foreach {
      i => println(i)
    }

    println(tupleMarge.toString)
  }
}
