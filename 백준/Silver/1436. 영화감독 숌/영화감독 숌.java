import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // N번째
		
		int num = 1;
		int count = 0;
		
		while(true) {
			
			// 문자열에 '666'이 포함되어 있으면 카운트 증가
			if(Integer.toString(num).contains("666")) {
				count++;
			}
			
			
			// 반복문 종료조건
			if(count == N) {
				System.out.println(num);
				break;
			}
			
			num++;
			
		}
		
		
		
	}

}
