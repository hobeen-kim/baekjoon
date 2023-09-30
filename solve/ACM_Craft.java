import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ACM_Craft {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int buildingCount = Integer.parseInt(st.nextToken());
            int ruleCount = Integer.parseInt(st.nextToken());

            HashMap<Integer, Building> buildings = new HashMap<>();

            st = new StringTokenizer(br.readLine(), " ");

            for (int b = 1; b <= buildingCount; b++) {
                buildings.put(b, new Building(Integer.parseInt(st.nextToken())));
            }

            for (int r = 0; r < ruleCount; r++) {
                st = new StringTokenizer(br.readLine(), " ");
                int prevBuilding = Integer.parseInt(st.nextToken());
                int nextBuilding = Integer.parseInt(st.nextToken());

                buildings.get(nextBuilding).add(buildings.get(prevBuilding));
            }

            Building winBuilding = buildings.get(Integer.parseInt(br.readLine()));
            System.out.println(calculate(winBuilding));
        }
    }

    static int calculate(Building building) {
        if(building.prev.size() == 0) {
            building.value = building.time;

        } else if(building.value == -1) {

            int max = Integer.MIN_VALUE;

            for (Building prev : building.prev) {
                if(prev.value == -1) {
                    calculate(prev);
                }
                max = Math.max(max, prev.value);
            }

            building.value = building.time + max;
        }

        return building.value;
    }

    static class Building {
        int time;
        ArrayList<Building> prev;
        int value;

        void add(Building building) {
            prev.add(building);
        }

        Building(int time) {
            this.time = time;
            this.prev = new ArrayList<>();
            value = -1;
        }
    }

}