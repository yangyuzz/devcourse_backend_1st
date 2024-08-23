package day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main_10026_적록색약 {
    static int[] di = { 1, -1, 0, 0 };
    static int[] dj = { 0, 0, 1, -1 };

    static char[][] map;
    static int normal, rgError;
    static boolean[][] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][];

        for(int n=0; n<N; n++){
            map[n] = br.readLine().toCharArray();
        }

        visit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]){ // 처음보는 칸이야! 여기서 주변 붙어있는 덩어리 다 탐색하고 오면
                    bfs(i, j);
                    normal++; // 덩어리 하나 추가요!
                }
            }
        }

        for (int i = 0; i < N; i++) { // 적록 색약은 R이랑 G 구분 못하지? 그럼 다 R로 통일! map을 훼손하면 간단해지네?!
            for (int j = 0; j < N; j++) {
               if(map[i][j]=='G')
                   map[i][j] = 'R';
            }
        }

        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visit[i][j]){ // 처음보는 칸이야! 여기서 주변 붙어있는 덩어리 다 탐색하고 오면
                    bfs(i, j);
                    rgError++; // 덩어리 하나 추가요!
                }
            }
        }

        System.out.println(normal+" "+rgError);
    }

    static void bfs(int starti, int startj) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(starti, startj));
        visit[starti][startj] = true;

        while(!queue.isEmpty()){
            Point now = queue.poll();

            for(int d=0; d<4; d++) {
                int nexti = now.i + di[d]; // 현재 서있는칸 옆 칸 좌표를 계산해서
                int nextj = now.j + dj[d];
                if (nexti >= 0 && nexti < N && nextj >= 0 && nextj < N && map[starti][startj] == map[nexti][nextj] && !visit[nexti][nextj]) { // 배열 내부이고, 출발한 칸이랑 동일한 알파벳이면? 같은 덩어리임!
                    queue.add(new Point(nexti, nextj));
                    visit[nexti][nextj] = true;
                }
            }
        }
    }

    static class Point{
        int i, j;
        Point(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}
