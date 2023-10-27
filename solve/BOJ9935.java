import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935 {

    static char[] arr;
    static char[] stack;
    static char[] boom;
    static int pointer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        boom = br.readLine().toCharArray();
        stack = new char[arr.length];

        for (int i = 0; i < arr.length; i++) {

            stack[pointer++] = arr[i];

            if(arr[i] == boom[boom.length - 1] && pointer >= boom.length) {
                checkAndBoom();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < pointer; i++) {
            sb.append(stack[i]);
        }

        if(sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }

    }

    private static void checkAndBoom() {

        for (int i = 0; i < boom.length; i++) {

            if(stack[pointer - i - 1] != boom[boom.length - i - 1]) return;
        }

        pointer -= boom.length;
    }
}
