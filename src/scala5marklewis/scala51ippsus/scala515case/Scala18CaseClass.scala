package scala5marklewis.scala51ippsus.scala515case

import scala.util.Random

/**
  * scala-project
  * Created by admin on 2016-10-10.
  */
object Scala18CaseClass {

  def theTroubleWithTuples() {
    // tuple
    val student = ("Mark", 22, 3.6)
    val studentName = student._1
    val (name, _, _) = student
    assert(name == studentName)

    // tuples with same signature are not unique
    type Point3D = (Double, Double, Double)
    def mag(p: Point3D): Double = (p.productIterator map (_.asInstanceOf[Double]) map (math pow(_, 2))).sum
    val p = (1.0, 2.0, 4.0)
    val m = mag(p)
    println(m)

    type Color = (Double, Double, Double)
    val c = (1.0, 2.0, 4.0)
    val n = mag(c)
    println(n)

    assert(m == n)
    // we need pattern matching to discern between Product Types
  }

  case class Point3D(x: Double, y: Double, z: Double)

  case class Student(name: String, age: Int, asgn: List[Int], quiz: List[Int], exam: List[Int], gpa: Double)

  def usingCaseClasses() {
    // case class fields (a.k.a. methods) are immutable

    val p = Point3D(1.0, 2.0, 3.0)
    def dist(p1: Point3D, p2: Point3D): Double = {
      val dx: Double = p1.x - p2.x
      val dy: Double = p1.y - p2.y
      val dz: Double = p1.z - p2.z
      dx * dx + dy * dy + dz * dz
    }
    println(dist(p, Point3D(4.0, 5.0, 6.0)))

    val stu = Student("Mark", 22, List(90, 88), List(100, 95), List(96, 84, 72), 3.6)
    def average(s: Student): Double = {
      0.4 * s.exam.sum / s.exam.length + 0.1 * s.quiz.sum / s.quiz.length + 0.5 * s.asgn.sum / s.asgn.length
    }
    println(average(stu))
  }

  def namedAndDefaultArguments() {

    def evalQuad(a: Double = 0, b: Double = 0, c: Double = 0, x: Double): Double = {
      c + x * (b + a * x)
    }

    // named arguments (can be used even without change to function definition)
    assert(evalQuad(1, 0, 0, 2) == evalQuad(1, 0, x = 2, c = 0))

    // default argument values (required in function definition in order to be used later)
    assert(evalQuad(0, 1, 0, 4) == evalQuad(x = 4, b = 1))
  }

  def copyMethod() {
    // like clone() for (immutable) case class. Basically, factory method construction with the added benefit of default arguments.
    val p = Point3D(1.0, 2.0, 3.0)
    val p1 = Point3D(1 + p.x, p.y, p.z)
    val pCopy1 = p.copy(1 + p.x)
    assert(p1 == pCopy1)

    val s = Student("Mark", 0, Nil, Nil, Nil, 0)
    val sCopyAsgn = s.copy(asgn = 99 :: s.asgn)
    val sCopyAsgnAge = sCopyAsgn.copy(age = 22)
    println(sCopyAsgnAge.name, sCopyAsgnAge.age, sCopyAsgnAge.asgn)
  }

  def caseClassPatterns() {

    // 'for' pattern matching

    // math random
    val points = Array.fill(20)(Point3D(Random.nextDouble, Random.nextDouble, Random.nextDouble))
    val radii = for (Point3D(eggs, why, _) <- points) yield math.sqrt(eggs * eggs + why * why)
    println(radii.toStream.mkString(","))

    // 'list' pattern matching
    def randomGradeList: List[Int] = {
      List.fill(Random.nextInt(5))(Random.nextInt(100))
    }
    val students = Array.fill(20)(Student(Random.nextString(Random.nextInt(10)), Random.nextInt(80), randomGradeList, randomGradeList, randomGradeList, Random.nextInt(100) / 20))
    val averageFirst3Asgns = for (Student(name, _, List(a1, a2, a3, _), _, _, _) <- students) yield (name, (a1 + a2 + a3) / 3)
    println(averageFirst3Asgns.toStream.mkString(","))
  }

  def mutableCaseClass() {

    /** default ctor. parameters are explicitly variable */
    case class MutPoint3D(var x: Double, var y: Double, var z: Double)

    val mp: MutPoint3D = MutPoint3D(0, 1, 2)

    println(mp)
    mp.z = -1
    println(mp)
    assert(mp.equals(MutPoint3D(0, 1, -1)))
  }

  def main(args: Array[String]) {
    theTroubleWithTuples()
    usingCaseClasses()
    namedAndDefaultArguments()
    copyMethod()
    caseClassPatterns()
    mutableCaseClass()
  }
}
