import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 뱀과_사다리_게임 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ladder = sc.nextInt();
        int snake = sc.nextInt();

        int[] solution = new int[101];
        int[] jump = new int[101];
        int[] snakes = new int[101];

        for (int i = 0; i < ladder; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            jump[from] = to;
        }

        for (int i = 0; i < snake; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();

            snakes[from] = to;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(1);

        while(!queue.isEmpty()) {

            int cur = queue.poll();

            for(int i = 1; i <= 6; i++) {
                if(cur + i <= 100) {
                    if(solution[cur + i] > solution[cur] + 1 || solution[cur + i] == 0) {
                        solution[cur + i] = solution[cur] + 1;

                        if(jump[cur + i] > 0) {
                            if(solution[jump[cur + i]] == 0 || solution[jump[cur + i]] > solution[cur] + 1){
                                solution[jump[cur + i]] = solution[cur] + 1;
                                queue.offer(jump[cur + i]);
                            }
                        }else if(snakes[cur + i] > 0) {
                            if(solution[snakes[cur + i]] == 0 || solution[snakes[cur + i]] > solution[cur] + 1){
                                solution[snakes[cur + i]] = solution[cur] + 1;
                                queue.offer(snakes[cur + i]);
                                solution[cur + i] = -1;
                            }
                        }else {
                            queue.offer(cur + i);
                        }
                    }
                }
            }
        }

        System.out.println(solution[100]);
    }
}
