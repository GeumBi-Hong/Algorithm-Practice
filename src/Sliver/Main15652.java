package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//N 과 M (4)
public class Main15652 {
    static  int N,M;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //출력 수

        arr= new int[M];

        backTracking(0,1);

        System.out.print(sb);

    }

    public static void backTracking(int depth ,int start){

        if(depth==M){
            for(int n : arr){
                sb.append(n).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start ; i<=N;i++){
            arr[depth]=i;
            backTracking(depth+1,i);
        }
    }
}
