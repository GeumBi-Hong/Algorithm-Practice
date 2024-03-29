package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main15650 {
    static int N;
    static int M;
    static int []answer;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

         N =  Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        answer = new int[M];

        backTracking(0,1);

        System.out.print(sb);
    }
  public static void backTracking (int depth,int start){
        if(depth==M){

           for(int n  : answer){
               sb.append(n).append(" ");
           }
           sb.append("\n");
            return;
        }



        for(int i =start; i<=N;i++){

            answer[depth]=i;
            backTracking(depth+1,i+1);
        }
  }


}
