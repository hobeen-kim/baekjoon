import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중_우선순위_큐 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            int n = Integer.parseInt(br.readLine());

            DupQueue queue = new DupQueue();

            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String func = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(func.equals("I")) {
                    queue.add(num);
                } else {
                    if(num == -1) {
                        queue.pollLeft();
                    }else {
                        queue.pollRight();
                    }
                }
            }

            if(queue.left >= queue.right) System.out.println("EMPTY");
            else {
                System.out.print(queue.arr[queue.right]);
                System.out.print(" ");
                System.out.print(queue.arr[queue.left + 1]);
            }
        }
    }

//    static class Node {
//
//        int value;
//        Node nextNode;
//
//        Node(int value) {
//            this.value = value;
//        }
//
//        void setNextNode(Node nextNode) {
//            this.nextNode = nextNode;
//        }
//
//
//    }


    static class DupQueue {

        int[] arr = new int[1000000];
        int left = -1;
        int right = -1;

        void add(int num){
            arr[++right] = num;
            sort();
        }

        void pollLeft() {
            if(left >= right) {
                return;
            }
           left++;
        }

        void pollRight() {
            if(left >= right) {
                return;
            }
            right--;
        }

        void sort() {
            int target = arr[right];
            int low = left + 1, high = right - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] < target) {
                    low = mid + 1;
                } else if (arr[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;  // Optional: choose to insert after duplicates
                }
            }

            // Shift elements to make space for the target
            for (int i = right; i > low; i--) {
                arr[i] = arr[i - 1];
            }
            arr[low] = target;
        }

    }
}
