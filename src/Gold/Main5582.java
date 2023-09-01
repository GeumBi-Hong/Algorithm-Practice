package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 *  공통 부분 문자열 = 최장 공통 문자열(Longest Common Substring)
 * LCS가 무엇이냐
 *
 * 예를들어
 *
 * ABCDEF
 * GBCDEF
 *
 * 이렇게 두 문자열이 있다고 하자.
 * 한 번에 이어진 문자열 중 부분으로 속하는 가장 긴 문자열의 길이를 출력하면 되는것이다.
 *
 * 먼저 , 완전탐색으로 진행한다해보자
 * 문자열의 최대길이는 4000이다.
 * 이걸 매번 1문자 비교 2문자 비교.......4000문자 비교 엄청 많은 연산횟수가 발생할 것이다 -> 시간초과
 * 그러면 이걸 단순화에서 연산횟수를 줄여야 한다는소리이다.
 *
 * [문제풀이]
 * - 그래서 적용할 수 있는 개념이 DP이다.
 * - G부터 ABCDEF의 문자중 같은게 있으면 1로 설정한다. 같으니까 길이는 1일테니까 말이다.
 * - 다음 알파벳인 B를 살펴보자 B와 같은게 있으니 1로 설정한다.
 * - 다음 알파벳인 C를 살펴보자 C같은 문자가 있다. 1로 설정한다. 근데 이렇게 하면 길이가 매번1이다.
 * - 그러니 현재 내가 같은 문자가 있으면 이전에도 연결되어있는 문자였다면 누적된 수가 있을 것이다. 이 경우엔 이전에 B가 같은 경우가 있으니 1이있다. 이를 더해준다.
 * - 다음 알파벳인 D를 보자 같은 문자가 있다 . 그러면 내가 이전의 문자가 같은게 몇개있었는지 셀 필요가 있을까? 없다 . 왜냐 이전에 내가 계속 누적해서 길이를 갱신시켜주고 있기 때문이다.
 * - C에서 B의 경우도 파악해서 2라는 값을 만들어 놨으니, D의 경우에서 이전문자인 C에 대해 즉 [i-1][j-1] 의 값을 누적해서 더해주면된다. 따라서 1 + 2 (C의 값) 하면 총 3이된다.
 * - 이렇게 쭉 꾸하면 연결됬다고하면 기존의 수와 더해지거나 0일테니 최대 공통 부분 길이를 구할 수 있게 된다.
 *
 *
 *    A B C D E F
 *  G 0 0 0 0 0 0
 *  B 0 1 0 0 0 0
 *  C 0 0 2(1+1) 0 0 0
 *  D 0 0 0 3(1+2) 0 0 0
 *  E
 *  F
 */
public class Main5582 {

    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] stringA = br.readLine().toCharArray();
        char[] stringB = br.readLine().toCharArray();

        int[][] dp = new int[4001][4001];

        int answer = 0;
        for(int i = 0; i < stringA.length; i++){
            for(int j = 0; j < stringB.length; j++){
                //만약에 같은 문자라면
                if(stringA[i] == stringB[j]){
                    //일단 본인부터 시작하면 길이 시작은 1이다
                    dp[i+1][j+1] = 1;
                    //그럼 이전 문자의 또 공통 부분의 문자열 길이가 누적해 있을 테니 그 값과 더하면서 계속 길이를 갱신한다.
                    dp[i+1][j+1] += dp[i][j];
                }
                answer = Math.max(answer,dp[i+1][j+1]);
            }
        }
        System.out.println(answer);
    }
}
