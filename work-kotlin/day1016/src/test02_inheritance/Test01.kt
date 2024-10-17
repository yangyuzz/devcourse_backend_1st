package test02_inheritance

import java.util.*

// 코틀린은 모든 클래스가 디폴트로 final(상속불가)라서 open 적힌 애들만 상속가능.
open class User1{
    lateinit var name:String
}
// 자식 클래스 생성자는 반드시 부모 생성자를 먼저 호출해야 한다.
class AdminUser:User1(){

}
fun main() {
    val user1:Any = User1()
    val obj2:Any = Scanner(System.`in`)
}