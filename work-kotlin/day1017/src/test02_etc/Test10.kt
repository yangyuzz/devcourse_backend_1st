package test02_etc

class Outer10{
    var outerName:String="yang"
    fun outerFun(){
        println("중첩 클래스의 외부 함수 호출 : ${outerName}")
    }
    inner class Inner10{ // inner 키워드를 붙이면 outer클래스의 멤버로 인식됨.
        var innerName="hi"
        fun innerFun(){
            println("내부에서 바깥 클래스 멤버 접근함 : $outerName") // 바깥 클래스 멤버 접근 못함.
            outerFun(); // 바깥 클래스 멤버 접근 못함.
            println("중첩 클래스의 함수 호출 : $innerName")
        }
    }
    val innerObj = Inner10()
}

fun main() {
    var obj = Outer10()
    // 아래처럼 구우우우우지 내부 클래스로 객체를 생성을 outer가 아닌 곳에서 하는 경우가... 없죠.....^^^^^^^^^
    // 위에 innerObj처럼 outer가 내부클래스 객체 생성해서 들고 있겠지....ㅋ
    var obj2 = Outer10().Inner10() // 내부 객체 생성하고 싶어? 그럼 바깥 클래스 객체부터 먼저 생성을 해야 해.

    obj.outerName = "바깥이름변경"
    obj.outerFun() // 바깥 함수 호출
    obj.Inner10() // 멤버클래스(inner class)의 객체생성
//    obj.innerName="안쪽변수 이름 변경"// error!! um....? outer 입장에서는 이런 멤버는 없는데?
//    obj.innerFun() // error!! um....? outer 입장에서는 이런 멤버는 없는데?

//    obj2.outerName = "바깥이름변경"
//    obj2.outerFun() // 바깥 함수 호출
//    obj2.Inner10() // 멤버클래스(inner class)의 객체생성
    obj2.innerName="안쪽변수 이름 변경"
    obj2.innerFun() //
}