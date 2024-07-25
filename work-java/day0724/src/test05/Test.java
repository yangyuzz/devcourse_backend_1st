package test05;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        BoxObject box = new BoxObject();
        box.setData(100);

        box.setData("hello"); // 데이터 저장
//        System.out.println(box.getData());
//
        System.out.println((Integer) box.getData()/10); // 몇천줄 아래에서 연산을 했는데.....
    }
}

class BoxInt{
    private int data;

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

class BoxObject{
    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}