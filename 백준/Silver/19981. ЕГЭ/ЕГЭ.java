import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong(); // 입력값 (10진수 정수)
        scanner.close();

        List<Integer> result = convertToNegativeBase2(x);

        System.out.println(result.size());

        for (int i = result.size() - 1; i > -1; i--) {
            System.out.print(result.get(i) + " ");
        }
        System.out.println();
    }

    public static List<Integer> convertToNegativeBase2(long x) {
        if (x == 0) return Arrays.asList(0);

        List<Integer> digits = new ArrayList<>();

        while (x != 0) {
            int remainder = (int) (x % -2);
            x /= -2;

            if (remainder < 0) {
                remainder += 2;
                x += 1;
            }

            digits.add(remainder);
        }

        Collections.reverse(digits);
        return digits;
    }
}