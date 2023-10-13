import java.util.Arrays;
import java.util.Scanner;

public class N_Queen {
    //https://www.acmicpc.net/problem/9663

    static int n;

    public static void main(String[] args) {
        //arr 을 만든다.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        int result = 0;

        for (int i = 0; i < n; i++) {
            int[] locations = new int[n];
            locations[0] = i;
            result += flip2(0, locations);
        }

        System.out.println(result);
    }

    static int flip2(int depth, int[] locations) {

        if(depth == n - 1) {

            return 1;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {

            if(checkValid(depth + 1, i, locations)) {

                locations[depth + 1] = i;
                result += flip2(depth + 1, locations);
            }
        }

        return result;
    }

    private static boolean checkValid(int depth, int location, int[] locations) {

        for (int i = 0; i < depth; i++) {

            int cur = locations[i];

            if(cur == location) return false;
            if(cur + depth - i == location) return false;
            if(cur - depth + i == location) return false;
        }

        return true;
    }
}
