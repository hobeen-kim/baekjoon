import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class 단지_번호_붙이기 {

    static int n;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            String[] inputArr = input.split("");

            for (int j = 0; j < n; j++) {
                if(inputArr[j].equals("1")) arr[i][j] = 1;
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1) {
                    list.add(calculate(i, j, arr));
                }
            }
        }

        list.sort(Comparator.comparingInt(o -> o));

        StringBuilder sb = new StringBuilder();

        sb.append(list.size()).append('\n');

        for(Integer i : list) {
            sb.append(i).append('\n');
        }

        System.out.println(sb);
    }

    static int calculate(int i, int j, int[][] arr) {

        int count = 1;

        arr[i][j] = 0;

        if(valid(i - 1, j)) {
            if(arr[i - 1][j] == 1) {
                count += calculate(i - 1, j, arr);
            }
        }
        if(valid(i + 1, j)) {
            if(arr[i + 1][j] == 1) {
                count += calculate(i + 1, j, arr);
            }
        }
        if(valid(i, j - 1)) {
            if(arr[i][j - 1] == 1) {
                count += calculate(i, j - 1, arr);
            }
        }
        if(valid(i, j + 1)) {
            if(arr[i][j + 1] == 1) {
                count += calculate(i, j + 1, arr);
            }
        }

        return count;
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
