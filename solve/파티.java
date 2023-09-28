import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파티 {
    //https://www.acmicpc.net/problem/1238
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[][] arrFrom = new int[n + 1][n + 1];
        int[][] arrTo = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            arrFrom[f][s] = t;
            arrTo[f][s] = t;
        }

        Queue<Item> queue = new LinkedList<>();
        queue.offer(new Item(x, 0));
        int[] fromX = new int[n + 1];
        Arrays.fill(fromX, Integer.MAX_VALUE);

        while(!queue.isEmpty()) {

            Item cur = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(arrFrom[cur.loc][i] > 0) {
                    if(fromX[i] > cur.value + arrFrom[cur.loc][i]) {
                        fromX[i] = cur.value + arrFrom[cur.loc][i];
                        queue.offer(new Item(i, fromX[i]));
                    }

                }
            }
        }

        queue.offer(new Item(x, 0));
        int[] toX = new int[n + 1];
        Arrays.fill(toX, Integer.MAX_VALUE);

        while(!queue.isEmpty()) {

            Item cur = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(arrTo[i][cur.loc] > 0) {
                    if(toX[i] > cur.value + arrTo[i][cur.loc]) {
                        toX[i] = cur.value + arrTo[i][cur.loc];
                        queue.offer(new Item(i, toX[i]));
                    }
                }
            }
        }

        int max = 0;

        toX[x] = 0;
        fromX[x] = 0;

        for(int i = 1; i <= n; i++) {
            max = Math.max(max, toX[i] + fromX[i]);
        }

        System.out.println(max);

    }

    static class Item {
        int loc;
        int value;

        Item(int loc, int value) {
            this.loc = loc;
            this.value = value;
        }
    }
}
