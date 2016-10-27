package scala5marklewis.scala51ippsus.scala6sorting

/**
  * scala-project
  * Created by admin on 2016-10-27.
  */
object Scala21SelectionSort {

  def swap(a: Array[Double], i: Int, min: Int) {
    val tmp = a(i)
    a(i) = a(min)
    a(min) = tmp
  }

  def minSort(a: Array[Double]) {
    for (i <- a.indices) {
      var min = i
      for (j <- i + 1 until a.length)
        if (a(j) < a(min)) min = j
      swap(a, i, min)
    }
  }


  val n = 10

  def main(args: Array[String]) {
    val arr = Array.fill(n)(math.random).map(_ * 1000) map (_.asInstanceOf[Int]) map (_.asInstanceOf[Double]) map (_ / 1000)
    println(arr.toStream mkString ", ")
    minSort(arr)
    println(arr.toStream mkString ", ")
  }
}
