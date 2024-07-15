import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};
    static int total = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[2][n][m];

        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }

        queue.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        bfs();

        System.out.println(total);
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dist = now[2];
            int destroy = now[3];

            if (x == n - 1 && y == m - 1) {
                total = dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + xDirection[i];
                int ny = y + yDirection[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 0 && !visited[destroy][nx][ny]) {
                    visited[destroy][nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1, destroy});
                } else {
                    if (destroy == 0 && !visited[destroy + 1][nx][ny]) {
                        visited[destroy + 1][nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1, destroy + 1});
                    }
                }
            }
        }
    }
}