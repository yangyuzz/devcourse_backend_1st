package test02_etc

// object 키워드 사용 예시 3가지
// 1. class 대신 사용해서 해당 클래스가 싱글턴 상태가 되도록 만들기
// 2. 이름없는 클래스로 객체하나 즉석해서 만들 때
// 3. 클래스의 일부 멤버를 모든 객체가 공유하는 static으로 만들기
class Student(val name:String,var age:Int){
    companion object{
        var studentCnt=0
    }
    init{
        studentCnt++
    }
}

fun main() {
    val s1 = Student("yangyu", 20)
    val s2 = Student("minhyuk", 25)
    var s3 = Student("Kamila", 22)

//    println(s1.studentCnt) // companion object 멤버는 클래스 이름으로만 접근하래요
    println(Student.studentCnt)
}