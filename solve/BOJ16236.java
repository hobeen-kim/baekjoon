import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class BOJ16236 {

    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int curX;
    static int curY;
    static Queue<Item> items = new LinkedList<>();
    static List<Item> eatable = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = parseInt(st.nextToken());
                if(arr[i][j] == 9) {
                    arr[i][j] = 0;
                    curX = i;
                    curY = j;
                }
            }
        }

        int time = 0;
        int size = 2;
        int eat = 0;

        while(true) {
            //가까운 잡아먹을 수 있는 애를 먹는다.
            Item item = find(size);

            if(item == null) {
                break;
            }

            arr[item.x][item.y] = 0;
            eat++;
            time += item.distance;
            curX = item.x;
            curY = item.y;

            //크기 계산
            if(eat == size) {
                size++;
                eat = 0;
            }
        }

        System.out.println(time);
    }

    static Item find(int size) {

        items.offer(new Item(curX, curY, 0));
        visited[curX][curY] = true;

        int minDis = Integer.MAX_VALUE;

        while(!items.isEmpty()) {

            Item cur = items.poll();

            if(cur.distance >= minDis) continue;

            for (int i = 0; i < 4; i++) {

                int locX = cur.x + dx[i];
                int locY = cur.y + dy[i];

                if(isValid(locX, locY) && !visited[locX][locY]) {
                    if(isEatable(size, arr[locX][locY])) {
                        eatable.add(new Item(locX, locY, cur.distance + 1));
                        minDis = cur.distance + 1;
                    }else if(isMovable(size, arr[locX][locY])) {
                        items.offer(new Item(locX, locY, cur.distance + 1));
                        visited[locX][locY] = true;
                    }
                }
            }
        }

        if(eatable.size() == 0) return null;

        List<Item> collect = eatable.stream()
                .sorted(Comparator.comparing(Item::getX).thenComparing(Item::getY))
                .collect(Collectors.toList());

        Item result = collect.get(0);

        eatable.clear();
        items.clear();
        visitClear();

        return result;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    static boolean isEatable(int size, int target) {
        return size > target && target > 0;
    }

    static boolean isMovable(int size, int target) {
        return size >= target;
    }

    static void visitClear() {
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    static class Item {
        int x;
        int y;
        int distance;

        Item(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

}
