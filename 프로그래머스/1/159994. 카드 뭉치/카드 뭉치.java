class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        
        int idx1 = 0, idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            if (!cards1[idx1].equals(goal[i]) && !cards2[idx2].equals(goal[i])) {
                answer = "No";
                break;
            }
            
            if (idx1 < cards1.length - 1 && cards1[idx1].equals(goal[i])) {
                idx1++;
            }
            
            if (idx2 < cards2.length - 1 && cards2[idx2].equals(goal[i])) {
                idx2++;
            }
        }
        
        return answer;
    }
}