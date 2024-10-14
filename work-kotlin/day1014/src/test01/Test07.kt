package test01


fun main() {
    var a1 = 10
    var a2 = a1 // 타입 추론은 지가 알아서 대입되는 값 보고 할 수 있긴 한데
    var a3:Int = 10 // 명시적으로 정의한 기초 타입은
//    var a4:Double = a3 // error! 자동 형변환 해주지 않음.
    var a4:Double = a3.toDouble() // 형변환 함수 호출해야 됨.

    getUpper(10) // Any 타입이라 아무거나 넣을 수 있음.
    getUpper("Hello")

    println(getUpper(10))
    println(getUpper("Programmers"))
}

fun getUpper(obj: Any):String{ // Object 처럼 아무거나 넣을 수 있는 부모타입 설정 가능.
    if(obj is String){ // 자바에서 instanceof 처럼 타입 체크 기능이 있는데 true 결과 나오면 obj 변수에 String으로 형변환까지 자동으로 진행해줌.
        return obj.uppercase()
    }
    return "no string"
}