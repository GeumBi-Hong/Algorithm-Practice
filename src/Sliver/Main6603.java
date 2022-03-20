package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6603 {

    static int [] lotto;
    static int k ;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            k = Integer.parseInt(st.nextToken());

            if( k == 0){ //  0 exit
                break;
            }
             lotto = new int[k];
             visited = new boolean[k];

            for(int i = 0 ; i <k ;i++){
                lotto[i]=Integer.parseInt(st.nextToken());
            }

           dfs(0,0);
            sb.append("\n");

        }
            System.out.print(sb);
    }


    public static void dfs(int depth,int start){
        if(depth==6){

            for(int i=0;i<k;i++){
                if(visited[i]){
                   sb.append(lotto[i]+" ");
                }
            }
            sb.append("\n");
        }
        for(int i=start;i<k;i++){
            visited[i]=true;
            dfs(depth+1,i+1);
            visited[i]=false;
        }
    }
}

