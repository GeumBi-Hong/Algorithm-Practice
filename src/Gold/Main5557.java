package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 1학년
 *
 * [문제풀이]
 * 중간의 수는 음수면 안되고 0부터 20이하의 수여야한다.
 *
 * - 큰 문제 : N-1개를 + , - 해가면서 N을 만드는 경우 결국엔 num[N]까지 만드는 개수
 * - 작은 문제 : num[i]의 수를 +,- 하면서 만들어지는 수의 개수만드는 개수를 구하면서 num[N]구하기
 * i 0 1 2 3 4 5 6 7 8 9
 *   8 3 2 4 8 7 2 4 0 8  = 8
 *
 *   i = 0 8은 1가지 dp[0][8] = 1
 *   i = 0 8에서 3(i =1)을  빼거나 더했을 때의 경우 dp[1][11] += dp[0][8] / dp[1][5] += dp[0][8]
 */
public class Main5557 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());


        int[] num = new int[N-1];
        st = new StringTokenizer(br.readLine());
        //N-1개만 입력
        for(int i = 0 ; i < N - 1 ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }



        int lastestNum = Integer.parseInt(st.nextToken()); //마지막 숫자

        long[][] dp = new long[N][21];

        dp[0][num[0]] = 1; //첫 번째 숫자의 경우는 1

        //i 는 몇번째 숫자에 대해서 하고 있는지
        for(int i = 1; i < N - 1; i++){
            for(int j = 0; j <= 20; j++){ //0부터 20까지의 수가 올 수 있으니

                if(dp[i-1][j] != 0){ //이전 단계에서 경우의 수가 있을 때만

                    int plus = j + num[i]; //현재 수 + 현재 위치의 수를 더하는 경우
                    int minus = j - num[i]; //현재 수  - 현재 위치의 수를 뺴는 경우

                    if(plus >= 0 && plus <= 20){ //더한 경우가 0~20 사이의 수일때만 기존 경우의 수와 합침
                        dp[i][plus] += dp[i-1][j];
                    }

                    if(minus >= 0 && minus <= 20){ //뺀 경우가 0~20사이의 수일때만 기존 경우의 수와 합침
                        dp[i][minus] += dp[i-1][j];
                    }

                }
            }

        }

        System.out.println(dp[N-2][lastestNum]);
    }
}
