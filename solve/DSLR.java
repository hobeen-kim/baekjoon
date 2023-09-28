import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DSLR {

    //https://www.acmicpc.net/problem/9019
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        for (int i = 0; i < tc; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();

            String[] arr = new String[10001];

            Queue<Integer> queue = new LinkedList<>();

            queue.add(from);
            arr[from] = "";

            while(!queue.isEmpty()) {

                int cur = queue.poll();

                if(cur == to) {
                    System.out.println(arr[to]);
                    break;
                }

                int d = calD(cur);
                if(arr[d] == null) {
                    arr[d] = arr[cur] + "D";
                    queue.offer(d);
                }
                int s = calS(cur);
                if(arr[s] == null) {
                    arr[s] = arr[cur] + "S";
                    queue.offer(s);
                }
                int l = calL(cur);
                if(arr[l] == null) {
                    arr[l] = arr[cur] + "L";
                    queue.offer(l);
                }
                int r = calR(cur);
                if(arr[r] == null) {
                    arr[r] = arr[cur] + "R";
                    queue.offer(r);
                }
            }
        }
    }

    private static int calD(int cur) {

        return (cur * 2) % 10000;
    }

    private static int calS(int cur) {

        int temp;

        if(cur == 0) {
            temp = 9999;
        }else {
            temp = cur - 1;
        }

        return temp;
    }

    private static int calL(int cur) {

        int thousand = cur / 1000;
        int hundred = (cur % 1000) / 100;
        int ten = (cur % 100) / 10;
        int one = (cur % 10);

        return hundred * 1000 + ten * 100 + one * 10 + thousand;
    }

    private static int calR(int cur) {

        int thousand = cur / 1000;
        int hundred = (cur % 1000) / 100;
        int ten = (cur % 100) / 10;
        int one = (cur % 10);

        return one * 1000 + thousand * 100 + hundred * 10 + ten;
    }
}
