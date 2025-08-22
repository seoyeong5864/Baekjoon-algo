import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 시작시간 + 걸리는 시간(분단위) 계산
		// 입력
		int A = sc.nextInt(); // 현재 시
		int B = sc.nextInt(); // 현재 분
		int C = sc.nextInt(); // 소요 시간(분단위)
		
		// 로직
		int h = C / 60; // 걸리는 시간(시)
		int m = C % 60; // 걸리는 시간(분)
		
		// 계산된 시간
		int H = A + h;
		int M = B + m;
		
		
		if(M >= 60) {
			H +=1;
			M -=60;
			if(H >= 24) H -= 24;
		} else { // 60분이 안넘으면
			if(H >= 24) H -= 24;			
		}


		
		// 출력
		System.out.println(H+" "+M);
		
	}

}
