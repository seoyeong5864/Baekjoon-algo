import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 덱을 정확히 절반으로 나누고
		// 나눈 것들에서 교대로 카드를 뽑아 새로운 덱을 만들어서 출력
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // N개의 카드
			
			
			String[] str = new String[N];
			for(int i = 0; i < N; i++) {
				str[i] = sc.next();
			}
			
			ArrayDeque<String> q1 = new ArrayDeque<>();
			ArrayDeque<String> q2 = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < str.length; i++) {
				
				if(i < (str.length+1)/2) {
					q1.add(str[i]);
				} else q2.add(str[i]);
				
			
			} // 2개의 덱으로 나눔
			
			
			while (!q1.isEmpty() || !q2.isEmpty()) {
				if (!q1.isEmpty()) sb.append(q1.poll()).append(' ');
                if (!q2.isEmpty()) sb.append(q2.poll()).append(' ');
			}
			
			
		System.out.println("#"+tc+" "+ sb.toString());	
			
		}
		
		
		
		
		
	}

}
