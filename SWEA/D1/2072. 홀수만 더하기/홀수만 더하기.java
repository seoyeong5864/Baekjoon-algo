
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int[] arr = new int[10];
			for(int i = 0; i < 10; i++) {
				arr[i] = sc.nextInt();
			}
			
			int sum = 0;
			for(int i = 0; i < 10; i++) {
				if(arr[i] % 2 == 1)
					sum += arr[i];
			}
			
			
			System.out.println("#"+tc+" "+sum);
			
			
			
			
			
			
		}
		
		
		
		
		
		
	}

}
