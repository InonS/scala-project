package scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods

/**
  * scala-project
  * Created by admin on 2016-10-31.
  */
object Scala5312MutabilityAndPrivateMembers {

  /**
    * @param x immutable property
    */
  class ImmutableObject(val x: List[Int] = Nil) {
    /**
      * Mutating an immutable object is not possible, so any mutators must return a new [[ImmutableObject]]
      *
      * @param y Int to cons onto existing list [[x]]
      * @return new [[ImmutableObject]] with updated [[x]]
      */
    def :+(y: Int): ImmutableObject = new ImmutableObject(y :: x)

  }

  /**
    * @param _f mutable property (Arrays are mutable objects in themselves, too), so private
    */
  class MutableForce(private var _f: List[Int]) {
    /**
      * Since [[_f]] is mutable, we perform the cons in-place.
      *
      * @param g element to cons onto existing [[_f]]
      */
    def :+(g: Int) {
      _f ::= g
    }

    /** public accessor
      * Since [[_f]] is a [[List]] (an immutable type), it's safe to return a reference to it.
      * had it been a mutable type (e.g. [[Array]]) we would allow access only via a defensive copy.
      */
    def f = _f

    /** property assignment method */
    def f_=(new_f: List[Int]) {
      f = new_f
    }

    /**
      * unary, prefix operator
      * private method, just for fun
      */
    private def unary_++() {
      this :+ f.head
      this f_= f
    }
  }

  def main(args: Array[String]) {

  }


}
