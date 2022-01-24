package Class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2xn 타일링 2 다이나믹 프로그래밍 풀이
public class Main11727 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());

        int []dp = new int[1001];

        dp[1]=1;
        dp[2]=3;

        for (int i = 3 ; i <1001;i++){
            dp[i]= dp[i-1]+(2*dp[i-2]) %10007; //점화식
        }

        System.out.print(dp[n]);
    }
}
