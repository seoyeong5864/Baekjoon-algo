import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] num;
	static int[] pick;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = i+1;
		}
		pick = new int[M];
		
		//  로직
		permRep(0);
		System.out.println(sb.toString());
		
	}


	private static void permRep(int sidx) {
		// 종료조건
		if(sidx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(pick[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		
		for(int i = 0; i < N; i++) {
			pick[sidx] = num[i];
			permRep(sidx+1);
		}
		
	
		
	}

}
