package test01_abstract

// 최상위 abstract 함수 안됨
//abstract fun func1(){
//
//}

abstract class Super1{
    abstract var name:String // 초기화 원래 필수이지만 얘는 추상이라 안해도 됨.
    fun generalFun(){}
    abstract fun func1(): Unit
}

class Sub() : Super1(), MyInterface{
    override var name: String = "yangyu" // 부모의 추상이었던 변수
    override fun func1() { // 부모의 추상이었던 함수
        println("구현 안하면 나도 추상클래스 됩니다요.")
    }

    override fun myFun() {
    }

}

interface MyInterface{
    fun myFun()
}

fun main() {
//    val obj = Super() // 추상클래스 객체생성 못한다이
    val obj = Sub()
    val obj2:MyInterface = Sub()
//    println(obj2.name) // 변수가 인터페이스 타입이면 인터페이스에 있던 함수 말고는 접근못함.
    val obj3:Sub = obj2 as Sub
    println(obj3.name)
}