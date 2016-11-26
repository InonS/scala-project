package scala5marklewis.scala53ooadsus.scala534collections.scala5342maps.scala53421map

/**
  * scala-project
  * Created by admin on 2016-11-26.
  */
object Maps extends App {

  /** instanciaton: using [[ArrowAssoc()]] to create a [[Tuple2]], a.k.a. [[Pair]] */
  val numMap = Map("one" -> 1, "two" -> 2, "three" -> 3)
  println(numMap)

  // indexing (again, implicit call to 'apply')
  println(numMap("two"))

  /** sparse storage. c.f. [[Array]] */
  val decMap = Map(10 -> "ten", 100 -> "hundred", 1000 -> "thousand")
  println(decMap)
  println(decMap(100))

  // mutators
  val decMap04 = decMap + (10000 -> "revava")
  val decMap14 = decMap04 - 10
  println(decMap14)
}
