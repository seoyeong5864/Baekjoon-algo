import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N장 중 3장의 합이 M을 넘지 않으면서 가장 큰 합
		
		// 입력
		int N = sc.nextInt(); // 카드의 개수
		int M = sc.nextInt();
		int[] card = new int[N];
		for(int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		// 로직
		int maxsum = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					int sum = card[i] + card[j] + card[k];
					if(sum <= M) {
						maxsum = Math.max(maxsum, sum);
					}
					
				}
			}
		}

		// 출력
		System.out.println(maxsum);
	}

}
