package scala5marklewis.scala51ippsus.scala2collections

/**
  * scala-project
  * Created by admin on 2016-07-01.
  */
object Scala12ParametricFunctions {

  def identity[T](t: T): T = t

  def main(args: Array[String]) {
    println(identity(1))
    println(identity(1.0))
    println(identity("a"))

    println(ourFold(List(1, 2, 3, 4, 5), 0)(_ + _))
    println(ourFold(List(1, 2, 3, 4, 5), "")(_ + _))
  }

  /**
    *
    * first parameter list:
    *
    * @param lst
    * @param base
    *
    * second parameter list:
    * @param f
    * @tparam A
    * @tparam B
    * @return
    */
  def ourFold[A, B](lst: List[A], base: B)(f: (A, B) => B): B = lst match {
    case Nil => base
    case h :: t => f(h, ourFold(t, base)(f))
  }

}

