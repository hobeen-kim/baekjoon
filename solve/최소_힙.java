import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class 최소_힙 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Heap heap = new Heap();

        for (int i = 0; i < tc; i++) {

            int x = Integer.parseInt(br.readLine());

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

        int[] arr = new int[100000];
        int size = 0;

        void add(int value) {
            arr[size++] = value;
            percolateUp(size - 1);
        }

        void percolateUp(int location) {

            int parent = (location - 1) / 2;

            if(arr[location] < arr[parent]) {
                int temp = arr[location];
                arr[location] = arr[parent];
                arr[parent] = temp;

                percolateUp(parent);
            }
        }

        int remove() {

            int removedValue;

            if(size == 0) {
                removedValue = 0;
            }else {
                removedValue = arr[0];
                arr[0] = arr[--size];
                percolateDown(0, size - 1);
            }
            return removedValue;
        }

        void percolateDown(int from, int to) {

            int left = from * 2 + 1;
            int right = from * 2 + 2;

            int targetChild = left;

            if(left <= to) {
                if(right <= to && arr[left] > arr[right]) {
                    targetChild = right;
                }
                if(arr[from] > arr[targetChild]) {
                    int temp = arr[targetChild];
                    arr[targetChild] = arr[from];
                    arr[from] = temp;
                    percolateDown(targetChild, to);
                }
            }
        }

    }
}
