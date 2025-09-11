import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	
	
	static class Edge implements Comparable<Edge>{
		int to, cost;
		
		Edge(int to, int cost){
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}
	
	static int N; // 사람 수
	static List<Edge>[] adjList; // 인접리스트
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 다른 사용자들로부터 가장 가까운 사용자를 출력
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			// 입력
			N = sc.nextInt(); // 사람 수
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			
			// 인접리스트 생성
			adjList = new ArrayList[N+1]; // 0번 인덱스 비움
			for(int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			// 인접행렬을 인접리스트로 변환
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] == 1) {
						adjList[i+1].add(new Edge(j+1, 1)); // 가중치 1
					}
				}
			}
			
			
			int minCC = Integer.MAX_VALUE; // 합이 가장 작은 값 찾기
			
			// 각 정점에 대해 다익스트라 실행
			for(int i = 1; i <= N; i++) {
				int[] dist = dijkstra(i);
				int sum = sumDistance(dist);
				minCC = Math.min(sum, minCC);
			}
			
					

			// 출력
			System.out.println("#"+tc+" "+minCC);
			
		}
		
	}



	private static int[] dijkstra(int start) {
		int INF = Integer.MAX_VALUE;
		int[] dist = new int[N+1];
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start,0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			if(curr.cost > dist[curr.to]) continue;
			
			for(Edge nx : adjList[curr.to]) {
				int nd = curr.cost + nx.cost;
				if(nd < dist[nx.to]) {
					dist[nx.to] = nd;
					pq.add(new Edge(nx.to, nd));
				}
			}
		}
		
		return dist;
		
	}
	
	static int sumDistance(int[] dist) {
		int sum = 0;
		for(int i = 1; i <= N; i++) {
			sum += dist[i];
		}
		return sum;
	}



}
