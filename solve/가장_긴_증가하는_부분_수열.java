import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장_긴_증가하는_부분_수열 {
    //https://www.acmicpc.net/problem/11053
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] arr = new int[n + 1];
        arr[0] = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {

            int cur = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= i; j++) {
                if(arr[i - j] < cur) dp[i] = Math.max(dp[i - j] + 1, dp[i]);
            }

            arr[i] = cur;
        }

        int max = 0;

        for(int i : dp) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
