package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//키 순서  [플로이드 -와샬]
public class Main2458 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int answer=0;

        int [][] map = new int[N+1][N+1];

        while (M-->0){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b]=1;
        }


        for(int k = 1; k<=N;k++){
            for(int r = 1; r<=N;r++){
                for(int c =1; c<=N;c++){
                    if(map[r][k]==1 && map[k][c]==1){
                        map[r][c]=1;
                    }
                }
            }
        }



        for(int i =1 ; i<=N;i++){
            int up =0;
            int down=0;
            for(int j =1 ;j<=N;j++){
                if(i==j)continue;
                if(map[i][j]==1){
                    down++;
                }

                if(map[j][i]==1){
                    up++;
                }
            }

            if(up+down==N-1){
                answer++;
            }
        }

        System.out.print(answer);
    }
}
