package scala5marklewis.scala51ippsus

import scala.reflect.io.File.separator

/**
  * scala-project
  * Created by admin on 2016-06-20.
  */

object Scala10BabyNames {

  type NameData = (String, Int, String, Int)

  def parseLine(line: String): NameData = {
    val parts = line split ","
    (parts(1), parts(2) toInt, parts(3), parts(4) toInt) // skip state
  }

  def main(args: Array[String]) {

    val nameData: Iterator[NameData] = getNameData
    // nameData foreach println

    val topFemaleNamesOf1988 = getTopFemalesNameOf1988(nameData)
    topFemaleNamesOf1988 map (_._3) foreach println
  }

  private def getTopFemalesNameOf1988(nameData: Iterator[NameData]) = {
    val f1988 = nameData filter (nd => nd._1 == "F" && nd._2 == 1988) toList
    // println(f1988 mkString ",")

    val maxNames = (f1988 map (_._4)).max
    f1988 filter (_._4 == maxNames)
  }

  private def getNameData: Iterator[NameData] = {
    /*
    val nameLines = Array.fill(43858)(io.StdIn.readLine)
    nameLines map parseLine
    */

    val fileName: String = "rsc" + separator + "ND.txt"
    val source = io.Source.fromFile(fileName)
    source getLines() map parseLine
  }
}

