import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] board;
	static int ans;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 퀸 N개를 서로 공격할 수 없도록 놓는 경우의 수
		// 같은 행, 열, 대각선 위의 말을 공격할 수 있음
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = sc.nextInt();
			
			// 말을 놓은 위치 확인
			board = new int[N][N];
			
			ans = 0; // 경우의 수 카운트
			
			// 0번째 row부터 확인 시작
			nqueen(0);
			
			
			// 출력
			System.out.println("#"+tc+" "+ans);
		}
	}

	
	// row = 현재 확인하고 있는 row
	// 한 줄씩 내려가면서 말을 두자
	private static void nqueen(int row) {
		
		// N개의 row를 전부 채우면 => 한가지 경우의 수 완성
		if(row == N) {
			ans++;
			return;
		}
		
		// 각 row의 모든 col에 대해서 확인
		for(int col = 0; col < N; col++) {
			if(isPossible(row, col)) {
				board[row][col]++; // 말 놓기
				nqueen(row+1); // 다음 row 호출
				board[row][col]--; // 되돌리기
			}
		}
	}
	
	// 말을 둘 수 있는 곳인지 확인
	// 바로 위에 row 확인
	private static boolean isPossible(int r, int c) {
		// 바로 위쪽에 말이 있는지 확인
		for(int i = 0; i < r; i++) {
			if(board[i][c] == 1) {
				return false;
			}
		}
		
		// 왼쪽 위 대각선 확인
		for(int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		
		// 오른쪽 위 대각선 확인
		for(int i = r - 1, j = c + 1; i >= 0 && j < N; i--, j++) {
			if(board[i][j] == 1) {
				return false;
			}
		}
		// 위의 3가지 경우에 해당되지 않으면 말을 놓을 수 있음
		return true; 
	}
	
	
}
