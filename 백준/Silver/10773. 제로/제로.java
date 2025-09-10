import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 정수가 0일 경우 가장 최근에 쓴 수를 지우고
		// 아닐 경우 해당 수를 씀
		// 재민이가 최종적으로 적어 낸 수의 합을 출력

		int K = sc.nextInt();
		ArrayDeque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < K; i++) {
			int x = sc.nextInt();

			if (x == 0) {
				stack.pop();
			} else {
				stack.push(x);
			}

		}

		// 출력
		int sum = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		System.out.println(sum);

	}

}
