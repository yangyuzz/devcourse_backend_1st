package test02_class

// 보통 함수 매개변수는 지역변수라 호출 완료되면 없어지는건데
// 주 생성자 매개변수는 이 클래스의 멤버변수가 될 수 있음.
// 이렇게 클래스 몸통 { }가 생략되는 경우도 볼 수 있음.
//class MyClass2(val name:String, var age:Int)
///////////////////////////////////////////////////////////////////////
class MyClass2(val name:String, var age:Int){
    // 이렇게 프로퍼티 생성과 동시에 초기화 가능하지만 뭔가 메소드 문장 실행 느낌이라 비추
//    var nickname:String = name+"ㅋㅋㅋㅋㅋ"
    var nickname:String

    init{ // 주생성자 몸통이 여깄는거라고 적어줍시다.
        nickname = name+"ㅋㅋㅋㅋㅋㅋㅋ"
    }
}


fun main() {
    val obj = MyClass2("yangyu", 30)
    println("이름은 ${obj.name}이고, 나이는 ${obj.age}")
//    obj.name = "양유리"
    obj.age = 31
    println("이름은 ${obj.name}이고, 나이는 ${obj.age}, 별명은 ${obj.nickname}")
}