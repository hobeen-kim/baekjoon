import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 삼각형 {
    //https://www.acmicpc.net/problem/1932
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= i; j++) {
                int num = Integer.parseInt(st.nextToken());

                int leftParent = j - 1;
                int rightParent = j;

                arr[i][j] = Math.max(arr[i - 1][leftParent], arr[i - 1][rightParent]) + num;
            }
        }

        int max = 0;

        for(int i : arr[n]) {
            max = Math.max(max, i);
        }

        System.out.println(max);
    }
}
