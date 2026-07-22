import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int n = 1000;

        for(int tc = 1; tc <= T; tc++){

            int t = sc.nextInt();

            // 0번 인덱스는 비워서 점수와 동일하게 사용
            int[] count = new int[101];

            // 각 점수 빈도 count
            for(int i = 1; i <= n; i++){

                int value = sc.nextInt();

                count[value] += 1;

            }

            int max_cnt = 0; // 최대 빈도수
            int score = 0; // 최대 빈도에 해당하는 점수

            for(int i = 1; i < 101; i++){

                if(count[i] >= max_cnt) {
                    max_cnt = count[i];
                    if(i > score){
                        score = i;
                    }
                }


            }

            // 출력
            System.out.println("#"+t+" "+score);

        }

    }
}
