import java.util.Scanner;

public class 잃어버린_괄호 {
    //https://www.acmicpc.net/problem/1541

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        String[] split = s.split("-");

        String[] nums = split[0].split("\\+");
        int sumLeft = 0;
        for(String num : nums) {
            sumLeft += Integer.valueOf(num);
        }

        if(split.length == 1) {
            System.out.println(sumLeft);
        }else {
            int sumRight = 0;
            for(int i = 1; i < split.length; i++) {
                for(String num : split[i].split("\\+")){
                    sumRight += Integer.valueOf(num);
                }
            }
            System.out.println(sumLeft - sumRight);
        }
    }
}
