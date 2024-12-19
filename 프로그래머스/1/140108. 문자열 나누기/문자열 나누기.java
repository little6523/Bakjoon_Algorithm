class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int x_cnt = 0, not_cnt = 0;
        boolean cut = true;
        char x = s.charAt(0);
        for(int i = 0; i < s.length(); i++) {
            if (cut) {
                x = s.charAt(i);
            }
            
            cut = false;
            
            if (s.charAt(i) == x) {
                x_cnt++;
            } else {
                not_cnt++;
            }
            
            if (x_cnt == not_cnt) {
                answer++;
                cut = true;
            } else {
                if (i == s.length() - 1) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}