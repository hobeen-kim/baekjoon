import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BOJ15649 {

    static int n;
    static int m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        putSequence(new boolean[n], new ArrayList<>(), m);

        bw.write(sb.toString());
        bw.close();
    }

    //수열 넣기
    static void putSequence(boolean[] used, ArrayList<Integer> result, int remainCount) {
        if(remainCount == 0) {
            //used 에서 true 인 항목만 sb 에 ++
            StringBuilder value = new StringBuilder();

            for (int r : result) {
                value.append(r + 1).append(" ");
            }

            sb.append(value);
            sb.append("\n");

            return;
        }

        for (int i = 0; i < used.length; i++) {
            if(!used[i]) {
                boolean[] newUsed = Arrays.copyOf(used, used.length);
                newUsed[i] = true;

                ArrayList<Integer> newResult = new ArrayList<>(result);
                newResult.add(i);

                putSequence(newUsed, newResult, remainCount - 1);
            }
        }
    }
}
