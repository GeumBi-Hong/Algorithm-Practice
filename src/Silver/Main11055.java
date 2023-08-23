package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 가장 큰 증가하는 부분 수열(152ms)
 *
 *
 * [문제풀이]
 *  A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8}
 *
 *  가 있으면 for(i) 에서는 원소 하나씩에 대해서 가장 긴 값을 갱신하는 거면
 *  for(j)로 이전에 값들중에  i번째보다 작은 애가 있으면 그 애가 가지고 있는 가장 큰 값을 가져와서 비교하기만 하면된다.
 *
 */
public class Main11055 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            dp[i] = num[i];
        }

        //0으로 초기화 했었는데 N이 1일 경우에 answer 가 0이되므로 초기값을 dp[0]으로 줘야함
        int answer = dp[0];

        for(int i = 0; i < N ;i++){
            for(int j = 0 ; j < i ; j++){

                //현재 위치의 값보다 작은 경우
                if(num[j] < num[i]){
                    //이미 다이나믹 프로그래밍으로 가장 큰 증가하는 수를 가지고 있으니 그 값을 가져와서 이용
                    dp[i] = Math.max(dp[j] + num[i],dp[i]);
                    //최대값 갱신
                    answer = Math.max(answer,dp[i]);

                }
            }
        }

        System.out.println(answer);

    }
}
