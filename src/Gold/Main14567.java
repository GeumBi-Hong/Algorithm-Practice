package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 선수과목(Prerequisite)
 *
 * [문제풀이]
 * 1. 그래프로 연관관계를 만들고 (단방향)
 * 2. 1~N에 대한 그래프에 '0'을 추가 (패딩처리 느낌 첫 학기가 0으로 찍히기 싫어서)
 * 3. graph[i] = 에는 i 에 대한 선수과목을 저장
 * 4. 1~N까지 자신보다 선수과목인 dp[num] +1과 dp[i] 를 비교해 최대값으로 갱신
 *
 *
 * - 내 위로 가장 길게 부모가 몇개 있는지를 알아야한다.
 * - 그런데 매번 현재 노드에서 완전 탐색을 하면 오래걸릴것이다.
 * - 따라서 나의 바로 위의 부모가 몇개의 부모를 갖고 있는지에 대한 정보를 알면 거기에 +1 만 하면되니까
 * - 매번 탐색하는것이 아니라 나의 부모가 또 몇개의 부모를 가지고 있는지에 대해서 dp를 하면 된다.
 * */
public class Main14567 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N + 1];

        for(int i = 1; i <= N ; i++){
            graph[i] = new ArrayList<>();
            graph[i].add(0);
        }

        int[] dp = new int[N + 1]; // dp[i] 는 i번째 과목이 몇번째 학기에 수강 되어있는지 저장
        // dp[i] = i과목의 부모가 몇개 있는지

        while (M --> 0){
            st = new StringTokenizer(br.readLine());
            //a가 b 의 선수과목이다.
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            //b에 자신의 선수과목을 저장한다.
            graph[b].add(a);
        }

        StringBuilder sb = new StringBuilder();

        //A < B인 입력만 주어진다. (1 ≤ A < B ≤ N)
        //이 조건이 중요한게 지금 1 <= I <= N까지 1부터 가는데
        // 선수과목인 A가 B보다 작다는것이다.
        //즉 1부터 하는것이 가장 선수과목의 자신의 선수과목이 먼저 몇개있는지를 다 갱신해놨으니 2,3,4를 할때도 dp[i 보다 작은수]에 대해서 이용할 수 있다.

        for(int i = 1; i <= N; i++){
            for(int num : graph[i]){
                dp[i] = Math.max(dp[i],dp[num]+1);
            }
            sb.append(dp[i]+" ");
        }

        System.out.println(sb);
    }
}

/**
 *    1  2  3  4  5  6
 *    0  0  0  0  0  0 => 최초 첫학기는 1학기니까 1로 시작할 수 있게끔 0을 하나씩 추가
 *       1  1     2
 *                4
 *
 *
 *   dp[1] = dp[1] or dp[0] + 1 (자신의 단계 +1) 중 큰값으로 갱신 dp[1] 은 이제 1로 고정되는것이다. 더이상 이후과정에서 바뀔 이유가 없다.
 *   dp[2] = dp[2] or dp[0] + 1 중 큰 값
 *   dp[2] = dp[2] or dp[1] + 1 중 큰 값  dp[1] + 1 = 2이므로 값이 크기 때문에 dp[2] = 2로 고정 더 이상
 *
 */