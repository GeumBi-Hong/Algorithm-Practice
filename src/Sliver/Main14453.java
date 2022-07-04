package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main14453 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        String str = "PHS";

        int [][] prefix = new int[3][N+1];
        for(int i = 1 ; i <= N; i++){
            String s = br.readLine(); //문자 받아오기

            for(int j = 0 ; j< 3;j++){
                prefix[j][i]= prefix[j][i-1];
                if(s.charAt(0)==str.charAt(j)){
                    prefix[j][i]=prefix[j][i-1]+1;
                }

            }
        }

 /* 누적합 배열 확인
        for(int i = 0 ; i < 3; i++){

            for(int j =0; j<=N;j++){
                System.out.print(prefix[i][j]+" ");
            }
            System.out.println();

        }

  */

        int answer = -1;
        for(int i = 0 ; i <3 ;i++){
            for(int j = 0 ; j <3; j++){

                for(int k = 1; k <=N;k++){
                    answer= Math.max(answer,(prefix[i][N]-prefix[i][k])+prefix[j][k]);
                }
            }
        }
        System.out.println(answer);

    }

}
