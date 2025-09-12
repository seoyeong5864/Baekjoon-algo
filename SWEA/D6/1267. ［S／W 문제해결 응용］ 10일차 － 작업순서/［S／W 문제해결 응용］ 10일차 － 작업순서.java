import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			// 입력
			
			String[] temp = sc.nextLine().split(" ");
			int V = Integer.parseInt(temp[0]);
			int E = Integer.parseInt(temp[1]);
			
			// 간선의 정보 입력
			// 인접리스트
			List<List<Integer>> graph = new ArrayList<>();
			for(int i = 0; i < V+1; i++) {
				graph.add(new ArrayList<>());
			}
			
			// 진입 차수 배열
			int[] indegree = new int[V+1];
			
			// 간선의 정보를 입력
			temp = sc.nextLine().split(" ");
			for(int i = 0; i < E; i++) {
				int u = Integer.parseInt(temp[i*2]);
				int v = Integer.parseInt(temp[i*2+1]);
				
				// u -> v 단방향 간선 기록
				graph.get(u).add(v);
				
				// 진입 차수
				indegree[v]++;
			}
			
			
			
			// 로직
			List<Integer> result = topologySort(graph, V, E, indegree);
			
			
			// 출력
			System.out.print("#"+tc);
			for(int i = 0; i < V; i++) {
				System.out.print(" "+result.get(i));
			}
			System.out.println();
		}
	}

	private static List<Integer> topologySort(List<List<Integer>> graph, int V, int E, int[] indegree) {
		List<Integer> result = new ArrayList<>();
		// 큐 선언
		Queue<Integer> q = new LinkedList<>();
		
		// 1. 진입차수가 0인 정점을 큐에 추가
		for(int i = 1; i <= V; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
		
		
		while(!q.isEmpty()) {
			// 2. 큐에서 정점을 꺼내어 결과로 출력하고 연결된 정점들의 진입차수를 감소
			int curr = q.poll();
			result.add(curr);
			
			// 인접되어 있는 정점에 대해서 진입차수 감소
			for(int nxt : graph.get(curr)) {
				// 연결된 정점의 진입차수들을 1씩 감소
				indegree[nxt]--;
				
				// 3. 새로 진입차수가 0이 된 정점들을 큐에 추가
				if(indegree[nxt] == 0) {
					q.offer(nxt);
			}
			
			
			}
		}
		
		return result;
	}
}
