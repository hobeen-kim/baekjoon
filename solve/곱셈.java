import java.util.*;

public class 곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        TreeSet<Integer> set = new TreeSet<>();

        int count = 0;

        a = a % c;
        set.add((int) a);

        for(int i = 1; i <= b; i++) {

            a = (a * a) % c;
            int inta = (int) a;
            if(set.contains(inta)) break;
            else {
                set.add(inta);
                count++;
            }
        }

        int index = (int) b % count;


        Integer integer = set.stream().skip(index).findFirst().get();

        System.out.println(integer);

    }
}
