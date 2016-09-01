package scala5marklewis.scala51ippsus.scala1matchcase

/**
  * scala-project
  * Created by admin on 2016-06-07.
  *
  * declaration keywords:
  * {{{val}}}, {{{var}}}: Object
  * {{{def}}}: Function
  * {{{class}}}: Class
  * {{{trait}}}: Trait ( ~ interface)
  * {{{object}}}: companion object
  * {{{case}}}: case class
  *
  * and now... {{{type}}}
  *
  */
object Scala1TypeDeclaration {

  def main(args: Array[String]) {

    // Example: Add 3-D vectors
    def addVector3a(v1: (Double, Double, Double), v2: (Double, Double, Double)): (Double, Double, Double) = (v1._1 + v2._1, v1._2 + v2._2, v1._3 + v2._3)

    // A type alias gives a more meaningful name to the type of the arguments and return value
    type Vector3 = (Double, Double, Double)
    def addVector3b(v1: Vector3, v2: Vector3): Vector3 = (v1._1 + v2._1, v1._2 + v2._2, v1._3 + v2._3)
  }
}
