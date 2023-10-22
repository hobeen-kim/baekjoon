import java.util.Arrays;
import java.util.Scanner;

public class BOJ12851 {

    static int n;
    static int k;
    static int[] dp;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        dp = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);

        if(k <= n) {
            System.out.println(n - k);
            System.out.println(1);
        }else {
            for (int i = 0; i <= n; i++) {
                dp[i] = n - i;
            }

            for (int i = 1; i <= 100000; i++) {
                if(i % 2 == 0) {
                    dp[i] = Math.min(dp[i], dp[i / 2] + 1);
                }
                dp[i] = Math.min(dp[i], dp[i - 1] + 1);

                int idx = 1;

                while(true) {
                    if (i - idx >= 0 && dp[i] + idx < dp[i - idx]) {
                        dp[i - idx] = dp[i] + idx;
                        idx++;
                    }else {
                        break;
                    }
                }
            }

            int result = dp[k];
            int count = cal(k, result);

            System.out.println(result);
            System.out.println(count);
        }
    }

    static int cal(int cur, int result) {

        if(result == 0) return 1;

        int count = 0;

        if(cur - 1 >= 0 && dp[cur - 1] == result - 1) {
            count += cal(cur - 1, result - 1);
        }
        if(cur + 1 <= 100000 && dp[cur + 1] == result - 1) {
            count += cal(cur + 1, result - 1);
        }
        if(cur % 2 == 0 && dp[cur / 2] == result - 1) {
            count += cal(cur / 2, result - 1);
        }

        return count;
    }
}
