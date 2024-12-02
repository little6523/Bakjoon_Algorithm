import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int[] video_time = stringToTime(video_len);
        int[] pos_time = stringToTime(pos);
        int[] op_start_time = stringToTime(op_start);
        int[] op_end_time = stringToTime(op_end);
        
        for (String command : commands) {
            if (compareTime(pos_time, op_start_time, op_end_time)) {
                pos_time = new int[] {op_end_time[0], op_end_time[1]};
            }
            
            if (command.equals("prev")) {
                if (pos_time[0] == 0 && pos_time[1] < 10) {
                    pos_time[1] = 0;
                } else {
                    pos_time[1] -= 10;
                }
            }
            
            if (command.equals("next")) {
                if (pos_time[0] == video_time[0] && pos_time[1] > 50) {
                    pos_time[1] = video_time[1];
                } else {
                    pos_time[1] += 10;
                }
            }
            
            if (pos_time[1] < 0 && pos_time[0] > 0) {
                pos_time[1] += 60;
                pos_time[0] -= 1;
            }
            
            if (pos_time[1] > 59 && pos_time[0] < video_time[0]) {
                pos_time[0] += 1;
                pos_time[1] -= 60;
            }
            
            if (pos_time[0] < 0) {
                pos_time[0] = 0;
            }
            
            if (pos_time[0] > video_time[0]) {
                pos_time[0] = video_time[0];
            }
            
            if (pos_time[0] == 0 && pos_time[1] < 0) {
                pos_time[1] = 0;
            }
            
            if (pos_time[0] == video_time[0] && pos_time[1] > video_time[1]) {
                pos_time[1] = video_time[1];
            }
            
            if (compareTime(pos_time, op_start_time, op_end_time)) {
                pos_time = new int[] {op_end_time[0], op_end_time[1]};
                System.out.println(pos_time[0] + " " + pos_time[1]);
            }
            
            System.out.println(pos_time[0] + " " + pos_time[1]);
        }
        
        answer = intToString(pos_time);
        
        return answer;
    }
    
    public int[] stringToTime(String str) {
        StringTokenizer st = new StringTokenizer(str);
        return new int[] { Integer.parseInt(st.nextToken(":")), Integer.parseInt(st.nextToken()) };
    }
    
    public boolean compareTime(int[] pos, int[] start, int[] end) {
        if (pos[0] < start[0]) {
            return false;
        }
        
        if (pos[0] == start[0]) {
            if (pos[1] < start[1]) {
                return false;
            }
        }
        
        if (pos[0] == end[0]) {
            if (pos[1] > end[1]) {
                return false;
            }
        }
        
        if (pos[0] > end[0]) {
            return false;
        }
        
        return true;
    }
    
    public String intToString(int[] pos) {
        String answer = "";
        
        if (pos[0] >= 0 && pos[0] <= 9) {
            answer += "0";
        } 
        
        answer += pos[0] + ":";
        
        if (pos[1] >= 0 && pos[1] <= 9) {
            answer += "0";
        }
        
        answer += pos[1];
        
        return answer;
    }
}