import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17070 {

    static int n;
    static int[][] arr;
    static int[][] answerR;
    static int[][] answerC;
    static int[][] answerD;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        answerR = new int[n][n];
        answerC = new int[n][n];
        answerD = new int[n][n];

        answerR[0][1] = 1;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (valid(i, j - 1) && arr[i][j] != 1) {
                    if(i != 0 || j != 1) answerR[i][j] = answerR[i][j - 1] + answerD[i][j - 1];
                }
                if(valid(i - 1, j) && arr[i][j] != 1) {
                    answerC[i][j] = answerC[i - 1][j] + answerD[i - 1][j];
                }
                if (valid(i - 1, j - 1) && arr[i][j] != 1 && dValid(i, j)) {
                    answerD[i][j] = answerR[i - 1][j - 1] + answerC[i - 1][j - 1] + answerD[i - 1][j - 1];
                }
            }
        }

        System.out.println(answerR[n - 1][n - 1] + answerC[n - 1][n - 1] + answerD[n - 1][n - 1]);
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean dValid(int x, int y) {
        return arr[x - 1][y] != 1 && arr[x][y - 1] != 1;
    }
}
