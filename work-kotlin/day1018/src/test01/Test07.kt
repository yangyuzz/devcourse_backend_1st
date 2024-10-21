package test01

class Parent(var name:String, var age:Int){

}

// 클래스 프로퍼티
val Parent.phone:String
    get() =  "010-7564-0626"
// 클래스 함수
fun Parent.printInfo(){
    println("$name, $age, $phone")
}
// 클래스 함수2
val Parent.printInfo2:()->Unit
    get()={ println("확장된 람다 함수.") }

fun main() {
    val obj = Parent("yangyu", 40)
    obj.printInfo()
}
