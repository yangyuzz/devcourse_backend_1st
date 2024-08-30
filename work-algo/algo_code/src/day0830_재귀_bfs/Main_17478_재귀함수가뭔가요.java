package day0830_재귀_bfs;

import java.util.Scanner;

public class Main_17478_재귀함수가뭔가요 {
    public static int N; // 모든 재귀들이 내가 마지막 순서인지 아닌지 체크할 수 있도록 공유하는 변수
    public static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        sb = new StringBuilder();
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        func(0);
    }

    static void func(int num){
        print(num, "\"재귀함수가 뭔가요?\"");

        if(num<N){
            print(num, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            print(num, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            print(num, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            func(num+1);
        }else{
            print(num, "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }

        print(num, "라고 답변하였지.");
    }


    static void print(int cnt, String msg){
        for(int i=0; i<cnt; i++){
            sb.append("____");
        }
        sb.append(msg+"\n");
    }
}
