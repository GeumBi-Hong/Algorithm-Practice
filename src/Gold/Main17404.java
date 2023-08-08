package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * RGB거리 2
 * <
 * [문제설명]
 * 거리가 선분으로 있고 1~N번 집이있음
 * 집은 빨/초/파 중 하나이어여함.
 * 색마다 비용이 다름. 그리고 아래 규칙 지킨다.
 * 1. 1번집은 2번과 N번 집과 달라야함
 * 2. N번집은 N- 1번과 1번 집의 색이 달라야한다.
 * 3.i (2<=i<=n-1) 은 i-1 과 i+1과 달라야한다.빨 파 초 이렇게 가란소리ㄴ
 *
 * [문제풀이]
 * 뭔가 맨 처음에 dp가 떠올랐음
 *
 * 각 색에 대하여 완탐 한다고 했을때 연산횟수가
 * 1000 x 1000 x 1000 => 1000000000 -> 10^ 10 0.5초안에 불가
 *
 *
 * 현재 위치가 i라고 하면 i번째집에 빨/초/파 중 하나 집을 짓는다 하면 이전에 지어야할 집은 정해져있다.
 * 예를 들어 빨강을 짓는다 하면 이전에는 파 or 초 중 가능하다.
 * 이거를 맨 처음부터 최소의 경우를 구해서 왔다면 이전에  i-1이  파란색으로 지어진 최소 경우의 값과  초록색으로 지어진 최소비용 중
 * 가장 작은 값과 + 현재 그 i번째 집에 빨강으로 칠해야할 색을 dp에 저장하면된다. 그 다음집에 갈때 또 그 위치에 무슨색을 칠하냐에 따라
 * 비용을 계속 갱신해가면서 구한다.
 *
 *
 * 한가지 어려운 점은 바로 1번째와 N번째 집의 색깔이 달라야 한다는점인데.
 * 그래서 맨 처음에 집의 색을 정해놓고 시작한다.
 *
 * 그러면 0번째가 처음 집이라고 하면 빨간색을 칠하면 이때 비용 100
 * dp[0][0 빨간색] = 100;
 * dp[0][1 초록색] = 1000 * 1000 +1 (비용의 최대로 갱신 , 처음 집을 빨산색으로 칠할꺼니 초록색으로 칠하는 경우를 무시해주기 위함이다.)
 * dp[0][2 파란색] = 1000 * 1000 + 1 (비용의 최대로 갱신 , 처음 집을 빨산색으로 칠할꺼니 파란색으로 칠하는 경우를 무시해주기 위함이다.)
 *
 * 이렇게 시작하고 모두 칠했을때 dp[n][색깔] 이있으니 끝에 어떤색으로 끝났는지도 알수있다.따라서 끝 색깔과 처음 정한 색깔과 같은 경우는
 * 정답의 최소비용을 구할때 무시해주면된다.
 *
 * 이를 dp + 반복문 + 조건 을 통해서 구현을 해보았다.
 */
public class Main17404 {

    static final int MAX = 1000 * 1000 + 1;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); //집의 수

        int[][] colorCost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            colorCost[i][0] = red;
            colorCost[i][1] = green;
            colorCost[i][2] = blue;
        }

        int[][] dp = new int[N][3];


        //내가 처음에 빨강을 햇으면 빨강을 끝에 안하게끔 뭔가 처리를 해야되네
        //그럴려면 뭔가 색마다dp를 따로 두는식이아니라 dp[][] 2차원으로 두고  i j 이런걸 이용해 같은 색이냐 아니냐를 판단해줘야될거같음
        // 빨강 : 0
        // 초록 : 1
        // 파랑 : 2
        //[1] 처음 집에 무슨 색을 입힐 껀지 먼저
        // 처음색이 Red면 Red에만 수를 저장하고 나머진 MAX = 1000 * 1000 + 1
        int answer = MAX;

        for (int color = 0; color < 3; color++) {

            for (int i = 0; i < 3; i++) {
                //빨간색을 먼저 칠할꺼면 첫 집에 빨간색 값만 넣고
                //나머지 dp[0][1] (초록) dp[0][2] (파랑은) MAX로 초기화 (값이 없으니까)
                if (color == i) dp[0][i] = colorCost[0][i];
                else dp[0][i] = MAX;
            }


            for (int i = 1; i < N; i++) {

                int beforeRed = dp[i - 1][0];
                int beforeGreen = dp[i - 1][1];
                int beforeBlue = dp[i - 1][2];

                //현재 집 : 빨강 / 이전 집: 초록 or 파랑
                dp[i][0] = Math.min(beforeGreen, beforeBlue) + colorCost[i][0];


                //현재 집 : 초록 / 이전 집: 빨강 or 파랑
                dp[i][1] = Math.min(beforeRed, beforeBlue) + colorCost[i][1];

                //현재 집 : 파랑 / 이전 집 : 빨강 or 초록
                dp[i][2] = Math.min(beforeRed, beforeGreen) + colorCost[i][2];

            }
            //이제 맨 마지막집에 무슨색이냐에 따라서 맨 앞에 똑같은 색인 경우는 무시해줄꺼임
            for (int i = 0; i < 3; i++) {
                if (i != color) answer = Math.min(answer, dp[N - 1][i]);
            }

        }
        System.out.println(answer);

    }
}
