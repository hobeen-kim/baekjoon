import java.util.Scanner;

public class _1_2_3_더하기 {
    //https://www.acmicpc.net/problem/9095

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int n = sc.nextInt();

            int[] dp = new int[n + 1];

            //dp[n] = 1, 2, 3 을 이용하여 n 을 만드는 경우의 수
            if(n == 1) {
                System.out.println(1);
                continue;
            }
            if(n == 2) {
                System.out.println(2);
                continue;
            }
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;

            for(int j = 3; j <= n; j++) {

                dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
            }

            System.out.println(dp[n]);
        }
    }

}
