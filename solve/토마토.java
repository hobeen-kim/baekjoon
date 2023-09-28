import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    //https://www.acmicpc.net/problem/7569

    static int n;
    static int m;
    static int h;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[h][n][m];

        Queue<Tomato> queue = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(arr[i][j][k] == 1) queue.offer(new Tomato(i, j, k));
                }
            }
        }

        while(!queue.isEmpty()) {

            Tomato cur = queue.poll();
            int day = arr[cur.h][cur.n][cur.m];

            if(cur.validPlusH()) {
                if(arr[cur.h + 1][cur.n][cur.m] == 0) {
                    arr[cur.h + 1][cur.n][cur.m] = day + 1;
                    queue.offer(new Tomato(cur.h + 1, cur.n, cur.m));
                }
            }
            if(cur.validMinusH()) {
                if(arr[cur.h - 1][cur.n][cur.m] == 0) {
                    arr[cur.h - 1][cur.n][cur.m] = day + 1;
                    queue.offer(new Tomato(cur.h - 1, cur.n, cur.m));
                }
            }
            if(cur.validPlusN()) {
                if(arr[cur.h][cur.n + 1][cur.m] == 0) {
                    arr[cur.h][cur.n + 1][cur.m] = day + 1;
                    queue.offer(new Tomato(cur.h, cur.n  + 1, cur.m));
                }
            }
            if(cur.validMinusN()) {
                if(arr[cur.h][cur.n - 1][cur.m] == 0) {
                    arr[cur.h][cur.n - 1][cur.m] = day + 1;
                    queue.offer(new Tomato(cur.h, cur.n  - 1, cur.m));
                }
            }
            if(cur.validPlusM()) {
                if(arr[cur.h][cur.n][cur.m + 1] == 0) {
                    arr[cur.h][cur.n][cur.m + 1] = day + 1;
                    queue.offer(new Tomato(cur.h, cur.n, cur.m  + 1));
                }
            }
            if(cur.validMinusM()) {
                if(arr[cur.h][cur.n][cur.m - 1] == 0) {
                    arr[cur.h][cur.n][cur.m - 1] = day + 1;
                    queue.offer(new Tomato(cur.h, cur.n, cur.m - 1));
                }
            }
        }

        int max = 0;
        boolean hasZero = false;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    max = Math.max(max, arr[i][j][k]);
                    if(arr[i][j][k] == 0) {
                        hasZero = true;
                    }
                }
            }
        }

        if(hasZero) System.out.println(-1);
        else System.out.println(max - 1);
    }

    static boolean isValid(int height, int row, int column) {
        return row >= 0 && row < n && column >= 0 && column < m && height >= 0 && height < h;
    }

    static class Tomato {
        int h;
        int n;
        int m;

        Tomato(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }

        boolean validPlusN(){
            return isValid(this.h, this.n + 1, this.m);
        }
        boolean validMinusN(){
            return isValid(this.h, this.n - 1, this.m);
        }
        boolean validPlusM(){
            return isValid(this.h, this.n, this.m + 1);
        }
        boolean validMinusM(){
            return isValid(this.h, this.n, this.m - 1);
        }
        boolean validPlusH(){
            return isValid(this.h + 1, this.n, this.m);
        }
        boolean validMinusH(){
            return isValid(this.h - 1, this.n, this.m);
        }
    }

}
