package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int [] prefix = new int[N+1];

        st = new StringTokenizer(br.readLine()," ");
        for(int i =1 ; i<=N;i++){
            int n = Integer.parseInt(st.nextToken());
            prefix[i]=prefix[i-1]+n;
        }

        int answer = Integer.MIN_VALUE; //최대 온도


        for(int i=N; i-K>=0;i--){

            answer= Math.max(answer,prefix[i]-prefix[i-K]);
        }


        System.out.println(answer);
    }
}
