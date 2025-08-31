import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			
			int tnum = Integer.parseInt(sc.next());
			
			// 100 x 100 문자판
			char[][] board = new char[100][100];

			// 입력
			for (int i = 0; i < 100; i++) {
				String line = sc.next();
				for(int j = 0; j < 100; j++) {
					board[i][j] = line.charAt(j);
				}
			}

			// 로직
			// 각 자리를 회문의 중심이라고 생각
			// 회문의 길이가 홀수 / 짝수
			// 회문이 세로 / 가로
			// 각각의 경우를 나워서 생각

			int maxlen = 1; // 회문의 최대길이
			for (int r = 0; r < 100; r++) {
				for (int c = 0; c < 100; c++) {
					int len; // 회문길이 임시변수

					// 홀수 가로
					// 가운데 글자는 상관없고 그 양옆의 문자가 같은지 확인
					// 같은 row에서 col 값만 바꿔가면서 비교
					int i = c - 1;
					int j = c + 1;
					while (i >= 0 && j < 100 && board[r][i] == board[r][j]) {
						i--;
						j++;
					}
					len = j - i - 1;
					maxlen = Math.max(maxlen, len);

					// 홀수 세로
					i = r - 1;
					j = r + 1;
					while (i >= 0 && j < 100 && board[i][c] == board[j][c]) {
						i--;
						j++;
					}
					len = j - i - 1;
					maxlen = Math.max(maxlen, len);

					// 짝수 가로
					// 바로 옆의 문자는 무조건 같아야하고
					// 그 다음부터 양옆의 문자가 같은지 확인
					i = c;
					j = c + 1;
					while (i >= 0 && j < 100 && board[r][i] == board[r][j]) {
						i--;
						j++;
					}
					len = j - i - 1;
					maxlen = Math.max(maxlen, len);

					// 짝수 세로
					i = r;
					j = r + 1;
					while (i >= 0 && j < 100 && board[i][c] == board[j][c]) {
						i--;
						j++;
					}
					len = j - i - 1;
					maxlen = Math.max(maxlen, len);

				}
			}

			// 출력
			System.out.println("#" + tnum + " " + maxlen);
		}
	}
}
