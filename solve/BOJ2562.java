import java.util.Scanner;

public class BOJ2562 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int idx = 0;
        int value = 0;

        for (int i = 1; i <= 9; i++) {
            int cur = sc.nextInt();

            if(cur > value) {
                value = cur;
                idx = i;
            }
        }

        System.out.println(value);
        System.out.println(idx);
    }
}
