import java.util.HashMap;
import java.util.Scanner;

public class BOJ2577 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int value = a * b * c;
        String[] v = String.valueOf(value).split("");

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            map.put(String.valueOf(i), 0);
        }

        for (String s : v) {
            map.put(s, map.get(s) + 1);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(map.get(String.valueOf(i)));
        }
    }
}
