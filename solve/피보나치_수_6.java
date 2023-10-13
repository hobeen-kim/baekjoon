import java.util.Scanner;

public class 피보나치_수_6 {
    //https://www.acmicpc.net/problem/11444
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();

        long[][] answers = calculate(n);

        System.out.println(answers[0][1]);
    }

    private static long[][] calculate(long n) {

        if(n == 1) return new long[][]{{1L, 1L}, {1L, 0L}};

        if(n % 2 == 0) {

            long[][] divided = calculate(n / 2);

            return matMultiple(divided, divided);
        }

        return matMultiple(calculate(n - 1), calculate(1));
    }

    private static long[][] matMultiple(long[][] mat1, long[][] mat2) {

        long mod = 1000000007L;

        long a = mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        long b = mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        long d = mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];

        return new long[][]{{a % mod, b % mod}, {b % mod, d % mod}};
    }
}
