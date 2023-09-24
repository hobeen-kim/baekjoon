import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class 다리놓기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            BigInteger result = BigInteger.ONE;

            for(int j = 1; j <= m; j++){
                result = result.multiply(BigInteger.valueOf(j));
            }

            for(int j = 1; j <= m - n; j++){
                result = result.divide(BigInteger.valueOf(j));
            }

            for(int j = 1; j <=  n; j++){
                result = result.divide(BigInteger.valueOf(j));
            }

            System.out.println(result);
        }
    }

}
