package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**Four Squares
 *
 *1 -> 1^2 : 1개
 * 2 -> 1^2 + 1^2 : 2
 * 3 -> 1^2 + 1^2 + 1^2  3
 * 4 -> 2^2 -> 1
 * 5 -> 2^2 + 1^2 -> 2
 * 6 -> 2^2 + 1^2 + 1^2 -> 3
 * 7 -> 2^2 + 1^2 + 1^2 + 1^2 -> 4
 * 8 -> 2^2 + 2^2 -> 2
 * 9 -> 3^3 -> 1
 *https://comain.tistory.com/306
 *
 */
public class Main17626 {

    static int[] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        D_Programming(n);

        System.out.println(dp[n]);
    }

    static void D_Programming(int n) {
        for (int i = 2; i <= n; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = 1; j * j <= i; j++) {

                min = Math.min(min, dp[i - j * j]);
            }
            dp[i] = min + 1;
        }
    }
}
