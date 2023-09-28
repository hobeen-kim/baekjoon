import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 테트로미노 {

    static int n;
    static int m;

    static int[][][] loc = {
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, //
            {{0, 0}, {0, 1}, {0, 2}, {-1, 2}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{0, 0}, {0, 1}, {-1, 1}, {-2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, //
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}},
            {{0, 0}, {1, 0}, {0, 1}, {-1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}},
            {{0, 0}, {0, 1}, {-1, 1}, {1, 1}},
            {{0, 0}, {1, 1}, {0, 1}, {1, 0}},
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max(i, j, arr), max);
            }
        }

        System.out.println(max);
    }

    static int max(int i, int j, int[][] arr) {

        List<Integer> solutions = new ArrayList<>();

        for (int k = 0; k < loc.length; k++) {
            int sol = cal(i, j, arr, loc[k]);
            solutions.add(sol);
        }

        return solutions.stream().mapToInt(Integer::intValue).max().orElse(-1);

    }

    static int cal(int i, int j, int[][] arr, int[][] loc) {

        boolean valid = true;
        int result = 0;

        for(int[] l : loc) {
            if(!valid(i + l[0], j + l[1])) {
                valid = false;
            }else {
                result += arr[i + l[0]][j + l[1]];
            }
        }

        if(!valid) {
            return 0;
        }

        return result;
    }


    static boolean valid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}
