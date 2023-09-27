import java.awt.image.AreaAveragingScaleFilter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 수열_정렬 {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        int[] arr = new int[tc];
        int[] solution = new int[tc];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < tc; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        int index = 0;

        for(int i = 1; i <= 1000; i++) {
            for(int j = 0; j < tc; j++) {
                if(arr[j] == i){
                    solution[j] = index++;
                }
            }
        }

        for(int i : solution) {
            System.out.print(i);
            System.out.print(" ");
        }
    }

}
