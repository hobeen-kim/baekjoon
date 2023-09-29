import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 집합 {

    //https://www.acmicpc.net/problem/11723

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String fuc = st.nextToken();

            switch (fuc) {
                case "add" :
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove" :
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check" :
                {
                    int num = Integer.parseInt(st.nextToken());
                    boolean contains = set.contains(num);
                    if (contains) sb.append(1).append('\n');
                    else sb.append(0).append('\n');
                    break;
                }
                case "toggle" :
                {
                    int num = Integer.parseInt(st.nextToken());
                    boolean contains = set.contains(num);
                    if (contains) set.remove(num);
                    else set.add(num);
                    break;
                }
                case "all" :
                    set.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
                    break;
                case "empty" :
                    set.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
