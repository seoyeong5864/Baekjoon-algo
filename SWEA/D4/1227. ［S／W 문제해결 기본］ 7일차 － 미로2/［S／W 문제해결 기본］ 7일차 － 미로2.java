import java.util.Scanner;

public class Solution {
	
	static int[][] maze;
	static boolean isSuccess;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = 10;
		
		for(int tc = 1; tc <= T; tc++) {
			// 입력
			int tnum = sc.nextInt();
			
			int N = 100;
			maze = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = sc.next();
				for(int j = 0; j < N; j++) {
					maze[i][j] = line.charAt(j) - '0';
				}
			}
			
			
			// 로직
			// DFS 순회 (완전탐색)을 통해 시작점(2) -> 도착점(3)으로 도달할 수 있는지
			// 시작점 좌표(sx,sy)
			int sx = -1, sy = -1;
			outer:
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(maze[i][j] == 2) {
						sx = i;
						sy = j;
						break outer;
					}
				}
			}
			
			// 종료점 좌표(ex,ey)
			int ex = -1, ey = -1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(maze[i][j] == 3) {
						ex = i;
						ey = j;
					}
				}
			}
			
			
			// 최종적으로 도달할 수 있는지 유무
			isSuccess = false;
			visited = new boolean[N][N];
			
			dfs(sx,sy,ex,ey);
			
			
			
			// 출력
			if(isSuccess) {
				System.out.println("#"+tnum+" "+ "1");
			} else System.out.println("#"+tnum+" "+ "0");
			
//			if(visited[ex][ey] == true) {
//				System.out.println("#"+tnum+" "+ "1");
//			} else System.out.println("#"+tnum+" "+ "0");
			
		}
	}

	// 델타배열
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	private static void dfs(int x, int y, int ex, int ey) {
		// 종료조건
		if(x == ex && y == ey) {
			isSuccess = true;
			return; // 이미 도달 완료
		}
		
		
		// 방문위치 체크
		visited[x][y] = true;
		
		//  상하좌우이동
		for(int k = 0; k < 4; k++) {
			// 다음 좌표
			int nr = x + dr[k];
			int nc = y + dc[k];
			
			// 아직 방문하지 하지 않은 지점 방문
			if(0 <= nr && 0 <= nc && nr < 100 && nc < 100 && maze[nr][nc] != 1 && visited[nr][nc] == false) {
				dfs(nr,nc,ex,ey);
			}
			
			
		}
		visited[x][y] = false; // 복구
		
		
		
	}
}
