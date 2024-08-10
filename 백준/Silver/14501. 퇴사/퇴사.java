import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] days = new int[n + 1][2];
        int[] answer = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken()); // Ti
            days[i][1] = Integer.parseInt(st.nextToken()); // Pi
        }

        for (int i = 1; i < n + 1; i++) {
            if (i + days[i][0] > n + 1) continue;

            if (answer[i] == 0) {
                answer[i] = days[i][1];
            }

            for (int j = i + days[i][0]; j < n + 1; j++) {
                if (answer[j] < answer[i] + days[j][1]) {
                    if (j + days[j][0] > n + 1) continue;
                    answer[j] = answer[i] + days[j][1];
                }
            }
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (max < answer[i]) {
                max = answer[i];
            }
        }

        System.out.println(max);
    }
}