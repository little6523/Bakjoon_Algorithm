import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int numerator = 1, denominator = 1;
        int dir = 0;
        // dir => 0: 아래로 한 칸 또는 오른쪽을 한 칸 / 1: 왼쪽 아래로 내려가는 방향 / 2: 오른쪽 위로 올라가는 방향

        for (int i = 1; i < n; i++) {

            if (dir == 0) {
                if (numerator == 1) {
                    denominator += 1;
                    dir = 1;
                }

                else if (denominator == 1) {
                    numerator += 1;
                    dir = 2;
                }
            }

            else if (dir == 1) {
                numerator += 1;
                denominator -= 1;

                if (denominator == 1) {
                    dir = 0;
                }
            }

            else if (dir == 2) {
                numerator -= 1;
                denominator += 1;

                if (numerator == 1) {
                    dir = 0;
                }
            }
        }

        System.out.println(numerator + "/" + denominator);

    }
}