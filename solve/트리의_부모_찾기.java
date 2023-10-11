import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class 트리의_부모_찾기 {
    //https://www.acmicpc.net/problem/11725
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] arr = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }

        int[] parent = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x].add(y);
            arr[y].add(x);
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);

        while(!queue.isEmpty()) {

            int cur = queue.poll();

            for(int i : arr[cur]) {
                if(parent[i] == 0) {
                    queue.offer(i);
                    parent[i] = cur;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i]).append('\n');
        }

        System.out.println(sb);
    }
}
