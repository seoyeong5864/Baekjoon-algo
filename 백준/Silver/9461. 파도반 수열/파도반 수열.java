import java.util.Scanner;

public class Main {
	
	static long p[] = new long[101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			// 입력
			int N = sc.nextInt();
			
			// 로직
			// 초기값 세팅
			p[1] = p[2] = p[3] = 1;
			
			for(int i = 4; i <= 100; i++) {
				p[i] = p[i-2] + p[i-3];
			}
			
			
			// 출력
			System.out.println(p[N]);
			
		}
		
	}
}
