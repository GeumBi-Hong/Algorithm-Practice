package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1182 {
    static int N ,S ;
    static int []num;
    static int [] answer ;
    static int count = 0 ;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        num = new int[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0 ; i <N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }


        backTracking(0,0,0);
        System.out.println(count);
    }


    private  static  void backTracking (int depth ,int start, int sum){

        if(depth ==N){
            return;
        }

        for(int i = start; i <N;i++){

            sum += num[i];
            if(sum==S)count++;
            backTracking(depth+1,i+1,sum);

            sum-=num[i];

        }
    }
}
