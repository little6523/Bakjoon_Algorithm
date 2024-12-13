class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        
        for (int sec : section) {
            if (sec == 0) continue;
            
            for (int i = 0; i < section.length; i++) {
                if (section[i] < sec + m) {
                    section[i] = 0;
                }
            }
            answer++;
        }
        
        return answer;
    }
}