package aop_proxy;

public class SpringAction {
    public static void main(String[] args) throws Exception {
        Boy daewon = new Boy(); // 직접 객체 생성 안하고 스프링한테 달라고 했었죠.

//        daewon.makeFood(); // 이걸 실행하는줄 알았는데
        PersonProxy daewonProxy = new PersonProxy();
        daewonProxy.setTarget(daewon); // makeTaco
        daewonProxy.setBefore(new CBefore());
        daewonProxy.setAfterReturn(new CAfterReturning());
        daewonProxy.setAfterThrow(new CAfterThrowing());
        daewonProxy.setTarget(new Girl()); // makeSamgyeopsal

        daewonProxy.makeFood();
    }
}
