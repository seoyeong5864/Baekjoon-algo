import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		long[] dp = new long[N + 1]; // 0 인덱스 비움
		
		
		if(N == 0) {
			System.out.println(1); 
			return;
		}
		if(N == 1) {
			System.out.println(1); 
			return;
		}
		
		
		dp[0] = 1; // 아무것도 채우지 않는 것도 한가지 방법
		dp[1] = 1;
		

		for (int i = 2; i <= N; i++) {
			dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;

		}

		System.out.println(dp[N]);
	}
}
