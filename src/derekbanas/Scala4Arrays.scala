package derekbanas

import scala.collection.mutable.ArrayBuffer

/**
  * Created by admin on 2016-05-30.
  */
object Scala4Arrays {
  def main(args: Array[String]) {

    // fixed length: Array. variable length: ArrayBuffer

    val favNums = new Array[Int](20)

    // constructor initialization
    val friends = Array("Bob", "Tom")

    // access element and set contents
    friends(0) = "Sue"

    println("Best friend: " + friends(0))


    // no initialization values
    val friends2 = ArrayBuffer[String]()

    friends2 += "Mark" // append
    friends2 ++= friends // multiple append

    friends2.insert(0, "Phil") // inserting in specific place
    friends2.insert(1, "Mike", "Sally") // multiple insert

    friends2.remove(2, 3) // remove

    // for-each loop over elements
    var friend: String = " "
    for (friend <- friends2) println(friend)

    // initializing the Array[Int]
    for (j <- 0 until favNums.length) {
      favNums(j) = j
      println(favNums(j))
    }

    // creating Array using yield
    val favNumsTimes2 = for (num <- favNums) yield 2 * num
    favNumsTimes2.foreach(println)

    // using yield and condition
    val favNumsDiv4 = for (num <- favNums if num % 4 == 0) yield num
    favNumsDiv4.foreach(println)

    // multidimensional arrays: Construction, setting values and retrieving them
    val multTable = Array.ofDim[Int](10, 10)
    for (i <- 0 to 9; j <- 0 to 9) multTable(i)(j) = i * j
    for (i <- 0 to 9; j <- 0 to 9) printf("%d : %d = %d\n", i, j, multTable(i)(j))

    // Array[Int] class methods
    println("Sum = " + favNums.sum + " max = " + favNums.max)

    // sorting
    val sortedNums = favNums.sortWith(_ > _) // descending order

    // CSV
    println("sorted  = " + sortedNums.deep.mkString(", "))

  }
}
