import java.util.Scanner;

public class 후위_표기식 {
    //https://www.acmicpc.net/problem/1918
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String q = sc.nextLine();

        Node rootNode = createNode(q);

        StringBuilder sb = new StringBuilder();

        postorder(rootNode, sb);

        System.out.println(sb);

    }

    static Node createNode(String q) {

        while(hasEmptyBracket(q)) {
            q = q.substring(1, q.length() - 1);
        }

        if(q.length() == 1) return new Node(q, null, null);

        int rootIndex = findRoot(q);

        String left = q.substring(0, rootIndex);
        String right = q.substring(rootIndex + 1);

        return new Node(q.substring(rootIndex, rootIndex + 1), createNode(left), createNode(right));

    }

    private static boolean hasEmptyBracket(String q) {

        if(!q.startsWith("(") || !q.endsWith(")")) return false;

        char[] cArr = q.toCharArray();

        int depth = 1;

        for (int i = 1; i < cArr.length - 1; i++) {
            if(cArr[i] == '(') depth++;
            else if(cArr[i] == ')') depth--;
            if(depth == 0) return false;
        }

        return true;
    }

    static int findRoot(String q) {

        int curDepth = 0;
        char[] cArr = q.toCharArray();

        int indexDepth = Integer.MAX_VALUE;
        char indexValue = 0;
        int index = 0;

        for (int i = 0; i < cArr.length; i++) {
            if(cArr[i] == '(') curDepth++;
            else if(cArr[i] == ')') curDepth--;
            else {
                if(cArr[i] == '+' || cArr[i] == '-') {
                    if(curDepth <= indexDepth) {
                        indexDepth = curDepth;
                        index = i;
                        indexValue = cArr[i];
                    }
                }
                else if(cArr[i] == '/' || cArr[i] == '*') {
                    if(curDepth == indexDepth) {
                        if(indexValue == '/' || indexValue == '*') {
                            index = i;
                            indexValue = cArr[i];
                        }
                    }else if(curDepth < indexDepth) {
                        indexDepth = curDepth;
                        index = i;
                        indexValue = cArr[i];
                    }
                }
            }
        }

        return index;
    }

    static void postorder(Node rootNode, StringBuilder sb) {

        if(rootNode == null) return;

        postorder(rootNode.left, sb);
        postorder(rootNode.right, sb);
        sb.append(rootNode.value);
    }

    static class Node {

        String value;
        Node left;
        Node right;

        Node(String value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
