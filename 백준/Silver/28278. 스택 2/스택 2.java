import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());

            if (order == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
            } else if (order == 2) {
                if (!stack.isEmpty()) sb.append(stack.pop()).append('\n');
                else sb.append(-1).append('\n');
            } else if (order == 3) {
                sb.append(stack.size()).append('\n');
            } else if (order == 4) {
                sb.append(stack.isEmpty() ? 1 : 0).append('\n');
            } else if (order == 5) {
                if (!stack.isEmpty()) sb.append(stack.peek()).append('\n');
                else sb.append(-1).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
