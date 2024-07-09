import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int temp = 1;
        char ch;
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                temp *= 2;
            }

            else if (ch == '[') {
                stack.push(ch);
                temp *= 3;
            }

            else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }

                else if (str.charAt(i - 1) == '(') {
                    answer += temp;
                }
                temp /= 2;
                stack.pop();
            }

            else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }

                else if (str.charAt(i - 1) == '[') {
                    answer += temp;
                }
                temp /= 3;
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }
}
