package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//정수 삼각형 (다이나믹 프로그래밍)
public class Main1932 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //삼각형 크기
        int [][]dp =new int[N][N];

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int c = st.countTokens();
            for(int j = 0; j<c;j++){
                dp[i][j]= Integer.parseInt(st.nextToken());

            }
        }

        for (int i = N-2; i >=0 ;i--){
            for(int j = 0 ; j< i+1;j++){
              dp[i][j]=dp[i][j]+Math.max(dp[i+1][j],dp[i+1][j+1]);

          }
        }

       System.out.print(dp[0][0]);

    }
}
