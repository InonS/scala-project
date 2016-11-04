package scala5marklewis.scala53ooadsus.scala532objectAndCaseClass

/**
  * scala-project
  * Created by admin on 2016-11-05.
  */
object Scala5322CaseClasses {

  case object NoParameters

  case class SomeParameters(x: Int)

  class SomeParametersExt(x: Int, y: Int) extends SomeParameters(x: Int)

  object SomeParametersExt {
    /** creating a clone, with fields changed if they appear as the appropriately named parameters */
    def copy(x: Option[Int] = Some(0), y: Option[Int] = Some(0)): SomeParametersExt = {
      new SomeParametersExt(x.get, y.get)
    }

    /** just like `apply`, but taking a single Tuple argument containing all default ctor. parameters */
    def tupled(ctorParams: (Int, Int)): SomeParametersExt = {
      new SomeParametersExt(ctorParams._1, ctorParams._2)
    }

    /** like `apply`, but taking some default ctor. parameters in curried calls
      * i.e. only the arguments in the first call are treated as case class parameters (automatic deffiniton as vals, equals, toString, copy, etc.)
      */
    def curried(x: Int): Int => Int => SomeParametersExt = {
      _ => new SomeParametersExt(x, _)
    }
  }

}
