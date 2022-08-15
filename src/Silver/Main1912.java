package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 다이나믹 프로그래밍
 * dp[i] = i번째 인덱스 까지 왔을때  어떻게 연속으로 합을 해왔던 경우가 큰지, 큰값을 넣어줌
 * (N==1)일때는 num[1]이 가장 큰값
 * (N>1)일때는
 *   dp[i]=Math.max(dp[i-1]+num[i],num[i]);
 *   즉 이전 (i-1)까지 구했던 최대 값에 현재 수와 더한게 큰지 (dp[i-1] +num[i]->누적해서 합을 하는게 좋은지)아니면 그냥 현재값이 더 큰지(num[i])비교해서 큰값을 넣어줌.(num[i]이 더 크다면
 *   이전에 합게 왔던거는 잘라내고 num[i]부터 더하는게 더 큰 값을 가져올테니말이다.)
 *   그런후에 가장 컸던 경우를 max에(최대값저장) 갱신한다
 *
 */
public class Main1912 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int []num  = new int[N+1];
        int []dp = new int[N+1];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <=N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        dp[0]=0;

        dp[1]=num[1];

        int max = num[1];
        for(int i = 2; i<=N;i++){
            dp[i]=Math.max(dp[i-1]+num[i],num[i]);
            max= Math.max(dp[i],max);
        }

        System.out.println(max);
    }
}
