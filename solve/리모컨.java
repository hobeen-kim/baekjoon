import java.util.Scanner;

public class 리모컨 {
    //https://www.acmicpc.net/problem/1107

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ch = sc.nextInt();
        int malCount = sc.nextInt();

        String[] malStr = new String[malCount];

        for(int i = 0; i < malCount; i++) {

            int n = sc.nextInt();

            malStr[i] = String.valueOf(n);
        }
        if(ch == 100) {
            System.out.println(0);
        }
        else if(malStr.length == 10) {
            System.out.println(Math.abs(ch - 100));
        }
        else{

            int minusCh = ch;
            int minusCount = 0;
            boolean minusFind = false;

            while(true) {

                if(minusCh == -1) break;

                String minusChStr = String.valueOf(minusCh);

                boolean hasMal = false;

                for(String mal : malStr) {
                    if(minusChStr.contains(mal)) {
                        hasMal = true;
                        break;
                    }
                }

                if(!hasMal) {
                    minusFind = true;
                    break;
                }

                minusCh--;
                minusCount++;
            }

            minusCount += String.valueOf(minusCh).length();
            if(!minusFind) minusCount = 99999999;

            int plusCh = ch;
            int plusCount = 0;
            boolean plusFind = false;

            while(true) {

                if(plusCh == 1000000) break;

                String plusChStr = String.valueOf(plusCh);

                boolean hasMal = false;

                for(String mal : malStr) {
                    if(plusChStr.contains(mal)) {
                        hasMal = true;
                        break;
                    }
                }

                if(!hasMal) {
                    plusFind = true;
                    break;
                }

                plusCh++;
                plusCount++;
            }

            plusCount += String.valueOf(plusCh).length();
            if(!plusFind) plusCount = 99999999;

            int c = Math.min(Math.min(minusCount, plusCount), Math.abs(ch - 100));
            System.out.println(c);

        }
    }
}
