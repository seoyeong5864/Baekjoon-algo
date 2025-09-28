import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	static int cnt; //구역개수 카운트
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			M = sc.nextInt();
			N = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			int K = sc.nextInt();

			for (int i = 0; i < K; i++) {

				int x = sc.nextInt();
				int y = sc.nextInt();

				map[y][x] = 1;

			}


			// 로직
			cnt = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			
			// 출력
			System.out.println(cnt);
			

		}
	}

	private static void bfs(int sr, int sc) {
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[sr][sc] = true;
		q.add(new int[] {sr,sc});
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int k = 0; k < 4; k++) {
				
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(map[nr][nc] != 1 || visited[nr][nc] == true) continue;
				// 위에 해당 안되면 배추 있고 방문 가능한 곳
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
			
		}
		
		
	}
}
