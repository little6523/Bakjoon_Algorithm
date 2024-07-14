import java.util.*;
import java.io.*;
import java.util.Queue;

class Main {

    static char[][] map;
    static Queue<int[]> person = new LinkedList<>();
    static Queue<int[]> fire = new LinkedList<>();
    static int[] xDirection = {-1, 0, 1, 0};
    static int[] yDirection = {0, 1, 0, -1};
    static int w, h;
    static int time = 0;
    static boolean isPossible = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];

            String temp;
            for (int i = 0; i < h; i++) {
                temp = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = temp.charAt(j);
                    if (temp.charAt(j) == '@') {
                        person.offer(new int[]{i, j});
                    }

                    if (temp.charAt(j) == '*') {
                        fire.offer(new int[]{i, j});
                    }
                }
            }

            while (true) {

                bfs();

                if (isPossible) {
                    System.out.println(time + 1);
                    time = 0;
                    isPossible = false;
                    person.clear();
                    fire.clear();
                    break;
                }

                else {
                    if (person.isEmpty()) {
                        System.out.println("IMPOSSIBLE");
                        time = 0;
                        fire.clear();
                        break;
                    }
                }

                time++;
            }
        }
    }

    static void bfs() {

        int size = fire.size();

        for (int i = 0; i < size; i++) {
            int[] newFire = fire.poll();

            for (int j = 0; j < 4; j++) {
                int nx = newFire[0] + xDirection[j];
                int ny = newFire[1] + yDirection[j];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == '*' || map[nx][ny] == '#') {
                    continue;
                }

                map[nx][ny] = '*';
                fire.offer(new int[]{nx, ny});
            }
        }

        size = person.size();
        for (int i = 0; i < size; i++) {
            int[] newPerson = person.poll();

            if (newPerson[0] == 0 || newPerson[0] == h - 1 || newPerson[1] == 0 || newPerson[1] == w - 1) {
                isPossible = true;
                return;
            }

            for (int j = 0; j < 4; j++) {
                int nx = newPerson[0] + xDirection[j];
                int ny = newPerson[1] + yDirection[j];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (map[nx][ny] == '*' || map[nx][ny] == '#' || map[nx][ny] == '@') {
                    continue;
                }

                if (nx == 0 || nx == h - 1 || ny == 0 || ny == w - 1) {
                    isPossible = true;
                    time++;
                    return;
                }

                map[nx][ny] = '@';
                person.offer(new int[]{nx, ny});
            }
        }
    }
}