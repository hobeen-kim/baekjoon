import java.util.Scanner;

public class _2xn_타일링_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {

            dp[i] = dp[i - 2] * 2 + dp[i - 1];

            if(dp[i] >= 10007) {
                dp[i] %= 10007;
                dp[i - 1] %= 10007;
            }
        }

        System.out.println(dp[n]);
    }
}
