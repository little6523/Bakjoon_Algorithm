import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static Queue<Pair> queue = new LinkedList<>();
    public static int n, m;
    public static int[][] conn, steps;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        conn = new int[n + 1][n + 1];
        steps = new int[n + 1][n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                steps[i][j] = m;
                steps[i][i] = 0;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            conn[a][b] = 1; conn[b][a] = 1;
            steps[a][b] = 1; steps[b][a] = 1;
        }
        
        bfs();

        Collections.sort(list);
        System.out.println(list.get(0));
    }

    public static void bfs() {

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            initQueue(queue, i);
            boolean[] visited = new boolean[n + 1];
            visited[i] = true;

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                int friend = pair.friend;
                int step = pair.step;

//                System.out.println(i+ " " + friend + " " + step);

                if (visited[friend]) continue;
                visited[friend] = true;

                if (step < steps[i][friend]) {
                    steps[i][friend] = step;
                }

                for (int j = 1; j < n + 1; j++) {
                    if (conn[friend][j] == 1 && !visited[j]) {
                        queue.offer(new Pair(j, step + 1));
                    }
                }
            }

            int sum = 0;
            for (int j = 1; j < n + 1; j++) {
                if (steps[i][j] > 0) {
                    sum += steps[i][j];
                }
            }

            if (sum < min) {
                min = sum;
                list.clear();
                list.add(i);
            }

            else if (sum == min) {
                list.add(i);
            }
        }
    }

    public static void initQueue(Queue<Pair> queue, int index) {
        for (int i = 1; i < n + 1; i++) {
            if (conn[index][i] == 1) {
                queue.offer(new Pair(i, 1));
            }
        }
    }

    public static class Pair {
        public int friend;
        public int step;

        public Pair(int friend, int step) {
            this.friend = friend;
            this.step = step;
        }
    }
}