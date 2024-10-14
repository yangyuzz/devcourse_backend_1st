package test01

fun main() {
    // 생성 후 불변
    var set = setOf("aaa","aaa","bbb")
    println("${set.size}, ${set.toString()}")
//    set.add("ddd") // error

    var mutableSet = mutableSetOf("aa","bb")
    mutableSet.add("ccc")
    mutableSet.add("aa")
    println("${mutableSet.size},${mutableSet.toString()}")

    var map = mutableMapOf<Int, String>(Pair(10, "Hi"), Pair(99, "Bye"))
    map.put(22, "Hello")
    map.put(99, "Yangyu")
    println(map.get(99))
}