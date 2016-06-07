package scala3craigtataryn

import scala.math._

/**
  * Created by admin on 2016-06-06.
  */
object Scala2FP_TypesAndLiterals {
  def main(args: Array[String]) {

    // Functions are first class citizens! have their own type
    println(Function)

    // function types
    class IntAdder extends Function2[Int, Int, Int] {
      override def apply(v1: Int, v2: Int): Int = v1 + v2
    }

    val intAdder = new IntAdder
    " three = " + intAdder(1, 2)

    // Unary function taking Int to Int: (Int) => Int
    class IntDoubler extends ((Int) => Int) {
      override def apply(v1: Int) = 2 * v1 // return type inferred, but not parameter type...
    }

    val intDoubler = new IntDoubler
    " four = " + intDoubler(2)


    // function literal (lambda)
    // '''declaration: definition = implementation'''
    // declaration: {{{val IntCuber}}}
    // definition: {{{(Int) => Int}}}
    // implementation: {{{(v1) => v1 * v1 * v1}}}
    val IntCuber: Int => Int = v1 => v1 * v1 * v1

    " eight = " + IntCuber(2)

    // using type inference
    val IntSqr = (x: Int) => pow(x, 2)
    println(IntSqr)

    // referencing unary function using an implicit parameter
    val IntSqrt = sqrt _
    println(IntSqrt)
  }
}
