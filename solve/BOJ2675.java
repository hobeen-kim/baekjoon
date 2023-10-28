import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            String[] arr = st.nextToken().split("");

            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < arr.length; j++) {
                sb.append(arr[j].repeat(n));
            }

            System.out.println(sb);
        }
    }
}
