import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> trees = new HashMap<>();

        String tree;
        int total = 0;
        while ((tree = br.readLine()) != null && (!tree.isEmpty())) {
            if (!trees.containsKey(tree)) {
                trees.put(tree, 1D);
            } else {
                trees.put(tree, trees.get(tree) + 1);
            }
            total += 1;
        }

        List<String> keyList = new ArrayList<>(trees.keySet());
        Collections.sort(keyList);
        for (String key : keyList) {
            System.out.printf("%s %.4f\n", key, (trees.get(key) / total) * 100);
        }
    }
}