package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 주지수
 *
 * [문제풀이]
 *
 * 사각형으로 된 구간의 합을 구하는 문제
 *
 * - 만약이걸 완탐으로 한다면?
 * - 테스트 케이스 k 가 최대 10만개라고 가정하고 NxM을 최대로 매번 탐색을 해야한다면? 당연히 시간 초과
 * - 그러면 매번 2차원 배열을 탐색하는것이 아니라 한번에 값을 접근해야된는 식으로 해야됨
 * - 이 방법이 이제 기존의 값을 계속 누적해서 더해서 해당 칸까지 1,1 해서 i,j까지 합을 구하는것
 *
 * 9 14
 * 1 31
 *
 * 있다면  9 -> 14 로 23 (가로)  d[i][j-1]
 *        9 -> 1 로 10(세로)    d[i-1][j]
 *
 * 이런식으로 계속 누적해서 더해주는데 문제는 9가 한번 더해져야하는데 두번 더해지니까 dp[i-1][j-1]은 빼줘야함
 *
 *  따라서 점화식은 num + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]
 *
 */
public class Main15724 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 1;  i <= N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                int num = Integer.parseInt(st.nextToken());
                //dp[i][j] 는 dp[1][1]부터 dp[i][j] 까지의 총 합이다.
                dp[i][j] = num + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }


        //테스트 케이스 시작
        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++){

            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());


            // dp[r2][c2] = 1,1 에서 r2,c2까지 누적합 값
            // r1 -1 c2 는 포함 안되는 가로 부분 빼기
            // r2 - c1-1 은 포함 안되는 세로부분 빼기
            // dp[r1-1][c1-1]은 위에 두번 뺏을때 공통부분을 두번뺏기때문에 한번은 다시 더해줘야함
            int answer = dp[r2][c2] - dp[r1-1][c2] - dp[r2][c1-1] + dp[r1-1][c1-1];

            sb.append(answer).append("\n");

        }

        System.out.println(sb);


    }
}
