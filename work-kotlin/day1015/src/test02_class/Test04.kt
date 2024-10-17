package test02_class

class MyClass4(val name:String){
    var age:Int
    init {
        println("코틀린은 멤버변수에 null 들어가는거 못참아!! 변수는 무조건 명시적으로 초기화 해!!!! 그 역할을 주생성자가 가져가!!!!")
        age = 0
    }
    constructor(name:String, age:Int) : this(name) {
        println("보조 생성자는 말그대로 보조라서.. 멤버 변수 값의 초기화는 주생성자에게 맡기고 그 밖의 초기화 작업을 처리하자.")
    }
}

fun main() {
    val obj = MyClass4("yangyu", 20)
}