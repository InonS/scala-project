package scala1derekbanas

import scala.io.StdIn.{readLine, readInt}


/**
  * Created by admin on 2016-05-30.
  */
object Scala2ConsoleIO {
  def main(args: Array[String]) {
    var numberGuess = 0

    // reading line from console and converting to Int
    do {
      print("Guess a number ")
      numberGuess = readLine.toInt
      // numberGuess = readInt
    } while (numberGuess != 15)

    // explicit C-style printf
    printf("You guessed the secret number %d\n", 15)

    // justification and filling
    printf("'%5d'\n", 5) // right justified
    printf("'%-5d'\n", 5) // left justified
    printf("'%05d'\n", 5) // zero-filled
    printf("'%.5f'\n", 5.0) // fixed decimal places
    printf("'%-5s'\n", "cat") // left justified text


    val name = "Derek"
    val age = 39
    val weight = 175.5

    // substituted text output
    println(s"Hello $name")

    // formatted text output
    println(f"I am under ${age + 1} and weigh exactly $weight%.2f")


    val randSentence = "I saw a dragon fly by"

    // String as zero-based Char array
    println("3rd index: " + randSentence(3))
    println("string length: " + randSentence.length)
    println(randSentence.concat(" and explode"))
    println("Are strings equal? " + "I saw a dragon".equals(randSentence))
    println("the word 'dragon' starts at index " + randSentence.indexOf("dragon"))

    // iterating through String requires making an explicit array out of it
    val randSentenceArray = randSentence.toArray
    for (v <- randSentenceArray) println(v)
  }
}
