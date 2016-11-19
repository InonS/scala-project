package scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods

import scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods.Scala5312MutabilityAndPrivateMembers.MutableForce

/**
  * scala-project
  * Created by admin on 2016-11-05.
  */
object Scala5315Update {
  def main(args: Array[String]) {

    /**
      * only relevant for Mutable classes
      */

    /** apply Companion Object: Array.apply(1, 2, 3) */
    val a = Array(1, 2, 3)

    /** apply Instance Object: a.apply(1) */
    a(1)

    /** update Instance Object: a.update(1, 99) */
    a(1) = 99

    class UpdateableMutableForce(var g: List[Int]) extends MutableForce(g: List[Int]) {
      def update(index: Int, value: Int) {
        index match {
          case n: Int if n > 0 && n < g.length => g = g.updated(index, value)
          case _ => throw new IndexOutOfBoundsException(s"${this.getClass.getName} indexed at $index")
        }
      }
    }
  }

}
