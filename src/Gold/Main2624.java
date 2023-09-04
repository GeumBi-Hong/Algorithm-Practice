package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 동전 바꿔주기
 *
 * [문제풀이]
 * - 동전 n가지에 대해서 하나씩 다 만들면서 경우의 수를 누적
 *
 */
public class Main2624 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int T = Integer.parseInt(br.readLine()); // 만들어야하는 금액
        int N = Integer.parseInt(br.readLine()); // 총 동전의 개수

        int[][] coin = new int[N][2]; // 동전 정보

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());

            coin[i][0] = Integer.parseInt(st.nextToken()); //동전 금액
            coin[i][1] = Integer.parseInt(st.nextToken()); //동전 개수
        }

        //dp[j]= 현재 금액이 j일 때 동전으로 교환하는 방법의 가지 수

        int[] dp = new int[T + 1];

        dp[0] = 1;

        for(int i = 0; i < N; i++){ //동전 종류 만큼 반복 //최대 100

            int amount = coin[i][0]; //ex )5원짜리
            int count = coin[i][1]; // ex ) 3개

            for(int j = T; j >= amount; j--){ //20원 부터 5원까지

                //해당 동전으로 개수로
                for(int k = 1; k <= count; k++){ // a 금액의 동전 개수만큼 반복

                    if(j - amount * k < 0){ //j (금액) - 에서 동전 금액 * 동전개수
                        break;
                    }
                    dp[j] =  dp[j] + dp[j - amount * k];
                }
            }

        }

        System.out.println(dp[T]);
    }
}
