import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 좌표압축 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            int next = Integer.parseInt(st.nextToken());
            arr[i] = next;
            set.add(next);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        Iterator<Integer> iterator = set.iterator();

        for (int i = 0; i < set.size(); i++) {
            map.put(iterator.next(), i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(' ');
        }

        System.out.println(sb);
    }
}
