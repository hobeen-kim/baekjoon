import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {

    //https://www.acmicpc.net/problem/7576

    static int n;
    static int m;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        Queue<Tomato> queue = new LinkedList<>();

            for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) queue.offer(new Tomato(i, j));
            }

        }

        while(!queue.isEmpty()) {

            Tomato cur = queue.poll();
            int day = arr[cur.n][cur.m];

            if(cur.validPlusN()) {
                if(arr[cur.n + 1][cur.m] == 0) {
                    arr[cur.n + 1][cur.m] = day + 1;
                    queue.offer(new Tomato(cur.n + 1, cur.m));
                }
            }
            if(cur.validMinusN()) {
                if(arr[cur.n - 1][cur.m] == 0) {
                    arr[cur.n - 1][cur.m] = day + 1;
                    queue.offer(new Tomato(cur.n - 1, cur.m));
                }
            }
            if(cur.validPlusM()) {
                if(arr[cur.n][cur.m + 1] == 0) {
                    arr[cur.n][cur.m + 1] = day + 1;
                    queue.offer(new Tomato(cur.n, cur.m + 1));
                }
            }
            if(cur.validMinusM()) {
                if(arr[cur.n][cur.m - 1] == 0) {
                    arr[cur.n][cur.m - 1] = day + 1;
                    queue.offer(new Tomato(cur.n, cur.m - 1));
                }
            }
        }

        int max = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, arr[i][j]);
                if(arr[i][j] == 0) {
                    hasZero = true;
                }
            }
        }

        if(hasZero) System.out.println(-1);
        else System.out.println(max - 1);
    }

    static boolean isValid(int row, int column) {
        return row >= 0 && row < n && column >= 0 && column < m;
    }

    static class Tomato {
        int n;
        int m;

        Tomato(int n, int m) {
            this.n = n;
            this.m = m;
        }

        boolean validPlusN(){
            return isValid(this.n + 1, this.m);
        }
        boolean validMinusN(){
            return isValid(this.n - 1, this.m);
        }
        boolean validPlusM(){
            return isValid(this.n, this.m + 1);
        }
        boolean validMinusM(){
            return isValid(this.n, this.m - 1);
        }
    }
}
