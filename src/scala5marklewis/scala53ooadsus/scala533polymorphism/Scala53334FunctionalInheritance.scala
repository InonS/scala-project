package scala5marklewis.scala53ooadsus.scala533polymorphism

/**
  * scala-project
  * Created by admin on 2016-11-20.
  */
object Scala53334FunctionalInheritance {

  /**
    * Functional object (callable), but does not implement functional interface, so can't be used just everywhere one of those is expected
    * @param _n
    */
  class C(_n: Int) {
    // def apply(i: Int): C = new C(2 * i)
    def apply(i: Int) = _n * i

    def n = _n
  }

  /**
    * Implements functional interface, so can be used in places where one of those is expected (monad)
    * @param _n
    */
  class F(val _n: Int) extends (Int => Int) {
    // (Int => F) {
    // def apply(i: Int): F = new F(2 * i)
    def apply(i: Int) = _n * i

    def n = _n
  }

  def main(args: Array[String]) {
    val ints = List(1, 2, 3)

    val f = new F(2)
    println(ints map f)

    /*val cs = ints map (new C(_))
    println(cs)
    println(cs map (_.n))

    val fs = ints map (new F(_))
    println(fs)
    println(fs map (_.n))*/
  }

}
