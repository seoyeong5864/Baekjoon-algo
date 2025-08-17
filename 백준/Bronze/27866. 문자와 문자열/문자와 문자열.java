import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int i = sc.nextInt();
		
		for(int n = 0; n < str.length(); n++) {
			if(n == i - 1)
				System.out.println(str.charAt(n));
		}
		
	}

}
