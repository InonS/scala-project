package scala5marklewis.scala51ippsus.scala2collections

import scala.Array.fill

/**
  * scala-project
  * Created by admin on 2016-06-19.
  */
object Scala7FP {

  def main(args: Array[String]) {
    val a = Array(5, 2, 9, 3, 1, 8, 6)

    filterMethod(a)
    existsMethods(a)
    morePredicateMethods(a)

    a.foreach(println)
    mapMethod(a)
    flatMapMethod(a)

    reduceAndFoldMethods(a)
  }

  def filterMethod(a: Array[Int]): Unit = {
    println(a filter (_ % 2 == 0) mkString ", ")
    println(a filter (_ % 2 != 1) mkString ", ")
    println(a filterNot (_ % 2 == 1) mkString ", ")

    val (evens, odds) = a partition (_ % 2 == 0)
    println("evens = " + evens.mkString(",") + "   odds = " + odds.mkString(","))
  }


  private def morePredicateMethods(a: Array[Int]): Unit = {
    println("count evens = " + a count (_ % 2 == 0))
    println("drop less than nine = " + a dropWhile (_ < 9) mkString ",")
    println("take less than nine = " + a takeWhile (_ < 9) mkString ",")
    println("index where divisible by three = " + a indexWhere (_ % 3 == 0))
    println("index where equal to eight = " + a indexWhere (_ == 8)) // same as a.indexOf(8)
    println("last index where divisible by three = " + a lastIndexWhere (_ % 3 == 0))
  }


  private def mapMethod(a: Array[Int]): Unit = {
    println(a map (i => i * 2) mkString ", ")
    println(a map (_ / 2.0) mkString ", ")
    println(a map ("hi-" * _) mkString ", ")
  }


  def flatMapMethod(a: Array[Int]) = {
    println(a map (n => fill(n / 2)(n)) map (_.mkString("(", ",", ")")) mkString ", ")
    println(a flatMap (n => fill(n / 2)(n)) mkString " ,")
  }


  private def existsMethods(a: Array[Int]): Unit = {
    println(a exists (_ % 5 == 0))
    println(a forall (_ % 5 == 1))
  }

  private def reduceAndFoldMethods(a: Array[Int]): Unit = {
    println(a.reduceLeft((a, b) => {
      println(a + " " + b)
      a + b
    }))
    println(a.reduceRight((a, b) => {
      println(a + " " + b)
      a + b
    }))

    a.foldLeft(0)((a, b) => {
      println(a + " " + b)
      a + b
    })
    a.foldLeft("")((a, b) => {
      println(a + " " + b)
      a + b
    })
    a.foldRight("")((a, b) => {
      println(a + " " + b)
      a + b
    })
  }
}
