package craigtataryn

/**
  * Created by admin on 2016-06-06.
  */
object Scala1CallByName {
  def main(args: Array[String]) {

    // call by name:
    // parameter type not given (will be a block of code, which in this example must return a Boolean)
    def transaction(code: => Boolean) = {
      code
    }

    // parameter passed is a block of code returning a Boolean
    transaction {
      println("DO CODE")
      true
    }
  }
}
