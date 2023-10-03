import java.util.Scanner;

public class 절대값_힙 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Heap heap = new Heap(n);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();

            if(x == 0) sb.append(heap.remove()).append('\n');
            else heap.add(x);
        }

        System.out.println(sb);
    }

    static class Heap {
        int[] arr;
        int point = -1;

        Heap(int num) {
            arr = new int[num];
        }

        int remove() {
            if(point == -1) return 0;
            if(point == 0) {
                int temp = arr[point--];
                arr[0] = 0;
                return temp;
            }

            int temp = arr[0];

            arr[0] = arr[point--];
            arr[point + 1] = 0;

            percolateDown(0, point);

            return temp;
        }

        void add(int value) {
            arr[++point]  = value;

            if(point > 0) {
                percolateUp(point);
            }
        }

        void percolateDown(int s, int e) {

            int left = s * 2 + 1;
            int right = s * 2 + 2;

            int target = left;

            if(left <= e) {
                if(right <= e) {
                    if(abs(arr[left]) > abs(arr[right])) {
                        target = right;
                    } else if(abs(arr[left]) == abs(arr[right])) {
                        if(arr[left] > arr[right]) {
                            target = right;
                        }
                    }
                }
                if(abs(arr[s]) > abs(arr[target])) {
                    int temp = arr[s];
                    arr[s] = arr[target];
                    arr[target] = temp;

                    percolateDown(target, e);
                }
                if(abs(arr[s]) == abs(arr[target])) {
                    if(arr[s] > arr[target]) {
                        int temp = arr[s];
                        arr[s] = arr[target];
                        arr[target] = temp;

                        percolateDown(target, e);
                    }

                }
            }
        }

        void percolateUp(int point) {

            if(point < 1) {
                return;
            }

            int parent = (point - 1) / 2;

            if(abs(arr[point]) == abs(arr[parent])) {
                if(arr[point] < arr[parent]) {
                    int temp = arr[point];
                    arr[point] = arr[parent];
                    arr[parent] = temp;

                    percolateUp(parent);
                }
            }
            if(abs(arr[point]) < abs(arr[parent])) {
                int temp = arr[point];
                arr[point] = arr[parent];
                arr[parent] = temp;

                percolateUp(parent);
            }
        }

        int abs(int value) {
            return Math.abs(value);
        }

    }
}
