package ver0_no_aop;

import java.util.Random;

public class Girl {
    public void makeSamgyepsal(){
        System.out.println("배가 고프다."); // before 핵심 관심사항 수행 전에 해야될 일
        try {
            ////////////////////////////////////////////////////////////////////////////////
            System.out.println("삼겹살을 굽거나 삶거나 육수를 내거나 암튼 다 만들자!"); // 핵심 관심사항
            if (new Random().nextBoolean()) { // 핵심 관심사항 수행 도중 만약 예외가 발생한다면?
                throw new Exception("불났다!!!!");
            }
            ////////////////////////////////////////////////////////////////////////////////
            System.out.println("맛있게 먹는다."); // 핵심 관심사항이 정상적으로 종료된게 확인 됐을 때!
        } catch (Exception e) {
            System.out.println("엄마를 부른다!!!!!"); // 예외 처리가 필요한 경우에 적고 아니면 안적고 중단시키겠죠.
        } finally {
            System.out.println("설거지를 한다... 등짝 맞는다..."); // 반드시 수행할 문장이 있는 경우에만 선택적으로 적으면 됨.
        }

    }
}
