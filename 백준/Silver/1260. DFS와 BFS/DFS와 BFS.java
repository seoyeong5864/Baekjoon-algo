import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

// DFS 탐색 결과와 BFS 탐색 결과 모두 출력
// 정점 번호가 작은 것을 먼저 방문
// 더 이상 방문할 수 있는 점이 없는 경우 종료

public class Main {

	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int V; // 시작 정점
	static boolean[] visited1;
	static boolean[] visited2;
	static List<Integer>[] graph;
	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	static ArrayDeque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		graph = new LinkedList[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			graph[a].add(b);
			graph[b].add(a);

		}

		// 자식 노드를 오름차순으로 방문
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}

		visited1 = new boolean[N + 1];
		visited2 = new boolean[N + 1];

		dfs(V);
		System.out.println();
		bfs(V);

	}

	private static void dfs(int start) {
		
		// 재귀함수 구현
		visited1[start] = true;
		System.out.print(start+" ");
		
		for(int next : graph[start]) {
			if(!visited1[next]) {
				dfs(next);
			}
		}
		
		
		// stack 구현
//		stack.push(start);
//		
//		while(!stack.isEmpty()) {
//			
//			int check = stack.pop();
//			
//			if(visited1[check]) continue;
//			visited1[check] = true;
//			System.out.println();
//			for(int next : graph[check]) {
//				if(!visited1[next]) {
//					stack.push(next);
//				}
//			}
//			
//			 
//			
//		}
		
	}

	private static void bfs(int start) {

		queue.offerLast(start);
		
		while(!queue.isEmpty()) {
			
			int check = queue.pollFirst();
			
			if(visited2[check]) continue;
			visited2[check] = true;
			System.out.print(check+" ");
			for(int next : graph[check]) {
				if(!visited2[next]) {
					queue.offerLast(next);
				}
			}
			
			
		}
		
	}

}
