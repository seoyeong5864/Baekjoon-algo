import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 격자판에서 최댓값을 찾고
		// 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램

		// 입력
		int[][] arr = new int[10][10];
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// 로직
		int max = Integer.MIN_VALUE;
		int r = 0;
		int c = 0;

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
					r = i;
					c = j;
				}
			}
		}

		// 출력
		System.out.println(max);
		System.out.println(r + " " + c);

	}

}
