import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 입력
		Character[][] arr = new Character[5][15];

		for (int i = 0; i < 5; i++) {
			String line = sc.nextLine();
			// 문장 길이만큼 문자 받고
			for (int j = 0; j < line.length(); j++) {
				arr[i][j] = line.charAt(j);
			}
			// 남은 부분은 공백으로 채우기
			for (int j = line.length(); j < 15; j++) {
				arr[i][j] = '\u0000';
			}
		}

		// 출력
		for (int j = 0; j < 15; j++) {
			for (int i = 0; i < 5; i++) {
				if (arr[i][j] == '\u0000')
					continue;
				System.out.print(arr[i][j]);
			}
		}

	}

}
