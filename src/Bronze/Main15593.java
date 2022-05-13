package Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15593 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [][]info = new int[N][2];
        int [] time = new int[1001];


        int count = 0;
        for (int i = 0 ; i <N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            info[i][0]=start;
            info[i][1]=end;

            for(int j= start; j<end;j++){
                time[j]++;
                if(time[j]==1){
                 count++;
                }
            }
        }
        int answer = 0;


        int max =0;
      for(int []n :info){
          int start = n[0];
          int end = n[1];

          answer=count;

          for(int i = start; i<end;i++){
              if(time[i]==1){
                  answer--;
              }
          }

          if(answer>max){
              max=answer;
          }
      }
     System.out.println(max);

    }
}
