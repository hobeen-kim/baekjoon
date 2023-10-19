import javax.swing.*;
import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class 최소비용_구하기_2 {
    //https://www.acmicpc.net/problem/11779
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = parseInt(br.readLine());
        m = parseInt(br.readLine());

        int[] cost = new int[n + 1];
        ArrayList<Integer>[] order = new ArrayList[n + 1];
        int[][] arr = new int[n + 1][n + 1];

        Arrays.fill(cost, Integer.MAX_VALUE);

        for (int i = 1; i <= n; i++) {
            order[i] = new ArrayList<>();
            Arrays.fill(arr[i], -1);
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            int value = parseInt(st.nextToken());

            if(arr[from][to] >= 0) {
                arr[from][to] = Math.min(arr[from][to], value);
            }else {
                arr[from][to] = value;
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = parseInt(st.nextToken());
        int to = parseInt(st.nextToken());

        cost[from] = 0;
        order[from].add(from);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);

        while(!queue.isEmpty()){

            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if(arr[cur][i] >= 0) {
                    if(cost[cur] + arr[cur][i] <= cost[i]) {
                        cost[i] = cost[cur] + arr[cur][i];
                        order[i] = new ArrayList<>(order[cur]);
                        order[i].add(i);
                        queue.offer(i);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(cost[to]).append('\n');
        sb.append(order[to].size()).append('\n');

        for (Integer integer : order[to]) {
            sb.append(integer).append(' ');
        }

        bw.write(sb.toString());

        bw.close();
        br.close();
    }
}
