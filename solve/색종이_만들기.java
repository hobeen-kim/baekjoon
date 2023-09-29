import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 색종이_만들기 {
    //https://www.acmicpc.net/problem/2630
    static int blue = 0;
    static int white = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        check(arr, 0, 0, n, n);

        System.out.println(white);
        System.out.println(blue);
    }

    static void check(int[][] arr, int x1, int y1, int x2, int y2) {

        boolean hasWhite = false;
        boolean hasBlue = false;

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if(arr[i][j] == 1) hasBlue = true;
                else hasWhite = true;
            }
        }

        if(hasBlue && hasWhite) {
            int halfX = (x1 + x2) / 2;
            int halfY = (y1 + y2) / 2;

            check(arr, x1, y1, halfX, halfY);
            check(arr, x1, halfY, halfX, y2);
            check(arr, halfX, y1, x2, halfY);
            check(arr, halfX, halfY, x2, y2);
        } else if(hasBlue) {
            blue++;
        } else if (hasWhite) {
            white++;
        }
    }
}


