import java.util.*;
import java.io.*;

class Main {

    static int size;
    static boolean[][] visited;
    static int[] knight;
    static int[] goal;
    static int[] xDirection = {-2, -1, +1, +2, +2, +1, -1, -2};
    static int[] yDirection = {+1, +2, +2, +1, -1, -2, -2, -1};
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {

            size = Integer.parseInt(br.readLine());
            visited = new boolean[size][size];

            st = new StringTokenizer(br.readLine());
            knight = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            goal = new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())};

            bfs();
        }
    }

    static void bfs() {

        int x, y, nx, ny, move = 0;
        queue.offer(new Position(knight[0], knight[1], move));
        visited[knight[0]][knight[1]] = true;

        if (knight[0] == goal[0] && knight[1] == goal[1]) {
            System.out.println(move);
            return;
        }

        while (!queue.isEmpty()) {

            Position position = queue.poll();
            x = position.x;
            y = position.y;
            move = position.move;

            for (int i = 0; i < 8; i++) {
                nx = x + xDirection[i];
                ny = y + yDirection[i];

                if (nx == goal[0] && ny == goal[1]) {
                    System.out.println(move + 1);
                    queue.clear();
                    break;
                }

                if (nx < 0 || nx >= size || ny < 0 || ny >= size) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;

                queue.offer(new Position(nx, ny, move + 1));
            }
        }
    }
}

class Position {

    int x;
    int y;
    int move;

    public Position(int x, int y, int move) {
        this.x = x;
        this.y = y;
        this.move = move;
    }
}