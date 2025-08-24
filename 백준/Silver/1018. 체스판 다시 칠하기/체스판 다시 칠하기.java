
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt(); // 행
        int N = sc.nextInt(); // 열

        char[][] board = new char[M][N];
        for (int i = 0; i < M; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;

        // 8x8 서브보드의 좌상단 (r, c)만 순회
        for (int r = 0; r <= M - 8; r++) {
            for (int c = 0; c <= N - 8; c++) {

                int repaintW = 0; // (r,c)가 'W'라고 가정했을 때 칠할 칸 수
                int repaintB = 0; // (r,c)가 'B'라고 가정했을 때 칠할 칸 수

                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        char cur = board[r + i][c + j];

                        // (i+j)의 짝/홀로 번갈아 색을 판단 (시작칸 기준 상대 좌표)
                        if ((i + j) % 2 == 0) {
                            // 짝수합 위치: 시작칸과 같은 색이어야 함
                            if (cur != 'W') repaintW++; // 시작이 W라고 가정
                            if (cur != 'B') repaintB++; // 시작이 B라고 가정
                        } else {
                            // 홀수합 위치: 시작칸과 반대 색이어야 함
                            if (cur != 'B') repaintW++;
                            if (cur != 'W') repaintB++;
                        }
                    }
                } // 8x8 탐색끝
                
                // 흰색칠/검은색칠 중 더 적은 횟수
                int localMin = Math.min(repaintW, repaintB);
                answer = Math.min(answer, localMin);
            }
        }

        System.out.println(answer);
    }
}
