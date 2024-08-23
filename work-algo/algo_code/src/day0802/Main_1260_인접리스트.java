package day0802;

import java.util.*;

public class Main_1260_인접리스트 {
    static int N, M, V; //정점갯수, 간선갯수, 시작정점
    static LinkedList<Integer>[] adjList; // 인접리스트
    static boolean[] visit; // 정점의 재방문 방지하기 위한 방문체크
    static StringBuilder sb; // DFS 탐색시 재귀 함수에서 방문처리 해야해서 스트링 이어붙일 때 메소드 밖에 있어야 편할수 있음.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        adjList = new LinkedList[N + 1]; // 링크드 리스트가 모든 정점마다 각각 가지도록!
        
        for(int i=1; i<=N; i++){
            adjList[i] = new LinkedList<>(); // 모든 정점들이 일단 비어있는 리스트 객체를 하나씩 가지도록
        }

        for(int m=0; m<M; m++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjList[v1].add(v2);
            adjList[v2].add(v1);
        }

        for(int i=1; i<=N; i++){ // 모든 정점들이 자기 친구 찾을 때 숫자 작은 친구부터 찾아야 하는데 입력순서는 보장되지 않음;;
            Collections.sort(adjList[i]); // 모든 애들이 자기 친구 정보를 오름차순 정렬해서 유지하도록!
        }

        visit = new boolean[N+1]; // 1~N번까지의 정점이 방문했는지 아닌지
        sb = new StringBuilder(); // 방문 할때마다 여기 기록해야지
        dfs(V);
        System.out.println(sb.toString());

        // bfs 탐색 출발을 위해 리셋!
        visit = new boolean[N+1]; // 1~N번까지의 정점이 방문했는지 아닌지
        sb = new StringBuilder(); // 방문 할때마다 여기 기록해야지
        bfs(V);
        System.out.println(sb.toString());
    }

    public static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>(); // or new LinkedList
        queue.add(start); // queue가 곧 방문 스케줄
        visit[start] = true; // BFS는 일단 스케줄 순서대로 무조건 방문 하니까 스케줄 잡은 정점은 이미 큐에 먼저 들어갔다고 표시하기

        while (!queue.isEmpty()) {
            int now = queue.poll(); // 현재 방문처리하는 정점
            sb.append(now+" ");

            for(int next: adjList[now]){
                if(!visit[next]){
                    queue.add(next);
                    visit[next] = true;
                }
            }
        }
    }


    public static void dfs(int now){
        visit[now] = true; // now 칸 방문했다!!
        sb.append(now+" "); // 결과에 보여줄 방문처리 스트링 만들고!

        for(int next: adjList[now]){
            if(!visit[next]){
                dfs(next);
            }
        }

    }
}
