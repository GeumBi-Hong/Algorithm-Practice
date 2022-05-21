package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main18312 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer =0;

        for(int h = 0 ; h<=N;h++){
            for(int m = 0 ; m<60;m++){
                for (int s = 0; s<60;s++){
                    if(h/10==K || h%10==K || m/10==K || m%10==K || s/10==K || s%10==K)  answer++;

                }
            }
        }
        System.out.println(answer);
    }
}
