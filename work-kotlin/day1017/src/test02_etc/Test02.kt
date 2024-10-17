package test02_etc

data class UserInfo(
    val username:String,
    val password:String,
    val email:String,
)

fun main() {
    val obj1 = UserInfo("yangyu","1234","a@a.com")
    val obj2 = UserInfo("yangyu2","1234","a@a.com")

    println(obj1.toString())
    println(obj2.toString())
    println(obj1 === obj2) // 주소가 같은지 즉 객체가 하나인지 체크
    println(obj1.equals(obj2)) // 데이터 객체 두개의 모든 프로퍼티 값 비교
    println(obj1 == obj2) // 기존의 값 비교는 항상 equals 쓰라 했는데 == 으로 편하게 값 비교가능
}