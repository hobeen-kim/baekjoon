import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 평범한_배낭 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] prevDp = new int[k + 1];
        int[] dp = new int[k + 1];


        for (int i = 1; i <= n; i++) {


            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st2.nextToken());
            int value = Integer.parseInt(st2.nextToken());

            for(int j = weight; j <= k; j++) {

                dp[j] = Math.max(prevDp[j], prevDp[j - weight] + value);
            }

            prevDp = Arrays.copyOf(dp, dp.length);
        }

        System.out.println(dp[k]);
    }

}
