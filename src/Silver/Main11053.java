package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 가장 긴 증가하는 부분 수열
 */
public class Main11053 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []num = new int[N+1];
        int [] dp = new int[N+1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1 ;  i <=N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }


        int count = N;

        dp[1]=num[1];


        for(int i =2; i<=N;i++){
            if(num[i]<dp[i-1]){
                count--;
                dp[i]=dp[i-1];
            }
            else if (num[i]>=dp[i-1]){
                dp[i]=num[i];
            }

        }


        System.out.println(count);
    }
}

