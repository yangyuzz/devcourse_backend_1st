package test02_inheritance

fun pow(num:Any) : Int{
    if(num is Int){ // true인 경우
        return num*num // Any타입이었던 num이 알아서 Int타입으로 바뀌어있음.
    }
    return 0
}

open class Parent{
}

class Child1: Parent(){
    fun fun1(){
        println("fun1 call!!")
    }
}

class Child2: Parent(){
}

fun main() {
    println(pow("Hello"))
    println(pow(5))

    var obj1:Child1 = Child1()
    var obj2:Parent = obj1 // obj2부모 = obj1자식1
//    var obj3:Child1 = obj2 // obj3자식1 = obj2부모 후레자식!!!! 에러 !!!!
    var obj3:Child1 = obj2 as Child1

    var obj4:Child1? = null
    var obj5:Parent? = obj4 // obj2부모 = obj1자식1
//    var obj3:Child1 = obj4 // obj3자식1 = obj2부모 후레자식!!!! 에러 !!!!
    var obj6:Child1? = obj5 as? Child1
    println(obj6?.fun1())
}