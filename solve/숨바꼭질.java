import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 숨바꼭질 {
    //213
    //https://www.acmicpc.net/problem/1697

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100001];

        Arrays.fill(arr, -1);

        int s = sc.nextInt();
        int t = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        arr[s] = 0;

        while(!queue.isEmpty()) {

            int cur = queue.poll();
            int time = arr[cur];

            if(cur == t) {
                System.out.println(time);
                break;
            }

            if(cur - 1 > -1) {
                if(arr[cur - 1] == -1) {
                    queue.offer(cur - 1);
                    arr[cur - 1] = time + 1;
                }
            }
            if(cur + 1 <= 100000) {
                if(arr[cur + 1] == -1) {
                    queue.offer(cur + 1);
                    arr[cur + 1] = time + 1;
                }
            }
            if(cur * 2 <= 100000) {
                if(arr[cur * 2] == -1) {
                    queue.offer(cur * 2);
                    arr[cur * 2] = time + 1;
                }
            }

        }
    }
}
