import java.util.Arrays;
import java.util.Scanner;

public class ATM {
    //https://www.acmicpc.net/problem/11399

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] array = Arrays.stream(arr).sorted().toArray();

        int min = 0;

        for (int i = 0; i < n; i++) {
            min += array[i] * (n - i);

        }

        System.out.println(min);

    }
}
