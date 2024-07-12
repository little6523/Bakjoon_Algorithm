import java.util.*;
import java.io.*;

class Main {

    static Queue<Position> queue = new LinkedList<>();
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};
    static int[][] map;
    static public int n, m;
    static int[][] wall = {{0, 0}, {0, 1}, {0, 2}};
    static List<Position> virus = new ArrayList<>();
    static int safe = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (map[a][b] == 2) {
                    virus.add(new Position(a, b));
                }
            }
        }

        for (int i = 0; i < n * m; i++) {
            for (int j = 0; j < n * m; j++) {
                for (int k = 0; k < n * m; k++) {

                    bfs();
                    queue.clear();

                    wall[2][1]++;

                    if (wall[2][1] == m) {
                        wall[2][1] = 0;
                        wall[2][0]++;
                    }

                    if (wall[2][0] == n) {
                        wall[2][0] = 0;
                        break;
                    }
                }
                wall[1][1]++;

                if (wall[1][1] == m) {
                    wall[1][1] = 0;
                    wall[1][0]++;
                }

                if (wall[1][0] == n) {
                    wall[1][0] = 0;
                    break;
                }
            }

            wall[0][1]++;

            if (wall[0][1] == m) {
                wall[0][1] = 0;
                wall[0][0]++;
            }
        }

        System.out.println(safe);
    }

    static void bfs() {

        if (map[wall[0][0]][wall[0][1]] != 0 ||
                map[wall[1][0]][wall[1][1]] != 0 ||
                map[wall[2][0]][wall[2][1]] != 0) {
            return;
        }

        if ((wall[0][0] == wall[1][0] && wall[0][1] == wall[1][1]) ||
                (wall[1][0] == wall[2][0] && wall[1][1] == wall[2][1]) ||
                (wall[2][0] == wall[0][0] && wall[2][1] == wall[0][1])) {
            return;
        }

        if ((wall[0][0] > wall[1][0]) || (wall[1][0] > wall[2][0])) {
            return;
        }

        if ((wall[0][0] == wall[1][0]) && (wall[0][1] > wall[1][1]) ||
                (wall[1][0] == wall[2][0]) && (wall[1][1] > wall[2][1])) {
            return;
        }

        for (int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));
        }

        int[][] newMap = new int[n][m];
        copy(newMap);

        newMap[wall[0][0]][wall[0][1]] = 1;
        newMap[wall[1][0]][wall[1][1]] = 1;
        newMap[wall[2][0]][wall[2][1]] = 1;

        int x, y, nx, ny;
        while (!queue.isEmpty()) {
            Position position = queue.poll();
            x = position.x;
            y = position.y;
//            System.out.println(x + " " + y);

            for (int i = 0; i < 4; i++) {
                nx = x + xDirection[i];
                ny = y + yDirection[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (newMap[nx][ny] == 1 || newMap[nx][ny] == 2) {
                    continue;
                }

                newMap[nx][ny] = 2;
                queue.add(new Position(nx, ny));
            }
        }

        check(newMap);

//        System.out.println(wall[0][0] + " " + wall[0][1] + " " +
//                wall[1][0] + " " + wall[1][1] + " " + wall[2][0] + " " + wall[2][1] + " " + safe);

//        System.out.println(Arrays.deepToString(map));
    }

    static void check(int[][] map) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    temp++;
                }
            }
        }
        if (safe < temp) {
            safe = temp;
        }
    }

    static void copy(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = map[i][j];
            }
        }
    }
}

class Position {

    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}