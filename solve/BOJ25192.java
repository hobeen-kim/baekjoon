import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class BOJ25192 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int recordCount;
    static HashSet<String> record = new HashSet<>();

    public static void main(String[] args) throws IOException {
        int result = 0;

        recordCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < recordCount; i++) {

            String chat = br.readLine();

            if(chat.equals("ENTER")) {
                record.clear();
                continue;
            }

            //이미 인사했다면 다음으로~
            if(record.contains(chat)) continue;

            //그렇지 않다면 ++
            result++;
            record.add(chat);
        }

        System.out.println(result);
    }
}
