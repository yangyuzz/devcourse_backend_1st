package test01

fun main() {
    val a = 10
    val result = if (a>10) "hello" else "bye"

    println("result $result")

    val result2 = if(a>=10){
        println("true")
        10+20
    }else{
        println("else")
        //30+40
    }

    println("result2: $result2")
}