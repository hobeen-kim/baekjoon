import java.util.Scanner;

public class Z {
    //https://www.acmicpc.net/problem/1074

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int count = 0;

        while(n > 1) {
            int location = location(n, r, c);
            int reduceAmount = (int) (Math.pow(2, n - 1) * Math.pow(2, n - 1));
            int reduceCount = (int) (Math.pow(2, n - 1));

            n--;
            if(location == 1) {
                count += reduceAmount;
                c -= reduceCount;
            }else if(location == 2) {
                count += reduceAmount * 2;
                r -= reduceCount;
            }else if(location == 3) {
                count += reduceAmount * 3;
                r -= reduceCount;
                c -= reduceCount;
            }
        }

        System.out.println(count + location(n, r, c));
    }

    static int location(int n, int r, int c) {
        int half = (int) (Math.pow(2, n)) / 2;

        if(r < half && c < half) return 0;
        else if(r < half && c >= half) return 1;
        else if(r >= half && c < half) return 2;
        else return 3;
    }
}
