package test01

class Person(var name:String, var age:Int)
val person = Person("", 0)
val result = person.apply {
    this.name = "yangyu"
    this.age = 20
}
fun main() {
    println(person)
    println(result)
    println("${person.name}, ${person.age}")
}
