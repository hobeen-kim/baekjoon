import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class BOJ26069 {

    static HashSet<String> dancingName = new HashSet<>(List.of("ChongChong"));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] meets = br.readLine().split(" ");

            String name1 = meets[0];
            String name2 = meets[1];

            if(dancingName.contains(name1)) dancingName.add(name2);
            if(dancingName.contains(name2)) dancingName.add(name1);
        }

        System.out.println(dancingName.size());
    }
}
