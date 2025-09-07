import java.util.Scanner;

public class Solution {

	static int T;
	static int N; // 자연수의 개수
	static int K; // 정해진 합
	static int[] num;
	static boolean sel[]; // 포함되는지 안되는지 저장
	static int count; // 만족시키는 경우의 수 카운트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 최소 1개 이상의 수를 선택하여 합이 K가 되는 경우의 수

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// 입력
			N = sc.nextInt();
			K = sc.nextInt();
			num = new int[N];
			sel = new boolean[N];
			
			for (int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}

			// 로직
			count = 0; // 초기화
			numSum(0);

			// 출력
			System.out.println("#" + tc + " " + count);

		}
	}

	private static void numSum(int idx) {
		int sum = 0; // 합 저장
		int picked = 0;

		// 종료조건
		if (idx == N) {
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					sum += num[i];
					picked++;
				}
			}

			if (picked > 0 && sum == K)
				count++;
			return;
		}

		// 현재 숫자 선택
		sel[idx] = true;
		numSum(idx + 1);

		// 현재 숫자 미선택
		sel[idx] = false;
		numSum(idx + 1);

	}
}
