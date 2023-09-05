package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 선수과목( (Prerequisite)
 *
 * [문제풀이]
 * 1. 그래프로 연관관계를 만들고
 * 2. 부모부터 1로 선언
 * 3. 내려갈수록 부모의 값 + 1로 자식을 갱신
 */
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

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= N; i++){
            for(int num : graph[i]){
                dp[i] = Math.max(dp[i],dp[num]+1);
            }
            sb.append(dp[i]+" ");
        }

        System.out.println(sb);
    }
}
