import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            // 숫자 빈도 계산
            if (!count.containsKey(num)) {
                count.put(num, 1);
            } else {
                count.put(num, count.get(num) + 1);
            }

            if (num > max) {
                max = num;
            }

            if (num < min) {
                min = num;
            }

            arr[i] = num;
        }

        arr = Arrays.stream(arr).sorted().toArray();

        // 1. 산술 평균
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        System.out.println((int) Math.round(sum / n));

        // 2. 중앙값
        System.out.println(arr[n / 2]);

        // 3. 최빈값
        Set<Integer> keySet = count.keySet();
        List<Integer> list = new ArrayList<>(keySet);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return count.get(o1) - count.get(o2);
            }
        });

        if (n == 1) {
            System.out.println(list.get(0));
        } else {
            int most = 0;
            List<Integer> mostList = new ArrayList<>();
            for (int number : list) {
                if (count.get(number) > most) {
                    most = count.get(number);
                    mostList.clear();
                    mostList.add(number);
                } else if (count.get(number) == most) {
                    mostList.add(number);
                }
            }

            Collections.sort(mostList);
            if (mostList.size() == 1) {
                System.out.println(mostList.get(0));
            } else {
                System.out.println(mostList.get(1));
            }
        }

        // 4. 범위
        System.out.println(max - min);
    }
}