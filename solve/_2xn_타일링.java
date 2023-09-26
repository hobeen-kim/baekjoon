import java.util.Scanner;
import java.util.*;

public class _2xn_타일링 {

    //https://www.acmicpc.net/problem/11726

    public static void main(String[] args) {
        //1, 2 를 사용해서 n 을 만드는 방법
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        int[] dp = new int[tc + 1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= tc; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
            if(dp[i - 2] / 10007 > 1 && dp[i - 1] / 10007 > 1) {
                dp[i] %= 10007;
                dp[i - 1] %= 10007;
            }
        }

        System.out.println(dp[tc] % 10007);
    }
}
