package Sliver;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {
    public static void main(String[] args)  throws IOException {

        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //2차원 배열 크기
        int M = Integer.parseInt(st.nextToken());// 합을 구해야 하는 횟수



        int [][]nums = new int[N+1][N+1];
        int [][] sum = new int[N+1][N+1];

        for(int r = 1; r <= N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 1 ; c <= N; c++){
                int n = Integer.parseInt(st.nextToken());

                nums[r][c]=n;
                sum[r][c]= sum[r-1][c]+sum[r][c-1] -sum[r-1][c-1]+n; //누적합
            }
        }
     /*구간합 잘 되었는지 확인
        for(int r = 0 ; r<=N;r++){
            for(int c =0 ;c<=N;c++){
                System.out.print(sum[r][c]+" ");
            }
            System.out.println();
        }

      */

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <M;i++){
            st = new StringTokenizer(br.readLine());

            int startR = Integer.parseInt(st.nextToken());
            int startC = Integer.parseInt(st.nextToken());
            int endR = Integer.parseInt(st.nextToken());
            int endC = Integer.parseInt(st.nextToken());


            int answer = sum[endR][endC]- (sum[endR][startC-1]+sum[startR-1][endC])+sum[startR-1][startC-1];

            sb.append(answer).append("\n");
        }
        System.out.println(sb);

    }
}
