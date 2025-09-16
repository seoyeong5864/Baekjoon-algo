import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// N개의 집에 대해 R G B 칠하는 비용이 주어짐
		// 인접한 집끼리는 색이 달라야함
		// 모든 집을 칠하는 비용의 최솟값 출력

		// 입력
		int N = sc.nextInt(); // 집의 개수
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				cost[i][j] = sc.nextInt();
			}
		}

		int[][] dp = new int[N][3];

		// 로직
		// 초기값 설정
		dp[0][0] = cost[0][0]; // R
		dp[0][1] = cost[0][1]; // G
		dp[0][2] = cost[0][2]; // B
		
		for(int i = 1; i < N; i++) {
			
			dp[i][0] = Math.min(dp[i-1][1]+cost[i][0], dp[i-1][2]+cost[i][0]); //(i-1)에서 G선택 / B선택 비교해서 작은값
			dp[i][1] = Math.min(dp[i-1][0]+cost[i][1], dp[i-1][2]+cost[i][1]); //(i-1)에서 R선택 / B선택 비교해서 작은값
			dp[i][2] = Math.min(dp[i-1][0]+cost[i][2], dp[i-1][1]+cost[i][2]); //(i-1)에서 R선택 / G선택 비교해서 작은값
						
		}

		
		int minCost = Integer.MAX_VALUE;
		for(int i = 0; i < 3; i++) {
			minCost = Math.min(minCost, dp[N-1][i]);
		}
		

		// 출력
		System.out.println(minCost);

	}
}
