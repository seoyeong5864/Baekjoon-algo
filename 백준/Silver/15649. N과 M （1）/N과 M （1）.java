import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N; // 1부터 N까지의 자연수
	static int M; // 선택할 개수
	static int[] num; // 자연수 N개 저장 배열
	static boolean[] sel; // 선택했는지 안했는지 저장
	static int[] pick; // 선택한 숫자 저장
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 입력
		N = sc.nextInt();
		M = sc.nextInt();
		
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = i+1;
		}
		
		pick = new int[M];
		sel = new boolean[N];
		
		// 로직
		dfs(0);
		
		
	}

	private static void dfs(int idx) {
		
		// 종료조건
		if(idx == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(pick[i]+" ");
			}
			System.out.println();
			return;
		}
		
		// 아직 사용 안한 수를 선택
		for(int i = 0; i < N; i++) {
			if(sel[i]) continue; // 선택했으면 패스
			sel[i] = true; // 선택처리
			pick[idx] = num[i];
			dfs(idx+1);
			sel[i] = false; // 되돌리기
		}
		
	}
	
	
	
}
