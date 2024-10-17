package test02_etc

data class User6(val name:String, val age:Int,)

fun main() {
    val user = User6("yangyu", 30)
    val (name) = user
    val (_, age) = user

    println("$name, $age")
    
//    val map = mapOf(Pair(1,"하나"), Pair(2,"둘"))
    val map = mapOf( 1 to "하나", 3 to "셋")
    for(item in map){
        println(item)
    }

    for((_, value) in map){
        println(value)
    }
}