package scala5marklewis.scala51ippsus.scala512collections

/**
  * scala-project
  * Created by admin on 2016-06-19.
  *
  * http://docs.scala-lang.org/overviews/collections/overview
  */
object Scala6Collections {

  private def twoCollectionMethods(a: Array[Int]) {
    val (first, second) = a splitAt 4
    println("a.splitAt(4) = " + first.mkString(",") + " , " + second.mkString(","))
    println("a.diff(Array(2, 9, 7, 6, 8)) = " + a.diff(Array(2, 9, 7, 6, 8)).mkString(",")) // left diff
  }

  private def zipMethods(a: Array[Int], lst: List[String]) {
    println("lst.zipWithIndex = " + lst.zipWithIndex.mkString(","))
    println("a.zip(lst) = " + a.zip(lst).mkString(","))
  }

  def main(args: Array[String]) {
    val a = Array(5, 2, 9, 3, 1, 8, 6, 1, 1)
    println("a = " + a.mkString(","))
    booleanMethods(a)
    selectionMethods(a)
    searchMethods(a)
    twoCollectionMethods(a)
    patchMethod(a)
    val lst = List("One", "Two", "Three", "Four")
    zipMethods(a, lst)
    arithmeticMethods(a, lst)
  }

  private def arithmeticMethods(a: Array[Int], lst: List[String]) {
    println("lst.min = " + lst.min)
    println("a.max = " + a.max)
    println("a.sum = " + a.sum)
    println("a.product = " + a.product)
    println("a.sum.toDouble / a.length = " + a.sum.toDouble / a.length)
  }

  private def patchMethod(a: Array[Int]) {
    println("a.patch(2, Array(77, 88, 99), 3) = " + a.patch(2, Array(77, 88, 99), 3).mkString(","))
    println("a.patch(2, Nil, 3) = " + a.patch(2, Nil, 3).mkString(","))
  }

  private def searchMethods(a: Array[Int]) {
    println("a.indexOf(1) = " + (a indexOf 1))
    println("a.indexOf(11) = " + (a indexOf 11))
    println("a.indexOf(1, 5) = " + (a indexOf(1, 5)))
    println("a.lastIndexOf(1) = " + (a lastIndexOf 1))
  }

  private def selectionMethods(a: Array[Int]) {
    headAndTailMethods(a)
    lastAndInitMethods(a)
    takeAndDropMethods(a)
    println("a.slice(1, 2) = " + (a slice(1, 2)).mkString(","))
    println("a.reverse = " + a.reverse)
    println("a.distinct = " + a.distinct)
    println("a.toList = " + a.toList)
  }

  private def headAndTailMethods(a: Array[Int]) {
    println("a.head = " + a.head)
    println("a.tail = " + (a tail).mkString(","))
    println("a.tails = ")
    a.tails.foreach(a => println(a mkString ","))
  }

  private def lastAndInitMethods(a: Array[Int]) {
    println("a.last = " + a.last)
    println("a.init = " + (a init).mkString(","))
    println("a.inits = ")
    a.inits.foreach(a => println(a mkString ","))
  }

  private def takeAndDropMethods(a: Array[Int]) {
    println("a.take(2) = " + (a take 2).mkString(","))
    println("a.takeRight(2) = " + (a takeRight 2).mkString(","))
    println("a.drop(2) = " + (a drop 2).mkString(","))
    println("a.dropRight(2) = " + (a dropRight 2).mkString(","))
  }

  private def booleanMethods(a: Array[Int]) {
    println("a.isEmpty = " + a.isEmpty)
    println("Nil.isEmpty = " + Nil.isEmpty)
    println("a.nonEmpty = " + a.nonEmpty)
    println("a.contains(8) = " + a.contains(8))
    println("a.startsWith(Array(1, 8)) = " + a.startsWith(Array(1, 8)))
    println("a.endsWith(Array(8, 6)) = " + a.endsWith(Array(8, 6, 1, 1)))
  }
}
