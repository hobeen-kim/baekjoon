import java.util.Scanner;

public class 파도반_수열 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {

            int n = sc.nextInt();

            long[] dp = new long[n + 1];

            for (int j = 1; j <= n; j++) {
                if(j <= 3) {
                    dp[j] = 1;
                }else if(j <= 5) {
                    dp[j] = 2;
                }else {
                    dp[j] = dp[j - 1] + dp[j - 5];
                }
            }

            System.out.println(dp[n]);
        }

    }
}
