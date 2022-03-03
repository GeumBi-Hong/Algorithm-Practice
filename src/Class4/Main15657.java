package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;
//N과 M (8)  (백트레킹)
public class Main15657{
    static int [] array ;
    static int []answer;
    static int M,N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)  throws IOException {


        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

         N =  Integer.parseInt(st.nextToken());
         M =  Integer.parseInt(st.nextToken());

         array = new int[N];
         answer = new int[M];


        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);//오름차순으로 정렬
        backTrack(0,0);

        System.out.print(sb);
    }

    public static void backTrack(int start ,int depth){

        if (depth == M){
            for (int n : answer){
                sb.append(n+" ");
            }
           sb.append("\n");
            return;
        }

        for(int i = start ; i<N;i++){
            answer[depth] = array[i]; 
            backTrack(i,depth+1);
        }
        
    }
}
