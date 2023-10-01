import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 보석_도둑 {
    //https://www.acmicpc.net/problem/1202

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Item[] items = new Item[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            items[i] = new Item(m, v);
        }

        Arrays.sort(items, (o1, o2) -> {
            if (o1.m == o2.m) {
                return o2.v - o1.v;
            }
            return o1.m - o2.m;
        });

        int[] bags = new int[k];

        for(int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        long sum = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0, j = 0; i < k; i++) {
            while(j < n && items[j].m <= bags[i]) {
                pq.offer(items[j++].v);
            }
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        System.out.println(sum);
    }

    static class Item{
        int m;
        int v;

        public Item(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}
