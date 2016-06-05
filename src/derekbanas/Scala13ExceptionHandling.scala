package derekbanas

/**
  * Created by admin on 2016-06-04.
  */
object Scala13ExceptionHandling {
  def main(args: Array[String]) {
    // divison by zero
    def divideNums(num1: Int, num2: Int) = {
      try {
        num1 / num2
      } catch {
        case ex: ArithmeticException => "Can't divide by zero!"
      } finally {
        // cleanup after exception
      }
    }

    println(" 3 / 0 = " + divideNums(3, 0))
  }
}
