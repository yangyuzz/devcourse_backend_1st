package day0830_재귀_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_ver2 {
    static int[][] map;
    static int ans; // 모든 토마토가 익는데 걸린 시간
    static int M, N; // M:가로=j, N:세로=i

    static int[] di = {1,-1,0,0};
    static int[] dj = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        Queue<Tomato> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) { // 처음부터 익어있는 토마토 큐에 담자!
                    queue.add(new Tomato(i, j));
                }
            }
        } // end input - queue에 0일차에 익어있는 토마토들 들어있는거임.

        int day=0;
        while(!queue.isEmpty()){
            int size = queue.size(); // day 일차에 익어있는 토마토들

            for(int s=0; s<size; s++){ // day 일차에 익어있는 토마토 갯수 미리 세어놨으니 그만큼만 poll 할래요.
                Tomato now = queue.poll();
                for(int d=0; d<4; d++){
                    int nexti = now.i + di[d];
                    int nextj = now.j + dj[d];
                    if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]==0){
                        queue.add(new Tomato(nexti, nextj));
                        map[nexti][nextj]=1;
                    }
                }
            }
            if(queue.isEmpty()) break; // 큐에 남은 애들이 다음날 익는다고 day++하던건데 다음날 익는 토마토가 없으면 day++ 안해야지

            day++;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) day = -1;
            }
        }

        System.out.println(day);
    }

    static class Tomato{
        int i, j;

        Tomato(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
