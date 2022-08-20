package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10163 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [][]map = new int[1001][1001];

        int [] square = new int[N+1];


        //순서대로 색 종이 올려놓기
       for(int  n =1; n <=N;n++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());


            for(int i=r; i<r+width;i++){
                for(int j = c; j<c+height;j++){
                    map[i][j]= n;
                }
            }
        }

       for(int r = 0 ; r <1001;r++){
           for(int c = 0 ; c <1001; c++){
               if(map[r][c]==0)continue;
               square[map[r][c]]++;
           }
       }

       StringBuilder sb = new StringBuilder();
       for(int i = 1; i<=N;i++){
           sb.append(square[i]).append("\n");
       }
       System.out.println(sb);
    }
}
