package test02_class

class MyClass3{
    // 주 생성자는 하나밖에 못만드는데 보조생성자는 여러 개 오버로딩 가능함.
    constructor(){
        println("보조생성자 no parameter")
    }
    constructor(name:String){
        println("보조생성자 호출됨 ${name}")
    }
    init{
        println("주생성자 호출됨")
    }
}

fun main() {
    val obj1 = MyClass3() // error 현재 작성된 생성자가(주생성자 안보이는데?) String 보조생성자 하나니까!
    val obj2 = MyClass3("yangyu")
//    println("my name ${obj2.name}") // 보조생성자에 들어간 값은 멤버 프로퍼티 아니고 걍 지역변수!
}