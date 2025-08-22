import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 원래 설정되어 있는 알람을 45분 앞서는 시간으로 바꾸기
		// 24시간 표현
		// 0:0 (자정) 23:59(끝)
		
		//입력
		int H = sc.nextInt(); // 시
		int M = sc.nextInt(); // 분
		
		// 로직
		// (M-45)가 0보다 작으면 H-1
		// 자정 생각 잘해줘야됨
		
		if(M-45 > 0) {
			M -= 45;
		} else if(M-45 < 0) {
			if(H==0) {
				H = 23;
				M += 15;
			} else {
				H -= 1;
				M += 15;
			}
		} else if(M-45 == 0) {
			M = 0;
		}
		
		
		
		//출력
		System.out.println(H+" "+M);
		
	}

}
