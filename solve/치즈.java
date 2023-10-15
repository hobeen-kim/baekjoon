import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈 {
    //https://www.acmicpc.net/problem/2638

    static int n;
    static int m;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Item> queue = new LinkedList<>();



        int time = 0;
        boolean hasCheeze = false;

        while(true) {

            queue.offer(new Item(0, 0));
            visited[0][0] = true;

            while (!queue.isEmpty()) {

                Item cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    if(valid(cur.x + dx[i], cur.y + dy[i]) && !visited[cur.x + dx[i]][cur.y + dy[i]]) {
                        if(arr[cur.x + dx[i]][cur.y + dy[i]] == 0) {
                            queue.offer(new Item(cur.x + dx[i], cur.y + dy[i]));
                            visited[cur.x + dx[i]][cur.y + dy[i]] = true;
                        } else if(arr[cur.x + dx[i]][cur.y + dy[i]] == 1) {
                            arr[cur.x + dx[i]][cur.y + dy[i]] = 2;
                        } else if(arr[cur.x + dx[i]][cur.y + dy[i]] == 2) {
                            arr[cur.x + dx[i]][cur.y + dy[i]] = -1;
                            hasCheeze = true;
                        }
                    }
                }
            }

            if(!hasCheeze) break;

            time++;
            hasCheeze = false;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    visited[i][j] = false;
                    if(arr[i][j] == -1) arr[i][j] = 0;
                    else if(arr[i][j] == 2) arr[i][j] = 1;
                }
            }
        }

        System.out.println(time);

        // 주위에 0 이면 queue 에 넣고
        // 1 이면 + 1 하고
        // 2 이면 -1 로 바꾸고

        // -1 을 전부 0으로 바꾸고 2 를 1로 바꾸고
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
