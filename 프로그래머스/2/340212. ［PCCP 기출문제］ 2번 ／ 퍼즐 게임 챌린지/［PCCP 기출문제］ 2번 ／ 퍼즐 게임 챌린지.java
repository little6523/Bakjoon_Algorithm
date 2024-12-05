import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        
        int left = 1;
        int right = max(diffs);
        
        while(left <= right) {
            int level = (left + right) / 2;
            long res = 0;
            
            for (int i = 0; i < diffs.length; i++) {
                if (diffs[i] <= level) {
                    res += times[i];
                } else {
                    res += (times[i] + times[i-1]) * (diffs[i] - level) + times[i];
                }
            }
            
            System.out.println(left + " " + level + " " + right + " " + res);
            
            if (limit >= res) {
                if (answer > level) {
                    answer = level;
                }
                right = level - 1;
            } else {
                left = level + 1;
            }
        }
        
        return answer;
    }
    
    public int max(int[] arr) {
        int result = Integer.MIN_VALUE;
        
        for (int num : arr) {
            if (result < num) {
                result = num;
            }
        }
        
        return result;
    }
}