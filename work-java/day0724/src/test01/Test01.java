package test01;//import programmers.TTTT;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n1 = sc.nextInt(); // InputMismatchException
            int n2 = sc.nextInt();

            int result = n1 / n2; // ArithmeticException
            System.out.println("나누기 실행 결과 : " + result);
        } catch (InputMismatchException ex) {
            System.out.println("아 쫌 숫자 입력 하랬잖아요 ㅠㅠ ");
        } catch (ArithmeticException ex) {
            System.out.println("0으로 나누려면 정수로는 안되는데 ㅠㅠㅠ");
        } catch (Exception ex) {
            System.out.println("대체 무슨 짓을..................??;;;;;");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("sleep 하다가 예외 발생하면 이렇게 조치할게요");
        }
    }
}