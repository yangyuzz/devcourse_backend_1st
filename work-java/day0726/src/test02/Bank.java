package test02;

public class Bank {
    private int balance;
    
    synchronized public void plus(){
        balance += 10000;
        System.out.println("만원 입금 현재 잔액 : "+balance);
    }

    synchronized public void minus(){
        balance -= 10000;
        System.out.println("만원 출금 현재 잔액 : "+balance);
    }
}
