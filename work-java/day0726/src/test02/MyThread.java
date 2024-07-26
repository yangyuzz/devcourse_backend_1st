package test02;

public class MyThread extends Thread{
    private Bank bank;

    public MyThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            bank.plus(); // 입금먼저 하고
            bank.minus(); // 그다음 출금
        }
    }
}
