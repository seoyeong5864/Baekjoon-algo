import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        
        // i = 몇번째 직원
        for(int i = 0; i < schedules.length; i++){
            
            int time = schedules[i];
            if(event(i,time, startday, timelogs)) {
                answer += 1;
            }
        }
        
        return answer;
    }
    
    
    // 상품을 받을 조건에 해당하는지 확인
    // staff = 해당 직원, time = 희망 출근 시간
    // 0일차 ~ 6일차 (총 7일)
    public boolean event(int staff, int time, int startday, int[][] timelogs){
        
        int sat = 6 - (startday % 7);
        int sun = 7 - startday;
        int success_time = 0;
        
        if(time % 100 + 10 > 59){
            success_time = time + 100 - 50;
        } else success_time = time + 10;
        
        // 토,일을 제외한 모든 요일에서 출근시간 지켜야 함
        for(int j = 0; j < 7; j++){
            
            if(j == sat || j == sun) continue;
            if(timelogs[staff][j] > success_time) {
                return false;
            }
            
        }
        
        return true;
    }
    
    
}