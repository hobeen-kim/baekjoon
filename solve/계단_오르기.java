import java.util.Scanner;

public class 계단_오르기 {
    //https://www.acmicpc.net/problem/2579

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        if(n == 1) {
            System.out.println(arr[1]);
        } else {
            int[] oneStep = new int[n + 1];
            int[] twoStep = new int[n + 1];
            int[] dp = new int[n + 1];

            oneStep[1] = arr[1];
            twoStep[1] = arr[1];
            oneStep[2] = arr[2];
            twoStep[2] = arr[1] + arr[2];

            dp[1] = arr[1];
            dp[2] = arr[1] + arr[2];

            for(int i = 3; i <= n; i++) {
                oneStep[i] = Math.max(twoStep[i - 2] + arr[i], oneStep[i - 2] + arr[i]);
                twoStep[i] = oneStep[i - 1] + arr[i];
                dp[i] = Math.max(oneStep[i], twoStep[i]);
            }

            System.out.println(dp[n]);
        }


    }
}
