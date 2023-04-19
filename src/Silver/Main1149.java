package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1149 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //집의 수

        int[][] rgb = new int[N][3];
        int[][] dp = new int[N][3];


        //입력값 저장
        for(int i = 0 ; i < N ; i++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        //초기값 설정
        dp[0][0]=rgb[0][0];
        dp[0][1]=rgb[0][1];
        dp[0][2]=rgb[0][2];


        for(int i =1; i<N;i++){

            dp[i][0] = rgb[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);  // i자리에 빨강을 칠할 경우 이전에 파랑 혹은 초록 칠한값 중 최소값을 누적하여 저장한다.
            dp[i][1] = rgb[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);  // i자리에 초록을 칠할 경우 이전에 빨강 혹은 파랑 칠한값 중 최소값을 누적하여 저장한다.
            dp[i][2] = rgb[i][2] + Math.min(dp[i-1][1],dp[i-1][0]);  // i자리에 파랑을 칠할 경우 이전에 빨강 혹은 초록 칠한값 중 최소값을 누적하여 저장한다.
        }


        System.out.println(Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2])));
    }
}
