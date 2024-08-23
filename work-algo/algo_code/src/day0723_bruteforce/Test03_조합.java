package test07_bruteforce;

import java.util.Arrays;

public class Test03_조합 {
    static int N=5, R= 3;
    static String[] cards = {"A","B","C","D","E"}; // 순열의 재료가 되는 대상(뽑히는 애들)
    static boolean[] select = new boolean[N];

    public static void main(String[] args) {
        comb(0, 0);
    }

    static void comb(int idx, int cnt){
        if(cnt == R){ // 앞에 재귀들이 R개를 true라고 기록해뒀음.
            System.out.println(Arrays.toString(select)); // 정확히 R개가 true 되어있는 상태임! 그걸로 시뮬레이션 해봅시당
            return;
        }
        if(idx == N) return; // 위에 R개를 뽑는 조건에 안걸리고 내려왔는데... 이미 카드 인덱스 벗어남

        select[idx] = true; // 내가 담당하는 idx 카드를 포함시켰으니
        comb(idx+1, cnt+1); // 다음 카드 뽑아보라고 기다리자. 뽑힌 카드 갯수 1개 증가.
        select[idx] = false; // 이번에는 그 카드 뺀 상태로 조합 만들어봐야지
        comb(idx+1, cnt); // 또 기다리는데 이번에는 뽑힌 카드 갯수 안늘림.
    }
}
