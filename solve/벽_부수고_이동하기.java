import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class 벽_부수고_이동하기 {
    //https://www.acmicpc.net/problem/2206

    static List<Integer> solutions = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("0") && n == 1 && m == 1) {
                solutions.add(1);
                break;
            }

            String[] split = s.split("");

            for(int j = 0; j < m; j++) {
                if(split[j].equals("1")) {
                    arr1[i][j] = -1;
                    arr2[i][j] = -1;
                }else {
                    arr1[i][j] = 0;
                    arr2[i][j] = 0;
                }
            }
        }

        findPath(0, 0, arr1);
        findPath(n - 1, m - 1, arr2);

        breakBlock(arr1, arr2);

        int s = solutions.stream().mapToInt(Integer::intValue).min().orElse(-1);
        s = s == 999999 ? -1 : s;
        System.out.println(s);
    }

    static void breakBlock(int[][] arr1, int[][] arr2) {
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[0].length; j++){
                if(arr1[i][j] == -1) {
                    if(i > 0 && i < arr1.length - 1) {

                        int left = 999999;
                        int right = 999999;

                        if(arr1[i - 1][j] > 0 && arr2[i + 1][j] > 0){
                            left = arr1[i - 1][j] + arr2[i + 1][j] + 1;
                        }
                        if(arr1[i + 1][j] > 0 && arr2[i - 1][j] > 0){
                            right = arr1[i + 1][j] + arr2[i - 1][j] + 1;
                        }

                        solutions.add(Math.min(left, right));
                    }
                    if(j > 0 && j < arr1[0].length - 1) {

                        int left = 999999;
                        int right = 999999;

                        if(arr1[i][j - 1] > 0 && arr2[i][j + 1] > 0){
                            left = arr1[i][j - 1] + arr2[i][j + 1] + 1;

                        }

                        if(arr1[i][j + 1] > 0 && arr2[i][j - 1] > 0){
                            right = arr1[i][j + 1] + arr2[i][j - 1] + 1;

                        }

                        solutions.add(Math.min(left, right));
                    }
                }
            }
        }
    }

    static void findPath(int startX, int startY, int[][] arr){

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int n = arr.length;
        int m = arr[0].length;

        arr[startX][startY] = 1;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(startX, startY));

        while(!queue.isEmpty()) {
            Point current = queue.poll();

            for(int i = 0; i < 4; i++){
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];

                if(isValid(newX, newY, n, m) && arr[newX][newY] == 0) {
                    arr[newX][newY] = arr[current.x][current.y] + 1;
                    queue.offer(new Point(newX, newY));
                }
            }
        }

        int sol = Math.max(arr[startX][startY], arr[n-1][m-1]);

        if(sol != 1) {
            solutions.add(sol);
        }
    }

    static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }



}
