import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        LinkedHashMap<Integer, Integer> hashMap = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!hashMap.containsKey(temp)) {
                hashMap.put(temp, 1);
                continue;
            }

            hashMap.put(temp, hashMap.get(temp) + 1);
        }

        List<Integer> list = new ArrayList<>(hashMap.keySet());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(hashMap.get(o2), hashMap.get(o1));
            }
        });

        for (int i : list) {
            for (int j = 0; j < hashMap.get(i); j++) {
                System.out.print(i + " ");
            }
        }
    }

}