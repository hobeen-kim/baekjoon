import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쉬운_최단거리 {
    //https://www.acmicpc.net/problem/14940

    static int n;
    static int m;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    arr[i][j] = -1;
                } else if(num == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }

        Queue<Item> queue = new LinkedList<>();

        queue.offer(new Item(startX, startY));

        while(!queue.isEmpty()) {
            Item cur = queue.poll();

            if(valid(cur.x - 1, cur.y)) {
                if(arr[cur.x - 1][cur.y] == -1) {
                    arr[cur.x - 1][cur.y] = arr[cur.x][cur.y] + 1;
                    queue.offer(new Item(cur.x - 1, cur.y));
                }
            }
            if(valid(cur.x + 1, cur.y)) {
                if(arr[cur.x + 1][cur.y] == -1) {
                    arr[cur.x + 1][cur.y] = arr[cur.x][cur.y] + 1;
                    queue.offer(new Item(cur.x + 1, cur.y));
                }
            }
            if(valid(cur.x, cur.y - 1)) {
                if(arr[cur.x][cur.y - 1] == -1) {
                    arr[cur.x][cur.y - 1] = arr[cur.x][cur.y] + 1;
                    queue.offer(new Item(cur.x, cur.y - 1));
                }
            }
            if(valid(cur.x, cur.y + 1)) {
                if(arr[cur.x][cur.y + 1] == -1) {
                    arr[cur.x][cur.y + 1] = arr[cur.x][cur.y] + 1;
                    queue.offer(new Item(cur.x, cur.y + 1));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int[] a : arr) {
            for (int i : a) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    static class Item {
        int x;
        int y;

        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
