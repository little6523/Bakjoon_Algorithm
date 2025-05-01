import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}