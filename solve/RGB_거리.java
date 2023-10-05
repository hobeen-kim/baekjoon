import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB_거리 {
    //https://www.acmicpc.net/problem/1149
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        int[] redDp = new int[n + 1];
        int[] greenDp = new int[n + 1];
        int[] blueDp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            greenDp[i] = green + Math.min(redDp[i - 1], blueDp[i - 1]);
            redDp[i] = red + Math.min(greenDp[i - 1], blueDp[i - 1]);
            blueDp[i] = blue + Math.min(greenDp[i - 1], redDp[i - 1]);
        }

        int min = Math.min(Math.min(redDp[n], greenDp[n]), blueDp[n]);
        System.out.println(min);
    }
}
