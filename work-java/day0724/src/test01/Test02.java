package test01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n1 = sc.nextInt(); // InputMismatchException
            int n2 = sc.nextInt();

            int result = n1 / n2; // ArithmeticException
            System.out.println("나누기 실행 결과 : " + result);
        } catch (InputMismatchException ex) {
            System.out.println("아 쫌 숫자 입력 하랬잖아요 ㅠㅠ ");
        } finally {
            System.out.println("마침내...?");
        }
        System.out.println("프로그램 종료");
    }
}
