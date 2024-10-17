package test02_etc

// object 키워드 사용 예시 3가지
// 1. class 대신 사용해서 해당 클래스가 싱글턴 상태가 되도록 만들기
// 2. 이름없는 클래스로 객체하나 즉석해서 만들 때
// 3. 클래스의 일부 멤버를 모든 객체가 공유하는 static으로 만들기

object MySingleton{
    var name="yangyu"
    fun f1(){
        println("f1 call")
    }
}

fun main() {
//    val obj = MySingleton()
    println("Singleton 이라 객체생성 못하고요. 그냥 클래스명으로 접근하면 됩니다. ${MySingleton.name}")
    MySingleton.f1()
}