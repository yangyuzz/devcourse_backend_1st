package aop_proxy;

// 실제 Person은 Boy 또는 Girl 이지만 Proxy가 Person인척 대리인 역할을 수행함.
public class PersonProxy implements Person{
    private IBefore before;
    private IAfterReturning afterReturn;
    private IAfterThrowing afterThrow;
    private IAfter after;
    private Person target; // 힉심 관심사항 구현체. Boy 또는 Girl과 같은.

    public void setTarget(Person target) {
        this.target = target;
    }

    public void setBefore(IBefore before) {
        this.before = before;
    }

    public void setAfterReturn(IAfterReturning afterReturn) {
        this.afterReturn = afterReturn;
    }

    public void setAfterThrow(IAfterThrowing afterThrow) {
        this.afterThrow = afterThrow;
    }

    public void setAfter(IAfter after) {
        this.after = after;
    }

    @Override
    public void makeFood() throws Exception { // 대행 메소드.
        if(before != null) before.doBefore(); // 배고파요.

        try{
            target.makeFood(); // 타코 만들기 or 삼겹살 굽기와 같은 핵심 관심사항 실행
            if(afterReturn != null)
                afterReturn.doAfterReturn(); // 냠냠 먹어요
        } catch (Exception e) {
            if(afterThrow!=null) afterThrow.doAfterThrow(); // 엄마!!!!!
        } finally {
            if(after!=null) after.doAfter(); // 설거지는 해야해요..
        }

    }
}
