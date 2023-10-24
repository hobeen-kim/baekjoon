import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BOJ14938 {

    static int n;
    static int m;
    static int r;
    static int[][] arr;
    static int[] items;
    static ArrayList<ArrayList<Node>> arrays = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        r = parseInt(st.nextToken());

        items = new int[n + 1];
        arr = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = parseInt(st.nextToken());
        }

        for (int i = 0; i <= n; i++) {
            arrays.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int d = parseInt(st.nextToken());

            arrays.get(x).add(new Node(y, d));
            arrays.get(y).add(new Node(x, d));
        }

        int max = 0;

        if(n == 1) max = items[n];
        else {
            for (int i = 1; i <= n; i++) {
                max = Math.max(cal(i), max);
            }
        }

        System.out.println(max);
    }

    static int cal(int loc) {
        boolean[] visited = new boolean[n + 1];
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        visited[loc] = true;
        cost[loc] = 0;

        for (Node node : arrays.get(loc)) {
            cost[node.v] = node.cost;
        }

        while(true) {
            int minV = getMinV(cost, visited);

            if(minV == -1) break;

            visited[minV] = true;

            for (Node node : arrays.get(minV)) {
                if(cost[node.v] > cost[minV] + node.cost) {
                    cost[node.v] = cost[minV] + node.cost;
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            if(cost[i] <= m) result += items[i];
        }

        return result;
    }

    static int getMinV(int[] cost, boolean[] visited) {

        int idx = -1;
        int minCost = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if(cost[i] < minCost && !visited[i]) {
                idx = i;
                minCost = cost[i];
            }
        }

        return idx;
    }

    static class Node {
        int v;
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
