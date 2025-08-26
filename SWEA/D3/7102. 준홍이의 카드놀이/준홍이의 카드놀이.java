import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			// 입력
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] arr = new int[N * M + 1]; // 0 자리를 비움

			// 로직
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					int sum = i + j;
					arr[sum]++;
				}
			}

			int maxcount = 0;
			for (int i = 1; i < arr.length; i++) {
				maxcount = Math.max(maxcount, arr[i]);
			}

			// 출력
			System.out.print("#" + tc + " ");
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == maxcount) {
					System.out.print(i + " ");
				}
			}
			System.out.println();

		}
	}

}
