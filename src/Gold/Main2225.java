package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 합분해
 *
 * [문제풀이]
 * 큰 문제를 작은 문제 단위로...
 * 뭐가 큰문제고 뭐가 작은 문제 인가.
 *
 *
 * 0부터 20까지의 정수 K개를 더해서 합이 N이 되는 경우
 * 덧셈 순서 바뀐 경우도 다른 경우로 세고, 한 개의 수는 여러개로 쓸 수 있다.
 *
 * k 가 3이고 N이 5라고 치자.
 *
 *
 * 5를 만들기 위해 0(1번) + 5(2번 더해서 만드는 경우) -> dp[2][5]
 * 5를 만들기 위해 1(1번) + 4(2번 더해서 만드는 경우) -> dp[2][4]
 * 5를 만들기 위해 2(1번) + 3(2번 더해서 만드는 경우) -> dp[2][3]
 * 5를 만들기 위해 3(1번) + 2(2번 더해서 만드는 경우) -> dp[2][2]
 * 5를 만들기 위해 4(1번) + 1(2번 더해서 만드는 경우) -> dp[2][1]
 * 5를 만들기 위해 5(1번) + 0(2번 더해서 만드는 경우) -> dp[2][0]
 *
 * dp[k][n] = dp[k-1][0] ... dp[k-1][5]
 * dp[3][5] = dp[2][0] ......dp[2][5]
 * dp [2][0] +...dp[2][N-1 즉4는] dp[3][4]와 같다.
 *
 * 그러니 dp[3][5]는 = dp[3][4] + dp[2][5] 인 것이다.
 *
 * 그러면 또 여기서 5를 2번으로 만드는 경우는 또
 * 5를 만들기 위해 0(1번) + 5(1번 ...)
 * 5를 만들기 위해 1(1번) + 4(1번 ...)
 * 5를 만들기 위해 2(1번) + 3(1번 ...)
 * 5를 만들기 위해 3(1번) + 2(1번 ...)
 * 5를 만들기 위해 4(1번) + 1(1번 ...)
 * 5를 만들기 위해 5(1번) + 0(1번 ...)
 *
 *
 * 5를 또 1번으로 만드는 경우
 *  5를 만들기 위해 5(1번)
 *
 */
public class Main2225 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        final int mod = 1_000_000_000;

        //dp[K (사용한 정수 개수)][합]
        int[][]dp = new int[K + 1][N + 1];


        //[초기화]
        for(int i = 0; i <= K; i++){
            dp[i][0] = 1;
        }

        for(int k = 1; k <= K;k++){ //k는 1부터니까
            for(int n = 1 ; n <= N; n++){

                dp[k][n] = (dp[k-1][n]+ dp[k][n-1]) % mod;
            }
        }

        //(A + B) % N = ((A % N) + (B % N)) % N
        //큰 수의 합을 구하는 동적 계획법  알고리즘을 구현할 때,
        // 계산 중간에 수가 매우 큰 값을 가지거나
        // 오버플로우(overflow) 문제가 발생할 수 있다.
        //dp[k][n] = (dp[k-1][n] + dp[k][n-1]) % mod
        System.out.println(dp[K][N] % mod);

    }
}
