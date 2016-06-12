package scala5marklewis.scala51ippsus

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

    /** other methods of appending n elements to a generally traversable instance [[scala.collection.GenTraversable]]
      * (Array and List are just two subclasses):
      *
      * [[Array.fill]]] (takes Supplier) and
      * [[List.tabulate]]] (takes function of index)
      */
    println(List.fill(3)(0))
    println(List.tabulate(3)(_ => 0))
    println(Array.tabulate(5)(i => i * (i + 1) / 2).toStream.mkString(","))
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
      val h: Int = lst.head
      val t: List[Int] = lst.tail

      // base case: last two elements (since f is a binary function)
      println((t tail).toStream.mkString(","))
      if (t.tail == Nil) return f(h, t.head)
      f(h, operateOnList(t, f))
    }

    def matchOperationOnList(lst: List[Int], f: (Int, Int) => Int): Int = {
      val h: Int = lst head
      val t: List[Int] = lst tail


      t tail match {
        case Nil => f(h, t head)
        case _ :: _ => f(h, matchOperationOnList(t, f)) // use cons pattern to match a List
      }
    }
  }


}

