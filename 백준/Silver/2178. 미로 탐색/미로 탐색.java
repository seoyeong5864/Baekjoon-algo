import java.util.ArrayDeque;
import java.util.Scanner;

public class Main{
	
	static int N; 
	static int M;
	static int[][] maze;
	static int[][] dist;
	
	// 상하좌우 탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		maze = new int[N+1][M+1];
		for(int i = 1; i <= N; i++) {
			String line = sc.next();
			for(int j = 1; j <= M; j++) {
				maze[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		
		dist = new int[N+1][M+1];
		
		int ans = bfs(1,1);
		
		System.out.println(ans);
		
	}

	private static int bfs(int sr, int sc) {
		
		ArrayDeque<int[]> q = new ArrayDeque<>();
		dist[sr][sc] = 1;
		q.add(new int[] {sr,sc});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			// 종료조건
			if(r == N && c == M) return dist[r][c];
			
			// 상하좌우 탐색
			for(int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 1 || nc < 1 || nr > N || nc > M)
					continue;
				// 길이고 & 방문한적이 없으면(거리가 0이면)
				if(maze[nr][nc] == 1 && dist[nr][nc] == 0) {
					dist[nr][nc] = dist[r][c] + 1;
					q.add(new int[] {nr,nc});
				}
			}
			
		}
		
		return -1; // 못찾으면 반환
	}
}
