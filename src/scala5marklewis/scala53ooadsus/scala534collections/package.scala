package scala5marklewis.scala53ooadsus

/**
  * scala-project
  * Created by admin on 2016-12-13.
  *
  * Scala mutable collections special method names conventions:
  *
  * @see [[collection.generic.Sizing]]
  *   1. Methods ending with colon (':') are right-associative, i.e. elem +: coll means pre-pend the element 'elem' to the collection 'coll'
  * @see [[collection.generic.Clearable]]
  * @see [[collection.generic.Growable]]
  *   2. Increment-assignment method names imply appending, i.e. coll += elem means append the element 'elem' to the mutable collection 'coll'
  *   3. Self-increment-assignment implies appending another collection, i.e. theOther += theOne means appending 'theOne' collection onto 'theOther' (mutable) collection
  *   4. List method names with double-colon ('::', a.k.a. 'cons') imply concatenation, e.g. immutableColl :: elem and mutableColl ::= elem mean return the immuable/mutable collection formed when appending the new element 'elem' onto the old collection, respectively
  * @see [[collection.generic.Subtractable]]
  *   6. Corollaries: -= , --= , +=: , ++=:
  *   7. See also: [[collection.mutable.Builder]]
  *   7. The apply and update methods on an Indexed Collection are used for sub-scripting -- accessing or mutating, respectively, a specific element, either based on its position (Array) or membership (Set)
  * @see [[collection.generic.Sorted]]
  * @see [[collection.mutable.BufferLike]]
  * @see [[collection.GenTraversableOnce]]
  * @see [[collection.GenTraversableLike]]
  * @see [[scala.collection.GenIterableLike]]
  * @see [[collection.GenSeqLike]]
  * @see [[collection.GenSetLike]]
  * @see [[collection.GenMapLike]]
  * @see [[collection.Parallelizable]]
  * @see [[collection.generic.Signalling]]
  * @see [[collection]]
  * @see [[Product]]
  */
package object scala534collections {

}
