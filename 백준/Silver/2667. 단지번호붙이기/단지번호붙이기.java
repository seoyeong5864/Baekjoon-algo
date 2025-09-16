import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static int[][] dist;
	// 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		N = sc.nextInt();
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			String line = sc.next();
			for(int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		dist = new int[N][N];
		
		// 로직
//		bfs(0,0);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && dist[i][j] == 0) {
					pq.add(bfs(i,j));
				}
			}
		}
				
		
		// 출력
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	
	private static int bfs(int sr, int sc) {
		
		Queue<int[]> q = new ArrayDeque<>();
		dist[sr][sc] = 1;
		q.add(new int[] {sr, sc});
		int count = 1; // 집개수카운트
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];

			
			for(int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				//따로따로 처리하자
				//방문한적 있으면(거리가 0이 아니면) 지나가
				//단지가 아니면(1이 아니면) 지나가
				if(dist[nr][nc] != 0) continue;
				if(map[nr][nc] == 0) continue;
				// 아무것도 해당안되면
				count++;
				dist[nr][nc] = dist[r][c] + 1;
				q.add(new int[] {nr, nc});
				
			}
			
		}
		
		return count;
		
	}
	
}
