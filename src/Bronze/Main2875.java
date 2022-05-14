package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2875 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int W = Integer.parseInt(st.nextToken()); // 여
        int M = Integer.parseInt(st.nextToken()); //남
        int K = Integer.parseInt(st.nextToken());

        int count = 0;


        for(int i=1; i<=M;i++){
            W-=2;
            if(W>=0 && (M-i)+W>=K){
                count++;
            }
        }

        System.out.println(count);
    }
}
