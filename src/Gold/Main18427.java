package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 함께 블록 쌓기
 *
 * - 학생마다 최대 M개의 블록을 가질 수 있음. 한명의 학생이 가지고 있는 블록의 높이는 서로 다르다.
 * - 1~N번까지의 학생들이 가진 블록을 차례로 사용하여 탑을 만듬
 *
 * - 큰 문제 : 학생의 블록중 하나 또는 안써서 목표 높이 H를 만드는 경우의 수
 * - 작은 문제 : 어느 한 학생의 경우를 구하고 그걸 이용해서 다음학생의 블록을 쓴다고 했을때 경우 구하기?
 */
public class Main18427 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

       // int[][] block = new int[N][M]; M의 범위가 학생마다 다르니 리스트로 변경

        List<Integer>[] block = new ArrayList[N + 1];
        final int mod = 10007;


        for(int i = 1; i <= N; i++){
            block[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
               block[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        long[][] dp = new long[N + 1][H + 1];

        for(int i=0; i <= N; i++){
            dp[i][0]=1;
        }

        for(int i = 1 ; i <= N ; i++){ //학생 수 만큼 반복
           for(int h = 1 ; h <= H ; h++){
               //학생이 가진 블록 만큼
               for(Integer blockNum  :  block[i]){
                   if(h >= blockNum){//지금 블록을 쓸 경우
                       dp[i][h] = (dp[i][h] + dp[i-1][h-blockNum]) % mod;
                   }
                   //내가 가진 블록 보다 큰 경우는 자신도 쓰는 경우가 있으니 그 경우를 판
               }
               dp[i][h] += dp[i-1][h]; //지금 블록을 안쓰는 경우
               dp[i][h] %=10007;
           }

        }
            System.out.println(dp[N][H]);

    }
}
