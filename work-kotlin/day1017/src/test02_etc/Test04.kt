package test02_etc

data class User4(val name:String, val age:Int,)

fun main() {
    val set = HashSet<User4>()
    set.add(User4("yang", 20))
    set.add(User4("yang", 20))
    set.add(User4("yang", 25))
    set.add(User4("yang2", 20))
    println(set)
}