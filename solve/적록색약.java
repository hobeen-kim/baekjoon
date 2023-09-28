import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 적록색약 {
    //https://www.acmicpc.net/problem/10026
    static int n;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        char[][] normalChar = new char[n][n];
        char[][] colorChar = new char[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] normalArr = str.toCharArray();
            char[] colorArr = str.toCharArray();

            for (int j = 0; j < n; j++) {
                if(colorArr[j] == 'G') {
                    colorArr[j] = 'R';
                }
            }

            normalChar[i] = normalArr;
            colorChar[i] = colorArr;
        }

        int normal = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(normalChar[i][j] != 0) {
                    divide(normalChar, i, j);
                    normal++;
                }
            }
        }

        int color = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(colorChar[i][j] != 0) {
                    divide(colorChar, i, j);
                    color++;
                }
            }
        }

        System.out.print(normal);
        System.out.print(" ");
        System.out.print(color);
    }

    static void divide(char[][] arr, int i, int j) {
        char c = arr[i][j];
        arr[i][j] = 0;

        if(isValid(i - 1, j)) {
            if(arr[i - 1][j] == c) {
                divide(arr, i - 1, j);
            }
        }
        if(isValid(i + 1, j)) {
            if(arr[i + 1][j] == c) {
                divide(arr, i + 1, j);
            }
        }
        if(isValid(i, j - 1)) {
            if(arr[i][j - 1] == c) {
                divide(arr, i, j - 1);
            }
        }
        if(isValid(i, j + 1)) {
            if(arr[i][j + 1] == c) {
                divide(arr, i, j + 1);
            }
        }
    }

    static boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }
}
