package scala5marklewis.scala53ooadsus.scala534collections.scala5341sets

/**
  * scala-project
  * Created by admin on 2016-11-22.
  */
object ImmutableSet extends App {
  val set0 = Set("hello", "world")
  println(set0)

  /** [[scala.collection.immutable.Set]] mutators return new [[Set]] */
  val set1 = set0 + "dude"
  println(set1)
  val set2 = set1 - "world"
  println(set2)

  /** [[Set.apply()]] does [[java.util.Set]] contains, like [[Seq.apply()]] does indexing */
  val isOneIndexedInSet: Boolean = set1("hello")
  println(isOneIndexedInSet)

  /** [[Set]] implements [[scala.collection.GenTraversableLike]]:
    * [[scala.collection.GenTraversableLike.map()]],
    * [[scala.collection.GenTraversableLike.filter()]],
    * [[scala.collection.GenTraversableOnce.foreach()]] (allowing for-loops),
    * etc.
    */
  val doubled = set1.map(_ * 2)
  println(doubled)
  val filterDs = set1.filter(_.contains("d"))
  println(filterDs)
  val forloop = for (_ <- set1) println

  //
}
