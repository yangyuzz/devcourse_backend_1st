package test04;

public class Test {
}

class Parent{
    protected void a() throws RuntimeException {

    }
}

class Child extends Parent{
    // 부모 클래스에서 대비하지 않은 다채로운 예외를 자식이 구우우우우우지 오버라이딩 하면서 발생시키지 않게 하자
//    @Override
//    protected void a() throws Exception{
//
//    }
}
