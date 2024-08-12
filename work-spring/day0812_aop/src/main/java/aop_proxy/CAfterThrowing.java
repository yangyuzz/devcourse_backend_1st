package aop_proxy;

public class CAfterThrowing implements IAfterThrowing{
    @Override
    public void doAfterThrow() {
        System.out.println("엄마!!!!!!!!!!");
    }
}
