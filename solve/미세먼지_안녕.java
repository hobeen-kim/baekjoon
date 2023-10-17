import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class 미세먼지_안녕 {
    //https://www.acmicpc.net/problem/17144
    static int r;
    static int c;
    static int[][] arr;
    static int[][] diffusion;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int top;
    static int bottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = parseInt(st.nextToken());
        c = parseInt(st.nextToken());
        int t = parseInt(st.nextToken());

        arr = new int[r][c];
        diffusion = new int[r][c];

        for (int i = 0; i < r; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < c; j++) {
                arr[i][j] = parseInt(st.nextToken());
                if(arr[i][j] == -1) {
                    arr[i][j] = 1001;
                    if(top == 0) top = i;
                    else bottom = i;
                }
            }
        }

        for (int i = 0; i < t; i++) {
            //먼지 확산
            diffusion();

            //위쪽 밀기
            pushTop();

            //아래쪽 밀기
            pushBottom();
        }

        int result = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result += arr[i][j];
            }
        }

        System.out.println(result - 2002);
    }

    static void diffusion() {

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(arr[i][j] > 0 && arr[i][j] <= 1000) {

                    int divide = arr[i][j] / 5;

                    for (int k = 0; k < 4; k++) {
                        if(valid(i + dx[k], j + dy[k])) {
                            diffusion[i + dx[k]][j + dy[k]] -= divide;
                            arr[i][j] -= divide;
                        }
                    }
                }

            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] -= diffusion[i][j];
                diffusion[i][j] = 0;
            }
        }
    }

    static void pushTop() {
        for (int i = top - 1; i > 0; i--) {
            arr[i][0] = arr[i - 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            arr[0][i] = arr[0][i + 1];
        }
        for (int i = 0; i < top; i++) {
            arr[i][c - 1] = arr[i + 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            arr[top][i] = arr[top][i - 1];
        }
        arr[top][1] = 0;
    }

    static void pushBottom() {
        for (int i = bottom + 1; i < r - 1; i++) {
            arr[i][0] = arr[i + 1][0];
        }
        for (int i = 0; i < c - 1; i++) {
            arr[r - 1][i] = arr[r - 1][i + 1];
        }
        for (int i = r - 1; i > bottom; i--) {
            arr[i][c - 1] = arr[i - 1][c - 1];
        }
        for (int i = c - 1; i > 1; i--) {
            arr[bottom][i] = arr[bottom][i - 1];
        }

        arr[bottom][1] = 0;
    }



    static boolean valid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c && arr[x][y] != 1001;
    }

}
