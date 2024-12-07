import java.util.Scanner;

public class BOJ24723 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();

        int result = (int) Math.pow(2, input);

        System.out.println(result);
    }
}
