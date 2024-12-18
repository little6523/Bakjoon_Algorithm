import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (map.get(temp) == null) {
                answer.add(-1);
                map.put(temp, i);
            } else {
                answer.add(i - map.get(temp));
                map.put(s.charAt(i), i);
            }
        }
        
        return answer;
    }
}