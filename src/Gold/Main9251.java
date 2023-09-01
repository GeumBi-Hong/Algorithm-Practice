package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * LCS(Longest Common Subsequence, 최장 공통 부분 수열)
 * 부분수열이기 때문에 문자 사이를 건너뛰어 공통되면서 가장 긴 부분 문자열을 찾으면 된다.
 *
 *
 * - 문자가 틀리다 하더라고 내 옆에 (왼쪽) 칸의 최대값과 나의 윗칸 중에 최대값으로 갱신해야한다.
 * - 문자가 같으면 그 경우에는 1로 시작하고 기존에 최대값 대각선 왼쪽의 칸이 이전 값을 더해야한다.
 *
 *     B D A A B
 *   A 0 0 1 2 2
 *   B 1 1 1 2 3(이 3의 경우에 B가 B D A A 와 A에서 B 문자가 공통으로 오니까 B D A A 와 A 의 최대 LCS를 가지고 있을테니 LCS + 1 을 하는것이다.
 *
 */
public class Main9251 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] stringA = br.readLine().toCharArray();
        char[] stringB = br.readLine().toCharArray();

        int[][] dp = new int[1001][1001];

        int answer = 0;
        for(int i = 0; i < stringA.length; i++){
            for(int j = 0; j < stringB.length; j++){
                //[1]만약에 같은 문자라면
                if(stringA[i] == stringB[j]){
                    //본인 문자가 같았으니 1로시작
                    dp[i+1][j+1] = 1;
                    //그럼 이전 i , j 의 경우에 최대 LCS가 담겨있으니까 그 값을 함께 더한다.
                    dp[i+1][j+1] += dp[i][j];
                }else{
                    //만약 문자가 서로 다르다면 이전의 값의 최대값으로 갱신한다.
                    //현재가 i j 라고 하면 i-1,j 가 더 큰지 i,j-1이 더 큰지 고려하면된다.
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }

            }
        }

        System.out.println(dp[stringA.length][stringB.length]);


    }
}
