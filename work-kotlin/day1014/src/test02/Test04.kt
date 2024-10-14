package test02

fun sayHello(name:String, phone:String="1234"){
    println("hello $name")
    println("phone : $phone")
}

fun main() {
//    sayHello(); // error! phone은 기본값이 있지만 name은 없으니 일단 String 하나는 최소한 들어가줘야 함.
    sayHello("yangyu")
    println("----------------------------")
    sayHello("grepp", "010-7564-0626")
    println("----------------------------")
    sayHello(phone = "9999", name="programmers") // 함수 정의할 때의 순서 상관없이 이 값이 어떤 변수에 들어가야 하는지 이름지정 가능!
}