import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나무_자르기 {

    //https://www.acmicpc.net/problem/2805
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());

        int min = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        int center = (min + max) / 2;

        long sum = 0;

        while(max - min > 1) {

            for (int i : arr) {
                sum += Math.max(0, i - center);
                if(sum > m) {
                    min = center;
                    center = (min + max) / 2;
                    break;
                }
            }

            if(sum <= m) {
                max = center;
                center = (min + max) / 2;
            }

            sum = 0;
        }

        for (int i : arr) {
            sum += Math.max(0, i - max);
            if(sum >= m) {
                System.out.println(max);
                break;
            }
        }
        if(sum < m) {
            System.out.println(min);
        }
    }
}
