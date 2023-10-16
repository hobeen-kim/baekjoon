import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 내려가기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dpMax1 = new int[n + 1];
        int[] dpMax2 = new int[n + 1];
        int[] dpMax3 = new int[n + 1];

        int[] dpMin1 = new int[n + 1];
        int[] dpMin2 = new int[n + 1];
        int[] dpMin3 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int third = Integer.parseInt(st.nextToken());

            dpMax1[i] = Math.max(dpMax1[i - 1], dpMax2[i - 1]) + first;
            dpMax2[i] = Math.max(Math.max(dpMax1[i - 1], dpMax2[i - 1]), dpMax3[i - 1]) + second;
            dpMax3[i] = Math.max(dpMax2[i - 1], dpMax3[i - 1]) + third;

            dpMin1[i] = Math.min(dpMin1[i - 1], dpMin2[i - 1]) + first;
            dpMin2[i] = Math.min(Math.min(dpMin1[i - 1], dpMin2[i - 1]), dpMin3[i - 1]) + second;
            dpMin3[i] = Math.min(dpMin2[i - 1], dpMin3[i - 1]) + third;
        }

        int max = Math.max(Math.max(dpMax1[n], dpMax2[n]), dpMax3[n]);
        int min = Math.min(Math.min(dpMin1[n], dpMin2[n]), dpMin3[n]);

        System.out.println(max + " " + min);
    }
}
