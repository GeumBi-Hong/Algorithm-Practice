package Class4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//N과 M(5) - [백트래킹]
public class Main15654 {
    static int N,M;
    static int []nums;
    static int []answer;
    static boolean [] isvisited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

         nums = new int[N];
         answer = new int[M];
         isvisited = new boolean[N];

         st = new StringTokenizer(br.readLine()," ");

         for(int i = 0 ; i<N;i++){
             nums[i]=Integer.parseInt(st.nextToken());
         }

        Arrays.sort(nums);

         backTracking(0);

         System.out.print(sb);
    }

    public static void backTracking(int depth){

        if(depth==M){
            for(int n : answer){
                sb.append(n+' ');
            }
            sb.append('\n');
            return;
        }


        for(int i = 0 ; i<nums.length;i++){

            if(!isvisited[i]) {

                isvisited[i] = true;
                answer[depth] = nums[i];
                backTracking(depth + 1);
                isvisited[i] = false;


            }
        }
    }
}
