package scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods

import scala.collection.immutable.NumericRange
import scala5marklewis.scala53ooadsus.scala531ooAndSpecialMethods.Scala5312MutabilityAndPrivateMembers.ImmutableObject

/**
  * scala-project
  * Created by admin on 2016-10-31.
  */
object Scala5313PublicAccessorsAndValidityChecks {

  class ValidatedImmuableObject() extends ImmutableObject {

    private val range = NumericRange.apply(1, 3, 1)

    private def validate(x: Int): Boolean = {
      require(range contains x)
      true
    }

    /** what a silly, symbolic name! */
    def ?=(x: Int): Option[Int] = if (!validate(x)) None else Some(x)

    /**
      * Mutating an immutable object is not possible, so any mutators must return a new [[ImmutableObject]]
      *
      * @param y Int to cons onto existing list [[x]]
      * @return new [[ImmutableObject]] with updated [[x]]
      */
    override def :+(y: Int): ImmutableObject = if (!validate(y)) this else super.:+(y)

    /** what a silly, symbolic name! */
    def ?+=(y: Int): Option[ImmutableObject] = if (!validate(y)) None else Some(super.:+(y))
  }

}
