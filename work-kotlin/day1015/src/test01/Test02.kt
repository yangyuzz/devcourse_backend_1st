package test01

fun main() {
    val num = 100
    when(num){
        100 -> println("hi 100 !!")
        200 -> println("bye 200!!")
        else -> println("what the..?")
    }

    val score = readln().toInt()
    println("input score : ${score/10}") // 90~100 : grade A, 80~90 : grade B

//    val grade = when(score){
//        in 90..100 -> 'A'
//        in 80 .. 89 -> 'B'
//        in 70 .. 79 -> 'C'
//        in 60 .. 69 -> 'D'
//        else ->'F'
//    }
    val grade = when(score/10){
        9, 10 -> 'A'
        8 -> 'B'
        7 -> 'C'
        6 -> 'D'
        else ->'F'
    }
    println("your grade : $grade")
}