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
        Queue<Integer> queue = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int sum = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (queue.size() < k) {
                sum += num;
                queue.offer(num);

                if (queue.size() == k) {
                    if (sum > max) {
                        max = sum;
                    }
                }
                continue;
            }

            if (queue.size() == k) {
                sum += num;
                queue.offer(num);
                sum -= queue.poll();

                if (sum > max) {
                    max = sum;
                }
            }
        }

        System.out.println(max);
    }
}