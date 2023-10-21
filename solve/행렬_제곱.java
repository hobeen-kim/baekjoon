import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.*;
import static java.lang.Long.parseLong;

public class 행렬_제곱 {
    //https://www.acmicpc.net/problem/10830
    static int[][] a;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        long b = parseLong(st.nextToken());

        a = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                a[i][j] = parseInt(st.nextToken());
            }
        }

        int[][] calculate = calculate(b);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                calculate[i][j] %= 1000;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(calculate[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int[][] calculate(long b) {

        if(b == 1) {
            return a;
        }

        if(b == 2) {
            return pow(a, a);
        }

        if(b % 2 == 0) {
            int[][] divided = calculate(b / 2);

            return pow(divided, divided);
        } else {
            return pow(calculate(b - 1), a);
        }
    }

    static int[][] pow(int[][] arr1, int[][] arr2) {

        int[][] newA = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    newA[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newA[i][j] %= 1000;
            }
        }

        return newA;
    }
}
