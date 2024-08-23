package day0809_탐색;

import java.util.Scanner;

public class Solution_1954_달팽이숫자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int TC = sc.nextInt();
        int[] di = {0,+1,0,-1};
        int[] dj = {+1,0,-1,0};

        for(int tc=1; tc<=TC; tc++){
            int N = sc.nextInt(); // 배열 크기
            int dir = 0; // 출발방향 0을 오른쪽으로 di, dj 셋팅 해놨고 순서는 우, 하, 좌, 상
            int num= 1;
            int nowi=0, nowj=0;
            int[][] map = new int[N][N];

            while(true){
                map[nowi][nowj] = num; // 졸라맨이 현재 칸에 해야할 일
                if(num == N*N) break;

                int nexti = nowi + di[dir];
                int nextj = nowj + dj[dir];

                if(nexti<0 || nexti>=N || nextj<0 || nextj>=N || map[nexti][nextj]!=0 ){
                    dir = dir+1;
                    dir %= 4;
                    continue;
                }
                nowi = nexti;
                nowj = nextj;
                num++;
            }

            System.out.println("#"+tc);
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
