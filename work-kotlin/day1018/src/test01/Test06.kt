package test01

fun main() {
    val result1 = run{
        println("call lambda by run")
        100
    }
    println("result = ${result1}")

    val person = Person("yangyu", 20)
    val result2 = person.run {
        println("person run 실행됨")
        100 // run은 마지막 문장이 람다의 리턴 데이터
    }
    println("$person, result = ${result2}")
}