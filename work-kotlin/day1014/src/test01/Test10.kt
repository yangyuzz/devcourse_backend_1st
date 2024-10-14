package test01

fun main() {
    // 얘는 그래서 이름만 리스트지 ;;; 생성이후 변경 불가 부분에서 배열이랑 다를게 없어 보이는데....
    val list = listOf("apple", "banana")
    println("${list[0]}, ${list.get(1)}")
//    list.add("tomato"); // 이렇게 리스트에 뭐 새롭게 추가하는 형태 안된대;;
//    list[0] = "carrot" // 배열인게 아니니 사실 이런 문법도 시도할 수 ... 음 ...

    // 추후 데이터를 추가하거나 변경하거나 하는 작업이 필요한 경우 아래처럼 mutable이라고 붙은 애들 쓰거나 ArrayList 쓰거나 해야 된대요.
    val list2 = mutableListOf("aaa","bbb")
    list2.add("ccc")
    list2.set(0, "zzz") // 오히려 이게 구형이라고 ;;
    list2[0]="zzz" // 기존 리스트 항목의 값을 변경하는게 목적이면 그냥 이렇게 쓰는게 더 잘읽힌대요;;;

    val list3 = List(3){0}

    val arrayList = ArrayList<String>()
    arrayList.add("aaa")
    arrayList.add("bbb")
    arrayList.add("ccc")
    arrayList.removeFirst()
    arrayList.removeLast()
    println("${arrayList.size}//${arrayList[0]}")
}