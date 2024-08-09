package day0802;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static List<Integer> houses;
	static boolean[][] visit;
	static int[] di = {1,-1,0,0};
	static int[] dj = {0,0,1,-1};
	
	static int cnt, size;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			char[] line = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = line[j]-'0';
			}
		} // end input
		
		visit = new boolean[N][N];
		houses = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && !visit[i][j]) { // 처음보는 집이다! 주변 단지 탐색하자 !
					cnt++; // 단지의 갯수
					size = 0; // 지금 출발하는 단지의 사이즈를 여기다 ++ 해서 측정합시다.
//					dfs(i, j);
					bfs(i, j);
					houses.add(size);
				}
			}
		}
		Collections.sort(houses);
		System.out.println(cnt); // 총 단지수
		for(int n: houses) { // 각 단지의 크기
			System.out.println(n); 
		}
			
	}
	
	static void bfs(int i, int j) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(i, j));
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			Point now = queue.poll();
			size++;
			
			for(int d=0; d<4; d++) {
				int nexti = now.i + di[d];
				int nextj = now.j + dj[d];
				if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && !visit[nexti][nextj] && map[nexti][nextj]==1) {
					queue.add(new Point(nexti, nextj));
					visit[nexti][nextj] = true;
				}
			}
		}		
	}

	static void dfs(int nowi, int nowj) {
		visit[nowi][nowj] = true;
		size++;
		
		for(int d=0; d<4; d++) {
			int nexti = nowi + di[d];
			int nextj = nowj + dj[d];
			if(nexti>=0 && nexti<N && nextj>=0 && nextj<N && !visit[nexti][nextj] && map[nexti][nextj]==1) {
				dfs(nexti, nextj);
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