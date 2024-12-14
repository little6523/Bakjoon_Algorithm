import java.util.*;

class Solution {
    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        
        HashMap<Character, Integer> keys = new HashMap<>();
        for(String key : keymap) {
            for(int i = 0; i < key.length(); i++) {
                char k = key.charAt(i);
                if(keys.get(k) == null) {
                    keys.put(k, i + 1);
                } else {
                    if (keys.get(k) > i + 1) {
                        keys.put(k, i + 1);
                    }
                }
            }
        }
        
        for(String target : targets) {
            int result = 0;
            boolean success = true;
            for(int i = 0; i < target.length(); i++) {
                if (keys.get(target.charAt(i)) != null) {
                    result += keys.get(target.charAt(i));
                } else {
                    success = false;
                    break;
                }
            }
            
            if(!success) {
                answer.add(-1);
            } else {
                answer.add(result);
            }
        }
        
        return answer;
    }
}