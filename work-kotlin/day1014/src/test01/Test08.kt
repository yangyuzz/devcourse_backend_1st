package test01

fun main() {
    // 그냥 arrayOf 하면 Any타입의 배열 생성
    val arr1 = arrayOf(1, "yang", true) // size 3
//    arr1 = arrayOf(10, 20); // 위에 arr1 변수가 val 이므로 arr1의 데이터를 새로 변경은 못함.
    arr1[0] = 111
    println("size:${arr1.size}, ${arr1[1]}, ${arr1.get(1)}")

    // arrayOf<타입> 으로 배열 데이터들의 타입 지정 가능.
    val arr2 = arrayOf<Int>(10, 20, 30)

    // 기초 타입 배열을 위한 함수 별도로 있긴 있음.
    val arr3 = intArrayOf(1,2,3)
    val arr4 = doubleArrayOf(0.1,0.2,0.3)

    // 크기만 지정하고 null 채워둔 배열 생성 가능.
    val arr5 = arrayOfNulls<Any>(5)
    arr5[0] = 100
    arr5[1] = "hello"
    arr5[2] = true
}