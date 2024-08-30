package day0830_재귀_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_ver1 {
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
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1) { // 처음부터 익어있는 토마토 큐에 담자!
                    queue.add(new Tomato(i, j, 0));
                }
            }
        } // end input
        
        // BFS 탐색으로 익은 토마토가 주변에 익힐 토마토들 찾아서 큐에 넣기!
        while(!queue.isEmpty()){
            Tomato now = queue.poll();

            ans = now.day; // 어차피 큐에서 마지막에 나오는 애가 제일 늦게 익은 애니까 그 날짜가 답임.
            for(int d=0; d<4; d++){
                int nexti = now.i + di[d];
                int nextj = now.j + dj[d];
                if(nexti>=0 && nexti<N && nextj>=0 && nextj<M && map[nexti][nextj]==0){
                    queue.add(new Tomato(nexti, nextj, now.day+1));
                    map[nexti][nextj]=1;
                }
            }
            print(map);
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j]==0) ans = -1;
            }
        }
        System.out.println(ans);
    }

    static void print(int[][] origin){
        for(int i=0; i<origin.length; i++) {
            for(int j=0; j<origin[i].length; j++) {
                System.out.print(origin[i][j]==7?"#":origin[i][j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
    }

    static class Tomato{
        int i, j;
        int day;

        Tomato(int i, int j, int day){
            this.i = i;
            this.j = j;
            this.day = day;
        }
    }
}
