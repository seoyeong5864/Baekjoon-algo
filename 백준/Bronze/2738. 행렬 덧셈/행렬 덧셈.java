import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N x M 크기의 두 행렬 A와 B
		// 두 행렬을 더하는 프로그램
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		// 행렬 A
		int[][] A = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		
		// 행렬 B
		int[][] B = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		
		// A + B 행렬
		int[][] arr = new int[N][M];
		
		
		// 로직
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				arr[i][j] = A[i][j] + B[i][j];
			}
		}
		
		// 출력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
	}
}
