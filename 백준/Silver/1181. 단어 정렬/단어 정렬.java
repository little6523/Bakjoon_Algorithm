import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(br.readLine());
        }

        HashMap<Integer, List<String>> words = new HashMap<>();
        for (String word : hashSet) {
            if (!words.containsKey(word.length())) {
                List<String> list = new ArrayList<>();
                list.add(word);
                words.put(word.length(), list);
                continue;
            }

            words.get(word.length()).add(word);
        }

        List<Integer> keys = new ArrayList<>(words.keySet());
        Collections.sort(keys);

        List<String> result = new ArrayList<>();
        for (int i : keys) {
            result = words.get(i);
            Collections.sort(result);
            for (String str : result) {
                System.out.println(str);
            }
        }
    }
}