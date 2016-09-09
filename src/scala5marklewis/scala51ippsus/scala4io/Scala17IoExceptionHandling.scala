package scala5marklewis.scala51ippsus.scala4io

import java.io.{FileNotFoundException, IOException}
import java.nio.file.{InvalidPathException, Paths}
import java.util.NoSuchElementException

import scala.io.Source

/**
  * scala-project
  * Created by admin on 2016-09-09.
  */
object Scala17IoExceptionHandling {
  def main(args: Array[String]): Unit = {

    val k = 10
    val inFileName: String = "ND.TXT"

    /** try getting resource */
    try {
      val inFile = Paths get("rsc", inFileName) toFile
      val source = Source fromFile inFile

      /** try-with-resource: 'source' */
      try {
        val lines = source getLines
        val totalBabiesWithTopTenNames = lines filter (_ nonEmpty) take k map (_ split "," toList) map (_ last) map (_ toInt) sum;
        println(s"average number of babies born in 2015 in %s with a Top $k name: ".format(inFileName substring(0, 2)) + totalBabiesWithTopTenNames / k)
      }
      catch {
        case _: NoSuchElementException => println("'next' on empty iterator!")
        case _: NumberFormatException => println("number format exception!")
      }
      finally {
        source close
      }

    } catch {
      case _: InvalidPathException => println("invalid path!")
      case _: FileNotFoundException => println(inFileName + " not found!")
      case _: IOException => println("other I/O exception!")
      case e => println("an badly unexpected exception has been thrown! " + e)
    }
  }
}