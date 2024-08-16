import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int answer = 0;
        char[] hp = br.readLine().toCharArray();
        for (int i = 0; i < n; i++) {
            if (hp[i] == 'H' && check(hp, i, n, k)) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean check(char[] hp, int index, int n, int k) {
        int start, end;
        if (index <= k) {
            start = 0;
        } else {
            start = index - k;
        }

        if (index >= n - k) {
            end = n - 1;
        } else {
            end = index + k;
        }

        for (int i = start; i <= end; i++) {
            if (hp[i] == 'P') {
                hp[i] = 'O';
                return true;
            }
        }
        return false;
    }
}