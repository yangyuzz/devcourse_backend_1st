package test02_etc

// object 키워드 사용 예시 3가지
// 1. class 대신 사용해서 해당 클래스가 싱글턴 상태가 되도록 만들기
// 2. 이름없는 클래스로 객체하나 즉석해서 만들 때
// 3. 클래스의 일부 멤버를 모든 객체가 공유하는 static으로 만들기
// 클래스가 없으니까 obj 변수의 타입을 뭐로해야 하나... 몰라 Object obj
val obj = object{
    val what=300
    override fun toString(): String {
        return "아오!!!!!!!!!! 열받아!!!!!!!!!! ${what}"
    }
}
////////////////////////////////////////////////////////////////////////
open class Super12{
    var x=10
}
val obj1 = object: Super12(){
    var y=20
}
////////////////////////////////////////////////////////////////////////
interface MyInterface{ // 라이브러리에 있는 인터페이스라고 상상하자.
    fun f()
}
val obj2 = object: MyInterface{
    // 여기서 무명 클래스 자식이 뭘 추가해본들 부모 타입으로 접근도 못할테니 그냥 오버라이딩만 수두룩 빽뺵!!
    override fun f() {
        println("인터페이스 구현체 하나!")
    }
}
var obj3 =  object: MyInterface{
    override fun f() {
        println("인터페이스 구현체 둘!")
    }
}
////////////////////////////////////////////////////////////////////////
fun main() {
//    println(obj.what)
    println(obj.toString()) // obj 변수는 자료형이 Object 상태임
    println(obj1.x) // obj1 변수는 자료형이 Super12 상태임.
//    println(obj1.y) // obj1 변수는 자료형이 Super12 상태임. 즉 Super12 상속받은 자식이 추가한 y 내용은 못봐.. 부모라 고지식...
}


