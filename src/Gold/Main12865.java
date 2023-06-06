package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *
 * 왜 무게 크기마다 해야했을까
 *
 * 추측 : 그 무게마다 최대의 가치를 뽑아낼 수 있는 경우를 구해서 최대값을 누적시켜놓으면 그 물건을 썻다고 했을때 남은 무게의 최대
 * 가치만 더하면 되니 그렇게 되는거 아닐까
 *
 *
 */
public class Main12865 {
    public static void main(String[] args)  throws IOException {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품의 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게 K

        int[][] back = new int[N+1][2];

        for(int i  = 1 ; i <=N; i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            back[i][0] = weight;
            back[i][1] = value;
        }

        int[][] dp = new int[N+1][K+1];


        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= K; j++){ // j = 무게
                dp[i][j] = dp[i-1][j]; //이전꺼 가져오기

                if(j-back[i][0] >= 0){ //최대 무게  j 에서 -현재 물건 무게의 남은 무게가 있는지
                    dp[i][j] = Math.max(dp[i][j], back[i][1]+ dp[i-1][j- back[i][0]]);
                };
            }
        }

        System.out.println(dp[N][K]);

    }
}
