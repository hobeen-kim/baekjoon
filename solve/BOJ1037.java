import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1037 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int count = Integer.parseInt(br.readLine());
        int[] divisors = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        //count 가 짝수면 최대값 * 최소값
        int max = Arrays.stream(divisors).max().getAsInt();
        int min = Arrays.stream(divisors).min().getAsInt();

        System.out.println(max * min);
    }
}
