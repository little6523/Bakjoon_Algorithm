import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int sum = 0, max = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        binarySearch(arr, m, max, sum);
        System.out.println(answer);
    }

    public static void binarySearch(int[] arr, int m, int start, int end) {
        while (start <= end) {
            int sum = 0, count = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < arr.length; i++) {
                if (sum + arr[i] <= mid) {
                    sum += arr[i];
                } else {
                    count++;
                    sum = arr[i];
                }
            }

            count++;

            if (count > m) {
                start = mid + 1;
            }

            if (count <= m) {
                end = mid - 1;
                if (answer > mid) {
                    answer = mid;
                }
            }

        }
    }
}