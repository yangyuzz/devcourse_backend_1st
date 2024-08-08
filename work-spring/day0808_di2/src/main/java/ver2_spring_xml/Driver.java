package ver2_spring_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Driver {
    public static void main(String[] args) {
//        Car car = new Car("BMW", "White", new KoreaTire()); // mysql
//        car.printInfo();
//
//        car.setTire(new ChinaTire()); // oracle
//        car.printInfo();
        // 객체가 필요하면 new를 하지 않고 beans.xml에서 생성된 객체를 가져다가 쓰면 된답니다.
        // 근데 우리가 web 개발로 가면 이렇게 main을 실행시키지 않고 
        // 톰캣을 돌려놓을 거라서 .. 여기 문법은 진짜 의미가 없어요 .. ㅠㅠㅠㅠ
        // 다만 컨텍스트가 무엇인지 자꾸 익숙해지는게 좋아요.
        // 지금 시점에서는 그냥 현재 작업 프로젝트 전체를 포함하는 애라고 생각할 수 있는데
        // 나중에 프로젝트가 커지면 하나의 프로젝트 내에도 여러 컨텍스트가 존재할 수 있답니다.
//        ApplicationContext context = new ClassPathXmlApplicationContext("/java/ver2_spring_xml/beans.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("/src/main/java/ver2_spring_xml/beans.xml");
        Car c1 = (Car) context.getBean("sonata1");
        Car c2 = (Car) context.getBean("sonata2");

        c1.printInfo();
        c2.printInfo();
    }
}
