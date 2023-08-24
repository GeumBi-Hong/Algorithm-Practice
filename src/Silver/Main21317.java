package Silver;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main21317 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] stone = new int[Math.max(4,N)][2];
        for(int i = 0; i < N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            stone[i][0] = Integer.parseInt(st.nextToken());
            stone[i][1] = Integer.parseInt(st.nextToken());
        }

        int K = Integer.parseInt(br.readLine());

        //4보다 작은 수면 그냥 큰 점프로 뛰어 넘을 수 있음
        int[][] dp = new int[2][Math.max(4, N+1)];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(dp[i], 100000);
        }
        dp[0][0] = 0;
        dp[1][0] = 0;

        //첫번째 돌
        dp[0][1] = 0;
        dp[1][1] = 0;

        dp[0][2] = stone[0][0];

        //1에서 두칸 움직이거나 2에서 한칸 움직이는거 중 최소
        dp[0][3] = Math.min(dp[0][2] + stone[1][0], dp[0][1]+stone[0][1]);


        for (int i = 4; i <= N; i++) {

            //3칸 이동을 하지 않았을 경우
            dp[0][i] = Math.min(dp[0][i-1] + stone[i-2][0], dp[0][i-2] + stone[i-3][1]);
            //3칸 이동을 한 경우
            dp[1][i] = Math.min(Math.min(dp[1][i-1] + stone[i-2][0], dp[1][i-2] + stone[i-3][1]),dp[0][i-3]+K);
        }
        int answer = Math.min(dp[0][N], dp[1][N]);
        System.out.println(answer);
    }
}
