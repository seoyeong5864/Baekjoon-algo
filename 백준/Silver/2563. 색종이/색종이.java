import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 좌표평면으로 읽을 것 => 101 x 101 배열 생성
		int[][] arr = new int[101][101];

		int N = sc.nextInt(); // 색종이 개수

		for (int n = 0; n < N; n++) {
			int x1 = sc.nextInt(); // x좌표
			int y1 = sc.nextInt(); // y좌표
			int x2 = x1 + 10;
			int y2 = y1 + 10;

			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					arr[i][j] = 1;
				}
			}

		} // N개의 색종이 붙이기

		// 면적 총합 구하기
		int sum = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				sum += arr[i][j];
			}
		}

		// 출력
		System.out.println(sum);

	}

}
