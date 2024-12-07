import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ1018 {

    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] bArr = new int[n][m];
        int[][] wArr = new int[n][m];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {

                String str = st.nextToken();

                if((i + j) % 2 == 0) {
                    if(str.equals("W")) {
                        modifyScore(i, j, bArr);
                    } else {
                        modifyScore(i, j, wArr);
                    }
                } else {
                    if(str.equals("B")) {
                        modifyScore(i, j, wArr);
                    } else {
                        modifyScore(i, j, bArr);
                    }
                }
            }
        }
    }

    public static void modifyScore(int i, int j, int[][] arr) {
        //스캔 범위는 0 ~ n-8 / 0 ~ m-8

    }
}