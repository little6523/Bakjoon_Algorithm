import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long numerator, denominator;
        StringTokenizer st;
        for (int i = 0; i < T; i ++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            numerator = 1;
            denominator = 1;

            if (n > m / 2) {
                n = m - n;
            }

            for (int j = m; j > m - n; j--) {
                numerator *= j;
            }

            for (int j = n; j > 0; j--) {
                denominator *= j;
            }

            System.out.println(numerator / denominator);
        }
    }
}