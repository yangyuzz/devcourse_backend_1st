package test01

fun main() {
    // Array(행 수, {IntArray(4칸, {초기에 채워두는 값})}
    val arr = Array(3, {IntArray(4,{2})}) // 3행 4열 배열에 숫자 2가 채워진 상태

    for(i in arr.indices){
        for(j in arr[i].indices){
            print("$i,$j=${arr[i][j]}//")
        }
        println()
    }
}