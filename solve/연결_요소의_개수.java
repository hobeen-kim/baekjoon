import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결_요소의_개수 {

    //https://www.acmicpc.net/problem/11724
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] arr = new int[v + 1][v + 1];
        boolean[] visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= v; i++) {
            if(!visited[i]) {
                count++;
                queue.offer(i);
                visited[i] = true;

                while(!queue.isEmpty()) {
                    int cur = queue.poll();

                    for(int j = 1; j <= v; j++) {
                        if(arr[cur][j] == 1 && !visited[j]) {
                            queue.offer(j);
                            visited[j] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
