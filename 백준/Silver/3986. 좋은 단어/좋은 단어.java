import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// A와 B가 짝수개씩 있어야 가능

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        String ab;
        char ch;
        for (int i = 0; i < n; i++) {
            ab = br.readLine();

            if (ab.length() % 2 == 1) {
                continue;
            }

            stack.push(ab.charAt(0));
            for (int j = 1; j < ab.length(); j++) {
                ch = ab.charAt(j);
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();
                    continue;
                }
                stack.push(ch);
            }

            if (!stack.isEmpty()) {
                stack.clear();
                continue;
            }

            answer++;
        }
        System.out.println(answer);
    }
}