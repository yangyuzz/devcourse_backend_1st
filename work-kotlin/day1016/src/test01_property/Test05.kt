package test01_property

// 객체 생성시 초기값 넣을건데요! 그 프로퍼티도 커스텀 get/set 하고싶어요!!
// solution : 주생성자 파라미터를 프로퍼티로 안쓰면 되지 ;;;;;
class User5(name:String){
    var name:String = name
        set(value) {field=name.uppercase()}
}

fun main() {
    val user = User5("yang")
}