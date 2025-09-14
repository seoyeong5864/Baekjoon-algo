import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 1번 컴퓨터가 바이러스 걸렸을 때
// 1번을 통해 바이러스 걸리게 되는 컴퓨터의 수 출력

public class Main {
	
	static int N; // 컴퓨터의 수(정점의 수)
	static int M; // 간선의 수
	static List<Integer>[] graph;
	static boolean[] visited;
	static int ans;
	static ArrayDeque<Integer> stack = new ArrayDeque<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		// 인접리스트 생성
		graph = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			// 무방향
			graph[a].add(b);
			graph[b].add(a);
		}
		
		visited = new boolean[N+1];
		ans = 0;
		
		
		
		virus(1);
		
		System.out.println(ans);
		
	}

	private static void virus(int start) {
		// 시작 정점 넣고 시작
		stack.push(start);
		
		while(!stack.isEmpty()) {
			
			// 노드를 스택에 넣고
			// 꺼내면서 자식노드를 확인한 후 스택에 넣음
			int check = stack.pop();
			
			// 방문한적 있으면 패스
			if(visited[check]) continue;
			// 방문한적 없으면
			visited[check] = true;
			if(check != 1) ans++;
			for(int next : graph[check]) {
				if(!visited[next]) {
					stack.push(next);
				}
			}
		}
		
		
	}
}
