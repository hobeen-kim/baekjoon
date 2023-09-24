import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 유기농_배추 {
    //https://www.acmicpc.net/problem/1012

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];

            for (int j = 0; j < k; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st2.nextToken());
                int y = Integer.parseInt(st2.nextToken());

                arr[y][x] = 1;
            }

            int count = 0;

            for(int a = 0; a < n; a++){
                for(int b = 0; b < m; b++){
                    if(arr[a][b] == 1) {
                        count++;
                        bfs(arr, a, b, n, m);
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void bfs(int[][] arr, int a, int b, int n, int m) {

        arr[a][b] = 0;

        if(a - 1 > -1) {
            if(arr[a - 1][b] == 1) {
                bfs(arr, a - 1, b, n, m);
            }
        }
        if(a + 1 < n) {
            if(arr[a + 1][b] == 1) {
                bfs(arr, a + 1, b, n, m);
            }
        }
        if(b - 1 > -1) {
            if(arr[a ][b - 1] == 1) {
                bfs(arr, a, b - 1, n, m);
            }
        }
        if(b + 1 < m) {
            if(arr[a ][b + 1] == 1) {
                bfs(arr, a, b + 1, n, m);
            }
        }

    }
}


