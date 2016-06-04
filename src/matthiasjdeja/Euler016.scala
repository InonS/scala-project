package matthiasjdeja

/**
  * Created by admin on 2016-06-04.
  *
  * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
  *
  * What is the sum of the digits of the number 2^1000?
  *
  */
object Euler016 {

  def main(args: Array[String]) {

    // use Java BigInteger? no, use the Scala class!
    val num: BigInt = BigInt(2).pow(1000)

    // Scala String is also a character array!
    val sum: Int = num.toString.map(_.asDigit).sum

    println(sum)
  }
}
