import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 연속적인 번호를 갖는 경우 => run
		// 3장의 카드가 동일한 번호 => trip
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			// 입력
			String line = sc.next();
			int[] card = new int[6];
			for(int i = 0; i < 6; i++) {
				card[i] = line.charAt(i) - '0';
			}
			
//			System.out.println(Arrays.toString(card));
			
			// 로직
			// 카운팅 배열
			int[] cnt = new int[10]; // 숫자 0~9
			for(int i = 0; i < 6; i++) {
				cnt[card[i]]++;
			}
			
			// 베이비진 판별
			boolean isBabyGin = false;
			
			// 1) 트리플 제거 후 -> 런 제거
			int[] c = cnt.clone();
			int triple = 0;
			int run = 0;
			
			// 트리플 제거
			for(int i = 0; i <= 9; i++) {
				while(c[i] >= 3) {
					c[i] = c[i]-3;
					triple++;
					if(triple == 2) break;
				}
				if(triple == 2) break;
			}
			
			// 런 제거
			if(triple + run < 2) {
				for(int i = 0; i <= 7; i++) {
					while(c[i] > 0 && c[i+1] > 0 && c[i+2] > 0) {
						// 연속된 세자리가 있는 경우
						c[i]--;
						c[i+1]--;
						c[i+2]--;
						run++;
						if(triple + run == 2) break;
					}
					if(triple + run == 2) break;
				}
			}
			
			
			if (triple + run >= 2) {
				isBabyGin = true;
			}
			
			
			// 2) 런 제거 후 트리플 제거
			// 1)에서 베이비진이 안된 경우, 한번 더 확인
			if(!isBabyGin) {
				c = cnt.clone();
				triple = 0;
				run = 0;
				
				// 런 제거
				for(int i = 0; i <= 7; i++) {
					while(c[i] > 0 && c[i+1] > 0 && c[i+2] > 0) {
						c[i]--;
						c[i+1]--;
						c[i+2]--;
						run++;
						if(run == 2) break;
					}
					if(run == 2) break;
				}
				
				
				// 트리플 제거
				if(triple + run < 2) {
					for(int i = 0; i <= 9; i++) {
						while(c[i] >= 3) {
							c[i] = c[i]-3;
							triple++;
							if(triple+run == 2) break;
						}
						if(triple + run == 2) break;
					}
				}
				
				if(triple + run >= 2) {
					isBabyGin = true;
				}
				
				
			}
			
			
			
			
			
			// 출력
			if(isBabyGin) {
				System.out.println("#"+tc+" "+"true");
			} else {
				System.out.println("#"+tc+" "+"false");
			}
			
		}
	}

}
