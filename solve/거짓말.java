import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 거짓말 {
    //https://www.acmicpc.net/problem/1043

    static int n;
    static int m;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = toInt(st.nextToken());
        m = toInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer>[] parties = new ArrayList[m];

        st = new StringTokenizer(br.readLine());

        int knowPeople = toInt(st.nextToken());

        for (int i = 0; i < knowPeople; i++) {
            int know = toInt(st.nextToken());
            visited[know] = true;
            queue.add(know);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int partyPeople = toInt(st.nextToken());
            parties[i] = new ArrayList<>();

            for (int j = 0; j < partyPeople; j++) {
                parties[i].add(toInt(st.nextToken()));
            }

            linkEach(parties[i]);
        }

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            for (int i = 1; i <= n; i++) {
                if(arr[cur][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }

        int count = 0;

        for (ArrayList<Integer> party : parties) {
            if(!hasKnow(party)) count++;
        }

        System.out.println(count);
    }

    private static boolean hasKnow(ArrayList<Integer> party) {

        for (Integer integer : party) {
            if(visited[integer]) return true;
        }

        return false;
    }

    private static void linkEach(ArrayList<Integer> party) {

        for (int i = 0; i < party.size() - 1; i++) {
            for (int j = i + 1; j < party.size(); j++) {

                int to = party.get(i);
                int from = party.get(j);

                arr[to][from] = 1;
                arr[from][to] = 1;
            }
        }
    }

    static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
