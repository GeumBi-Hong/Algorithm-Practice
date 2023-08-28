package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 호텔
 *
 * [문제풀이]
 *
 * C가 50명인데
 *
 * 50명을 딱 하는건 비용이 10인데
 * 150명을 하는게 비용이 8이다. 이런 경우가 생길 수 잇음
 *
 * 1. 최소 C명을 모을 수 있는 경우를 모두 구할거임
 * 2. 최소 만약 7이라고 하면 7 이상으로 더 작은경우가 있으므로 c + 100만큼 더 추가
 * 3. 모든 마을의 경우를 확인하면서 그 마을에서 얻을 수 있는 고객수 부터 c +100까지의 인원으로의 최소 경우를 매번갱신
 */
public class Main1106 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); //최소 C명 늘려야함
        int N = Integer.parseInt(st.nextToken()); //도시의 개수

        //적어도 C명을 늘려야함 / 각 도시에서 100명 이하로 고객을 얻을 수 있음
        //근데 꼭 C명일 필요없고 100명 얻을 수 있는데 그 비용이 더 작을 수 도 있음
        int[] dp = new int[C + 100];
        Arrays.fill(dp,Integer.MAX_VALUE); //최소 비용을 구할꺼니까 최대 비용으로 미리 갱신

        dp[0] = 0; //0명일때 비용은 0이기 때문에 0으로 초기화


        //dp[명] 모았을때 최소 비용을 구해보자

        for(int i = 0; i < N; i++){

            st = new StringTokenizer(br.readLine());

            int cost = Integer.parseInt(st.nextToken()); //비용
            int people = Integer.parseInt(st.nextToken()); //얻을 수 있는 인원 수


            for(int k = people; k < C + 100; k++){
                //돈의 정수배만큼 투자할 수 있다.
                // 현재 비용에 + dp[ k - people ] 로 j 명의 고객을 늘린다.
                if(dp[k - people] != Integer.MAX_VALUE){
                    dp[k] = Math.min(dp[k], cost + dp[k - people]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i= C; i< C+100; i++) {// 최소 c명을 확보해야 하므로 dp[c]부터 탐색
            answer = Math.min(answer, dp[i]);
        }
        System.out.println(answer);


    }
}
