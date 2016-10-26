package scala5marklewis.scala51ippsus.scala1matchcase

/**
  * scala-project
  * Created by admin on 2016-06-08.
  */
object Scala4RecursiveFizzBuzz {

  def fizzBuzz(n: Int) {

    val isFizz: Boolean = n % 3 == 0
    val isBuzz: Boolean = n % 5 == 0
    val isBoom: Boolean = (n % 7 == 0) || (n.toString.toCharArray contains '7')

    (isFizz, isBuzz, isBoom) match {

      // always lead with your base case, otherwise you risk another pattern matching and you get a runaway infinite loop!
      case (true, true, true) => println("fizzbuzzboom"); return

        // match cases do not have a fallthrough like C or Java switch
      case (true, true, _) => println("fizzbuzz")
      case (true, _, true) => println("fizzboom")
      case (_, true, true) => println("buzzboom")

      case (true, _, _) => println("fizz")
      case (_, true, _) => println("buzz")
      case (_, _, true) => println("boom")

      case _ => println(n)
    }
    fizzBuzz(n + 1)
  }

  def main(args: Array[String]) {
    fizzBuzz(1)
  }
}
