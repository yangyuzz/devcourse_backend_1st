package test07_bruteforce;

import java.util.Arrays;

public class Test02_부분집합 {
    static int N = 3;
    static String[] cards = {"A","B","C"};
    static boolean[] select = new boolean[N];

    public static void main(String[] args) {
        subset(0);
    }

    static void subset(int idx){
        if(idx == N){ // 앞에 카드 다 선택 할지말지 먼저 재귀들이 골랐고.. 나는 카드 음슴.
            System.out.println(Arrays.toString(select)); // N개중에 true라고 되어있는 것들로 시뮬레이션 돌려서 계산해보기
            return;
        }

        select[idx] = true;
        subset(idx+1);
        select[idx] = false;
        subset(idx+1);
        return;
    }
}
