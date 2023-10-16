import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class 이진_검색_트리 {
    //https://www.acmicpc.net/problem/5639
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String s = br.readLine();
            if(s == null || s.equals("")) break;
            root.add(Integer.parseInt(s));
        }

        StringBuilder sb = new StringBuilder();

        postOrder(sb, root);

        System.out.println(sb);
    }

    static void postOrder(StringBuilder sb, Node root) {

        if(root == null) return;

        postOrder(sb, root.left);
        postOrder(sb, root.right);
        sb.append(root.value).append('\n');
    }

    static class Node {

        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        void add(int next) {
            if(value > next) {
                if(left == null) left = new Node(next);
                else left.add(next);
            } else if(value < next) {
                if(right == null) right = new Node(next);
                else right.add(next);
            }
        }
    }
}
