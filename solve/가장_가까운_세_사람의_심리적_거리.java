import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 가장_가까운_세_사람의_심리적_거리 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tc; i++) {
            int people = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < people; j++) {
                map.merge(st.nextToken(), 1, Integer::sum);
            }

            ArrayList<String> arr = new ArrayList<>();

            boolean hasOverThree = false;

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                int j = entry.getValue();
                if(j > 2) hasOverThree = true;

                if(hasOverThree) break;

                for (int k = 0; k < j; k++) {
                    arr.add(entry.getKey());
                }
            }

            int min = 9999;
            for (int j = 0; j < arr.size() - 2; j++) {
                for (int k = j + 1; k < arr.size() - 1; k++) {
                    for (int l = k + 1; l < arr.size(); l++) {
                        int temp = check(arr.get(j), arr.get(k)) + check(arr.get(k), arr.get(l)) + check(arr.get(l), arr.get(j));
                        min = Math.min(temp, min);
                    }
                }
            }

            if(hasOverThree) {
                sb.append(0).append('\n');
            }else {
                sb.append(min).append('\n');
            }

        }

        System.out.println(sb);

    }

    static int check(String mbti1, String mbti2) {
        char[] char1 = mbti1.toCharArray();
        char[] char2 = mbti2.toCharArray();

        int result = 0;

        for (int i = 0; i < 4; i++) {
            if(char1[i] != char2[i]) {
                result++;
            }
        }

        return result;
    }
}
