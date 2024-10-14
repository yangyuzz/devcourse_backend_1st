package test02

fun func(vararg params:Any){
    for(item in params){
        println("func receive : $item")
    }
}

fun main() {
    func(10,20,30,"hello");
    func(1,2,3,4,5,6,7,8,9)
}