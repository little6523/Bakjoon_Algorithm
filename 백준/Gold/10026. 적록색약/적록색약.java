import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int n;
    static char[][] map;
    static boolean[][] visited;
    static boolean redGreenBlindness = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        String temp;
        for (int i = 0; i < n; i++) {
            temp = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j);
            }
        }

        int answer = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dfs(j, k, map[j][k])) {
                        answer++;
                    }
                }
            }
            System.out.print(answer + " ");
            answer = 0;

            visited = new boolean[n][n];
            redGreenBlindness = true;
        }
    }

    static boolean dfs (int x, int y, char ch) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (!redGreenBlindness) {
            if (map[x][y] != ch) {
                return false;
            }
        } else {
            if ((ch == 'R' || ch == 'G') && map[x][y] == 'B') {
                return false;
            }

            else if ((ch == 'B') && (map[x][y] == 'R' || map[x][y] == 'G')) {
                return false;
            }
        }

        visited[x][y] = true;

        dfs(x - 1, y, ch);
        dfs(x, y + 1, ch);
        dfs(x + 1, y, ch);
        dfs(x, y - 1, ch);

        return true;
    }
}