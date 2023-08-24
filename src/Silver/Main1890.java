package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 점프
 *
 * [문제풀이]
 * - 그냥 DFS로 하기엔 시간초과
 * - dp를 이용해서 그 칸에 경로의 수를 알면 그 값을 그대로 사용해서 경로의 수 추척
 *
 *
 * - dp [r][c] = 이 칸 까지 올 수 있는 경우의 수들.
 */
public class Main1890 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        long [][]dp = new long[n][n];


        for(int r = 0; r < n ;r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c = 0; c < n; c++){

                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;


        for(int r = 0; r < n ;r++){
            for(int c = 0; c < n; c++){
                //도착 지점에 왔으면 그만
                if(r == n-1 && c == n-1)continue;
                //오른쪽으로 간다면
                if(r + map[r][c] < n){
                    dp[r+map[r][c]][c] += dp[r][c];
                }

                //아래로 간다면

                if(c + map[r][c] < n){
                    dp[r][c+map[r][c]] += dp[r][c];
                }
            }
        }

        System.out.println(dp[n-1][n-1]);



    }
}
