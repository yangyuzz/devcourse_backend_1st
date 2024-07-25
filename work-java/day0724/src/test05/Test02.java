package test05;

import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        BoxGeneric<Integer> box = new BoxGeneric<>();

//        box.setData("hello"); // 이제 컴파일러가 체크할 수 있어짐!
        box.setData(100);
        System.out.println(box.getData()/5);
    }
}

class BoxGeneric<T>{
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
