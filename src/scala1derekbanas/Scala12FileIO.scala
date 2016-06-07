package scala1derekbanas

import java.io.PrintWriter

import scala.io.Source

/**
  * Created by admin on 2016-06-04.
  */
object Scala12FileIO {

  def main(args: Array[String]) {
    val writer = new PrintWriter("test.txt")
    writer.write("Just some random text;\nsome more random text.")
    writer.close()

    val textFromFile = Source.fromFile("test.txt", "UTF-8")
    val lineIterator = textFromFile.getLines
    for (line <- lineIterator) println(line)

    textFromFile.close
  }

}
