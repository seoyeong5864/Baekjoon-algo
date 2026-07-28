import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> rank = new HashMap<>();
        
        for(int i = 0; i < players.length; i++){
            rank.put(players[i], i);
        }
        
        for(String calledPlayer : callings){
            
            // 호출된 선수의 현재 위치
            int currentIndex = rank.get(calledPlayer);
            int frontIndex = currentIndex - 1;
            
            // 바로 앞 선수
            String frontPlayer = players[frontIndex];
            
            // 두 선수 위치 교환
            players[frontIndex] = calledPlayer;
            players[currentIndex] = frontPlayer;
            
            // HashMap에 변경된 위치 반영
            rank.put(calledPlayer, frontIndex);
            rank.put(frontPlayer, currentIndex);
        }
        
        return players;
    }
}