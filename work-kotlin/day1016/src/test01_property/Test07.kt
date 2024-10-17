package test01_property

class Board{
    // int no
    // int readCount
    // ~~~~
    // Comment
    // Follower
}

class User7(val name:String){
    // 아오 코틀린 초기값 설정하라고 진짜 징글징글 하네;;;;;; 쫌 늦게 넣겠다고요 ...!!!!!
    // val은 추후 값 변경 불가한 애니까 lateinit은 허용되지 않고요!
    // 기초자료형 한테는 lateinit 안됨!
    lateinit var major:String// 이름은 처음부터 정해져 있지만 전공은... 아직... 모름...?
    val length:Int by lazy {
        println("val 라서 나중에 값 변경 안되는 length 값이 지금 결정되었어요!!!")
        major.length // 코틀린의 람다는 return 키워드 안씀. 마지막 표현식이 그냥 리턴되는 값임.
    }
}

fun main() {
    val user = User7("양유")
    user.major = "computer programming" // lateinit 으로 이 프로퍼티는 늦은 초기화 진행함.
    println("전공 : ${user.major}, 길이:${user.length}") // val 값을 처음으로 읽어??? by lazy 부랴부랴부랴 실행해!! 안읽었으면 안실행하지 ㅋㅋㅋ

}