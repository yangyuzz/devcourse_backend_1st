package test02_etc

enum class Direction{
    NORTH, SOUTH, WEST, EAST
}

fun main() {
    val dir = Direction.SOUTH
    println("${dir.name} // ${dir.ordinal}")

    val directions = Direction.entries // 굳이 열거형에 담긴 모든 애들 싹 보고싶은 경우...?
    directions.forEach{
        t-> println("${t.name}, ${t.ordinal}")
    }
}