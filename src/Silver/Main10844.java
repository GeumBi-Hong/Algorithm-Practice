package Silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 쉬운 계단 수
 *
 * [문제풀이]
 * - 자리수에 뭐가 오냐에 따라 경우의 수가 다름
 * - 따라서 dp[몇자리][무슨 수]를 가지고 계속 누적해서 값을 더한다.
 */
public class Main10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] dp = new long[n + 1][10];

        long mod = 1_000_000_000;

        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                //끝자리가 0인 경우는 1만 가능
                if (j == 0)
                    dp[i][j] = (dp[i - 1][j + 1]) % mod;
                    //끝자리가 9인경우는 8만 가능
                else if (j == 9)
                    dp[i][j] = (dp[i - 1][j - 1]) % mod;
                    //끝자리가 2~8인 경우는 -1 +1 둘다 가능
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;

            }
        }

        // 몇개있는지 합
        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % mod);


    }
}
