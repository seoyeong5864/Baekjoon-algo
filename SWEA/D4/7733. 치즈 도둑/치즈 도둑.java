import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static int N; // 치즈 한변의 길이
	static int[][] map; // 치즈 맛 배열 저장
	static int maxCount; // 치즈덩어리가 가장 많을 때의 개수
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// 입력
			N = sc.nextInt();
			map = new int[N][N];
			int maxTaste = 0; // 최대맛 찾기 -> 여기까지만 반복
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					maxTaste = Math.max(maxTaste, map[i][j]);
				}
			}

			// 로직
			maxCount = 0;

			for (int day = 0; day <= maxTaste; day++) {

				// 오늘 기준 치즈 덩어리 개수 카운트
				visited = new boolean[N][N];
				int count = 0;
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						// 아직 안 먹었고, visited=false 이면 새로운 덩어리 시작
						if (map[i][j] > day && !visited[i][j]) {
							bfs(i, j, day);
							count++;
						}
					}
				}

				maxCount = Math.max(maxCount, count);

			}

			// 출력
			System.out.println("#" + tc + " " + maxCount);
		}

	}

	// 상하좌우 탐색
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int r, int c, int day) {

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = curr[0] + dr[k];
				int nc = curr[1] + dc[k];

				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (map[nr][nc] > day && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
				}
			}
		}

	}

}
