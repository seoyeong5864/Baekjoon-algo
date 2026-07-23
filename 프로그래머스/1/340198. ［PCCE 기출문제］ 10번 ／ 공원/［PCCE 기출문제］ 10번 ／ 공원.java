import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        
        int answer = 0;
        
        Arrays.sort(mats);
        
        // 큰 돗자리부터 확인
        for(int i = mats.length - 1; i >= 0; i--){
            int size = mats[i];
            
            for(int r = 0; r + size <= park.length; r++){
                for(int c = 0; c + size <= park[r].length; c++){
                    
                    boolean possible = true;
                    
                    for(int nr = r; nr < r + size; nr++){
                        for(int nc = c; nc < c + size; nc++){
                            if(!park[nr][nc].equals("-1")){
                                possible = false;
                                break;
                            }
                        }
                        
                        if(possible == false) break; 
                    }
                    
                    // 돗자리를 깔 수 있는 경우
                    if(possible == true) {
                        answer = size;
                        return answer;
                    }          
                }
            }
            
        }
        
        
        
        // 돗자리를 깔 수 없는 경우
        return -1;
    }
}