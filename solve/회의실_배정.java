import java.util.*;

public class 회의실_배정 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();

        HashMap<Integer, List<Integer>> maps = new HashMap<>();

        for (int i = 0; i < count; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();

            if(maps.containsKey(t)) {
                maps.get(t).add(s);
            }else {
                List<Integer> arr = new ArrayList<>();
                arr.add(s);
                maps.put(t, arr);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(maps.keySet());
        Collections.sort(keys);

        int result = 0;
        int startTime = 0;

        for(int cur : keys) {

            List<Integer> innerList = maps.get(cur);

            for(int i : innerList) {
                if(startTime <= i && i != cur) {
                    startTime = cur;
                    result++;
                    break;
                }
            }

            for (int i : innerList) {
                if(i == cur) {
                    result++;
                    startTime = cur;
                }
            }
        }

        System.out.println(result);
    }

}
