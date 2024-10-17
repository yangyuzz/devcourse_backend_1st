package test02_etc

class Outer9{
    var outerName:String="yang"
    fun outerFun(){
        println("중첩 클래스의 외부 함수 호출 : ${outerName}")
    }
    class Inner9{ // 바깥놈과 나는 전혀 상관없다. 인생 혼자 산다.
        var innerName="hi"
        fun innerFun(){
//            println("$outerName") // 바깥 클래스 멤버 접근 못함.
//            outerFun(); // 바깥 클래스 멤버 접근 못함.
            println("중첩 클래스의 함수 호출 : $innerName")
        }
    }
}

fun main() {
    //var obj = Outer9()
    var obj2 = Outer9.Inner9() // 바깥 클래스 인스턴스 생성 여부랑 상관없이 내부 클래스 객체 생성됨. 걍 클래스 이름만 좀 길어짐;;

    obj2.innerFun()
}