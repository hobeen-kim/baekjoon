import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AC {
    //https://www.acmicpc.net/problem/5430
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            String[] fuc = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] arrStr = br.readLine().replace("[", "").replace("]", "").split(",");

            for(int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(arrStr[j]);
            }

            int left = -1;
            int right = n;
            boolean isReverse = false;

            for(String f : fuc) {
                if(f.equals("R")) isReverse = !isReverse;
                else {
                    if(isReverse) {
                        right--;
                    }else {
                        left++;
                    }
                }
            }

            if(left >= right) {
                System.out.println("error");
            }else {
                int[] solution = Arrays.copyOfRange(arr, left + 1, right);
                if(isReverse) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    for(int num = solution.length - 1; num >= 0; num--) {
                        sb.append(solution[num]);
                        if(num != 0) {
                            sb.append(",");
                        }
                    }
                    sb.append("]");
                    System.out.println(sb);

                }else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    for(int num = 0; num < solution.length; num++) {
                        sb.append(solution[num]);
                        if(num != solution.length - 1) {
                            sb.append(",");
                        }
                    }
                    sb.append("]");
                    System.out.println(sb);
                }
            }
        }
    }
}
