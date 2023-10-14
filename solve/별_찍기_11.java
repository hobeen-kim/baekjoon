import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 별_찍기_11 {
    //https://www.acmicpc.net/problem/2448
    static char[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = 5 * (n / 3) + n / 3 - 1;

        arr = new char[n][m];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], ' ');
        }

        int center = m / 2;

        recursive(0, center, n);

        StringBuilder sb = new StringBuilder();

        for (char[] chars : arr) {
            sb.append(chars).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private static void recursive(int i, int j, int depth) {
        if(depth == 3) {
            draw(i, j);
            return;
        }

        int m = 5 * (depth / 3) + depth / 3 - 1;
        int half = m / 2 / 2 + 1;

        recursive(i, j, depth / 2);
        recursive(i + depth / 2, j - half, depth / 2);
        recursive(i + depth / 2, j + half, depth / 2);
    }

    private static void draw(int i, int j) {
        arr[i][j] = '*';
        arr[i + 1][j - 1] = arr[i + 1][j + 1] = '*';

        for (int k = -2; k < 3; k++) {
            arr[i + 2][j + k] = '*';
        }
    }


}
