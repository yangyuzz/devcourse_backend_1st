package test02_inheritance

public val obj1=10 // default
private val obj2=10 // 이 파일 안에서만.... 사실 이 파일 자체가 하나의 클래스인 거라 넘나 당연...;;;
internal val obj3=10 // 현재 모듈 안에서 public
//protected val obj4=10 // 현재 파일도 하나의 클래스이기는 한데... 이 파일 자체를 상속받는 애가 어딨겠어 ;;;;

open class MyClass{
    val obj1=10 // public이 기본
    private val obj2=10
    internal val obj4=10 // 같은 모듈안에서
    protected val obj3=10 // 나를 상속받은 자식은 건드릴 수 있음.
}

fun main() {
    val obj = MyClass()
    //println(obj.obj2) // private이라 접근 불가.
}