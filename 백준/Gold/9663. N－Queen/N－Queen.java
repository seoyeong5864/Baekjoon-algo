import java.util.*;

public class Main {
    static int N;
    static boolean[] col;    // 열 사용 여부
    static boolean[] diag1;  // ↘ (i - j + N - 1)
    static boolean[] diag2;  // ↙ (i + j)
    static long count;       // 해의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        col   = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        count = 0;

        dfs(0);  // 0번째 행부터 시작
        System.out.println(count);

        sc.close();
    }

    // i: 현재 배치할 행(0..N-1)
    static void dfs(int i) {
        // 모든 행에 배치 완료 → 해 1개 완성
        if (i == N) {
            count++;
            return;
        }

        for (int j = 0; j < N; j++) {
            int d1 = i - j + (N - 1); // ↘ 대각선 인덱스
            int d2 = i + j;           // ↙ 대각선 인덱스

            // 같은 열/대각선에 이미 퀸이 있으면 스킵
            if (col[j] || diag1[d1] || diag2[d2]) continue;

            // (i, j)에 퀸을 놓는다 → 사용 표시
            col[j] = diag1[d1] = diag2[d2] = true;

            // 다음 행으로
            dfs(i + 1);

            // 되돌리기(백트래킹)
            col[j] = diag1[d1] = diag2[d2] = false;
        }
    }
}
