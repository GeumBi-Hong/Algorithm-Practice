package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 스티커
 *
 * [문제풀이]
 *
 * 스티커를 때면 상하좌우로 영향이 간다. 그래서 내가 현재 스티커를 땟을때 이전에 땐다고하면
 * 이전에 땐 값의 최대를 항상 갱신해서 값을 누적해야한다.
 *
 * 예를 들어 내가 3열의 위의 스티커를 때려고 한다.
 * 그렇다고 하면 2열의 스티커를 땐 상태이거나 이전에 1열의 위 스티커를 때거나 아래열의 스티커를 땐 경우를 고려할 수 있다.
 * 위의 예시의 경우는 1열의 아래만 고려하면되는데, 왜 1열의 위는 고려안해도되냐?
 * 이미 2열의 아래를 때는 경우에서 1열의 위를 때는 경우를 고려했기때문이다.
 */
public class Main9465 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        while(T --> 0){

            int n = Integer.parseInt(br.readLine());

            int[][] num = new int[2][n+1];

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for(int i = 1; i <= n ; i++){


                num[0][i] = Integer.parseInt(st1.nextToken());
                num[1][i] = Integer.parseInt(st2.nextToken());
            }

            int[][] dp = new int[2][n +1];
            dp[0][1] = num[0][1];
            dp[1][1] = num[1][1];

            for(int i = 2 ; i <= n ; i++){
                //위의 스티커를 때는 경우는 왼쪽 아래 스티커 / 왼쪽 오른쪽 아래 스티커를 비교한다.
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + num[0][i];
                //아래 스티커를 때는 경우는  왼쪽 스티커 / 왼쪽 왼쪽 위 스티커를 비교한다.
                dp[1][i] = Math.max(dp[0][i- 1], dp[0][i - 2]) + num[1][i];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }

    }
}
