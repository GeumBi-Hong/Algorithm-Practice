package Sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10819 {
    static int N;
    static int [] num;
    static int []index;
    static boolean isVisted[];
    static int max = -1;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        index = new int[N];
        isVisted= new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i <N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }



        backTracking(0);

        System.out.println(max);



    }
    private static void backTracking(int depth){

        if(depth==N){

            int sum = 0;
            for(int i = 1; i <N;i++){
                sum+=Math.abs(num[index[i]]-num[index[i-1]]);

            }
            max = Math.max(sum, max);

            return;
        }


        for(int i = 0; i<N;i++){
            if(isVisted[i])continue;

            isVisted[i]=true;
            index[depth]=i;
            backTracking(depth+1);
            isVisted[i]=false;
        }

    }
}
