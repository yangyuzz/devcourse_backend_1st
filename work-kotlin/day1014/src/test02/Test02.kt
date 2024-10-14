package test02

fun sum2(start:Int, end:Int):Int{
    var sum = 0;
    // sum 함수 안에 내부함수가 선언된다?! 그리고 자기를 감싼 바깥 함수의 변수에 접근할 수 있다?!
    fun innerSum(){
        for(i in start..end){
            sum += i
        }
    }
    innerSum() // 내부함수 호출
    innerSum() // 내부함수 호출
    return sum
}

fun sum2(end:Int):Int{
    var sum:Int=0;
    for(i in 1..end){
        sum += i
    }
    return sum
}

fun main() {
    println(sum2(1,3))
    println(sum2(10))
}