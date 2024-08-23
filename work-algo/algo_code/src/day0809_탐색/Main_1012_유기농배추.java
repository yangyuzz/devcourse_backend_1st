package day0809_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1012_유기농배추 {
	static int M, N; // M:가로, N:세로
	static int K; // 배추 갯수
	static int[][] map;
	static boolean[][] visit;

	static int[] di = { +1, -1, 0, 0 };
	static int[] dj = { 0, 0, +1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt(); // 테스트 케이스의 개수

		for (int tc = 1; tc <= TC; tc++) {

			M = sc.nextInt(); // 가로j
			N = sc.nextInt(); // 세로i

			K = sc.nextInt(); // 배추 좌표 갯수

			map = new int[N][M]; // 행열 주의!
			visit = new boolean[N][M];

			for (int k = 0; k < K; k++) { // 배추 좌표 입력
				int X = sc.nextInt(); // M이랑 관련있으니 좌우 열번호 j 좌표
				int Y = sc.nextInt(); // N이랑 관련있으니 세로 행번호 i 좌표
				map[Y][X] = 1; // 배추 위치 기록
			}

			int ans = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visit[i][j]) { // visit[i][j]==false
						// 여정을 시작하자! gogo!!
						dfs(i, j);
						// 여정이 끝났음?!
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}

	static void bfs(int si, int sj) {
		Point start = new Point(si, sj); // 출발하는 정점!

		Queue<Point> queue = new LinkedList<>(); // 방문 스케줄!
		queue.add(start); // 방문 스케줄 큐에 넣고!
		visit[start.i][start.j] = true; // 지금 스케줄큐에 들어간 정점 기록해서 중복해서 큐에 들어가지 않게!

		while(!queue.isEmpty()) { // 스케줄 남았으면 계속 해야징~~
			Point now = queue.poll(); // 자 이번 스케줄 처리합시다!

			for(int d=0; d<4; d++) { // 옆에 붙어있는 1 있나요 ? 있으면 스케줄 잡아야죠~!
				int ni = now.i + di[d];
				int nj = now.j + dj[d];

				if(ni>=0 && ni<N && nj>=0 && nj<M && map[ni][nj]==1 && visit[ni][nj]==false) {
					queue.add(new Point(ni, nj));
					visit[ni][nj] = true;
				}
			}
		}
	}

	static void dfs(int i, int j) {
		visit[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];

			if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 1 && visit[ni][nj] == false) {
				dfs(ni, nj);
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