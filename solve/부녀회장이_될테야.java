import java.util.Scanner;

public class 부녀회장이_될테야 {
    //https://www.acmicpc.net/problem/2775

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[] dp = new int[n + 1];

            for(int j = 1; j <= n; j++) {
                dp[j] = j;
            }

            for(int floor = 1; floor <= k; floor++){
                for(int room = 1; room <= n; room++){
                    dp[room] = dp[room] + dp[room - 1];
                }
            }

            System.out.println(dp[n]);
        }
    }
}
