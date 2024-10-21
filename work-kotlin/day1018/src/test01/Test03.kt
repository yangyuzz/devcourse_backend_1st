package test01

class User(val name:String, var age:Int)

fun f(user: User):Int{
    println("내가 실행됨!")
    return user.age
}
val getAge : (User)->Int = ::f
val getAge2 : (User)->Int = {it.age}
val getAge3 = {user:User -> user.age}

fun main() {
    println("유저의 나이 : ${getAge(User("yangyu", 30))}")
}
