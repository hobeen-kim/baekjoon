import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());

        boolean isMixed = false;

        if(first == 1) {
            for (int i = 2; i <= 8; i++) {
                if(Integer.parseInt(st.nextToken()) != i) {
                    isMixed = true;
                    break;
                }
            }

            if(!isMixed) System.out.println("ascending");

        } else if(first == 8) {
            for (int i = 7; i >= 1; i--) {
                if(Integer.parseInt(st.nextToken()) != i) {
                    isMixed = true;
                    break;
                }
            }

            if(!isMixed) System.out.println("descending");

        } else {
            isMixed = true;
        }

        if(isMixed) System.out.println("mixed");
    }
}
