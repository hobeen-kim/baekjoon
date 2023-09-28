import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 듣보잡 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<String> sets = new HashSet<>();
        TreeSet<String> result = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            sets.add(name);
        }

        for (int i = 0; i < m; i++) {
            String name = br.readLine();
            if(sets.contains(name)){
                result.add(name);
            }
        }

        System.out.println(result.size());
        Iterator<String> iterator = result.iterator();
        for (int i = 0; i < result.size(); i++) {
            System.out.println(iterator.next());
        }
    }
}
