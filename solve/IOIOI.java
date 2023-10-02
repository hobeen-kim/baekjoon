import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IOIOI {
    //https://www.acmicpc.net/problem/5525
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        String question = br.readLine();
        char[] quesChar = question.toCharArray();

        int start = 0;
        int end = 0;
        boolean started = false;
        int count = 0;

        for (int i = 0; i < m - 1; i++) {

            if(quesChar[i] == 'I') started = true;

            while(started && i < m - 1) {
                if(quesChar[i] != quesChar[i + 1]) {
                    end = ++i;
                } else {
                    started = false;
                    break;
                }
            }

            int temp = end - start + 1;

            int max = Math.max(-1, temp - (n * 2 + 1));

            if(max > -1) {
                count += (max / 2) + 1;
            }

            start = i + 1;
            end = i + 1;
        }

        System.out.println(count);

    }
}
