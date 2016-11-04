package scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods

import scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods.Scala5312MutabilityAndPrivateMembers.ImmutableObject

/**
  * scala-project
  * Created by admin on 2016-11-04.
  */
object Scala5314Apply {

  def main(args: Array[String]) {

    /**
      * Objects (both Singleton and Instance) may implement an 'apply' method,
      * a protocol akin to the Java Functional Interface [[java.util.function.Function]], like `AbstractFunctionN`
      * which is implicitly called when the object itself is called.
      */

    /** shorthand for Array.apply(1, 2, 3),
      * where Array is the Singleton/Companion Object,
      * and the method is the factory method
      */
    val arr = Array(1, 2, 3)

    /** analogous to subscript indexing,
      * arr is an Instance Object, and the implicit apply method is the element accessor.
      * Thus, the [[Array]] class does not have to be a built-in type,
      * but can be a ([[scala.collection]]) library type
      */
    arr(0)

    /** same for an implicit function, a.k.a. lambda expression */
    val f = () => math.random

    /** shorthand for f.apply() */
    f()

    /** this is not a call on the `f` object, but just a reference to it, so `apply` is not called. */
    f

    class AppliableImmutableObject extends ImmutableObject {

      /** apply as factory method (no-arg in this case) */
      def apply: AppliableImmutableObject = new AppliableImmutableObject()

      /** apply as custom, wacky, factory method */
      def apply(y: Int, z: Int): AppliableImmutableObject = {
        val immutableObject = new AppliableImmutableObject()
        (0 to z).foreach(i => immutableObject.:+(i * y))
        immutableObject
      }

      /** apply as indexed element accessor */
      def apply(index: Int): Int = index match {
        case n: Int if n > 0 && n < this.x.length => this.x(n)
        case _ => throw new IndexOutOfBoundsException(s"${this.getClass.getName} indexed at $index")
      }


    }
  }
}
