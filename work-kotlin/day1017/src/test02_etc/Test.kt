package test02_etc

fun main() {
    val intValue_1 = 128
    val boxed_1 : Int? = intValue_1
    val boxed_2 : Int? = intValue_1

    val intValue_2 = 200
    val boxed_3 : Int? = intValue_2
    val boxed_4 : Int? = intValue_2

// Question : 뭐가 출력될까요?
    println(boxed_1 === boxed_2)
    println(boxed_3 === boxed_4)
}