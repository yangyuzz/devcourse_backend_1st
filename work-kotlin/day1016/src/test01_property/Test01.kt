package test01_property

class User1{
    var msg:String = "Hello"
        set(value) {
            println("called setter")
            field = "Hello ${value}" // 내가 쳐다보고 있는 대상을 field 라고 부름.
        }
        get() {
            return field.uppercase()
        }
    var age:Int = 0
        set(value) = if (value>0) field = value else field =0
}

fun main() {
    val user = User1()
    user.msg = "안녕하세요." // setter 호출됨
    println(user.msg) // getter 호출됨

    user.age = -150
    println(user.age)
}
