package scala5marklewis.scala51ippsus

import scala.collection.immutable

/**
  * scala-project
  * Created by admin on 2016-06-08.
  */
object Scala5ArrayAndListFunctions {

  def main(args: Array[String]) {
    println("Array sum:\n" + ArrayExample.operateOnArray(ArrayExample.arr, _ + _) + '\n')
    println("Array product:\n" + ArrayExample.operateOnArray(ArrayExample.arr, _ * _) + '\n')

    println("List sum:\n" + ListExample.operateOnList(ListExample.lst, _ + _) + '\n')
    println("List product:\n" + ListExample.operateOnList(ListExample.lst, _ * _) + '\n')

    println("List match sum:\n" + ListExample.matchOperationOnList(ListExample.lst, _ + _) + '\n')
    println("List match product:\n" + ListExample.matchOperationOnList(ListExample.lst, _ * _) + '\n')
  }

  object ArrayExample {
    /**
      * @see [[Array]]
      *
      *      Arrays are mutable, random access, and zero-based
      */
    val arr: Array[Int] = Array(1, 2, 3)
    println(arr.length)
    println(arr(1))
    arr(2) = 4

    /** other methods of appending n elements to an array:
      * [[Array.fill]]] (takes Supplier) and
      * [[Array.tabulate]]] (takes function of index)
      */
    println((arr toStream).mkString(","))

    def operateOnArray(arr: Array[Int], f: (Int, Int) => Int, start: Int = 0): Int = {
      val lengthMinusOne: Int = arr.length - 1
      if (start == lengthMinusOne) return arr(lengthMinusOne)
      f(arr(start), operateOnArray(arr, f, start + 1))
    }
  }

  object ListExample {

    /**
      * @see Default [[List]] documentation, i.e. [[scala.collection.immutable.List]]
      *
      *      A class for immutable linked lists representing ordered collections
      *      of elements of type.
      *
      *      This class comes with two implementing case classes `scala.Nil`
      *      and `scala.::` that implement the abstract members `isEmpty`,
      *      `head` and `tail`.
      *
      *      This class is optimal for last-in-first-out (LIFO), stack-like access patterns. If you need another access
      *      pattern, for example, random access or FIFO, consider using a collection more suited to this than `List`.
      *
      */
    val lst: List[Int] = List(2, 3, 4)
    println(lst.length)
    println(lst(1))
    println((lst toStream).mkString(","))

    def operateOnList(lst: List[Int], f: (Int, Int) => Int): Int = {
      val head: Int = lst.head
      val tail: List[Int] = lst.tail

      // base case: last two elements (since f is a binary function)
      if (tail.tail == Nil) return f(head, tail.head)
      f(head, operateOnList(tail, f))
    }

    def matchOperationOnList(lst: List[Int], f: (Int, Int) => Int): Int = {
      val tail: List[Int] = lst.tail

      tail.tail match {
        case Nil => f(lst.head, tail.head)
        case h :: t => f(h, operateOnList(t, f)) // use cons pattern
      }
    }
  }


}

