package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15651 {
    static int N,M;
    static int num [];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine()," ");


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num=new int[M];



        backTracking(0,1);
        System.out.println(sb);

    }
    private  static  void backTracking(int depth ,int start){
        if(depth ==M){
            for(int i = 0 ; i<M;i++){
                sb.append(num[i]+" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start ; i<=N;i++){
            num[depth]=i;
            backTracking(depth+1,start);
        }
    }
}
