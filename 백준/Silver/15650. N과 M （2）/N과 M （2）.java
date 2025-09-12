import java.util.Scanner;

public class Main {
	
	static int N;
	static int M;
	static int[] num; // 1~N까지 자연수 저장
	static int[] pick; // 선택한 숫자 저장
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = i+1;
		}
		pick = new int[M];
		
		combination(0,0);
		
	}

	
	// idx : 내가 현재 확인하고 있는 인덱스
	// sidx : 내가 선택하고 있는 인덱스
	private static void combination(int idx, int sidx) {
		
		// 종료조건
		// M개를 모두 선택했으면
		if(sidx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(pick[i] + " ");
			}
			System.out.println();
			return;
		}
		
		if(idx >= N) return;
		
		
		// 이번 재료를 선택했으면
		pick[sidx] = num[idx];
		combination(idx+1, sidx+1);
		
		// 이번 재료 선택안했으면
		combination(idx+1, sidx);
		
		
	}
}
