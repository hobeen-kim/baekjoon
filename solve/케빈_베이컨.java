import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 케빈_베이컨 {
    //https://www.acmicpc.net/problem/1389

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int user = sc.nextInt();
        int x = sc.nextInt();

        int[][] arr = new int[user + 1][user + 1];

        for (int i = 0; i < x; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            arr[s][t] = 1;
            arr[t][s] = 1;
        }

        int[][] bacon = new int[user + 1][user + 1];

        for(int i = 1; i <= user; i++) {

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int[][] tempArr = new int[user + 1][user + 1];
            for(int tem = 0; tem <= user; tem++) {
                tempArr[tem] = Arrays.copyOf(arr[tem], arr[tem].length);
            }

            while(!queue.isEmpty()) {

                Integer cur = queue.poll();

                for(int k = 0; k <= user; k++) {
                    tempArr[k][cur] = 0;
                }

                for(int j = 1; j <= user; j++) {
                    if(tempArr[cur][j] == 1) {
                        queue.add(j);
                        bacon[i][j] = bacon[i][cur] + 1;
                        for(int k = 0; k <= user; k++) {
                            tempArr[k][j] = 0;
                        }
                    }
                }
            }
        }

        int[] avgBacon = new int[user + 1];
        for(int i = 1; i <= user; i++) {
            int avgI = 0;
            for(int j : bacon[i]) {
                avgI += j;
            }
            avgBacon[i] = avgI;
        }
        int min = 9999;

        for(int i = 1; i <= user; i++) {
            if(avgBacon[i] < min) min = avgBacon[i];
        }

        for(int i = 1; i <= user; i++) {
            if(avgBacon[i] == min){
                System.out.println(i);
                break;
            }
        }
    }
}
