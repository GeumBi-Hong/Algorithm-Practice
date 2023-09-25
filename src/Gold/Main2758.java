package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *로또
 *
 * [풀이]
 *
 * 로또는 1~m까지 있으며 이중에 n개를 골라야함
 * 수를 고를때 이전에 고른 수 보다 적어도 2배가 되도록 할것 , 이때 구매할 수 있는 로또의 개수를 구한다.
 *
 *
 * dp[i][j] => i번째 수를 선택할때 1~j 숫자 중에서 선택하는 경우의 수
 * dp[i - 1] [j /2 ] =>
 *
 * X번째 수를 고를 때 1부터 Y까지의 숫자 중에서 선택하는 경우의 수는 X번째 수를 고를 때 1부터 Y-1까지의 숫자 중에서 선택하는 경우와 X번째 수를 Y로 선택하는 경우 2가지로 나뉜다.
 * X번째 수를 고를 때 1부터 Y-1까지의 숫자 중에서 선택하는 경우는 dp [X][Y-1]이고,
 * X번째 수를 Y로 선택하는 경우는 dp [X-1][Y/2]이다
 */
public class Main2758 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); //테스트 케이스 수


        while(T --> 0){ //테스트 케이스 수 만큼

            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = Integer.parseInt(st.nextToken()); //몇개숫자 선택
            int max = Integer.parseInt(st.nextToken()); // 최대 수

            long [][] dp = new long[count + 1][max + 1];//[몇번째 수를 골랐을때 ,


            //처음 0 번째는 1로 갱신
            for (int i = 0; i <= max; i++) {
                dp[0][i] = 1L;
            }

            for(int i = 1; i <= count; i++){
                for(int j = 1;  j <= max; j++){
                    dp[i][j] = dp[i-1][j/2] + dp[i][j - 1];
                }
            }

            sb.append(dp[count][max]+"\n");

        }

        System.out.println(sb);

    }
}
