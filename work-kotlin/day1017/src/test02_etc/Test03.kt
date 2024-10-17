package test02_etc

data class User3(val username:String,val password:String,){
    lateinit var accessToken:String
}

fun main() {
    val user1 = User3("yangyu", "1234")
    user1.accessToken = "abc"

    val user2 = User3("yangyu","1234")
    user2.accessToken = "def"

    val user3 = user1.copy(password = "9999")
    user3.accessToken = user1.accessToken

    println(user1 == user2) // data 클래스 주생성자 프로퍼티 기준으로 equals 만들어줌
    println(user1.toString()) // data 클래스 주생성자 프로퍼티 기준으로 toString 만들어줌
    println(user3.toString()) // data 클래스 주생성자 프로퍼티 기준으로 copy기능도 만들어줌.
    println(user3.accessToken) // 주생성자 프로퍼티 아닌 변수는 수작업으로 복사해야 됨.
}