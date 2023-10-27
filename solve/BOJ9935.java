import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9935 {

    static char[] arr;
    static char[] boom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = br.readLine().toCharArray();
        boom = br.readLine().toCharArray();

        for (int i = 0; i < arr.length; i++) {

            boom(i);
        }

        StringBuilder sb = new StringBuilder();

        for (char c : arr) {
            if (c != 0) sb.append(c);
        }

        if(sb.length() == 0) {
            System.out.println("FLURA");
        } else {
            System.out.println(sb);
        }
    }

    static void boom(int i) {

        if(arr[i] != boom[0]) return;

        if(isBoom(i)) {

            clear(i);

            for (int j = 1; j < boom.length; j++) {
                if(i - j >= 0) boom(i - j);
            }
        }
    }

    static boolean isBoom(int i) {

        int count = 0;
        int idx = i;
        int boomIdx = 0;

        while(count != boom.length) {

            if(idx >= arr.length) break;

            if(arr[idx] == boom[boomIdx]) {
                idx++;
                count++;
                boomIdx++;
            }else if(arr[idx] == 0) {
                idx++;
            }else {
                break;
            }
        }

        return count == boom.length;
    }

    static void clear(int i) {

        int count = 0;
        int idx = i;
        int boomIdx = 0;

        while(count != boom.length) {

            if(arr[idx] == boom[boomIdx]) {
                arr[idx] = 0;
                idx++;
                count++;
                boomIdx++;
            }else {
                idx++;
            }
        }
    }
}
