package test01

// 어떤 함수한테 람다 집어넣으면서 실행하는데
// 람다는 원래 return 안씀. 그냥 마지막 문장으로 리턴되는 건데
// 특정 경우에 중간 종료를 위한 return이 필요하다면? 람다 바깥 누구가 종료되어야 하는지 @aaa 명시해줘야 함.
fun main() {
    val arr = arrayOf(10,20,90)

    arr.forEach({
        if(it>50) return@forEach
        println("람다 실행중 : ${it}")
    })

//    if(10>50) return
//    println("람다 실행중 : ${it}")
//    if(20>50) return
//    println("람다 실행중 : ${it}")
//    if(90>50) return
//    println("람다 실행중 : ${it}")

    println("프로그램이 종료됩니다.")
}