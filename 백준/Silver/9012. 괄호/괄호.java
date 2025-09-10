import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String line = sc.next();
			ArrayDeque<Character> stack = new ArrayDeque<>();
			boolean isValid = false;
			for (int i = 0; i < line.length(); i++) {
				char ch = line.charAt(i);
				if (ch == '(') {
					stack.push(ch);
				} else {
					if (stack.isEmpty()) {
						isValid = false;
						break;
					} else {
						stack.pop();
						isValid = true;
					}
				}
			}

			// 올바른 문자열이면 yes 아니면 no
			if (stack.isEmpty() && isValid) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		} // tc
	}
}
