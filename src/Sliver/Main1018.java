package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1018 {

    static char[][] map  ;
     static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];


        for(int i = 0 ; i<N;i++){
            String str = br.readLine();
            for(int  j = 0 ; j<M;j++){
                map[i][j]= str.charAt(j);
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 0 ;  i <=N-8;i++){
            for(int j = 0 ; j<= M-8;j++){
                answer = Math.min(answer, Math.min(countChessPiece(i, j, 'B'), countChessPiece(i, j, 'W')));
            }
        }

        System.out.println(answer);


    }


    private static int countChessPiece(int r ,int c,char color) {
        char bw = color;
        int change = 0 ;
        for (int i = r; i <r+8; i++) {
            for (int j = c ;j <c+8; j++) {
                if(map[i][j]!=bw) {
                    change++;
                }

                if(bw=='B') bw='W';
                else bw='B';
            }
            if(bw=='B') bw='W';
            else bw='B';
        }

        return change;
    }


}
