import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        int box = 1;
        int i = 0;
        
        while (true) {
            while (box <= order[i]) {
                stack.push(box++);
            }
            
            while (!stack.isEmpty() && stack.peek() == order[i]) {
                stack.pop();
                i++;
            }
        
            if (i == order.length || (!stack.isEmpty() && stack.peek() > order[i])) {
                break;
            }
        }
        
        answer = i;
        
        return answer;
    }
}