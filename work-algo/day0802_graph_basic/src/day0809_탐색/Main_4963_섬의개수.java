package day0809_탐색;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_4963_섬의개수 {
	static int[] di = { -1, -1, 0, +1, +1, +1, 0, -1 }; // 12시방향부터 시계방향으로
	static int[] dj = { 0, +1, +1, +1, 0, -1, -1, -1 };

	static int[][] map;
	static boolean[][] visit;
	static int W, H;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			W = sc.nextInt();
			H = sc.nextInt();

			if(W==0 && H==0) break; // 입력이 무제한 들어오다 0 0 들어왔을때 끝남.
			
			map = new int[H][W];

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					map[i][j] = sc.nextInt();
				}
			} // end input
			
			visit = new boolean[H][W];
			int ans = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j]==1&& !visit[i][j]) { // 땅이다! 처음가는곳 맞나?!
//						bfs(i, j); // 자 이땅 주변에 붙은 땅 다 탐색하러 가자!!
						dfs(i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
	}
	static void dfs(int nowi, int nowj){
		visit[nowi][nowj] = true;

		for(int d=0; d<8; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];
			if(nexti>=0 && nexti<H && nextj>=0 && nextj<W
					&&map[nexti][nextj]==1 && !visit[nexti][nextj]) {
				dfs(nexti, nextj);
			}
		}
	}

	static void bfs(int si, int sj) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(si, sj));
		visit[si][sj] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			
			for(int d=0; d<8; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				if(nexti>=0 && nexti<H && nextj>=0 && nextj<W 
						&&map[nexti][nextj]==1 && !visit[nexti][nextj]) {
					queue.add(new Point(nexti, nextj));
					visit[nexti][nextj] = true;
				}
			}
		}
	}
	
	static class Point{
		int i, j;

		public Point(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}