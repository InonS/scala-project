package scala5marklewis.scala53ooadsus.scala534collections.scala5341sets

import scala.collection.{TraversableOnce, mutable}

/**
  * scala-project
  * Created by admin on 2016-11-23.
  */
object MutableSet extends App {
  /** note informative yet terse import (no dot-underscore!), allowing mutable and (default) immutable */
  val mSet = mutable.Set(1, 2, 3)

  /** same mutators as [[scala.collection.immutable.Set]] still work,
    * but to conserve behavior, their semantics are identical with those for immutable collection */
  mSet + -1
  println(mSet)

  /** however, [[scala.collection.mutable]] allow in-place mutation */
  mSet += 4
  println(mSet)
  mSet -= 1
  println(mSet)

  /** analogue of [[java.util.Collection]] addAll works on all [[TraversableOnce]] */
  mSet ++= Set(10, 20)
  println(mSet)

  /** [[scala.collection.mutable.Set.add()]] and [[scala.collection.mutable.Set.remove()]] returns [[Boolean]] whether [[Set]] has changed */
  println(mSet.add(1))
  println(mSet.remove(1))

  mSet.clear()
  mSet ++= 0 to 10

  /** again, [[scala.collection.GenTraversableLike]] semantics for mutable are identical with those for immutable collections */
  mSet.filter(_ % 2 == 0)
  println(mSet)

  mSet.retain(_ % 2 == 0)
  println(mSet(3))

  /** explicit [[mutable.Set.update()]] call, and implicit */
  mSet.update(3, true)
  mSet(4) = false
  println(mSet)
}
