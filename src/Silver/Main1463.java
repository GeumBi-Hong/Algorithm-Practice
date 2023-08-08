package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 1로 만들기 (148ms)
 *
 * [문제조건]
 * 1 <= N  <= 10&6
 *
 * 1 ->  0
 * 2 -> 2로 나누기 1
 * 3 -> 3으로 나누기 1
 * 4 -> 2로 나누기 2로 나누기 2
 * 5는 -> 1빼고 2나누고 2나누고 -> 3
 * 6 -> 3나누고 2나누고 -> 2
 * 7 -> 1 + 3  2 =>3
 * 8 ->  2 2 2 -> 3
 * 9 -> 3 3 ->2
 * 10 -> 1 3  3 -> 3
 *
 * 먼가 .... 규칙은 없는데
 *
 * [풀이과정]
 * 문제 예시와 같이 10의 경우를 보면
 *
 * - 10 을 먼저 2로 나누는 경우는 4번해야하고
 * 10 5 4 2 1 일꺼고
 * - 10에서 1을 먼저뺴는 경우는 3번해야한다.
 * 10 9 3 1 일꺼다.
 *
 *
 * 즉 3과 2로 나눌 수 있기 전에 1을 뺀 경우를 먼저 해보고
 * 그 이후로 3 또는 2로 나누었을때를 비교하여 최솟값을 갱신한다.
 *
 *
 * dp를 이용하는 이유는
 *
 * 우리가 예를 들어서
 * 9라는 숫자가 있다. 9는
 *
 * 9  -> 3 -> 1 : 이렇게 하면 3부터 또 나눌 필요없이 3에서 나누었던 방법의 최소연산 수만 알면 그걸 이용해서 구하면됨
 * 9 -> 8 -> 4- > 2 -> 1  : 여기도 마찬가지로 8을 계속 2로 나눌 필요 없이 이전에 8의 최소 연산수를 미리 저장해놓으면 그냥 쓰면 되는구조
 * 그렇게 젤 중요한건 처음에 3으로 나눌꺼냐 2로 나눌꺼냐 1로 뺄꺼냐 인거
 * 그래서 이 연산은 단순히 연산수 +1이니까  위의 연산을 한 수에 그 다음 수는 기존에 구해놨던 값을 이용하여 풀이 -> dp
 */
public class Main1463 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[]dp = new int[N + 1];


        dp[0] = 0;
        dp[1] = 0;


        for(int i = 2; i <= N; i++){


            dp[i] = dp[i-1] +1;

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i/3] + 1 , dp[i]);
            }

            if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2] + 1 , dp[i]);
            }
        }

        System.out.println(dp[N]);

    }
}
