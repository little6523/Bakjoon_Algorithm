import java.util.*;
import java.io.*;

class Main {

    static int[][][] tomatoes;
    static Queue<Position> queue = new LinkedList<>();
    static int m, n, h;
    static int day;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        tomatoes = new int[h][n][m];

        int value;
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < m; x++) {
                    value = Integer.parseInt(st.nextToken());
                    tomatoes[z][y][x] = value;
                    if (value == 1) {
                        queue.offer(new Position(x, y, z, 0));
                    }
                }
            }
        }

        bfs();
    }

    static void bfs() {

        while (!queue.isEmpty()) {
            Position position = queue.poll();
            int x = position.x;
            int y = position.y;
            int z = position.z;
            day = position.day;

            if (x < 0 || x >= m || y < 0 || y >= n || z < 0 || z >= h) {
                continue;
            }

            if (day > 0 && (tomatoes[z][y][x] == 1 || tomatoes[z][y][x] == -1)) {
                continue;
            }

            tomatoes[z][y][x] = 1;

            queue.offer(new Position(x + 1, y, z, day + 1));
            queue.offer(new Position(x - 1, y, z, day + 1));
            queue.offer(new Position(x, y + 1, z, day + 1));
            queue.offer(new Position(x, y - 1, z, day + 1));
            queue.offer(new Position(x, y, z + 1, day + 1));
            queue.offer(new Position(x, y, z - 1, day + 1));
        }

        if (check()) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }
    }

    static boolean check() {
        for (int z = 0; z < h; z++) {
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < m; x++) {
                    if (tomatoes[z][y][x] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

class Position {
    int x;
    int y;
    int z;
    int day;

    public Position(int x, int y, int z, int day) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.day = day;
    }
}