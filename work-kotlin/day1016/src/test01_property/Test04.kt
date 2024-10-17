package test01_property

// 주 생성자 파라미터로 설정된 프로퍼티는 커스텀 get/set 불가능!
class User4(var name:String){
    var nickname:String = name
        get() = field.uppercase()
}

fun main() {
    val user = User4("yang")
    println(user.name)
    println(user.nickname)
}