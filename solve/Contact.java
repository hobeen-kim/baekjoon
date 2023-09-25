import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Contact {

    //https://www.acmicpc.net/problem/1013

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String t = br.readLine();

            String[] split = t.split("");

            String state = "YES";

            for (int j = 0; j < split.length; j++) {

                if(split[j].equals("0")) {

                    j++;

                    if(j == split.length) {
                        state = "NO";
                        break;
                    }

                    if(!split[j].equals("1")) {

                        state = "NO";
                        break;
                    }
                }
                else {
                    j += 2;

                    if(j >= split.length) {
                        state = "NO";
                        break;
                    }

                    if(!(split[j - 1] + split[j]).equals("00")){
                        state = "NO";
                        break;
                    }

                    while(true) {
                        if(j + 1 < split.length) {
                            if(split[j + 1].equals("0")) {
                                j++;
                            }else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }

                    j++;

                    if(j == split.length) {
                        state = "NO";
                        break;
                    }

                    if(!split[j].equals("1")){
                        state = "NO";
                        break;
                    }

                    while(true) {
                        if(j + 1 < split.length) {
                            if(split[j + 1].equals("1")) {
                                if(j + 3 < split.length) {
                                    if((split[j + 1] + split[j + 2] + split[j + 3]).equals("100")) {
                                        break;
                                    }else{
                                        j++;
                                    }
                                }else{
                                    j++;
                                }
                            }else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }



                }
            }

            System.out.println(state);
        }
    }

}
