import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는
	// 익지 않은 토마토가 익게 됨
	// 토마토가 며칠이 지나면 다 익게 되는지 최소 일수
	// 1 - 익은 토마토
	// 0 - 익지 않은 토마토
	// -1 - 토마토가 들어있지 않은 칸
	
	//출력
	// 최소 일수를 출력
	// 이미 처음부터 모든 토마토가 익어 있으면 0 출력
	// 토마토가 모두 익지 못하는 상황이면 -1 출력
	
	
	static int M;
	static int N;
	static int[][] box;
	static int[][] dist;
	// 상하좌우 탐색
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		M = sc.nextInt();
		N = sc.nextInt();
		box = new int[N][M];
		dist = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		
		// dist를 전부 -1로 초기화
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				dist[i][j] = -1;
			}
		}
				
		// 로직
		bfs();
		
		
		// 출력
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				// 아직 안 익은 토마토가 있으면
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				
				ans = Math.max(ans, dist[i][j]);
			}
		}
		
		
		System.out.println(ans);
		
	}


	private static void bfs() {
		
		Queue<int[]> q = new ArrayDeque<>();
		
		// 처음에 익어있던 토마토 위치를 전부 큐에 넣기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					dist[i][j] = 0; //시작점들은 모두 0일로 셋팅
					q.add(new int[] {i,j});
				}
			}
		}
		
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			
			for(int k = 0; k < 4; k++) {
				
				int nr = r + dr[k];
				int nc = c + dc[k];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(box[nr][nc] == -1) continue; // 토마토가 없는 칸 지나감
				if(dist[nr][nc] != -1) continue; // 이미 방문한 칸 지나감
				
				// 안 익은 토마토인 경우
				if(box[nr][nc] == 0) {
					dist[nr][nc] = dist[r][c] + 1;
					box[nr][nc] = 1; // 이제 토마토 익음
					q.add(new int[] {nr, nc});
				}
				
			}
			
		}
		
	}
}
