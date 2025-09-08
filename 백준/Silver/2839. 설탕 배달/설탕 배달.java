import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 3kg과 5kg만으로 배달
		// 최소한의 봉지 개수
		
		int minBag = Integer.MAX_VALUE; // 최소 봉지 개수
		int bagCount = 0;
		
		// 5kg부터 계산 시작하는게 맞음
		// 5kg을 가장 많이 줄 수 있는 경우부터 시작
		int fiveCount = N / 5;
		
		
		for(int i = fiveCount; i >= 0; i--) {
			
			int rest = N - (i * 5);
			int threeCount = 0;
			
			if(rest % 3 == 0) {
				threeCount = rest / 3;
				bagCount = i + threeCount;
				minBag = Math.min(minBag, bagCount);
			} 
		}
		
		if(minBag == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minBag);
		}
		
		
	}
}
