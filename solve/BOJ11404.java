import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404 {

    static int n;
    static ArrayList<ArrayList<Item>> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }


        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            boolean alreadyHas = false;

            for (Item item : arr.get(from)) {
                if(item.vertex == to) {
                    item.cost = Math.min(item.cost, value);
                    alreadyHas = true;
                }
            }
            if(!alreadyHas) arr.get(from).add(new Item(to, value));
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            int[] costs = dij(i);

            for(int j = 1; j <= n; j++) {
                if(costs[j] != 0 && costs[j] != Integer.MAX_VALUE) {
                    sb.append(costs[j]);
                }else {
                    sb.append(0);
                }
                sb.append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        bw.close();
    }

    private static int[] dij(int i) {
        int[] cost = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[i] = 0;
        visited[i] = true;

        for (Item item : arr.get(i)) {
            cost[item.vertex] = item.cost;
        }

        while(true) {
            int minIdx = findMinIdx(cost, visited);

            if(minIdx == -1) break;

            visited[minIdx] = true;

            for (Item item : arr.get(minIdx)) {
                if(cost[item.vertex] > cost[minIdx] + item.cost) {
                    cost[item.vertex] = cost[minIdx] + item.cost;
                }
            }
        }



        return cost;
    }

    private static int findMinIdx(int[] cost, boolean[] visited) {

        int minIdx = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            if(cost[i] < minValue && !visited[i]) {
                minIdx = i;
                minValue = cost[i];
            }
        }

        return minIdx;
    }


    static class Item {
        int vertex;
        int cost;

        public Item(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }
    }
}
