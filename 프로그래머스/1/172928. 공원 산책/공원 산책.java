import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];
        
        // 전체 map 저장 + 시작점 찾기
        Character [][] map = new Character[park.length][park[0].length()];
        int r = 0;
        int c = 0;
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[0].length(); j++){
                
                map[i][j] = park[i].charAt(j);
                
                if(park[i].charAt(j) == 'S'){
                    r = i;
                    c = j;
                }

            }
        }
        
        // 이동 방향 & 거리 확인하고 도착점 저장
        for(int i = 0; i < routes.length; i++){
            
            String[] parts = routes[i].split(" ");
            
            String direction = parts[0];
            int dist = Integer.parseInt(parts[1]);
            
            int dr = 0;
            int dc = 0;
            
            if(direction.equals("N")){
                dr = -1;
            } else if(direction.equals("S")){
                dr = 1;
            } else if(direction.equals("E")){
                dc = 1;
            } else{
                dc = -1;
            }
            
            // 이동 가능한 경로 확인
            boolean possible = true;
            
            for(int k = 1; k <= dist; k++){
                int nr = r + dr * k;
                int nc = c + dc * k;
                
                if(nr < 0 || nr >= map.length || nc < 0 || nc >= map[0].length){
                    possible = false;
                    break;
                }
                
                if(map[nr][nc] == 'X'){
                    possible = false;
                    break;
                }
                
                
            }
            
            if(possible){
                r += dr * dist;
                c += dc * dist;
            }
        }
        
        answer[0] = r;
        answer[1] = c;
        
        return answer;
    }
}