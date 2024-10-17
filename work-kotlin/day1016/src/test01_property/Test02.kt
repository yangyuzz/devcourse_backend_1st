package test01_property

class User2{
    val name:String = "yang"
//        set(value) = field = "Hello $value" // error!! val는 set 못만든다! 값 변경 못한다!
        get() = field.uppercase() // 맨 처음 값이 정해지고 나면 읽기만 하는 애가 val 인데 그 때 get 호출할게?? OK!!

    val age:Int // 코틀린은 변수가 비어있는 상황을 엄청 싫어하지만 get이 있으면? 응응 오키오키 초기값 생략 가능.
        get() = 10

    var phone:String="" // var는 값 변경이 가능한 애잖아?? 그럼 일단 초기 값은 무조건 있어야지!!!!!
        get() = "01012345678"
}