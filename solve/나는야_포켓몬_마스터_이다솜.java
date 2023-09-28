import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 나는야_포켓몬_마스터_이다솜 {
    //https://www.acmicpc.net/problem/1620

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[n + 1];

        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(name, i);
            arr[i] = name;
        }

        for(int i = 1; i <= m; i++){
            String quiz = br.readLine();
            if(map.containsKey(quiz)) {
                System.out.println(map.get(quiz));
            }else {
                System.out.println(arr[Integer.parseInt(quiz)]);
            }
        }

    }
}
