package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1913 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int []dr = {1,0,-1,0};
        int []dc = {0,1,0,-1};


        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int [][]map = new int[N][N];

        int start = N*N;


        int r= 0; int c =0;
        int d = 0;

        int targetR = 0 ;  int targetC=0;
        for(int i= start; i>=1;i--){


            if(i==target){
                targetR=r+1;
                targetC=c+1;
            }

            map[r][c]= i;

            int nr = r+ dr[d];
            int nc = c+ dc[d];
            if(!isRange(nr,nc,N)||map[nr][nc]!=0){
                d= (d+1)%4;

            }

            r= r+dr[d];
            c= c+dc[d];



        }


        for(int i = 0 ; i <N;i++){
            for(int j = 0 ; j<N;j++){
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }

        sb.append(targetR+" "+targetC);

        System.out.println(sb);

    }
    private static boolean isRange(int r,int c,int N){
        return r>=0 && r<N && c>=0 && c<N;
    }
}
