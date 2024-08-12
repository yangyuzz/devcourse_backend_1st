package ver2_aop_xml_around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

public class CommonAspect {
//    public void bbbefore(){
//        System.out.println("배가 고프다."); // before 핵심 관심사항 수행 전에 해야될 일
//    }
//
//    public void aaafterReturning(){
//        System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 때!
//    }
//
//    public void aaafterThrowing(){
//        System.out.println("엄마를 부른다!!!!!"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠죠.
//    }
//
//    public void aaafter(){
//        System.out.println("설거지를 한다... 등짝 맞는다..."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
//    }
    // 위에처럼 전후 다 적용하고자 하는 경우에는 굳이 하나하나 떼서 만들지 않고 아래처럼 around 하면 편해염.
    public void aaaround(ProceedingJoinPoint target){
        System.out.println("배가 고프다."); // before 핵심 관심사항 수행 전에 해야될 일
        try {
            target.proceed(); // 이 시점에 타코 만들거나 삼겹살굽거나 그런 일들이 일어날꺼임.
            System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 때!
        } catch (Throwable e) {
            System.out.println("엄마를 부른다!!!!!"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠죠.
            throw new RuntimeException(e);
        } finally{
            System.out.println("설거지를 한다... 등짝 맞는다..."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
        }
    }
}
