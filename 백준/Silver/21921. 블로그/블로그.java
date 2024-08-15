import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int start = 0, sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < x; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
        }

        int max = sum;

        int count = 1;
        for (int i = x; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            sum += num;
            sum -= arr[start];
            start++;

            if (sum > max) {
                max = sum;
                count = 1;
            } else if (sum == max) {
                count++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }
    }
}