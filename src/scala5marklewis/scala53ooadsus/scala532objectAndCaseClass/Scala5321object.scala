package scala5marklewis.scala53ooadsus.scala532objectAndCaseClass

/**
  * scala-project
  * Created by admin on 2016-11-05.
  */
object Scala5321object {

  /** Class with private ctor.
    * Instances can only be constructed within an existing instance or by the Companion Object
    */
  class MyClass private()

  /**
    * object declaration to the Companion Object to [[MyClass]]
    * look, ma! no `static`!
    * has `private` visibility into instances of [[MyClass]]
    */
  object MyClass

}
