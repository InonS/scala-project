package scala5marklewis.scala51ippsus.scala7xml

import scala.collection.immutable.Seq
import scala.xml.{Elem, Node, NodeSeq, XML}

/**
  * scala-project
  * Created by admin on 2016-10-27.
  */
object Scala22xml {

  def xSearchOneLevel(elem: Elem, tag: String, isAttribute: Boolean = false): NodeSeq = {
    println()
    val tg = if (isAttribute) "@" concat tag else tag
    val res = elem \ tg // backslash
    print(res.toStream mkString ", ")
    res
  }

  def xSearchAnyLevel(elem: Elem, tag: String, isAttribute: Boolean = false): NodeSeq = {
    println()
    val tg = if (isAttribute) "@" concat tag else tag
    val res = elem \\ tg // double backslash
    print(res.toStream mkString ", ")
    res
  }

  def xSearchGetText(elem: Elem, tag: String, isAttribute: Boolean = false): String = {
    val tg = if (isAttribute) "@" concat tag else tag
    (elem \\ tg).text
  }

  def xSearch(elem: Elem): String = {
    xSearchOneLevel(elem, "student")
    xSearchAnyLevel(elem, "fname", isAttribute = true)
    val courseName = xSearchGetText(elem, "courseName")
    println('\n' + courseName)
    courseName
  }

  def xSearchGetTextNode(elem: Node, tag: String, isAttribute: Boolean = false): String = {
    val tg = if (isAttribute) "@" concat tag else tag
    (elem \ tg).text
  }

  case class GradeAndComment(value: Int, comment: String)

  case class Quiz(grade: GradeAndComment)

  case class Assignment(grade: GradeAndComment)

  case class Exam(grade: GradeAndComment)

  case class Student(fname: String, lname: String, quizzes: List[Quiz], assignments: List[Assignment], exams: List[Exam])

  object StudentA {
    def unapply(node: Node): Student = {
      val fname: String = xSearchGetTextNode(node, "fname", isAttribute = true)
      val lname: String = xSearchGetTextNode(node, "lname", isAttribute = true)
      val quizNodes = node \ "quizzes"
      val quizzesSeq: Seq[Quiz] = quizNodes map QuizA.unapply
      val quizzes: List[Quiz] = quizzesSeq.toList
      val assignmentNodes = node \ "assignments"
      val assignments: List[Assignment] = AssignmentA.unapplySeq(assignmentNodes)
      val examNodes = node \ "exams"
      val exams: List[Exam] = ExamA.unapplySeq(examNodes)
      Student(fname, lname, quizzes, assignments, exams)
    }

    def apply(student: Student): Node = {
      <student fname={student.fname} lname={student.lname}>
        <quizzes>
          {student.quizzes.map(QuizA.apply)}
        </quizzes>
        <assignments>
          {student.assignments map AssignmentA.apply}
        </assignments>
        <exams>
          {student.exams map ExamA.apply}
        </exams>
      </student>
    }
  }

  object GradeAndCommentA {
    def unapply(node: Node): GradeAndComment = {
      val gradeText = xSearchGetTextNode(node, "grade", isAttribute = true)
      GradeAndComment(if (gradeText.nonEmpty) gradeText.toInt else 0, node.text)
    }
  }

  object QuizA {
    def unapply(node: Node): Quiz = {
      Quiz(GradeAndCommentA.unapply(node))
    }

    def apply(quiz: Quiz): Node = {
      <quiz grade={quiz.grade.value.toString}>
        {quiz.grade.comment}
      </quiz>
    }
  }

  object AssignmentA {
    def unapplySeq(nodes: NodeSeq): List[Assignment] = (nodes map GradeAndCommentA.unapply map Assignment).toList

    def apply(assignment: Assignment): Node = {
      <assignment grade={assignment.grade.value.toString}>
        {assignment.grade.comment}
      </assignment>
    }
  }

  object ExamA {
    def unapplySeq(nodes: NodeSeq): List[Exam] = (nodes map GradeAndCommentA.unapply map Exam).toList

    def apply(exam: Exam): Node = {
      <exam grade={exam.grade.value.toString}>
        {exam.grade.comment}
      </exam>
    }
  }

  def deserialize(elem: Elem): List[Student] = {
    val students = (elem \ "student" map StudentA.unapply).toList
    print(students.toStream mkString ", ")
    students
  }

  def serialize(elem: Elem, courseName: String, students: List[Student]) {
    XML.save("rsc/" + "grades2.xml", <gradeBook>
      <courseName>
        {courseName}
      </courseName>{students.map(StudentA.apply)}
    </gradeBook>)
  }

  def main(args: Array[String]) {
    xmlElement()
    val elem: Elem = xmlLoadFile()
    val courseName = xSearch(elem)
    val students = deserialize(elem)
    students.foreach(Exam(GradeAndComment((math.random * 100).toInt, "new exam")) :: _.exams)
    serialize(elem, courseName, students)
  }

  def xmlLoadFile(): Elem = {
    println()
    val file: Elem = XML.loadFile("rsc/" + "grades.xml")
    print(file)
    file
  }

  def xmlElement() {
    val elem: Elem = <tag>this is an xml element</tag>
    println(elem)
  }
}
