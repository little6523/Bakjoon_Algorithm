import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int poll = 0, answer = 0;
        String polls = br.readLine();
        char ch1, ch2;

        for (int i = 0; i < polls.length(); i++) {

            ch1 = polls.charAt(i);

            if (ch1 == '(') {
                poll++;
                continue;
            }

            if (ch1 == ')') {
                poll--;
                ch2 = polls.charAt(i - 1);

                if (ch2 == '(') {
                    answer += poll;
                    continue;
                }

                if (ch2 == ')') {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }
}