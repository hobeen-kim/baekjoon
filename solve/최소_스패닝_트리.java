import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최소_스패닝_트리 {
    //https://www.acmicpc.net/problem/1197

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Item>[] arr = new ArrayList[v + 1];

        for (int i = 1; i < v + 1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            arr[from].add(new Item(to, value));
            arr[to].add(new Item(from, value));
        }

        int[] cost = new int[v + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        boolean[] visited = new boolean[v + 1];
        int vnum = 1;

        for(int i = 2; i <= v; i++) {
            for(Item item : arr[1]) {
                cost[item.v] = item.value;
            }
        }

        cost[1] = 0;
        visited[1] = true;

        while (vnum != v) {

            int next = visitMin(visited, cost);
            vnum++;

            for(Item item : arr[next]) {
                if(!visited[item.v] && item.value < cost[item.v]) {
                    cost[item.v] = item.value;
                }
            }
        }

        int sum = 0;

        for (int i = 1; i <= v; i++) {
            sum += cost[i];
        }

        System.out.println(sum);

    }

    static int visitMin(boolean[] visited, int[] cost) {

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 1; i < cost.length; i++) {
            if(!visited[i]) {
                if(cost[i] < min) {
                    min = cost[i];
                    index = i;
                }
            }
        }

        visited[index] = true;

        return index;
    }

    static class Item {

        int v;
        int value;

        Item(int v, int value) {
            this.v = v;
            this.value = value;
        }

    }

}
