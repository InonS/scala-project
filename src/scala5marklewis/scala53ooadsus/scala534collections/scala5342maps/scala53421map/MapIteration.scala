package scala5marklewis.scala53ooadsus.scala534collections.scala5342maps.scala53421map

/**
  * scala-project
  * Created by admin on 2016-11-26.
  */
object MapIteration extends App {
  val firstVecOfTuple2 = (1 to 100).map(i => i.toString -> i)
  println(firstVecOfTuple2)

  /** two way to create a [[Map]] from a [[Seq[Tuple2]]: */
  // copy input (will be consumed)
  val sameVecOfTuple2 = firstVecOfTuple2

  // the right way
  val numMap = firstVecOfTuple2.toMap
  println(numMap)

  // the wrong way
  private val anotherVecOfTuple2 = sameVecOfTuple2.map(x => x)
  println(anotherVecOfTuple2)

  for ((k, v) <- numMap) println(s"$k -> $v")

  println(numMap.filter(entry => entry._2 % 17 == 4).map(entry => ("minus " + entry._1, entry._2 * -1)))
}
