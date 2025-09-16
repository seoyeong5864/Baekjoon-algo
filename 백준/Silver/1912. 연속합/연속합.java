import java.util.Arrays;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// dp[] - 마지막에 i번째 값을 더했을때의 최대합을 저장
		int[] dp = new int[N];
		// 초기값
		dp[0] = arr[0];
		
		
		// 로직
		int maxSum = dp[0]; // 초기화
		for(int i = 1; i < N; i++) {
			dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);
			maxSum = Math.max(maxSum, dp[i]);
		}
		
			
		// 출력
		System.out.println(maxSum);
	}
}
