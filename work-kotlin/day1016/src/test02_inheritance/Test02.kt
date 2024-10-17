package test02_inheritance


open class Shape2{
    var x=0
        set(value) {
            if(value<0) field=0
            else field=value
        }
    var y=0
        set(value) {
            if(value<0) field=0
            else field=value
        }

    open var name:String="no name"
    open fun print(){
        println("$name : location $x, $y")
    }
}

class Rect2(): Shape2(){
    override var name:String="child name"
    var width:Int=0
        set(value) {
            if(value<0) field=0
            else field=value
        }
    var height:Int=0
        set(value) {
            if(value<0) field=0
            else field=value
        }

    override fun print() {
        super.print()
        println("부모 이름 : ${super.name}, 내 이름: ${this.name}")
        println("width: $width, height:$height")
    }
}

class Circle2:Shape2(){
    var r:Int=0
        set(value) {
            if(value<0) field=0
            else field=value
        }

    override fun print() {
        super.print()
        println("radius: $r")
    }
}

fun main() {
    val obj = Rect2()
    obj.print()
}