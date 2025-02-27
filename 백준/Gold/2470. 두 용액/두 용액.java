import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Long> datas = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            datas.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(datas);

        int left = 0, right = datas.size() - 1;
        long min = Long.MAX_VALUE;
        long[] answer = {0, 0};
        while (left < right) {
            long cal = datas.get(left) + datas.get(right);
            if (min > Math.abs(cal)) {
                min = Math.abs(cal);
                answer[0] = datas.get(left); answer[1] = datas.get(right);
            }

            if (cal == 0) break;

            if (cal < 0) {
                left++;
            }

            if (cal > 0) {
                right--;
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}