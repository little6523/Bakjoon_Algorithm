import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[1] == b[1]) {
            return Integer.compare(a[0], b[0]); // 두 번째 요소 기준 정렬
        }
        return Integer.compare(a[1], b[1]); // 첫 번째 요소 기준 정렬
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] data = new int[2];
            data[0] = Integer.parseInt(st.nextToken());
            data[1] = Integer.parseInt(st.nextToken());
            pq.offer(data);
        }

        List<int[]> arr = new ArrayList<>();
        arr.add(pq.poll());

        while (!pq.isEmpty()) {
            int[] newD = pq.poll();
            int[] d = arr.get(arr.size() - 1);

            if (d[1] <= newD[0]) {
                arr.add(newD);
            }
        }

        System.out.println(arr.size());
    }
}