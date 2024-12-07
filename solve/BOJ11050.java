import java.util.Scanner;

public class BOJ11050 {
    public static void main(String[] args) {
        //n! / n-k! k!

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        long result = getFactorial(n) / (getFactorial(n - k) * getFactorial(k));

        System.out.println(result);
    }

    static long getFactorial(int number) {
        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }
}
