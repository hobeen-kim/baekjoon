import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는_친구가_필요해 {

    static int n;
    static int m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        Queue<Item> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                char cur = charArr[j];
                if(cur == 'X') arr[i][j] = -1;
                else if(cur == 'I') {
                    queue.offer(new Item(i, j));
                    arr[i][j] = 1;
                }
                else if(cur == 'P') arr[i][j] = -2;
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            Item cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (cur.valid(dx[i], dy[i])) {
                    if(arr[cur.x + dx[i]][cur.y + dy[i]] == 0) {
                        arr[cur.x + dx[i]][cur.y + dy[i]] = 1;
                        queue.offer(cur.create(dx[i], dy[i]));
                    } else if(arr[cur.x + dx[i]][cur.y + dy[i]] == -2) {
                        arr[cur.x + dx[i]][cur.y + dy[i]] = 1;
                        queue.offer(cur.create(dx[i], dy[i]));
                        count++;
                    }
                }
            }
        }

        if(count == 0) {
            System.out.println("TT");
        }else {
            System.out.println(count);
        }
    }

    static class Item {
        int x;
        int y;

        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean valid(int dx, int dy) {
            return x + dx >= 0 && x + dx < n && y + dy >= 0 && y + dy < m;
        }

        Item create(int dx, int dy) {
            return new Item(x + dx, y + dy);
        }

    }
}
