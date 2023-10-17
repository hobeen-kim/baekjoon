import java.io.*;
import java.util.*;

public class 최단경로 {
    //https://www.acmicpc.net/problem/1753
    static int[] cost;
    static Node[] nodes;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = toInt(st.nextToken());
        int e = toInt(st.nextToken());
        int start = toInt(br.readLine());

        cost = new int[v + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        nodes = new Node[v + 1];
        visited = new boolean[v + 1];

        for (int i = 0; i < e; i++) {

            st = new StringTokenizer(br.readLine());

            int from = toInt(st.nextToken());
            int to = toInt(st.nextToken());
            int distance = toInt(st.nextToken());

            if(nodes[from] == null) {
                nodes[from] = new Node(from, 0);
            }
            nodes[from].nodes.add(new Node(to, distance));
        }

        cost[start] = 0;

        Queue<Node> queue = new LinkedList<>();

        queue.offer(nodes[start]);
        visited[start] = true;

        while(!queue.isEmpty()) {

            Node cur = queue.poll();

            if(cur == null) continue;

            for (Node node : cur.nodes) {

                if(cost[node.vertex] > node.distance + cost[cur.vertex]) {
                    cost[node.vertex] = Math.min(node.distance + cost[cur.vertex], cost[node.vertex]);
                    queue.offer(nodes[node.vertex]);
                }

            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= v; i++) {
            if(cost[i] == Integer.MAX_VALUE) sb.append("INF").append('\n');
            else sb.append(cost[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static class Node {
        int vertex;
        int distance;
        List<Node> nodes = new ArrayList<>();

        Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        void addNode(Node node) {
            nodes.add(node);
        }
    }

    static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
