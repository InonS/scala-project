package derekbanas

/**
  * Created by admin on 2016-05-30.
  */
object Scala3Functions {
  def main(args: Array[String]) {

    def getSum(num1: Int = 1, num2: Int = 1): Int = {
      // body
      num1 + num2 // last line value is implicitly returned
    }

    println("5 + 4 = " + getSum(5, 4) + " = 4 + 5 = " + getSum(num2 = 4, num1 = 5))

    // a Function that does not return anything is called a Procedure
    def sayHi(numTimes: Int = 1): Unit = {
      var i = 0
      while (i < numTimes) {
        println("Hi, how are you?")
        i += 1
      }
    }

    sayHi(3)

    // a variable number of arguments can be passed using '*' after the type
    def getSums(args: Int*): Int = {
      var sum: Int = 0 // type hinting and initialization of a variable
      for (num <- args) {
        sum += num
      }
      sum // implicit return
    }

    println("sum is = " + getSums(1, 2, 3, 4, 5, 6))


    // recursion
    def factorial(num: BigInt): BigInt = {
      if (num <= 1) 1
      else num * factorial(num - 1)
    }

    println("factorial of 4 = " + factorial(4))
  }
}
