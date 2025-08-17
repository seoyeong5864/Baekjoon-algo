import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			String str = sc.next();
			int N = str.length();
			
			int ball = 0; // 공 개수 카운트
			
			for(int i = 0; i < N-1; i++) {
				char ch1 = str.charAt(i);
				char ch2 = str.charAt(i+1);
				
				if(ch1 == '(' && ch2 == ')') ball++;
				
				if(ch1 == '(' && ch2 == '|') ball++;
				
				if(ch1 == '|' && ch2 == ')') ball++;
				
				
				
			}
			
			
			System.out.println("#"+tc+" "+ball);
			
		}
		
		
	}
}
