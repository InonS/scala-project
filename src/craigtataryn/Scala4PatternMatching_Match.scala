package craigtataryn

/**
  * Created by admin on 2016-06-06.
  */
object Scala4PatternMatching_Match {
  def main(args: Array[String]) {

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
    val matched = sentence match {
      // using string interpolation
      case "The" :: xs => s"Sentence starts with 'The', rest is $xs"
      case first :: second :: _ => s"First word: '$first', second word: '$second', threw away the rest"
      case _ => "no match found"
    }
    println(matched)
  }
}
