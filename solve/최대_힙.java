import java.util.Scanner;

public class 최대_힙 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Heap heap = new Heap(n);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            if(x == 0) {
                int remove = heap.remove();
                sb.append(remove).append('\n');
            }else {
                heap.add(x);
            }
        }

        System.out.println(sb);


    }
    static class Heap {

        int[] arr;
        int point = -1;

        Heap(int num) {
            arr = new int[num];
        }

        void add(int value) {
            arr[++point] = value;

            percolateUp(point);
        }

        int remove() {
            if(point < 0) return 0;
            if(point == 0) return arr[point--];

            int max = arr[0];

            arr[0] = arr[point--];

            percolateDown(0, point);

            return max;
        }

        void percolateUp(int point) {

            if(point < 1) return;

            int parent = (point - 1) / 2;

            if(arr[parent] < arr[point]) {
                int temp = arr[point];
                arr[point] = arr[parent];
                arr[parent] = temp;
                percolateUp(parent);
            }
        }

        void percolateDown(int s, int e) {

            int left = s * 2 + 1;
            int right = s * 2 + 2;

            int target = left;

            if(point >= left) {
                if(point >= right && arr[right] >= arr[left]) {
                    target = right;
                }
                if(arr[s] < arr[target]) {
                    int temp = arr[s];
                    arr[s] = arr[target];
                    arr[target] = temp;

                    percolateDown(target, e);
                }
            }

        }


    }

}
