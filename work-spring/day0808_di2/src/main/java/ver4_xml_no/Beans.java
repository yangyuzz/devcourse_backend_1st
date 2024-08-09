package ver4_xml_no;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // 기존에 객체관리 창고 파일이 xml이었는데 그걸 대체하는 자바다(즉, 일반적인 객체생성을 위한 클래스가 아님.)
public class Beans {

    @Bean // xml에서 쓰던 <bean> 태그 역할
    public Tire koreaTire(){
        return new KoreaTire();
    }

    @Bean
    public Car sonata(){
//        Car c = new Car();
//        c.setTire(koreaTire()); // xml에서 <property> 태그 쓰던 경우
        Car c = new Car(koreaTire()); // xml에서 <constructor-arg>
        return c;
    }
}
