package day0830_재귀_bfs;

import java.util.ArrayList;

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
    static ArrayList<CCTV> camera; // 카메라 총 몇개있을지 입력 안줌.
    static int ans; // 카메라를 적절히 배치했을 때 사각지대의 최소크기

    
}
