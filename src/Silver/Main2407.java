package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


/**
 * 조합
 *
 * nCr = n-1 C r + n-1 C r-1
 *
 * long 범위를 넘기나 보군요...
 * 100 C 50 할때  100891344545564193334812497256 가 나와야한다고 합니다.
 */
public class Main2407 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger[][] dp = new BigInteger[101][101];

        dp[0][0] = new BigInteger("1");

        for(int i = 1 ; i <= 100; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) dp[i][j] = new BigInteger("1");
                else{
                    dp[i][j] = dp[i-1][j-1].add(dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[n][m]);

    }
}
