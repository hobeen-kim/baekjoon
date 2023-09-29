import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int comNum = sc.nextInt();
        int e = sc.nextInt();

        int[][] arr = new int[comNum + 1][comNum + 1];

        int[] isInfected = new int[comNum + 1];

        for (int i = 0; i < e; i++) {
            int to = sc.nextInt();
            int from = sc.nextInt();

            arr[to][from] = 1;
            arr[from][to] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        isInfected[1] = 1;
        queue.add(1);

        int result = 0;

        while(!queue.isEmpty()) {

            Integer cur = queue.poll();

            for (int i = 1; i <= comNum; i++) {
                if(arr[cur][i] == 1 && isInfected[i] == 0) {
                    queue.add(i);
                    isInfected[i] = 1;
                    result++;
                }
            }
        }

        System.out.println(result);

    }
}
