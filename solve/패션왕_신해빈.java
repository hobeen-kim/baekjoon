import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 패션왕_신해빈 {
    //https://www.acmicpc.net/problem/9375
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < n; j++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                st.nextToken();

                map.merge(st.nextToken(), 1, Integer::sum);
            }

            int count = 1;

            for(Map.Entry<String, Integer> entry : map.entrySet()) {
                count *= entry.getValue() + 1;
            }

            System.out.println(count - 1);


        }
    }
}
