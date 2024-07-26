package test02;

public class Test {
    public static void main(String[] args) {
        Bank bank = new Bank();
        MyThread t1 = new MyThread(bank);
        MyThread t2 = new MyThread(bank);

        t1.start();
        t2.start();
    }
}
