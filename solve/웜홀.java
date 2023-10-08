import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 웜홀 {
    //https://www.acmicpc.net/problem/1865
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n + 1][n + 1];

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                if(arr[x][y] == 0) {
                    arr[x][y] = cost;
                    arr[y][x] = cost;
                }else {
                    arr[x][y] = Math.min(cost, arr[x][y]);
                    arr[y][x] = arr[x][y];
                }
            }

            for (int j = 0; j < w; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                arr[x][y] = -1 * cost;
                arr[y][x] = -1 * cost;
            }
        }
    }
}
