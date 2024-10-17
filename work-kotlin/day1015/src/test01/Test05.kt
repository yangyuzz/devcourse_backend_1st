package test01

fun main() {
    // 배열 <-> 리스트 왔다갔다 바꾸는 경우 생기는 상황들.
    val arr1 = arrayOf(10, 20, 30) // 얘는 배열 -> 리스트로 바꾸고 싶을때 선택지(불변리스트 or 가변리스트)
    val list1 = arr1.toList() // 불변리스트
    val list2 = arr1.toMutableList() // 가변리스트
    list2.add(500)
    list2.add(600)
    val arr2 = list2.toTypedArray() // 리스트 -> 배열로 만들기.
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    val list3 = listOf(1,2,arr1[0],arr1[1],arr1[2], 500, 600) // 배열에 있는 데이터 포함하면서 좀 더 추가해서 리스트 만들기.
    val list4 = listOf(1,2,*arr1,500,600) // 쨈 발라라!!! 라는 부분....^^^^^^^^^
    //////////////////////////////////////////////////////////////////////////////////////////
    val arr3 = arrayOf("abc","tomato","banana");
    myPrint(*arr3) // arr3[0], arr3[1], arr3[2] 이렇게 하나하나 펼쳐 넣는것과 동일 행동
    //myPrint(*list3) // 리스트에 전개연산자 안됨. 그래서 배열이랑 리스트 와리가리 알려준거...
}

fun myPrint(vararg params:Any){
    for(item in params){
        println(item)
    }
}