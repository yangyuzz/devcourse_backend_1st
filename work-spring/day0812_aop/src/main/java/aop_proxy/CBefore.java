package aop_proxy;

public class CBefore implements IBefore{
    @Override
    public void doBefore() {
        System.out.println("배가 고파요..");
    }
}
