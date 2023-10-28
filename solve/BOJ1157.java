import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split("");

        String max = "?";
        int maxValue = 0;

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : arr) {
            map.merge(s.toUpperCase(), 1, Integer::sum);
        }

        for (String s : map.keySet()) {
            if(maxValue < map.get(s)) {
                max = s;
                maxValue = map.get(s);
            } else if(maxValue == map.get(s)) {
                max = "?";
            }
        }

        System.out.println(max);
    }


}
