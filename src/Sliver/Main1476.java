package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//날짜계산
public class Main1476 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int time = 1;

        int e =1;
        int s=1;
        int m=1;
        while (true){

            if(E==e && S==s && M==m){
                break;
            }

            e++;
            s++;
            m++;
            if(e==16){
                e=1;
            }

            if(s==29){
                s=1;
            }

            if(m==20){
                m=1;
            }
            time++;

        }
        System.out.print(time);

    }
}
