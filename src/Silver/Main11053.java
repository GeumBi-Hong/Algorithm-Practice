package Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가장 긴 증가하는 부분 수열
 */
public class Main11053 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 0; i < N ;i++){
            dp[i] = 1;



            //0 부터 i이전의 값에서 (j)
            //1. 자기 자신 보다 값이 작고
            //2. i이전의(j) dp값이 j번째의 dp + 1 값보다 작은 경우가 있다면 최대길이로 갱신해준다.
            for(int j = 0 ; j < i ; j++){

                if(num[j] < num[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
        }


        //최대 길이를 찾아 정답을 출력한다.
        int answer = 0;

        for(int i = 0; i < N; i++){
            answer = Math.max(dp[i],answer);
        }

        System.out.println(answer);



    }
}
