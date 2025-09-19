import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		int N = sc.nextInt();
		int[][] tri = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				tri[i][j] = sc.nextInt();
			}
		}		
		
		int[][] dp = new int[N][N];
		
		
		// 로직
		// 초기값 설정
		dp[0][0] = tri[0][0];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N; j++) {
				
				if(j-1 < 0) {
					dp[i][j] = tri[i][j] + dp[i-1][j];
					continue;
				}
				
				dp[i][j] = Math.max(tri[i][j] + dp[i-1][j-1], tri[i][j] + dp[i-1][j]);
			}
		}
				
		// 최대합 찾기
		int maxSum = 0;
		for(int i = 0; i < N; i++) {
			maxSum = Math.max(maxSum, dp[N-1][i]);
		}
		
		// 출력
		System.out.println(maxSum);
		
	}
}
