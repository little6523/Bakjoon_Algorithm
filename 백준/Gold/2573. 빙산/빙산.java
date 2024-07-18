import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[][] map;
    static Queue<Integer> melting = new LinkedList<>();
    static List<int[]> ice = new ArrayList<>();
    static Queue<int[]> temp = new LinkedList<>();
    static boolean[][] visited;
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    ice.add(new int[]{i, j});
                }
            }
        }

        int count = 0, answer = 0;
        boolean isEnd = false;

        while (!ice.isEmpty()) {

            // 녹일 얼음의 높이 계산
            for (int[] pos : ice) {
                melt(pos[0], pos[1]);
            }

            // 얼음을 녹임
            for (int[] pos : ice) {
                if (!melting.isEmpty()) {
                    map[pos[0]][pos[1]] -= melting.poll();
                    if (map[pos[0]][pos[1]] < 0) map[pos[0]][pos[1]] = 0;
                }
            }

            answer++;
            checkIce();
//            icePrint();
//            System.out.println();

            copyIce();
            for (int[] pos : ice) {

                if (visited[pos[0]][pos[1]]) continue;

                if (bfs(pos[0], pos[1])) {
                    count++;
                }
                
                if (count < 2 && !temp.isEmpty()) continue;

                if (count == 2) {
                    isEnd = true;
                    break;
                }
            }

            if (isEnd) break;

            count = 0;

            melting.clear();
            visited = new boolean[n][m];
        }

        if (isEnd) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }

    }

    // 얼음 사르르 녹이는 메소드
    static void melt(int x, int y) {

        int nx, ny, count = 0;

        for (int i = 0; i < 4; i++) {
            nx = x + xDirection[i];
            ny = y + yDirection[i];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                continue;
            }

            if (map[nx][ny] == 0) {
                count++;
            }
        }

        melting.offer(count);
    }

    // 하나의 덩어리를 모두 방문하는 메소드
    static boolean bfs(int x, int y) {

        if (map[x][y] == 0) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        temp.poll();

        int nx, ny, dx, dy;
        int[] xy;
        while (!queue.isEmpty()) {

            xy = queue.poll();
            dx = xy[0];
            dy = xy[1];

            for (int i = 0; i < 4; i++) {
                nx = dx + xDirection[i];
                ny = dy + yDirection[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                visited[nx][ny] = true;
                temp.poll();
                queue.offer(new int[]{nx, ny});
            }
        }

        return true;
    }

    // 다 녹은 얼음 제거
    static void checkIce() {
        if (ice.isEmpty()) return;

        int x, y, i = 0;
        while (i < ice.size()) {
            x = ice.get(i)[0];
            y = ice.get(i)[1];

            if (map[x][y] == 0) {
                ice.remove(i);
                i--;
            }
            i++;
        }
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void icePrint() {
        for (int i = 0; i < ice.size(); i++) {
            System.out.print(Arrays.toString(ice.get(i)) + " ");
        }
    }

    static void copyIce() {
        temp.clear();
        for (int i = 0; i < ice.size(); i++) {
            temp.offer(ice.get(i));
        }
    }
}