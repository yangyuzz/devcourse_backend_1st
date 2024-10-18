package test01

fun funname(){}
// 람다는 기본적으로 아래처럼 {  } 로 묶여있는 덩어리임. {매개변수 -> 실행문}
//{input -> expression 실행문 중 마지막 문장이 리턴값}

val lambda1 = { -> 100} // 무조건 100만 리턴하는 함수
val lambda2 = { 100} // 무조건 100만 리턴하는 함수(-> 생략)
val lambda3 = { ->
    println("람다3 호출됨! 실행문 여러줄!")
    100
} // 무조건 100만 리턴하는 함수(실행문이 여러줄에 걸쳐있으면 마지막 값이 리턴)
val lambda4 = {n:Int -> n*n} // 매개변수 있으면 타입을 알려줘야 되는게 정석
val lambda5:    (Int)->Int  = { x -> x*x} // 대입연산 왼쪽에 뭐하는 함수인지 적혀있으니까 람다는 굳이 자료형 안적어도 됨.
val num:        Int         = 100
val lambda6:    (Int)->Int  = {it*it} // 매개변수가 달랑 하나 들어오면 x-> 부분 생략 가능. 대신 들어온게 it이다 라고 함수 작성 가능.