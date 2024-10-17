package test02_etc

fun main() {
    val obj1 = Pair<Int, String>(123, "yangyu")
    val obj2 = Pair<Int, String>(1234, "yangyu")
    println("$obj1, $obj2")
    println(obj1 == obj2)

    val obj3 = Triple<Int, Int, String>(10, 20, "programmers")
    val obj4 = Triple<Int, Int, String>(10, 20, "programmers")
    println(obj3)
    println(obj3==obj4)

    val(_, num2, name)=obj3 // 대입연산자 오른쪽에 덩어리가 오는데 거기서 원하는 것만 뽑아서 대입연산 왼쪽에 변수들에 각각 담아놓고 쓸 수 있음.
    println("$num2, $name")
}