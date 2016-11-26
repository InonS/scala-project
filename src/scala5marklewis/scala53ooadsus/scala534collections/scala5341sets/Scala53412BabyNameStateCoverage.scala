package scala5marklewis.scala53ooadsus.scala534collections.scala5341sets

import java.io.File
import java.nio.file.Paths

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * scala-project
  * Created by admin on 2016-11-26.
  *
  * https://www.ssa.gov/OACT/babynames/limits.html
  */
object Scala53412BabyNameStateCoverage extends App {

  trait NameRecord {
    def name: String
  }

  trait NameRecordCompanion[R <: NameRecord] {
    def apply(s: Array[String]): Option[R]
  }

  val year = 2015


  /** get national data */
  def nation(): Try[Set[String]] = {
    val nationalFile = {
      val nationalFileName = "yob" + year + ".TXT"
      (Paths get("rsc", "BabyNames", "National", nationalFileName)).toFile
    }

    object NationalRecord extends NameRecordCompanion[NationalRecord] {
      def apply(s: Array[String]): Option[NationalRecord] = NationalRecord(s(0), s(1)(0), s(2).toInt)

      def apply(name: String, gender: Char, count: Int): Option[NationalRecord] = {
        try {
          validate(name, gender, count)
          Some(new NationalRecord(name, gender == 'M', count))
        } catch {
          case t: Throwable => println((name, gender, count, t)); None
        }
      }

      private def validate(name: String, gender: Char, count: Int) {
        require(gender == 'F' || gender == 'M')
        // require(name forall (c => c.isLetter && c.isTitleCase))
        require(count > 0)
      }
    }

    case class NationalRecord(name: String, /* TitleCase */
                              isMale: Boolean /* read 'M'/'F' */ ,
                              count: Int /* positive definite */) extends NameRecord

    namesFromFile[NationalRecord](nationalFile, NationalRecord)
  }

  val nationNames = nation().get
  val numNationNames = nationNames.size

  /** get state data */
  def state() {
    def stateFile(state: String) = {
      val stateFileName = state + ".TXT"
      (Paths get("rsc", "BabyNames", "State", stateFileName)).toFile
    }

    object StateRecord extends NameRecordCompanion[StateRecord] {

      def apply(s: Array[String]): Option[StateRecord] = StateRecord(s(0), s(1)(0), s(2).toInt, s(3), s(4).toInt)

      def apply(state: String, gender: Char, year: Int, name: String, count: Int): Option[StateRecord] = {
        try {
          validate(state, gender, year, name, count)
          if (year != Scala53412BabyNameStateCoverage.year) return None
          Some(new StateRecord(state, gender == 'M', year, name, count))
        } catch {
          case t: Throwable => println((state, gender, year, name, count, t)); None
        }
      }

      private def validate(state: String, gender: Char, year: Int, name: String, count: Int) {
        require(state.length == 2)
        require(gender == 'F' || gender == 'M')
        require(year > 1900 && year < 2020)
        // require(name forall (c => c.isLetter && c.isTitleCase))
        require(count > 0)
      }
    }

    case class StateRecord(state: String /* length (2) */ ,
                           isMale: Boolean /* read 'M'/'F' */ ,
                           year: Int /* 1910 */ ,
                           name: String /* TitleCase */ ,
                           count: Int /* positive definite */) extends NameRecord

    val stateFiles = (Paths get("rsc", "BabyNames", "State")).toFile.listFiles() filter (fname => (fname.getName endsWith ".TXT") && fname.getName.length == 6)

    case class StateNameAndBabyNames(stateName: String, babyNames: Set[String])

    println("parsing:")
    val statesAndNames = stateFiles.map(stateFile => StateNameAndBabyNames(stateFile.getName take 2, namesFromFile[StateRecord](stateFile, StateRecord).get))

    println("coverage [%]:")
    statesAndNames.map(state_names => (state_names.stateName, (100.0 * state_names.babyNames.size / numNationNames).formatted("%2.0f%%"))).foreach(println)
  }

  private def namesFromFile[R <: NameRecord](f: File, o: NameRecordCompanion[R]): Try[Set[String]] = {
    println(s"parsing ${f.getName}")
    val source = Source fromFile f
    try {
      val lineIterator = source.getLines filter (_ nonEmpty)
      val csv = lineIterator.map(_ split ",")
      val records = csv.map(o(_)).filter(_.nonEmpty).map(_ get)
      val names = records.map(_ name).toSet
      Success(names)
    } catch {
      case t: Throwable => Failure(t)
    } finally {
      source.close()
    }
  }

  state()
}
