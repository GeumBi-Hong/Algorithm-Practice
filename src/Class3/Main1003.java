package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//피보나치 함수
public class Main1003 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수
        int []dp = new int[41]; //최대 n 40
        dp[0]=0;
        dp[1]=1;

        for( int i =2 ;i <41 ;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        while (T -->0){
            int n = Integer.parseInt(br.readLine());
            if (n==0){
                sb.append("1 0").append("\n");
                continue;
            }
            sb.append(dp[n -1]).append(" ").append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
