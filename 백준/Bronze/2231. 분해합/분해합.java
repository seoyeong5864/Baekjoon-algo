import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 자연수 N이 주어졌을 때 N의 가장 작은 생성자를 출력
		// 생성자가 없으면 0을 출력
		
		int N = sc.nextInt();
		int M = N; // 생성자
		boolean isM = false;
		
		
		// 로직
		for(int m = N; m > 0; m--) {
			String strM = Integer.toString(m);
			int sum = m;
			for(int i = 0; i < strM.length(); i++) {
				char ch = strM.charAt(i);
				sum += (ch - '0');
			}
			if(sum == N) {
				isM = true;
				M = Math.min(M, m);
			}
		}
			
			
			
		// 출력
		if(isM) {
			System.out.println(M);
		} else System.out.println(0);
		
	}

}
