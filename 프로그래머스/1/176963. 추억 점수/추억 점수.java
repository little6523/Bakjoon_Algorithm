class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int idx = 0;
        
        for (String[] p : photo) {
            int score = 0;
            for (String str : p) {
                for (int i = 0; i < name.length; i++) {
                    if (str.equals(name[i])) {
                        score += yearning[i];
                    }               
                }
            }
            answer[idx] = score;
            idx++;
        }
        
        return answer;
    }
}