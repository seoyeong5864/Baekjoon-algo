import java.util.Scanner;

public class Solution {

	static int N; // 전체 재료의 개수
	static int[][] S;
	static int[][] pairSum;
	static boolean[] sel; // true이면 A가 선택, false이면 B가 선택 (A만 선택하면 B는 자동으로 정해짐)
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 맛의 차이가 최소가 되는 경우를 찾기

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			// 입력
			N = sc.nextInt();
			S = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					S[i][j] = sc.nextInt();
				}
			}

			// 로직
			// 시너지의 합 계산
			pairSum = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					pairSum[i][j] = S[i][j] + S[j][i];
				}
			}

			sel = new boolean[N];

			result = Integer.MAX_VALUE;

			combine(0, 0);

			// 출력
			System.out.println("#" + tc + " " + result);

		}

	}

	private static void combine(int idx, int sidx) {
		int sumA = 0;
		int sumB = 0;
		int min; // A와 B의 차의 절댓값

		// 종료조건
		if (sidx == N / 2) {
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (sel[i] == true && sel[j] == true) {
						sumA += pairSum[i][j];
					} else if (sel[i] == false && sel[j] == false) {
						sumB += pairSum[i][j];
					}
				}

			} // 음식A와 B 대한 맛 계산

			min = Math.abs(sumA - sumB);
			result = Math.min(result, min);
			return;
		}

		if (idx == N)
			return;

		// 현재 재료 A가 선택
		sel[idx] = true;
		combine(idx + 1, sidx + 1);

		// 현재 재료 A가 선택하지 않음 (B가 선택)
		sel[idx] = false;
		combine(idx + 1, sidx);

	}
}
