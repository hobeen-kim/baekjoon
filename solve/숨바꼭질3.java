import java.util.Arrays;
import java.util.Scanner;

public class 숨바꼭질3 {
    //https://www.acmicpc.net/problem/13549
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] dp = new int[100001];

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            dp[i] = n - i;
        }

        dp[n] = 0;

        for (int i = 1; i <= 100000; i++) {
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2]);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);

            int idx = i;

            while(true) {
                if(dp[idx - 1] > dp[idx] + 1) {
                    dp[idx - 1] = dp[idx] + 1;
                    idx--;
                } else {
                    break;
                }
            }
        }

        System.out.println(dp[k]);
    }
}
