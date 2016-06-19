package scala5marklewis.scala51ippsus

/**
  * scala-project
  * Created by admin on 2016-06-20.
  */
object Scala9StringsAsCollections {

  def main(args: Array[String]) {
    val str = "This   is a test."
    println(str(3))

    str foreach println
    println(str map (_ + 1) map (_.toChar) mkString ",")
    println(str count ("aeiou" contains _))
    str split " " foreach println
    str split " +" foreach println
    println("1 2 3 4 5" split " " map (_ toInt) mkString ",")
  }

}
