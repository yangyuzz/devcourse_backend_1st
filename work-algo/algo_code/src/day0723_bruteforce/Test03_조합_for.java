package test07_bruteforce;

import java.util.Arrays;

public class Test03_조합_for {
    static int N=5, R= 3;
    static String[] cards = {"A","B","C","D","E"}; // 순열의 재료가 되는 대상(뽑히는 애들)
    static String[] result = new String[R];

    public static void main(String[] args) {
        comb(0, 0);
    }
    static void comb(int cnt, int start){
        if(cnt == R){ // R개가 뽑아서 result 배열에 채워져있음!
            System.out.println(Arrays.toString(result));
            return;
        }

        for(int i=start; i<N; i++){
            result[cnt] = cards[i]; // i번 카드를 사용할게요
            comb(cnt+1, start+1);
        }
    }
}
