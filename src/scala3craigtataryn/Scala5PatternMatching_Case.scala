package scala3craigtataryn

/**
  * Created by admin on 2016-06-06.
  */
object Scala5PatternMatching_Case {
  def main(args: Array[String]) {
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
  }
}
