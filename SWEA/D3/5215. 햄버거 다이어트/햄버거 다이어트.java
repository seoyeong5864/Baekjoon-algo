import java.util.Scanner;

public class Solution {

	static int N; // 재료의 개수
	static int L; // 제한 칼로리
	static int[] score; // 재료 점수
	static int[] cal; // 재료 칼로리
	static boolean[] sel; // 재료 포함 여부를 저장
	static int maxScore; // 재료 점수 최고합 저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 재료에 대한 점수와 칼로리
		// 정해진 칼로리 이하의 조합 중에서
		// 민기가 가장 선호하는 조합의 햄버거 점수를 출력
		// 같은 재료를 여러번 사용할 수 없음

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// 입력
			N = sc.nextInt();
			L = sc.nextInt();
			score = new int[N];
			cal = new int[N];
			sel = new boolean[N];

			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}

			// 로직
			// 부분집합으로 재료를 선택하면서 점수를 합산함
			// 점수합 최댓값을 업데이트해줌
			maxScore = 0;
			calScore(0);

			// 출력
			System.out.println("#" + tc + " " + maxScore);

		} // tc

	} // main

	private static void calScore(int idx) {
		// idx는 몇번째 재료인지
		int tmpScore = 0; // 재료 점수 합
		int tmpCal = 0; // 재료 칼로리 합

		// 종료조건
		if (idx == N) {
			// true인 재료의 칼로리와 점수 합 계산
			for (int i = 0; i < N; i++) {
				if (sel[i] == true) {
					tmpCal += cal[i];
					tmpScore += score[i];
				}
			}

			// 제한 칼로리보다 낮은지 확인 후 점수 업데이트해줌
			if (tmpCal <= L) {
				maxScore = Math.max(maxScore, tmpScore);
			}
			return;
		}

		// 현재 재료 선택
		sel[idx] = true;
		calScore(idx + 1);

		// 현재 재료 미선택
		sel[idx] = false;
		calScore(idx + 1);
	}
}
