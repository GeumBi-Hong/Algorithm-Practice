package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19532 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int [] num = new int[6];

        for(int i = 0 ; i <6; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int a= num[0];
        int b = num[1];
        int c = num[2];
        int d =num[3];
        int e =num[4];
        int f = num[5];


        for(int x = -999 ; x <=999;x++){
            for(int y=-999; y<=999;y++){
                if(a*x+b*y==c && d*x+e*y==f) System.out.println(x+" "+y);
            }
        }
    }
}
