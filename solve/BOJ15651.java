import java.io.*;
import java.util.*;

public class BOJ15651 {

    static Scanner sc = new Scanner(System.in);
    static BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        n = sc.nextInt();
        m = sc.nextInt();

        putSequence(new ArrayList<>());

        br.write(sb.toString());
        br.close();
    }

    static void putSequence(ArrayList<Integer> result) {
        if(result.size() == m) {

            StringBuilder resultCombines = new StringBuilder();

            for (Integer r : result) {
                resultCombines.append(r + 1).append(" ");
            }
            resultCombines.append("\n");

            sb.append(resultCombines);
            return;
        }

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> newResult = new ArrayList<>(result);

            newResult.add(i);

            putSequence(newResult);
        }
    }
}
