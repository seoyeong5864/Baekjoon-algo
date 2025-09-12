import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[] pick, num;
	static boolean[] sel;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = i+1;
		}
		sel = new boolean[N];
		pick = new int[M];
		
		combRep(0,0);
		
		System.out.println(sb.toString());
	
		
	}


	private static void combRep(int idx, int sidx) {
		
		// 종료조건
		if(sidx == M) {
			for(int i = 0; i < M; i++) {
				sb.append(pick[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		
		if(idx == N) return;
		
		// 이번 숫자 선택했으면 -> pick에 저장
		// 근데 같은 숫자 또 선택할 수 있으니깐 idx+1 아니고 idx 또 써줘도됨
		pick[sidx] = num[idx];
		combRep(idx, sidx+1);
		
		// 이번 숫자 선택안했으면
		combRep(idx+1, sidx);
		
		
		
		
		
	}
}
