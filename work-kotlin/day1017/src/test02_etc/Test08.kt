package test02_etc

enum class Direction8(val no:Int, val msg:String){
    NORTH(10, "북쪽"), SOUTH(20, "남쪽"),
    EAST(30, "동쪽"), WEST(40,"서쪽"); // enum 인스턴스 나열 끝나고 추가 프로퍼티 필요하면 ; 필수
    val opposite: Direction8
        get() = when(this){
            NORTH -> SOUTH
            SOUTH -> NORTH
            WEST->EAST
            EAST->WEST
        }
}

fun main() {
    val dir = Direction8.WEST
    println(dir)
    println(dir.no)
    println(dir.msg)
    println(dir.opposite)
    println(dir.opposite.msg)
}