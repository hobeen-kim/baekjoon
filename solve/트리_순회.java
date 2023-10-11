import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class 트리_순회 {
    //https://www.acmicpc.net/problem/1991
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        HashMap<String, Node> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            char c = (char) ('A' + i);

            map.put(String.valueOf(c), new Node(c));
        }

        for (int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node node = map.get(root);

            if(!left.equals(".")) {
                node.setLeft(map.get(left));
            }

            if(!right.equals(".")) {
                node.setRight(map.get(right));
            }
        }

        StringBuilder sb = new StringBuilder();

        preorder(map.get("A"), sb);
        sb.append('\n');
        inorder(map.get("A"), sb);
        sb.append('\n');
        postorder(map.get("A"), sb);

        System.out.println(sb);
    }

    static void preorder(Node root, StringBuilder sb) {

        if(root == null) return;

        sb.append(root.num);
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    static void inorder(Node root, StringBuilder sb) {

        if(root == null) return;

        inorder(root.left, sb);
        sb.append(root.num);
        inorder(root.right, sb);
    }

    static void postorder(Node root, StringBuilder sb) {

        if(root == null) return;

        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.num);
    }

    static class Node {

        char num;
        Node left;
        Node right;

        Node(char num) {
            this.num = num;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        void setRight(Node right) {
            this.right = right;
        }


    }
}
