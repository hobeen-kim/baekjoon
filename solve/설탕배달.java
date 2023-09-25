import java.util.Scanner;

public class 설탕배달 {
    //https://www.acmicpc.net/problem/2839
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int count = 0;

        int k = n / 5;
        count += k;
        n %= 5;

        if(n == 0) {
            System.out.println(count);
        }
        if(n == 1) {
            System.out.println(count + 1);
        }
        if(n == 2) {
            if(count < 2) System.out.println(-1);
            else System.out.println(count + 2);
        }
        if(n == 3) {
            System.out.println(count + 1);
        }
        if(n == 4) {
            if(count < 1) System.out.println(-1);
            else System.out.println(count + 2);
        }
    }
}
