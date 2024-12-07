import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class BOJ2108 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        numbers.sort((o1, o2) -> o1 - o2);

        int sum = numbers.stream().mapToInt(i -> i).sum();
        int center = numbers.get(n / 2);
        int max = numbers.stream().mapToInt(i -> i).max().getAsInt();
        int min = numbers.stream().mapToInt(i -> i).min().getAsInt();

        int maxCount = 0;
        TreeSet<Integer> maxCountNumbers = new TreeSet<>();

        for (int i = 0; i < numbers.size(); i++) {
            int count = 1;
            int number = numbers.get(i);

            while(true) {
                if(i + 1 >= numbers.size()) break;

                if(numbers.get(i + 1) == number) {
                    count++;
                    i++;
                } else break;
            }

            if(maxCount < count) {
                maxCountNumbers.clear();
                maxCountNumbers.add(number);
                maxCount = count;
            }

            if(maxCount == count) {
                maxCountNumbers.add(number);
                maxCount = count;
            }
        }

        System.out.println(Math.round((double) sum / n));
        System.out.println(center);
        if(maxCountNumbers.size() == 1) System.out.println(maxCountNumbers.first());
        else System.out.println(maxCountNumbers.ceiling(maxCountNumbers.first() + 1));
        System.out.println(max - min);
    }
}
