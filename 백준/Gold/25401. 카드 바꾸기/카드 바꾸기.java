import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> diffMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        int answer;

        // 1. 가장 많이 나온 숫자를 제외한 나머지 숫자를 가장 많이 나온 숫자로 바꾸는 경우
        int most = 0;
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int num : list) {
            if (map.get(num) > most) {
                most = map.get(num);
            }
        }

        answer = n - most;
//        System.out.println(answer);

        // 2. 등차수열 만드는 경우

        int min = n - 1;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n + 1; j++) {
                int diff = (arr[j] - arr[i]) / (j - i);
                int a0 = arr[i] - (i - 1) * diff;
//                System.out.println("초항: " + a0 + " 공차: " + diff);
                int[] copyArr = arr.clone();

                for (int k = 1; k < n + 1; k++) {
                    copyArr[k] = a0 + (k - 1) * diff;
                }

//                System.out.println(Arrays.toString(arr) + " " + Arrays.toString(copyArr));

                int check = differenceCheck(arr, copyArr, n);
                if (check < min) {
                    min = check;
                }
            }

            if (answer > min) {
                answer = min;
            }
        }

        System.out.println(answer);
    }

    public static int differenceCheck(int[] arr1, int[] arr2, int n) {

        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
            }
        }
        return count;
    }
}