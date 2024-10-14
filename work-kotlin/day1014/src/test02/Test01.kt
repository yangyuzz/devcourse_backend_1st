package test02

import test01.MyJava

// 매개변수는 무조건 val 이라서 함수 실행하면서 값 변경 안됨
fun hello(param1:Int, param2:String):String {
//    param1 = 99 // error! 함수 매개변수는 val 라서 내부에서 변경 불가
    var param1_ = param1
    param1_ = 99
    return "hello"
}

// 리턴타입 생략->함수내용으로 추론함. 만약 함수 내부에서 리턴이 없었으면? 자동으로 Unit(void)임.
// {} 중괄호 대신 =가 쓰였음. -> 한줄짜리 함수이고 그 한줄의 실행 결과가 곧 함수의 리턴값이 됨.
fun sum(n1:Int, n2:Int) = n1+n2

fun main() {
    println("result = ${sum(10,20)}")

    val myjava = MyJava("yangyu")
}