package ver1_strategy;

public class Driver {
    public static void main(String[] args) {
        Car car = new Car("BMW", "White", new KoreaTire()); // mysql
        car.printInfo();

        car.setTire(new ChinaTire()); // oracle
        car.printInfo();


    }
}
