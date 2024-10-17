package test01

fun main() {
    val list = listOf("aaa","bbb","tomato")

    for(str in list){ // list에 들어있는 데이터 자체를 str에 순차적으로 꺼내서 반복함.
        print(str)
    }
    println("\n-----------------------------")

    println(list.indices) // 이렇게 리스트의 인덱스만 똑 떼서 얻어올 수 있음.
    for(i in list.indices){
        println("$i -- ${list[i]}")
    }
    println("\n-----------------------------")

    for((idx, value) in list.withIndex()){
        println("$idx is $value")
    }
    println("\n-----------------------------")

    val f1 = {n1:Int-> println(n1) }
//    repeat(10, {i->println(i)})
    repeat(10, f1)
}