package scala5marklewis.scala53ooadsus.scala533polymorphism

import java.util.concurrent.TimeUnit

import scala.concurrent.duration.Duration

/**
  * scala-project
  * Created by admin on 2016-11-20.
  */
object Scala5338TypeBounds extends App {
  val nums = Array.fill(3)(math.random)
  println(Sorting.bubbleSort(nums).toStream mkString ", ")
  println(Sorting.sortWithComparator(nums)(_ < _).toStream mkString ", ")
  println(Sorting.sortedImplicitConversion(nums).toStream mkString ", ")

  val durations = Array.fill(3)(Duration(math.random, TimeUnit.SECONDS))
  println(Sorting.typeBound(durations).toStream mkString ", ")

  object Sorting {

    def bubbleSort[A](arr: Array[A]) = {
      for (i <- arr.indices; j <- arr.indices if j < arr.length - 1 - i) {
        if (arr(j + 1).toString.compareTo(arr(j).toString) < 0) {
          val tmp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = tmp
        }
      }
      arr
    }

    /**
      * Currying carries type inference forward from first argument to second.
      */
    def sortWithComparator[A](arr: Array[A])(isLessThan: (A, A) => Boolean) = {
      for (i <- arr.indices; j <- arr.indices if j < arr.length - 1 - i) {
        if (isLessThan(arr(j + 1), arr(j))) {
          val tmp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = tmp
        }
      }
      arr
    }

    /**
      * @tparam A is a subtype of [[Ordered]], and therefore implements [[Ordered[A].<]]
      */
    def typeBound[A <: Ordered[A]](arr: Array[A]) = {
      for (i <- arr.indices; j <- arr.indices if j < arr.length - 1 - i) {
        if (arr(j + 1) < arr(j)) {
          val tmp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = tmp
        }
      }
      arr
    }

    /**
      * @tparam A is a subtype of [[Ordered]], or can be implicitly converted to a type which is
      *
      *           Explicitly making the implicit conversion:
      *           `def bubbleSort[A](arr: Array[A])(implicit castAtoOrdered: A => Ordered[A])`
      */
    def sortedImplicitConversion[A <% Ordered[A]](arr: Array[A]) = {
      for (i <- arr.indices; j <- arr.indices if j < arr.length - 1 - i) {
        if (arr(j + 1) < arr(j)) {
          val tmp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = tmp
        }
      }
      arr
    }
  }

}
