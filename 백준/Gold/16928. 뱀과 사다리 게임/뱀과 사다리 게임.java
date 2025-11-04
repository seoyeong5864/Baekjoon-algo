import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	// 100번째 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는지
	// 주사위는 1~6
	
	static int N; // 사다리의 수
	static int M; // 뱀의 수
	static int cnt; // 주사위 굴린 횟수
	static int[] board;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		N = sc.nextInt();
		M = sc.nextInt();
		
		board = new int[101]; // 0번 인덱스 비움
		
		// 보드 채우기 -> 자기자신임
		for(int i = 1; i <= 100; i++) {
			board[i] = i;
		}
		
		
		// 보드에 정보 업데이트
		// 사다리
		for(int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			board[x] = y;
			
		}
		
		// 뱀
		for(int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			board[u] = v;
		}
		
		
		// 로직
		visited = new boolean[101];
		cnt = 0;
		
		snake_ladder(1);
		
		
		
		// 출력
		System.out.println(cnt);
		
	}

	private static void snake_ladder(int position) {
		
		Queue<int[]> q = new ArrayDeque<>();
		visited[position] = true;
		q.add(new int[] {position, 0});
		
	
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			int p = curr[0];
			int c = curr[1];
			
			// 종료조건
			if(p == 100) {
				cnt = c;
				return;
			}
			
			for(int i = 1; i <= 6; i++) {
				
				int np = p + i; // 다음 위치
				
				if(np > 100) continue;
				if(visited[np]) continue;
				
				// 100칸을 넘지 않고 방문하지 않은 곳이라면
				visited[np] = true; // 방문처리
				np = board[np];
				q.add(new int[] {np, c + 1});
				
			}
			
		}
				
	}
}
