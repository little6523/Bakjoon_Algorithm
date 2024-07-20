import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int s = 0, l = 0;
        while (s < n) {
            s = l * (1 + l) / 2;
            l++;
        }

        l--;
        s -= l;

        int numerator = 0, denominator = 0;

        if (l % 2 == 0) {

            numerator = 1;
            denominator = l;

            for (int i = 1; i < n - s; i++) {
                numerator += 1;
                denominator -= 1;
            }
        }

        else if (l % 2 == 1) {

            numerator = l;
            denominator = 1;

            for (int i = 1; i < n - s; i++) {
                numerator -= 1;
                denominator += 1;
            }
        }
        System.out.println(numerator + "/" + denominator);
    }
}