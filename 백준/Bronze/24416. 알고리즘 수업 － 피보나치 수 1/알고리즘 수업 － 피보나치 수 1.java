import java.util.Scanner;

public class Main {
	
	static int[] f;
	static int count1;
	static int count2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		f = new int[N+1];
		
		// 코드1과 코드2의 호출횟수를 출력
		count1 = 0;
		count2 = 0;
		
		fib(N);
		fibonacci(N);

		System.out.println(count1+" "+count2);
		
	}


	// 재귀호출코드
	static int fib(int N) {
		if(N == 1 || N == 2) {
			count1++;
			return 1; // 코드1
		} else {
			return fib(N-1) + fib(N-2);
		}
	}
					
			
	// DP 코드
	// 배열을 생성해서 값을 저장해두고 bottom-up 형식으로
	private static int fibonacci(int N) {
		f[1] = f[2] = 1;
		for(int i = 3; i <= N; i++) {
			f[i] = f[i-1] + f[i-2]; // 코드2
			count2++;
		}
		return f[N];
	}
	
	
	
}
