import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        char[] data = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            data[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(data);
        dfs(l, c, "", data, 0);
    }

    static void dfs(int l, int c, String str, char[] data, int index) {
        if (str.length() == l && isValid(str)) {
            System.out.println(str);
            return;
        }

        for (int i = index; i < c; i++) {
            str += data[i];
            dfs(l, c, str, data, i + 1);
            str = str.substring(0, str.length() - 1);
        }
    }

    static boolean isValid(String str) {
        int consonant = 0, vowel = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                vowel++;
            } else {
                consonant++;
            }
        }
        return consonant >= 2 && vowel >= 1;
    }
}