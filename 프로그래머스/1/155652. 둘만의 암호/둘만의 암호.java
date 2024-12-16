import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            for (int j = 1; j <= index; j++) {
                temp += 1;
                if(temp > 'z') {
                    temp -= 26;
                }
                
                if(skip.contains("" + temp)) {
                    j--;
                }
            }
            answer += temp;
        }
        
        return answer;
    }
}