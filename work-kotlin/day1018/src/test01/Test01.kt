package test01

fun f1(){
    println("매개변수 인자값도, 리턴 결과값도 없는 함수")
}

fun f2(a:Int, b:Int) : Int{
    println("2개의 인자값을 받아서 1개의 결과를 리턴하는 함수")
    return a+b
}

fun f3(name:String) {
    println("인자는 있고 반환값은 없는 함수")
}

fun f4(obj:Any){
    println("$obj 인자가 들어왔네요. 이건 숫자일지 문자일지 객체일지 저야 모르죠")
}

fun f5(fffffff: (Int, Int)->Int){ // 함수를 (매개변수) 로 받는
    println("연산을 수행했습니다. ${fffffff(10,20)}")
}

fun f6() : ()->Int{ // 함수를 리턴하는
    return fun():Int{return 100}
}
val sum = (fun (a:Int, b:Int) = a+b) // 변수에 어떤 함수를 담아서 들고다님..;;;;
val minus = (fun (a:Int, b:Int) = a-b)
val mul = (fun (a:Int, b:Int) = a*b)
val divide = (fun (a:Int, b:Int) = a/b)

fun main() {
    f5(sum) // sum이라는 함수를 집어넣음
    f5(minus) // minus라는 함수를 집어넣음.
    val result = f6() // f6의 호출 리턴값은 함수가 나옴
    println("f6() 결과로 나온 함수 result를 호출합니다. ${result()}")
}