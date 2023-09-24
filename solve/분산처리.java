import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 분산처리 {
    //https://www.acmicpc.net/problem/1009

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = a % 10;

            System.out.println(cal(a,b));
        }

    }

    static int cal(int a, int b){

        switch (a) {
            case 0:
                return 10;
            case 1:
                return 1;
            case 2:
                List<Integer> list2 = List.of(2, 4, 8, 6);
                int index2 = (b - 1) % 4;
                return list2.get(index2);
            case 3:
                List<Integer> list3 = List.of(3, 9, 7, 1);
                int index3 = (b - 1) % 4;
                return list3.get(index3);
            case 4:
                List<Integer> list4 = List.of(4, 6);
                int index4 = (b - 1) % 2;
                return list4.get(index4);
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                List<Integer> list7 = List.of(7, 9, 3, 1);
                int index7 = (b - 1) % 4;
                return list7.get(index7);
            case 8:
                List<Integer> list8 = List.of(8, 4, 2, 6);
                int index8 = (b - 1) % 4;
                return list8.get(index8);
            case 9:
                List<Integer> list9 = List.of(9, 1);
                int index9 = (b - 1) % 2;
                return list9.get(index9);
        }

        return 0;
    }

}
