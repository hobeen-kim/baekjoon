import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] up = new int[n + 1];
        int[] down = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());

            // 0 ~ i-1 까지 숫자를 비교했을 때 dp[i] 가 더 크면 up[i] = max up[j] + 1, up[i]
            for (int j = 0; j < i; j++) {
                if(dp[i] > dp[j]) {
                    up[i] = Math.max(up[j] + 1, up[i]);
                }
            }

            for (int j = 0; j < i; j++) {
                if (dp[i] < dp[j]) {
                    down[i] = Math.max(down[j] + 1, down[i]);
                    down[i] = Math.max(up[j] + 1, down[i]);
                }
            }

            // 0 ~ i-1 까지 숫자를 비교했을 때 dp[i] 가 더 작으면 down[i] = max down[j] + 1, down[i], up[j] + 1
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {

            max = Math.max(max, up[i]);
            max = Math.max(max, down[i]);
        }

        System.out.println(max);
    }
}
