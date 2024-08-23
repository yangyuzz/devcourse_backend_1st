package test07_bruteforce;

import java.util.Arrays;

public class Test01_순열 {
    static int N=5, R= 3;
    static String[] cards = {"A","B","C","D","E"}; // 순열의 재료가 되는 대상(뽑히는 애들)
    static boolean[] used = new boolean[N];

    static String[] result = new String[R]; // N개중에 R개를 뽑아서 순서까지 고려해서 채워놓을 배열
    
    public static void main(String[] args) {
        perm(0);
    }

    static void perm(int idx){ // 함수 한놈한테 줘야하는 재료가 무엇인지.
        if(idx == R){
            System.out.println(Arrays.toString(result)); // 방금 결정된 하나의 순서로 시뮬레이션 계산 등을 하겠지요^^
            return; // 얘는 맡을 칸이 없는 애라 아래는 실행안하고 return 되어야 함.
        }

        for(int i=0; i<N; i++){ // 재귀가 한번 호출되면 A부터 E까지 모든 카드를 한번씩 다 보고 끝남.
            if(used[i])  continue;
            result[idx] = cards[i]; // 먼저 호출된 재귀가 안쓰는 카드네?내가 맡은자리 idx에다 i번 카드를 써볼게요
            used[i] = true; // i번 카드 내가 쓰고있다고 내 다음 재귀들한테 알려야 해요!
            perm(idx+1); // 자 이제 얘가 스택에서 나갈때까지 나는 이 아래 문장 실행 안하고 계속 기다림!!!!!
            used[i] = false;
        }
    }

}



























