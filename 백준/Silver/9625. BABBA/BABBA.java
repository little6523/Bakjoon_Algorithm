import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] ab = {1, 0};
        for (int i = 0; i < k; i++) {
            int a = ab[1];
            int b = ab[0] + ab[1];
            ab[0] = a; ab[1] = b;
        }
        System.out.println(ab[0] + " " + ab[1]);
    }
}