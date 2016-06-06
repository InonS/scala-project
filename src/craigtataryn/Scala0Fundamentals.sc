/**
  * https://www.youtube.com/watch?v=ugHsIj60VfQ
  */

import scala.math.{pow, sqrt}


// type inference
// (c.f. reversed diamond syntax)


// -------------------------------------------------------

// call by name:
// parameter type not given (will be a block of code, which in this example must return a Boolean)
def transaction(code: => Boolean) = {
  code
}

// parameter passed is a block of code returning a Boolean
transaction {
  println("DO CODE")
  true
}


// ------------------------------------------------------


// Functions are first class citizens! have their own type
Function

// function types
class IntAdder extends Function2[Int, Int, Int] {
  override def apply(v1: Int, v2: Int): Int = v1 + v2
}

val intAdder = new IntAdder
" three = " + intAdder(1, 2)

// Unary function taking Int to Int: (Int) => Int
class IntDoubler extends ((Int) => Int) {
  override def apply(v1: Int) = 2 * v1 // return type inferred, but not parameter type...
}

val intDoubler = new IntDoubler
" four = " + intDoubler(2)


// function literal (lambda)
// '''declaration: definition = implementation'''
// declaration: {{{val IntCuber}}}
// definition: {{{(Int) => Int}}}
// implementation: {{{(v1) => v1 * v1 * v1}}}
val IntCuber: Int => Int = v1 => v1 * v1 * v1

" eight = " + IntCuber(2)

// using type inference
val IntSqr = (x: Int) => pow(x, 2)

// referencing unary function using an implicit parameter
val IntSqrt = sqrt _

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

class MyX(yourX: Int) {
  var x: Int = yourX
}

// higher-order functions

// closure
def enclosingMultiplier(myX: MyX): (Int) => Int = {
  (y: Int) => myX.x * y
}

var myNumber = new MyX(2)

val enclosedMultiplier = enclosingMultiplier(myNumber)

enclosedMultiplier(3)

myNumber.x = 5

enclosedMultiplier(3)

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// define a function which returns a callable (function)
def callbacker(n: Int): () => Int = {
  () => n * 2
}

val callback = callbacker(5)

// execute nullary callback
callback _

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

def funcThat(f: Int => Int, x: Int) = f(x)

funcThat(x => {
  val tmp = x + x;
  tmp * x
}, 2)

// -------------------------------------------------------

// pattern matching: Expressiveness and flexibility (ad-hoc match-case)

// string contains
val searchType = "four"
searchType match {
  case "One" => println(1)
  case "Two" => println(2)
  case "Three" => println(3)
  case _ => println("More than three")
}

// regex
// TODO bug: matches everything!
val matchContainsOne = "^.*One.*$"
val list = List("TwentyOne", "ThirtyTwo", "FortyFive", "FiftyOne") // uses List factory method
for (num <- list) {
  num match {
    case `matchContainsOne` => println("contains One!")
    case _ => println("does not contain One!")
  }
}

// match on the concatenation operator, [[cons]], [[::]]
val sentence = List("The", "best", "things", "in", "life", "are", "free")
sentence match {
  // using string interpolation
  case "The" :: xs => s"Sentence starts with 'The', rest is $xs"
  case first :: second :: _ => s"First word: '$first', second word: '$second', threw away the rest"
  case _ => "no match found"
}

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

// flexibility: (ad-hoc) case implements unapply method, used to unwrap user class fields, and perform matching on the known classes of these fields
case class PersonName(fst: String, lst: String) {
  var first: String = fst
  var last: String = lst
}

// for non-case class, we'd need to implement the unapply method in the companion object
/*
object PersonName {
  def unapply(name: PersonName): (String, String) = (name.first, name.last)
}
*/


val thisGuy = new PersonName("our", "guy")
thisGuy match {
  case PersonName("my", "guy") => println("found my guy!")
  case PersonName("your", "guy") => println("found your guy!")
  case PersonName("my", "shoes") => println("found my shoes!")
  case PersonName(_, "guy") => println("found some guy!")
}
