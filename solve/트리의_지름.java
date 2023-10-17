import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의_지름 {
    //https://www.acmicpc.net/problem/1967
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());

        HashMap<Integer, Vertex> map = new HashMap<>();

        map.put(1, new Vertex(null, 0));

        for (int i = 0; i < v - 1; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(!map.containsKey(parent)) {
                map.put(parent, new Vertex(null, 0));
            }

            Vertex parentV = map.get(parent);

            if(!map.containsKey(child)) {
                map.put(child, new Vertex(parentV, value));
            }
            Vertex childV = map.get(child);

            if(childV.value == 0) childV.value = value;

            if(childV.parent == null) childV.parent = parentV;

            parentV.addChild(childV);
        }

        int max = findMax(map.get(1), 0);

        System.out.println(max);
    }

    private static int findMax(Vertex vertex, int criteria) {

        if(vertex.children.size() == 0) {
            return 0;
        }

        if(vertex.children.size() == 1) {
            int max = vertex.max;
            int childMax = findMax(vertex.children.get(0), max);

            return Math.max(max, childMax);
        }

        int max = -1;
        Vertex maxV = new Vertex();

        int second = -1;
        Vertex secondV = new Vertex();

        for (Vertex child : vertex.children) {
            if(max < child.value + child.max) {
                max = child.value + child.max;
                maxV = child;
            }
        }

        for (Vertex child : vertex.children) {
            if(second < child.value + child.max && !child.equals(maxV)) {
                second = child.value + child.max;
                secondV = child;
            }
        }

        int result = max + second;

        if(criteria < result) {
            int left = findMax(maxV, result);
            int right = findMax(secondV, result);

            result = Math.max(result, Math.max(left, right));
        }

        return result;
    }

    static class Vertex {
        Vertex parent;
        List<Vertex> children = new ArrayList<>();
        int value;
        int max = 0;

        Vertex() {}

        Vertex(Vertex parent, int value) {
            this.parent = parent;
            this.value = value;
        }

        void addChild(Vertex child) {
            children.add(child);
            percolateUp();
        }

        void percolateUp() {
            for (Vertex child : children) {
                max = Math.max(max, child.value + child.max);
            }
            if(parent != null) {
                parent.percolateUp();
            }
        }


    }
}
