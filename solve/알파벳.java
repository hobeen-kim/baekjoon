import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 알파벳 {
    //https://www.acmicpc.net/problem/1987
    static int r;
    static int c;
    static char[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] charArr = br.readLine().toCharArray();
            arr[i] = charArr;
        }

        int size = dfs(0, 0, List.of(arr[0][0]));

        System.out.println(size);
    }

    static int dfs(int x, int y, List<Character> locs) {

        int size = locs.size();

        for (int i = 0; i < 4; i++) {
            if(valid(x + dx[i], y + dy[i]) && !hasAlphabet(locs, arr[x + dx[i]][y + dy[i]])) {
                List<Character> newLocs = new ArrayList<>(locs);
                newLocs.add(arr[x + dx[i]][y + dy[i]]);
                int newSize = dfs(x + dx[i], y + dy[i], newLocs);
                size = Math.max(newSize, size);
            }
        }
        return size;
    }

    static boolean hasAlphabet(List<Character> locs, char alphabet) {
        return locs.contains(alphabet);
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

}
