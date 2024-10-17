package test01_property

// 최상위 변수(이 파일이 클래스가 되니까 클래스 멤버 프로퍼티? OK!)
var myName:String = "Yang"
    get() = field
    set(value) {field = value}

fun myFun(){
    // 함수 내에 선언된.. 지역변수.... ? 프로퍼티 아님!! get/set이 뭔말????? 지역변수는 함수 실행할 때 잠깐 저장시키고 버리는 용도!
    var funName:String = "hello"
//        get() = field
//        set(value) {field = value}
}

class User3{
    // 클래스 멤버변수? 프로퍼티 ! OK
    var userName:String = "programmers"
        get() = field
        set(value) {field = value}
}