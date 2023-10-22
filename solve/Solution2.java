import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result2 {

    /*
     * Complete the 'findMaximumGreatness' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int findMaximumGreatness(List<Integer> arr) {
        // Write your code here
        //int[] 로 변경
        int[] arr2 = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            arr2[i] = arr.get(i);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            if(map.containsKey(arr2[i])) {
                map.put(arr2[i], map.get(arr2[i]) + 1);
            }else {
                map.put(arr2[i], 1);
            }
        }

        //정렬
        Arrays.sort(arr2);

        int min = arr2[0];
        int count = map.get(min);
        int result = 0;

        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i] > min) {
                if(count > 0) {
                    result++;
                    count--;
                    if (count == 0) {
                        min = nextMin(arr2, min);
                        count = map.get(min);
                    }
                }
            }
        }

        return result;
    }

    static int nextMin(int[] arr, int min) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > min) {
                return arr[i];
            }
        }
        return 0;
    }

}

public class Solution2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result2.findMaximumGreatness(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
