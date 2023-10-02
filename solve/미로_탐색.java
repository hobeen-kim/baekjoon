import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로_탐색 {
    //https://www.acmicpc.net/problem/2178

    static int n;
    static int m;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] inputArr = input.split("");

            for (int j = 0; j < m; j++) {
                if(!inputArr[j].equals("0")) arr[i][j] = -1;
            }
        }

        arr[0][0] = 1;

        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(0, 0));

        while(!queue.isEmpty()) {

            Item cur = queue.poll();

            if(cur.x == n - 1 && cur.y == m - 1) {
                break;
            }

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

        System.out.println(arr[n - 1][m - 1]);

    }

    static class Item {
        int x;
        int y;

        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
