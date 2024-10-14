package test01

// 모든 변수는 자동 초기값 없음. 값 대입 해야 변수 사용 가능.

//var global:String // error - 초기화 필수. 전역변수

class User3{
//    var member:String // error - 초기화 필수. 멤버변수
    
    fun hello(){
        var local:String // 지역변수 - 초기화 필수 아님. 다만

//        println(local) // error - 초기화 안한 지역변수 읽기.
        local = "지역변수 값 넣으면 읽기 가능"
        println(local)

//        local = null // 모든 변수는 기본적으로 null 안됨. 자바에서는 자동으로 null 넣었었는데 너무 싫어!!!!!
        var local2:String? = null // ? 붙여서 null 허용변수로 만들어야 사용가능. 즉, null을 쓰는 상황을 최대한 안만들면서 코딩하자 라는 의도로 해석됨.
    }

}
