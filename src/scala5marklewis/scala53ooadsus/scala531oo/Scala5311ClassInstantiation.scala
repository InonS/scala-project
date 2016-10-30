package scala5marklewis.scala53ooadsus.scala531oo

/**
  * scala-project
  * Created by admin on 2016-10-31.
  */
object Scala5311ClassInstantiation {

  /**
    *
    * @param context an inaccessible member
    * @param name    an immutable, accessible member
    * @param age     a mutable, accessible member with default value
    */
  class Person(context: String, val name: String, var age: Int = 18) {

    var hasAged = false

    /**
      * Convention: Use parameter parenthesis for a method with side-effects.
      * Simple mutator.
      */
    def incAge() {
      if (!context.isEmpty) age += 1
      hasAged = true
    }

    /**
      * Convention: No parameter parentheses for a method with no side-effects.
      * Simple getter.
      */
    def getAge: Int = age

    override def toString: String = {
      s"{name=$name, context=$context, age=$age, overEighteen=${age > 18}, hasAged=$hasAged}"
    }
  }

  def main(args: Array[String]) {
    val josh = new Person("", "Josh")
    josh.incAge()
    val avi = new Person("Met at work", "Avi")
    avi.incAge()
    println((josh, avi))
  }
}
