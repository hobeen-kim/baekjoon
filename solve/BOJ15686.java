import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class BOJ15686 {

    static int n;
    static int m;
    static int[][] arr;
    static int[][] temp;
    static Queue<Dis> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        arr = new int[n][n];
        temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = parseInt(st.nextToken());
            }
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 2) {
                    List<Item> l = new ArrayList<>();
                    l.add(new Item(i, j));
                    result = Math.min(brutal(l, m), result);
                }
            }
        }
        System.out.println(result);
    }

    static int brutal(List<Item> items, int depth) {

        if(depth == 1) return cal(items);

        int result = Integer.MAX_VALUE;

        for (int i = items.get(items.size() - 1).x; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == items.get(items.size() - 1).x && j <= items.get(items.size() - 1).y) {
                    continue;
                }
                if(arr[i][j] == 2) {
                    List<Item> newItems = new ArrayList<>(items);
                    newItems.add(new Item(i, j));
                    result = Math.min(brutal(newItems, depth - 1), result);
                }
            }
        }

        return result;
    }

    static int cal(List<Item> items) {

        for (Item item : items) {
            dis(item.x, item.y);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) result += temp[i][j];
            }
        }

        tempClear();

        return result;
    }

    static void dis(int i, int j) {
        queue.offer(new Dis(i, j, 0));
        boolean[][] visited = new boolean[n][n];
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            Dis cur = queue.poll();

            for (int k = 0; k < 4; k++) {
                int locX = cur.x + dx[k];
                int locY = cur.y + dy[k];
                if(valid(locX, locY) && !visited[locX][locY]) {
                    if(arr[locX][locY] == 1) {
                        if (temp[locX][locY] == 0) temp[locX][locY] = cur.dis + 1;
                        else temp[locX][locY] = Math.min(cur.dis + 1, temp[locX][locY]);
                    }

                    queue.offer(new Dis(locX, locY, cur.dis + 1));
                    visited[locX][locY] = true;
                }
            }
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static void tempClear() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(temp[i], 0);
        }
    }


    static class Item {
        int x;
        int y;

        Item(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Dis {
        int x;
        int y;
        int dis;

        Dis(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
}
