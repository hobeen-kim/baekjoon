import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class a_b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long from = sc.nextLong();
        long to = sc.nextLong();

        Queue<Item> queue = new LinkedList<>();

        queue.offer(new Item(1, from));

        int result = -1;

        while(!queue.isEmpty()) {

            Item cur = queue.poll();

            if(cur.value == to) {
                result = cur.depth;
                break;
            }

            if(cur.value * 2 <= to) {
                queue.offer(new Item(cur.depth + 1, cur.value * 2));
            }

            if(cur.value * 10 + 1 <= to) {
                queue.offer(new Item(cur.depth + 1, cur.value * 10 + 1));
            }
        }

        System.out.println(result);

    }

    static class Item {
        int depth;
        long value;

        Item(int depth, long value) {
            this.depth = depth;
            this.value = value;
        }
    }
}
