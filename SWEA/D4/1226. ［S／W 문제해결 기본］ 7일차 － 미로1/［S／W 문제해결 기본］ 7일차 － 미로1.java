import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	
	static final int N = 16;
	static int[][] maze;
	static int[][] dist;
	static boolean isSuccess;
	static int sx, sy, ex, ey;
	// 상하좌우 탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			
			// 입력
			int tnum = sc.nextInt();
			maze = new int[N][N];
			dist = new int[N][N];
			for(int i = 0; i < N; i++) {
				String line = sc.next();
				for(int j = 0; j < N; j++) {
					maze[i][j] = line.charAt(j) - '0';
				}
			}
			
			// 로직
			// 시작점, 도착점 찾기
			sx = 0; sy = 0; ex = 0; ey = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(maze[i][j] == 2) {
						sx = i; sy = j;
					} else if(maze[i][j] == 3) {
						ex = i; ey = j;
					}
				}
			}
			
			isSuccess = false;
			
			bfs(sx, sy);
			
			// 출력
			if(isSuccess) {
				System.out.println("#"+ tnum + " "+ "1");
			} else System.out.println("#"+ tnum + " "+ "0");
			
			
		}
	}

	private static void bfs(int sx, int sy) {
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sx,sy});
		dist[sx][sy] = 1;
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			
			// 종료조건
			if(r == ex && c == ey) {
				isSuccess = true;
				return;
			}
			
			for(int k = 0; k < 4; k++) {
				
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if(maze[nr][nc] != 1 && dist[nr][nc] == 0) {
					dist[nr][nc] = dist[r][c]+1;
					q.add(new int[] {nr,nc});
				}
			}
			
			
		}
		
	}

}
