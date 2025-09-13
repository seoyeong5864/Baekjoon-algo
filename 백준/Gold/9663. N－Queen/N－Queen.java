import java.util.Scanner;

public class Main {
	
	static int N;
	static int[][] board;
	static int ans;
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 퀸 N개를 서로 공격할 수 없도록 놓는 경우의 수
		// 같은 행, 열, 대각선 위의 말을 공격할 수 있음
		
			N = sc.nextInt();
			
			
			board = new int[N][N]; // 말을 놓은 위치 확인
			
			ans = 0; // 경우의 수 카운트
			
			nqueen(0); // 0번째 row부터 확인 시작
			
			
			// 출력
			System.out.println(ans);
		
	}

	
	
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
	// 현재 row보다 위에 있는 row들에 대해서만 확인
	private static boolean isPossible(int r, int c) {
		// 같은 column에 말이 있는지 확인
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
