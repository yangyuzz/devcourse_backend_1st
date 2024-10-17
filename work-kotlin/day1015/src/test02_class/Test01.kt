package test02_class

// 보통 클래스 개발할 때 생성자는
// 1. 안만들거나
// 가장 간단한 형태의 클래스 이자 생성자
//class MyClass

// 2. 하나만 만들어서 기본값 싹 셋팅하거나
class MyClass(name:String, age:Int=0){ 
    init{
        // 여기가 주 생성자의 초기화블럭 부분입니다. 사실상 주생성자 몸통이 이렇게 떨어져 나온...
        println("주생성자 호출됨!")
    }
    var phone:String = "01012345678"
    fun myFunc(){
//        println("class 멤버 함수 ${name}") // 주 생성자 매개변수에 var, val 안붙은 애들은 멤버 프로퍼티 아니고 그냥 매개변수(지역변수)
        println("class 멤버 함수 ${phone}") // phone은 멤버변수임. name이랑 age는 지역변수라 없어짐.
    }
}
// 3. 되게 여러 개 만들어서 여러 종류로 초기 셋팅되게 하더라...

fun main() {
//    val myObj = MyClass() // 주생성자 아예 안만들면 기본 생성자로 있었을건데, 주생성자를 만드네? 그럼 기본생성자 자동제공 안되지!
    val myObj = MyClass("양유", 20)
    val myObj2 = MyClass("그렙") // age에 디폴트 값 0 있으니까 생략하면 그걸로 셋팅되겠지.
//    println(myObj.name)
}