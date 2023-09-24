import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fly_me_to_the_Alpha_Centauri {
    //https://www.acmicpc.net/problem/1011
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        //1 2 2 1
        //딱 절반이다 -> x 2
        //절반은 아닌데 다음으로써 절반을 넘는다
        ////정점을 더하고 왼쪽걸 더해서 distance 가 나오는 경우
        ////정점+1 을 더하고 왼쪽걸 더해서 distance 가 나오는 경우
        ///정점+1 을 더하고 왼쪽걸 더해도 distance 가 안나오는 경우 -> +1
        //1 2 2 2 1 = 8  -> 지속 -> 4
        //1 2 3 2 1 = 9 -> 4.5
        //절반을 넘었다 -> 감속
        //1 2 2 2 2 1 -> 10 ->
        //1 2 3 2 2 1 -> 11
        //1 2 3 3 2 1 -> 12
        //1 2 3 3 2 1 1 -> 13

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int totalDistance = end - start;

            int num = beforeHalf(totalDistance);
            long current = num * (num + 1) / 2;
            long speed = num;
            int count = num;

            if(current * 2 == totalDistance) {
                count *= 2;
            }

            else {
                if(current * 2 + speed + 1 >= totalDistance) {
                    count = count * 2 + 1;
                }else{
                    count = count * 2 + 2;
                }
            }

            System.out.println(count);
        }
    }

    static int beforeHalf(double num){

        return (int) (Math.sqrt((num) + 0.25) - 0.5);
    }
}
