package ver3_aop_annotation;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect // 다른 핵심관심사항 들에게 공통적으로 적용할 공통관심사항
public class CommonAspect {
    @Pointcut("execution(* make*())")
    public void ppp(){}

    @Before("ppp()")
    public void bbbefore(){
        System.out.println("배가 고프다."); // before 핵심 관심사항 수행 전에 해야될 일
    }

    @AfterReturning("ppp()")
    public void aaafterReturning(){
        System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 때!
    }

    @AfterThrowing("ppp()")
    public void aaafterThrowing(){
        System.out.println("엄마를 부른다!!!!!"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠죠.
    }

    @After("ppp()")
    public void aaafter(){
        System.out.println("설거지를 한다... 등짝 맞는다..."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
    }
}
