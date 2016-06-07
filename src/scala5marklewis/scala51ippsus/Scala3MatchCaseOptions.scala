package scala5marklewis.scala51ippsus

import javax.lang.model

/**
  * scala-project
  * Created by admin on 2016-06-07.
  */
object Scala3MatchCaseOptions {


  def matchCasePatternExample(expr: (Int, Int)): Unit = {

    println("expression to match = " + expr)
    expr match {
      case (0, 1) => println(expr + " fully matched the 2-tuple (a.k.a pair) with first member = 0 and second member = 1")
      case (2, _) => println(expr + " matched any 2-tuple with first member = 2, wasn't instructed to capture second member")
      case (x, 3) => println(expr + " matched a 2-tuple with second member = 3 and any first member. In this case, the first member capture is " + x)
      case (x, 4) if x % 2 == 0 => println(expr + " matched a 2-tuple with second member = 4 and any EVEN first member (used 'if guards'). In this case, the first member capture is " + x)
      case (x, 4) => println(expr + " matched a 2-tuple with second member = 4 and any ODD first member (based on previous pattern being missed). In this case, the first member capture is " + x)
      case (_, _) => println(expr + " matched any other 2-tuple pattern, irrespective of data, based only on structure.")
    }
  }

  def main(args: Array[String]) {

  }
}
