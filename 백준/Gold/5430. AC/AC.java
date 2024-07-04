import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String command;
        int n;
        List<Integer> arr;
        String numbers;
        long dCount;
        int pointer;
        StringTokenizer st;

        // 테스트 케이스 입력
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            // 명령 입력
            command = br.readLine().replaceAll("RR", "");

            // 숫자 개수 입력
            n = Integer.parseInt(br.readLine());

            // 숫자 배열 입력
            numbers = br.readLine().replaceFirst("\\[", "").replace("]", "");
            arr = new LinkedList<>();

            st = new StringTokenizer(numbers, ",");
            for (int j = 0; j < n; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            // 명령의 D개수가 숫자 개수보다 많으면 에러
            dCount = command.chars()
                    .filter(c -> c == 'D')
                    .count();

            if (dCount > arr.size()) {
                sb.append("error\n");
                continue;
            }

            pointer = 0;
            // 명령에 따른 배열 조작
            for (int j = 0; j < command.length(); j++) {

                // R이면 배열 뒤집기
                if (command.charAt(j) == 'R') {
                    if (pointer == 0) {
                        pointer = arr.size() - 1;
                    } else {
                        pointer = 0;
                    }

                } else {
                    // D이면 앞에서 원소 제거
                    arr.remove(pointer);
                    if (pointer == arr.size()) {
                        pointer -= 1;
                    }
                }
            }
            if (pointer == arr.size() - 1) {
                Collections.reverse(arr);
            }
            sb.append(arr.toString().replaceAll(" ", "") + "\n");
        }
        System.out.println(sb);
    }
}