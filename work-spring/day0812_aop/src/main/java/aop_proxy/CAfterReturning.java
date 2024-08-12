package aop_proxy;

public class CAfterReturning implements IAfterReturning{
    @Override
    public void doAfterReturn() {
        System.out.println("냠냠 맛있게 먹어요");
    }
}
