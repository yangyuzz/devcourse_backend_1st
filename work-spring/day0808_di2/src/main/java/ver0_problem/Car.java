package ver0_problem;

// 비지니스 로직을 처리하는 서비스 클래스(사용자 권한 체크라던지.. 포인트 계산이라던지.. 트랜잭션 담당.. 예를들면 송금하기 : update+update)
public class Car {
    // 여기서 JDBC 코딩을 다 하긴 좀 지저분하고.. SQL 실행 역할을 맡은 객체를 데리고 있다가 일 시켜야지!
    //private KoreaTire koreaTire = new KoreaTire(); // Oracle로 바꾸려면 Car클래스를 수정해야 함.
    private ChinaTire chinaTire = new ChinaTire(); // 의존하는 객체를 너무 강하게 결합하고 있음.
    private String model;
    private String color;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    // 예를 들면 송금같은 비즈니스 로직 처리 함수를 작성하는게 내 일이지!
    public void printInfo(){
        System.out.println("차량 모델 : "+model); // 잔액 체크(select)
        System.out.println("색상 : "+color); // 출금 처리(insert or update)
//        System.out.println("장착된 타이어 : "+koreaTire.getModel()); // SQL 실행이 필요할 때는 이렇게 부하직원 객체에게 일 시켜버림! // 입금 처리(insert or update)
        System.out.println("장착된 타이어 : "+chinaTire.getTireModel()); // SQL 실행이 필요할 때는 이렇게 부하직원 객체에게 일 시켜버림! // 입금 처리(insert or update)
    }
}
