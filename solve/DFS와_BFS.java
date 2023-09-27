import java.util.*;

public class DFS와_BFS {
    //https://www.acmicpc.net/problem/1260

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        int[][] dfsArr = new int[n + 1][n + 1];
        int[][] bfsArr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            dfsArr[s][t] = 1;
            dfsArr[t][s] = 1;
            bfsArr[s][t] = 1;
            bfsArr[t][s] = 1;
        }

        List<Integer> dfs = new ArrayList<>();
        getDfs(n, start, dfsArr, dfs);
        String[] array = dfs.stream().map(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", array));
        getBfs(n, start, bfsArr);

    }

    private static void getDfs(int n, int start, int[][] dfsArr, List<Integer> dfs) {

        dfs.add(start);
        for(int j = 1; j <= n; j++) {
            dfsArr[j][start] = 0;
        }

        for(int next = 1; next <= n; next++) {
            if(dfsArr[start][next] == 1) {
                dfsArr[start][next] = 0;

                getDfs(n, next, dfsArr, dfs);
            }
        }
    }

    private static void getBfs(int n, int start, int[][] bfsArr) {
        List<Integer> bfs = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        bfs.add(start);

        for(int j = 1; j <= n; j++) {
            bfsArr[j][start] = 0;
        }

        while(!queue.isEmpty()) {

            Integer cur = queue.poll();

            for(int next = 1; next <= n; next++) {
                if(bfsArr[cur][next] == 1) {
                    queue.offer(next);
                    bfs.add(next);
                    bfsArr[cur][next] = 0;

                    for(int j = 1; j <= n; j++) {
                        bfsArr[j][next] = 0;
                    }

                }
            }
        }

        String[] array = bfs.stream().map(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", array));
    }
}
