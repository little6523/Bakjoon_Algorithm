import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int[] pos = {0, 0};
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    pos[0] = i;
                    pos[1] = j;
                }
            }
        }
        
        for (String route : routes) {
            StringTokenizer st = new StringTokenizer(route);
            String dir = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            
            pos = go(park, pos, dir, num);
        }
        answer = pos;
        return answer;
    }
    
    public int[] go(String[] park, int[] pos, String dir, int num) {
        int[] temp = new int[] {pos[0], pos[1]};
        
        if (dir.equals("E")) {
            for (int i = 0; i < num; i++) {
                temp[1] += 1;
                
                if (temp[1] >= park[0].length()) {
                    return pos;
                }
                
                if (park[temp[0]].charAt(temp[1]) == 'X') {
                    return pos;
                }
            }
        }
        
        else if (dir.equals("S")) {
            for (int i = 0; i < num; i++) {
                temp[0] += 1;
                
                if (temp[0] >= park.length) {
                    return pos;
                }
                
                if (park[temp[0]].charAt(temp[1]) == 'X') {
                    return pos;
                }
            }
        }
        
        else if (dir.equals("W")) {
            for (int i = 0; i < num; i++) {
                temp[1] -= 1;
                if (temp[1] < 0) {
                    return pos;
                }
                
                if (park[temp[0]].charAt(temp[1]) == 'X') {
                    return pos;
                }
            }
        }
        
        else if (dir.equals("N")) {
            for (int i = 0; i < num; i++) {
                temp[0] -= 1;
                if (temp[0] < 0) {
                    return pos;
                }
                
                if (park[temp[0]].charAt(temp[1]) == 'X') {
                    return pos;
                }
            }
        }
        
        return temp;
    }
}
