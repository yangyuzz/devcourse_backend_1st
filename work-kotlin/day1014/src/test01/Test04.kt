package test01

val fullname:String = "yangyujin"
//    set(value) { // error!! val 는 나중에 값 변경 안되는 애인데 setter가 왜있음??
//        print("이름이 설정되고 있습니다.")
//        field = value
//    }
    get() {
        println("풀네임이 읽어지고(사용되고) 있습니다.")
        return field.uppercase() // 저장된 값은 이게 아니었는...? 암튼 가공해서 읽어지게 조작가능.
    }
var name = "yujin"
    set(value) {
        println("이름이 설정되고 있습니다.")
        field = value
    }
    get() {
        println("이름이 읽어지고(사용되고) 있습니다.")
        return field
    }

fun main() {
    name = "양유" // 변수에 직접 내가 값을 넣는게 아니라 사실 setter가 호출되는 거임.
    println(name) // getter가 자동으로 호출됨.
    println(fullname) // getter가 자동으로 호출되는데 조작함.
}