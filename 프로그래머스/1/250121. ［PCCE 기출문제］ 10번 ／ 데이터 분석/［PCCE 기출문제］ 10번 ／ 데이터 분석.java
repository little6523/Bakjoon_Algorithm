import java.util.*;

class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        
        HashMap<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        int ext_idx = map.get(ext);
        int sort_idx = map.get(sort_by);
        
        for(int i = 0; i < data.length; i++) {
            if(data[i][ext_idx] < val_ext) {
                answer.add(data[i]);
            }
        }
        
        Collections.sort(answer, (o1, o2) -> o1[sort_idx] - o2[sort_idx]);
        
        return answer;
    }
}