package scala5marklewis.scala51ippsus.scala513forloop

/**
  * scala-project
  * Created by admin on 2016-08-07.
  */
object Scala13Yield {
  def main(args: Array[String]) {
    // 3x^2 + 2x - 5
    val coeffs = Array(3.0, 2.0, -5.0)
    val x = 1

    print(evalPolyRange(coeffs, x))
    print(evalPolyYield(coeffs, x))
  }

  def evalPolyRange(coeffs: Array[Double], x: Double): Double = {
    var sum = 0.0
    var power = 1.0 // math.pow(x, 0)
    for (i <- coeffs indices) {
      sum += coeffs(i) * power // this iteration's 'power' was calculated on previous iteration
      power *= x // math.pow(x, i) for next iteration
    }
    sum
  }

  def evalPolyYield(coeffs: Array[Double], x: Double): Double = {
    yieldMonomialEval(coeffs, x).sum
  }

  private def yieldMonomialEval(coeffs: Array[Double], x: Double): IndexedSeq[Double] = {
    for (i <- coeffs indices) yield {
      coeffs(i) * math.pow(x, coeffs.length - 1 - i)
    }
  }
}
