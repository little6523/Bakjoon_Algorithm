import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        for(int mat : mats) {
            for (int i = 0; i < park.length - mat + 1; i++) {
                for (int j = 0; j < park[i].length - mat + 1; j++) {
                    if (park[i][j].equals("-1")) {
                        
                        boolean success = true;
                        
                        for (int x = i; x < i + mat; x++) {
                            for (int y = j; y < j + mat; y++ ) {
                                if (!park[x][y].equals("-1")) {
                                    success = false;
                                    break;
                                }
                            }
                            if (success == false) {
                                break;
                            }
                        }
                        
                        if (success == true && answer < mat) {
                            answer = mat;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}