package test01;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        Thread t1 = new MyThread("이범수", r.nextInt(10000));
        System.out.println("범수 객체 생성 완료");
        Thread t2 = new MyThread("정준상", r.nextInt(10000));
        System.out.println("준상 객체 생성 완료");
        Thread t3 = new MyThread("김민우", r.nextInt(10000));
        System.out.println("민우 객체 생성 완료");

//        t1.run();
//        t2.run();

        t1.start();
        t2.start();
        t3.start();
    }
}
