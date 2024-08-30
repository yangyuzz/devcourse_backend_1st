package day0830_재귀_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_15683_감시 {
    static int[] di = { -1,1,0,0 }; // 0:상 1:하 2:좌 3:우
    static int[] dj = { 0,0,-1,1 };
    
    static String[][] cctvDir = { //[카메라종류][반복횟수+쳐다보는방향]
            {}, //0번 카메라 엄슴
            {"0","1","2","3"}, // 1번 카메라는 상,하,좌,우 4번 실행해봐야 함. cctvDir[1].length = 4
            {"01", "23"}, // 2번 카메라는 상하, 좌우 2번 실행해봐야 함. cctvDir[2].length=2
            {"03", "31", "21", "20"}, // ㄴ, ┌, ㄱ, ┘ cctvDir[3].length = 4
            {"123","023","013","012"}, // cctvDir[4].length=4
            {"0123"} // 5번 카메라는 반복 1회. cctvDir[5].length=1
    };
    
    static int[][][] cctvInfo = { // [카메라종류 1~5][현재 카메라 회전 상태][색칠해야 하는 방향]
            {}, // 0번 카메라 종류 없음.
            {{0},{1},{2},{3}}, // 한번에 한방향만 보는 카메라
            {{0,1}, {2,3}}, // 한번에 두방향 보는 카메라 ex) cctvInfo[2].length = 2(회전수), cctvInfo[2][0].length=2(상하), cctvInfo[2][1].length=2(좌우)
            {{0,3}, {3,1}, {2,1}, {2,0}}, // 한번에 두방향 보는 카메라 ex) cctvInfo[3].length = 4(회전수)
            {{1,2,3},{0,2,3},{0,1,3},{0,1,2}}, // 한번에 세방향 보는 카메라
            {{0,1,2,3}} // 한번에 네방향 보는 카메라.
    };

    static class CCTV {
        int i, j;
        int camType;
        CCTV(int i, int j, int camType) {
            this.i = i;
            this.j = j;
            this.camType = camType;
        }
    }
    static int N, M; // 지도크기
    static ArrayList<CCTV> cameras; // 카메라 총 몇개있을지 입력 안줌.
    static int ans; // 카메라를 적절히 배치했을 때 사각지대의 최소크기

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        int[][] map = new int[N][M];
        cameras = new ArrayList<>();
        ans = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]>=1 && map[i][j]<=5){ // 카메라다 ! 모아 !
                    cameras.add(new CCTV(i, j, map[i][j]));
                }
            }
        }// end input

        dfs(0, map); // (카메라 인덱스, 현재 상태의 맵을 주자)
        System.out.println(ans);
    }
    
    static void dfs(int camIdx, int[][] prev){
//        print(prev);
        if(camIdx == cameras.size()){ // 모든 카메라가 배치된 상태네? 사각지대 체크하자
            int zero = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(prev[i][j] == 0) zero++;
                }
            }
            ans = Math.min(ans, zero);
            return;
        }
        // 현재 내가 배치해야 하는 카메라 종류 확인
        CCTV cctv = cameras.get(camIdx);
        int[][] nowInfo = cctvInfo[cctv.camType]; //ex) cctvInfo[2] = {{0,1},{2,3}}; // {{상,하}, {좌,우}}

        // {0,1} 색칠하게 하고 기다려... 돌아오면 {2,3} 색칠하게 하고 기다려. 그러려면 일단 지도 사본에다 칠해야지!
        for(int r=0; r<nowInfo.length; r++){ // 회전 반복문. 1,3,4번 카메라는 4번반복, 2번카메라는 두번 반복함.
            int[][] copy = deepcopy(prev); // 내가 색칠하기 전 지도를 복사뜸!
            // {0,1} 또는 {0,2,3} 방향에 색칠해야 됨.
            int[] now = nowInfo[r]; // {0,1}, {2,3]이런 1차 배열이 나옴. 현재 카메라가 쳐다보는 방향들임.
            for(int d=0; d<now.length; d++){ // 1번 카메라는 1방향, 5번 카메라는 4방향
                draw(now[d], cctv.i, cctv.j, copy);
            }
            dfs(camIdx+1, copy); // 내가 방금 상,하 색칠한거 줄게. 나 기다린다?
        }
    }

    static void draw(int dir, int si, int sj, int[][] copy){ // 주어진 좌표에서 주어진 방향으로 쭉 직진하면서 색칠하는
        int nexti = si + di[dir];
        int nextj = sj + dj[dir];
        while(true){
            if(nexti<0 || nexti>=N || nextj<0 || nextj>=M || copy[nexti][nextj]==6) break;
            copy[nexti][nextj] = 7; // 뛰쳐나가지 않고 벽 안만났으면
            nexti += di[dir];
            nextj += dj[dir];
        }
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


    static int[][] deepcopy(int[][] origin){
        int[][] copy = new int[origin.length][origin[0].length];

        for(int i=0; i<origin.length; i++) {
            for(int j=0; j<origin[i].length; j++) {
                copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }
}