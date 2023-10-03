import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 카잉_달력 {
    //https://www.acmicpc.net/problem/6064
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            boolean[] arr = new boolean[40001];

            for (int j = 0;;j++) {
                int k = (j * m + x) % n;

                if(k == 0) k = n;

                if(k == y) {
                    System.out.println((j * m + x));
                    break;
                }else {
                    if(arr[k]){
                        System.out.println(-1);
                        break;
                    }else {
                        arr[k] = true;
                    }

                }
            }
        }
    }

    static int cal(int cur, int max) {
        if(cur < max) return cur + 1;
        else return 1;
    }
}
