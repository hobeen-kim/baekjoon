import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class 연구소 {
    //https://www.acmicpc.net/problem/14502
    static int n;
    static int m;
    static int[][] arr;
    static int[][] tempArr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = parseInt(st.nextToken());
            }
        }

        tempArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            tempArr[i] = Arrays.copyOf(arr[i], m);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j] == 0) {
                    result = Math.max(result, bfs(new Item(i, j)));
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(Item... items) {

        int result = 0;

        if(items.length == 3) {
            //바이러스 확산
            spread(items);

            // 0 계산
            result = sum();

            //tempArr 초기화
            initializeTemp();

            //리턴
            return result;
        }

        int nStart = items[items.length - 1].x;
        int mStart = items[items.length - 1].y;


        for (int i = nStart; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == nStart && j <= mStart) {
                    continue;
                }
                if(arr[i][j] == 0) {
                    Item[] newItems = Arrays.copyOf(items, items.length + 1);
                    newItems[newItems.length - 1] = new Item(i, j);
                    result = Math.max(result, bfs(newItems));
                }

            }
        }

        return result;
    }

    static void spread(Item[] items) {

        for (Item item : items) {
            tempArr[item.x][item.y] = 1;
        }

        Queue<Item> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tempArr[i][j] == 2) {
                    queue.offer(new Item(i, j));
                }
            }
        }

        while(!queue.isEmpty()) {

            Item cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                if(valid(cur.x + dx[i], cur.y + dy[i])) {
                    if(tempArr[cur.x + dx[i]][cur.y + dy[i]] == 0) {
                        tempArr[cur.x + dx[i]][cur.y + dy[i]] = 2;
                        queue.offer(new Item(cur.x + dx[i], cur.y + dy[i]));
                    }
                }
            }
        }
    }

    static int sum() {

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tempArr[i][j] == 0) {
                    sum++;
                }
            }
        }

        return sum;
    }

    static void initializeTemp() {
        for (int i = 0; i < n; i++) {
            tempArr[i] = Arrays.copyOf(arr[i], m);
        }
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
