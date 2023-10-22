import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'extractErrorLogs' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts 2D_STRING_ARRAY logs as parameter.
     */

    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {
        // Write your code here
        List<Log> logList = new ArrayList<>();

        for (int i = 0; i < logs.size(); i++) {
            Log newLog = new Log();
            newLog.index = i;

            String date = logs.get(i).get(0) + " " + logs.get(i).get(1);
            newLog.date = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
            newLog.status = logs.get(i).get(2);
            newLog.message = logs.get(i).get(3);
            logList.add(newLog);
        }

        List<List<String>> list = logList.stream()
                .filter(log -> log.status.equals("ERROR") || log.status.equals("CRITICAL"))
                .sorted(Comparator.comparing(Log::getDate).thenComparing(Log::getIndex))
                .map(Log::toList)
                .collect(toList());

        return list;
    }
}

class Log {
    int index;
    LocalDateTime date;
    String status;
    String message;

    public int getIndex() {
        return index;
    }

    public LocalDateTime getDate() {
        return date;
    }

    List<String> toList() {
        List<String> list = new ArrayList<>();
        list.add(date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        list.add(date.format(DateTimeFormatter.ofPattern("HH:mm")));
        list.add(status);
        list.add(message);
        return list;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int logsRows = Integer.parseInt(bufferedReader.readLine().trim());
        int logsColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> logs = new ArrayList<>();

        IntStream.range(0, logsRows).forEach(i -> {
            try {
                logs.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<List<String>> result = Result.extractErrorLogs(logs);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
