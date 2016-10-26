package scala5marklewis.scala51ippsus.scala6sorting

import breeze.plot.{Figure, hist}

import scala.collection.mutable


/**
  * scala-project
  * Created by admin on 2016-10-27.
  */
object Scala20BubbleSort {

  def swap(arr: Array[Double], j: Int) {
    val tmp = arr(j)
    arr(j) = arr(j + 1)
    arr(j + 1) = tmp
    ops += 1
  }

  def bubbleSort(arr: Array[Double]) {
    val lastIndex = arr.length - 1
    for (i <- 0 until lastIndex; j <- 0 until (lastIndex - i)) {
      if (arr(j) > arr(j + 1)) swap(arr, j)
    }
  }

  private val decimalPlaces = 3
  private var ops = 0

  val inputLength: Int = 1 << 4

  def toRoundByDecimalPlaces(decimalPlaces: Int): (Double) => Double = {
    val factor = math.pow(inputLength, decimalPlaces).asInstanceOf[Int]
    d => (d * factor).asInstanceOf[Int].asInstanceOf[Double] / factor
  }

  val numSamples = 1 << 16

  def main(args: Array[String]) {
    val opses = mutable.MutableList[Int]()
    for (i <- 0 to numSamples) {
      println(i)
      example()
      opses += ops
      ops = 0
    }
    plot(opses, "Bubble Sort Ops")
  }

  def plot(counts: mutable.MutableList[Int], title: String) {
    val f = Figure()
    val p = f.subplot(0)
    val bins = riceRule()
    p += hist(counts, bins)
    p.title = title + " distribution"
    p.xlabel = "values"
    p.ylabel = "count"
    val cleanTitle = title.trim.replaceAll(" ", "_")
    f.saveas(cleanTitle + ".png")
  }

  /** [[https://en.wikipedia.org/wiki/Histogram#Number_of_bins_and_width]] */
  def riceRule(): Int = {
    math.max((2 * math.pow(numSamples, 1 / 3)).asInstanceOf[Int], 1 << 4)
  }

  def example() {
    val arr = Array.fill(inputLength)(math.random).map(toRoundByDecimalPlaces(decimalPlaces))
    println(arr.toStream mkString ", ")
    bubbleSort(arr)
    println(arr.toStream mkString ", ")
    println(s"input length = $inputLength, number of swaps = $ops")
  }
}
