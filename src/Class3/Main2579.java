package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//계단오르기 (다이나믹 프로그래밍)
public class Main2579 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine()); //계단 개수
       int[] array = new int[N+1];
       int[] dp = new int[N+1];

        for(int i = 1 ; i <N+1;i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        dp[0]=0; //0
        dp[1]=array[1]; // 10
        if(N!=1) {
            dp[2] = array[1] + array[2]; //30
        }
        for(int i=3; i< N+1;i++){
            dp[i]= array[i]+ Math.max(array[i-1]+dp[i-3],dp[i-2]);
        }


         System.out.println(dp[N]);


    }

}
