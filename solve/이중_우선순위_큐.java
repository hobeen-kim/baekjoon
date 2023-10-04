import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 이중_우선순위_큐 {

    static class Node {
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static int T,K;
    static PriorityQueue<Node> minHeap;
    static PriorityQueue<Node> maxHeap;
    static ArrayList<Boolean> deleted;
    static long min = Long.MIN_VALUE;
    static long max = Long.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++) {
            K = Integer.parseInt(br.readLine());
            int tempIndex = 0;
            deleted = new ArrayList<>();
            boolean isAllDeleted = true;

            minHeap = new PriorityQueue<>((node1, node2) -> {
                if(node1.value  > node2.value) return 1;
                else return -1;
            });

            maxHeap = new PriorityQueue<>((node1, node2) -> {
                if(node2.value  > node1.value) return 1;
                else return -1;
            });

            for(int j=0; j<K; j++) {
                String[] commandInfo = br.readLine().split(" ");
                if(commandInfo[0].equals("I")) {
                    minHeap.offer(new Node(tempIndex, Integer.parseInt(commandInfo[1])));
                    maxHeap.offer(new Node(tempIndex, Integer.parseInt(commandInfo[1])));
                    deleted.add(false);
                    tempIndex+=1;
                }
                else {
                    if(commandInfo[1].equals("1")) {    // 최댓값 삭제
                        while(!maxHeap.isEmpty()) {
                            Node deleteTarget = maxHeap.poll();

                            if(!deleted.get(deleteTarget.index)) {
                                deleted.set(deleteTarget.index, true);
                                break;
                            }
                        }
                    }
                    else {  // 최솟값 삭제
                        while(!minHeap.isEmpty()) {
                            Node deleteTarget = minHeap.poll();

                            if(!deleted.get(deleteTarget.index)) {
                                deleted.set(deleteTarget.index, true);
                                break;
                            }
                        }
                    }
                }
            }

            while(!minHeap.isEmpty()) {
                Node answer = minHeap.poll();
                if(!deleted.get(answer.index)) {
                    min = answer.value;
                    isAllDeleted = false;
                    break;
                }
            }

            while(!maxHeap.isEmpty()) {
                Node answer = maxHeap.poll();
                if(!deleted.get(answer.index)) {
                    max = answer.value;
                    isAllDeleted = false;
                    break;
                }
            }

            if(isAllDeleted) {
                bw.write("EMPTY" + "\n");
            }
            else {
                if(max == Long.MAX_VALUE || min == Long.MIN_VALUE) {
                    if(max == Long.MAX_VALUE) {
                        max = min;
                    }
                    else {
                        min = max;
                    }
                }
                bw.write(String.valueOf(max) + " " + String.valueOf(min) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
