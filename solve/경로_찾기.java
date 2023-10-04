import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로_찾기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {

            Queue<Integer> queue = new LinkedList<>();

            queue.offer(i);

            while (!queue.isEmpty()) {

                int cur = queue.poll();

                for (int j = 0; j < n; j++) {
                    if(arr[cur][j] == 1 && answer[i][j] == 0) {
                        queue.offer(j);
                        answer[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}
