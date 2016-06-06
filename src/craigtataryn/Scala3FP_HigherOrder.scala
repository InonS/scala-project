package craigtataryn

/**
  * Created by admin on 2016-06-06.
  */
object Scala3FP_HigherOrder {

  def main(args: Array[String]) {

    // higher-order functions

    // closure
    def enclosingMultiplier(myX: MyX): (Int) => Int = {
      (y: Int) => myX.x * y
    }

    val myNumber = new MyX(2)

    val enclosedMultiplier = enclosingMultiplier(myNumber)

    enclosedMultiplier(3)

    myNumber.x = 5

    enclosedMultiplier(3)

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // define a function which returns a callable (function)
    def callbacker(n: Int): () => Int = {
      () => n * 2
    }

    val callback = callbacker(5)

    // execute nullary callback
    callback()

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    def funcThat(f: Int => Int, x: Int) = f(x)

    funcThat(x => {
      val tmp = x + x;
      tmp * x
    }, 2)
  }


  class MyX(yourX: Int) {
    var x: Int = yourX
  }
}
